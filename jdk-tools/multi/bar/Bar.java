import es.olives.Manzanilla;
import fr.cognac.Courvoisier;
import fr.cognac.Hennessy;
import fr.wine.Bordeaux;
import it.olives.Lazio;
import it.wine.Martini;

private static void runClient(int idx, Class... req) {
    IO.println("Client " + idx + " >>");

    for (Class clazz : req) {
        IO.println(clazz.getName());
    }

    IO.println("<< Client " + idx);
}

void main() {
    runClient(1, Courvoisier.class);
    runClient(2, Martini.class, Lazio.class);
    runClient(3, Bordeaux.class, Manzanilla.class, Hennessy.class);
}
