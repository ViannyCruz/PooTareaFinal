package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import logico.Comision;
import logico.CoordinacionEvento;
import logico.Evento;
import logico.Jurado;
import logico.Participante;
import logico.Persona;
import logico.Recurso;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class regEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTema;
	private JTextField txtUbicacion;
	private JTextField txtBarraBuscar;
	private JTextField txtNombreDos;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtModeradorActual;
	private JRadioButton rdbtnComision;
	private JRadioButton rdbtnParticipantes;
	private JRadioButton rdbtRecursos;
	private JButton btnBuscar;
	private JButton btnAgregarComoModerador;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JLabel lblAreaDeLaComision;
	private JLabel lblModeradorActual;
	private JLabel lblEspecialidad;
	private JLabel LBLaCTUALES;
	private JLabel lblBuscar;
	private JLabel lblTitulo;
	private JButton btnAgregarParticipante;
	private JButton btnEliminarParticipante;
	private JButton btnAgregarRecurso;
	private JButton btnEliminarRecurso;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JSpinner spnFecha;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNombreDos;
	private JLabel lblCedula;
	private JLabel lblTelefono;
	private JScrollPane scrollPane;
	
	
	
	private String Area;
	private Jurado moderador = null;
	
	private ArrayList<Persona> personas =  new ArrayList<>();
	private ArrayList<Recurso> recursos = new ArrayList<>();
	private ArrayList<Comision> comisiones = new ArrayList<>();
	
	Jurado juradoAux = null;
	Participante participanteAux = null;
	Recurso recursoAux = null;
	int i = 0;
	
	
	DefaultListModel modelListParticipantesAct = new DefaultListModel();
	DefaultListModel modelListJuradosAct = new DefaultListModel();
	DefaultListModel modelListRecursosAct = new DefaultListModel();

	int selectedIndex = 0;

	private JList list;
	private JComboBox cbxEspecialidad;
	private JComboBox cbxArea;
	private JButton btnLimpiarCampos;
	private JButton btnVerComisiones;
	private JButton btnAgregarComison;
	private JComboBox cbxTipo;
	private JComboBox cbxTipoEvento;
	private JButton btnRegistrar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regEvento dialog = new regEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regEvento() {
		
		setBounds(100, 100, 530, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 8, 46, 20);
			panel.add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 36, 59, 20);
			panel.add(lblNewLabel_1);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(70, 8, 163, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(70, 36, 401, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			txtNombre.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
			});
			
			lblNewLabel_2 = new JLabel("Fecha:");
			lblNewLabel_2.setBounds(260, 8, 46, 20);
			panel.add(lblNewLabel_2);
			
			spnFecha = new JSpinner();
			spnFecha.setModel(new SpinnerDateModel(new Date(1669262400000L), null, null, Calendar.DAY_OF_YEAR));
			spnFecha.setBounds(308, 8, 163, 20);
			panel.add(spnFecha);
			
			lblNewLabel_3 = new JLabel("Tipo:");
			lblNewLabel_3.setBounds(10, 68, 46, 20);
			panel.add(lblNewLabel_3);
			
			lblNewLabel_4 = new JLabel("Tema:");
			lblNewLabel_4.setBounds(260, 67, 46, 20);
			panel.add(lblNewLabel_4);
			
			txtTema = new JTextField();
			txtTema.setBounds(308, 67, 163, 20);
			panel.add(txtTema);
			txtTema.setColumns(10);
			txtTema.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
			});
			
			lblNewLabel_5 = new JLabel("Ubicacion:");
			lblNewLabel_5.setBounds(10, 96, 82, 20);
			panel.add(lblNewLabel_5);
			
			txtUbicacion = new JTextField();
			txtUbicacion.setBounds(70, 96, 401, 20);
			panel.add(txtUbicacion);
			txtUbicacion.setColumns(10);
			txtUbicacion.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
			});		
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 181, 461, 432);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			txtBarraBuscar = new JTextField();
			txtBarraBuscar.setBounds(10, 25, 247, 22);
			panel_1.add(txtBarraBuscar);
			txtBarraBuscar.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(rdbtnComision.isSelected() == true)
					{
						for (Persona persona : CoordinacionEvento.getInstance().getPersonas()) 
						{
							if(persona instanceof Jurado)
								if(persona.getCedula().equalsIgnoreCase(txtBarraBuscar.getText()))
								{
									clearComision();
									txtNombreDos.setText(persona.getNombre());
									txtCedula.setText(persona.getCedula());
									txtTelefono.setText(persona.getNumero());
									cbxEspecialidad.setSelectedItem(juradoAux.getEspecialidad().toString());
									
									txtNombreDos.setEditable(false);
									txtCedula.setEditable(false);
									txtTelefono.setEditable(false);
									cbxEspecialidad.setEditable(false);
									
									juradoAux =  (Jurado) persona;
								}
								
								else
								{
									juradoAux = null;
									clearComision();
									txtNombreDos.setEditable(true);
									txtCedula.setEditable(true);
									txtTelefono.setEditable(true);
									cbxEspecialidad.setEditable(true);
								}
						}
					}
					else if(rdbtnParticipantes.isSelected() == true)
					{
						for (Persona persona : CoordinacionEvento.getInstance().getPersonas()) 
						{
							if(persona instanceof Participante)
								if(persona.getCedula().equalsIgnoreCase(txtBarraBuscar.getText()))
								{
									clearComision();
									txtNombreDos.setText(persona.getNombre());
									txtCedula.setText(persona.getCedula());
									txtTelefono.setText(persona.getNumero());
									
									txtNombreDos.setEditable(false);
									txtCedula.setEditable(false);
									txtTelefono.setEditable(false);
									
									participanteAux =  (Participante) persona;
								}
								
								else
								{
									participanteAux = null;
									clearComision();
									txtNombreDos.setEditable(true);
									txtCedula.setEditable(true);
									txtTelefono.setEditable(true);
								}
						}
						
						
						
						
						
						
						
					}
					
				}
			});
			btnBuscar.setBounds(267, 25, 89, 23);
			panel_1.add(btnBuscar);
			
			lblBuscar = new JLabel("Buscar jurado por cedula");
			lblBuscar.setBounds(12, 0, 226, 22);
			panel_1.add(lblBuscar);
			
			btnAgregar = new JButton("Agregar jurado");
			btnAgregar.setEnabled(false);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					habilitarAgregarComision();

					Jurado nuevoJurado = null;
					int existe = 0;
					
					// Ya tengo un jurado
					if(juradoAux != null)
					{
						
						for (Persona persona : personas) 
						{
							if(txtCedula.getText().equalsIgnoreCase(persona.getCedula()))
								existe = 1;
						}
						
						
						if(existe == 0)
						{
						
							modelListJuradosAct.addElement(juradoAux.getCedula());
							personas.add(juradoAux);
							juradoAux = null;
						}
						
						
					}
					else 
					{
						
						for (Persona persona : personas) 
						{
							if(txtCedula.getText().equalsIgnoreCase(persona.getCedula()))
								existe = 1;
						}
						
						//Si no existe uno con la misma cedula
						//Entonces ese jurado es valido
						if(existe != 1)
						{
							juradoAux = new Jurado(txtCedula.getText(), txtNombreDos.getText(), txtTelefono.getText(), cbxEspecialidad.getSelectedItem().toString());
							modelListJuradosAct.addElement(juradoAux.getCedula());
							CoordinacionEvento.getInstance().getPersonas().add(juradoAux);
							personas.add(juradoAux);
							juradoAux =  null;
						}
						
					}
					
					btnAgregar.setEnabled(false);
					clearComision();
					habilitarRegistrarEvento();

				}
			});
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAgregar.setBounds(158, 240, 117, 23);
			panel_1.add(btnAgregar);
			
			btnEliminar = new JButton("Eliminar jurado");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					habilitarAgregarComision();

					selectedIndex = list.getSelectedIndex();
					if (selectedIndex != -1) {
						
						//Eliminar de la ArrayList
						juradoAux = (Jurado) CoordinacionEvento.getInstance().getPersonaByCedula((String) modelListJuradosAct.getElementAt(selectedIndex));
						personas.remove(juradoAux);
						
						//Eliminar de la lista
						selectedIndex = list.getSelectedIndex();
						modelListJuradosAct.remove(selectedIndex);
						
						if(moderador == juradoAux)
							moderador = null;
						
						juradoAux = null;
						clearComision();
						list.setSelectedIndex(-1);
					}
					clearComision();
						

				}
			});
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnEliminar.setBounds(285, 240, 117, 23);
			panel_1.add(btnEliminar);
			
			lblNombreDos = new JLabel("Nombre:");
			lblNombreDos.setBounds(158, 60, 191, 20);
			panel_1.add(lblNombreDos);
			
			txtNombreDos = new JTextField();
			txtNombreDos.setBounds(158, 80, 293, 20);
			panel_1.add(txtNombreDos);
			txtNombreDos.setColumns(10);
			txtNombreDos.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitar();
					habilitarAgregarComision();
					
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitar();
					habilitarAgregarComision();


				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitar();
					habilitarAgregarComision();


				}
			});
			
			lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(158, 105, 46, 20);
			panel_1.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(158, 124, 191, 20);
			panel_1.add(txtCedula);
			txtCedula.setColumns(10);
			txtCedula.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitar();
					habilitarAgregarComision();


				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitar();
					habilitarAgregarComision();


				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitar();
					habilitarAgregarComision();


				}
			});
			
			lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(158, 148, 67, 20);
			panel_1.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(158, 167, 191, 20);
			panel_1.add(txtTelefono);
			txtTelefono.setColumns(10);
			txtTelefono.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitar();
					habilitarAgregarComision();


				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitar();
					habilitarAgregarComision();


				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitar();
					habilitarAgregarComision();


				}
			});
			
			lblEspecialidad = new JLabel("Especialidad:");
			lblEspecialidad.setBounds(158, 190, 122, 20);
			panel_1.add(lblEspecialidad);
			
			btnAgregarComoModerador = new JButton("Agregar como Moderador");
			btnAgregarComoModerador.setEnabled(false);
			btnAgregarComoModerador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Jurado nuevoJurado = null;
					int existe = 0;
					
					// Ya tengo un jurado
					if(juradoAux != null)
					{
						
						for (Persona persona : personas) 
						{
							if(txtCedula.getText().equalsIgnoreCase(persona.getCedula()))
								existe = 1;
						}
						
						
						if(existe == 1)
						{
							moderador = juradoAux;
							txtModeradorActual.setText(moderador.getNombre());
							juradoAux = null;
							existe = 0;
						}
						else
						{
							modelListJuradosAct.addElement(juradoAux.getCedula());
							personas.add(juradoAux);
							moderador = juradoAux;
							txtModeradorActual.setText(moderador.getNombre());
							juradoAux = null;
						}
						
						
						
						
						
						
						
					}
					else 
					{
						
						for (Persona persona : personas) 
						{
							if(txtCedula.getText().equalsIgnoreCase(persona.getCedula()))
								existe = 1;
						}
						
						
						if(existe != 1)
						{
							juradoAux = new Jurado(txtCedula.getText(), txtNombreDos.getText(), txtTelefono.getText(), cbxEspecialidad.getSelectedItem().toString());
							modelListJuradosAct.addElement(juradoAux.getCedula());
							CoordinacionEvento.getInstance().getPersonas().add(juradoAux);
							personas.add(juradoAux);
							moderador = juradoAux;
							txtModeradorActual.setText(moderador.getNombre());
							
							juradoAux =  null;
						}
						
					}
					

					
					
					
					
					
					
					habilitarAgregarComision();

					
				}
			});
			btnAgregarComoModerador.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAgregarComoModerador.setBounds(158, 277, 244, 23);
			panel_1.add(btnAgregarComoModerador);
			
			lblModeradorActual = new JLabel("Moderador Actual:");
			lblModeradorActual.setBounds(10, 356, 122, 14);
			panel_1.add(lblModeradorActual);
			
			txtModeradorActual = new JTextField();
			txtModeradorActual.setEnabled(false);
			txtModeradorActual.setBounds(10, 370, 441, 20);
			panel_1.add(txtModeradorActual);
			txtModeradorActual.setColumns(10);
			txtModeradorActual.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					habilitarRegistrarEvento();

				}
			});
			
			LBLaCTUALES = new JLabel("Jurados actuales");
			LBLaCTUALES.setBounds(10, 60, 138, 20);
			panel_1.add(LBLaCTUALES);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 80, 136, 220);
			panel_1.add(scrollPane);
			
			list = new JList();
			scrollPane.setViewportView(list);
			list.setModel(modelListJuradosAct);
			list.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					habilitarAgregarComision();
					selectedIndex = list.getSelectedIndex();
					
					if(selectedIndex != -1)
					{
						if(rdbtnComision.isSelected() == true)
						{
							juradoAux = (Jurado) CoordinacionEvento.getInstance().getJuradoByCedula(modelListJuradosAct.getElementAt(list.getSelectedIndex()).toString());
							putDatos(juradoAux);
							list.setSelectedIndex(-1);
							
							txtNombreDos.setEditable(false);
							txtCedula.setEditable(false);
							txtTelefono.setEditable(false);
							cbxEspecialidad.setEditable(false);
						}else if(rdbtnParticipantes.isSelected() == true)
						{
							participanteAux = (Participante) CoordinacionEvento.getInstance().getParticipanteByCedula(list.getSelectedValue().toString());
							putDatos(participanteAux);
							list.setSelectedIndex(-1);
							
							txtNombreDos.setEditable(false);
							txtCedula.setEditable(false);
							txtTelefono.setEditable(false);
							cbxEspecialidad.setEditable(false);
						}
						

					}
					
					
					
					
				}
				
				
				
			});

			
			lblAreaDeLaComision = new JLabel("Area de la comision:");
			lblAreaDeLaComision.setBounds(10, 315, 122, 14);
			panel_1.add(lblAreaDeLaComision);
			
			btnAgregarParticipante = new JButton("Agregar Participante");
			btnAgregarParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				
						Participante nuevoParticipante = null;
						int existe = 0;
						
						// Ya tengo un jurado
						if(juradoAux != null)
						{
							
							for (Persona persona : personas) 
							{
								if(txtCedula.getText().equalsIgnoreCase(persona.getCedula()))
									existe = 1;
							}
							
							
							if(existe == 0)
							{
							
								modelListParticipantesAct.addElement(participanteAux.getCedula());
								personas.add(participanteAux);
								participanteAux = null;
							}
							
							
						}
						else 
						{
							
							for (Persona persona : personas) 
							{
								if(txtCedula.getText().equalsIgnoreCase(persona.getCedula()))
									existe = 1;
							}
							
							//Si no existe uno con la misma cedula
							//Entonces ese jurado es valido
							if(existe != 1)
							{
								participanteAux = new Participante(txtCedula.getText(), txtNombreDos.getText(), txtTelefono.getText());
								modelListParticipantesAct.addElement(participanteAux.getCedula());
								CoordinacionEvento.getInstance().getPersonas().add(participanteAux);
								personas.add(participanteAux);
								participanteAux =  null;
							}
							
						}
						
						
						
					btnAgregarParticipante.setEnabled(false);
					
					clearComision();
					habilitarRegistrarEvento();

					
				}
			});
			btnAgregarParticipante.setBounds(158, 241, 191, 23);
			panel_1.add(btnAgregarParticipante);
			btnAgregarParticipante.setVisible(false);

			
			btnEliminarParticipante = new JButton("Eliminar Participante");
			btnEliminarParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					selectedIndex = list.getSelectedIndex();
					if (selectedIndex != -1) {
						
						//Eliminar de la ArrayList
						participanteAux = (Participante) CoordinacionEvento.getInstance().getParticipanteByCedula((String) modelListParticipantesAct.getElementAt(selectedIndex));
						personas.remove(participanteAux);
						
						//Eliminar de la lista
						selectedIndex = list.getSelectedIndex();
						modelListParticipantesAct.remove(selectedIndex);
						
	
						participanteAux = null;
						clearComision();
						list.setSelectedIndex(-1);
					}
					clearComision();
					
				}
			});
			btnEliminarParticipante.setBounds(158, 274, 191, 23);
			panel_1.add(btnEliminarParticipante);
			btnEliminarParticipante.setVisible(false);
			

			
			btnAgregarRecurso = new JButton("Agregar Recurso");
			btnAgregarRecurso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Recurso nuevoRecurso = null;
					int existe = 0;
					
					if(recursoAux != null)
					{
						
						for (Recurso recurso : recursos) 
						{
							if(txtCedula.getText().equalsIgnoreCase(recurso.getCodigo()))
								existe = 1;
						}
						
						
						if(existe == 0)
						{
						
							modelListRecursosAct.addElement(recursoAux.getCodigo());
							recursos.add(recursoAux);
							recursoAux = null;
						}
						
						
					}
					else 
					{
						
						for (Recurso recurso : recursos) 
						{
							if(txtCedula.getText().equalsIgnoreCase(recurso.getCodigo()))
								existe = 1;
						}

						if(existe != 1)
						{
							recursoAux = new Recurso(txtCedula.getText(), txtNombreDos.getText(),cbxTipo.getSelectedItem().toString());
							modelListRecursosAct.addElement(recursoAux.getCodigo());
							CoordinacionEvento.getInstance().getRecursos().add(recursoAux);
							recursos.add(recursoAux);
							recursoAux =  null;
						}
						
					}
					
					clearComision();
					
					
				}
			});
			btnAgregarRecurso.setBounds(158, 241, 191, 23);
			panel_1.add(btnAgregarRecurso);
			btnAgregarRecurso.setVisible(false);

			
			btnEliminarRecurso = new JButton("Eliminar Recurso");
			btnEliminarRecurso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					selectedIndex = list.getSelectedIndex();
					if (selectedIndex != -1) {
						
						//Eliminar de la ArrayList
						recursoAux = (Recurso) CoordinacionEvento.getInstance().getRecursoByCode((String) modelListRecursosAct.getElementAt(selectedIndex));
						recursos.remove(recursoAux);
						
						//Eliminar de la lista
						selectedIndex = list.getSelectedIndex();
						modelListRecursosAct.remove(selectedIndex);
						
						
						recursoAux = null;
						clearComision();
						list.setSelectedIndex(-1);
					}
					clearComision();
						
					
				}
			});
			btnEliminarRecurso.setBounds(158, 274, 191, 23);
			panel_1.add(btnEliminarRecurso);
			
			btnLimpiarCampos = new JButton("Limpiar");
			btnLimpiarCampos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					clearComision();
					juradoAux = null;
					//list.setSelectedIndex(-1);
				}
			});
			btnLimpiarCampos.setBounds(362, 25, 89, 23);
			panel_1.add(btnLimpiarCampos);
			
			cbxEspecialidad = new JComboBox();
			cbxEspecialidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					habilitar();
				}
			});
			cbxEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"Matem\u00E1ticas", "F\u00EDsica", "Qu\u00EDmica", "Biolog\u00EDa", "Astronom\u00EDa", "Sociolog\u00EDa", "Ambiental"}));
			cbxEspecialidad.setBounds(158, 209, 191, 20);
			panel_1.add(cbxEspecialidad);
			
			cbxArea = new JComboBox();
			cbxArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					habilitar();
				}
			});
			cbxArea.setModel(new DefaultComboBoxModel(new String[] {"Matem\u00E1ticas", "F\u00EDsica", "Qu\u00EDmica", "Biolog\u00EDa", "Astronom\u00EDa", "Sociolog\u00EDa", "Ambiental"}));
			cbxArea.setBounds(10, 329, 441, 20);
			panel_1.add(cbxArea);
			
			btnVerComisiones = new JButton("Ver comisiones");
			btnVerComisiones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					verComisiones verComisionesAux = new verComisiones(comisiones);
					verComisionesAux.setVisible(true);
					
					
					
				}
			});
			btnVerComisiones.setBounds(10, 398, 138, 23);
			panel_1.add(btnVerComisiones);
			
			btnAgregarComison = new JButton("Agregar comision");
			btnAgregarComison.setEnabled(false);
			btnAgregarComison.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				//Agregar comision
				Comision comisionAux = new Comision(cbxArea.getSelectedItem().toString(), moderador);
				comisiones.add(comisionAux);
				
				ArrayList<Jurado> jurados =  new ArrayList<>();
				
				for (Persona persona : personas) {
					if(persona instanceof Jurado)
					{
						jurados.add((Jurado) persona);
						modelListJuradosAct.removeElement(persona.getCedula());
					}
				}
				
				comisionAux.setJurados(jurados);
				habilitarAgregarComision();
				moderador = null;
				clearComision();	
				btnAgregarComison.setEnabled(false);

					
					
					
					
					
					
					
					
					
					
				}
			});
			btnAgregarComison.setBounds(156, 398, 138, 23);
			panel_1.add(btnAgregarComison);
			
			cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Bocina"}));
			cbxTipo.setBounds(158, 167, 191, 20);
			panel_1.add(cbxTipo);
			btnEliminarRecurso.setVisible(false);

			
			lblTitulo = new JLabel("Comision");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTitulo.setBounds(10, 156, 144, 14);
			panel.add(lblTitulo);
			
			rdbtRecursos = new JRadioButton("Recursos");
			rdbtRecursos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					btnVerComisiones.setVisible(false);
					btnAgregarComison.setVisible(false);
					
					
					clearComision();
					list.setModel(modelListRecursosAct);

					cbxTipo.setVisible(true);
					txtTelefono.setVisible(false);
					
					cbxArea.setVisible(false);
					btnAgregarRecurso.setVisible(true);
					btnEliminarRecurso.setVisible(true);
					
					btnAgregarParticipante.setVisible(false);
					btnEliminarParticipante.setVisible(false);
					
					btnAgregar.setVisible(false);
					btnEliminar.setVisible(false);
					
					rdbtnComision.setSelected(false);
					rdbtnParticipantes.setSelected(false);
					
					lblEspecialidad.setVisible(false);
					cbxEspecialidad.setVisible(false);
					
					btnAgregarComoModerador.setVisible(false);
					
					lblAreaDeLaComision.setVisible(false);	
					
					lblModeradorActual.setVisible(false);
					txtModeradorActual.setVisible(false);
					
					lblBuscar.setText("Buscar recurso por codigo");
					lblTitulo.setText("Recursos");
					LBLaCTUALES.setText("Recursos actuales");
					
					
					lblNombreDos.setText("Codigo del Recurso");
					lblCedula.setText("Nombre");
					lblTelefono.setText("Tipo");
					
					
				}
			});
			rdbtRecursos.setBounds(401, 151, 82, 23);
			panel.add(rdbtRecursos);
			
			rdbtnParticipantes = new JRadioButton("Participantes");
			rdbtnParticipantes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					clearComision();
					list.setModel(modelListParticipantesAct);
					
					btnVerComisiones.setVisible(false);
					btnAgregarComison.setVisible(false);
					cbxTipo.setVisible(false);
					cbxTipoEvento.setVisible(true);
					cbxArea.setVisible(false);
					
					btnAgregarParticipante.setVisible(true);
					btnEliminarParticipante.setVisible(true);
					
					btnAgregarRecurso.setVisible(true);
					btnEliminarRecurso.setVisible(true);
			
					btnAgregar.setVisible(false);
					btnEliminar.setVisible(false);
					txtTelefono.setVisible(true);
					
					
					rdbtnComision.setSelected(false);
					rdbtRecursos.setSelected(false);
					
					lblEspecialidad.setVisible(false);
					cbxEspecialidad.setVisible(false);
					
					btnAgregarComoModerador.setVisible(false);
					
					lblAreaDeLaComision.setVisible(false);	
					cbxEspecialidad.setVisible(false);
					
					lblModeradorActual.setVisible(false);
					txtModeradorActual.setVisible(false);
					
					lblNombreDos.setText("Nombre");
					lblCedula.setText("Cedula");
					lblBuscar.setText("Buscar participante por cedula");
					lblTitulo.setText("Participantes");
					LBLaCTUALES.setText("Participantes actuales");
				}
			});
			rdbtnParticipantes.setBounds(290, 151, 109, 23);
			panel.add(rdbtnParticipantes);
			
			rdbtnComision = new JRadioButton("Comision");
			rdbtnComision.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					clearComision();
					list.setModel(modelListJuradosAct);
					cbxArea.setVisible(true);

					btnVerComisiones.setVisible(true);
					btnAgregarComison.setVisible(true);
					
					cbxTipo.setVisible(false);
					cbxTipoEvento.setVisible(true);
					
					txtTelefono.setVisible(true);
					btnAgregarParticipante.setVisible(false);
					btnEliminarParticipante.setVisible(false);
					
					btnAgregarRecurso.setVisible(false);
					btnEliminarRecurso.setVisible(false);
			
					btnAgregar.setVisible(true);
					btnEliminar.setVisible(true);
					
					
					rdbtnParticipantes.setSelected(false);
					rdbtRecursos.setSelected(false);
					
					
					lblEspecialidad.setVisible(true);
					cbxEspecialidad.setVisible(true);
					
					btnAgregarComoModerador.setVisible(true);
					
					lblAreaDeLaComision.setVisible(true);	
					cbxEspecialidad.setVisible(true);
					
					lblModeradorActual.setVisible(true);
					txtModeradorActual.setVisible(true);
					
					lblBuscar.setText("Buscar jurado por cedula");
					lblTitulo.setText("Comision");
					LBLaCTUALES.setText("Jurados actuales");
					
					
					lblNombreDos.setText("Nombre:");
					lblCedula.setText("Cedula:");
					lblTelefono.setText("Telefono:");
					
				}
			});
			rdbtnComision.setSelected(true);
			rdbtnComision.setBounds(195, 151, 93, 23);
			panel.add(rdbtnComision);
			
			cbxTipoEvento = new JComboBox();
			cbxTipoEvento.setModel(new DefaultComboBoxModel(new String[] {"Panel", "Mesa Redonda"}));
			cbxTipoEvento.setBounds(70, 68, 163, 20);
			panel.add(cbxTipoEvento);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
			}
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Evento eventoAux = new Evento(txtCodigo.getText(), txtNombre.getText(), (Date) spnFecha.getValue(), "12",txtUbicacion.getText(), cbxTipo.getSelectedItem().toString(), txtTema.getText());
						
						// Agregar evento
						CoordinacionEvento.getInstance().getEventos().add(eventoAux);
						
			
						btnRegistrar.setEnabled(false);
					}
				});
				btnRegistrar.setEnabled(false);
				btnRegistrar.setActionCommand("Cancel");
				buttonPane.add(btnRegistrar);
			}
		}
	}
	
	public int getcantJurados()
	{
		int cantJurados = 0;
		for (Persona persona : personas) {
			if(persona instanceof Jurado)
				cantJurados++;
		}
		
		return cantJurados;
	}
	
	public int getcantParticipantes()
	{
		int cantParticipantes = 0;
		for (Persona persona : personas) {
			if(persona instanceof Participante)
				cantParticipantes++;
		}
		
		return cantParticipantes;
	}
	
	public int getCantComisiones()
	{
		int cantComisiones = 0;
		for (Comision comision : comisiones) {
				cantComisiones++;
		}
		
		return cantComisiones;
	}
	
	
	public void habilitarAgregarRecurso()
	{
		
	}
	
	public void habilitarRegistrarEvento()
	{
		btnRegistrar.setEnabled(false);

		if(txtNombre.getText().equals("") == false && txtUbicacion.getText().equals("") == false && txtTema.getText().equals("") == false)
				if(getCantComisiones() != 0) 
					if(getcantParticipantes() != 0)
						btnRegistrar.setEnabled(true);

				
	}
	
	public void habilitarAgregarComision()
	{
		if(txtModeradorActual.getText().equals("") || getcantJurados() < 3)
			btnAgregarComison.setEnabled(false);
		else
			btnAgregarComison.setEnabled(true);
	}
	
	public void habilitar()
	{
		if(txtNombreDos.getText().equals("") || txtCedula.getText().equals("") || txtTelefono.getText().equals(""))
		{
			btnAgregar.setEnabled(false);
			btnAgregarComoModerador.setEnabled(false);
			
			btnAgregarParticipante.setEnabled(false);
			btnAgregarRecurso.setEnabled(false);
		}
		else
		{
			if(txtNombreDos.isEnabled() == true)
			{
				btnAgregar.setEnabled(true);
				btnAgregarParticipante.setEnabled(true);
				btnAgregarRecurso.setEnabled(true);
			}
			
			if(juradoAux != null)
			{
				if(cbxArea.getSelectedItem().toString().equalsIgnoreCase(cbxEspecialidad.getSelectedItem().toString()))
				{
					btnAgregarComoModerador.setEnabled(true);
				}
				else
					btnAgregarComoModerador.setEnabled(false);
			}
							
		}
	}
	
	public void clearComision()
	{
		txtNombreDos.setText("");
		txtCedula.setText("");
		txtTelefono.setText("");
		cbxEspecialidad.setSelectedIndex(0);
		
		txtNombreDos.setEditable(true);
		txtCedula.setEditable(true);
		txtTelefono.setEditable(true);
		cbxEspecialidad.setEditable(true);
		
	}
	
	public void putDatos(Persona persona)
	{
		
		clearComision();
		txtNombreDos.setText(persona.getNombre());
		txtCedula.setText(persona.getCedula());
		txtTelefono.setText(persona.getNumero());
		
		if(persona instanceof Jurado)
			cbxEspecialidad.setSelectedItem(((Jurado) persona).getEspecialidad());
		
	}
}
