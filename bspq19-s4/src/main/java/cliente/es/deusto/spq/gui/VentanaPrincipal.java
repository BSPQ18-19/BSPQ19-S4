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
import cliente.es.deusto.spq.controller.AnadirPeliculaController;
import cliente.es.deusto.spq.controller.AnadirUsuarioController;
import cliente.es.deusto.spq.controller.BorrarPeliculaController;
import cliente.es.deusto.spq.controller.BorrarUsuarioController;
import cliente.es.deusto.spq.controller.BuscarPeliculaController;
import cliente.es.deusto.spq.controller.ContrasenyaController;
import cliente.es.deusto.spq.controller.LoginController;
import cliente.es.deusto.spq.controller.MostrarPeliculasController;
import cliente.es.deusto.spq.controller.MostrarUsuariosController;
import cliente.es.deusto.spq.controller.PeliculaController;
import cliente.es.deusto.spq.controller.PeliculasController;
import cliente.es.deusto.spq.controller.RegistrarController;
import cliente.es.deusto.spq.controller.UsuarioController;
import cliente.es.deusto.spq.controller.UsuariosController;
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
	public static final String CONTRASENYA = "CONTRASENYA";
	public static final String ADMINISTRADOR = "ADMINISTRADOR";
	public static final String PELICULAS = "PELICULAS";
	public static final String ANADIRPELICULA = "ANADIRPELICULA";
	public static final String BORRARPELICULA = "BORRARPELICULA";
	public static final String MOSTRARPELICULAS = "MOSTRARPELICULAS";
	public static final String USUARIOS = "USUARIOS";
	public static final String ANADIRUSUARIO = "ANADIRUSUARIO";
	public static final String BORRARUSUARIO = "BORRARUSUARIO";
	public static final String MOSTRARUSUARIOS = "MOSTRARUSUARIOS";
	public static final String USUARIO = "USUARIO";
	public static final String BUSCARPELICULA = "BUSCARPELICULA";
	public static final String PELICULA = "PELICULA";

	/**
	 * Create the frame.
	 * 
	 * @param serviceName
	 * @param port
	 * @param ip
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */

	public VentanaPrincipal(String ip, String port, String serviceName)
			throws MalformedURLException, RemoteException, NotBoundException {
		RMIBSPQ19S4ServiceLocator service = new RMIBSPQ19S4ServiceLocator();
		service.setService(ip, port, serviceName);

		LoginController loginController = new LoginController(service);
		RegistrarController registrarController = new RegistrarController(service);
		ContrasenyaController contrasenyaController = new ContrasenyaController(service);
		AdministradorController administradorController = new AdministradorController(service);
		PeliculasController peliculasController = new PeliculasController(service);
		AnadirPeliculaController anadirPeliculaController = new AnadirPeliculaController(service);
		BorrarPeliculaController borrarPeliculaController = new BorrarPeliculaController(service);
		MostrarPeliculasController mostrarPeliculasController = new MostrarPeliculasController(service);
		UsuariosController usuariosController = new UsuariosController(service);
		AnadirUsuarioController anadirUsuarioController = new AnadirUsuarioController(service);
		BorrarUsuarioController borrarUsuarioController = new BorrarUsuarioController(service);
		MostrarUsuariosController mostrarUsuariosController = new MostrarUsuariosController(service);
		UsuarioController usuarioController = new UsuarioController(service);
		BuscarPeliculaController buscarPeliculaController = new BuscarPeliculaController(service);
		PeliculaController peliculaController = new PeliculaController(service);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 563);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);

		Login login = new Login(loginController, cardLayout);
		Registrar registrar = new Registrar(registrarController, cardLayout);
		ContrasenyaOlvidada pass = new ContrasenyaOlvidada(contrasenyaController, cardLayout);
		Administrador admin = new Administrador(administradorController, cardLayout);
		Peliculas pelis = new Peliculas(peliculasController, cardLayout);
		AnadirPelicula anPeli = new AnadirPelicula(anadirPeliculaController, cardLayout);
		BorrarPelicula borPeli = new BorrarPelicula(borrarPeliculaController, cardLayout);
		MostrarPeliculas mosPelis = new MostrarPeliculas(mostrarPeliculasController, cardLayout);
		Usuarios users = new Usuarios(usuariosController, cardLayout);
		AnadirUsuario anUser = new AnadirUsuario(anadirUsuarioController, cardLayout);
		BorrarUsuario borUser = new BorrarUsuario(borrarUsuarioController, cardLayout);
		MostrarUsuarios mosUsers = new MostrarUsuarios(mostrarUsuariosController, cardLayout);
		Usuario user = new Usuario(usuarioController, cardLayout);
		BuscarPelicula busPeli = new BuscarPelicula(buscarPeliculaController, cardLayout);
		Pelicula peli = new Pelicula(peliculaController, cardLayout);

		contentPane.add(login, LOGIN);
		contentPane.add(registrar, REGISTRAR);
		contentPane.add(pass, CONTRASENYA);
		contentPane.add(admin, ADMINISTRADOR);
		contentPane.add(pelis, PELICULAS);
		contentPane.add(anPeli, ANADIRPELICULA);
		contentPane.add(borPeli, BORRARPELICULA);
		contentPane.add(mosPelis, MOSTRARPELICULAS);
		contentPane.add(users, USUARIOS);
		contentPane.add(anUser, ANADIRUSUARIO);
		contentPane.add(borUser, BORRARUSUARIO);
		contentPane.add(mosUsers, MOSTRARUSUARIOS);
		contentPane.add(user, USUARIO);
		contentPane.add(busPeli, BUSCARPELICULA);
		contentPane.add(peli, PELICULA);

	}

}