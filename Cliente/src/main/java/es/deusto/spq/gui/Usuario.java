package es.deusto.spq.gui;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class Usuario extends JFrame{

	private static final long serialVersionUID = -1644310303190255276L;
	private JPanel contentPane;
	private static ImageIcon imagen= new ImageIcon("Icono//icono.jpg");
	
	//TODO:eliminar hasta la linea 30 cuando funcione la BD
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Usuario frame = new Usuario();
						frame.setVisible(true);
						frame.setTitle("Usuario");
						frame.setIconImage(imagen.getImage());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 175};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMostrarPeliculas = new JLabel("Las peliculas registradas en este momento son:");
		GridBagConstraints gbc_lblMostrarPeliculas = new GridBagConstraints();
		gbc_lblMostrarPeliculas.gridwidth = 3;
		gbc_lblMostrarPeliculas.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrarPeliculas.gridx = 0;
		gbc_lblMostrarPeliculas.gridy = 0;
		contentPane.add(lblMostrarPeliculas, gbc_lblMostrarPeliculas);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		//TODO: Cargar String[]usuarios con los nombres de todos los usuarios de la BD
		String[]peliculas = null;
		Arrays.sort(peliculas);
		
//		JList<String> listMostarPeliculas = new JList<String>(peliculas);
//		listMostarPeliculas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		listMostarPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		scrollPane.setViewportView(listMostarPeliculas);
		
		JButton btnTitulo = new JButton("Titulo");
		btnTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
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
		gbc_btnTitulo.gridy = 2;
		contentPane.add(btnTitulo, gbc_btnTitulo);
		
		JButton btnGenero = new JButton("Genero");
		btnGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
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
		gbc_btnGenero.gridy = 2;
		contentPane.add(btnGenero, gbc_btnGenero);
		
		JButton btnFecha = new JButton("Fecha");
		btnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		GridBagConstraints gbc_btnFecha = new GridBagConstraints();
		gbc_btnFecha.insets = new Insets(0, 0, 5, 0);
		gbc_btnFecha.gridx = 2;
		gbc_btnFecha.gridy = 2;
		contentPane.add(btnFecha, gbc_btnFecha);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaPrincipal frame = new VentanaPrincipal();
							frame.setVisible(true);
							frame.setTitle("Login");
							frame.setIconImage(imagen.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridwidth = 3;
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 3;
		contentPane.add(btnAtras, gbc_btnAtras);
	}
}
