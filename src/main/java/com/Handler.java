/*package com;

import com.domain.Client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Client, String> {

    @Override
    public String handleRequest(Client client, Context context) {
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }

        return String.format("Added %s %s.", client.getId(), client.getName());
    }
}*/

