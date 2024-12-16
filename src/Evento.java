import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data = null;
    private final int numeroPosti;
    private int numeroPostiPrenotati = 0;

    public Evento(String titolo, LocalDate data, int numeroPosti) {
        this.titolo = titolo;

        // Chiedere se fare il controllo nel main o qui

        // Inserire il controllo che la data non sia già passata e che il numero di
        // posti totali sia positivo. In caso contrario mostrare i dovuti avvisi
        // all’utente
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNumeroPosti() {
        return this.numeroPosti;
    }

    public int getNumeroPostiPrenotati() {
        return this.numeroPostiPrenotati;
    }

    public String prenota() {
        ////Se l’evento è già passato o non ha posti disponibili deve restituire un messaggio di avviso

        if (this.numeroPostiPrenotati == this.numeroPosti || this.data.isBefore(LocalDate.now()))
            return "Prenotazione non disponibile.";
        else if (this.numeroPostiPrenotati < this.numeroPosti) {
            this.numeroPostiPrenotati++;
        }

        return "Prenotazione effettuata.";

    }

    // riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono
    // prenotazioni restituisce un messaggio di avviso.
    public String disdici() {
        if (this.numeroPostiPrenotati == 0 || this.data.isBefore(LocalDate.now())) {
            return "Disdetta non disponibile";
        }
        this.numeroPostiPrenotati--;
        return "Disdetta effettuata";
    }

    // data formattata - titolo
    @Override
    public String toString() {
        return this.data + " - " + this.titolo;
    }

    public int calcoloPostiDisponibili(){
        return this.numeroPosti - this.numeroPostiPrenotati;
    }
}
