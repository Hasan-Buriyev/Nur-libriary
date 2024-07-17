package com.oss.nur.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Email {
    private static final String username = "hasanburiyev0@gmail.com";
    private static final String password = "djze dcsx itlp ytea";

    //              email send message to ->

    public static void sendEmail(String email, String name, String link) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            email(email, name, link);
        });
    }

    private static void email(String email, String name, String link) {
        try {
            Properties properties = getProperties();
            Session session = getSession(properties);
            Message message = new MimeMessage(session);
            String str = getHTML(name, link);
            message.setSubject("NUR");
            message.setContent(str, "text/html");
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println("Error sending email");
        }
    }

    private static Session getSession(Properties properties) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        return properties;
    }

    private static String getHTML(String name, String link) {
        return head+ """
                  <body>
                      <div class="container">
                          <div class="cl1" style="color: black; background-color: #e9ecef; text-align: center; border-bottom: 1px solid #ddd;">
                              <h3>Dear %s</h3>
                                 </div>
                                 <div class="cl2" style="background-color: gray; text-align: center;">
                                     <a href="%s" style="color: blue;">activation</a>
                                 </div>
                                 <div class="cl3" style="color: white;background-color: rgb(7,24,64); line-height: 1.6;">
                                     <h4>You cannot use the site until your account is activated.
                                                 To activate your account, click the <span>activation</span> button</h4>
                                 </div>
                             </div>
                         </body>
                """.formatted(name,link);
    }

    private static final String head = """
            <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Document</title>
                  <style>
                      body {
                          font-family: Arial, sans-serif;
                          background-color: #f4f4f9;
                          margin: 0;
                          padding: 0;
                          display: flex;
                          justify-content: center;
                          align-items: center;
                          height: 100vh;
                      }
                      .container {
                          background-color: #fff;
                          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                          border-radius: 10px;
                          overflow: hidden;
                          max-width: 600px;
                          width: 100%;
                      }
                      a {
                          text-decoration: none;
                          font-weight: bold;
                          padding: 10px 20px;
                          border-radius: 5px;
                          background-color: #e9ecef;
                      }
                      a:hover {
                          background-color: #d8d8d8;
                      }
                      h3, h4 {
                          margin: 0;
                      }
                      .cl1, .cl2, .cl3 {
                          padding: 20px;
                      }
                  </style>
              </head>
            """;


}
