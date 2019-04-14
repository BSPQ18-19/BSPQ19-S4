package cliente.es.deusto.spq.gui;

import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.es.deusto.spq.controller.AdministradorController;
import cliente.es.deusto.spq.controller.ContrasenyaController;
import cliente.es.deusto.spq.controller.LoginController;
import cliente.es.deusto.spq.controller.RegistrarController;
import cliente.es.deusto.spq.controller.UsuarioController;
import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;

import java.awt.CardLayout;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4344002416292816158L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private static ImageIcon imagen = new ImageIcon("Icono//icono.jpg");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(args[0], args[1], args[2]);
					frame.setIconImage(imagen.getImage());
					frame.setVisible(true);
					frame.setTitle(new String("VideoClub"));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ha habido un error :(", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
	}
	
	public static final String LOGIN = "LOGIN";
	public static final String REGISTRAR = "REGISTRAR";
	public static final String ADMINISTRADOR = "ADMINISTRADOR";
	public static final String USUARIO = "USUARIO";
	public static final String CONTRASENYA = "CONTRASENYA";

	/**
	 * Create the frame.
	 * @param serviceName 
	 * @param port 
	 * @param ip 
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	
	public VentanaPrincipal(String ip, String port, String serviceName) throws MalformedURLException, RemoteException, NotBoundException {
		RMIBSPQ19S4ServiceLocator service = new RMIBSPQ19S4ServiceLocator();
		service.setService(ip, port, serviceName);
		
		LoginController loginController = new LoginController(service);
		AdministradorController administradorController = new AdministradorController(service);
		UsuarioController usuarioController = new UsuarioController(service);
		RegistrarController registrarController = new RegistrarController(service);
		ContrasenyaController contrasenyaController = new ContrasenyaController(service);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
	
		Login login = new Login(loginController, cardLayout);
		Administrador admin = new Administrador(administradorController, cardLayout);
		Usuario user = new Usuario(usuarioController, cardLayout);
		Registrar registrar = new Registrar(registrarController, cardLayout);
		ContrasenyaOlvidada pass = new ContrasenyaOlvidada(contrasenyaController, cardLayout);
		
		contentPane.add(login, LOGIN);
		contentPane.add(admin, ADMINISTRADOR);
		contentPane.add(user, USUARIO);
		contentPane.add(registrar, REGISTRAR);
		contentPane.add(pass, CONTRASENYA);
	
	
	}
	
	
}
