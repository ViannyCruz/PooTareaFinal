package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.ControlLogin;
import logico.CoordinacionEvento;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ventanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 *
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
		
		try {
			CoordinacionEvento.getInstance().loadParticipante();
			CoordinacionEvento.getInstance().loadRecurso();

		} catch (ClassNotFoundException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		

		
		
		
		
		
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FileOutputStream coordinacionEvento2;
				ObjectOutputStream coordinacionEventoWrite;
				try {
					coordinacionEvento2 = new  FileOutputStream("coordinacionEvento.dat");
					coordinacionEventoWrite = new ObjectOutputStream(coordinacionEvento2);
					coordinacionEventoWrite.writeObject(ControlLogin.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setTitle("Coordinacion de Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1271, 804);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuarios");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regUsuario regUser = new regUsuario();
				regUser.setModal(true);
				regUser.setVisible(true);		
			}
		});
		mnUsuario.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("Participantes/Jurado");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar Participante/Jurado");
		mnNewMenu.add(mntmRegistrar);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mnNewMenu.add(mntmListado);
		mntmListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listParticipante listPersonas = null;
				try {
					listPersonas = new listParticipante();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				listPersonas.setModal(true);
				listPersonas.setVisible(true);
			}
		});
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regParticipante personas= new regParticipante();
				personas.setModal(true);
				personas.setVisible(true);
			}
		});
		
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
