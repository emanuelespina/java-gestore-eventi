package org.gestore.eventi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {

    // variabili di istanza

    private String titolo;

    private List <Evento> eventi;

    // costruttore    
    
    public ProgrammaEventi(String titolo) {

        setTitle(titolo);

        eventi = new ArrayList <> ();

    }

    // gettere e setter

    public void setTitle(String titolo) {

        if (titolo.length() > 0) {
            this.titolo = titolo;
        }

    }

    public String getTitle() {

        return titolo; //

    }
    public String getHumanTitle() {

        return Character.toUpperCase(titolo.charAt(0)) + titolo.substring(1).toLowerCase();
    }

    // metodo per aggiungere un evento alla lista 

    public void addEvent (Evento evento){

        eventi.add(evento);

    }

    // metodo per ricercare uno o più eventi in base alla data richiesta 

    public List <Evento> getEventsForDate (LocalDate date){
        
        List <Evento> eventsForDate = new ArrayList<>();

        for (Evento evento : eventi) {

            if (evento.getDate().equals(date)) {

                eventsForDate.add(evento);
                
            }
            
        }

        return eventsForDate;

    }

    // metodo che restituisce quanti eventi sono in lista 

    public int getNumberOfEvents (){

        return eventi.size();

    }

    // metodo che cancella tutti gli eventi della lista 

    public void resetEvents (){

        // eventi.removeAll(eventi);
        eventi.clear();
    }

    // metodo che restituisce una lista ordinata degli eventi in base alla data 

    public List<Evento> getOrderEvents (){ 
        
        Collections.sort(eventi);

        eventi.sort((e1, e2) -> e1.getDate().compareTo(e2.getDate())); // labmda function
       
        return eventi;

    }

}
