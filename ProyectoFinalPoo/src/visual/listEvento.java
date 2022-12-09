package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.CoordinacionEvento;
import logico.Evento;
import logico.Jurado;
import logico.Participante;
import logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listEvento extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Evento selected = null;
	private JButton btnRevisado;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			listEvento dialog = new listEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public listEvento()   {
	
		
		try {

			CoordinacionEvento.getInstance().loadEvento();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			model = new DefaultTableModel();
			String[] columnas = {"Codigo", "Nombre", "Tema", "Ubicacion"};
			model.setColumnIdentifiers(columnas);
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if(rowSelected>=0){
								//btnRevisado.setEnabled(true);
								selected = CoordinacionEvento.getInstance().getEventoByCode(table.getValueAt(rowSelected, 0).toString());

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
				JButton cancelButton = new JButton("Revisado");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {		
						dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadPersonas();
	}
	
	public static void loadPersonas() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Evento evento :  CoordinacionEvento.getInstance().getEventos()) 
		{
				rows[0] = evento.getCodigo();
				rows[1]	= evento.getNombre();
				rows[2] = evento.getTema();	
				rows[3] = evento.getUbicacion();
				/*
				rows[4] = evento.GetComision();
				rows[5] = evento.GetParticipantes();
				rows[6] = evento.GetRecursos();
				*/
				model.addRow(rows);
		

		}

	}

}
