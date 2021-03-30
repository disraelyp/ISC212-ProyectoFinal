package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Tienda {

	private JFrame frmCecomsaGestion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda window = new Tienda();
					window.frmCecomsaGestion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tienda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCecomsaGestion = new JFrame();
		frmCecomsaGestion.setTitle("Cecomsa - Gestion de Sucursal");
		frmCecomsaGestion.setIconImage(Toolkit.getDefaultToolkit().getImage(Tienda.class.getResource("/resources/logo.png")));
		frmCecomsaGestion.setBounds(100, 100, 1000, 700);
		frmCecomsaGestion.setLocationRelativeTo(null);
		frmCecomsaGestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCecomsaGestion.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmCecomsaGestion.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frmCecomsaGestion.setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Facturacion");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Modulo de Facturacion");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturacion facturacion = new Facturacion();
				facturacion.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JSeparator separator_4 = new JSeparator();
		mnNewMenu_1.add(separator_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Reportes");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JSeparator separator_5 = new JSeparator();
		mnNewMenu_1.add(separator_5);
		
		JMenu mnNewMenu_3 = new JMenu("Clientes");
		mnNewMenu_1.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Ver/Modificar/Crear Clientes");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoClientes listadoClientes = new ListadoClientes(false);
				listadoClientes.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JSeparator separator_6 = new JSeparator();
		mnNewMenu_3.add(separator_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Cuentas por cobrar");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JSeparator separator_7 = new JSeparator();
		mnNewMenu_3.add(separator_7);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Reportes");
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu = new JMenu("Inventario");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Modulo de Inventario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventario inventario = new Inventario();
				inventario.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reportes");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu.add(separator_3);
		
		JMenu mnNewMenu_2 = new JMenu("Proveedores");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ver/Modificar/Crear Proveedores");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoProveedores listadoProveedores = new ListadoProveedores(false);
				listadoProveedores.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_2.add(separator);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Cuentas por pagar");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu_2.add(separator_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Reportes");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("Empleados");
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("Vendedores");
		mnNewMenu_4.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Ver/Modificar/Crear Vendedores");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoVendedores listadoVendedores = new ListadoVendedores(false);
				listadoVendedores.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_11);
		
		JSeparator separator_11 = new JSeparator();
		mnNewMenu_5.add(separator_11);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Reportes");
		mnNewMenu_5.add(mntmNewMenuItem_14);
		
		JSeparator separator_12 = new JSeparator();
		mnNewMenu_4.add(separator_12);
		
		JMenu mnNewMenu_6 = new JMenu("Administradores");
		mnNewMenu_4.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Ver/Modificar/Crear Administradores");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoAdministradores listadoAdministradores = new ListadoAdministradores(false);
				listadoAdministradores.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_10);
		
		JSeparator separator_8 = new JSeparator();
		mnNewMenu_6.add(separator_8);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Reportes");
		mnNewMenu_6.add(mntmNewMenuItem_15);
		
		JSeparator separator_10 = new JSeparator();
		mnNewMenu_4.add(separator_10);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Nominas");
		mnNewMenu_4.add(mntmNewMenuItem_12);
		
		JSeparator separator_9 = new JSeparator();
		mnNewMenu_4.add(separator_9);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Reportes de pago");
		mnNewMenu_4.add(mntmNewMenuItem_13);
	}

}
