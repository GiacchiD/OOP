package classes;

public class Cultura extends Libro{
    private final String CATEGORIA = "Cultura";
    private String argomento;
    public Cultura (String titolo, String autore, int punteggio, String argomento){
        super(titolo, autore, punteggio);
        setCategoria(CATEGORIA);
        this.argomento = argomento;
    }
}
