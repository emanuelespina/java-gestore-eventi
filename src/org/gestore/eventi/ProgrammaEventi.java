package org.gestore.eventi;

import java.text.CollationElementIterator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    private String titolo;

    private List <Evento> eventi;
    
    
    public ProgrammaEventi(String titolo) {

        setTitle(titolo);

        eventi = new ArrayList <Evento> ();

    }

    public void setTitle(String titolo) {

        if (titolo.length() > 0) {
            this.titolo = titolo;
        }

    }

    public String getTitle() {

        return titolo = Character.toUpperCase(titolo.charAt(0)) + titolo.substring(1).toLowerCase();

    }

    public void addEvent (Evento evento){

        eventi.add(evento);

    }

    public List getEventsForDate (LocalDate date){
        
        List <Evento> eventsForDate = eventi;

        return eventsForDate;

    }

    public int getNumberOfEvents (){

        return eventi.size();

    }

    public void resetEvents (){

        eventi.removeAll(eventi);

    }

    public List getOrderEvents (){

        

        return eventi;

    }




}
