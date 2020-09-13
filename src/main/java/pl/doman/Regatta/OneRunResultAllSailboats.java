package pl.doman.Regatta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.doman.Boat.Sailboat;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class OneRunResultAllSailboats {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SingleJachtRunResult> regattaResults;

    public OneRunResultAllSailboats ( Long id, List<SingleJachtRunResult> regattaResults ) {
        this.id = id;
        this.regattaResults = regattaResults;    }

    public Sailboat getWinner() throws NoWinnerException {
        return regattaResults.stream()
                .sorted()
                .findFirst()
                .map( SingleJachtRunResult::getSailboat )
                .orElseThrow(NoWinnerException::new);           }

                public OneRunResultAllSailboats oneRunResultAllSailboats_withId(Long id) {
        return new OneRunResultAllSailboats ( id, regattaResults );
                }
}
