package DtoService;

import dbservice.ConnectDb;
import entities.Planet;
import entities.Planets;
import entities.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketDto {

    public Ticket getTicketById(int id) {
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();

        return session.get(Ticket.class, 1);

    }


    public void deleteTicketById(int id) {

        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Ticket ticketById = getTicketById(id);
            if(ticketById==null){
                throw new NoSuchTicketFound("There is no such Ticket");
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

    public void updateTicket(Ticket newTicket, int id){
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Ticket ticketById = getTicketById(id);
            if(ticketById ==null){
                throw new NoSuchTicketFound("there is no such ticket");
            }
            ticketById.setClientId(newTicket.getClientId());
            ticketById.setCreatedAt(newTicket.getCreatedAt());
            ticketById.setToPlanet(newTicket.getToPlanet());
            ticketById.setFromPlanet(newTicket.getFromPlanet());

            session.persist(ticketById);

            transaction.commit();

        }catch (Exception ex){
            System.out.println("Failed to update ticket");
            transaction.rollback();
        }finally {
            session.close();
        }
    }


    public List<Ticket> getAllTickets() {
        return ConnectDb.getInstance()
                .getSessionFactory()
                .openSession()
                .createQuery("from Ticket ", Ticket.class).list();
    }
}
