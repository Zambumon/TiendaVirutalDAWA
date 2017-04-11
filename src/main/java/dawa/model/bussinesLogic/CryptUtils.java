package dawa.model.bussinesLogic;


import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class CryptUtils {

    private static final int iterations = 64;
    private static final int keyLength = 512;

    private CryptUtils() {}

    public static boolean checkPassword(String password, String storedHash) {
        Base64.Decoder dc = Base64.getDecoder();

        String[] parts = storedHash.split("\\$");
        byte[] encrypted = dc.decode(parts[0]);
        byte[] seed = dc.decode(parts[1]);
        byte[] newHash = hashPassword(password.toCharArray(), seed);

        return slowEquals(newHash, encrypted);
    }

    public static String encrypt(String password) {
        Base64.Encoder dc = Base64.getEncoder();

        byte[] salt = new byte[64];
        SecureRandom rand = new SecureRandom();
        rand.nextBytes(salt);
        byte[] hash = hashPassword(password.toCharArray(), salt);

        return dc.encodeToString(hash) + "$" + dc.encodeToString(salt);
    }

    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;

        for (int i = 0; i < a.length && i < b.length; ++i) {
            diff |= a[i] ^ b[i];
        }

        return diff == 0;
    }

    private static byte[] hashPassword(char[] password, byte[] salt) {
        try {
            SecretKeyFactory e = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKey key = e.generateSecret(spec);
            return key.getEncoded();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException var5) {
            throw new RuntimeException(var5);
        }
    }
}
