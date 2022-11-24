package logico;

import java.util.ArrayList;

public class CoordinacionEvento {
	
	private ArrayList<Evento> eventos;
	private ArrayList<Persona> personas;
	private ArrayList<TrabajoCientifico> trabajosCientificos;
	private ArrayList<Recurso> recursos;
	
	private static CoordinacionEvento coordinacionEventos = null;
	
	public static int genCodeEvento = 1;



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
		genCodeEvento++;
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
	
	public void addRecurso(Recurso recurso) {
		recursos.add(recurso);
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
	
	
	
	
	public Evento getEventoByCode(String codigo)
	{
		Evento eventoAux =  null;
		for (Evento evento : eventos) {
			if(evento.getCodigo().equalsIgnoreCase(codigo))
				eventoAux =  evento;
		}

		return eventoAux;
	}
	
	public Persona getPersonaByCedula(String cedula)
	{
		Persona personaAux =  null;
		for (Persona persona : personas) {
			if(persona.getCedula().equalsIgnoreCase(cedula))
				personaAux =  persona;
		}

		return personaAux;
	}
	
	public Persona getJuradoByCedula(String cedula)
	{
		Persona juradoAux =  null;
		for (Persona persona : personas) {
			if(persona.getCedula().equalsIgnoreCase(cedula))
				if(persona instanceof Jurado)
					juradoAux =  persona;
		}

		return juradoAux;
	}
	
	public Persona getParticipanteByCedula(String cedula)
	{
		Persona participanteAux =  null;
		for (Persona persona : personas) {
			if(persona.getCedula().equalsIgnoreCase(cedula))
				if(persona instanceof Participante)
					participanteAux =  persona;
		}

		return participanteAux;
	}
	
	
	public TrabajoCientifico getTrabajoCientificoByCode(String codigo)
	{
		TrabajoCientifico trabajoAux =  null;
		for (TrabajoCientifico trabajo : trabajosCientificos) {
			if(trabajo.getCodigo().equalsIgnoreCase(codigo))
				trabajoAux =  trabajo;
		}

		return trabajoAux;
	}
	
	public Recurso getRecursoByCode(String codigo)
	{
		Recurso recursoAux =  null;
		for (Recurso recurso : recursos) {
			if(recurso.getCodigo().equalsIgnoreCase(codigo))
				recursoAux =  recurso;
		}

		return recursoAux;
	}
	
	
}
