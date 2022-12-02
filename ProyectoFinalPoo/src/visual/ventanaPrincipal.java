package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal frame = new ventanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventanaPrincipal() {
		setTitle("Coordinacion de Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1271, 804);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuarios");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regParticipante personas= new regParticipante();
				personas.setModal(true);
				personas.setVisible(true);
			}
		});
		mnUsuario.add(mntmRegistrar);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mntmListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listParticipante listPersonas= new listParticipante();
				listPersonas.setModal(true);
				listPersonas.setVisible(true);
			}
		});
		mnUsuario.add(mntmListado);
		
		JMenu mnRecursos = new JMenu("Recursos");
		menuBar.add(mnRecursos);
		
		JMenuItem mntmRegistarR = new JMenuItem("Registrar");
		mntmRegistarR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regRecursos recursos= new regRecursos();
				recursos.setModal(true);
				recursos.setVisible(true);
			}
		});
		mnRecursos.add(mntmRegistarR);
		
		JMenuItem mntmListadoR = new JMenuItem("Listado");
		mntmListadoR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listRecursos listRecursos= new listRecursos();
				listRecursos.setModal(true);
				listRecursos.setVisible(true);
			}
		});
		mnRecursos.add(mntmListadoR);
		
		JMenu mnEventos = new JMenu("Eventos");
		menuBar.add(mnEventos);
		
		JMenuItem mntmRegistrarE = new JMenuItem("Registrar");
		mntmRegistrarE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regEvento eventos= new regEvento();
				eventos.setModal(true);
				eventos.setVisible(true);
			}
		});
		mnEventos.add(mntmRegistrarE);
		
		JMenuItem mntmListadoE = new JMenuItem("Listado");
		mntmListadoE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnEventos.add(mntmListadoE);
		
		JMenu mnTrabajoC = new JMenu("Trabajos C.");
		menuBar.add(mnTrabajoC);
		
		JMenuItem mntmRegistrarT = new JMenuItem("Registrar");
		mntmRegistrarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regTrabajoCientifico trabajos= new regTrabajoCientifico(null);
				trabajos.setModal(true);
				trabajos.setVisible(true);
			}
		});
		mnTrabajoC.add(mntmRegistrarT);
		
		JMenuItem mntmListadoT = new JMenuItem("Listado");
		mntmListadoT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listTrabajoC listTrabajos= new listTrabajoC();
				listTrabajos.setModal(true);
				listTrabajos.setVisible(true);
			}
		});
		mnTrabajoC.add(mntmListadoT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
