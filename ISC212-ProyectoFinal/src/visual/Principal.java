package visual;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import logic.Administrador;
import logic.Tienda;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;

	public Principal() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream tienda2;
				ObjectOutputStream write;
				try {
					tienda2 = new FileOutputStream("data.dat");
					write = new ObjectOutputStream(tienda2);
					write.writeObject(Tienda.getInstance());
				} catch(FileNotFoundException e1) {
					e1.printStackTrace();
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
				
		setTitle("Cecomsa - Gestion de Sucursal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/logo.png")));
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
				Entidades entidades = new Entidades(0);
				entidades.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JSeparator separator_6 = new JSeparator();
		mnNewMenu_3.add(separator_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Cuentas por cobrar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuentasCobrar cuentasCobrar = new CuentasCobrar();
				cuentasCobrar.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JSeparator separator_7 = new JSeparator();
		mnNewMenu_3.add(separator_7);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Reportes");
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu = new JMenu("Inventario");
		if(!(Tienda.getLoginUser() instanceof Administrador)) {
			mnNewMenu.setEnabled(false);
		}
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
				Entidades entidades = new Entidades(2);
				entidades.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_2.add(separator);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Cuentas por pagar");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuentasPagar cuentasPagar = new CuentasPagar();
				cuentasPagar.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu_2.add(separator_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Reportes");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("Empleados");
		if(!(Tienda.getLoginUser() instanceof Administrador)) {
			mnNewMenu_4.setEnabled(false);
		}
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("Empleados");
		mnNewMenu_4.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Ver/Modificar/Crear Empleados");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entidades entidades = new Entidades(1);
				entidades.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_11);
		
		JSeparator separator_11 = new JSeparator();
		mnNewMenu_5.add(separator_11);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Reportes");
		mnNewMenu_5.add(mntmNewMenuItem_14);
		
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
