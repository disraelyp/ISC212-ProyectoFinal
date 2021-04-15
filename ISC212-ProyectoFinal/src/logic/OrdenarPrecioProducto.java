package logic;

import java.util.Comparator;

public class OrdenarPrecioProducto implements Comparator<Producto> {
    @Override
    public int compare(Producto o1, Producto o2) {
        return (""+o2.getPrecio()).compareToIgnoreCase((""+o1.getPrecio()));
    }
}
