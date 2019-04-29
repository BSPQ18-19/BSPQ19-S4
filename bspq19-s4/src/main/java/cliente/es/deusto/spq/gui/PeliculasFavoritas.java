package cliente.es.deusto.spq.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cliente.es.deusto.spq.controller.PeliculasFavoritasController;
import servidor.es.deusto.spq.jdo.Pelicula;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PeliculasFavoritas extends JFrame implements ActionListener {
	private static final long serialVersionUID = 8617549966130702827L;
	private static PeliculasFavoritas INSTANCE;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	private JLabel lblPeliculasFavoritas;
	private JButton btnVolver;
	private JFrame ventanaAnterior;
	private JScrollPane scrollPaneTabla;
	private JTable tablaPeliculasFavoritas;
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	private PeliculasFavoritasController controller = null;
	String favoritas = null;

	public static PeliculasFavoritas getInstance() {
		return INSTANCE;
	}
		
	public void dispose(){
		INSTANCE.setVisible(false);
	}


	public PeliculasFavoritas(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		lblPeliculasFavoritas = new JLabel("Las películas favoritas son las siguientes:");
		panelNorte.add(lblPeliculasFavoritas);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		panelSur.add(btnVolver);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setToolTipText("");
		scrollPaneTabla.setBounds(20, 90, 200, 250);
		panelCentro.add(scrollPaneTabla);
		
		tablaPeliculasFavoritas = new JTable();
		tablaPeliculasFavoritas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Titulo", "Genero", "Fecha Estreno", "Ficha Tecnica", "Sinopsis" 
			}
		));
		scrollPaneTabla.setViewportView(tablaPeliculasFavoritas);

		List<Pelicula> peliculasFavoritas = new ArrayList<>();
		
		peliculasFavoritas = (List<Pelicula>)controller.buscarPeliculasFavoritas(favoritas);
		for (int i = 0; i < peliculasFavoritas.size(); i++) {
			cargarPeliculasFavoritasEnTabla(peliculasFavoritas.get(i));
		}
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		JButton botonPulsado = (JButton) e.getSource();
		if(botonPulsado == btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
		}
	}
	
	private void cargarPeliculasFavoritasEnTabla(Pelicula p){
		modeloTabla = (DefaultTableModel)tablaPeliculasFavoritas.getModel();
		String titulo = p.getTitulo();
		String genero = p.getGenero();
		String fEstreno = p.getfEstreno();
		String fichaTecnica = p.getFichaTecnica();
		String sinopsis = p.getSinopsis();

		Object[] fila = {titulo, genero, fEstreno, fichaTecnica, sinopsis};
		modeloTabla.addRow(fila);                   
	}
	
	private static List<Pelicula> buscarPeliculasFavoritas(String favoritas) {
		return PeliculasFavoritas.getInstance().getController().buscarPeliculasFavoritas(favoritas);
	}
	
	public PeliculasFavoritasController getController() {
		return controller;
	}
		
	public void setController(PeliculasFavoritasController controller) {
			this.controller = controller;
	}
}
