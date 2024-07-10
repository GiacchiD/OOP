package classes;

import java.time.LocalDate;


public class Prenotazione {
    private Libro libro;
    private Studente studente;
    private LocalDate dataConsegna;
    private LocalDate dataScadenza;
    public Prenotazione(Libro libro, Studente studente, LocalDate dataConsegna, LocalDate dataScadenza){
        this.libro = libro;
        this.studente = studente;
        this.dataConsegna = dataConsegna;
        this.dataScadenza = dataScadenza;
    }

    public Libro getLibro() {
        return libro;
    }


    public Studente getStudente() {
        return studente;
    }

    public LocalDate getDataConsegna() {
        return dataConsegna;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }
}
