package dawa.model.bussinesLogic;

import dawa.model.VOs.Registered;
import dawa.model.dao.api.IDAOUsers;

/**
 * Created by cout970 on 2017/04/11.
 */
public class AccountManager {

    private IDAOUsers daoUsers;

    public AccountManager(IDAOUsers daoUsers) {
        this.daoUsers = daoUsers;
    }

    public Registered tryLogin(String email, String pass) {
        Registered user = daoUsers.getUser(email);
        if (user == null) {
            return null;
        }

        String hash = daoUsers.getHashPass(email);
        if (hash == null) {
            return null;
        }

        return CryptUtils.checkPassword(pass, hash) ? user : null;
    }

    public Registered trySignUp(Registered reg, String pass) {
        Registered user = daoUsers.getUser(reg.getEmail());
        if (user != null) {
            return null;
        }

        try {
            daoUsers.insertUser(reg);
            String hash = CryptUtils.encrypt(pass);
            daoUsers.insertHash(reg.getEmail(), hash);

            return daoUsers.getUser(reg.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
