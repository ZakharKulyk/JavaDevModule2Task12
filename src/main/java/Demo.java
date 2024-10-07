import DtoService.ClientDto;
import DtoService.PlanetDto;
import dbservice.InitDbService;
import entities.Client;

import java.util.List;


public class Demo {
    public static void main(String[] args) {
        InitDbService initDbService = new InitDbService();
        initDbService.initdb();

        ClientDto clientDto = new ClientDto();
        PlanetDto planetDto = new PlanetDto();


    }
}
