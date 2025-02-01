import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data = null;
    private final int numeroPosti;
    private int numeroPostiPrenotati = 0;

    public Evento(String titolo, LocalDate data, int numeroPosti) {
        // Inserire il controllo che la data non sia già passata e che il numero di
        // posti totali sia positivo. In caso contrario mostrare i dovuti avvisi
        // all’utente
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data non deve essere già passata.");
        }

        if(numeroPosti <= 0){
            throw new IllegalArgumentException("Numero posti non valido.");
        }

        this.titolo = titolo;
        this.data = data;
        this.numeroPosti = numeroPosti;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getData() {
        return this.data.toString();
    }

    public LocalDate getLocalDate() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNumeroPosti() {
        return this.numeroPosti;
    }

    public int getNumeroPostiPrenotati() {
        return this.numeroPostiPrenotati;
    }

    public void prenota(int prenotazioniDaEffettuare) {
        if(data.isAfter(this.data))
            System.out.println("L'evento già passato");
        else if(prenotazioniDaEffettuare == 0)
            System.out.println("Hai scelto di non effettuare prenotazioni.");
        else if(prenotazioniDaEffettuare > this.calcoloPostiDisponibili())
            System.out.println("Non sono disponibili abbastanza posti. Non verranno effettuate prenotazioni.");
        else if(prenotazioniDaEffettuare < 0)
            System.out.println("Il numero di prenotazioni deve essere positivo. Non verranno effettuate prenotazioni.");
        else{this.numeroPostiPrenotati += prenotazioniDaEffettuare;
            System.out.println("Prenotazione effettuata.");}
    }

    public void disdici(int disdetteDaEffettuare){
        if(this.data.isBefore(LocalDate.now()))
            System.out.println("Evento già passato. Disdetta non disponibile.");
        else if(disdetteDaEffettuare > this.numeroPostiPrenotati) {
            System.out.println("Disdetta non disponibile.");
        }
        else if(disdetteDaEffettuare < 0)
            System.out.println("Il numero di disdette da effettuare deve essere maggiore o uguale a 0. Non verranno effettuate disdette.");
        else if( disdetteDaEffettuare <= this.numeroPostiPrenotati )
            this.numeroPostiPrenotati -= disdetteDaEffettuare;
    }

    // data formattata - titolo
    @Override
    public String toString() {
        return this.data + " - " + this.titolo;
    }

    public int calcoloPostiDisponibili() {
        return this.numeroPosti - this.numeroPostiPrenotati;
    }
}
