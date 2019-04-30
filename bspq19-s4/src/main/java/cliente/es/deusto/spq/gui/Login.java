package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
//import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cliente.es.deusto.spq.controller.LoginController;

public class Login extends JPanel {
	private static final long serialVersionUID = 8689513507453358451L;
	private JLabel lblUsuario;
	private JTextField textFieldUsuario;
	static JLabel lblContrasea;
	static JPasswordField passwordFieldContrasea;
	private JButton btnNuevoUsuario;
	static JButton btnContraseaOlvidada;
	static JButton btnIniciarSesion;
	static boolean usuario = false;
	static boolean administrador = false;
	static String nombre = null;
	static String contrasenya = null;

		public Login(LoginController loginController, CardLayout cardLayout) {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		add(lblUsuario, gbc_lblUsuario);

		textFieldUsuario = new JTextField();
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUsuario.gridx = 1;
		gbc_textFieldUsuario.gridy = 0;
		add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(20);

		textFieldUsuario.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					nombre = textFieldUsuario.getText();
					try {
						if (loginController.esAdmin(nombre) == true){
							administrador = true;
							lblContrasea.setEnabled(true);
							passwordFieldContrasea.setEnabled(true);
							btnContraseaOlvidada.setEnabled(true);
							passwordFieldContrasea.requestFocus();
							textFieldUsuario.setEditable(false);
						}else if(loginController.esUser(nombre) == true){
							usuario = true;
							lblContrasea.setEnabled(true);
							passwordFieldContrasea.setEnabled(true);
							btnContraseaOlvidada.setEnabled(true);
							passwordFieldContrasea.requestFocus();
							textFieldUsuario.setEditable(false);
						 }
						if (administrador == false && usuario == false) {
							JOptionPane.showMessageDialog(null, "El usuario introducido no est\u00E1 registrado");
						}
					} catch (HeadlessException | RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setEnabled(false);
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 1;
		add(lblContrasea, gbc_lblContrasea);

		passwordFieldContrasea = new JPasswordField();
		passwordFieldContrasea.setEnabled(false);
		passwordFieldContrasea.setColumns(20);
		GridBagConstraints gbc_passwordFieldContrasea = new GridBagConstraints();
		gbc_passwordFieldContrasea.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldContrasea.gridx = 1;
		gbc_passwordFieldContrasea.gridy = 1;
		add(passwordFieldContrasea, gbc_passwordFieldContrasea);

		passwordFieldContrasea.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					contrasenya = new String(passwordFieldContrasea.getPassword());
					 try {
						if(loginController.contrasenna(nombre, contrasenya) == true){
							 btnIniciarSesion.setEnabled(true);
							 passwordFieldContrasea.setEnabled(false);
							 btnIniciarSesion.requestFocus();
						 }else{
							 JOptionPane.showMessageDialog(null, "Contrase\u00F1a incorrecta");
						 }
					} catch (HeadlessException | RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btnNuevoUsuario = new JButton("Registrar nuevo usuario");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.REGISTRAR);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnNuevoUsuario = new GridBagConstraints();
		gbc_btnNuevoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoUsuario.gridx = 0;
		gbc_btnNuevoUsuario.gridy = 2;
		add(btnNuevoUsuario, gbc_btnNuevoUsuario);

		btnContraseaOlvidada = new JButton("Se me ha olvidado la contrase\u00F1a");
		btnContraseaOlvidada.setEnabled(false);
		btnContraseaOlvidada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.CONTRASENYA);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnContraseaOlvidada = new GridBagConstraints();
		gbc_btnContraseaOlvidada.insets = new Insets(0, 0, 5, 0);
		gbc_btnContraseaOlvidada.gridx = 1;
		gbc_btnContraseaOlvidada.gridy = 2;
		add(btnContraseaOlvidada, gbc_btnContraseaOlvidada);

		btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				if (usuario == true) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								//TODO: pasar info usuario
								cardLayout.show(getParent(), VentanaPrincipal.USUARIO);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else if (administrador == true) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								cardLayout.show(getParent(), VentanaPrincipal.ADMINISTRADOR);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnIniciarSesion.setEnabled(false);
		GridBagConstraints gbc_btnIniciarSesion = new GridBagConstraints();
		gbc_btnIniciarSesion.gridwidth = 2;
		gbc_btnIniciarSesion.insets = new Insets(0, 0, 0, 5);
		gbc_btnIniciarSesion.gridx = 0;
		gbc_btnIniciarSesion.gridy = 3;
		add(btnIniciarSesion, gbc_btnIniciarSesion);
	}

}
