package com.yizhao.SendingEmail;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * https://www.tutorialspoint.com/servlets/servlets-sending-email.htm
 * http://stackoverflow.com/questions/8612437/unable-to-send-e-mail-through-java
 * Browser:
 * http://localhost:8080/SendEmail
 */
public class SendEmail extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Recipient's email ID needs to be mentioned.
        String to = "yi.zhao@adara.com";

        // Sender's email ID needs to be mentioned
        String from = "yi.zhao@adara.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();
//        properties.setProperty("mail.user", "yi.zhao@adara.com");
//        properties.setProperty("mail.password", "n2eb3afam7");
        // Setup mail server
        // properties.setProperty("mail.smtp.host", host);


        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        Authenticator auth = new SMTPAuthenticator("yi.zhao@adara.com", "n2eb3afam7");

        // Get the default Session object.
        Session session = Session.getInstance(properties,auth);

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        MimeMessage message = null;
        try{
            // Create a default MimeMessage object.
            message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("This is the Subject Line!");
            // Now set the actual message
            message.setText("This is actual message");
            // Send message
            Transport.send(message);
            String title = "Send Email";
            String res = "Sent message successfully....";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<p align=\"center\">" + res + "</p>\n" +
                    "</body></html>");

        } catch (AddressException e){

        }catch (javax.mail.MessagingException e){
            e.printStackTrace();
        }
    }

    private class SMTPAuthenticator extends Authenticator
    {
        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password)
        {
            authentication = new PasswordAuthentication(login, password);
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
            return authentication;
        }
    }
}