package logico;

import java.io.Serializable;
import java.util.ArrayList;

import logico.Usuario;

public class ControlLogin implements Serializable{
	
	private static final long serialVersionUID = 1;;
	private ArrayList<Usuario> usuarios;
	private static ControlLogin control;
    private static Usuario loginUsuario;
    
    private ControlLogin() {
    	usuarios = new ArrayList<>();
    }
    
    public static ControlLogin getInstance() {
    	
    	if(control == null)
    	{
    		control = new ControlLogin();
    	}
    	return control;
    }
    
    public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public static ControlLogin getControl() {
		return control;
	}

	public static void setControl(ControlLogin control) {
		ControlLogin.control = control;
	}

	public static Usuario getLoginUsuario() {
		return loginUsuario;
	}

	public static void setLoginUsuario(Usuario loginUsuario) {
		ControlLogin.loginUsuario = loginUsuario;
	}

	public void regUsuario(Usuario user) {
		usuarios.add(user);
	}
    
	public boolean confirmarLogin(String text, String text2) {
		boolean login = false;
		for (Usuario user : usuarios) {
			if(user.getNombreUsuario().equals(text) && user.getContrasena().equals(text2)){
				loginUsuario = user;
				login = true;
			}
		}
		return login;
	}
}
