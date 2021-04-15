package logic;

import java.util.Comparator;

public class OrdenarProveedorOrdenInventario implements Comparator<OrdenInventario> {
    @Override
    public int compare(OrdenInventario o1, OrdenInventario o2) {
        return o2.getProveedor().getNombre().compareToIgnoreCase(o1.getProveedor().getNombre());
    }
}
