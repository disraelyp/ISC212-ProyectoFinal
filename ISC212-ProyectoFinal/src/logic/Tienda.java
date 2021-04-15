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
		Producto aux=null;
		for(Producto x: Tienda.getInstance().getProductos()) {
			if(x.getCodigo().equalsIgnoreCase(codigo)) {
				aux=x;
			}
		}
		return aux;
	}
	public void eliminarProducto(String codigo) {
		productos.remove(buscarProducto(codigo));
		JOptionPane.showMessageDialog(null, "El producto (Codigo: "+codigo+") fue eliminado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public Producto clonarProducto(String codigo) {
		Producto producto = buscarProducto(codigo);
		Producto copia=null;
		
		if(producto instanceof PaqueteComponentes) {
    		PaqueteComponentes paqueteComponentes = new PaqueteComponentes(null, null, 0, 0);
    		
    		paqueteComponentes.setAdministrador(((PaqueteComponentes) producto).getAdministrador());
    		paqueteComponentes.setCantidad(producto.getCantidad());
    		paqueteComponentes.setCodigo(producto.getCodigo());
    		paqueteComponentes.setDescuento(((PaqueteComponentes) producto).getDescuento());
    		paqueteComponentes.setProductos(((PaqueteComponentes) producto).getProductos());
    		
    		copia=paqueteComponentes;
    	} else {
    		if(producto instanceof TarjetaMadre) {
    			TarjetaMadre tarjetaMadre = new TarjetaMadre(null, null, 0, 0, 0, 0, 0, 0, null);
    			
    			tarjetaMadre.setCantidad(producto.getCantidad());
    			tarjetaMadre.setCantidadMinima(((TarjetaMadre) producto).getCantidadMinima());
    			tarjetaMadre.setCodigo(producto.getCodigo());
    			tarjetaMadre.setCosto(producto.getCosto());
    			tarjetaMadre.setMarca(((TarjetaMadre) producto).getMarca());
    			tarjetaMadre.setModelo(((TarjetaMadre) producto).getModelo());
    			tarjetaMadre.setPrecio(producto.getPrecio());
    			tarjetaMadre.setTipoDisco(((TarjetaMadre) producto).getTipoDisco());
    			tarjetaMadre.setTipoMicro(((TarjetaMadre) producto).getTipoMicro());
    			tarjetaMadre.setTipoRAM(((TarjetaMadre) producto).getTipoRAM());
    			
    			copia=tarjetaMadre;
    		} else {
    			if(producto instanceof DiscoDuro) {
    				DiscoDuro discoDuro = new DiscoDuro(null, null, 0, 0, 0, 0, 0, 0, 0);
    				
    				discoDuro.setCantidad(producto.getCantidad());
    				discoDuro.setCantidadMinima(((DiscoDuro) producto).getCantidadMinima());
    				discoDuro.setCapacidad(((DiscoDuro) producto).getCapacidad());
    				discoDuro.setCodigo(producto.getCodigo());
    				discoDuro.setCosto(producto.getCosto());
    				discoDuro.setMarca(((DiscoDuro) producto).getMarca());
    				discoDuro.setModelo(((DiscoDuro) producto).getModelo());
    				discoDuro.setPrecio(producto.getPrecio());
    				discoDuro.setRpm(((DiscoDuro) producto).getRpm());
    				discoDuro.setTipo(((DiscoDuro) producto).getTipo());
    				
    				copia=discoDuro;
    			} else {
    				if(producto instanceof Microprocesador) {
    					Microprocesador microprocesador = new Microprocesador(null, null, 0, 0, 0, 0, 0, 0, 0);
 
    					microprocesador.setCantidad(producto.getCantidad());
    					microprocesador.setCantidadMinima(producto.getCantidad());
    					microprocesador.setCodigo(producto.getCodigo());
    					microprocesador.setConexion(((Microprocesador) producto).getConexion());
    					microprocesador.setCosto(producto.getCosto());
    					microprocesador.setMarca(((Microprocesador) producto).getMarca());
    					microprocesador.setModelo(((Microprocesador) producto).getModelo());
    					microprocesador.setNucleos(((Microprocesador) producto).getNucleos());
    					microprocesador.setPrecio(producto.getPrecio());
    					microprocesador.setVelocidad(((Microprocesador) producto).getVelocidad());
    					
    					copia = microprocesador;
    				} else {
    					if(producto instanceof MemoriaRAM) {
    						MemoriaRAM memoriaRAM = new MemoriaRAM(null, null, 0, 0, 0, 0, 0, 0, 0);
    						
    						memoriaRAM.setCantidad(producto.getCantidad());
    						memoriaRAM.setCantidadMinima(((MemoriaRAM) producto).getCantidadMinima());
    						memoriaRAM.setCapacidad(((MemoriaRAM) producto).getCapacidad());
    						memoriaRAM.setCodigo(producto.getCodigo());
    						memoriaRAM.setCosto(producto.getCosto());
    						memoriaRAM.setFrecuencia(((MemoriaRAM) producto).getFrecuencia());
    						memoriaRAM.setMarca(((MemoriaRAM) producto).getMarca());
    						memoriaRAM.setModelo(((MemoriaRAM) producto).getModelo());
    						memoriaRAM.setPrecio(producto.getPrecio());
    						memoriaRAM.setTipo(((MemoriaRAM) producto).getTipo());
    						
    						copia = memoriaRAM;
    					}
    				}
    			}
    		}
    	}
		
		return copia;
	}
	
	// FUNCIONES DE LOS COMPONENTES
	public void generarTarjetaMadre(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, int tipoMicro, int tipoRAM, ArrayList<Integer> tipoDisco) {
		productos.add(new TarjetaMadre(modelo, marca, cantidad, cantidadMinima, precio, costo, tipoMicro, tipoRAM, tipoDisco));
		JOptionPane.showMessageDialog(null, "El componente fue registrado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void generarMicro(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, int conexion, float velocidad, int nucleos) {
		productos.add(new Microprocesador(modelo, marca, cantidad, cantidadMinima, precio, costo, conexion, velocidad, nucleos));
		JOptionPane.showMessageDialog(null, "El componente fue registrado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void generarDiscoDuro(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, float capacidad, int tipo, int rpm) {
		productos.add(new DiscoDuro(modelo, marca, cantidad, cantidadMinima, precio, costo, capacidad, tipo, rpm));
		JOptionPane.showMessageDialog(null, "El componente fue registrado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void generarMemoriaRAM(String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, float capacidad, int tipo, int frecuencia) {
		productos.add(new MemoriaRAM(modelo, marca, cantidad, cantidadMinima, precio, costo, capacidad, tipo, frecuencia));
		JOptionPane.showMessageDialog(null, "El componente fue registrado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
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
	public void modificarDiscoDuro(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo,
			float capacidad, int tipo, int rpm) {
		for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof DiscoDuro) {
				((Componente) x).setModelo(modelo);
				((Componente) x).setMarca(marca);
				x.setCantidad(cantidad);
				((Componente) x).setCantidadMinima(cantidadMinima);
				((Componente) x).setPrecio(precio);
				((Componente) x).setCosto(costo);
				((DiscoDuro) x).setCapacidad(capacidad);
				((DiscoDuro) x).setTipo(tipo);
				((DiscoDuro) x).setRpm(rpm);
				JOptionPane.showMessageDialog(null, "El componente (Codigo: "+x.getCodigo()+") fue modificado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
	}
	public void modificarMicro(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo,
			int conexion, float velocidad, int nucleos) {
		for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof Microprocesador) {
				((Componente) x).setModelo(modelo);
				((Componente) x).setMarca(marca);
				x.setCantidad(cantidad);
				((Componente) x).setCantidadMinima(cantidadMinima);
				((Componente) x).setPrecio(precio);
				((Componente) x).setCosto(costo);
				((Microprocesador) x).setConexion(conexion);
				((Microprocesador) x).setVelocidad(velocidad);
				((Microprocesador) x).setNucleos(nucleos);
				JOptionPane.showMessageDialog(null, "El componente (Codigo: "+x.getCodigo()+") fue modificado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
	}
	public void modificarTarjetaMadre(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo,
			int tipoMicro, int tipoRAM, ArrayList<Integer> tipoDisco) {
		for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof TarjetaMadre) {
				((Componente) x).setModelo(modelo);
				((Componente) x).setMarca(marca);
				x.setCantidad(cantidad);
				((Componente) x).setCantidadMinima(cantidadMinima);
				((Componente) x).setPrecio(precio);
				((Componente) x).setCosto(costo);
				((TarjetaMadre) x).setTipoDisco(tipoDisco);
				((TarjetaMadre) x).setTipoRAM(tipoRAM);
				((TarjetaMadre) x).setTipoMicro(tipoMicro);
				JOptionPane.showMessageDialog(null, "El componente (Codigo: "+x.getCodigo()+") fue modificado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
	}
	public void modificarMemoriaRAM(String codigo, String modelo, String marca, int cantidad, int cantidadMinima, float precio, float costo, 
			float capacidad, int tipo, int frecuencia) {
		for(Producto x: productos) {
			if(x.getCodigo().equalsIgnoreCase(codigo) && x instanceof MemoriaRAM) {
				((Componente) x).setModelo(modelo);
				((Componente) x).setMarca(marca);
				x.setCantidad(cantidad);
				((Componente) x).setCantidadMinima(cantidadMinima);
				((Componente) x).setPrecio(precio);
				((Componente) x).setCosto(costo);
				((MemoriaRAM) x).setTipo(tipo);
				((MemoriaRAM) x).setCapacidad(capacidad);
				((MemoriaRAM) x).setFrecuencia(frecuencia);
				JOptionPane.showMessageDialog(null, "El componente (Codigo: "+x.getCodigo()+") fue modificado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
	}
	
	// FUNCIONES DE LOS PAQUETES DE COMPONENTES
	public void retirarComponente(String codigo) {
		PaqueteComponentes paqueteComponentes = buscarPaqueteComponentes(codigo);
		for(int i=0; i<paqueteComponentes.getCantidad(); i++) {
			for(Producto x: productos) {
				if(x instanceof Componente) {
					for(Componente y: paqueteComponentes.getProductos()) {
						if(x.getCodigo().equalsIgnoreCase(y.getCodigo())) {	
							x.setCantidad(x.getCantidad()-y.getCantidad());
							break;
						}
					}
				}	
				
			}
		}
	}
	public void cargarComponente(String codigo) {
		PaqueteComponentes paqueteComponentes = buscarPaqueteComponentes(codigo);
		for(Producto x: productos) {
			if(x instanceof Componente) {
				for(Componente y: paqueteComponentes.getProductos()) {
					if(x.getCodigo().equalsIgnoreCase(y.getCodigo())) {
						x.setCantidad(x.getCantidad()+y.getCantidad());
					}
				}
			}	
		}
	}
	public boolean verificarPaqueteComponentes(String codigo) {
		for(Producto x: productos) {
			if(x instanceof PaqueteComponentes) {
				if(x.getCodigo().equalsIgnoreCase(codigo)) {
					return true;
				}
			}
		}
		return false;
	}
	public PaqueteComponentes buscarPaqueteComponentes(String codigo) {
		for(Producto x: productos) {
			if(x instanceof PaqueteComponentes) {
				if(x.getCodigo().equalsIgnoreCase(codigo)) {
					return (PaqueteComponentes) x;
				}
			}
		}
		return null;
	}
	public void generarPaqueteComponentes(ArrayList<Componente> producto, float descuento, int cantidad) {
		PaqueteComponentes paqueteComponente = new PaqueteComponentes((Administrador) Tienda.getLoginUser(), producto, descuento, cantidad);
		productos.add(paqueteComponente);
		retirarComponente(paqueteComponente.getCodigo());
		JOptionPane.showMessageDialog(null, "El paquete de componentes fue registrado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void modificarPaqueteComponentes(String codigo, ArrayList<Componente> producto, float descuento, int cantidad) {
		cargarComponente(codigo);
		for(Producto x: productos) {
			if(x instanceof PaqueteComponentes) {
				((PaqueteComponentes) x).setProductos(producto);
				((PaqueteComponentes) x).setDescuento(descuento);
				x.setCantidad(cantidad);
				retirarComponente(codigo);
				JOptionPane.showMessageDialog(null, "El componente (Codigo: "+x.getCodigo()+") fue modificado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
				break;				
			}
		}
	}
	public void eliminarPaqueteComponentes(String codigo) {
		cargarComponente(codigo);
		productos.remove(buscarPaqueteComponentes(codigo));
		JOptionPane.showMessageDialog(null, "El paquete de componentes fue eliminado exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	
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
				return true;
			}
		}
		return false;
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
		JOptionPane.showMessageDialog(null, "La compra fue registrada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public CompraInventario buscarCompraInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof CompraInventario) {
				if((x.getCodigo().equalsIgnoreCase(codigo))) {
					return (CompraInventario) x;
				}
			}
		}
		return null;
	}
	public boolean verificarOrdenInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof CompraInventario) {
				if(((CompraInventario) x).getCodigo().equalsIgnoreCase(codigo)) {
					return true;
				}
			}
		}
		return false;
	}
	public void compraInventarioToDevolucionInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		if(compraInventario.isRecibida()) {
			DevolucionInventario devolucionInventario = new DevolucionInventario(compraInventario.getProveedor(), compraInventario.getFecha(), compraInventario.getAdministrador(), compraInventario.getPlazoPago(), compraInventario.getComponentes());
			ordenes.add(devolucionInventario);
			JOptionPane.showMessageDialog(null, "La compra (codigo: "+codigo+") emitio una devolucion", "Confirmacion", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "La compra (codigo: "+codigo+") no puede emitir una devolucion sin ser recibida", "Error", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	public void recibirCompraInventario(String codigo) {
		CompraInventario compraInventario = (CompraInventario) buscarCompraInventario(codigo);
		if(!compraInventario.isRecibida()) {
			for(Producto x: productos) {
				for(Componente y: compraInventario.getComponentes()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						((Componente) (x)).setCantidad(((Componente) (x)).getCantidad()+y.getCantidad());
					}
				}
			}
			buscarCompraInventario(codigo).setRecibida(true);
			JOptionPane.showMessageDialog(null, "La orden ("+codigo+") fue recibida exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "La orden ("+codigo+") no puede ser recibida multiples veces.", "Error", JOptionPane.ERROR_MESSAGE);
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
	}
	public void modificarCompraInventario(String codigo, Proveedor proveedor, Administrador administrador, int plazoPago, Date fecha, ArrayList<Componente> componentes) {
		buscarCompraInventario(codigo).setAdministrador(administrador);
		buscarCompraInventario(codigo).setProveedor(proveedor);
		buscarCompraInventario(codigo).setComponentes(componentes);
		buscarCompraInventario(codigo).setPlazoPago(plazoPago);
		buscarCompraInventario(codigo).setPagada(false);
		buscarCompraInventario(codigo).setFecha(fecha);
		buscarCompraInventario(codigo).setRecibida(false);
		JOptionPane.showMessageDialog(null, "La compra (codigo: "+codigo+") fue modificada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void eliminarCompraInventario(String codigo) {
		ordenes.remove((OrdenInventario) buscarCompraInventario(codigo));
		JOptionPane.showMessageDialog(null, "La compra (codigo: "+codigo+") fue eliminada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}

	// FUNCIONES DE DEVOLUCION DE INVENTARIO
	public void generarDevolucionInventario(Proveedor proveedor, Administrador administrador, int plazoPago, Date fecha, ArrayList<Componente> componentes) {
		DevolucionInventario devolucionInventario = new DevolucionInventario(proveedor, fecha, administrador, plazoPago, componentes);
		ordenes.add(devolucionInventario);
		JOptionPane.showMessageDialog(null, "La devolucion fue registrada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public DevolucionInventario buscarDevolucionInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof DevolucionInventario) {
				if(((DevolucionInventario) x).getCodigo().equalsIgnoreCase(codigo)) {
					return (DevolucionInventario) x;
				}
			}
		}
		return null;
	}
	public boolean verificarDevolucionInventario(String codigo) {
		for(OrdenInventario x: ordenes) {
			if(x instanceof DevolucionInventario) {
				if(((DevolucionInventario) x).getCodigo().equalsIgnoreCase(codigo)) {
					return true;
				}
			}
		}
		return false;
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
		buscarDevolucionInventario(codigo).setRetirada(true);
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
	public void modificarDevolucionInventario(String codigo, Proveedor proveedor, Administrador administrador, int plazoPago, Date fecha, ArrayList<Componente> componentes) {
		buscarDevolucionInventario(codigo).setAdministrador(administrador);
		buscarDevolucionInventario(codigo).setComponentes(componentes);
		buscarDevolucionInventario(codigo).setFecha(fecha);
		buscarDevolucionInventario(codigo).setPlazoPago(plazoPago);
		buscarDevolucionInventario(codigo).setProveedor(proveedor);
		buscarDevolucionInventario(codigo).setRetirada(false);
		JOptionPane.showMessageDialog(null, "La devolucion (codigo: "+codigo+") fue modificada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void eliminarDevolucionInventario(String codigo) {
		ordenes.remove( buscarDevolucionInventario(codigo));
		JOptionPane.showMessageDialog(null, "La devolucion (codigo: "+codigo+") fue eliminada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	
	// FUNCIONES DE COTIZACION DE INVENTARIO
	public void generarCotizacionInventario(Proveedor proveedor, Administrador administrador, int plazoPago, Date fecha, ArrayList<Componente> componentes) {
		ordenes.add(new CotizacionInventario(proveedor, fecha, administrador, plazoPago, componentes));
		JOptionPane.showMessageDialog(null, "La cotizacion fue registrada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
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
					return true;
				}
			}
		}
		return false;
	}
	public void cotizacionInventarioToCompraInventario(String codigo) {
		CotizacionInventario cotizacionInventario = (CotizacionInventario) buscarCotizacionInventario(codigo);
		generarCompraInventario(cotizacionInventario.getProveedor(), cotizacionInventario.getAdministrador(), cotizacionInventario.getPlazoPago(), cotizacionInventario.getFecha(), cotizacionInventario.getComponentes());
	}
	public void eliminarCotizacionInventario(String codigo) {
		ordenes.remove(buscarCotizacionInventario(codigo));
		JOptionPane.showMessageDialog(null, "La cotizacion (codigo: "+codigo+") fue eliminada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void modificarCotizacionInventario(String codigo, Proveedor proveedor, Administrador administrador, int plazoPago, Date fecha, ArrayList<Componente> componentes) {
		buscarCotizacionInventario(codigo).setAdministrador(administrador);
		buscarCotizacionInventario(codigo).setProveedor(proveedor);
		buscarCotizacionInventario(codigo).setComponentes(componentes);
		buscarCotizacionInventario(codigo).setPlazoPago(plazoPago);
		buscarCotizacionInventario(codigo).setFecha(fecha);
		JOptionPane.showMessageDialog(null, "La cotizacion (codigo: "+codigo+") fue modificada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	
	
	
	
	// FUNCIONES DE FACTURAS DE VENTAS
	public void generarFacturaVenta(Cliente cliente, Empleado empleado, Date fecha, int plazoPago, ArrayList<Producto> productos) {
		FacturaVenta venta = new FacturaVenta(cliente, empleado, fecha, plazoPago, productos);
		facturas.add(venta);
		retirarVenta(venta.getCodigo());
		JOptionPane.showMessageDialog(null, "La venta fue registrada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public FacturaVenta buscarFacturaVenta(String codigo) {
		for(OrdenVenta x: facturas) {
			if(x instanceof FacturaVenta) {
				if((x.getCodigo().equalsIgnoreCase(codigo))) {
					return (FacturaVenta) x;
				}
			}
		}
		return null;
	}
	public boolean verificarFacturaVenta(String codigo) {
		for(OrdenVenta x: facturas) {
			if(x instanceof FacturaVenta) {
				if((x.getCodigo().equalsIgnoreCase(codigo))) {
					return true;
				}
			}
		}
		System.out.printf("a");
		return false;
	}
	public void facturaVentaToDevolucionVenta(String codigo) {
		FacturaVenta venta = buscarFacturaVenta(codigo);
		DevolucionVenta devolucion = new DevolucionVenta(venta.getCliente(), venta.getEmpleado(), venta.getFecha(), venta.getPlazoPago(), venta.getProductos());
		facturas.add(devolucion);
		JOptionPane.showMessageDialog(null, "La venta (codigo: "+codigo+") emitio una devolucion", "Confirmacion", JOptionPane.WARNING_MESSAGE);

	}
	public void retirarVenta(String codigo) {
		FacturaVenta compraInventario = buscarFacturaVenta(codigo);
		for(Producto x: productos) {
			for(Producto y: compraInventario.getProductos()) {
				if(x.getCodigo().equals(y.getCodigo())) {
					x.setCantidad(x.getCantidad()-y.getCantidad());
				}
			}
		}
	}
	
	
	// FUNCIONES DE DEVOLUCION DE VENTA
	public void generarDevolucionVenta(Cliente cliente, Empleado empleado, Date fecha, int plazoPago, ArrayList<Producto> productos) {
		DevolucionVenta devolucionInventario = new DevolucionVenta(cliente, empleado, fecha, plazoPago, productos);
		facturas.add(devolucionInventario);
		JOptionPane.showMessageDialog(null, "La devolucion fue registrada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public DevolucionVenta buscarDevolucionVenta(String codigo) {
		for(OrdenVenta x: facturas) {
			if(x instanceof DevolucionVenta) {
				if(((DevolucionVenta) x).getCodigo().equalsIgnoreCase(codigo)) {
					return (DevolucionVenta) x;
				}
			}
		}
		return null;
	}
	public boolean verificarDevolucionVenta(String codigo) {
		for(OrdenVenta x: facturas) {
			if(x instanceof DevolucionVenta) {
				if(((DevolucionVenta) x).getCodigo().equalsIgnoreCase(codigo)) {
					return true;
				}
			}
		}
		return false;
	}
	public void recibirDevolucionVenta(String codigo) {
		DevolucionVenta devolucionVenta = buscarDevolucionVenta(codigo);
		if(!devolucionVenta.isRecibida()) {
			for(Producto x: productos) {
				for(Producto y: devolucionVenta.getProductos()) {
					if(x.getCodigo().equals(y.getCodigo())) {
						x.setCantidad(x.getCantidad()+y.getCantidad());
					}
				}
			}
		}
		buscarDevolucionVenta(codigo).setRecibida(true);
	}
	public void modificarDevolucionVenta(String codigo,Cliente cliente, Empleado empleado, Date fecha, int plazoPago, ArrayList<Producto> producto) {
		buscarDevolucionVenta(codigo).setCliente(cliente);
		buscarDevolucionVenta(codigo).setEmpleado(empleado);
		buscarDevolucionVenta(codigo).setFecha(fecha);
		buscarDevolucionVenta(codigo).setProductos(productos);
		buscarDevolucionVenta(codigo).setPlazoPago(plazoPago);
		JOptionPane.showMessageDialog(null, "La devolucion (codigo: "+codigo+") fue modificada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void eliminarDevolucionVenta(String codigo) {
		facturas.remove(buscarDevolucionVenta(codigo));
		JOptionPane.showMessageDialog(null, "La devolucion (codigo: "+codigo+") fue eliminada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}

	// FUNCIONES DE COTIZACION DE VENTAS
	public void generarCotizacionVenta(Cliente cliente, Empleado empleado, Date fecha, int plazoPago, ArrayList<Producto> productos) {
		facturas.add(new CotizacionVenta(cliente, empleado, fecha, plazoPago, productos));
		JOptionPane.showMessageDialog(null, "La cotizacion fue registrada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public CotizacionVenta buscarCotizacionVenta(String codigo) {
		for(OrdenVenta x: facturas) {
			if(x instanceof CotizacionVenta) {
				if(x.getCodigo().equalsIgnoreCase(codigo)) {
					return (CotizacionVenta) x;
				}
			}
		}
		return null;
	}
	public boolean verificarCotizacionVenta(String codigo) {
		for(OrdenVenta x: facturas) {
			if(x instanceof CotizacionVenta) {
				if(x.getCodigo().equalsIgnoreCase(codigo)) {
					return true;
				}
			}
		}
		return false;
	}
	public void cotizacioVentaToCompraVenta(String codigo) {
		CotizacionVenta cotizacionInventario = (CotizacionVenta) buscarCotizacionVenta(codigo);
		generarFacturaVenta(cotizacionInventario.getCliente(), cotizacionInventario.getEmpleado(), cotizacionInventario.getFecha(), cotizacionInventario.getPlazoPago(), cotizacionInventario.getProductos());
	}
	public void eliminarCotizacionVenta(String codigo) {
		facturas.remove(buscarCotizacionVenta(codigo));
		JOptionPane.showMessageDialog(null, "La cotizacion (codigo: "+codigo+") fue eliminada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	public void modificarCotizacionVenta(String codigo, Cliente cliente, Empleado empleado, Date fecha, int plazoPago, ArrayList<Producto> productos) {
		buscarCotizacionVenta(codigo).setCliente(cliente);
		buscarCotizacionVenta(codigo).setEmpleado(empleado);
		buscarCotizacionVenta(codigo).setFecha(fecha);
		buscarCotizacionVenta(codigo).setProductos(productos);
		buscarCotizacionVenta(codigo).setPlazoPago(plazoPago);
		JOptionPane.showMessageDialog(null, "La cotizacion (codigo: "+codigo+") fue modificada exitosamente.", "Confirmacion", JOptionPane.WARNING_MESSAGE);
	}
	
	public Boolean isCotizacioVentaToCompraVenta(String codigo) {
		CotizacionVenta cotizacion = buscarCotizacionVenta(codigo);
		for(Producto x: productos) {
			for(Producto y: cotizacion.getProductos()) {
				if(x.getCodigo().equals(y.getCodigo())) {
					if(x.getCantidad()<y.getCantidad()) {
						return false;
					}
				}
				
			}
		}
		return true;
	}

}
