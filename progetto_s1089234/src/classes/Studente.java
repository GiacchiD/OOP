package classes;

import java.util.ArrayList;

public class Studente {
    private String cognome;
    private String classe;
    private int punteggioTotale = 0;
    private ArrayList<Libro> libriInPrestito;

    public Studente(String cognome, String classe){
        this.cognome = cognome;
        this.classe = classe;
        this.libriInPrestito = new ArrayList<>();
    }


    public String getCognome() {
        return cognome;
    }

    public void addLibro(Libro libro) {
        libriInPrestito.add(libro);
    }

    public ArrayList<Libro> getLibriInPrestito() {
        return libriInPrestito;
    }

    public int getPunteggioTotale() {
        return punteggioTotale;
    }

    public void setPunteggioTotale(int punteggioTotale) {
        this.punteggioTotale = punteggioTotale;
    }
}
