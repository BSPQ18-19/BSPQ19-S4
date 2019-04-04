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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BorrarPelicula extends JFrame {
	private static final long serialVersionUID = -2878465684552734783L;
	private JPanel contentPane;
	private JButton btnBorrar;
	private JList<String> listMostarPeliculas;
	private String[] peliculas;
	private static ImageIcon imagen = new ImageIcon("Icono//icono.jpg");

	public BorrarPelicula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblMostrarPelicula = new JLabel("Seleccione la pelicula que desea borrar:");
		GridBagConstraints gbc_lblMostrarPelicula = new GridBagConstraints();
		gbc_lblMostrarPelicula.gridwidth = 2;
		gbc_lblMostrarPelicula.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrarPelicula.gridx = 0;
		gbc_lblMostrarPelicula.gridy = 0;
		contentPane.add(lblMostrarPelicula, gbc_lblMostrarPelicula);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		// TODO: Cargar String[]peliculas con los titulos de todas las peliculas de la
		// BD
		peliculas = null;
		Arrays.sort(peliculas);

//		listMostarPeliculas = new JList<String>(peliculas);
//		listMostarPeliculas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		listMostarPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		scrollPane.setViewportView(listMostarPeliculas);

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
				// TODO: eliminar la pelicula con titulo n de la BD
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Peliculas frame = new Peliculas();
							frame.setVisible(true);
							frame.setTitle("Base de datos de peliculas");
							frame.setIconImage(imagen.getImage());
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
		gbc_btnBorrar.gridwidth = 2;
		gbc_btnBorrar.gridx = 0;
		gbc_btnBorrar.gridy = 2;
		contentPane.add(btnBorrar, gbc_btnBorrar);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Peliculas frame = new Peliculas();
							frame.setVisible(true);
							frame.setTitle("Base de datos de peliculas");
							frame.setIconImage(imagen.getImage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridwidth = 2;
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 3;
		contentPane.add(btnAtras, gbc_btnAtras);
	}

}
