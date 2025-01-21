package org.example;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDao {
    private EntityManager entityManager;

    public EventoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
public void save(Evento evento){
    EntityTransaction transaction = entityManager.getTransaction();
    try{
        transaction.begin();
        entityManager.persist(evento);
        transaction.commit();
    }catch (Exception e){
        if(transaction.isActive()){
            transaction.rollback();
        }
        throw e;
    }
}
public Evento getById(Long id){
      return entityManager.find(Evento.class, id);
    }
public void delete(Long id){
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Evento evento = entityManager.find(Evento.class, id);
            if(evento != null){
                entityManager.remove(evento);
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
}
}
