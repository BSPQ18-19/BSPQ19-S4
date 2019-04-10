package cliente.es.deusto.spq.gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Usuario extends JFrame{
	private static final long serialVersionUID = -1644310303190255276L;
	private JPanel contentPane;
	private static ImageIcon imagen = new ImageIcon("Icono//icono.jpg");

	// TODO:eliminar hasta la linea 35 cuando funcione la BD
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
					frame.setVisible(true);
					frame.setTitle("Usuario");
					frame.setIconImage(imagen.getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnPerfil = new JButton("Mi perfil de usuario");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Perfil frame = new Perfil();
							frame.setVisible(true);
							frame.setTitle("Mi perfil");
							frame.setIconImage(imagen.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnPerfil = new GridBagConstraints();
		gbc_btnPerfil.insets = new Insets(0, 0, 5, 0);
		gbc_btnPerfil.gridx = 0;
		gbc_btnPerfil.gridy = 0;
		contentPane.add(btnPerfil, gbc_btnPerfil);

		JButton btnPelicula = new JButton("Buscar pelicula");
		btnPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BuscarPelicula frame = new BuscarPelicula();
							frame.setVisible(true);
							frame.setTitle("Buscar pelicula");
							frame.setIconImage(imagen.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnPelicula = new GridBagConstraints();
		gbc_btnPelicula.insets = new Insets(0, 0, 5, 0);
		gbc_btnPelicula.gridx = 0;
		gbc_btnPelicula.gridy = 1;
		contentPane.add(btnPelicula, gbc_btnPelicula);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.administrador = false;
				VentanaPrincipal.usuario = false;
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaPrincipal frame = new VentanaPrincipal();
							frame.setVisible(true);
							frame.setTitle("Login");
							frame.setIconImage(imagen.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 2;
		contentPane.add(btnAtras, gbc_btnAtras);
	}

}
