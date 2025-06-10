
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.gestore.eventi.Concerto;
import org.gestore.eventi.Evento;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        LocalDate data = LocalDate.of(2029, 9, 22);

        LocalTime ora = LocalTime.of(10, 30);

        BigDecimal prezzo = new BigDecimal("150.1125137");

        Concerto concerto = new Concerto("namles", data, 100, ora, prezzo);

        System.out.println(concerto);

        // creazione dell'evento

        try {

            System.out.println("inserisci il titolo dell'evento");

            String eventTitle = scanner.nextLine();

            System.out.println("inseisci la data dell'evento in questo formato yyyy-mm-dd");

            LocalDate eventDate = LocalDate.parse(scanner.nextLine());

            System.out.println("inserisci il numero di posti a disposizione");

            int eventSeats = Integer.parseInt(scanner.nextLine());

            Evento evento = new Evento(eventTitle, eventDate, eventSeats);            

            /*
             * ----------------------------------------------------------------------------
             */

            System.out.println("Vuoi prenotare dei posti");

            if (yesOrNo(scanner.nextLine())) {

                System.out.println("Quanti posti vuoi prenotare?");

                int numberOfReservationSeats = Integer.parseInt(scanner.nextLine());

                int i = 0;

                while (i < numberOfReservationSeats) {

                    evento.prenota();

                    i++;

                }               
                
            }

            System.out.println(evento + " " + evento.getAnvaibleSeats());

            System.out.println("Vuoi disdire dei posti");

            if (yesOrNo(scanner.nextLine())) {

                System.out.println("Quanti posti vuoi disdire?");

                int numberOfCancelSeats = Integer.parseInt(scanner.nextLine());

                int i = 0;

                while (i < numberOfCancelSeats) {

                    evento.disdici();

                    i++;

                }

            }

            System.out.println(evento + " " + evento.getAnvaibleSeats());            


        } catch (DateTimeException eccezione) {

            System.out.println("problema temporale: " + eccezione.getMessage());

        } catch (RuntimeException eccezione){

            System.out.println("Problema: " + eccezione.getMessage());

        }      
     
        scanner.close();

    }


    

    private static boolean yesOrNo(String chose) throws RuntimeException {

        boolean checker = false;

        if (chose.toLowerCase().equals("si")) {

            checker = true;

        } else if (chose.toLowerCase().equals("no")) {

            checker = false;

        } else {

            throw new RuntimeException("la scelta fatta non è corretta, digita o si o no");

        }

        return checker;

    }

}
