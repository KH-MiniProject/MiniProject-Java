package com.pizza.mail;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.pizza.model.vo.PizzaMenu;


public class Test {
	public static void main(String[] args) {
		Test test = new Test();
        test.gmailSend();
    }
    
    
    public void gmailSend() {
    	String user = "id@gmail.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
        String password = "password";   // 패스워드

        String to = "id@gmail.com";

        // SMTP 서버 정보를 설정한다.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true"); 
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try (ObjectInputStream ois = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream("pizza.txt")));) { 
        	
        	MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject("피자 주문 내역");
            
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setText("내용을 입력하세요");
            
            MimeBodyPart mbp2 = new MimeBodyPart();
            FileDataSource  fds = new FileDataSource("pizza.txt"); //파일 읽어오기
            
            mbp2.setDataHandler(new DataHandler(fds)); //파일 첨부
            mbp2.setFileName(fds.getName());
            
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            mp.addBodyPart(mbp2);
            
            message.setContent(mp);
            
            // send the message
            Transport.send(message); ////전송
            System.out.println("message sent successfully...");
        } catch (MessagingException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    public void pizzaorder() {
    	try (ObjectInputStream ois = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream("pizza.txt")));) {
			
    		PizzaMenu arr[] = (PizzaMenu[]) ois.readObject();
			
			for(PizzaMenu pizzas : arr) {
				System.out.println(pizzas);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    
}

