package org.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {

    private LocalTime ora;

    private BigDecimal prezzo;

    public Concerto(String title, LocalDate date, int seating, LocalTime ora, BigDecimal prezzo) {
        super(title, date, seating);

        this.ora = ora;

        this.prezzo = prezzo;
        
    }

    

}
