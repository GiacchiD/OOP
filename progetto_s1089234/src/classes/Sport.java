package classes;

public class Sport extends Libro{

    private final String CATEGORIA = "Sport";
    private String disciplina;
    public Sport (String titolo, String autore, int punteggio, String disciplina){
        super(titolo, autore, punteggio);
        setCategoria(CATEGORIA);
        this.disciplina = disciplina;
    }
}
