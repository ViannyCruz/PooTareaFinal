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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class regParticipante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JButton cancelButton;
	private JButton okButton;
	private JTextField txtTipo;
	private JTextField txtEspecialidad;
	private JRadioButton rdbtnJurado;
	private JRadioButton rdbtnParticipante;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

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
					lblNewLabel_3.setVisible(true);
					txtTipo.setVisible(true);
					lblNewLabel_4.setVisible(true);
					txtEspecialidad.setVisible(true);
				}
			});
			rdbtnJurado.setSelected(true);
			rdbtnJurado.setBounds(81, 90, 109, 23);
			panel.add(rdbtnJurado);
			
			rdbtnParticipante = new JRadioButton("Participante");
			rdbtnParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnJurado.setSelected(false);
					lblNewLabel_3.setVisible(false);
					txtTipo.setVisible(false);
					lblNewLabel_4.setVisible(false);
					txtEspecialidad.setVisible(false);
				}
			});
			rdbtnParticipante.setBounds(271, 89, 109, 23);
			panel.add(rdbtnParticipante);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 122, 458, 85);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			lblNewLabel_3 = new JLabel("Tipo:");
			lblNewLabel_3.setBounds(12, 10, 56, 22);
			panel_1.add(lblNewLabel_3);
			
			lblNewLabel_4 = new JLabel("Especialidad:");
			lblNewLabel_4.setBounds(12, 53, 82, 22);
			panel_1.add(lblNewLabel_4);
			
			txtTipo = new JTextField();
			txtTipo.setBounds(57, 10, 389, 22);
			panel_1.add(txtTipo);
			txtTipo.setColumns(10);
			
			txtEspecialidad = new JTextField();
			txtEspecialidad.setBounds(105, 53, 341, 22);
			panel_1.add(txtEspecialidad);
			txtEspecialidad.setColumns(10);
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

						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
