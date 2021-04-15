package logic;

import java.util.Comparator;

public class OrdenarRNCProveedor implements Comparator<Proveedor> {
    @Override
    public int compare(Proveedor o1, Proveedor o2) {
        return o2.getRnc().compareToIgnoreCase(o1.getRnc());
    }
}

