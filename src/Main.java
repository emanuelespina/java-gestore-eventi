
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import org.gestore.eventi.Evento;
import org.gestore.eventi.ProgrammaEventi;

public class Main {
    public static void main(String[] args) throws Exception {


        ProgrammaEventi tour1 = new ProgrammaEventi("tourEminem");
        
        tour1.addEvent(new Evento("concertoMilano", LocalDate.of(2030, 10, 10), 300));

        tour1.addEvent(new Evento("concertoMilano2", LocalDate.of(2030, 10, 10), 300));

        tour1.addEvent(new Evento("concertoRoma", LocalDate.of(2030, 12, 10), 350));

        tour1.addEvent(new Evento("concertoComo", LocalDate.of(2030, 8, 10), 250));

        tour1.addEvent(new Evento("concertoMilano", LocalDate.of(2031, 10, 10), 310));

        System.out.println(tour1.getNumberOfEvents());

        System.out.println(tour1.getEventsForDate(LocalDate.of(2030, 10, 10)));

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

        // prenotazioni / disdette

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

            throw new RuntimeException("la scelta fatta non è corretta, digita si o no");

        }

        return checker;

    }

}
