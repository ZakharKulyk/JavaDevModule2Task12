package dbservice;

import org.flywaydb.core.Flyway;

public class InitDbService {
    String URL = "jdbc:h2:~/test";
    String USER = "sa";
    String PASSWORD ="";

    public  void initdb(){
        Flyway.configure()
                .dataSource(URL, USER, PASSWORD)
                .load()
                .migrate();
    }
}
