package org.gestore.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento implements Comparable <Object> {

    // variabili si istanza

    private String titolo;

    private LocalDate data;

    private int postiTotali;

    private int postiPrenotati;

    // costruttore
      

    public Evento(String titolo, LocalDate data, int postiTotali) {

        setTitle(titolo);

        setDate(data);

        setSeating (postiTotali);

        this.postiPrenotati = 0;

    }

    // getter e setter

    public void setTitle(String titolo) {

        if (titolo.length() > 0) {
            this.titolo = titolo;
        }

    }

    public String getTitle() {

        return titolo = Character.toUpperCase(titolo.charAt(0)) + titolo.substring(1).toLowerCase();

    }

    public void setDate(LocalDate data) throws DateTimeException {

        if (data.isAfter(LocalDate.now()) || data.equals(LocalDate.now())) {

            this.data = data;

        } else {

            throw new DateTimeException("data precedente ad oggi");         
            
        }

    }

    public LocalDate getDate() {

        return data;
    }
    public String getHumanDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return this.data.format(formatter);
    }

    public void setSeating(int postiTotali) throws RuntimeException {

        if  (postiTotali >= 0) {

            this.postiTotali = postiTotali;

        } else {

            throw new RuntimeException("non poi inserire posti negativi");

        }

    }

    public int getSeating() {

        return this.postiTotali;

    }

    private void setpostiPrenotati(int postiPrenotati) {

        this.postiPrenotati = postiPrenotati;

    }

    public int getpostiPrenotati() {

        return this.postiPrenotati;

    }

    // metodo per prenotare un posto

    public void prenota(int nPosti) {

        if (postiPrenotati < postiTotali && data.isAfter(LocalDate.now())) {

            postiPrenotati+= nPosti;       

        } else  if (data.isBefore(LocalDate.now())) {

            throw new DateTimeException("Stai cercando i prenotare un evento passato");

        } else if (postiPrenotati >= postiTotali) {

            throw new RuntimeException("non ci sono più posti disponibili");
            
        }   

    }

    // metodo per disdire un posto

    public void disdici() throws DateTimeException {

        if (postiPrenotati > 0 && data.isAfter(LocalDate.now())) {

            postiPrenotati--;            

        } else  if (data.isBefore(LocalDate.now())) {

            throw new DateTimeException("Stai cercando i disdire un evento passato");

        } else if (postiPrenotati <= 0) {

            throw new RuntimeException("non puoi disdire ulteriri posti");
            
        }        

    }

    // metodo che restituisce quanti posti sono ancora disponibili e quanti sono occupati

    public String getAnvaibleSeats(){

        return "I posti prenotati sono: " + Integer.toString(this.postiPrenotati) + ", mentre quelli ancora disponibili sono: " + Integer.toString(this.postiTotali - this.postiPrenotati);

    }

    // metodo per stapare l'evento come una stringa che contenga la data e il titolo

    @Override
    public String toString() {

        return getDate() + "-" + getTitle();

    }

    // metodo grazie al quale l'arrayList compare le date degli eventi 

    @Override

    public int compareTo(Object o) {

        Evento c = (Evento) o;

        return this.data.compareTo(c.data);

    }

}
