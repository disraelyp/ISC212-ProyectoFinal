package logic;

import java.util.Comparator;

public class OrdenarNombreProveedor implements Comparator<Proveedor> {
    @Override
    public int compare(Proveedor o1, Proveedor o2) {
        return o2.getNombre().compareToIgnoreCase(o1.getNombre());
    }
}

