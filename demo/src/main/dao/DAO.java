package dao;

import javax.persistence.*;

public class DAO {
    static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("dac");
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
    
}