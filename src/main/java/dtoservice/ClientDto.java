package dtoservice;

import dbservice.ConnectDb;
import entities.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDto {

    public Client getClientById(int id) {
        try (Session session = ConnectDb.getInstance().getSessionFactory().openSession()) {
            Client client = session.get(Client.class, id);
            if (client == null) {
                throw new NoSuchClientFound("no such user");
            }
            return client;
        } catch (Exception ex) {
            System.out.println("FAILED to get client");
            return null;
        }

    }

    public void createClient(Client client) {
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.persist(client);

            transaction.commit();
        } catch (Exception exception) {
            System.out.println("Client wasn't created");
            transaction.rollback();
        } finally {
            session.close();
        }

    }

    public void updateClient(Client newClient, int clientId) {
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, clientId);
            if (client == null) {
                throw new NoSuchClientFound("No such client fount. Impossible to update");
            }
            client.setName(newClient.getName());

            transaction.commit();

        } catch (Exception ex) {
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    public void delete(int id) {
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);

            if (client == null) {
                throw new NoSuchClientFound("no such user to be deleted");
            }

            session.remove(client);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    public List<Client>getAllClient(){
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        return  session.createQuery("from Client ", Client.class).list();
    }


}
