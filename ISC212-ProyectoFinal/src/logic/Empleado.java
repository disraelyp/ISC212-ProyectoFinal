package logic;

public class Empleado extends Persona{
	
	protected static int idEmpleado=0;
	
	protected int codigo;
	protected float sueldo;
	protected float comision;
	protected String usuario;
	protected String contraseña;
	
	public Empleado(String cedula, String nombre, String telefono, String direccion, float sueldo, 
			float comision, String usuario, String contraseña) {
		super(cedula, nombre, telefono, direccion);
		this.codigo = idEmpleado;
		idEmpleado++;
		this.sueldo = sueldo;
		this.comision = comision;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
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
