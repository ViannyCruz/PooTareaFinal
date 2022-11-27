package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.CoordinacionEvento;
import logico.Participante;
import logico.Persona;
import logico.TrabajoCientifico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class regTrabajoCientifico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JSpinner spinAo;
	private JSpinner spinMes;
	private JSpinner spinDia;
	private JButton cancelButton;
	private JButton okButton;
	private Persona pers;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regTrabajoCientifico dialog = new regTrabajoCientifico(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regTrabajoCientifico(Persona aux) {
		pers = aux;
		setTitle("Registrar Trabajo");
		setBounds(100, 100, 500, 300);
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
				JLabel lblCodigo = new JLabel("C\u00F3digo:");
				lblCodigo.setBounds(10, 28, 46, 20);
				panel.add(lblCodigo);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(66, 28, 145, 20);
				txtCodigo.setText("Proyecto-"+String.valueOf(CoordinacionEvento.genCodeTrabajo));
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 76, 57, 20);
				panel.add(lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(66, 76, 284, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel lblFecPubl = new JLabel("Fecha de publicaci\u00F3n:");
				lblFecPubl.setBounds(10, 124, 145, 14);
				panel.add(lblFecPubl);
			}

			JLabel lblDia = new JLabel("Dia:");
			lblDia.setBounds(10, 166, 46, 14);
			panel.add(lblDia);

			spinDia = new JSpinner();
			spinDia.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			spinDia.setBounds(45, 163, 63, 20);
			panel.add(spinDia);

			JLabel lblMes = new JLabel("Mes:");
			lblMes.setBounds(126, 166, 46, 14);
			panel.add(lblMes);

			spinMes = new JSpinner();
			spinMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			spinMes.setBounds(168, 163, 63, 20);
			panel.add(spinMes);

			JLabel lblAo = new JLabel("A\u00F1o:");
			lblAo.setBounds(245, 166, 46, 14);
			panel.add(lblAo);

			spinAo = new JSpinner();
			spinAo.setModel(new SpinnerNumberModel(new Integer(1900), new Integer(1900), null, new Integer(1)));
			spinAo.setBounds(287, 163, 63, 20);
			panel.add(spinAo);
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
					public void actionPerformed(ActionEvent arg0) {
						String codigo = txtCodigo.getText();
						String nombre = txtNombre.getText();
						int dia =  Integer.parseInt(spinDia.getValue().toString());
						int mes =  Integer.parseInt(spinMes.getValue().toString());
						int year = Integer.parseInt(spinAo.getValue().toString());

						String fecha = dia+"/"+mes+ "/" +year;
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
						Date fech = null;
						try {
							fech = formatter.parse(fecha);
							
						} catch (ParseException e) {
							e.printStackTrace();
						}

						TrabajoCientifico auxT = new TrabajoCientifico(codigo, nombre, fech);
						
						CoordinacionEvento.getInstance().insertarTrabajo(auxT);
						if(pers!=null)
						{
							((Participante) pers).insertarTrabajo(auxT);
							JOptionPane.showMessageDialog(null, "Registro Satisfactorio del trabajo para el participante "+pers.getNombre()+"!", "Informacion", JOptionPane.INFORMATION_MESSAGE);

						}
						else {
						JOptionPane.showMessageDialog(null, "Registro Satisfactorio del trabajo!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						}
						clean();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void clean() {
		txtCodigo.setText("Proyecto-"+String.valueOf(CoordinacionEvento.genCodeTrabajo));
		txtNombre.setText("");
		spinDia.setValue(new Integer("1"));
		spinMes.setValue(new Integer("1"));
		spinAo.setValue(new Integer("1900"));
	
	}
}
