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

import cliente.es.deusto.spq.controller.UsuarioController;

public class Usuario extends JPanel{
	private static final long serialVersionUID = -1644310303190255276L;

	public Usuario(UsuarioController usuarioController, CardLayout cardLayout) {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		JButton btnPerfil = new JButton("Mi perfil de usuario");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.PERFIL);
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
		add(btnPerfil, gbc_btnPerfil);

		JButton btnPelicula = new JButton("Buscar pelicula");
		btnPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.BUSCARPELICULA);
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
		add(btnPelicula, gbc_btnPelicula);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reinicio();
				setVisible(false);
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
