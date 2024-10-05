import DtoService.ClientDto;
import DtoService.PlanetDto;
import DtoService.TicketDto;
import dbservice.ConnectDb;
import dbservice.InitDbService;
import entities.Client;
import entities.Planet;
import entities.Planets;


public class Demo {
    public static void main(String[] args) {
        InitDbService initDbService = new InitDbService();
        initDbService.initdb();

        Planet planet = new Planet();
        planet.setId(Planets.UPD);
        planet.setName("Updated PLANET");

        ClientDto clientDto = new ClientDto();
        PlanetDto planetDto = new PlanetDto();
        TicketDto ticketDto = new TicketDto();

        System.out.println(ticketDto.getAllTickets());



    }
}
