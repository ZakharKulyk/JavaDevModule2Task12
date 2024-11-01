package crudservice;

import dbconfig.ConnectDb;
import dbconfig.InitDbService;
import entitity.Planet;
import entitity.Planets;
import entitity.Ticket;
import exception.NoSuchPlanetFound;
import exception.NoSuchTicketFound;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {

    public Ticket getTicketById(int id) {

        try (Session session = ConnectDb.getInstance().getSessionFactory().openSession()) {

            Ticket ticket = session.get(Ticket.class, id);

            if (ticket == null) {
                throw new NoSuchTicketFound("There is no such ticket");
            }

            return ticket;

        } catch (Exception e) {
            System.out.println("Failed to find Ticket");
            return null;
        }
    }

    public void updateTicket(Ticket ticket, int ticketId) {
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Ticket oldTicket = session.get(Ticket.class, ticketId);
            if (oldTicket == null) {
                throw new NoSuchTicketFound("no such ticket to update");
            }
            oldTicket.setClientId(ticket.getClientId());
            oldTicket.setCreatedAt(ticket.getCreatedAt());
            oldTicket.setToPlanet(ticket.getToPlanet());
            oldTicket.setFromPlanet(ticket.getFromPlanet());

            transaction.commit();
        } catch (Exception ex) {
            System.out.println("No ticket to update");
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void createTicket(Ticket ticket) {
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.persist(ticket);

            transaction.commit();
        } catch (Exception exception) {
            System.out.println("Ticket wasn't created");
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public  void deleteById(int id){
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Ticket ticketById = getTicketById(id);
            if(ticketById==null){
                throw new NoSuchTicketFound("no such ticket found");
            }

            session.remove(ticketById);

            transaction.commit();

        }catch (Exception ex){
            System.out.println("Failed to delete");
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    public List<Ticket> getAllTickets() {
        return ConnectDb.getInstance().getSessionFactory().openSession().createQuery("from Ticket ", Ticket.class).list();
    }
}
