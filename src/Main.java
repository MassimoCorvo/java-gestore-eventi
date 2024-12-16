import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // LocalDate data = LocalDate.of(2026, 10, 22);
        // Evento evento = new Evento("Concerto", data, 200);

        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci titolo evento");
        String titolo = in.nextLine();
        System.out.println("Inserisci giorno evento");
        int giorno = in.nextInt();
        System.out.println("Inserisci mese evento");
        int mese = in.nextInt();
        System.out.println("Inserisci anno evento");
        int anno = in.nextInt();

        LocalDate data = LocalDate.of(anno, mese, giorno);

        while (data.isBefore(LocalDate.now())) {
            System.out.println("Data non valida. Inserisci nuovamente la data");
            System.out.println("Inserisci giorno evento");
            giorno = in.nextInt();
            System.out.println("Inserisci mese evento");
            mese = in.nextInt();
            System.out.println("Inserisci anno evento");
            anno = in.nextInt();
            data = LocalDate.of(anno, mese, giorno);
        }

        System.out.println("Inserisci numero di posti totali");
        int numeroPosti = in.nextInt();

        while (numeroPosti <= 0) {
            System.out.println("Numero di posti non valido. Inserisci nuovamente il numero di posti");
            System.out.println("Inserisci numero di posti totali");
            numeroPosti = in.nextInt();
        }

        Evento evento = new Evento(titolo, data, numeroPosti);

        // Dopo che l’evento è stato istanziato, chiedere all’utente se e quante
        // prenotazioni vuole fare e provare ad effettuarle, implementando opportuni
        // controlli
        System.out.println("Inserisci il numero di prenotazioni da effettuare");
        int prenotazioniDaEffettuare = in.nextInt();
        if(prenotazioniDaEffettuare <= evento.calcoloPostiDisponibili() && prenotazioniDaEffettuare >= 0){
            for(int i=0; i < prenotazioniDaEffettuare; i++){
                evento.prenota();
            }
        }

        System.out.println("Posti prenotati: " + evento.getNumeroPostiPrenotati());
        System.out.println("Posti disponibili: " + evento.calcoloPostiDisponibili());

        System.out.println("Inserisci il numero di disdette da effettuare");
        int disdetteDaEffettuare = in.nextInt();
        if(disdetteDaEffettuare <= evento.getNumeroPostiPrenotati() && disdetteDaEffettuare >= 0)
        {
            for(int i=0; i < disdetteDaEffettuare;i++){
                evento.disdici();
            }
        }

        System.out.println("Posti prenotati: " + evento.getNumeroPostiPrenotati());
        System.out.println("Posti disponibili: " + evento.calcoloPostiDisponibili());        

    }

}
