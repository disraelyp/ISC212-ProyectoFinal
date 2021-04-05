package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Tienda implements Serializable{

	private static final long serialVersionUID =1L;
	private static Tienda tienda=null;
	private static Empleado loginUser;
	
	private ArrayList<Producto> productos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Empleado> empleados;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<OrdenVenta> facturas;
	private ArrayList<OrdenInventario> ordenes;

	public Tienda() {
		super();
		this.productos = new ArrayList<Producto>();
		this.clientes = new ArrayList<Cliente>();
		this.empleados = new ArrayList<Empleado>();
		this.proveedores = new ArrayList<Proveedor>();
		this.facturas = new ArrayList<OrdenVenta>();
		this.ordenes = new ArrayList<OrdenInventario>();
	}

	public static Tienda getInstance() {
		if(tienda==null) {
			tienda=new Tienda();
		}
		return tienda;
	}
	
	public static void setTienda(Tienda tiendaCargada) {
		tienda = tiendaCargada;
	}
	
	public static Empleado getLoginUser() {
		return loginUser;
	}
	public static void setLoginUser(Empleado loginUser) {
		Tienda.loginUser = loginUser;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
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
	public ArrayList<OrdenVenta> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<OrdenVenta> facturas) {
		this.facturas = facturas;
	}
	public ArrayList<OrdenInventario> getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(ArrayList<OrdenInventario> ordenes) {
		this.ordenes = ordenes;
	}

	// FUNCIONES DE LOS PRODUCTOS
	public boolean verificarProducto(String codigo) {
		for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo)) {
				return true;
			}
		}
		return false;
	}
	public Producto buscarProducto(String codigo) {
		for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo)) {
				return x;
			}
		}
		return null;
	}
	
	// FUNCIONES DE LOS COMPONENTES
	public void generarComponente(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo) {
		Componente componente = new Componente(modelo, marca, cantidad, cantidadMinima, precio, costo);
		System.out.printf(""+componente.getCodigo());
		productos.add(componente);
	}
	
	public boolean verificarComponente(String codigo) {
		for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof Componente) {
				return true;
			}
		}
		return false;
	}
	
	public Componente buscarComponente(String codigo) {
		for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof Componente) {
				return (Componente) x;
			}
		}
		return null;
	}
	
	// FUNCIONES DE LOS PAQUETES DE COMPONENTES
	
	
	// FUNCIONES DE LOS EMPLEADOS
	public boolean iniciarSesion(String usuario, String contrasena) {
		boolean login = false;
		for(Empleado usuarios: empleados) {
			if(usuarios.getUsuario().equalsIgnoreCase(usuario) && usuarios.getContraseña().equalsIgnoreCase(contrasena)) {
				loginUser = usuarios;
				login = true;
			}
		}
		return login;
	}
	public void generarEmpleado(String cedula, String nombre, String telefono, String direccion, float sueldo, float comision, String usuario, String contraseña) {
		Empleado empleado = new Empleado(cedula, nombre, telefono, direccion, sueldo, comision, usuario, contraseña);
		empleados.add(empleado);
		
	}
	
	public boolean verificarEmpleado(int codigo) {
		for(Empleado x: empleados) {
			if((x.getCodigo() == codigo) && (!(x instanceof Administrador))) {
				return true;
			}
		}
		return false;
	}
	
	public Empleado buscarEmpleado(int codigo) {
		for(Empleado x: empleados) {
			if((x.getCodigo() == codigo) && (!(x instanceof Administrador))) {
				return (Empleado) x;
			}
		}
		return null;
	}
	
	//FUNCIONES DE ADMINISTRADORES
	public void generarAdministrador(String cedula, String nombre, String telefono, String direccion, float sueldo, float comision, String usuario, String contraseña) {
		Administrador administrador = new Administrador(cedula, nombre, telefono, direccion, sueldo, comision, usuario, contraseña);
		empleados.add(administrador);
	}
	
	public boolean verificarAdministrador(int codigo) {
		for(Empleado x: empleados) {
			if((x.getCodigo() == codigo) && (x instanceof Administrador)) {
				return true;
			}
		}
		return false;
	}
	
	public Administrador buscarAdministrador(int codigo) {
		for(Empleado x: empleados) {
			if((x.getCodigo() == codigo) && (x instanceof Administrador)) {
				return (Administrador) x;
			}
		}
		return null;
	}
	
	//FUNCIONES DE CLIENTES
	
	public void generarCliente(String cedula, String nombre, String telefono, String direccion, float creditoLimite) {
		Cliente cliente = new Cliente(cedula, nombre, telefono, direccion, creditoLimite);
		clientes.add(cliente);
		
	}
	
	public boolean verificarCliente(String cedula) {
		for(Cliente x: clientes) {
			if(x.getCedula().equalsIgnoreCase(cedula)) {
				return true;
			}
		}
		return false;
	}
	
	public Cliente buscarCliente(String cedula) {
		for(Cliente x: clientes) {
			if(x.getCedula().equalsIgnoreCase(cedula)) {
				return x;
			}
		}
		return null;
	}
	
	
	// FUNCIONES DE PROVEEDORES
	public void generarProveedor(String rnc, String nombre, String telefono, String direccion, Persona representante) {
		Proveedor proveedor = new Proveedor(rnc, nombre, telefono, direccion, representante);
		proveedores.add(proveedor);
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
		ordenes.add(compraInventario);
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
		ordenes.remove(compraInventario);
		DevolucionInventario devolucionInventario = new DevolucionInventario(compraInventario.getProveedor(), compraInventario.getFecha(), compraInventario.getAdministrador(), compraInventario.getPlazoPago(), compraInventario.getComponentes());
		devolucionInventario.setRetirada(true);
		ordenes.add(devolucionInventario);
	}
	public void recibirCompraInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		for(Producto x: productos) {
			for(Componente y: compraInventario.getComponentes()) {
				if(x.getCodigo().equals(y.getCodigo())) {
					((Componente) (x)).setCantidad(((Componente) (x)).getCantidad()+y.getCantidad());
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
			for(Producto x: productos) {
				for(Componente y: compraInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						((Componente) (x)).setCantidad(((Componente) (x)).getCantidad()-y.getCantidad());
					}
				}
			}
		}
		modificarCompraInventario(codigo, compraInventario.getProveedor(), compraInventario.getAdministrador(), compraInventario.getComponentes());
	}
	public Boolean isRetirableCompraInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		if(compraInventario.isRecibida()) {
			for(Producto x: productos) {
				for(Componente y: compraInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						if(((Componente) (x)).getCantidad()<y.getCantidad()) {
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
					ordenes.remove(x);
					break;
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
		ordenes.add(devolucionInventario);
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
			for(Producto x: productos) {
				for(Componente y: devolucionInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						((Componente) (x)).setCantidad(((Componente) (x)).getCantidad()+y.getCantidad());
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
			for(Producto x: productos) {
				for(Componente y: devolucionInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						((Componente) (x)).setCantidad(((Componente) (x)).getCantidad()-y.getCantidad());
					}
				}
			}
		}
		modificarDevolucionInventario(codigo, devolucionInventario.getProveedor(), devolucionInventario.getAdministrador(), devolucionInventario.getComponentes());
	}
	public Boolean isRetirableDevolucionInventario(String codigo) {
		DevolucionInventario devolucionInventario = (DevolucionInventario) buscarDevolucionInventario(codigo);
		if(!devolucionInventario.isRetirada()) {
			for(Producto x: productos) {
				for(Componente y: devolucionInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						if(((Componente) (x)).getCantidad()<y.getCantidad()) {
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
					ordenes.remove(x);
					break;
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
		ordenes.add(devolucionInventario);
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
		ordenes.remove(cotizacionInventario);
		generarCompraInventario(cotizacionInventario.getProveedor(), cotizacionInventario.getAdministrador(), cotizacionInventario.getPlazoPago(), cotizacionInventario.getFecha(), cotizacionInventario.getComponentes());
	}
	public void eliminarCotizacionInventario(String codigo) {
		CotizacionInventario cotizacionInventario = (CotizacionInventario) buscarCotizacionInventario(codigo);
		for(OrdenInventario x: ordenes) {
			if(x instanceof CotizacionInventario) {
				if(x==cotizacionInventario) {
					ordenes.remove(x);
					break;
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
	
	// FUNCIONES DE FACTURACION
	public void generarFactura(Cliente cliente, Empleado empleado, ArrayList<Producto> carrito) {
		OrdenVenta factura = new OrdenVenta(cliente, empleado, carrito);
		retirarFactura(carrito);
		facturas.add(factura);
	}
	public OrdenVenta buscarFactura(String codigo) {
		for(OrdenVenta x: facturas) {
			if(x.getCodigo().equals(codigo)) {
				return x;
			}
		}
		return null;
	}
	public boolean verificarFactura(String codigo) {
		for(OrdenVenta x: facturas) {
			if(x.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}
	public void duplicarFactura(String codigo) {
		OrdenVenta factura = buscarFactura(codigo);
		generarFactura(factura.getCliente(), factura.getEmpleado(), factura.getProductos());
	}
	public void recibirFactura(ArrayList<Producto> carrito) {
		for(Producto x: productos) {
			for(Producto y: carrito) {
				if(x.getCodigo().equals(y.getCodigo())) {
					x.setCantidad(x.getCantidad()+y.getCantidad());
				}
			}
		}
	}
	public void retirarFactura(ArrayList<Producto> carrito) {
		for(Producto x: productos) {
			for(Producto y: carrito) {
				if(x.getCodigo().equals(y.getCodigo())) {
					x.setCantidad(x.getCantidad()-y.getCantidad());
				}
			}
		}
	}
	public void modificarFactura(String codigo, Cliente cliente, Empleado empleado, ArrayList<Producto> carrito) {
		OrdenVenta factura = buscarFactura(codigo);
		recibirFactura(carrito);
		for(OrdenVenta x: facturas) {
			if(x==factura) {
				x.setCliente(cliente);
				x.setEmpleado(empleado);
				x.setProductos(carrito);
			}
		}
	}
	public void eliminarFactura(String codigo) {
		OrdenVenta factura = buscarFactura(codigo);
		facturas.remove(factura);
		retirarFactura(factura.getProductos());
	}

}
