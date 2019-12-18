package Dao;

import Bean.Earrings;
import Hibernate.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EarringsDaoImpl implements EarringsDao {


    private static EarringsDaoImpl earringsDaoImpl = null;

    private SessionFactory sessionFactory = ConnectionFactory.getSessionFactory();

    public List<Earrings> getAllEarrings(){
/*
        List<Earrings> earrings = new ArrayList<>();
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from Earrings earrings");
        earrings = query.list();
        return earrings;
*/
        Session session = this.sessionFactory.openSession();
        List<Earrings> earringsList = session.createCriteria(Earrings.class).list();
        session.close();

        return earringsList;
    }

    public void saveEarrings (Earrings earrings) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(earrings);
        transaction.commit();
        session.close();

        System.out.println("inserted new");

    }

    public void updateEarrings(Earrings earrings) {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(earrings);
        transaction.commit();
        session.close();

        System.out.println("Updated");
    }

    public void deleteEarrings(Earrings earrings){
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(earrings);
        transaction.commit();
        session.close();

        System.out.println("Deleted");
    }

    public Earrings getEarringsById (int id) {
/*
        String query = "from Earrings earrings where earrings.id =" + id;
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Query query1 = session.createQuery(query);
        Earrings earrings = (Earrings) query1.list().get(0);
        return earrings; */

        Session session = this.sessionFactory.openSession();
        Earrings earrings = session.get(Earrings.class, id);
        session.close();

        return earrings;
        }

    public static EarringsDao getInstance() {
        if(earringsDaoImpl == null)
            earringsDaoImpl = new EarringsDaoImpl();

        return earringsDaoImpl;
    }

}
