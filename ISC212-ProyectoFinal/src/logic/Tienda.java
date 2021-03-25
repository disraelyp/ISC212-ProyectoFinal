package logic;

import java.util.ArrayList;

public class Tienda {
	private ArrayList<Componente> productos;
	private ArrayList<PaqueteComponentes> ofertas;
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Empleado> empleados;
	private ArrayList<Proveedor> proveedores;
	
	private ArrayList<Venta> facturas;
	private ArrayList<Compra> ordenes;
	
	
	public Tienda() {
		super();
		this.productos = new ArrayList<Componente>();
		this.ofertas = new ArrayList<PaqueteComponentes>();
		this.clientes = new ArrayList<Cliente>();
		this.empleados = new ArrayList<Empleado>();
		this.proveedores = new ArrayList<Proveedor>();
		this.facturas = new ArrayList<Venta>();
		this.ordenes = new ArrayList<Compra>();
	}


	public ArrayList<Componente> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Componente> productos) {
		this.productos = productos;
	}
	public ArrayList<PaqueteComponentes> getOfertas() {
		return ofertas;
	}
	public void setOfertas(ArrayList<PaqueteComponentes> ofertas) {
		this.ofertas = ofertas;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	public ArrayList<Venta> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Venta> facturas) {
		this.facturas = facturas;
	}
	public ArrayList<Compra> getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(ArrayList<Compra> ordenes) {
		this.ordenes = ordenes;
	}
	
}
