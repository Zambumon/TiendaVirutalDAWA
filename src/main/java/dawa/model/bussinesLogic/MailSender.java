package dawa.model.bussinesLogic;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


/**
 * Created by pedro on 8/04/17.
 */
public class MailSender {

    private static final String SENDER_DIRECTION = "tiendavirtualv4@gmail.com";
    private static final String SERVER_PASS = "rootroot";
    private static final String SERVER_HOST = "smtp.gmail.com";
    private static final String SHOP_NAME = "Tokyo CD Store";

    private static MailSender instance = null;

    protected MailSender() {}

    public static MailSender getInstance() {
        if (instance == null) {
            instance = new MailSender();
        }
        return instance;
    }

    public void sendMail(String receptor, String subject, String messageContent) throws MessagingException {

        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SERVER_HOST);
        props.put("mail.smtp.user", SENDER_DIRECTION);
        props.put("mail.smtp.password", SERVER_PASS);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(SENDER_DIRECTION, SHOP_NAME));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));


            message.setSubject(subject);
            message.setContent(messageContent, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(SERVER_HOST, SENDER_DIRECTION, SERVER_PASS);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}