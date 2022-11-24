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
import javax.swing.SpinnerNumberModel;

public class regTrabajoCientifico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regTrabajoCientifico dialog = new regTrabajoCientifico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regTrabajoCientifico() {
		setTitle("Registrar Trabajo");
		setBounds(100, 100, 408, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Codigo:");
				lblNewLabel.setBounds(10, 11, 46, 14);
				panel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setEditable(false);
				textField.setBounds(66, 8, 145, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 36, 46, 14);
				panel.add(lblNewLabel_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(66, 33, 284, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Fecha de publicacion:");
				lblNewLabel_2.setBounds(10, 75, 145, 14);
				panel.add(lblNewLabel_2);
			}
			
			JLabel lblNewLabel_3 = new JLabel("Dia:");
			lblNewLabel_3.setBounds(10, 100, 46, 14);
			panel.add(lblNewLabel_3);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			spinner.setBounds(45, 97, 63, 20);
			panel.add(spinner);
			
			JLabel lblNewLabel_4 = new JLabel("Mes:");
			lblNewLabel_4.setBounds(126, 100, 46, 14);
			panel.add(lblNewLabel_4);
			
			JSpinner spinner_1 = new JSpinner();
			spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			spinner_1.setBounds(168, 97, 63, 20);
			panel.add(spinner_1);
			
			JLabel lblAo = new JLabel("A\u00F1o:");
			lblAo.setBounds(245, 100, 46, 14);
			panel.add(lblAo);
			
			JSpinner spinner_2 = new JSpinner();
			spinner_2.setModel(new SpinnerNumberModel(new Integer(1900), new Integer(1900), null, new Integer(1)));
			spinner_2.setBounds(287, 97, 63, 20);
			panel.add(spinner_2);
		}
		{
			JPanel buttonPane = new JPanel();
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
