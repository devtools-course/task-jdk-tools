package it.olives;

import es.olives.Olives;
import es.producto.Producto;
import es.producto.Productor;

public class Lazio implements Productor {
    @Override
    public Producto producir() {
        return Olives.RED;
    }
}
