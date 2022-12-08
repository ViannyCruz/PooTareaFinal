package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Recurso;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class modRecurso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;

	private Recurso recursoAux = null;
	private JComboBox cbxTipo;
	private JButton btnAplicar;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			modRecurso dialog = new modRecurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public modRecurso(Recurso recurso) {
		recursoAux = recurso;
		
		setBounds(100, 100, 432, 164);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 11, 46, 20);
		contentPanel.add(label);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(66, 11, 142, 20);
		contentPanel.add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(66, 52, 342, 20);
		contentPanel.add(txtNombre);
		
		JLabel label_1 = new JLabel("Tipo:");
		label_1.setBounds(230, 11, 46, 20);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setBounds(10, 52, 57, 20);
		contentPanel.add(label_2);
		
		cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Bocina"}));
		cbxTipo.setBounds(263, 11, 145, 20);
		contentPanel.add(cbxTipo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
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
				btnAplicar = new JButton("Aplicar");
				btnAplicar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						modificarInformacion();
						dispose();
					}
				});
				btnAplicar.setActionCommand("Cancel");
				buttonPane.add(btnAplicar);
			}
		}
		loadDatos();
	}
	
	
	public void loadDatos()
	{
		txtCodigo.setText(recursoAux.getCodigo());
		txtNombre.setText(recursoAux.getNombre());
		cbxTipo.setSelectedItem(recursoAux.getTipo());
	}
	
	public void modificarInformacion()
	{
		recursoAux.setNombre(txtNombre.getText());
		recursoAux.setTipo(cbxTipo.getSelectedItem().toString());
	}
}
