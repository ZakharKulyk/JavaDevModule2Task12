package entitity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "planets")
public class Planet {


    @Enumerated(EnumType.STRING)
    @Id
    private Planets id;

    @Column
    private String name;

}
