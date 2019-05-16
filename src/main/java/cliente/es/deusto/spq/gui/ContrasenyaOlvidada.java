package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cliente.es.deusto.spq.controller.ContrasenyaController;

public class ContrasenyaOlvidada extends JPanel {

	private static final long serialVersionUID = 8892233185250939659L;
	private JPanel panel;
	private JLabel lblCorreo;
	private JTextField textFieldCorreo;
	private JButton btnAtras;

	public ContrasenyaOlvidada(ContrasenyaController contrasenyaController, CardLayout cardLayout) {

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 86, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblCorreo = new JLabel("Introducir correo electr\u00F3nico: ");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.insets = new Insets(0, 0, 0, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 0;
		panel.add(lblCorreo, gbc_lblCorreo);

		textFieldCorreo = new JTextField();
		GridBagConstraints gbc_textFieldCorreo = new GridBagConstraints();
		gbc_textFieldCorreo.gridx = 1;
		gbc_textFieldCorreo.gridy = 0;
		panel.add(textFieldCorreo, gbc_textFieldCorreo);
		textFieldCorreo.setColumns(20);

		textFieldCorreo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String correo = textFieldCorreo.getText();
					String nombre = Login.nombre;
					 try {
						if(contrasenyaController.correo(nombre, correo) == true){
						 String contrasenya = contrasenyaController.contrasenya(nombre);
						 JOptionPane.showMessageDialog(null, "La contrase\u00F1a del usuario "+nombre+" con correo "+correo+" es "+contrasenya);
						 }
					} catch (HeadlessException | RemoteException e1) {
						e1.printStackTrace();
					}
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
			}
		});

		btnAtras = new JButton("Atr\u00E1s");
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
		gbc_btnAtras.gridy = 1;
		add(btnAtras, gbc_btnAtras);
	}
	public void reinicio(){
		Login.administrador = false;
		Login.usuario = false;
		Login.nombre = null;
		Login.contrasenya = null;
		Login.textFieldUsuario.setText(null);
		Login.lblContrasea.setEnabled(false);
		Login.passwordFieldContrasea.setEnabled(false);
		Login.passwordFieldContrasea.setText(null);
		Login.passwordFieldContrasea.setEditable(false);
		Login.btnContraseaOlvidada.setEnabled(false);
		Login.btnIniciarSesion.setEnabled(false);
	}

}
