package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.ControlLogin;
import logico.CoordinacionEvento;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class regUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtnUser;
	private JTextField txtContrs;
	private JTextField txtConfContrs;
	private JComboBox cbxTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regUsuario dialog = new regUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regUsuario() {
		setTitle("Registrar/Iniciar Sesion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre Usuario:");
			lblNewLabel.setBounds(16, 30, 104, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_1.setBounds(16, 76, 78, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Confirmar Contrase\u00F1a:");
			lblNewLabel_2.setBounds(16, 122, 131, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Tipo:");
			lblNewLabel_3.setBounds(16, 168, 35, 16);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtnUser = new JTextField();
			txtnUser.setBounds(136, 27, 278, 22);
			contentPanel.add(txtnUser);
			txtnUser.setColumns(10);
		}
		{
			txtContrs = new JTextField();
			txtContrs.setBounds(106, 73, 308, 22);
			contentPanel.add(txtContrs);
			txtContrs.setColumns(10);
		}
		{
			txtConfContrs = new JTextField();
			txtConfContrs.setBounds(159, 119, 255, 22);
			contentPanel.add(txtConfContrs);
			txtConfContrs.setColumns(10);
		}
		{
			cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Participante/Jurado"}));
			cbxTipo.setBounds(63, 165, 351, 22);
			contentPanel.add(cbxTipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario user = new Usuario(cbxTipo.getSelectedItem().toString(),txtnUser.getText(),txtContrs.getText());
					    ControlLogin.getInstance().regUsuario(user);
						JOptionPane.showMessageDialog(null, "Usuario "+cbxTipo.getSelectedItem().toString()+" creado con exito!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        clean();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void clean() {
		txtnUser.setText("");
		txtContrs.setText("");
		txtConfContrs.setText("");
		cbxTipo.setSelectedIndex(0);
	
	}

}
