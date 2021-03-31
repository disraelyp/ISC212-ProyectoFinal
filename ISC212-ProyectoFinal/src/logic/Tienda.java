package logic;

import java.util.ArrayList;
import java.util.Date;

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
	public void generarCompraInventario(Proveedor proveedor, Administrador administrador, int plazoPago, Date fecha, ArrayList<Componente> componentes) {
		CompraInventario compraInventario = new CompraInventario(proveedor, fecha, administrador, plazoPago, componentes);
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
		retirarCompraInventario(codigo);
		this.ordenes.remove(compraInventario);
		DevolucionInventario devolucionInventario = new DevolucionInventario(compraInventario.getProveedor(), compraInventario.getFecha(), compraInventario.getAdministrador(), compraInventario.getPlazoPago(), compraInventario.getComponentes());
		devolucionInventario.setRetirada(true);
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
		for(OrdenInventario x: ordenes) {
			if(x instanceof CompraInventario) {
				if(((CompraInventario) x).getCodigo().equals(codigo)) {
					((CompraInventario) x).setRecibida(true);
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
		modificarCompraInventario(codigo, compraInventario.getProveedor(), compraInventario.getAdministrador(), compraInventario.getComponentes());
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
	public void eliminarCompraInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		for(OrdenInventario x: ordenes) {
			if(x instanceof CompraInventario) {
				if(x==compraInventario) {
					if(((CompraInventario) x).isRecibida()) {
						retirarCompraInventario(codigo);
					}
					this.ordenes.remove(x);
				}
			}
		}
	}
	public void duplicarCompraInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		generarDevolucionInventario(compraInventario.getProveedor(), compraInventario.getAdministrador(), compraInventario.getPlazoPago(), compraInventario.getFecha(), compraInventario.getComponentes());
	}

	// FUNCIONES DE DEVOLUCION DE INVENTARIO
	public void generarDevolucionInventario(Proveedor proveedor, Administrador administrador, int plazoPago, Date fecha, ArrayList<Componente> componentes) {
		DevolucionInventario devolucionInventario = new DevolucionInventario(proveedor, fecha, administrador, plazoPago, componentes);
		this.ordenes.add(devolucionInventario);
	}
	public OrdenInventario buscarDevolucionInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof DevolucionInventario) {
				if(((DevolucionInventario) x).getCodigo().equalsIgnoreCase(codigo)) {
					return x;
				}
			}
		}
		return null;
	}
	public boolean verificarDevolucionInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof DevolucionInventario) {
				if(((DevolucionInventario) x).getCodigo().equalsIgnoreCase(codigo)) {
					return false;
				}
			}
		}
		return true;
	}
	public void recibirDevolucionInventario(String codigo) {
		DevolucionInventario devolucionInventario = (DevolucionInventario) buscarDevolucionInventario(codigo);
		if(devolucionInventario.isRetirada()) {
			for(Componente x: productos) {
				for(Componente y: devolucionInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						x.setCantidad(x.getCantidad()+y.getCantidad());
					}
				}
			}
		}
		for(OrdenInventario x: ordenes) {
			if(x instanceof DevolucionInventario) {
				if(((DevolucionInventario) x).getCodigo().equals(codigo)) {
					((DevolucionInventario) x).setRetirada(false);
				}
			}
		}
	}
	public void retirarDevolucionInventario(String codigo) {
		DevolucionInventario devolucionInventario = (DevolucionInventario) buscarDevolucionInventario(codigo);
		if(!devolucionInventario.isRetirada()) {
			for(Componente x: productos) {
				for(Componente y: devolucionInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						x.setCantidad(x.getCantidad()-y.getCantidad());
					}
				}
			}
		}
		modificarDevolucionInventario(codigo, devolucionInventario.getProveedor(), devolucionInventario.getAdministrador(), devolucionInventario.getComponentes());
	}
	public Boolean isRetirableDevolucionInventario(String codigo) {
		DevolucionInventario devolucionInventario = (DevolucionInventario) buscarDevolucionInventario(codigo);
		if(!devolucionInventario.isRetirada()) {
			for(Componente x: productos) {
				for(Componente y: devolucionInventario.getComponentes()) {
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
	public void modificarDevolucionInventario(String codigo, Proveedor proveedor, Administrador administrador, ArrayList<Componente> componentes) {
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
	public void eliminarDevolucionInventario(String codigo) {
		DevolucionInventario devolucionInventario = (DevolucionInventario) buscarDevolucionInventario(codigo);
		for(OrdenInventario x: ordenes) {
			if(x instanceof DevolucionInventario) {
				if(x==devolucionInventario) {
					if(((DevolucionInventario) x).isRetirada()) {
						recibirDevolucionInventario(codigo);
					}
					this.ordenes.remove(x);
				}
			}
		}
	}
	public void duplicarDevolucionInventario(String codigo) {
		DevolucionInventario devolucionInventario = (DevolucionInventario) buscarDevolucionInventario(codigo);
		generarDevolucionInventario(devolucionInventario.getProveedor(), devolucionInventario.getAdministrador(), devolucionInventario.getPlazoPago(), devolucionInventario.getFecha(), devolucionInventario.getComponentes());
	}
	
	// FUNCIONES DE COTIZACION DE INVENTARIO
	public void generarCotizacionInventario(Proveedor proveedor, Administrador administrador, int plazoPago, Date fecha, ArrayList<Componente> componentes) {
		CotizacionInventario devolucionInventario = new CotizacionInventario(proveedor, fecha, administrador, plazoPago, componentes);
		this.ordenes.add(devolucionInventario);
	}
	public OrdenInventario buscarCotizacionInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof CotizacionInventario) {
				if(((CotizacionInventario) x).getCodigo().equalsIgnoreCase(codigo)) {
					return x;
				}
			}
		}
		return null;
	}
	public boolean verificarCotizacionInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof CotizacionInventario) {
				if(((CotizacionInventario) x).getCodigo().equalsIgnoreCase(codigo)) {
					return false;
				}
			}
		}
		return false;
	}
	public void cotizacionInventarioToCompraInventario(String codigo) {
		CotizacionInventario cotizacionInventario = (CotizacionInventario) buscarCotizacionInventario(codigo);
		this.ordenes.remove(cotizacionInventario);
		generarCompraInventario(cotizacionInventario.getProveedor(), cotizacionInventario.getAdministrador(), cotizacionInventario.getPlazoPago(), cotizacionInventario.getFecha(), cotizacionInventario.getComponentes());
	}
	public void eliminarCotizacionInventario(String codigo) {
		CotizacionInventario cotizacionInventario = (CotizacionInventario) buscarCotizacionInventario(codigo);
		for(OrdenInventario x: ordenes) {
			if(x instanceof CotizacionInventario) {
				if(x==cotizacionInventario) {
					this.ordenes.remove(x);
				}
			}
		}
	}
	public void duplicarCotizacionInventario(String codigo) {
		CotizacionInventario cotizacionInventario = (CotizacionInventario) buscarDevolucionInventario(codigo);
		generarDevolucionInventario(cotizacionInventario.getProveedor(), cotizacionInventario.getAdministrador(), cotizacionInventario.getPlazoPago(), cotizacionInventario.getFecha(), cotizacionInventario.getComponentes());
	}
	public void modificarCotizacionInventario(String codigo, Proveedor proveedor, Administrador administrador, ArrayList<Componente> componentes) {
		CotizacionInventario cotizacionInventario = (CotizacionInventario) buscarCotizacionInventario(codigo);
		for(OrdenInventario x: ordenes) {
			if(x instanceof CotizacionInventario) {
				if(x==cotizacionInventario) {
					x.setAdministrador(administrador);
					x.setProveedor(proveedor);
					x.setComponentes(componentes);
				}
			}
		}
	}
	
}
