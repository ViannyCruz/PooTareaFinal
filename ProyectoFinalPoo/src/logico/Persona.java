package logico;

import java.io.Serializable;

public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;

	protected String cedula;
	protected String nombre;
	protected String numero;
	
	public Persona(String cedula, String nombre, String numero) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.numero = numero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
}
