package email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;


@SpringBootTest(classes = Application.class)
public class SendTest {
    @Resource
    JavaMailSender javaMailSender;

    /**
     *  发送简单邮件
     */
//    @Test
    public void sendSimpleMail() {
        // 构建一个邮件对
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封测试邮件");
        // 设置邮件发送者，与配置文件中的邮箱保持一致
        message.setFrom("ooahz@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("123@qq.com","999qq.com");
        message.setTo("ooahz@outlook.com");
        // 设置邮件抄送人，可以有多个抄送人
//        message.setCc("123@qq.com");
        // 设置隐秘抄送人，可以有多个
//        message.setBcc("999@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("这是一封测试邮件");
        // 发送邮件
        javaMailSender.send(message);
    }
}
