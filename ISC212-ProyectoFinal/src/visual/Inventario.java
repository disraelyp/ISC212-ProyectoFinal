package visual;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.CompraInventario;
import logic.OrdenInventario;
import logic.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Inventario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model1;
	private static Object[] rows1;
	private static DefaultTableModel model2;
	private static Object[] rows2;
	private static DefaultTableModel model3;
	private static Object[] rows3;
	private static DefaultTableModel model4;
	private static Object[] rows4;
	private JTable tableOrden;
	private JTable tableCotizacion;
	private JButton btnCrearOrden;
	private JButton btnModificarOrden;
	private JButton btnDuplicarOrden;
	private JComboBox<String> cmbOrden;
	private JComboBox<String> cmbOrdenCotizacion;
	private JButton btnSalirCotizacion;
	private JButton btnSalirOrden;
	private JTable tableDevoluciones;
	private JTable tableProductos;

	public Inventario() {
		setResizable(false);
		setTitle("Modulo de Inventario");
		setModal(true);
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 784, 512);
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 774, 500);
		contentPanel.add(tabbedPane);
		
		JPanel panelOrdenes = new JPanel();
		tabbedPane.addTab("Ordenes de Compras", null, panelOrdenes, null);
		panelOrdenes.setLayout(null);
		
		btnCrearOrden = new JButton("");
		btnCrearOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/comprar.png")));
		btnCrearOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroCompra registroCompra = new RegistroCompra();
				registroCompra.setVisible(true);
			}
		});
		btnCrearOrden.setBounds(90, 391, 70, 70);
		panelOrdenes.add(btnCrearOrden);
		
		btnModificarOrden = new JButton("");
		btnModificarOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/modificar.png")));
		btnModificarOrden.setBounds(170, 391, 70, 70);
		panelOrdenes.add(btnModificarOrden);
		
		btnDuplicarOrden = new JButton("");
		btnDuplicarOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/duplicar.png")));
		btnDuplicarOrden.setBounds(250, 391, 70, 70);
		panelOrdenes.add(btnDuplicarOrden);
		
		btnSalirOrden = new JButton("");
		btnSalirOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/salir.png")));
		btnSalirOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirOrden.setBounds(689, 391, 70, 70);
		panelOrdenes.add(btnSalirOrden);
		
		JButton btnDevolucionOrden = new JButton("");
		btnDevolucionOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/devolver.png")));
		btnDevolucionOrden.setBounds(330, 391, 70, 70);
		panelOrdenes.add(btnDevolucionOrden);
		
		JLabel lblOrdenar = new JLabel("Ordenar por:");
		lblOrdenar.setBounds(10, 11, 78, 14);
		panelOrdenes.add(lblOrdenar);
		
		cmbOrden = new JComboBox<String>();
		cmbOrden.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "PROVEEDOR", "MONTO", "FECHA"}));
		cmbOrden.setBounds(90, 8, 150, 20);
		panelOrdenes.add(cmbOrden);
		
		JPanel panelTablaOrden = new JPanel();
		panelTablaOrden.setBounds(10, 36, 749, 344);
		panelOrdenes.add(panelTablaOrden);
		panelTablaOrden.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneOrden = new JScrollPane();
		panelTablaOrden.add(scrollPaneOrden, BorderLayout.CENTER);
		
		tableOrden = new JTable();
		tableOrden.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model1 = new DefaultTableModel();
		tableOrden.setModel(model1);
		tableOrden.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableOrden.getTableHeader().setReorderingAllowed(false);
		
		String[] headers1= {"Codigo", "Fecha", "Proveedor", "Estado", "Monto Total"};
		model1.setColumnIdentifiers(headers1);
		TableColumnModel columModel1 = tableOrden.getColumnModel();
		columModel1.getColumn(0).setPreferredWidth(90);
		columModel1.getColumn(1).setPreferredWidth(90);
		columModel1.getColumn(2).setPreferredWidth(330);
		columModel1.getColumn(3).setPreferredWidth(120);
		columModel1.getColumn(4).setPreferredWidth(114);
		scrollPaneOrden.setViewportView(tableOrden);
		
		JButton btnVerOrden = new JButton("");
		btnVerOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/abrir.png")));
		btnVerOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVerOrden.setBounds(10, 391, 70, 70);
		panelOrdenes.add(btnVerOrden);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Inventario.class.getResource("/resources/eliminar.png")));
		button.setBounds(410, 391, 70, 70);
		panelOrdenes.add(button);
		
		JButton btnRecibir = new JButton("");
		btnRecibir.setIcon(new ImageIcon(Inventario.class.getResource("/resources/recibir.png")));
		btnRecibir.setBounds(490, 391, 70, 70);
		panelOrdenes.add(btnRecibir);
		
		JPanel panelCotizaciones = new JPanel();
		tabbedPane.addTab("Cotizaciones", null, panelCotizaciones, null);
		panelCotizaciones.setLayout(null);
		
		JButton btnCrearCotizacion = new JButton("");
		btnCrearCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/cotizar.png")));
		btnCrearCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearCotizacion.setBounds(170, 391, 70, 70);
		panelCotizaciones.add(btnCrearCotizacion);
		
		JButton btnModificarCotizacion = new JButton("");
		btnModificarCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/modificar.png")));
		btnModificarCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificarCotizacion.setBounds(250, 391, 70, 70);
		panelCotizaciones.add(btnModificarCotizacion);
		
		JButton btnDuplicarCotizacion = new JButton("");
		btnDuplicarCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/duplicar.png")));
		btnDuplicarCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDuplicarCotizacion.setBounds(330, 391, 70, 70);
		panelCotizaciones.add(btnDuplicarCotizacion);
		
		btnSalirCotizacion = new JButton("");
		btnSalirCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/salir.png")));
		btnSalirCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSalirCotizacion.setBounds(689, 391, 70, 70);
		panelCotizaciones.add(btnSalirCotizacion);
		
		JButton btnEliminarCotizacion = new JButton("");
		btnEliminarCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/eliminar.png")));
		btnEliminarCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarCotizacion.setBounds(410, 391, 70, 70);
		panelCotizaciones.add(btnEliminarCotizacion);
		
		JButton btnRecibirCotizacion = new JButton("");
		btnRecibirCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/comprar.png")));
		btnRecibirCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRecibirCotizacion.setBounds(10, 391, 70, 70);
		panelCotizaciones.add(btnRecibirCotizacion);
		
		JLabel lblOrdenarCotizacion = new JLabel("Ordenar por:");
		lblOrdenarCotizacion.setBounds(10, 11, 78, 14);
		panelCotizaciones.add(lblOrdenarCotizacion);
		
		cmbOrdenCotizacion = new JComboBox<String>();
		cmbOrdenCotizacion.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "PROVEEDOR", "MONTO", "FECHA"}));
		cmbOrdenCotizacion.setBounds(90, 8, 150, 20);
		panelCotizaciones.add(cmbOrdenCotizacion);
		
		JPanel panelTablaCotizacion = new JPanel();
		panelTablaCotizacion.setBounds(10, 36, 749, 344);
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
		
		String[] headers2= {"Codigo", "Fecha", "Proveedor", "Estado", "Monto Total"};
		model2.setColumnIdentifiers(headers2);
		TableColumnModel columModel2 = tableCotizacion.getColumnModel();
		columModel2.getColumn(0).setPreferredWidth(90);
		columModel2.getColumn(1).setPreferredWidth(90);
		columModel2.getColumn(2).setPreferredWidth(330);
		columModel2.getColumn(3).setPreferredWidth(120);
		columModel2.getColumn(4).setPreferredWidth(114);
		scrollPaneCotizacion.setViewportView(tableCotizacion);
		
		JButton btnVerCotizacion = new JButton("");
		btnVerCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/abrir.png")));
		btnVerCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVerCotizacion.setBounds(90, 391, 70, 70);
		panelCotizaciones.add(btnVerCotizacion);
		
		// EMPEZO AQUI
		
		
		
		// TERMINO AQUI
		JPanel panelDevoluciones = new JPanel();
		tabbedPane.addTab("Devoluciones", null, panelDevoluciones, null);
		panelDevoluciones.setLayout(null);
		
		JLabel label = new JLabel("Ordenar por:");
		label.setBounds(10, 11, 78, 14);
		panelDevoluciones.add(label);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "PROVEEDOR", "MONTO", "FECHA"}));
		comboBox.setBounds(90, 8, 150, 20);
		panelDevoluciones.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 749, 344);
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
		
		String[] headers4= {"Codigo", "Fecha", "Proveedor", "Estado", "Monto Total"};
		model4.setColumnIdentifiers(headers4);
		TableColumnModel columModel4 = tableDevoluciones.getColumnModel();
		columModel4.getColumn(0).setPreferredWidth(90);
		columModel4.getColumn(1).setPreferredWidth(90);
		columModel4.getColumn(2).setPreferredWidth(330);
		columModel4.getColumn(3).setPreferredWidth(120);
		columModel4.getColumn(4).setPreferredWidth(114);
		scrollPane.setViewportView(tableDevoluciones);
		
		JButton btnProcesar = new JButton("");
		btnProcesar.setIcon(new ImageIcon(Inventario.class.getResource("/resources/retirar.png")));
		btnProcesar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnProcesar.setBounds(10, 391, 70, 70);
		panelDevoluciones.add(btnProcesar);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Inventario.class.getResource("/resources/abrir.png")));
		button_1.setVerticalAlignment(SwingConstants.BOTTOM);
		button_1.setBounds(90, 391, 70, 70);
		panelDevoluciones.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Inventario.class.getResource("/resources/devolver.png")));
		button_2.setVerticalAlignment(SwingConstants.BOTTOM);
		button_2.setBounds(170, 391, 70, 70);
		panelDevoluciones.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Inventario.class.getResource("/resources/modificar.png")));
		button_3.setVerticalAlignment(SwingConstants.BOTTOM);
		button_3.setBounds(250, 391, 70, 70);
		panelDevoluciones.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(Inventario.class.getResource("/resources/duplicar.png")));
		button_4.setVerticalAlignment(SwingConstants.BOTTOM);
		button_4.setBounds(330, 391, 70, 70);
		panelDevoluciones.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(Inventario.class.getResource("/resources/eliminar.png")));
		button_5.setVerticalAlignment(SwingConstants.BOTTOM);
		button_5.setBounds(410, 391, 70, 70);
		panelDevoluciones.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(Inventario.class.getResource("/resources/salir.png")));
		button_6.setVerticalAlignment(SwingConstants.BOTTOM);
		button_6.setBounds(689, 391, 70, 70);
		panelDevoluciones.add(button_6);
		
		JPanel panelProductos = new JPanel();
		tabbedPane.addTab("Listado de Productos", null, panelProductos, null);
		panelProductos.setLayout(null);
		
		JLabel label_1 = new JLabel("Ordenar por:");
		label_1.setBounds(10, 11, 78, 14);
		panelProductos.add(label_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO", "PROVEEDOR"}));
		comboBox_1.setBounds(90, 8, 150, 20);
		panelProductos.add(comboBox_1);
		
		JButton btnEmitirOrden = new JButton("EMITIR ORDEN");
		btnEmitirOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEmitirOrden.setBounds(10, 391, 70, 70);
		panelProductos.add(btnEmitirOrden);
		
		JButton btnEmitirDevolucion = new JButton("EMITIR DEVOLUCION");
		btnEmitirDevolucion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEmitirDevolucion.setBounds(90, 391, 70, 70);
		panelProductos.add(btnEmitirDevolucion);
		
		JButton btnCrearProducto = new JButton("");
		btnCrearProducto.setIcon(new ImageIcon(Inventario.class.getResource("/resources/abrir.png")));
		btnCrearProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearProducto.setBounds(170, 391, 70, 70);
		panelProductos.add(btnCrearProducto);
		
		JButton btnCrearProducto_1 = new JButton("CREAR PRODUCTO");
		btnCrearProducto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroComponente registroComponente = new RegistroComponente();
				registroComponente.setVisible(true);
			}
		});
		btnCrearProducto_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearProducto_1.setBounds(250, 391, 70, 70);
		panelProductos.add(btnCrearProducto_1);
		
		JButton btnModificarProducto = new JButton("MODIFICAR PRODUCTO");
		btnModificarProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificarProducto.setBounds(330, 391, 70, 70);
		panelProductos.add(btnModificarProducto);
		
		JButton button_12 = new JButton("Salir");
		button_12.setVerticalAlignment(SwingConstants.BOTTOM);
		button_12.setBounds(689, 391, 70, 70);
		panelProductos.add(button_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 36, 749, 344);
		panelProductos.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneProductos = new JScrollPane();
		panel_1.add(scrollPaneProductos, BorderLayout.CENTER);
		
		tableProductos = new JTable();
		tableProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model3 = new DefaultTableModel();
		tableProductos.setModel(model3);
		tableProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableProductos.getTableHeader().setReorderingAllowed(false);
		
		String[] headers3= {"Codigo", "Descripcion", "Cantidad", "Precio total", "Proveedor"};
		model3.setColumnIdentifiers(headers3);
		TableColumnModel columModel3 = tableProductos.getColumnModel();
		columModel3.getColumn(0).setPreferredWidth(90);
		columModel3.getColumn(1).setPreferredWidth(302);
		columModel3.getColumn(2).setPreferredWidth(90);
		columModel3.getColumn(3).setPreferredWidth(100);
		columModel3.getColumn(4).setPreferredWidth(114);
		scrollPaneProductos.setViewportView(tableProductos);		
		
		cargarTablas();
	}

	private void cargarTablas() {
		rows1 = new Object[model1.getColumnCount()];
		model1.setRowCount(0);
		for(OrdenInventario x: Tienda.getInstance().getOrdenes()) {
			if(x instanceof CompraInventario) {
				rows1[0]= ((CompraInventario) x).getCodigo();

				model1.addRow(rows1);
			}
		}
	}
}
