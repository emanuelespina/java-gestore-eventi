
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import org.gestore.eventi.Evento;
import org.gestore.eventi.ProgrammaEventi;

public class Main {
    public static void main(String[] args) throws Exception {

        //--------------------------------------------------------------------------------

        Scanner scanner = new Scanner(System.in);

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

        // prenotazioni 

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

            // disdette

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

            // possibili errori 

        } catch (DateTimeException eccezione) {

            System.out.println("problema temporale: " + eccezione.getMessage());

        } catch (RuntimeException eccezione){

            System.out.println("Problema: " + eccezione.getMessage());

        }      
     
        scanner.close();

    }

    // metodo per capire se l'utente risponde sì o no 

    private static boolean yesOrNo(String chose) throws RuntimeException {

        boolean checker = false;

        if (chose.toLowerCase().equals("si")) {

            checker = true;

        } else if (chose.toLowerCase().equals("no")) {

            checker = false;

        } else {

            throw new RuntimeException("la scelta fatta non è corretta, digita si o no");

        }

        return checker;

    }

}
