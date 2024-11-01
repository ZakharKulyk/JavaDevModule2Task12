import crudservice.TicketCrudService;
import dbconfig.InitDbService;
import crudservice.ClientCrudService;
import crudservice.PlanetCrudService;
import entitity.Client;
import entitity.Planet;
import entitity.Planets;
import entitity.Ticket;

import java.time.LocalDateTime;


public class Demo {
    public static void main(String[] args) {
        InitDbService initDbService = new InitDbService();
        initDbService.initdb();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

        Ticket ticket = new Ticket();

       ticketCrudService.createTicket(ticket);


    }
}
