package dao;

import java.util.List;
import javax.persistence.*;
import javax.xml.registry.infomodel.User;

public class UserDAO extends DAO {
    public void save(User user) throws PersistenciaException {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(user);
            transaction.commit();
        } catch (PersistenceException e1) {
            e1.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }

            throw new PersistenciaException("Ocorreu um erro na hora de salvar o usuário!", e1);
        } finally {
            entityManager.close();
        }
    }

    public void update(User user) throws PersistenciaException {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(user);
            transaction.commit();
        } catch (PersistenceException e1) {
            e1.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }

            throw new PersistenciaException("Ocorreu um erro na hora de atualizar os dados do usuário!", e1);
        } finally {
            entityManager.close();
        }
    }

    public void delete(User user) throws PersistenciaException {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(user);
            transaction.commit();
        } catch (PersistenceException e1) {
            e1.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }

            throw new PersistenciaException("Ocorreu um erro na hora de deletar o usuário!", e1);
        } finally {
            entityManager.close();
        }
    } 

    public User getById(Integer id) throws PersistenciaException {
        EntityManager entityManager = getEntityManager();
        User usuarioEncontrado = null;
        try {
            usuarioEncontrado = entityManager.find(User.class, id);
        } catch (PersistenceException e1) {
            e1.printStackTrace();
            throw new PersistenciaException("Ocorreu um erro na hora de encontrar o usuário!", e1);
        } finally {
            entityManager.close();
        }

        return usuarioEncontrado;
    }
}
