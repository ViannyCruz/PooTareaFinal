package logico;

import java.util.ArrayList;

public class Participante extends Persona {

	private ArrayList<TrabajoCientifico> trabajos;

	public Participante(String cedula, String nombre, String numero) {
		super(cedula, nombre, numero);

		this.trabajos= new ArrayList<>();
	}


	public ArrayList<TrabajoCientifico> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<TrabajoCientifico> trabajos) {
		this.trabajos = trabajos;
	}

	public void insertarFactura(TrabajoCientifico trabajo) {
		trabajos.add(trabajo);
	}

	public String GetCodTrabajo()
	{
		String aux="";
		for (TrabajoCientifico trabajo : trabajos) {

			aux+=trabajo.getCodigo()+" : "+trabajo.getNombre()+" ";
		}
		return aux;
	}
}
