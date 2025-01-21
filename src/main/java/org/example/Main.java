package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventi");
        EntityManager em = emf.createEntityManager();


        EventoDao eventoDao = new EventoDao(em);


        Evento nuovoEvento = new Evento(
                "Concerto Rock",
                LocalDate.of(2025, 2, 15),
                "Un fantastico concerto di musica rock!",
                Evento.TipoEvento.PUBBLICO,
                500
        );


        eventoDao.save(nuovoEvento);
        System.out.println("Evento salvato con successo!");


        Evento eventoRecuperato = eventoDao.getById(nuovoEvento.getId());
        System.out.println("Evento recuperato: " + eventoRecuperato.getTitolo());


        eventoDao.delete(nuovoEvento.getId());
        System.out.println("Evento eliminato!");

        em.close();
        emf.close();
    }
}
