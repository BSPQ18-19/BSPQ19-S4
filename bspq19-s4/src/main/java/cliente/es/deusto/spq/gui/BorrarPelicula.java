package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cliente.es.deusto.spq.controller.BorrarPeliculaController;

public class BorrarPelicula extends JPanel {
	private static final long serialVersionUID = -2878465684552734783L;
	private JButton btnBorrar;
	private JList<String> listMostarPeliculas;
	//TODO;quitar la siguiente linea
	private String[] peliculas = { "a", "b" };

	public BorrarPelicula(BorrarPeliculaController borrarPeliculaController, CardLayout cardLayout) {

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		JLabel lblMostrarPelicula = new JLabel("Seleccione la pelicula que desea borrar:");
		GridBagConstraints gbc_lblMostrarPelicula = new GridBagConstraints();
		gbc_lblMostrarPelicula.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrarPelicula.gridx = 0;
		gbc_lblMostrarPelicula.gridy = 0;
		add(lblMostrarPelicula, gbc_lblMostrarPelicula);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		// TODO: Cargar String[]peliculas con los titulos de todas las peliculas de la BD
		Arrays.sort(peliculas);

		listMostarPeliculas = new JList<String>(peliculas);
		listMostarPeliculas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listMostarPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listMostarPeliculas);

		listMostarPeliculas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listMostarPeliculas.getSelectedIndex() != -1) {
					btnBorrar.setEnabled(true);
				}
			}
		});

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = listMostarPeliculas.getSelectedIndex();
				String n = peliculas[i];
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							borrarPeliculaController.borrarPelicula(n);
							
							cardLayout.show(getParent(), VentanaPrincipal.PELICULAS);
							JOptionPane.showMessageDialog(null, "Pelicula eliminada");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnBorrar.setEnabled(false);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrar.gridx = 0;
		gbc_btnBorrar.gridy = 2;
		add(btnBorrar, gbc_btnBorrar);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
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

		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 3;
		add(btnAtras, gbc_btnAtras);
	}

}