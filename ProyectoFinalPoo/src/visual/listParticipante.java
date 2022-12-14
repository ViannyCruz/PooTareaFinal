package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.CoordinacionEvento;
import logico.Jurado;
import logico.Participante;
import logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listParticipante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Persona selected = null;
	private JButton btnRevisado;

	Participante participanteAux =  null;
	private JButton btnModificar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			listParticipante dialog = new listParticipante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public listParticipante() throws ClassNotFoundException, IOException {

		CoordinacionEvento.getInstance().loadParticipante();
		CoordinacionEvento.getInstance().saveParticipante();

		setTitle("Lista de personas");
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			model = new DefaultTableModel();
			String[] columnas = {"Cedula", "Nombre", "Telefono", "Especialidad", "Trabajos"};
			model.setColumnIdentifiers(columnas);
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected>=0){
								btnModificar.setEnabled(true);
								//btnRevisado.setEnabled(true);
								//selected = CoordinacionEvento.getInstance().getPersonaByCedula(table.getValueAt(rowSelected, 0).toString());
								selected = CoordinacionEvento.getInstance().getPersonaByCedula(table.getValueAt(table.getSelectedRow(), 0).toString());

							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Revisado");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnModificar = new JButton("Modificar");
					btnModificar.setEnabled(false);
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							modPersona modPersonaAux = new modPersona(selected);
							modPersonaAux.setModal(true);
							modPersonaAux.setVisible(true);
							dispose();

						}
					});
					buttonPane.add(btnModificar);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{

			}
		}

		loadPersonas();
	}

	public static void loadPersonas() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Persona persona :  CoordinacionEvento.getInstance().getPersonas()) {
			if(persona instanceof Jurado) {
				rows[0] = persona.getCedula();
				rows[1]	= persona.getNombre();
				rows[2] = persona.getNumero();	
				rows[3] = ((Jurado) persona).getEspecialidad();
				rows[4] = "";
				model.addRow(rows);
			}
			if(persona instanceof Participante)
			{
				rows[0] = persona.getCedula();
				rows[1]	= persona.getNombre();
				rows[2] = persona.getNumero();	
				rows[3] = "";	

				rows[4] = ((Participante) persona).GetCodTrabajo();
				model.addRow(rows);
			}

		}

	}
}
