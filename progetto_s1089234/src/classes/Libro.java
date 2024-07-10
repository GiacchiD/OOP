package classes;

public abstract class Libro {
    private String titolo;
    private String autore;
    private String categoria;
    private int punteggio;
    public Libro(String titolo, String autore, int punteggio){
        this.titolo = titolo;
        this.autore = autore;
        this.punteggio = punteggio;
    };

    public String getTitolo() {
        return titolo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getPunteggio() {
        return punteggio;
    }
}
