import dbconfig.InitDbService;
import crudservice.ClientCrudService;
import crudservice.PlanetCrudService;


public class Demo {
    public static void main(String[] args) {
        InitDbService initDbService = new InitDbService();
        initDbService.initdb();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();


    }
}
