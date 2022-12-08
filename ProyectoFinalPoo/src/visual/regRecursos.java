package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import logico.CoordinacionEvento;
import logico.Recurso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class regRecursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JComboBox cbxTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regRecursos dialog = new regRecursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regRecursos() {
		setTitle("Registrar recurso");
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCodigo = new JLabel("C\u00F3digo:");
			lblCodigo.setBounds(10, 21, 46, 20);
			panel.add(lblCodigo);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(66, 21, 142, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 62, 57, 20);
				panel.add(lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(66, 62, 342, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
				
				txtNombre.getDocument().addDocumentListener(new DocumentListener() {
					
					@Override
					public void removeUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
						
						habilitarRegistrar();
					}
					
					@Override
					public void insertUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
						habilitarRegistrar();

					}
					
					@Override
					public void changedUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
						habilitarRegistrar();

					}
				});
				
				
				
			}
			{
				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(230, 21, 46, 20);
				panel.add(lblTipo);
			}
			
			cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Bocina"}));
			cbxTipo.setBounds(260, 21, 148, 20);
			panel.add(cbxTipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();	
					}
				});
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
			}
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setEnabled(false);
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					Recurso recursoAux = new Recurso(txtCodigo.getText(), txtNombre.getText(), cbxTipo.getSelectedItem().toString());
					CoordinacionEvento.getInstance().insertarRecurso(recursoAux);
					dispose();	
					
					}
				});
				btnRegistrar.setActionCommand("Cancel");
				buttonPane.add(btnRegistrar);
			}
			
			
			
			
		}
		
	
	}
	
	
	
	
	private void habilitarRegistrar() {
		
		if(txtNombre.getText().equals(""))
			btnRegistrar.setEnabled(false);
		else
			btnRegistrar.setEnabled(true);
	
	}
}
