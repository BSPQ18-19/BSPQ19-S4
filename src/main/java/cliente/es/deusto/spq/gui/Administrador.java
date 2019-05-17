package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import cliente.es.deusto.spq.controller.AdministradorController;

public class Administrador extends JPanel {

	private static final long serialVersionUID = -1644310303190255276L;

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
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.USUARIOS);
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
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.PELICULAS);
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

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reinicio();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.LOGIN);
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
	public void reinicio(){
		Login.administrador = false;
		Login.usuario = false;
		Login.nombre = null;
		Login.contrasenya = null;
		Login.textFieldUsuario.setText(null);
		Login.textFieldUsuario.setEnabled(true);
		Login.textFieldUsuario.setEditable(true);
		Login.lblContrasea.setEnabled(false);
		Login.passwordFieldContrasea.setEnabled(false);
		Login.passwordFieldContrasea.setText(null);
		Login.passwordFieldContrasea.setEditable(true);
		Login.btnContraseaOlvidada.setEnabled(false);
		Login.btnIniciarSesion.setEnabled(false);
	}
}
