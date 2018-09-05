package com.amazonaws.lambda.clients;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;	
import org.mockito.runners.MockitoJUnitRunner;

import com.amazonaws.services.lambda.runtime.Context;

@RunWith(MockitoJUnitRunner.class)
public class AddClientHandlerTest {

    private static Client client;

    @InjectMocks
    private AddClientHandler handler = new AddClientHandler();
    
    @Mock
    private Connection connection;
    
    @Mock
    private SessionFactory sessionFactory;
    
    @Mock
    private Session session;
    
    @Mock
    private Transaction transaction;
    
    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        client = new Client();
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testLambdaFunctionHandler() {    	
    	when(connection.getSessionFactory()).thenReturn(sessionFactory);
    	when(sessionFactory.openSession()).thenReturn(session);
    	when(session.beginTransaction()).thenReturn(transaction);
    	when(session.getTransaction()).thenReturn(transaction);
    	
        Context ctx = createContext();
        String output = handler.handleRequest(client, ctx);
        
        verify(session).save(client);
        Assert.assertEquals("Hello from Lambda!", output);
    }
}
