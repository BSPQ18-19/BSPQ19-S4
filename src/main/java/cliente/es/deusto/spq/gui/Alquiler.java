package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cliente.es.deusto.spq.controller.AlquilerController;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Alquiler extends JPanel {
private static final long serialVersionUID = 674330126384087764L;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Alquiler(AlquilerController alquilerController, CardLayout cardLayout) {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0 };
		setLayout(gbl_contentPane);
		
		JLabel lblTiempo = new JLabel("¿Durante cuantos días quieres alquilar la película? ");
		GridBagConstraints gbc_lblTiempo = new GridBagConstraints();
		gbc_lblTiempo.gridwidth = 2;
		gbc_lblTiempo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTiempo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiempo.gridx = 0;
		gbc_lblTiempo.gridy = 0;
		add(lblTiempo, gbc_lblTiempo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");  
							Date date = new Date(System.currentTimeMillis());  
							String fAlq = formatter.format(date);
							int tAlq = comboBox.getSelectedIndex()+1;
							String nombre = Login.textFieldUsuario.getText();
							String peli = Pelicula.lblGetTit.getText();
							alquilerController.alquilarPelicula(fAlq, tAlq, nombre, peli);
							cardLayout.show(getParent(), VentanaPrincipal.PELICULA);
							JOptionPane.showMessageDialog(null, "Película alquilada");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 2;
		add(btnAceptar, gbc_btnAceptar);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.PELICULA);
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
		gbc_btnAtras.gridy = 2;
		add(btnAtras, gbc_btnAtras);
	}
}
