package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.ControlLogin;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		
				try {
					Login frame = new Login();
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
	public Login() {
		FileInputStream coordinacionEvento;
		FileOutputStream coordinacionEvento2;
		ObjectInputStream coordinacionEventoRead;
		ObjectOutputStream coordinacionEventoWrite;
		try {
			coordinacionEvento = new FileInputStream ("coordinacionEvento.dat");
			coordinacionEventoRead = new ObjectInputStream(coordinacionEvento);
			ControlLogin temp = (ControlLogin)coordinacionEventoRead.readObject();
			ControlLogin.setControl(temp);
			coordinacionEvento.close();
			coordinacionEventoRead.close();
		} catch (FileNotFoundException e) {
			try {
				coordinacionEvento2 = new  FileOutputStream("coordinacionEvento.dat");
				coordinacionEventoWrite = new ObjectOutputStream(coordinacionEvento2);
				Usuario aux = new Usuario("Administrador", "Admin", "Admin");
				ControlLogin.getInstance().regUsuario(aux);
				coordinacionEventoWrite.writeObject(ControlLogin.getInstance());
				coordinacionEvento2.close();
				coordinacionEventoWrite.close();
			} catch (FileNotFoundException e1) {
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			}
		} catch (IOException e) {
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(12, 25, 56, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(12, 69, 76, 16);
		panel.add(lblNewLabel_1);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ControlLogin.getInstance().confirmarLogin(txtUsuario.getText(),txtContrasena.getText())){
					ventanaPrincipal frame = new ventanaPrincipal();
					dispose();
					frame.setVisible(true);
				};
			}
		});
		btnLogin.setBounds(179, 113, 97, 25);
		panel.add(btnLogin);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(69, 22, 207, 22);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(90, 66, 186, 22);
		panel.add(txtContrasena);
		txtContrasena.setColumns(10);
	}
}
