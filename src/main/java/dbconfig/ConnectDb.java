package dbconfig;

import entities.Client;
import entities.Planet;
import entities.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectDb {
   private  SessionFactory sessionFactory;
   private static ConnectDb INSTANCE;

    static {
        INSTANCE = new ConnectDb();
    }

    private ConnectDb(){
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public  void close(){
        sessionFactory.close();
    }

    public  SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public  static ConnectDb  getInstance(){
        return INSTANCE;
    }


}


