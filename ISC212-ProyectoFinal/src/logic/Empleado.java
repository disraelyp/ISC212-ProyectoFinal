package logic;

public class Empleado extends Persona{
	
	protected String codigo;
	protected float sueldo;
	protected float comision;
	protected String usuario;
	protected String contraseña;
	
	public Empleado(String cedula, String nombre, String telefono, String direccion, float sueldo, 
			float comision, String usuario, String contraseña) {
		super(cedula, nombre, telefono, direccion);
		this.codigo = "E-"+Tienda.getInstance().getEmpleados().size();
		this.sueldo = sueldo;
		this.comision = comision;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
