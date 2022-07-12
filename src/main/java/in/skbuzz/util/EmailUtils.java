package in.skbuzz.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailUtils {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail(String to , String subject ,String body){
        boolean isSent= false;
        try{
            MimeMessage mimeMailMessage=mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body , true);
            mailSender.send(mimeMailMessage);
            isSent=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSent;
    }

}
