package pl.doman.Regatta;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.doman.Boat.Sailboat;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Data
@NoArgsConstructor
public class RegattaResult {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private OneRunResultAllSailboats oneRunResultAllSailboats;
    private Duration time; //TODO

}
