package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class regEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JTextField txtTema;
	private JTextField txtUbicacion;
	private JTextField txtBarraBuscar;
	private JTextField txtNombreDos;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtEspecialidad;
	private JTextField txtModeradorActual;
	private JTextField txtAreaDeComision;
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
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 8, 46, 20);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
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
			
			JLabel lblNewLabel_2 = new JLabel("Fecha:");
			lblNewLabel_2.setBounds(260, 8, 46, 20);
			panel.add(lblNewLabel_2);
			
			JSpinner spnFecha = new JSpinner();
			spnFecha.setModel(new SpinnerDateModel(new Date(1669262400000L), null, null, Calendar.DAY_OF_YEAR));
			spnFecha.setBounds(308, 8, 163, 20);
			panel.add(spnFecha);
			
			JLabel lblNewLabel_3 = new JLabel("Tipo:");
			lblNewLabel_3.setBounds(10, 68, 46, 20);
			panel.add(lblNewLabel_3);
			
			txtTipo = new JTextField();
			txtTipo.setBounds(70, 68, 163, 20);
			panel.add(txtTipo);
			txtTipo.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Tema:");
			lblNewLabel_4.setBounds(260, 67, 46, 20);
			panel.add(lblNewLabel_4);
			
			txtTema = new JTextField();
			txtTema.setBounds(308, 67, 163, 20);
			panel.add(txtTema);
			txtTema.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Ubicacion:");
			lblNewLabel_5.setBounds(10, 96, 82, 20);
			panel.add(lblNewLabel_5);
			
			txtUbicacion = new JTextField();
			txtUbicacion.setBounds(70, 96, 401, 20);
			panel.add(txtUbicacion);
			txtUbicacion.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 181, 461, 401);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			txtBarraBuscar = new JTextField();
			txtBarraBuscar.setBounds(10, 25, 339, 22);
			panel_1.add(txtBarraBuscar);
			txtBarraBuscar.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					
				}
			});
			btnBuscar.setBounds(362, 24, 89, 23);
			panel_1.add(btnBuscar);
			
			lblBuscar = new JLabel("Buscar jurado por cedula");
			lblBuscar.setBounds(12, 0, 226, 22);
			panel_1.add(lblBuscar);
			
			btnAgregar = new JButton("Agregar jurado");
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAgregar.setBounds(158, 240, 117, 23);
			panel_1.add(btnAgregar);
			
			btnEliminar = new JButton("Eliminar jurado");
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnEliminar.setBounds(285, 240, 117, 23);
			panel_1.add(btnEliminar);
			
			JLabel lblNombreDos = new JLabel("Nombre:");
			lblNombreDos.setBounds(158, 60, 191, 20);
			panel_1.add(lblNombreDos);
			
			txtNombreDos = new JTextField();
			txtNombreDos.setBounds(158, 80, 293, 20);
			panel_1.add(txtNombreDos);
			txtNombreDos.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(158, 105, 46, 20);
			panel_1.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(158, 124, 191, 20);
			panel_1.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(158, 149, 67, 20);
			panel_1.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(158, 167, 191, 20);
			panel_1.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			lblEspecialidad = new JLabel("Especialidad:");
			lblEspecialidad.setBounds(158, 190, 122, 20);
			panel_1.add(lblEspecialidad);
			
			txtEspecialidad = new JTextField();
			txtEspecialidad.setBounds(158, 209, 191, 20);
			panel_1.add(txtEspecialidad);
			txtEspecialidad.setColumns(10);
			
			btnAgregarComoModerador = new JButton("Agregar como Moderador");
			btnAgregarComoModerador.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAgregarComoModerador.setBounds(158, 277, 244, 23);
			panel_1.add(btnAgregarComoModerador);
			
			lblModeradorActual = new JLabel("Moderador Actual:");
			lblModeradorActual.setBounds(10, 356, 122, 14);
			panel_1.add(lblModeradorActual);
			
			txtModeradorActual = new JTextField();
			txtModeradorActual.setBounds(10, 370, 441, 20);
			panel_1.add(txtModeradorActual);
			txtModeradorActual.setColumns(10);
			
			LBLaCTUALES = new JLabel("Jurados actuales");
			LBLaCTUALES.setBounds(10, 60, 138, 20);
			panel_1.add(LBLaCTUALES);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 80, 136, 220);
			panel_1.add(scrollPane);
			
			JList list = new JList();
			scrollPane.setViewportView(list);
			
			lblAreaDeLaComision = new JLabel("Area de la comision:");
			lblAreaDeLaComision.setBounds(10, 315, 122, 14);
			panel_1.add(lblAreaDeLaComision);
			
			txtAreaDeComision = new JTextField();
			txtAreaDeComision.setBounds(10, 330, 441, 20);
			panel_1.add(txtAreaDeComision);
			txtAreaDeComision.setColumns(10);
			
			btnAgregarParticipante = new JButton("Agregar Participante");
			btnAgregarParticipante.setBounds(158, 241, 191, 23);
			panel_1.add(btnAgregarParticipante);
			btnAgregarParticipante.setVisible(false);

			
			btnEliminarParticipante = new JButton("Eliminar Participante");
			btnEliminarParticipante.setBounds(158, 274, 191, 23);
			panel_1.add(btnEliminarParticipante);
			btnEliminarParticipante.setVisible(false);
			

			
			btnAgregarRecurso = new JButton("Agregar Recurso");
			btnAgregarRecurso.setBounds(158, 241, 191, 23);
			panel_1.add(btnAgregarRecurso);
			btnAgregarRecurso.setVisible(false);

			
			btnEliminarRecurso = new JButton("Eliminar Recurso");
			btnEliminarRecurso.setBounds(158, 274, 191, 23);
			panel_1.add(btnEliminarRecurso);
			btnEliminarRecurso.setVisible(false);

			
			lblTitulo = new JLabel("Comision");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTitulo.setBounds(10, 156, 144, 14);
			panel.add(lblTitulo);
			
			rdbtRecursos = new JRadioButton("Recursos");
			rdbtRecursos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					btnAgregarRecurso.setVisible(true);
					btnEliminarRecurso.setVisible(true);
					
					btnAgregarParticipante.setVisible(false);
					btnEliminarParticipante.setVisible(false);
					
					btnAgregar.setVisible(false);
					btnEliminar.setVisible(false);
					
					rdbtnComision.setSelected(false);
					rdbtnParticipantes.setSelected(false);
					
					lblEspecialidad.setVisible(false);
					txtEspecialidad.setVisible(false);
					
					btnAgregarComoModerador.setVisible(false);
					
					lblAreaDeLaComision.setVisible(false);	
					txtAreaDeComision.setVisible(false);
					
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
			rdbtRecursos.setBounds(389, 151, 82, 23);
			panel.add(rdbtRecursos);
			
			rdbtnParticipantes = new JRadioButton("Participantes");
			rdbtnParticipantes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					btnAgregarParticipante.setVisible(true);
					btnEliminarParticipante.setVisible(true);
					
					btnAgregarRecurso.setVisible(true);
					btnEliminarRecurso.setVisible(true);
			
					btnAgregar.setVisible(false);
					btnEliminar.setVisible(false);
					
					
					
					rdbtnComision.setSelected(false);
					rdbtRecursos.setSelected(false);
					
					lblEspecialidad.setVisible(false);
					txtEspecialidad.setVisible(false);
					
					btnAgregarComoModerador.setVisible(false);
					
					lblAreaDeLaComision.setVisible(false);	
					txtAreaDeComision.setVisible(false);
					
					lblModeradorActual.setVisible(false);
					txtModeradorActual.setVisible(false);
					
					lblBuscar.setText("Buscar participante por cedula");
					lblTitulo.setText("Participantes");
					LBLaCTUALES.setText("Participantes actuales");
				}
			});
			rdbtnParticipantes.setBounds(278, 151, 109, 23);
			panel.add(rdbtnParticipantes);
			
			rdbtnComision = new JRadioButton("Comision");
			rdbtnComision.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					btnAgregarParticipante.setVisible(false);
					btnEliminarParticipante.setVisible(false);
					
					btnAgregarRecurso.setVisible(false);
					btnEliminarRecurso.setVisible(false);
			
					btnAgregar.setVisible(true);
					btnEliminar.setVisible(true);
					
					
					rdbtnParticipantes.setSelected(false);
					rdbtRecursos.setSelected(false);
					
					
					lblEspecialidad.setVisible(true);
					txtEspecialidad.setVisible(true);
					
					btnAgregarComoModerador.setVisible(true);
					
					lblAreaDeLaComision.setVisible(true);	
					txtAreaDeComision.setVisible(true);
					
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
			rdbtnComision.setBounds(183, 151, 93, 23);
			panel.add(rdbtnComision);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cancelar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Registrar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
