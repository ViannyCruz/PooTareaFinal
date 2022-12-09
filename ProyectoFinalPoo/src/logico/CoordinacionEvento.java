package logico;

import java.io.DataOutput;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class CoordinacionEvento {
	

	
	private ArrayList<Evento> eventos;
	private ArrayList<Persona> personas;
	private ArrayList<TrabajoCientifico> trabajosCientificos;
	
	private ArrayList<Recurso> recursos;
	
	private static CoordinacionEvento coordinacionEventos = null;
	
	public static int genCodeEvento = 1;
	public static int genCodePersona = 1;
	public static int genCodeTrabajo = 1;
	public static int genCodeRecurso = 1;





	
	
	
	
	
	
	
	
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
	
	public void insertarEvento(Evento evento) {
		eventos.add(evento);	
		genCodeEvento++;
	}
	public void insertarPersona(Persona persona) {
		personas.add(persona);
		genCodePersona++;
	}
	public void insertarTrabajo(TrabajoCientifico trabajo) {
		trabajosCientificos.add(trabajo);
		genCodeTrabajo++;
	}
	public void insertarRecurso(Recurso recurso) {
		recursos.add(recurso);
		genCodeRecurso++;
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
	
	
	public void saveParticipante() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("ParticipantesFile.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(personas);
		oos.close();
	}
	
	public void loadParticipante() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("ParticipantesFile.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);	
		personas = (ArrayList<Persona>) ois.readObject();
		
		ois.close();
	}

	
	
	public void saveRecurso() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("RecursosFile.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(recursos);
		oos.close();
	}
	
	public void loadRecurso() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("RecursosFile.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);	
		recursos = (ArrayList<Recurso>) ois.readObject();
		
		ois.close();
	}

	
	public void saveEvento() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("EventosFile.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(eventos);
		oos.close();
	}
	
	public void loadEvento() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("EventosFile.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);	
		eventos = (ArrayList<Evento>) ois.readObject();
		
		ois.close();
	}


	
}
