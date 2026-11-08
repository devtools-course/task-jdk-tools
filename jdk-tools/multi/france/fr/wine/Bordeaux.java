package fr.wine;

import es.producto.Producto;
import es.producto.Productor;
import it.wine.Wine;

public class Bordeaux implements Productor {
    public Producto producir() {
        return Wine.RED;
    }
}
