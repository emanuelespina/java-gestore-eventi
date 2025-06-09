package org.gestore.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String title;

    private LocalDate date;

    private int seating;

    private int reservedSeats;

    public Evento(String title, LocalDate date, int seating) {

        setTitle(title);

        setDate(date);

        setSeating(seating);

        reservedSeats = 0;

    }

    public void setTitle(String title) {

        if (title.length() > 0) {
            this.title = title;
        }

    }

    public String getTitle() {

        return title = Character.toUpperCase(title.charAt(0)) + title.substring(1).toLowerCase();

    }

    public void setDate(LocalDate date) throws DateTimeException {

        if (date.isAfter(LocalDate.now())) {

            this.date = date;

        } else {

            throw new DateTimeException("data precedente ad oggi");         
            
        }

    }

    public String getDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return this.date.format(formatter);
    }

    private void setSeating(int seating) throws RuntimeException {

        if (seating >= 0) {

            this.seating = seating;

        } else {

            throw new RuntimeException("non poi inserire posti negativi");

        }

    }

    public int getSeating() {

        return this.seating;

    }

    private void setReservedSeats(int reservedSeats) {

        this.reservedSeats = reservedSeats;

    }

    public int getReservedSeats() {

        return this.reservedSeats;

    }

    public void prenota() {

        if (reservedSeats < seating && date.isAfter(LocalDate.now())) {

            reservedSeats++;

           System.out.println("Prenotazione effettuata");

        } else {

            // messaggio di errore pienone

        }

    }

    public void disdici() {

        if (reservedSeats > 0 && date.isAfter(LocalDate.now())) {

            reservedSeats--;

            // disdetta gestita come errore

        } else {

            // messaggio di errore pienone

        }

        // va aggiunto il messaggio per la data

    }

    public String getAnvaibleSeats(){

        return "I posti prenotati sono: " + Integer.toString(this.reservedSeats) + ", mentre quelli ancora disponibili sono: " + Integer.toString(this.seating - this.reservedSeats);

    }

    @Override
    public String toString() {

        return getDate() + " " + getTitle();

    }

}
