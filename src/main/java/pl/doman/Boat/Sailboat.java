package pl.doman.Boat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Sailboat {
    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private String SailNr;
    private String JachtClass;

    private Crew crew;

    public Sailboat ( Long id, String sailNr, Crew crew, String name, String jachtClass ) {
        this.id = id;
        Name = name;
        SailNr = sailNr;
        JachtClass = jachtClass; //TODO POLE POWINNO POCHODZIĆ Z ENCJI JachtClass
        this.crew = crew;
    }

    @Override
    public String toString () {
        return "Jacht{" +
                "id="+ id +
                ", Name='" + Name + '\'' +
                ", Nr żagla='" + SailNr + '\'' +
                ", Klasa='" + JachtClass + '\'' +
                ", Załoga=" + crew +
                '}';
    }

}
