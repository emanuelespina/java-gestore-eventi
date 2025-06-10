package org.gestore.eventi;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

    private LocalTime ora;

    private BigDecimal prezzo;

    public Concerto(String title, LocalDate date, int seating, LocalTime ora, BigDecimal prezzo) {
        super(title, date, seating);

        this.ora = ora;

        this.prezzo = prezzo;
        
    }

    public void setTime (LocalTime ora) throws DateTimeException {

        if (ora.isAfter(LocalTime.now())){

            this.ora = ora;

        } else if (ora.equals(LocalTime.now()) || ora.isBefore(ora)) {

            throw new DateTimeException ("ora precendete a quella corrente");
            
        }

    }

    public String getTime (){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        return this.ora.format(formatter);

    }

    public void setPrice (BigDecimal prezzo) throws RuntimeException{

        if (prezzo.compareTo(BigDecimal.ZERO) >= 0) {

            this.prezzo = prezzo;

        } else {

            throw new RuntimeException("il prezzo inserito è negativo, correggerlo con uno >= 0");

        }

    }

    public String getPrice (){

        return this.prezzo.setScale(2).toString();

    }    

    @Override
    public String toString() {
        
        return getDate() + "-" + getTime() + "-" + getTitle() + "-" + getPrice() + "€";
    }

    

}
