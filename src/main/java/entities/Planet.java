package entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "planets")
public class Planet {



    @Enumerated(EnumType.STRING)
    @Id
    Planets id;

    @Column
    String name;

}
