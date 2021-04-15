package logic;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrdenInventario implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	protected String codigo;
	protected Proveedor proveedor;
	protected Date fecha;
	protected Administrador administrador;
	protected int plazoPago;
	protected ArrayList<Componente> componentes;
	
	public OrdenInventario(Proveedor proveedor, Date fecha, Administrador administrador, int plazoPago,
			ArrayList<Componente> componentes) {
		super();
		this.codigo="I-"+Tienda.getInstance().getOrdenes().size();
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.administrador = administrador;
		this.plazoPago = plazoPago;
		this.componentes = componentes;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	public int getPlazoPago() {
		return plazoPago;
	}
	public void setPlazoPago(int plazoPago) {
		this.plazoPago = plazoPago;
	}
	
	public String getFechaTexto() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		String fechat = formato.format(fecha);
		return fechat;
	}
	public float getCostoTotal() {
		float costoTotal=0;
		for(Componente x: componentes) {
			costoTotal+=x.getCosto()*x.getCantidad();
		}
		return costoTotal;
	}

}
