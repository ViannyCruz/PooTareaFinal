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

public class regRecursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JButton btnCancelar;
	private JButton btnRegistrar;

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
		setBounds(100, 100, 450, 178);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 14, 46, 14);
			panel.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(66, 11, 142, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 45, 46, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(66, 42, 342, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
				
				txtNombre.getDocument().addDocumentListener(new DocumentListener() {
					
					@Override
					public void removeUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
						
						//habilitarRegistrar();
					}
					
					@Override
					public void insertUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
						habilitarRegistrar();

					}
					
					@Override
					public void changedUpdate(DocumentEvent arg0) {
						// TODO Auto-generated method stub
						//habilitarRegistrar();

					}
				});
				
				
				
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tipo:");
				lblNewLabel_2.setBounds(230, 14, 46, 14);
				panel.add(lblNewLabel_2);
			}
			{
				txtTipo = new JTextField();
				txtTipo.setBounds(266, 11, 142, 20);
				panel.add(txtTipo);
				txtTipo.setColumns(10);
			}
		}
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
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setEnabled(false);
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					Recurso recursoAux = new Recurso(txtCodigo.getText(), txtNombre.getText(), txtTipo.getText());
						
						
					}
				});
				btnRegistrar.setActionCommand("Cancel");
				buttonPane.add(btnRegistrar);
			}
			
			
			
			
		}
		
	
	}
	
	
	
	
	private void habilitarRegistrar() {
		
		//if(txtCodigo.getText().isEmpty() == true)
		btnRegistrar.setEnabled(true);
		
		
		
	}
	
	
	
}
