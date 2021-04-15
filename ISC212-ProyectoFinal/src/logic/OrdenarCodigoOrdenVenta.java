package logic;

import java.util.Comparator;

public class OrdenarCodigoOrdenVenta implements Comparator<OrdenVenta> {
    @Override
    public int compare(OrdenVenta o1, OrdenVenta o2) {
        return o2.getCodigo().compareToIgnoreCase(o1.getCodigo());
    }
}
