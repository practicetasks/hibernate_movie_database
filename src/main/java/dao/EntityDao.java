package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class EntityDao<T> implements AutoCloseable {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

    protected EntityManager manager;

    protected EntityDao() {
        manager = factory.createEntityManager();
    }

    public abstract T getById(int id);

    public abstract List<T> getAll();

    public void update(T entity) {
        try {
            manager.getTransaction().begin();
            manager.merge(entity);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        }
    }

    public void insert(T entity) {
        try {
            manager.getTransaction().begin();
            manager.persist(entity);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        }
    }

    public void delete(T entity) {
        try {
            manager.getTransaction().begin();
            manager.remove(entity);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        }
    }

    @Override
    public void close() throws Exception {
        if (manager.isOpen()) {
            manager.close();
        }
    }
}
