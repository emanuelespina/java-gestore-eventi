package org.gestore.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;

    private LocalDate data;

    private int postiTotali;

    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali) {

        setTitle(titolo);

        setDate(data);

        setSeating (postiTotali);

        postiPrenotati = 0;

    }

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

    public String getDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return this.data.format(formatter);
    }

    private void setSeating(int postiTotali) throws RuntimeException {

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

    public void prenota() {

        if (postiPrenotati < postiTotali && data.isAfter(LocalDate.now())) {

            postiPrenotati++;

           System.out.println("Prenotazione effettuata");

        } else  if (data.isBefore(LocalDate.now())) {

            throw new DateTimeException("Stai cercando i prenotare un evento passato");

        } else if (postiPrenotati >= postiTotali) {

            throw new RuntimeException("non ci sono più posti disponibili");
            
        }   

    }

    public void disdici() throws DateTimeException {

        if (postiPrenotati > 0 && data.isAfter(LocalDate.now())) {

            postiPrenotati--;            

        } else  if (data.isBefore(LocalDate.now())) {

            throw new DateTimeException("Stai cercando i disdire un evento passato");

        } else if (postiPrenotati <= 0) {

            throw new RuntimeException("non puoi disdire ulteriri posti");
            
        }        

    }

    public String getAnvaibleSeats(){

        return "I posti prenotati sono: " + Integer.toString(this.postiPrenotati) + ", mentre quelli ancora disponibili sono: " + Integer.toString(this.postiTotali - this.postiPrenotati);

    }

    @Override
    public String toString() {

        return getDate() + "-" + getTitle();

    }

}
