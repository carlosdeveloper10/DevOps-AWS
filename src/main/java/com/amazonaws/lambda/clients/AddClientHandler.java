package com.amazonaws.lambda.clients;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AddClientHandler implements RequestHandler<Object, String> {

	@Inject
	Connection connection;
	
    @Override
    public String handleRequest(Object client, Context context) {      
        SessionFactory sessionFactory = connection.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
        return "Hello from Lambda!";
    }

}
