import Bean.Earrings;
import Hibernate.ConnectionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class main {

/*
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = ConnectionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Earrings earrings = new Earrings();

        earrings.setTitle("fff");
        earrings.setStyle("fff");
        earrings.setDesigner("fff");
        earrings.setStone("fff");
        earrings.setMetal("fff");
        earrings.setPrice(120);

        session.save(earrings);
        session.getTransaction().commit();

        session.close();

    }
*/


    public static void main(String[] args) {
        System.out.println("Criteria");

        Session session = ConnectionFactory.getSessionFactory().openSession();

        List<Earrings> earrings = null;

        try {

            session.beginTransaction();

            Criteria criteria = session.createCriteria(Earrings.class);

            criteria.list();



            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        session.close();


        for (Earrings earring: earrings) {
            System.out.println(earring.toString());
        }

    }




}
