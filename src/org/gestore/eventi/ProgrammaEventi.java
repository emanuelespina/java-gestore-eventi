package org.gestore.eventi;

import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    private String titolo;

    private List eventi;

    
    public ProgrammaEventi(String titolo) {

        setTitle(titolo);

        eventi = new ArrayList();

    }

    public void setTitle(String titolo) {

        if (titolo.length() > 0) {
            this.titolo = titolo;
        }

    }

    public String getTitle() {

        return titolo = Character.toUpperCase(titolo.charAt(0)) + titolo.substring(1).toLowerCase();

    }

}
