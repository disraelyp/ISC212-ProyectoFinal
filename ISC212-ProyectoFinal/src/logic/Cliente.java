package logic;

public class Cliente extends Persona{
	// Padre: Persona
	private float credito;
	private float creditoLimite;
	
	public Cliente(String cedula, String nombre, String telefono, String direccion, float credito,
			float creditoLimite) {
		super(cedula, nombre, telefono, direccion);
		this.credito = credito;
		this.creditoLimite = creditoLimite;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	public float getCreditoLimite() {
		return creditoLimite;
	}

	public void setCreditoLimite(float creditoLimite) {
		this.creditoLimite = creditoLimite;
	}
	
	
	
}
