package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import cliente.es.deusto.spq.controller.MostrarPeliculasController;

public class MostrarPeliculas extends JPanel {
	private static final long serialVersionUID = 8617549966130702827L;

	public MostrarPeliculas(MostrarPeliculasController mostrarPeliculasController, CardLayout cardLayout) throws RemoteException {

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		JLabel lblMostrarPeliculas = new JLabel("Las peliculas registradas en este momento son:");
		GridBagConstraints gbc_lblMostrarPeliculas = new GridBagConstraints();
		gbc_lblMostrarPeliculas.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrarPeliculas.gridx = 0;
		gbc_lblMostrarPeliculas.gridy = 0;
		add(lblMostrarPeliculas, gbc_lblMostrarPeliculas);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		String[] peliculas = mostrarPeliculasController.mostrarPeliculas();
		Arrays.sort(peliculas);

		JList<String> listMostarPeliculas = new JList<String>(peliculas);
		listMostarPeliculas.setEnabled(false);
		listMostarPeliculas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listMostarPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listMostarPeliculas);

		JButton btnAtras = new JButton("Atras");
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
		gbc_btnAtras.gridy = 2;
		add(btnAtras, gbc_btnAtras);
	}

}
