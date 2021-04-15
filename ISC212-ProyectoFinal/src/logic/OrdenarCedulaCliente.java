package logic;

import java.util.Comparator;

public class OrdenarCedulaCliente implements Comparator<Cliente> {
    @Override
    public int compare(Cliente o1, Cliente o2) {
        return o2.getCedula().compareToIgnoreCase(o1.getCedula());
    }
}
