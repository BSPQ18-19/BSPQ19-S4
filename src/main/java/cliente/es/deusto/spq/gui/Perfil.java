package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cliente.es.deusto.spq.controller.PerfilController;
import javax.swing.JTextField;

public class Perfil extends JPanel{
	private static final long serialVersionUID = 6216694316784718679L;
	
public Perfil(PerfilController perfilController, CardLayout cardLayout) {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 };
		setLayout(gbl_contentPane);
	
		//TODO: introducir contenido
		
		JLabel lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		JLabel lblGetNombre = new JLabel("");
		GridBagConstraints gbc_lblGetNombre = new GridBagConstraints();
		gbc_lblGetNombre.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetNombre.gridx = 1;
		gbc_lblGetNombre.gridy = 0;
		add(lblGetNombre, gbc_lblGetNombre);
		
		JLabel lblCorreo = new JLabel("Correo: ");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.fill = GridBagConstraints.VERTICAL;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 1;
		add(lblCorreo, gbc_lblCorreo);
		
		JLabel lblGetCorreo = new JLabel("");
		GridBagConstraints gbc_lblGetCorreo = new GridBagConstraints();
		gbc_lblGetCorreo.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetCorreo.gridx = 1;
		gbc_lblGetCorreo.gridy = 1;
		add(lblGetCorreo, gbc_lblGetCorreo);
		
		JLabel lblPaypal = new JLabel("Cuenta de Paypal: ");
		GridBagConstraints gbc_lblPaypal = new GridBagConstraints();
		gbc_lblPaypal.fill = GridBagConstraints.VERTICAL;
		gbc_lblPaypal.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaypal.gridx = 0;
		gbc_lblPaypal.gridy = 2;
		add(lblPaypal, gbc_lblPaypal);
		
		JButton btnPelFav = new JButton("Lista películas favoritas");
		btnPelFav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.FAVORITAS);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JLabel lblGetPaypal = new JLabel("");
		GridBagConstraints gbc_lblGetPaypal = new GridBagConstraints();
		gbc_lblGetPaypal.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetPaypal.gridx = 1;
		gbc_lblGetPaypal.gridy = 2;
		add(lblGetPaypal, gbc_lblGetPaypal);
		GridBagConstraints gbc_btnPelFav = new GridBagConstraints();
		gbc_btnPelFav.insets = new Insets(0, 0, 5, 5);
		gbc_btnPelFav.gridx = 0;
		gbc_btnPelFav.gridy = 3;
		add(btnPelFav, gbc_btnPelFav);
		
		JButton btnPelVis = new JButton("Lista películas vistas");
		btnPelVis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.VISTAS);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnPelVis = new GridBagConstraints();
		gbc_btnPelVis.insets = new Insets(0, 0, 5, 0);
		gbc_btnPelVis.gridx = 1;
		gbc_btnPelVis.gridy = 3;
		add(btnPelVis, gbc_btnPelVis);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.USUARIO);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 4;
		add(btnAtras, gbc_btnAtras);
	}
}
