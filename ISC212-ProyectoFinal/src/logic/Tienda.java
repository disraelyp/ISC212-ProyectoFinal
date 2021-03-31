package logic;

import java.util.ArrayList;

public class Tienda {
	
	private ArrayList<Componente> productos;
	private ArrayList<PaqueteComponentes> ofertas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Empleado> empleados;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Venta> facturas;
	private ArrayList<OrdenInventario> ordenes;
	
	private static Tienda tienda = null;
	
	
	public Tienda() {
		super();
		this.productos = new ArrayList<Componente>();
		this.ofertas = new ArrayList<PaqueteComponentes>();
		this.clientes = new ArrayList<Cliente>();
		this.empleados = new ArrayList<Empleado>();
		this.proveedores = new ArrayList<Proveedor>();
		this.facturas = new ArrayList<Venta>();
		this.ordenes = new ArrayList<OrdenInventario>();
	}

	public static Tienda getInstance() {
		if(tienda==null) {
			tienda=new Tienda();
		}
		return tienda;
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
	public ArrayList<OrdenInventario> getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(ArrayList<OrdenInventario> ordenes) {
		this.ordenes = ordenes;
	}
	
	//FUNCIONES DE ADMINISTRADORES
	
	
	// FUNCIONES DE PROVEEDORES
	public void generarProveedor(String rnc, String nombre, String telefono, String direccion, Persona representante) {
		Proveedor proveedor = new Proveedor(rnc, nombre, telefono, direccion, representante);
		this.proveedores.add(proveedor);
	}
	public boolean verificarRnc(String rnc) {
		for(Proveedor x: proveedores) {
			if(x.getRnc().equals(rnc)) {
				return false;
			}
		}
		return true;
	}
	public Proveedor buscarProveedor(String rnc) {
		for(Proveedor x: proveedores) {
			if(x.getRnc().equals(rnc)) {
				return x;
			}
		}
		return null;
	}
	
	// FUNCIONES DE COMPRAS DE INVENTARIO
	public void generarCompraInventario(Proveedor proveedor, Administrador administrador, ArrayList<Componente> componentes) {
		CompraInventario compraInventario = new CompraInventario(proveedor, administrador, componentes);
		this.ordenes.add(compraInventario);
	}
	public OrdenInventario buscarCompraInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof CompraInventario) {
				if(((CompraInventario) x).getCodigo().equalsIgnoreCase(codigo)) {
					return x;
				}
			}
		}
		return null;
	}
	public boolean verificarOrdenInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof CompraInventario) {
				if(((CompraInventario) x).getCodigo().equalsIgnoreCase(codigo)) {
					return false;
				}
			}
		}
		return false;
	}
	public void compraInventarioToDevolucionInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		this.ordenes.remove(compraInventario);
		DevolucionInventario devolucionInventario = new DevolucionInventario(compraInventario.getProveedor(), compraInventario.getAdministrador(), compraInventario.getComponentes());
		this.ordenes.add(devolucionInventario);
	}
	public void recibirCompraInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		if(compraInventario.isRecibida()) {
			for(Componente x: productos) {
				for(Componente y: compraInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						x.setCantidad(x.getCantidad()+y.getCantidad());
					}
				}
			}
		}
	}
	public void retirarCompraInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		if(compraInventario.isRecibida()) {
			for(Componente x: productos) {
				for(Componente y: compraInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						x.setCantidad(x.getCantidad()-y.getCantidad());
					}
				}
			}
		}
	}
	public Boolean isRetirableCompraInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		if(compraInventario.isRecibida()) {
			for(Componente x: productos) {
				for(Componente y: compraInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						if(x.getCantidad()<y.getCantidad()) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	public void modificarCompraInventario(String codigo, Proveedor proveedor, Administrador administrador, ArrayList<Componente> componentes) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		for(OrdenInventario x: ordenes) {
			if(x instanceof CompraInventario) {
				if(x==compraInventario) {
					retirarCompraInventario(((CompraInventario) x).getCodigo());
					x.setAdministrador(administrador);
					x.setProveedor(proveedor);
					x.setComponentes(componentes);
					((CompraInventario) x).setPagada(false);
					((CompraInventario) x).setRecibida(false);
				}
			}
		}
	}

}
