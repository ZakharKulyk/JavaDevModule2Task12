package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client clientId;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", referencedColumnName = "id")
    Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", referencedColumnName = "id")
    Planet toPlanet;

}
