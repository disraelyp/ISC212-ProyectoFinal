package logic;

import java.util.Comparator;

public class OrdenarNombreCliente implements Comparator<Cliente> {
    @Override
    public int compare(Cliente o1, Cliente o2) {
        return o2.getNombre().compareToIgnoreCase(o1.getNombre());
    }
}
