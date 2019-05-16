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

import cliente.es.deusto.spq.controller.PeliculaController;
import javax.swing.JTextField;

public class Pelicula extends JPanel{

	private static final long serialVersionUID = 674330126384087764L;
	private JTextField textFieldTitulo;
	private JTextField textFieldGenero;
	private JTextField textFieldFEstreno;
	private JTextField textFieldSinopsis;
	private JTextField textFieldFicha;
	
	public Pelicula(PeliculaController peliculaController, CardLayout cardLayout) {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		setLayout(gbl_contentPane);
	
		//TODO: introducir contenido
		
		JLabel lblTitulo = new JLabel("Titulo de la pelicula: ");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.EAST;
		gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		add(lblTitulo, gbc_lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setEditable(false);
		GridBagConstraints gbc_textFieldTitulo = new GridBagConstraints();
		gbc_textFieldTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTitulo.gridx = 1;
		gbc_textFieldTitulo.gridy = 0;
		add(textFieldTitulo, gbc_textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero de la pelicula: ");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.fill = GridBagConstraints.VERTICAL;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 1;
		add(lblGenero, gbc_lblGenero);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setEditable(false);
		GridBagConstraints gbc_textFieldGenero = new GridBagConstraints();
		gbc_textFieldGenero.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGenero.gridx = 1;
		gbc_textFieldGenero.gridy = 1;
		add(textFieldGenero, gbc_textFieldGenero);
		textFieldGenero.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de estreno de la pelicula: ");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.fill = GridBagConstraints.VERTICAL;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 2;
		add(lblFecha, gbc_lblFecha);
		
		textFieldFEstreno = new JTextField();
		textFieldFEstreno.setEditable(false);
		GridBagConstraints gbc_textFieldFEstreno = new GridBagConstraints();
		gbc_textFieldFEstreno.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFEstreno.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFEstreno.gridx = 1;
		gbc_textFieldFEstreno.gridy = 2;
		add(textFieldFEstreno, gbc_textFieldFEstreno);
		textFieldFEstreno.setColumns(10);
		
		JLabel lblSinopsis = new JLabel("Sinopsis de la pelicula: ");
		GridBagConstraints gbc_lblSinopsis = new GridBagConstraints();
		gbc_lblSinopsis.anchor = GridBagConstraints.EAST;
		gbc_lblSinopsis.fill = GridBagConstraints.VERTICAL;
		gbc_lblSinopsis.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinopsis.gridx = 0;
		gbc_lblSinopsis.gridy = 3;
		add(lblSinopsis, gbc_lblSinopsis);
		
		textFieldSinopsis = new JTextField();
		textFieldSinopsis.setEditable(false);
		GridBagConstraints gbc_textFieldSinopsis = new GridBagConstraints();
		gbc_textFieldSinopsis.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSinopsis.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSinopsis.gridx = 1;
		gbc_textFieldSinopsis.gridy = 3;
		add(textFieldSinopsis, gbc_textFieldSinopsis);
		textFieldSinopsis.setColumns(10);
		
		JLabel lblFTecnica = new JLabel("Ficha tecnica de la pelicula: ");
		GridBagConstraints gbc_lblFTecnica = new GridBagConstraints();
		gbc_lblFTecnica.anchor = GridBagConstraints.EAST;
		gbc_lblFTecnica.fill = GridBagConstraints.VERTICAL;
		gbc_lblFTecnica.insets = new Insets(0, 0, 5, 5);
		gbc_lblFTecnica.gridx = 0;
		gbc_lblFTecnica.gridy = 4;
		add(lblFTecnica, gbc_lblFTecnica);
		
		JButton btnTrailer = new JButton("Ver trailer");
		btnTrailer.addActionListener(new ActionListener() {
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
		});
		
		textFieldFicha = new JTextField();
		textFieldFicha.setEditable(false);
		GridBagConstraints gbc_textFieldFicha = new GridBagConstraints();
		gbc_textFieldFicha.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFicha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFicha.gridx = 1;
		gbc_textFieldFicha.gridy = 4;
		add(textFieldFicha, gbc_textFieldFicha);
		textFieldFicha.setColumns(10);
		GridBagConstraints gbc_btnTrailer = new GridBagConstraints();
		gbc_btnTrailer.insets = new Insets(0, 0, 5, 0);
		gbc_btnTrailer.gridwidth = 2;
		gbc_btnTrailer.gridx = 0;
		gbc_btnTrailer.gridy = 5;
		add(btnTrailer, gbc_btnTrailer);
		
		JButton btnVerPuntYOpin = new JButton("Ver puntuaciones y opiniones");
		btnVerPuntYOpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
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
				//setVisible(false);
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
							//TODO: ventana alquilar pelicula
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
		
		JButton btnAtras = new JButton("Atr\u00E1s");
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
