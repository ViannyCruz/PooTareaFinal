package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import logico.Jurado;
import logico.Persona;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class modPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JButton btnCancelar;
	private JButton btnAplicarCambios;
	private JComboBox cbxEspecialidad;
	private JTextField txtNombre;

	private Persona personaAux = null;
	private JLabel lblEspecialidad;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			modPersona dialog = new modPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public modPersona(Persona persona) {
		setLocationRelativeTo(null);

		personaAux = persona;
		setBounds(100, 100, 500, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("C\u00E9dula:");
		label.setBounds(10, 11, 46, 20);
		contentPanel.add(label);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(76, 11, 151, 20);
		contentPanel.add(txtCedula);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(76, 42, 398, 20);
		contentPanel.add(txtNombre);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(10, 42, 58, 20);
		contentPanel.add(label_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(313, 11, 161, 20);
		contentPanel.add(txtTelefono);
		
		JLabel label_2 = new JLabel("Tel\u00E9fono:");
		label_2.setBounds(248, 11, 64, 20);
		contentPanel.add(label_2);
		
		lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(10, 73, 82, 22);
		contentPanel.add(lblEspecialidad);
		
		cbxEspecialidad = new JComboBox();
		cbxEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"Matem\u00E1ticas", "F\u00EDsica", "Qu\u00EDmica", "Biolog\u00EDa", "Astronom\u00EDa", "Sociolog\u00EDa", "Ambiental"}));
		cbxEspecialidad.setBounds(76, 73, 398, 22);
		loadDatos();
		
		contentPanel.add(cbxEspecialidad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
			}
			{
				btnAplicarCambios = new JButton("Aplicar");
				btnAplicarCambios.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						modificarDatos();
						
						dispose();
					}
				});
				btnAplicarCambios.setActionCommand("Cancel");
				buttonPane.add(btnAplicarCambios);
			}
		}
	}
	
	public void loadDatos() {
		txtCedula.setText(personaAux.getCedula());
		txtNombre.setText(personaAux.getNombre());
		txtTelefono.setText(personaAux.getNumero());
		
		if(personaAux instanceof Jurado)
		{
			cbxEspecialidad.setVisible(true);
			lblEspecialidad.setVisible(true);
			cbxEspecialidad.setSelectedItem(((Jurado) personaAux).getEspecialidad());
		}else
		{
			cbxEspecialidad.setVisible(false);
			lblEspecialidad.setVisible(false);
		}
			
	}
	
	public void modificarDatos()
	{
		personaAux.setCedula(txtCedula.getText());
		personaAux.setNombre(txtNombre.getText());
		personaAux.setNumero(txtTelefono.getText());
		
		if(personaAux instanceof Jurado)
			((Jurado) personaAux).setEspecialidad(cbxEspecialidad.getSelectedItem().toString());
	}
	
	
}
