package pl.doman.Boat;

import com.sun.istack.Nullable;
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
@Setter
public class Crew<Skipper, name1, name2> {

    @Id
    @GeneratedValue
    private String Skipper;
    @Nullable
    private String crew1;
    @Nullable
    private String crew2;

    public Crew ( String skipper, String crew1, String crew2 ) {
        this.Skipper = skipper;
        this.crew1 = crew1;
        this.crew2 = crew2; }

    @Override
    public String toString () {
        return "\nZałoga:{" +
                "Skipper'" + Skipper + '\'' +
                ", crew'" + crew1 + '\'' +
                ",'" + crew2 + '\'' +
                '}';
    }
}
