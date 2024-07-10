package controller;

import classes.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestoreLibro<T extends Libro>{

    private static ArrayList<Libro> listaLibriCompleta = new ArrayList<>();
    private static ArrayList<Studente> listaStudenti = new ArrayList<>();
    private static ArrayList<Prenotazione> listaPrenotazioni = new ArrayList<>();

    public static void setListaLibriCompleta(ArrayList<Libro> libri){
        listaLibriCompleta.addAll(libri);
    }

    public static ArrayList<Libro> getListaLibriCompleta() {
        return listaLibriCompleta;
    }
    public static void setListaStudenti(ArrayList<Studente> studenti){
        listaStudenti.addAll(studenti);
    }
    public static ArrayList<Studente> getListaStudenti(){
        return listaStudenti;
    }
    public static void setListaPrenotazioni(ArrayList<Prenotazione> prenotazioni){
        listaPrenotazioni.addAll(prenotazioni);
    }
    public static ArrayList<Prenotazione> getListaPrenotazioni(){
        return listaPrenotazioni;
    }


    public <T extends Libro> void leggiLibri(String sezione, String genereLibro){
        String[] libri = sezione.split("\n");
        for (String libro: libri) {
            try{
                String[] args = libro.split(",");
                String titolo = args[0];
                String autore = args[1];
                int punteggio = Integer.parseInt(args[2]);
                String dettaglio = args[3];
                switch(genereLibro){
                    case "Cultura":
                        try{
                            listaLibriCompleta.add(new Cultura(titolo, autore, punteggio, dettaglio));
                        } catch (Exception ignored){}
                        break;
                    case "Sport":
                        try{
                            listaLibriCompleta.add(new Sport(titolo, autore, punteggio, dettaglio));
                        } catch (Exception ignored){}
                        break;
                    case "Avventura":
                        try{
                            listaLibriCompleta.add(new Avventura(titolo, autore, punteggio, dettaglio));
                        } catch (Exception ignored){}
                        break;
                }

            } catch (ArrayIndexOutOfBoundsException e){};
        }
    }

    public static ArrayList<Studente> leggiStudenti(String sezione){
        ArrayList<Studente> result = new ArrayList<>();
        String[] studenti = sezione.split("\n");
        for (String studente: studenti){
            try {
                String[] args = studente.split(",");
                String cognome = args[0];
                String classe = args[1];
                result.add(new Studente(cognome, classe));
            } catch (ArrayIndexOutOfBoundsException e){

            }
        }
        return result;
    }
    public static ArrayList<Prenotazione> leggiPrenotazioni(String sezione){
        ArrayList<Prenotazione> result = new ArrayList<>();
        String[] listaPrenotazione = sezione.split("\n");
        for(String prenotazione: listaPrenotazione){
            try{
                String[] args = prenotazione.split(",");
                Libro libro = trovaLibro(args[0], listaLibriCompleta);
                Studente studente = trovaStudente(args[1], listaStudenti);
                LocalDate dataPrestito = LocalDate.parse(args[2]);
                LocalDate dataConsegna = LocalDate.parse(args[3]);
                result.add(new Prenotazione(libro, studente, dataPrestito, dataConsegna));

            }catch(ArrayIndexOutOfBoundsException e){

            }
        } return result;
    }

    private static Libro trovaLibro(String titolo, ArrayList<Libro> listaLibriCompleta){
        for(Libro libro: listaLibriCompleta){
            if(titolo.equals(libro.getTitolo())){
                return libro;
            }
        } return null;
    }

    private static Studente trovaStudente(String cognome, ArrayList<Studente> listaStudenti){
        for(Studente studente: listaStudenti){
            if(cognome.equals(studente.getCognome())){
                return studente;
            }
        } return null;
    }


}
