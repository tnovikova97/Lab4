package Dao;

import Bean.Earrings;
import Hibernate.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

public interface EarringsDao {

    /*
    public List<Earrings> getAllEarrings(){

        List<Earrings> earrings = new ArrayList<>();

        Session session = ConnectionFactory.getSessionFactory().openSession();

        Query query = session.createQuery("from Earrings earrings");
        earrings = query.list();

        return earrings;
    }

    public void saveEarrings (Earrings earrings) {

        Session session = ConnectionFactory.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.save(earrings);
        transaction.commit();

        System.out.println("inserted new");
    }

    public void updateEarrings(Earrings earrings) {

        Session session = ConnectionFactory.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.update(earrings);
        transaction.commit();

        System.out.println("Updated");
    }

    public void deleteEarrings(Earrings earrings){

        Session session = ConnectionFactory.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.delete(earrings);
        transaction.commit();

        System.out.println("Deleted");
    }

    public Earrings getEarringsById (int id) {

        String query = "from Earrings earrings where earrings.id =" + id;

        Session session = ConnectionFactory.getSessionFactory().openSession();

        Query query1 = session.createQuery(query);

        Earrings earrings = (Earrings) query1.list().get(0);

        return earrings;
    }

     */

    void saveEarrings(Earrings earrings);

    void updateEarrings(Earrings earrings);

    void deleteEarrings(Earrings earrings);

    Earrings getEarringsById(int id);

    List<Earrings> getAllEarrings();

}
