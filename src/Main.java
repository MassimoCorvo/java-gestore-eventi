import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate data = LocalDate.of(2026, 10, 22);
        Evento evento = new Evento("Concerto", data, 200);

        System.out.println(data);
        System.out.println(evento.prenota());
        System.out.println(evento.toString());
        System.out.println(evento.getNumeroPostiPrenotati());
    }
    
}
