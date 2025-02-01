import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento{
    private LocalTime ora;
    private float prezzo;

    public Concerto(String titolo, LocalDate data, int numeroPosti, LocalTime ora, float prezzo){
        super(titolo, data, numeroPosti);

        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String dataEOra(){
        return this.getData() + " " + this.getOra();
    }

    public String prezzoFormattato(){
        return String.format("%.02f", this.getPrezzo()) + "E";
    }

    //data e ora formattata - titolo - prezzo formattato
    @Override
    public String toString(){
        return this.dataEOra() + " - " + this.getTitolo() + " - " + this.prezzoFormattato();
    }
}
