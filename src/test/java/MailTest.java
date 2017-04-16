import dawa.model.bussinesLogic.MailSender;
import org.junit.Test;

import javax.mail.MessagingException;

/**
 * Created by pedro on 16/04/17.
 */
public class MailTest {

    private static String MAIL = "tiendavirtualv4@gmail.com";

    @Test
    public void doTest(){

        MailSender m = MailSender.getInstance();


        try {
            m.sendMail(MAIL, "Hola", "buenosDias");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
