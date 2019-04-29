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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cliente.es.deusto.spq.controller.BorrarUsuarioController;
import servidor.es.deusto.spq.jdo.Cuenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class BorrarUsuario extends JFrame {
	private static final long serialVersionUID = -2878465684552734783L;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	private JLabel lblMostrarUsuario;
	private JButton btnBorrar, btnAtras;
	private JScrollPane scrollPaneTabla;
	private JTable tablaUsuarios;
	//private JFrame ventanaAnterior;
	private static BorrarUsuario INSTANCE;
	private BorrarUsuarioController controller = null;
	private String correo, nombre;
	List<Cuenta> usuarios = new ArrayList<>();
	
	public static BorrarUsuario getInstance() {
		return INSTANCE;
	}
	
	public void dispose() {
		INSTANCE.setVisible(false);
	}
	
	public BorrarUsuario(BorrarUsuarioController controller, String correo, String nombre) {
		this.controller = controller;
		this.correo = correo;
		this.nombre = nombre;
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
		
		lblMostrarUsuario = new JLabel("Seleccione el usuario que desea borrar:");
		panelNorte.add(lblMostrarUsuario);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablaUsuarios.getSelectedRow() >= 0) {
					System.out.println(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0));
					int usuarios = 0;
					try {
						String correo = (String)tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0);
						String nombre = (String)tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 1);
						String contrasenna = (String)tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2);
						String paypal = (String)tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 3);
						int privilegio = (int)tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 4);
						double gasto = (double)tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 5);
						
						Cuenta u = new Cuenta(correo, nombre, contrasenna, paypal, privilegio, gasto);
					
						controller.borrarUsuario(u, nombre);
						JOptionPane.showMessageDialog(null, "El usuario seleccionado se ha eliminado correctamente", "ENHORABUENA", JOptionPane.INFORMATION_MESSAGE);
					} catch (NumberFormatException ex) {
						
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Antes de eliminar un usuario, seleccione uno de ellos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}	
		});
		panelSur.add(btnBorrar);
		
		btnAtras = new JButton("Atrás");
		panelSur.add(btnAtras);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		panelCentro.add(tablaUsuarios);
		
		scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setBounds(17, 197, 643, 250);
		panelCentro.add(scrollPaneTabla);
		
		tablaUsuarios = new JTable();
		tablaUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Correo", "Nombre", "Contraseña", "PayPal", "Privilegio", "Gasto"
			}
		));
		scrollPaneTabla.setViewportView(tablaUsuarios);
	}

}
