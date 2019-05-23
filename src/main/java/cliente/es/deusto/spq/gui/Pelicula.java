package cliente.es.deusto.spq.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import cliente.es.deusto.spq.controller.PeliculaController;
import cliente.es.deusto.spq.gui.Pelicula;

public class Pelicula extends JPanel{

	private static final long serialVersionUID = 674330126384087764L;
	 
	static JLabel lblGetTit;
	static JLabel lblGetGen;
	static JLabel lblGetEstreno;
	static JLabel lblGetSinopsis;
	static JLabel lblGetFicha;
	
	static PeliculaController peliculaController;
	static servidor.es.deusto.spq.jdo.Pelicula peli;
	
	public static void init(servidor.es.deusto.spq.jdo.Pelicula peli) throws RemoteException {
		lblGetTit.setText(peli.getTitulo());
		lblGetGen.setText(peli.getGenero());
		lblGetEstreno.setText(peli.getfEstreno());
		lblGetSinopsis.setText(peli.getSinopsis());
		lblGetFicha.setText(peli.getFichaTecnica());
	}
	
	public Pelicula(PeliculaController peliculaController, CardLayout cardLayout) throws RemoteException {
		this.peliculaController = peliculaController;
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		setLayout(gbl_contentPane);
	
		JLabel lblTitulo = new JLabel("Titulo de la pelicula: ");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.EAST;
		gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		add(lblTitulo, gbc_lblTitulo);
		
		lblGetTit = new JLabel("");
		GridBagConstraints gbc_lblGetTit = new GridBagConstraints();
		gbc_lblGetTit.fill = GridBagConstraints.BOTH;
		gbc_lblGetTit.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetTit.gridx = 1;
		gbc_lblGetTit.gridy = 0;
		add(lblGetTit, gbc_lblGetTit);
		
		JLabel lblGenero = new JLabel("Genero de la pelicula: ");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.fill = GridBagConstraints.VERTICAL;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 1;
		add(lblGenero, gbc_lblGenero);
		
		lblGetGen = new JLabel("");
		GridBagConstraints gbc_lblGetGen = new GridBagConstraints();
		gbc_lblGetGen.fill = GridBagConstraints.BOTH;
		gbc_lblGetGen.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetGen.gridx = 1;
		gbc_lblGetGen.gridy = 1;
		add(lblGetGen, gbc_lblGetGen);
		
		JLabel lblFecha = new JLabel("Fecha de estreno de la pelicula: ");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.fill = GridBagConstraints.VERTICAL;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 2;
		add(lblFecha, gbc_lblFecha);
		
		lblGetEstreno = new JLabel("");
		GridBagConstraints gbc_lblGetEstreno = new GridBagConstraints();
		gbc_lblGetEstreno.fill = GridBagConstraints.BOTH;
		gbc_lblGetEstreno.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetEstreno.gridx = 1;
		gbc_lblGetEstreno.gridy = 2;
		add(lblGetEstreno, gbc_lblGetEstreno);
		
		JLabel lblSinopsis = new JLabel("Sinopsis de la pelicula: ");
		GridBagConstraints gbc_lblSinopsis = new GridBagConstraints();
		gbc_lblSinopsis.anchor = GridBagConstraints.EAST;
		gbc_lblSinopsis.fill = GridBagConstraints.VERTICAL;
		gbc_lblSinopsis.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinopsis.gridx = 0;
		gbc_lblSinopsis.gridy = 3;
		add(lblSinopsis, gbc_lblSinopsis);
		
		lblGetSinopsis = new JLabel("");
		GridBagConstraints gbc_lblGetSinopsis = new GridBagConstraints();
		gbc_lblGetSinopsis.fill = GridBagConstraints.BOTH;
		gbc_lblGetSinopsis.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetSinopsis.gridx = 1;
		gbc_lblGetSinopsis.gridy = 3;
		add(lblGetSinopsis, gbc_lblGetSinopsis);
		
		JLabel lblFTecnica = new JLabel("Ficha tecnica de la pelicula: ");
		GridBagConstraints gbc_lblFTecnica = new GridBagConstraints();
		gbc_lblFTecnica.anchor = GridBagConstraints.EAST;
		gbc_lblFTecnica.fill = GridBagConstraints.VERTICAL;
		gbc_lblFTecnica.insets = new Insets(0, 0, 5, 5);
		gbc_lblFTecnica.gridx = 0;
		gbc_lblFTecnica.gridy = 4;
		add(lblFTecnica, gbc_lblFTecnica);
		
		lblGetFicha = new JLabel("");
		GridBagConstraints gbc_lblGetFicha = new GridBagConstraints();
		gbc_lblGetFicha.fill = GridBagConstraints.BOTH;
		gbc_lblGetFicha.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetFicha.gridx = 1;
		gbc_lblGetFicha.gridy = 4;
		add(lblGetFicha, gbc_lblGetFicha);
		
		JButton btnTrailer = new JButton("Ver trailer");
		btnTrailer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NativeInterface.open();
							VentanaTrailerPelicula abrirventana = new VentanaTrailerPelicula();
							abrirventana.setVisible(true);
							abrirventana.setTitle("Trailer de la pelicula");
							abrirventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							abrirventana.setSize(1366, 768);
							
							
							NativeInterface.runEventPump();
							
							Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

								public void run() {
									NativeInterface.close();
								}
								
							}));
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
			}
			/*
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							try {
								VentanaTrailerPelicula frame = new VentanaTrailerPelicula();
								frame.setVisible(true);
								frame.setTitle("Trailer");
							} catch (Exception e) {
								e.printStackTrace();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			*/
		});
		GridBagConstraints gbc_btnTrailer = new GridBagConstraints();
		gbc_btnTrailer.insets = new Insets(0, 0, 5, 0);
		gbc_btnTrailer.gridwidth = 2;
		gbc_btnTrailer.gridx = 0;
		gbc_btnTrailer.gridy = 5;
		add(btnTrailer, gbc_btnTrailer);
		
		JButton btnVerPuntYOpin = new JButton("Ver puntuaciones y opiniones");
		btnVerPuntYOpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//TODO: ventana de ver puntuaciones y opiniones
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnVerPuntYOpin = new GridBagConstraints();
		gbc_btnVerPuntYOpin.insets = new Insets(0, 0, 5, 5);
		gbc_btnVerPuntYOpin.gridx = 0;
		gbc_btnVerPuntYOpin.gridy = 6;
		add(btnVerPuntYOpin, gbc_btnVerPuntYOpin);
		
		JButton btnDejarPuntYOpin = new JButton("Dejar puntuacion u opinion");
		btnDejarPuntYOpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//TODO: ventana de dejar puntuaciones y opiniones
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnDejarPuntYOpin = new GridBagConstraints();
		gbc_btnDejarPuntYOpin.insets = new Insets(0, 0, 5, 0);
		gbc_btnDejarPuntYOpin.gridx = 1;
		gbc_btnDejarPuntYOpin.gridy = 6;
		add(btnDejarPuntYOpin, gbc_btnDejarPuntYOpin);
		
		JButton btnAlquilar = new JButton("Alquilar pelicula");
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.ALQUILER);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnAlquilar = new GridBagConstraints();
		gbc_btnAlquilar.gridx = 1;
		gbc_btnAlquilar.gridy = 7;
		add(btnAlquilar, gbc_btnAlquilar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
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
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 7;
		add(btnAtras, gbc_btnAtras);
	}
}
