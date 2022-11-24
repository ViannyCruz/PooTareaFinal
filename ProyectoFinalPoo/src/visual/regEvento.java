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

public class regEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	
	
	
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
		setBounds(100, 100, 510, 676);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 11, 46, 14);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 39, 59, 14);
			panel.add(lblNewLabel_1);
			
			textField = new JTextField();
			textField.setBounds(70, 8, 163, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(70, 36, 401, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Fecha:");
			lblNewLabel_2.setBounds(260, 11, 46, 14);
			panel.add(lblNewLabel_2);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerDateModel(new Date(1669262400000L), null, null, Calendar.DAY_OF_YEAR));
			spinner.setBounds(308, 8, 163, 20);
			panel.add(spinner);
			
			JLabel lblNewLabel_3 = new JLabel("Tipo:");
			lblNewLabel_3.setBounds(10, 71, 46, 14);
			panel.add(lblNewLabel_3);
			
			textField_2 = new JTextField();
			textField_2.setBounds(70, 68, 163, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Tema:");
			lblNewLabel_4.setBounds(260, 71, 46, 14);
			panel.add(lblNewLabel_4);
			
			textField_3 = new JTextField();
			textField_3.setBounds(308, 67, 163, 20);
			panel.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Ubicacion:");
			lblNewLabel_5.setBounds(10, 99, 82, 14);
			panel.add(lblNewLabel_5);
			
			textField_4 = new JTextField();
			textField_4.setBounds(70, 96, 401, 20);
			panel.add(textField_4);
			textField_4.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 181, 461, 401);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			textField_5 = new JTextField();
			textField_5.setBounds(10, 25, 339, 22);
			panel_1.add(textField_5);
			textField_5.setColumns(10);
			
			JButton btnNewButton = new JButton("Buscar");
			btnNewButton.setBounds(362, 24, 89, 23);
			panel_1.add(btnNewButton);
			
			JLabel lblNewLabel_7 = new JLabel("Buscar jurado por cedula:");
			lblNewLabel_7.setBounds(10, 11, 176, 14);
			panel_1.add(lblNewLabel_7);
			
			JButton btnNewButton_2 = new JButton("Agregar jurado");
			btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnNewButton_2.setBounds(158, 240, 117, 23);
			panel_1.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("Eliminar jurado");
			btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnNewButton_3.setBounds(285, 240, 117, 23);
			panel_1.add(btnNewButton_3);
			
			JLabel lblNewLabel_8 = new JLabel("Nombre:");
			lblNewLabel_8.setBounds(158, 63, 80, 14);
			panel_1.add(lblNewLabel_8);
			
			textField_6 = new JTextField();
			textField_6.setBounds(158, 80, 293, 20);
			panel_1.add(textField_6);
			textField_6.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("Cedula:");
			lblNewLabel_9.setBounds(158, 108, 46, 14);
			panel_1.add(lblNewLabel_9);
			
			textField_7 = new JTextField();
			textField_7.setBounds(158, 124, 191, 20);
			panel_1.add(textField_7);
			textField_7.setColumns(10);
			
			JLabel lblNewLabel_10 = new JLabel("Telefono:");
			lblNewLabel_10.setBounds(158, 153, 67, 14);
			panel_1.add(lblNewLabel_10);
			
			textField_8 = new JTextField();
			textField_8.setBounds(158, 167, 191, 20);
			panel_1.add(textField_8);
			textField_8.setColumns(10);
			
			JLabel lblNewLabel_11 = new JLabel("Especialidad:");
			lblNewLabel_11.setBounds(158, 196, 122, 14);
			panel_1.add(lblNewLabel_11);
			
			textField_9 = new JTextField();
			textField_9.setBounds(158, 209, 191, 20);
			panel_1.add(textField_9);
			textField_9.setColumns(10);
			
			JButton btnNewButton_4 = new JButton("Agregar como Moderador");
			btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnNewButton_4.setBounds(158, 265, 244, 23);
			panel_1.add(btnNewButton_4);
			
			JLabel lblNewLabel_12 = new JLabel("Moderador Actual:");
			lblNewLabel_12.setBounds(10, 356, 122, 14);
			panel_1.add(lblNewLabel_12);
			
			textField_10 = new JTextField();
			textField_10.setBounds(10, 370, 441, 20);
			panel_1.add(textField_10);
			textField_10.setColumns(10);
			
			JLabel lblNewLabel_13 = new JLabel("Jurados actuales");
			lblNewLabel_13.setBounds(10, 63, 117, 14);
			panel_1.add(lblNewLabel_13);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 80, 122, 183);
			panel_1.add(scrollPane);
			
			JList list = new JList();
			scrollPane.setViewportView(list);
			
			JLabel lblAreaDeLa = new JLabel("Area de la comision:");
			lblAreaDeLa.setBounds(10, 315, 122, 14);
			panel_1.add(lblAreaDeLa);
			
			textField_11 = new JTextField();
			textField_11.setBounds(10, 330, 441, 20);
			panel_1.add(textField_11);
			textField_11.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Comision");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_6.setBounds(10, 160, 82, 14);
			panel.add(lblNewLabel_6);
			
			JButton btnNewButton_1 = new JButton("Participantes >");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton_1.setBounds(342, 151, 129, 23);
			panel.add(btnNewButton_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
