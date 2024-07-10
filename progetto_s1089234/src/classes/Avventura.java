package classes;

public class Avventura extends Libro{
    private final String CATEGORIA = "Avventura";
    private String ambientazione;
    public Avventura(String titolo, String autore, int punteggio, String ambientazione){
        super(titolo, autore,  punteggio);
        setCategoria(CATEGORIA);
        this.ambientazione = ambientazione;
    }
}
