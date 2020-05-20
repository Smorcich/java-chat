package model;

import model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeveloperRunner {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        DeveloperRunner developerRunner = new DeveloperRunner();

        System.out.println("Adding developer's records to the DB");
        /**
         *  Adding developer's records to the database (DB)
         */
        developerRunner.addDeveloper("QWE");
        developerRunner.addDeveloper("GDF");
        developerRunner.addDeveloper("Peter");

        System.out.println("List of developers");
        /**
         * List developers
         */
        List<Developer> developers = developerRunner.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }
        System.out.println("===================================");
        System.out.println("Removing Some Developer and updating Proselyte");
        /**
         * Update and Remove developers
         */
        developerRunner.updateDeveloper(10);
        developerRunner.removeDeveloper(11);

        System.out.println("Final list of developers");
        /**
         * List developers
         */
        developers = developerRunner.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }
        System.out.println("===================================");

    }

    public void addDeveloper(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Developer developer = new Developer(0, name);
        session.save(developer);
        transaction.commit();
        session.close();
    }

    public List<Developer> listDevelopers() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Developer> developers = session.createQuery("FROM Developer").list();

        transaction.commit();
        session.close();
        return developers;
    }

    public void updateDeveloper(int developerId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, developerId);
        session.update(developer);
        transaction.commit();
        session.close();
    }

    public void removeDeveloper(int developerId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, developerId);
        session.delete(developer);
        transaction.commit();
        session.close();
    }

}