import dbservice.InitDbService;
import dtoservice.ClientDto;
import dtoservice.PlanetDto;
import entities.Client;


public class Demo {
    public static void main(String[] args) {
        InitDbService initDbService = new InitDbService();
        initDbService.initdb();

        ClientDto clientDto = new ClientDto();
        PlanetDto planetDto = new PlanetDto();


    }
}
