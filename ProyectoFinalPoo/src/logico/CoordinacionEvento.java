package logico;

import java.util.ArrayList;

public class CoordinacionEvento {
	
	private ArrayList<Evento> eventos;
	private ArrayList<Persona> personas;
	private ArrayList<TrabajoCientifico> trabajosCientificos;
	private ArrayList<Recurso> recursos;
	
	private static CoordinacionEvento coordinacionEventos = null;

	public CoordinacionEvento() {
		super();
		this.eventos = new ArrayList<>();
		this.personas = new ArrayList<>();
		this.trabajosCientificos =new ArrayList<>();
		this.recursos = new ArrayList<>();
	}

	public static CoordinacionEvento getInstance(){
		if(coordinacionEventos == null){
			coordinacionEventos = new CoordinacionEvento();  
		} 	   
		return coordinacionEventos;
	}
	
	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public ArrayList<TrabajoCientifico> getTrabajosCientificos() {
		return trabajosCientificos;
	}

	public void setTrabajosCientificos(ArrayList<TrabajoCientifico> trabajosCientificos) {
		this.trabajosCientificos = trabajosCientificos;
	}

	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	public void insertarFactura(Evento evento) {
		eventos.add(evento);	
	}
	public void insertarFactura(Persona persona) {
		personas.add(persona);
	}
	public void insertarFactura(TrabajoCientifico trabajo) {
		trabajosCientificos.add(trabajo);
	}
	public void insertarFactura(Recurso recurso) {
		recursos.add(recurso);
	}
}
