package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

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
	public void generarTarjetaMadre(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, 
			int tipoMicro, int tipoRAM, ArrayList<Integer> tipoDisco) {
		TarjetaMadre componente = new TarjetaMadre(modelo, marca, cantidad, cantidadMinima, precio, costo, tipoMicro, tipoRAM, tipoDisco);
		productos.add(componente);
	}
	public void generarMicro(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, 
			int conexion, float velocidad, int nucleos) {
		Microprocesador componente = new Microprocesador(modelo, marca, cantidad, cantidadMinima, precio, costo, conexion, velocidad, nucleos);
		productos.add(componente);
	}
	public void generarDiscoDuro(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, 
			float capacidad, int tipo, int rpm) {
		DiscoDuro componente = new DiscoDuro(modelo, marca, cantidad, cantidadMinima, precio, costo, capacidad, tipo, rpm);
		productos.add(componente);
	}
	public void generarMemoriaRAM(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, 
			float capacidad, int tipo, int frecuencia) {
		MemoriaRAM componente = new MemoriaRAM(modelo, marca, cantidad, cantidadMinima, precio, costo, capacidad, tipo, frecuencia);
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
	public void modificarTarjetaMadre(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, 
			int tipoMicro, int tipoRAM, ArrayList<Integer> tipoDisco) {
		/*for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof TarjetaMadre) {
				x.setCodigo(codigo);
				x.setModelo(modelo);
				x.setMarca(marca);
				x.setCantidad(cantidad);
				x.setCantidadMinima(cantidadMinima);
				x.setPrecio(precio);
				x.setCosto(costo);
				x.setTipoMicro(tipoMicro);
				x.setTipoRAM(tipoRAM);
				x.setTipoDisco(tipoDisco);
			}
		}*/
	}
	public void modificarMicro(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, 
			int conexion, float velocidad, int nucleos) {
		/*for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof TarjetaMadre) {
				x.setCodigo(codigo);
				x.setModelo(modelo);
				x.setMarca(marca);
				x.setCantidad(cantidad);
				x.setCantidadMinima(cantidadMinima);
				x.setPrecio(precio);
				x.setCosto(costo);
				x.setTipoMicro(conexion);
				x.setTipoRAM(velocidad);
				x.setTipoDisco(nucleos);
			}
		}*/
	}
	public void modificarDiscoDuro(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, 
			float capacidad, int tipo, int rpm) {
		/*for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof TarjetaMadre) {
				x.setCodigo(codigo);
				x.setModelo(modelo);
				x.setMarca(marca);
				x.setCantidad(cantidad);
				x.setCantidadMinima(cantidadMinima);
				x.setPrecio(precio);
				x.setCosto(costo);
				x.setTipoMicro(capacidad);
				x.setTipoRAM(tipo);
				x.setTipoDisco(rpm);
			}
		}*/
	}
	public void modificarMemoriaRAM(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, 
			float capacidad, int tipo, int frecuencia) {
		for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof MemoriaRAM) {
				((Componente) x).setModelo(modelo);
				((Componente) x).setMarca(marca);
				((Componente) x).setCantidad(cantidad);
				((Componente) x).setCantidadMinima(cantidadMinima);
				((Componente) x).setPrecio(precio);
				((Componente) x).setCosto(costo);
				((MemoriaRAM) x).setTipo(tipo);
				((MemoriaRAM) x).setCapacidad(capacidad);
				((MemoriaRAM) x).setFrecuencia(frecuencia);
			}
		}
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
	public boolean verificarEmpleado(String codigo) {
		for(Empleado x: empleados) {
			if(x.getCodigo().equalsIgnoreCase(codigo)) {
				return false;
			}
		}
		return true;
	}
	public Empleado buscarEmpleado(String codigo) {
		for(Empleado x: empleados) {
			if(x.getCodigo().equalsIgnoreCase(codigo)) {
				return x;
			}
		}
		return null;
	}
	public void eliminarEmpleado(String codigo) {
		empleados.remove(buscarEmpleado(codigo));
		JOptionPane.showMessageDialog(null, "El empleado (Codigo: "+codigo+") fue eliminado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void modificarEmpleado(String codigo, String cedula, String nombre, String telefono, String direccion, float sueldo, float comision, String usuario, String contraseña) {
		for(Empleado x: empleados) {
			if(x.getCodigo().equalsIgnoreCase(codigo)) {
				x.setCedula(cedula);
				x.setComision(comision);
				x.setContraseña(contraseña);
				x.setUsuario(usuario);
				x.setDireccion(direccion);
				x.setSueldo(sueldo);
				x.setTelefono(telefono);
				x.setNombre(nombre);
				JOptionPane.showMessageDialog(null, "El empleado (Codigo: "+codigo+") fue modificado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
	}
	
	// FUNCIONES DE LOS VENDEDORES
	public void generarVendedor(String cedula, String nombre, String telefono, String direccion, float sueldo, float comision, String usuario, String contraseña) {
		empleados.add(new Empleado(cedula, nombre, telefono, direccion, sueldo, comision, usuario, contraseña));
	}
	public boolean verificarVendedor(String codigo) {
		for(Empleado x: empleados) {
			if((x.getCodigo().equalsIgnoreCase(codigo)) && !(x instanceof Administrador)) {
				return true;
			}
		}
		return false;
	}
	public Empleado buscarVendedor(String codigo) {
		for(Empleado x: empleados) {
			if((x.getCodigo().equalsIgnoreCase(codigo)) && !(x instanceof Administrador)) {
				return x;
			}
		}
		return null;
	}
	
	//FUNCIONES DE ADMINISTRADORES
	public void generarAdministrador(String cedula, String nombre, String telefono, String direccion, float sueldo, float comision, String usuario, String contraseña) {
		empleados.add(new Administrador(cedula, nombre, telefono, direccion, sueldo, comision, usuario, contraseña));
	}
	public boolean verificarAdministrador(String codigo) {
		for(Empleado x: empleados) {
			if((x.getCodigo().equalsIgnoreCase(codigo)) && (x instanceof Administrador)) {
				return true;
			}
		}
		return false;
	}
	public Administrador buscarAdministrador(String codigo) {
		for(Empleado x: empleados) {
			if((x.getCodigo().equalsIgnoreCase(codigo)) && (x instanceof Administrador)) {
				return (Administrador) x;
			}
		}
		return null;
	}
	
	//FUNCIONES DE CLIENTES
	public void generarCliente(String cedula, String nombre, String telefono, String direccion,	float creditoLimite) {
		clientes.add(new Cliente(cedula, nombre, telefono, direccion,	creditoLimite));
		JOptionPane.showMessageDialog(null, "El cliente fue registrado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
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
	public void modificarCliente(String cedula, String nombre, String telefono, String direccion,	float creditoLimite) {
		for(Cliente x: clientes) {
			if(x.getCedula().equalsIgnoreCase(cedula)) {
				x.setCreditoLimite(creditoLimite);
				x.setNombre(nombre);
				x.setTelefono(telefono);
				x.setDireccion(direccion);
				JOptionPane.showMessageDialog(null, "El cliente (Cedula: "+cedula+") fue modificado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
	}
	public void eliminarCliente(String cedula) {
		clientes.remove(buscarCliente(cedula));
		JOptionPane.showMessageDialog(null, "El cliente (Cedula: "+cedula+") fue eliminado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	
	// FUNCIONES DE PROVEEDORES
	public void generarProveedor(String rnc, String nombre, String telefono, String direccion, String nombreRepre, String telefonoRepre) {
		proveedores.add(new Proveedor(rnc, nombre, telefono, direccion, nombreRepre, telefonoRepre));
		JOptionPane.showMessageDialog(null, "El proveedor fue registrado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public boolean verificarRnc(String rnc) {
		for(Proveedor x: proveedores) {
			if(x.getRnc().equals(rnc)) {
				return true;
			}
		}
		return false;
	}
	public Proveedor buscarProveedor(String rnc) {
		for(Proveedor x: proveedores) {
			if(x.getRnc().equalsIgnoreCase(rnc)) {
				return x;
			}
		}
		return null;
	}
	public void modificarProveedor(String rnc, String nombre, String telefono, String direccion, String nombreRepre, String telefonoRepre) {
		for(Proveedor x: proveedores) {
			if(x.getRnc().equalsIgnoreCase(rnc)) {
				x.setNombre(nombre);
				x.setTelefono(telefono);
				x.setDireccion(direccion);
				x.setNombreRepre(nombreRepre);
				x.setTelefonoRepre(telefonoRepre);
				JOptionPane.showMessageDialog(null, "El proveedor (RNC: "+rnc+") fue modificado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
	}
	public void eliminarProveedor(String rnc) {
		proveedores.remove(buscarProveedor(rnc));
		JOptionPane.showMessageDialog(null, "El proveedor (RNC: "+rnc+") fue eliminado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
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
