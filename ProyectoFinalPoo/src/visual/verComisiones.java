package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Comision;
import logico.CoordinacionEvento;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class verComisiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model = new DefaultTableModel();
	private static Object[] rows;
	
	private Comision comisionAux = null;
	private ArrayList<Comision> listComisiones;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			verComisiones dialog = new verComisiones();
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
	public verComisiones(   ArrayList<Comision> comisiones) {
		
		listComisiones = new ArrayList<>(comisiones);
		
		setBounds(100, 100, 518, 380);
		setModal(true);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(model);
		String[] columnas = {"Codigo", "Moderador", "Area"};
		model.setColumnIdentifiers(columnas);
		
		scrollPane.setViewportView(table);
		{
			
			
			
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnAceptar.setActionCommand("Cancel");
				buttonPane.add(btnAceptar);
			}
		}
		loadComisiones();
	}
	
	
	
	
private void loadComisiones() {

		
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		
		for (Comision comision : listComisiones) {
			rows[0] = comision.getCodigo();
			rows[1] = comision.getModerador().getNombre();
			rows[2] = comision.getArea();

			model.addRow(rows);

		}
		
		

		
	}
	
}
