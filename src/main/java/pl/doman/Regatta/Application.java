package pl.doman.Regatta;

import pl.doman.Boat.CRUD_Competitor.SailBoatDAO;
import pl.doman.Boat.Sailboat;

public class Application {
    public static void main ( String[] args ) {

        SailBoatDAO sailBoatDAO = new SailBoatDAO ();

        Sailboat jacht1 = new Sailboat (  );
        jacht1.setName ( "Zadra" );
        jacht1.setSailNr ( "POL_101" );
        jacht1.setJachtClass ( "Laser" );
        /*jacht1.setCrew (  );*/   //TODO should get parametrs for crew from Crew class

       sailBoatDAO.create ( jacht1 );


    }
}
