package es.olives;

import es.producto.Producto;
import es.producto.Productor;

public class Manzanilla implements Productor {
    @Override
    public Producto producir() {
        return Olives.GREEN;
    }
}
