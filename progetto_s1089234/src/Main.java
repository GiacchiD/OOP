import classes.Libro;
import classes.Prenotazione;
import classes.Studente;
import controller.GestoreLibro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static GestoreLibro gestore = new GestoreLibro();

    private static void init(){
        try{
            Scanner fileInput = new Scanner(new FileInputStream("traccia_B.txt"));
            fileInput.useDelimiter("###");
            String[] sezioni = new String[5];
            int i = 0;
            while(fileInput.hasNext()) {
                sezioni[i] = fileInput.next();
                i++;
            }
            gestore.leggiLibri(sezioni[0], "Cultura");
            gestore.leggiLibri(sezioni[1], "Sport");
            gestore.leggiLibri(sezioni[2], "Avventura");
            gestore.setListaStudenti(gestore.leggiStudenti(sezioni[3]));
            gestore.setListaPrenotazioni(gestore.leggiPrenotazioni(sezioni[4]));


        } catch (FileNotFoundException e){
            System.out.println("File non trovato");
        }
    }

    public static void task1(){
        ArrayList<Libro> libriCultura = new ArrayList<>();
        ArrayList<Libro> libriSport = new ArrayList<>();
        ArrayList<Libro> libriAvventura = new ArrayList<>();

        ArrayList<Studente> studentiCultura = new ArrayList<>();
        ArrayList<Studente> studentiSport = new ArrayList<>();
        ArrayList<Studente> studentiAvventura = new ArrayList<>();

        for (Libro l: gestore.getListaLibriCompleta()){
            switch (l.getCategoria()){
                case "Cultura":
                    libriCultura.add(l);
                    break;
                case "Sport":
                    libriSport.add(l);
                    break;
                case "Avventura":
                    libriAvventura.add(l);
                    break;
            }
        }

        for (Libro l : gestore.getListaLibriCompleta()){
            for (Prenotazione p: gestore.getListaPrenotazioni()){
                if(p.getLibro() == l){
                    switch (l.getCategoria()){
                        case "Cultura":
                            if(!studentiCultura.contains(p.getStudente())){
                                studentiCultura.add(p.getStudente());
                            }
                            break;
                        case "Sport":
                            if(!studentiSport.contains(p.getStudente())){
                                studentiSport.add(p.getStudente());
                            }
                            break;
                        case "Avventura":
                            if(!studentiAvventura.contains(p.getStudente())){
                                studentiAvventura.add(p.getStudente());
                            }
                            break;
                    }
                }
            }
        }

        System.out.println("Cultura:"+libriCultura.size()+", "+studentiCultura.size());
        System.out.println("Sport:"+libriSport.size()+", "+studentiSport.size());
        System.out.println("Avventura:"+libriAvventura.size()+", "+studentiAvventura.size());
    }

    public static void task2(){
        for(Studente s: gestore.getListaStudenti()){
            for(Prenotazione p: gestore.getListaPrenotazioni()){
                if(s == p.getStudente()){
                     if(!s.getLibriInPrestito().contains(p.getLibro())){
                        s.addLibro(p.getLibro());
                        if(p.getDataConsegna().isAfter(p.getDataScadenza())){
                            s.setPunteggioTotale(s.getPunteggioTotale()+p.getLibro().getPunteggio()-5);
                        } else {
                            s.setPunteggioTotale(s.getPunteggioTotale()+p.getLibro().getPunteggio());
                        }
                    }
                }
            }
        }
        for(Studente s: gestore.getListaStudenti()){
            System.out.println(s.getCognome()+", "+s.getPunteggioTotale());
        }
    }
    public static void task3(){
        int bonus;
        ArrayList<Studente> studentiEligibiliBonus = new ArrayList<>();
        ArrayList<Studente> studentiRitardatari = new ArrayList<>();
        for(Studente s: gestore.getListaStudenti()){
            if(s.getLibriInPrestito().size()>1){
                studentiEligibiliBonus.add(s);
            }
        }
        for(Studente s: studentiEligibiliBonus){
            for(Prenotazione p : gestore.getListaPrenotazioni()){
                if(p.getStudente() == s && p.getDataConsegna().isAfter(p.getDataScadenza())){
                    studentiRitardatari.add(s);
                }
            }
        }
        for(Studente s: studentiRitardatari){
            studentiEligibiliBonus.remove(s);
        }
        for (Studente s : gestore.getListaStudenti()){
            if (studentiEligibiliBonus.contains(s)){
                bonus = 20;
                s.setPunteggioTotale(s.getPunteggioTotale()+bonus);
                System.out.println(s.getCognome()+", "+ bonus +", "+s.getPunteggioTotale());
            } else {
                bonus = 0;
                s.setPunteggioTotale(s.getPunteggioTotale()+bonus);
                System.out.println(s.getCognome()+", "+ bonus + ", "+s.getPunteggioTotale());
            }
        }
    }
    public static void main(String[] args) {
        init();
        task1();
        System.out.println();
        task2();
        System.out.println();
        task3();
    }
}