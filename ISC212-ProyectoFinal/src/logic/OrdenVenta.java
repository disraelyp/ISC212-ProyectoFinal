package logic;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class OrdenVenta implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private Date fecha;
	private int plazoPago;
	private String codigo;
	private Cliente cliente;
	private Empleado empleado;
	private ArrayList<Producto> productos;
	
	public OrdenVenta(Cliente cliente, Empleado empleado, Date fecha, int plazoPago, ArrayList<Producto> productos) {
		super();
		this.setFecha(fecha);
		this.codigo = "F-"+Tienda.getInstance().getFacturas().size();
		this.cliente = cliente;
		this.empleado = empleado;
		this.setPlazoPago(plazoPago);
		this.productos = productos;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public float getMontoTotal() {
		float montoTotal=0;
		for(Producto x: productos) {
			montoTotal+=x.getPrecio()*x.getCantidad();
		}
		return montoTotal;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getPlazoPago() {
		return plazoPago;
	}
	public void setPlazoPago(int plazoPago) {
		this.plazoPago = plazoPago;
	}
}
