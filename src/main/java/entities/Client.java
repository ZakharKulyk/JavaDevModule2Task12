package entities;

import jakarta.persistence.*;
import lombok.Data;



@Table(name = "clients")
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

    @Column
    String name;

}
