package org.gestore.eventi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

    // variabili di istanza

    private LocalTime ora;

    private BigDecimal prezzo;
    
    // costruttore

    public Concerto(String title, LocalDate date, int seating, LocalTime ora, BigDecimal prezzo) {
        super(title, date, seating);

        setTime(ora);

        setPrice(prezzo);
        
    }

    // gettere e setter

    public void setTime (LocalTime ora) throws DateTimeException {

        if (ora.isAfter(LocalTime.now())){

            this.ora = ora;

        } else {

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

        BigDecimal finalePrice = this.prezzo.setScale(2,RoundingMode.HALF_UP);

        return finalePrice.toString();

    }   
    
    // metodo per stapare il concerto come una stringa che contenga la data, l'ora, il titolo e il prezzo 

    @Override
    public String toString() {

        return getDate() + "-" + getTime() + "-" + getTitle() + "-" + getPrice() + " EUR";

    }

    

}
