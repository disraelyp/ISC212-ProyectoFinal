package logic;

import java.util.Comparator;

public class OrdenarCodigoOrdenInventario implements Comparator<OrdenInventario> {
    @Override
    public int compare(OrdenInventario o1, OrdenInventario o2) {
        return o2.getCodigo().compareToIgnoreCase(o1.getCodigo());
    }
}
