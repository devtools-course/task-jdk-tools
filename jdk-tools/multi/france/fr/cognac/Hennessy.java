package fr.cognac;

import es.producto.Producto;
import es.producto.Productor;

public class Hennessy implements Productor {
    @Override
    public Producto producir() {
        return Cognac.VSOP;
    }
}
