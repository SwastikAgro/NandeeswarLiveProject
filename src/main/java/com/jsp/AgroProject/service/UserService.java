package com.jsp.AgroProject.service;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.jsp.AgroProject.dao.UserDao;
import com.jsp.AgroProject.entity.User;
import com.jsp.AgroProject.exception.EmailAlreadyExistsException;
import com.jsp.AgroProject.exception.EmailNotFoundException;
import com.jsp.AgroProject.exception.PasswordWrongException;
import com.jsp.AgroProject.exception.UserNotFoundException;
import com.jsp.AgroProject.exception.UserPwdMissMatch;
import com.jsp.AgroProject.util.ResponseStructure;

import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	@Autowired
	private JavaMailSender mailSender;
	

	
	public void sendSimpleMail(String email,String sub, String msg) throws MessagingException {
		
		MimeMessage mailMessage=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mailMessage, true);
		
		helper.setFrom("swastikagro86@gmail.com");
		helper.setTo(email);
		helper.setText(msg);
		helper.setSubject(sub);
		mailSender.send(mailMessage);
		
	}
	

//	register
	public ResponseEntity<ResponseStructure<User>> register(User user) throws MessagingException  {
		User u= dao.fetchByEmail(user.getEmail());
		MimeMessage mailMessage=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mailMessage, true);
		helper.setFrom("swastikagro86@gmail.com");
		
		
		ResponseStructure<User> m= new ResponseStructure<User>();
		m.setData(dao.saveUser(user));
		m.setMessage("user Registered successfully");
		m.setStatus(HttpStatus.CREATED.value());
		
		String email=user.getEmail();
		String subject="Registration Confirmation for "+user.getFirstName()+" "+user.getLastName()+" in Agricultural Website ";
		String msg=("\r\n"
				+ "Dear user "+user.getFirstName()+" "+user.getLastName()+",\r\n"
				+ "\r\n"
				+ "We are pleased to confirm your successful registration on our agricultural website! \r\n"
				+ "\r\n"
				+ "Thank you for choosing to join our community dedicated to fostering knowledge, innovation, and collaboration in the agricultural sector. With your registration, you've taken the first step toward accessing valuable resources, networking opportunities, and the latest insights in agriculture.\r\n"
				+ "\r\n"
				+ "Your commitment to staying informed and engaged in the agricultural community is commendable, and we look forward to your active participation on our platform. Whether you're a seasoned professional, a passionate hobbyist, or a curious newcomer, there's something here for everyone.\r\n"
				+ "\r\n"
				+ "As a registered member, you'll gain access to a wealth of features, including:\r\n"
				+ "\r\n"
				+ "1. Expert articles and research papers covering various agricultural topics.\r\n"
				+ "2. Forums and discussion boards for exchanging ideas and seeking advice.\r\n"
				+ "3. Upcoming events, workshops, and webinars relevant to the agricultural industry.\r\n"
				+ "4. Tools and resources to enhance your farming practices and maximize yields.\r\n"
				+ "5. Networking opportunities with fellow enthusiasts, experts, and industry leaders.\r\n"
				+ "\r\n"
				+ "We encourage you to explore our website thoroughly and take advantage of all the resources available to you. Your contributions and insights will enrich our community and help us collectively advance the field of agriculture.\r\n"
				+ "\r\n"
				+ "Once again, welcome aboard! If you have any questions or need assistance navigating our website, please don't hesitate to reach out to our support team at [Support Email Address].\r\n"
				+ "\r\n"
				+ "Happy farming!\r\n"
				+ "\r\n"
				+ "Best regards,\r\n"
				+ "\r\n"
				+ "Nandeeswar Reddy Polu \r\n"
				+ "CEO \r\n"
				+ " SwastikAgro ");
		FileSystemResource file = new FileSystemResource(new File("C:\\Users\\Nandeeswar Reddy\\Pictures\\Camera Roll\\veggies.jpg"));
		
		helper.addAttachment(file.getFilename(), file);
		helper.setTo(email);
		helper.setText(msg);
		helper.setSubject(subject);
		if(email!=null) {
			
				mailSender.send(mailMessage);
			
		}else {
				throw new EmailAlreadyExistsException("User already exist with the email Id "+user.getEmail());
			
		}
		return new ResponseEntity<ResponseStructure<User>>(m, HttpStatus.CREATED);
		
	}


//	saveUser
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {

		ResponseStructure<User> m= new ResponseStructure<User>();	
		m.setData(dao.saveUser(user));
		m.setMessage("user saved successfully");
		m.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<User>> (m, HttpStatus.ACCEPTED);
	}
//	fetchUser
	public ResponseEntity<ResponseStructure<User>> fetchUser(int id) {
		ResponseStructure<User>m= new ResponseStructure<User>();
		
		m.setData(dao.fetchUser(id));
		m.setMessage(" user fetched successfully");
		m.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<User>> (m, HttpStatus.FOUND);
	}
//	deleteUser
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		 User db = dao.deleteUser(id);
		if(db!=null) {
			ResponseStructure<User> m=new ResponseStructure<User>();
			m.setData(db);
			m.setMessage("user deleted successfully ");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>> (m, HttpStatus.FOUND);
			
		}else {
			 throw new UserNotFoundException("no user found by this  id"+id);
		}
	}
//	fetchAll
	public List<User> fetchAll() {

		return dao.fetchAll();
	}
//	updateUser
	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		User db = dao.fetchUser(user.getId());
		if(db!=null) {
			ResponseStructure<User>m=new ResponseStructure<User>();
			m.setData(dao.updateUser(user));
			m.setMessage("user updated successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(m,HttpStatus.FOUND);
		}else {
			throw new UserNotFoundException("no user found"+user.getId());
		}
		 
	}
//	loginUser
	public ResponseEntity<ResponseStructure<User>> loginUser(String email, String pwd) {
		 String dbemail = dao.fetchByEmail(email, pwd);
		 String dbpwd = dao.fetchByEmail(email, pwd);

		if(dbemail == email && dbpwd== pwd) {
				ResponseStructure<User> st=new ResponseStructure<User>();
				st.setMessage("user login successfully ");
				st.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<User>>(st, HttpStatus.FOUND);
		}else if(dbemail== null){
			throw new EmailNotFoundException();
		}
		else {
		throw new UserPwdMissMatch();
		}


	
	}

//  sendOtp
	public ResponseEntity<ResponseStructure<Integer>> sendOtp(String email) throws MessagingException {
		boolean db=dao.sendOtp(email);
		if(db == true) {
			Random random = new Random();
			int value = random.nextInt(999999);
			String email1 = email;
			String emailtext = "YOUR ONE TIME PASSWORD IS \n \n "+"("+value+")";
			String sub="Swastik Agro OTP ";
			sendSimpleMail(email1,sub,emailtext);
			ResponseStructure<Integer> m = new ResponseStructure<Integer>();
			m.setData(value);
			m.setMessage("OTP Sent Successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Integer>>(m, HttpStatus.FOUND);
		}else {
			throw new EmailNotFoundException();
		}
	}
}