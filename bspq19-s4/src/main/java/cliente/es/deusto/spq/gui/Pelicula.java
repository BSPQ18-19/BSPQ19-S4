package cliente.es.deusto.spq.gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Pelicula extends JFrame{

	private static final long serialVersionUID = 674330126384087764L;
	private JPanel contentPane;
	private static ImageIcon imagen = new ImageIcon("Icono//icono.jpg");
	
	public Pelicula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		contentPane.setLayout(gbl_contentPane);
	
		//TODO: introducir contenido
		
		JLabel lblTitulo = new JLabel("Titulo de la pelicula: ");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblGenero = new JLabel("Genero de la pelicula: ");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.fill = GridBagConstraints.VERTICAL;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 1;
		contentPane.add(lblGenero, gbc_lblGenero);
		
		JLabel lblFecha = new JLabel("Fecha de estreno de la pelicula: ");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.fill = GridBagConstraints.VERTICAL;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 2;
		contentPane.add(lblFecha, gbc_lblFecha);
		
		JLabel lblSinopsis = new JLabel("Sinopsis de la pelicula: ");
		GridBagConstraints gbc_lblSinopsis = new GridBagConstraints();
		gbc_lblSinopsis.fill = GridBagConstraints.VERTICAL;
		gbc_lblSinopsis.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinopsis.gridx = 0;
		gbc_lblSinopsis.gridy = 3;
		contentPane.add(lblSinopsis, gbc_lblSinopsis);
		
		JLabel lblFTecnica = new JLabel("Ficha tecnica de la pelicula: ");
		GridBagConstraints gbc_lblFTecnica = new GridBagConstraints();
		gbc_lblFTecnica.fill = GridBagConstraints.VERTICAL;
		gbc_lblFTecnica.insets = new Insets(0, 0, 5, 5);
		gbc_lblFTecnica.gridx = 0;
		gbc_lblFTecnica.gridy = 4;
		contentPane.add(lblFTecnica, gbc_lblFTecnica);
		
		JButton btnTrailer = new JButton("Ver trailer");
		btnTrailer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//TODO: reproducir trailer
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GridBagConstraints gbc_btnTrailer = new GridBagConstraints();
		gbc_btnTrailer.insets = new Insets(0, 0, 5, 0);
		gbc_btnTrailer.gridwidth = 2;
		gbc_btnTrailer.gridx = 0;
		gbc_btnTrailer.gridy = 5;
		contentPane.add(btnTrailer, gbc_btnTrailer);
		
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
		contentPane.add(btnVerPuntYOpin, gbc_btnVerPuntYOpin);
		
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
		contentPane.add(btnDejarPuntYOpin, gbc_btnDejarPuntYOpin);
		
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
		contentPane.add(btnAlquilar, gbc_btnAlquilar);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BuscarPelicula frame = new BuscarPelicula();
							frame.setVisible(true);
							frame.setTitle("Buscar Pelicula");
							frame.setIconImage(imagen.getImage());
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
		contentPane.add(btnAtras, gbc_btnAtras);
	}
}
