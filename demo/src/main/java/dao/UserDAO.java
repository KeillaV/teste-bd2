package dao;

import java.util.List;
import javax.persistence.*;

import entities.IdUser;
import entities.User;

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

    public void delete(IdUser idUser) throws PersistenciaException {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
        	// Esse processo de encontrar o usuário e remover deve estar dentro da mesma transação!
        	User user = entityManager.find(User.class, idUser);
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

    public User getByPK(IdUser pk) throws PersistenciaException {
        EntityManager entityManager = getEntityManager();
        User usuarioEncontrado = null;
        try {
            usuarioEncontrado = entityManager.find(User.class, pk);
        } catch (PersistenceException e1) {
            e1.printStackTrace();
            throw new PersistenciaException("Ocorreu um erro na hora de encontrar o usuário!", e1);
        } finally {
            entityManager.close();
        }
        
        return usuarioEncontrado;
    }
    
    public List<User> getAll() throws PersistenciaException {
    	EntityManager entityManager = getEntityManager();
    	List<User> usuarios = null; 
    	
    	try {
    		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
    		usuarios = query.getResultList();
    		
    	} catch (PersistenceException e1) {
            e1.printStackTrace();
            throw new PersistenciaException("Ocorreu um erro na hora de encontrar os usuários!", e1);
        } finally {
            entityManager.close();
        }
    	
    	return usuarios;
    }
}
