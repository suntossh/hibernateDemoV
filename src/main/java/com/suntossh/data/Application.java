package com.suntossh.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.suntossh.data.entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		User user = new User();
		//Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'BIRTH_DATE' cannot be null
		//Exception in thread "main" org.hibernate.PropertyValueException: not-null property references a null or transient value : com.suntossh.data.entities.User.birthDate
	
			user.setBirthDate(null);
			user.setCity("Jersey City");
			user.setCreatedBy("Santoshkumar");
			user.setCreatedDate(new Date());
			user.setEmailAddress("Suntossh.numerouno@gmail.com");
			user.setFirstName("Santosh");
			user.setLastName("Pandey");
			user.setLastUpdatedBy("Santosh");
			user.setLastUpdatedDate(new Date());
			user.setState("NJ");
			user.setUserAddressLine1("400 Vanilla Avnue");
			user.setUserAddressLine2("Grove St 6th Street");
			user.setZipCode("07306");
		
		session.save(user);	
		
		
		session.getTransaction().commit();

		System.out.println("######1"+user.getUserId());
		
		session.beginTransaction();
		System.out.println("######2"+user.getUserId());
		User user2 = (User) session.get(User.class, user.getUserId());
			user2.setFirstName("Santos");
			user2.setCreatedBy("Santos");
			System.out.println("######3"+user2.getUserId());
		session.update(user2);
		session.getTransaction().commit();
			
			
		session.close();
	}

/*	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();


		Transaction transaction = session.beginTransaction();

		User user = new User();
			user.setBirthDate(new Date());
			user.setCity("Jersey City");
			user.setCreatedBy("Santoshkumar");
			user.setCreatedDate(new Date());
			user.setEmailAddress("Suntossh.numerouno@gmail.com");
			user.setFirstName("Santosh");
			user.setLastName("Pandey");
			user.setLastUpdatedBy("Santosh");
			user.setLastUpdatedDate(new Date());
			user.setState("NJ");
			user.setUserAddressLine1("400 Vanilla Avnue");
			user.setUserAddressLine2("Grove St 6th Street");
			user.setZipCode("07306");
		
		session.save(user);	
		
		transaction.commit();
			
		session.close();
	}*/

}
