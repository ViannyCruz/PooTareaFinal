package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.CoordinacionEvento;
import logico.Jurado;
import logico.Participante;
import logico.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class regParticipante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JButton cancelButton;
	private JButton okButton;
	private JRadioButton rdbtnJurado;
	private JRadioButton rdbtnParticipante;
	private JLabel lblNewLabel_4;
	private JComboBox cbxEspecialidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regParticipante dialog = new regParticipante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regParticipante() {
		setTitle("Registro de Persona");
		setBounds(100, 100, 508, 312);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("C\u00E9dula:");
				lblNewLabel.setBounds(10, 8, 46, 20);
				panel.add(lblNewLabel);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(66, 8, 161, 20);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 49, 58, 20);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tel\u00E9fono:");
				lblNewLabel_2.setBounds(248, 8, 64, 20);
				panel.add(lblNewLabel_2);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setBounds(313, 8, 161, 20);
				panel.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(66, 49, 408, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}

			rdbtnJurado = new JRadioButton("Jurado");
			rdbtnJurado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnParticipante.setSelected(false);
					lblNewLabel_4.setEnabled(true);
					cbxEspecialidad.setEnabled(true);
				}
			});
			rdbtnJurado.setSelected(true);
			rdbtnJurado.setBounds(81, 90, 109, 23);
			panel.add(rdbtnJurado);

			rdbtnParticipante = new JRadioButton("Participante");
			rdbtnParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnJurado.setSelected(false);
					lblNewLabel_4.setEnabled(false);
					cbxEspecialidad.setEnabled(false);
				}
			});
			rdbtnParticipante.setBounds(271, 89, 109, 23);
			panel.add(rdbtnParticipante);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 122, 458, 85);
			panel.add(panel_1);
			panel_1.setLayout(null);

			lblNewLabel_4 = new JLabel("Especialidad:");
			lblNewLabel_4.setBounds(12, 13, 82, 22);
			panel_1.add(lblNewLabel_4);

			cbxEspecialidad = new JComboBox();
			cbxEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"Matem\u00E1ticas", "F\u00EDsica", "Qu\u00EDmica", "Biolog\u00EDa", "Astronom\u00EDa", "Sociolog\u00EDa", "Ambiental"}));
			cbxEspecialidad.setBounds(106, 13, 340, 22);
			panel_1.add(cbxEspecialidad);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Cancelar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Registrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Persona aux = null;

						String cedula = txtCedula.getText();
						String nombre = txtNombre.getText();
						String telefono = txtTelefono.getText();
						String especialidad = cbxEspecialidad.getSelectedItem().toString();

						if(rdbtnJurado.isSelected())
						{
							aux = new Jurado (cedula, nombre, telefono, especialidad);
							JOptionPane.showMessageDialog(null, "Jurado creado con exito!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						}
						if(rdbtnParticipante.isSelected())
						{
                            aux = new Participante (cedula, nombre, telefono);
						int option;
							option = JOptionPane.showConfirmDialog(null, "Participante creado con exito! Desea agregarle un Trabajo Cientifico?", "Confirmación", JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.OK_OPTION){
							   regTrabajoCientifico regTrabajo = new regTrabajoCientifico(aux);
							   regTrabajo.setModal(true);
							   regTrabajo.setVisible(true);
							
						}
							}
						CoordinacionEvento.getInstance().insertarPersona(aux);
						clean();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	private void clean() {
		txtCedula.setText("");
	    txtNombre.setText("");
	    txtTelefono.setText("");
	    cbxEspecialidad.setSelectedIndex(0);
		rdbtnParticipante.setSelected(false);
		rdbtnJurado.setSelected(true);
		rdbtnParticipante.setSelected(false);
		lblNewLabel_4.setEnabled(true);
		cbxEspecialidad.setEnabled(true);
		
	}
}
