package entitity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Table(name = "clients")
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;


    @ToString.Exclude
    @OneToMany(mappedBy = "clientId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket>tickets;

}
