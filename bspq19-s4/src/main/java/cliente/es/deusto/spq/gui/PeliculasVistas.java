package cliente.es.deusto.spq.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cliente.es.deusto.spq.controller.PeliculasFavoritasController;
import cliente.es.deusto.spq.controller.PeliculasVistasController;
import servidor.es.deusto.spq.jdo.Pelicula;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PeliculasVistas extends JFrame implements ActionListener{
	private static final long serialVersionUID = 8617549966130702827L;
	private static PeliculasVistas INSTANCE;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	private JLabel lblPeliculasVistas;
	private JButton btnVolver;
	private JFrame ventanaAnterior;
	private JScrollPane scrollPaneTabla;
	private JTable tablaPeliculasVistas;
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	private PeliculasVistasController controller = null;
	String vistas = null;
	
	public static PeliculasVistas getInstance() {
		return INSTANCE;
	}
	
	public void dispose() {
		INSTANCE.setVisible(false);
	}
	
	public PeliculasVistas(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		lblPeliculasVistas = new JLabel("Las películas vistas son las siguientes:");
		panelNorte.add(lblPeliculasVistas);
		
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
		
		tablaPeliculasVistas = new JTable();
		tablaPeliculasVistas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Genero", "Fecha Estreno", "Ficha Tecnica", "Sinopsis" 
			}
		));
		scrollPaneTabla.setViewportView(tablaPeliculasVistas);
		
		List<Pelicula> peliculasVistas = new ArrayList<>();
		
		peliculasVistas = (List<Pelicula>)controller.buscarPeliculasVistas(vistas);
		for (int i = 0; i < peliculasVistas.size(); i++) {
			cargarPeliculasVistasEnTabla(peliculasVistas.get(i));
		}
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		
		JButton botonPulsado = (JButton) e.getSource();
		if(botonPulsado == btnVolver){
			this.dispose();
			ventanaAnterior.setVisible(true);
		}
	}
	
	private void cargarPeliculasVistasEnTabla(Pelicula p) {
		modeloTabla = (DefaultTableModel)tablaPeliculasVistas.getModel();
		String titulo = p.getTitulo();
		String genero = p.getGenero();
		String fEstreno = p.getfEstreno();
		String fichaTecnica = p.getFichaTecnica();
		String sinopsis = p.getSinopsis();
		
		Object[] fila = {titulo, genero, fEstreno, fichaTecnica, sinopsis};
		modeloTabla.addRow(fila);  	
	}
	
	private static List<Pelicula> buscarPeliculasVistas(String vistas) {
		return PeliculasVistas.getInstance().getController().buscarPeliculasVistas(vistas);
	}
	
	public PeliculasVistasController getController() {
		return controller;
	}
		
	public void setController(PeliculasVistasController controller) {
			this.controller = controller;
	}
}
