package org.example;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Eventi")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String titolo;

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento", nullable = false)
    private TipoEvento tipoEvento;

    @Column(name = "numero_max_partecipenti", nullable = false)
    private Integer numeroMassimoPartecipanti;

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }


    public enum TipoEvento {
        PUBBLICO("pubblico"), PRIVATO("privato");

        private final String tipo;

        TipoEvento(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }

        @Override
        public String toString() {
            return tipo;  // Assicurati che restituisca il valore in minuscolo
        }
    }

}

