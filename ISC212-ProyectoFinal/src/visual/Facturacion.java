package visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.ImageIcon;

public class Facturacion extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model1;
	private static DefaultTableModel model2;
	private static DefaultTableModel model4;
	private JTable tableFactura;
	private JTable tableCotizacion;
	private JButton btnCrearFactura;
	private JButton btnModificarFactura;
	private JButton btnDuplicarFactura;
	private JComboBox<String> cmbOrden;
	private JComboBox<String> cmbOrdenCotizacion;
	private JButton btnSalirCotizacion;
	private JButton btnSalirFactura;
	private JTable tableDevoluciones;

	public Facturacion() {
		setResizable(false);
		setTitle("Modulo de Facturacion");
		setModal(true);
		setBounds(100, 100, 750, 550);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 744, 522);
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelT = new JPanel();
		contentPanel.add(panelT, BorderLayout.CENTER);
		panelT.setLayout(null);
		
		// EMPIEZA AQUI
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 719, 496);
		panelT.add(tabbedPane);
		
		JPanel panelFacturas = new JPanel();
		tabbedPane.addTab("Facturas", null, panelFacturas, null);
		panelFacturas.setLayout(null);
		
		btnCrearFactura = new JButton("");
		btnCrearFactura.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/facturar.png")));
		btnCrearFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroVenta registroVenta = new RegistroVenta();
				registroVenta.setVisible(true);
			}
		});
		btnCrearFactura.setBounds(90, 391, 70, 70);
		panelFacturas.add(btnCrearFactura);
		
		btnModificarFactura = new JButton("");
		btnModificarFactura.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/modificar.png")));
		btnModificarFactura.setBounds(170, 391, 70, 70);
		panelFacturas.add(btnModificarFactura);
		
		btnDuplicarFactura = new JButton("");
		btnDuplicarFactura.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/duplicar.png")));
		btnDuplicarFactura.setBounds(250, 391, 70, 70);
		panelFacturas.add(btnDuplicarFactura);
		
		btnSalirFactura = new JButton("");
		btnSalirFactura.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/salir.png")));
		btnSalirFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirFactura.setBounds(634, 391, 70, 70);
		panelFacturas.add(btnSalirFactura);
		
		JButton btnDevolucionFactura = new JButton("");
		btnDevolucionFactura.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/devolver.png")));
		btnDevolucionFactura.setBounds(330, 391, 70, 70);
		panelFacturas.add(btnDevolucionFactura);
		
		JLabel lblOrdenar = new JLabel("Ordenar por:");
		lblOrdenar.setBounds(10, 11, 78, 14);
		panelFacturas.add(lblOrdenar);
		
		cmbOrden = new JComboBox<String>();
		cmbOrden.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "VENDEDOR", "MONTO", "FECHA", "CLIENTE"}));
		cmbOrden.setBounds(90, 8, 150, 20);
		panelFacturas.add(cmbOrden);
		
		JPanel panelTablaFactura = new JPanel();
		panelTablaFactura.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTablaFactura.setBounds(10, 36, 694, 349);
		panelFacturas.add(panelTablaFactura);
		panelTablaFactura.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneFactura = new JScrollPane();
		panelTablaFactura.add(scrollPaneFactura, BorderLayout.CENTER);
		
		tableFactura = new JTable();
		tableFactura.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model1 = new DefaultTableModel();
		tableFactura.setModel(model1);
		tableFactura.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableFactura.getTableHeader().setReorderingAllowed(false);
		
		String[] headers1= {"Codigo", "Fecha", "Cliente", "Vendedor", "Monto Total"};
		model1.setColumnIdentifiers(headers1);
		TableColumnModel columModel1 = tableFactura.getColumnModel();
		columModel1.getColumn(0).setPreferredWidth(90);
		columModel1.getColumn(1).setPreferredWidth(90);
		columModel1.getColumn(2).setPreferredWidth(300);
		columModel1.getColumn(3).setPreferredWidth(100);
		columModel1.getColumn(4).setPreferredWidth(114);
		scrollPaneFactura.setViewportView(tableFactura);
		
		JButton btnVerFactura = new JButton("");
		btnVerFactura.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/abrir.png")));
		btnVerFactura.setBounds(10, 391, 70, 70);
		panelFacturas.add(btnVerFactura);
		
		JPanel panelCotizaciones = new JPanel();
		tabbedPane.addTab("Cotizaciones", null, panelCotizaciones, null);
		panelCotizaciones.setLayout(null);
		
		JButton btnCrearCotizacion = new JButton("");
		btnCrearCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/cotizar.png")));
		btnCrearCotizacion.setBounds(170, 391, 70, 70);
		panelCotizaciones.add(btnCrearCotizacion);
		
		JButton btnModificarCotizacion = new JButton("");
		btnModificarCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/modificar.png")));
		btnModificarCotizacion.setBounds(250, 391, 70, 70);
		panelCotizaciones.add(btnModificarCotizacion);
		
		JButton btnDuplicarCotizacion = new JButton("");
		btnDuplicarCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/duplicar.png")));
		btnDuplicarCotizacion.setBounds(330, 391, 70, 70);
		panelCotizaciones.add(btnDuplicarCotizacion);
		
		btnSalirCotizacion = new JButton("");
		btnSalirCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/salir.png")));
		btnSalirCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirCotizacion.setBounds(634, 391, 70, 70);
		panelCotizaciones.add(btnSalirCotizacion);
		
		JButton btnEliminarCotizacion = new JButton("");
		btnEliminarCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/eliminar.png")));
		btnEliminarCotizacion.setBounds(410, 391, 70, 70);
		panelCotizaciones.add(btnEliminarCotizacion);
		
		JButton btnRecibirCotizacion = new JButton("");
		btnRecibirCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/facturar.png")));
		btnRecibirCotizacion.setBounds(10, 391, 70, 70);
		panelCotizaciones.add(btnRecibirCotizacion);
		
		JLabel lblOrdenarCotizacion = new JLabel("Ordenar por:");
		lblOrdenarCotizacion.setBounds(10, 11, 78, 14);
		panelCotizaciones.add(lblOrdenarCotizacion);
		
		cmbOrdenCotizacion = new JComboBox<String>();
		cmbOrdenCotizacion.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "VENDEDOR", "MONTO", "FECHA", "CLIENTE"}));
		cmbOrdenCotizacion.setBounds(90, 8, 150, 20);
		panelCotizaciones.add(cmbOrdenCotizacion);
		
		JPanel panelTablaCotizacion = new JPanel();
		panelTablaCotizacion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTablaCotizacion.setBounds(10, 36, 694, 349);
		panelCotizaciones.add(panelTablaCotizacion);
		panelTablaCotizacion.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneCotizacion = new JScrollPane();
		panelTablaCotizacion.add(scrollPaneCotizacion, BorderLayout.CENTER);
		
		tableCotizacion = new JTable();
		tableCotizacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model2 = new DefaultTableModel();
		tableCotizacion.setModel(model2);
		tableCotizacion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableCotizacion.getTableHeader().setReorderingAllowed(false);
		
		String[] headers2= {"Codigo", "Fecha", "Cliente", "Vendedor", "Monto Total"};
		model2.setColumnIdentifiers(headers2);
		TableColumnModel columModel2 = tableCotizacion.getColumnModel();
		columModel2.getColumn(0).setPreferredWidth(90);
		columModel2.getColumn(1).setPreferredWidth(90);
		columModel2.getColumn(2).setPreferredWidth(300);
		columModel2.getColumn(3).setPreferredWidth(100);
		columModel2.getColumn(4).setPreferredWidth(114);
		scrollPaneCotizacion.setViewportView(tableCotizacion);
		
		JButton btnVerCotizacion = new JButton("");
		btnVerCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/abrir.png")));
		btnVerCotizacion.setBounds(90, 391, 70, 70);
		panelCotizaciones.add(btnVerCotizacion);
		
		JPanel panelDevoluciones = new JPanel();
		tabbedPane.addTab("Devoluciones", null, panelDevoluciones, null);
		panelDevoluciones.setLayout(null);
		
		JLabel label = new JLabel("Ordenar por:");
		label.setBounds(10, 11, 78, 14);
		panelDevoluciones.add(label);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "VENDEDOR", "MONTO", "FECHA", "CLIENTE"}));
		comboBox.setBounds(90, 8, 150, 20);
		panelDevoluciones.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 694, 344);
		panelDevoluciones.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tableDevoluciones = new JTable();
		tableDevoluciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model4 = new DefaultTableModel();
		tableDevoluciones.setModel(model4);
		tableDevoluciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDevoluciones.getTableHeader().setReorderingAllowed(false);
		
		String[] headers4= {"Codigo", "Fecha", "Cliente", "Vendedor", "Monto Total"};
		model4.setColumnIdentifiers(headers4);
		TableColumnModel columModel4 = tableDevoluciones.getColumnModel();
		columModel4.getColumn(0).setPreferredWidth(90);
		columModel4.getColumn(1).setPreferredWidth(90);
		columModel4.getColumn(2).setPreferredWidth(300);
		columModel4.getColumn(3).setPreferredWidth(100);
		columModel4.getColumn(4).setPreferredWidth(114);
		scrollPane.setViewportView(tableDevoluciones);
		
		JButton btnProcesar = new JButton("");
		btnProcesar.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/retirar.png")));
		btnProcesar.setBounds(10, 391, 70, 70);
		panelDevoluciones.add(btnProcesar);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/abrir.png")));
		button_1.setBounds(90, 391, 70, 70);
		panelDevoluciones.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/devolver.png")));
		button_2.setBounds(170, 391, 70, 70);
		panelDevoluciones.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/modificar.png")));
		button_3.setBounds(250, 391, 70, 70);
		panelDevoluciones.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/duplicar.png")));
		button_4.setBounds(330, 391, 70, 70);
		panelDevoluciones.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/eliminar.png")));
		button_5.setBounds(410, 391, 70, 70);
		panelDevoluciones.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/salir.png")));
		button_6.setBounds(634, 391, 70, 70);
		panelDevoluciones.add(button_6);
		// TERMINA AQUI
		
		
	}
}
