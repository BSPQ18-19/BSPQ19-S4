package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;



import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cliente.es.deusto.spq.controller.BuscarPeliculaController;

public class BuscarPelicula extends JPanel {

	private static final long serialVersionUID = -1644310303190255276L;
	private JLabel lblLista;
	private JScrollPane scrollPane;
	private String[] peliculas = {"Elegir como ordenar la lista"};
	private String[] pelis = null;
	private JList<String> listMostarPeliculas;
	private JButton btnVer;
	static String pelicula = null;

	public void actualizarLista(String[] peliculas) {
		listMostarPeliculas.setEnabled(true);
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String s:peliculas) {
			model.addElement(s);
		}
		listMostarPeliculas.setModel(model);
	}

	public BuscarPelicula(BuscarPeliculaController buscarPeliculaController, CardLayout cardLayout) {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 130, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 };
		setLayout(gbl_contentPane);

		JLabel lblMostrarPeliculas = new JLabel("Las peliculas registradas en este momento son:");
		GridBagConstraints gbc_lblMostrarPeliculas = new GridBagConstraints();
		gbc_lblMostrarPeliculas.gridwidth = 3;
		gbc_lblMostrarPeliculas.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrarPeliculas.gridx = 0;
		gbc_lblMostrarPeliculas.gridy = 2;
		add(lblMostrarPeliculas, gbc_lblMostrarPeliculas);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);

		Arrays.sort(peliculas);
		
		listMostarPeliculas = new JList<String>(peliculas);
		listMostarPeliculas.setEnabled(false);
		listMostarPeliculas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listMostarPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listMostarPeliculas);
		
		listMostarPeliculas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listMostarPeliculas.getSelectedIndex() != -1) {
					btnVer.setEnabled(true);
				}
			}
		});
		
		lblLista = new JLabel("Ordenar lista por: ");
		GridBagConstraints gbc_lblLista = new GridBagConstraints();
		gbc_lblLista.insets = new Insets(0, 0, 5, 0);
		gbc_lblLista.gridwidth = 3;
		gbc_lblLista.gridx = 0;
		gbc_lblLista.gridy = 0;
		add(lblLista, gbc_lblLista);

		JButton btnTitulo = new JButton("Titulo");
		btnTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String[] peliculasTitulo = buscarPeliculaController.buscarPeliculasTitulo();
							actualizarLista(peliculasTitulo);
							pelis = peliculasTitulo;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		GridBagConstraints gbc_btnTitulo = new GridBagConstraints();
		gbc_btnTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_btnTitulo.gridx = 0;
		gbc_btnTitulo.gridy = 1;
		add(btnTitulo, gbc_btnTitulo);

		JButton btnGenero = new JButton("Genero");
		btnGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String[] peliculasGenero = buscarPeliculaController.buscarPeliculasGenero();
							actualizarLista(peliculasGenero);
							pelis = peliculasGenero;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		GridBagConstraints gbc_btnGenero = new GridBagConstraints();
		gbc_btnGenero.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenero.gridx = 1;
		gbc_btnGenero.gridy = 1;
		add(btnGenero, gbc_btnGenero);

		JButton btnFecha = new JButton("Fecha");
		btnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String[] peliculasFecha = buscarPeliculaController.buscarPeliculasFecha();
							actualizarLista(peliculasFecha);
							pelis = peliculasFecha;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		GridBagConstraints gbc_btnFecha = new GridBagConstraints();
		gbc_btnFecha.insets = new Insets(0, 0, 5, 5);
		gbc_btnFecha.gridx = 2;
		gbc_btnFecha.gridy = 1;
		add(btnFecha, gbc_btnFecha);

		btnVer = new JButton("Ver información película");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = listMostarPeliculas.getSelectedIndex();
				pelicula = pelis[i];
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Pelicula.titulo =pelicula;
							cardLayout.show(getParent(), VentanaPrincipal.PELICULA);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnVer.setEnabled(false);
		GridBagConstraints gbc_btnVer = new GridBagConstraints();
		gbc_btnVer.gridwidth = 2;
		gbc_btnVer.insets = new Insets(0, 0, 5, 0);
		gbc_btnVer.gridx = 1;
		gbc_btnVer.gridy = 4;
		add(btnVer, gbc_btnVer);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reinicio();
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
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 4;
		add(btnAtras, gbc_btnAtras);
	}
	public void reinicio(){
		actualizarLista(peliculas);
		listMostarPeliculas.setEnabled(false);
		btnVer.setEnabled(false);
	}
}
