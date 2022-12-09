package visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Comision;
import logico.CoordinacionEvento;
import logico.Persona;
import logico.Recurso;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class verEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtxCodigo;
	private JTextField txtNombre;
	private JTextField txtTema;
	private JTextField textField_3;
	
	private String codigoEvento;
	DefaultListModel modelListParticipantesAct = new DefaultListModel();
	DefaultListModel modelListComisionesAct = new DefaultListModel();
	DefaultListModel modelListRecursosAct = new DefaultListModel();
	
	
	private JSpinner spnFecha;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			verEvento dialog = new verEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public verEvento( String codigo) {
		codigoEvento = codigo;
		load();

		setBounds(100, 100, 508, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel label = new JLabel("Codigo:");
			label.setBounds(10, 11, 46, 20);
			panel.add(label);
			
			txtxCodigo = new JTextField();
			txtxCodigo.setText("Evento-0");
			txtxCodigo.setEditable(false);
			txtxCodigo.setColumns(10);
			txtxCodigo.setBounds(70, 11, 163, 20);
			panel.add(txtxCodigo);
			
			JLabel label_1 = new JLabel("Nombre:");
			label_1.setBounds(10, 39, 59, 20);
			panel.add(label_1);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(70, 39, 401, 20);
			panel.add(txtNombre);
			
			spnFecha = new JSpinner();
			spnFecha.setModel(new SpinnerDateModel(new Date(1670558400000L), null, null, Calendar.DAY_OF_YEAR));
			spnFecha.setBounds(308, 11, 163, 20);
			panel.add(spnFecha);
			
			JLabel label_2 = new JLabel("Fecha:");
			label_2.setBounds(260, 11, 46, 20);
			panel.add(label_2);
			
			JLabel label_3 = new JLabel("Tipo:");
			label_3.setBounds(10, 71, 46, 20);
			panel.add(label_3);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Panel", "Mesa Redonda"}));
			comboBox.setBounds(70, 71, 163, 20);
			panel.add(comboBox);
			
			txtTema = new JTextField();
			txtTema.setColumns(10);
			txtTema.setBounds(308, 70, 163, 20);
			panel.add(txtTema);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(70, 99, 401, 20);
			panel.add(textField_3);
			
			JLabel label_4 = new JLabel("Ubicacion:");
			label_4.setBounds(10, 99, 82, 20);
			panel.add(label_4);
			
			JLabel lblComisiones = new JLabel("Comisiones");
			lblComisiones.setBounds(10, 156, 126, 14);
			panel.add(lblComisiones);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 181, 126, 174);
			panel.add(scrollPane);
			
			JList listComisiones = new JList();
			scrollPane.setViewportView(listComisiones);
			listComisiones.setModel(modelListComisionesAct);
			
			JLabel lblParticipantes = new JLabel("Participantes");
			lblParticipantes.setBounds(164, 156, 107, 14);
			panel.add(lblParticipantes);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(164, 181, 126, 174);
			panel.add(scrollPane_1);
			
			JList listParticipantes = new JList();
			scrollPane_1.setViewportView(listParticipantes);
			listParticipantes.setModel(modelListParticipantesAct);
			
			JLabel lblRecursos = new JLabel("Recursos");
			lblRecursos.setBounds(323, 156, 46, 14);
			panel.add(lblRecursos);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(323, 181, 126, 174);
			panel.add(scrollPane_2);
			
			JList listRecursos = new JList();
			scrollPane_2.setViewportView(listRecursos);
			listRecursos.setModel(modelListRecursosAct);

			
			JLabel lblNewLabel = new JLabel("Tema:");
			lblNewLabel.setBounds(260, 74, 46, 14);
			panel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
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
		load();
	}
	
	
	
	public void load()
	{
		
		for (Persona persona : CoordinacionEvento.getInstance().getPersonas()) {
			if(persona.getCodigoEvento() != null)
			if(persona.getCodigoEvento().equalsIgnoreCase(codigoEvento))
			{
				modelListParticipantesAct.addElement(persona.getCedula());
			}
		}
		
		
		for (Comision comision : CoordinacionEvento.getInstance().getComsiones()) {
			if(comision.getCodigoEvento() != null)
			if(comision.getCodigoEvento().equalsIgnoreCase(codigoEvento))
			{
				modelListComisionesAct.addElement(comision.getCodigo());
			}
		}
	
		
		for (Recurso recurso : CoordinacionEvento.getInstance().getRecursos()) {
			if(recurso.getCodigoEvento() != null)
			if(recurso.getCodigoEvento().equalsIgnoreCase(codigoEvento))
			{
				modelListRecursosAct.addElement(recurso.getCodigo());
			}
		}
	}

	
	
	
}
