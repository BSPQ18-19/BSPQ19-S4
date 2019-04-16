package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
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

import cliente.es.deusto.spq.controller.AdministradorController;

public class Administrador extends JPanel {

	private static final long serialVersionUID = -1644310303190255276L;
	private static ImageIcon imagen = new ImageIcon("Icono//icono.jpg");


	public Administrador(AdministradorController administradorController, CardLayout cardLayout) {
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0};
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0 };
		setLayout(gbl_contentPane);

		JButton btnUsuarios = new JButton("Base de datos de usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
//							Usuarios frame = new Usuarios();
//							frame.setVisible(true);
//							frame.setTitle("Base de datos de usuarios");
//							frame.setIconImage(imagen.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnUsuarios = new GridBagConstraints();
		gbc_btnUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_btnUsuarios.gridx = 0;
		gbc_btnUsuarios.gridy = 0;
		add(btnUsuarios, gbc_btnUsuarios);

		JButton btnPeliculas = new JButton("Base de datos de peliculas");
		btnPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Peliculas frame = new Peliculas();
							frame.setVisible(true);
							frame.setTitle("Base de datos de peliculas");
							frame.setIconImage(imagen.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnPeliculas = new GridBagConstraints();
		gbc_btnPeliculas.insets = new Insets(0, 0, 5, 0);
		gbc_btnPeliculas.gridx = 0;
		gbc_btnPeliculas.gridy = 1;
		add(btnPeliculas, gbc_btnPeliculas);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.administrador = false;
				Login.usuario = false;
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//TODO ARREGLAR
//							Login frame = new Login(null, null, null);
//							frame.setVisible(true);
//							frame.setTitle("Login");
//							frame.setIconImage(imagen.getImage());
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
		add(btnAtras, gbc_btnAtras);
	}

}
