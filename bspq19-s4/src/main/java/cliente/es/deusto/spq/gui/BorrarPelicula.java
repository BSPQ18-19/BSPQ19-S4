package cliente.es.deusto.spq.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cliente.es.deusto.spq.controller.BorrarPeliculaController;
import servidor.es.deusto.spq.jdo.Pelicula;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class BorrarPelicula extends JFrame {
	private static final long serialVersionUID = -2878465684552734783L;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	private JLabel lblMostrarPelicula;
	private JButton btnBorrar, btnAtras;
	private JScrollPane scrollPaneTabla;
	private JTable tablaPeliculas;
	//private JFrame ventanaAnterior;
	private static BorrarPelicula INSTANCE;
	private BorrarPeliculaController controller = null;
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	private String titulo, genero;
	private JScrollPane scrollPane;
	private JTable tabla;
	List<Pelicula> peliculas = new ArrayList<>();
	
	public static BorrarPelicula getInstance() {
		return INSTANCE;
	}
	
	public void dispose() {
		INSTANCE.setVisible(false);
	}
	
	public BorrarPelicula(BorrarPeliculaController controller, String titulo, String genero) {
		this.controller = controller;
		this.titulo = titulo;
		this.genero = genero;
		ventana();
		this.setVisible(true);
	}

	public void ventana() {
		//ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		lblMostrarPelicula = new JLabel("Seleccione la película que desea borrar:");
		panelNorte.add(lblMostrarPelicula);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablaPeliculas.getSelectedRow() >= 0) {
					System.out.println(tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), 0));
					int peliculas = 0;
					try {
						String titulo = (String)tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), 0);
						String genero = (String)tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), 1);
						String fEstreno = (String)tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), 2);
						String trailer = (String)tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), 3);
						String fichaTecnica = (String)tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), 4);
						String sinopsis = (String)tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), 5);
						int puntuacion = (int)tablaPeliculas.getValueAt(tablaPeliculas.getSelectedRow(), 6);
						
						Pelicula p = new Pelicula(titulo, genero, fEstreno, trailer, fichaTecnica, sinopsis, puntuacion);
					
						controller.borrarPelicula(p, titulo);
						JOptionPane.showMessageDialog(null, "La película seleccionada se ha eliminado correctamente", "ENHORABUENA", JOptionPane.INFORMATION_MESSAGE);
					} catch (NumberFormatException ex) {
						
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Antes de eliminar una película, seleccione una de ellas", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}	
		});
		panelSur.add(btnBorrar);
		
		btnAtras = new JButton("Atrás");
		panelSur.add(btnAtras);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		panelCentro.add(tablaPeliculas);
		
		scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setBounds(17, 197, 643, 250);
		panelCentro.add(scrollPaneTabla);
		
		tablaPeliculas = new JTable();
		tablaPeliculas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Genero", "Fecha Estreno", "Ficha Técnica", "Sinopsis"
			}
		));
		scrollPaneTabla.setViewportView(tablaPeliculas);
	}

}
