package it.wine;

import es.producto.Producto;
import es.producto.Productor;

public class Martini implements Productor {
    @Override
    public Producto producir() {
        return Wine.WHITE;
    }
}
