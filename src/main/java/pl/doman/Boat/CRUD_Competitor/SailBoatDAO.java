package pl.doman.Boat.CRUD_Competitor;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.doman.Boat.Sailboat;

public class SailBoatDAO {

    public void create( Sailboat sailboat) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(sailboat);
            session.getTransaction().commit();

            /*sailboat.setName (sailboat.getName ());
            sailboat.setSailNr (sailboat.getSailNr ());
            sailboat.setJachtClass (sailboat.getJachtClass ());   //TODO klasa jachtu powinna być zapisana w encji
            sailboat.setCrew ( sailboat.getCrew () );*/

        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }

    public Sailboat read(long id) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        try {
            Sailboat sailboat = session.get(Sailboat.class, id);
            return sailboat;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }

    public static void update(long id, Sailboat newSailBoat) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Sailboat sailboat = session.find (Sailboat.class, id);

            sailboat.setName (newSailBoat.getName ());
            sailboat.setSailNr (newSailBoat.getSailNr ());
            sailboat.setJachtClass (newSailBoat.getJachtClass ());   //TODO klasa jachtu powinna być zapisana w encji
            sailboat.setCrew ( newSailBoat.getCrew () );

            session.getTransaction().commit();

        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }

    public static void delete(long id) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {

            Sailboat sailboat = session.find(Sailboat.class, id);
            session.delete(sailboat);

            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }
}

