package logico;

import java.util.ArrayList;

public class Participante extends Persona {

	private ArrayList<TrabajoCientifico> trabajos;
	
	public Participante(String cedula, String nombre, String numero) {
		super(cedula, nombre, numero);
	
		this.trabajos= new ArrayList<>();
	}

}
