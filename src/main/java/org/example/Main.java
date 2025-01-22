package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventi");
        EntityManager em = emf.createEntityManager();


        EventoDao eventoDao = new EventoDao(em);

        List<Evento> eventi = Arrays.asList(
                new Evento(
                        "Romics 2025",
                        LocalDate.of(2025, 4, 15),
                        "Fiera del fumetto di Roma",
                        Evento.TipoEvento.pubblico,
                        5000
                ),
                new Evento(
                        "Concerto Coldplay",
                        LocalDate.of(2026, 6, 22),
                        "Concerto dei Coldplay allo stadio olimpico di Roma",
                        Evento.TipoEvento.pubblico,
                        70000
                ),
                new Evento(
                        "Party aziendale",
                        LocalDate.of(2025, 2, 15),
                        "Festa per il pensionamento del capo",
                        Evento.TipoEvento.privato,
                        80
                ),
                new Evento(
                        "Compleanno nonna",
                        LocalDate.of(2025, 12, 15),
                        "98esimo compleanno di nonna Piergilda",
                        Evento.TipoEvento.privato,
                        5
                ), new Evento(
                        "24a giornata di Serie A",
                        LocalDate.of(2025, 3, 1),
                        "Lazio vs Monza",
                        Evento.TipoEvento.pubblico,
                        65000
                ), new Evento(
                        "Rave party",
                        LocalDate.of(2025, 1, 30),
                        "Rave party di Torbella",
                        Evento.TipoEvento.privato,
                        80
                ), new Evento(
                        "Concerto di Michael Jackson",
                        LocalDate.of(2027, 2, 2),
                        "Paradiso",
                        Evento.TipoEvento.pubblico,
                        1
                )
        );




      //  eventoDao.delete(nuovoEvento.getId());
      //  System.out.println("Evento eliminato!");

        for (Evento evento : eventi) {
            if (eventoDao.existsByTitolo(evento.getTitolo())) {
                System.out.println("Evento già presente nel database: " + evento.getTitolo());
            } else {
                eventoDao.save(evento);
                System.out.println("Evento salvato con successo: " + evento.getTitolo());

                // Recupera l'evento appena salvato per conferma
                Evento eventoRecuperato = eventoDao.getById(evento.getId());
                System.out.println("Evento recuperato: " + eventoRecuperato.getTitolo());
            }
        }

        em.close();
        emf.close();
}}
