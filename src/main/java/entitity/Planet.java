package entitity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "planets")
@Data

public class Planet {


    @Enumerated(EnumType.STRING)
    @Id
    private Planets id;

    @Column
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    Set<Ticket> planetSetFrom;

    @ToString.Exclude
    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Ticket> planetSetTo;


}
