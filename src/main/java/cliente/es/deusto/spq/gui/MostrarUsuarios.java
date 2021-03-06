package cliente.es.deusto.spq.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import cliente.es.deusto.spq.controller.MostrarUsuariosController;

public class MostrarUsuarios extends JPanel {
	private static final long serialVersionUID = 8617549966130702827L;

	public MostrarUsuarios(MostrarUsuariosController mostrarUsuariosController, CardLayout cardLayout) throws RemoteException{
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		JLabel lblMostrarUsuarios = new JLabel("Los usuarios registrados en este momento son:");
		GridBagConstraints gbc_lblMostrarUsuarios = new GridBagConstraints();
		gbc_lblMostrarUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_lblMostrarUsuarios.gridx = 0;
		gbc_lblMostrarUsuarios.gridy = 0;
		add(lblMostrarUsuarios, gbc_lblMostrarUsuarios);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		String[] usuarios = mostrarUsuariosController.mostrarUsuarios();
		Arrays.sort(usuarios);

		JList<String> listMostarUsuarios = new JList<String>(usuarios);
		listMostarUsuarios.setEnabled(false);
		listMostarUsuarios.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listMostarUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listMostarUsuarios);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cardLayout.show(getParent(), VentanaPrincipal.USUARIOS);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 2;
		add(btnAtras, gbc_btnAtras);
	}

}
