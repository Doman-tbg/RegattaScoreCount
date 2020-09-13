package pl.doman.Regatta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.doman.Boat.Sailboat;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleJachtRunResult implements Comparable <SingleJachtRunResult> {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Sailboat sailboat;
    private Duration time;//TODO


    @Override
    public int compareTo ( SingleJachtRunResult result ) {
        return time.compareTo ( result.getTime ( ) );
    }
}