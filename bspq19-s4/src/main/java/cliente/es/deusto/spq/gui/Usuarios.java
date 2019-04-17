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

import cliente.es.deusto.spq.controller.UsuariosController;

public class Usuarios extends JPanel {
	private static final long serialVersionUID = 6216694316784718679L;
	private JPanel contentPane;
	
	public Usuarios(UsuariosController usuariosController, CardLayout cardLayout) {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnAnadir = new JButton("A\u00F1adir usuario");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.ANADIRUSUARIO);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnAnadir = new GridBagConstraints();
		gbc_btnAnadir.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnadir.gridx = 0;
		gbc_btnAnadir.gridy = 0;
		contentPane.add(btnAnadir, gbc_btnAnadir);

		JButton btnBorrar = new JButton("Borrar usuario");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.BORRARUSUARIO);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrar.gridx = 0;
		gbc_btnBorrar.gridy = 1;
		contentPane.add(btnBorrar, gbc_btnBorrar);

		JButton btnMostrarLista = new JButton("Mostrar lista de usuarios");
		btnMostrarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.MOSTRARUSUARIOS);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnMostrarLista = new GridBagConstraints();
		gbc_btnMostrarLista.insets = new Insets(0, 0, 5, 0);
		gbc_btnMostrarLista.gridx = 0;
		gbc_btnMostrarLista.gridy = 2;
		contentPane.add(btnMostrarLista, gbc_btnMostrarLista);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 3;
		contentPane.add(btnAtras, gbc_btnAtras);
	}

}
