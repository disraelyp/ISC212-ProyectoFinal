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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.CotizacionVenta;
import logic.DevolucionVenta;
import logic.FacturaVenta;
import logic.OrdenVenta;
import logic.Tienda;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class Facturacion extends JDialog {

	private static String facturaSeleccionada=null;
	private static String cotizacionSeleccionada=null;
	private static String devolucionSeleccionada=null;

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelFacturas;
	private static DefaultTableModel modelCotizaciones;
	private static DefaultTableModel modelDevoluciones;

	private static Object[] rowsFacturas;
	private static Object[] rowsCotizaciones;
	private static Object[] rowsDevoluciones;
	
	private JTable tableFactura;
	private JTable tableCotizacion;
	private JButton btnCrearFactura;
	private JComboBox<String> cmbOrden;
	private JComboBox<String> cmbOrdenCotizacion;
	private JButton btnSalirCotizacion;
	private JButton btnSalirFactura;
	private JTable tableDevoluciones;
	private JButton btnVerFactura;
	private JButton btnDevolucionFactura;
	private JButton btnVerCotizacion;
	private JButton btnCrearCotizacion;
	private JButton btnModificarCotizacion;
	private JButton btnConvertirCotizacion;
	private JButton btnEliminarCotizacion;
	private JButton btnDevolucion;
	private JButton btnRecibirDevolucion;
	private JButton btnEditarDevolucion;
	private JButton btnEliminarDevolucion;
	private JButton btnSalirDevolucion;
	private JButton btnAbrirDevolucion;

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
				RegistroVenta registroVenta = new RegistroVenta(null, 0, 0);
				registroVenta.setVisible(true);
				cargarTablas();
			}
		});
		btnCrearFactura.setBounds(10, 391, 70, 70);
		panelFacturas.add(btnCrearFactura);
		
		btnSalirFactura = new JButton("");
		btnSalirFactura.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/salir.png")));
		btnSalirFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirFactura.setBounds(634, 391, 70, 70);
		panelFacturas.add(btnSalirFactura);
		
		btnDevolucionFactura = new JButton("");
		btnDevolucionFactura.setEnabled(false);
		btnDevolucionFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(5, 4, facturaSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnDevolucionFactura.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/devolver.png")));
		btnDevolucionFactura.setBounds(170, 391, 70, 70);
		panelFacturas.add(btnDevolucionFactura);
		
		JLabel lblOrdenar = new JLabel("Ordenar por:");
		lblOrdenar.setBounds(10, 11, 78, 14);
		panelFacturas.add(lblOrdenar);
		
		cmbOrden = new JComboBox<String>();
		cmbOrden.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "VENDEDOR", "MONTO", "FECHA", "CLIENTE"}));
		cmbOrden.setBounds(90, 8, 150, 20);
		panelFacturas.add(cmbOrden);
		
		JPanel panelTablaFactura = new JPanel();
		panelTablaFactura.setBounds(10, 36, 694, 349);
		panelFacturas.add(panelTablaFactura);
		panelTablaFactura.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneFactura = new JScrollPane();
		panelTablaFactura.add(scrollPaneFactura, BorderLayout.CENTER);
		
		tableFactura = new JTable();
		tableFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableFactura.getSelectedRow();
				facturaSeleccionada = tableFactura.getValueAt(seleccion,  0).toString();
				if(facturaSeleccionada!=null) {
					btnVerFactura.setEnabled(true);
					btnDevolucionFactura.setEnabled(true);
				}
			}
		});
		tableFactura.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelFacturas = new DefaultTableModel();
		tableFactura.setModel(modelFacturas);
		tableFactura.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableFactura.getTableHeader().setReorderingAllowed(false);
		
		String[] headers1= {"Codigo", "Fecha", "Cliente", "Vendedor", "Monto Total"};
		modelFacturas.setColumnIdentifiers(headers1);
		TableColumnModel columModel1 = tableFactura.getColumnModel();
		columModel1.getColumn(0).setPreferredWidth(90);
		columModel1.getColumn(1).setPreferredWidth(90);
		columModel1.getColumn(2).setPreferredWidth(200);
		columModel1.getColumn(3).setPreferredWidth(200);
		columModel1.getColumn(4).setPreferredWidth(110);
		scrollPaneFactura.setViewportView(tableFactura);
		
		btnVerFactura = new JButton("");
		btnVerFactura.setEnabled(false);
		btnVerFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(5, 2, facturaSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnVerFactura.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/abrir.png")));
		btnVerFactura.setBounds(90, 391, 70, 70);
		panelFacturas.add(btnVerFactura);
		
		JPanel panelCotizaciones = new JPanel();
		tabbedPane.addTab("Cotizaciones", null, panelCotizaciones, null);
		panelCotizaciones.setLayout(null);
		
		btnCrearCotizacion = new JButton("");
		btnCrearCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroVenta registroVenta = new RegistroVenta(null, 0, 2);
				registroVenta.setVisible(true);
				cargarTablas();
			}
		});
		btnCrearCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/cotizar.png")));
		btnCrearCotizacion.setBounds(10, 391, 70, 70);
		panelCotizaciones.add(btnCrearCotizacion);
		
		btnModificarCotizacion = new JButton("");
		btnModificarCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(6, 0, cotizacionSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnModificarCotizacion.setEnabled(false);
		btnModificarCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/modificar.png")));
		btnModificarCotizacion.setBounds(170, 391, 70, 70);
		panelCotizaciones.add(btnModificarCotizacion);
		
		btnSalirCotizacion = new JButton("");
		btnSalirCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/salir.png")));
		btnSalirCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirCotizacion.setBounds(634, 391, 70, 70);
		panelCotizaciones.add(btnSalirCotizacion);
		
		btnEliminarCotizacion = new JButton("");
		btnEliminarCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(6, 3, cotizacionSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnEliminarCotizacion.setEnabled(false);
		btnEliminarCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/eliminar.png")));
		btnEliminarCotizacion.setBounds(330, 391, 70, 70);
		panelCotizaciones.add(btnEliminarCotizacion);
		
		btnConvertirCotizacion = new JButton("");
		btnConvertirCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(6, 4, cotizacionSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnConvertirCotizacion.setEnabled(false);
		btnConvertirCotizacion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/facturar.png")));
		btnConvertirCotizacion.setBounds(250, 391, 70, 70);
		panelCotizaciones.add(btnConvertirCotizacion);
		
		JLabel lblOrdenarCotizacion = new JLabel("Ordenar por:");
		lblOrdenarCotizacion.setBounds(10, 11, 78, 14);
		panelCotizaciones.add(lblOrdenarCotizacion);
		
		cmbOrdenCotizacion = new JComboBox<String>();
		cmbOrdenCotizacion.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "VENDEDOR", "MONTO", "FECHA", "CLIENTE"}));
		cmbOrdenCotizacion.setBounds(90, 8, 150, 20);
		panelCotizaciones.add(cmbOrdenCotizacion);
		
		JPanel panelTablaCotizacion = new JPanel();
		panelTablaCotizacion.setBounds(10, 36, 694, 349);
		panelCotizaciones.add(panelTablaCotizacion);
		panelTablaCotizacion.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneCotizacion = new JScrollPane();
		panelTablaCotizacion.add(scrollPaneCotizacion, BorderLayout.CENTER);
		
		tableCotizacion = new JTable();
		tableCotizacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableCotizacion.getSelectedRow();
				cotizacionSeleccionada = tableCotizacion.getValueAt(seleccion,  0).toString();
				if(cotizacionSeleccionada!=null) {
					btnEliminarCotizacion.setEnabled(true);
					btnModificarCotizacion.setEnabled(true);
					btnConvertirCotizacion.setEnabled(true);
					btnVerCotizacion.setEnabled(true);
				} else {
					btnEliminarCotizacion.setEnabled(false);
					btnModificarCotizacion.setEnabled(false);
					btnConvertirCotizacion.setEnabled(false);
					btnVerCotizacion.setEnabled(false);
				}
			}
		});
		tableCotizacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelCotizaciones = new DefaultTableModel();
		tableCotizacion.setModel(modelCotizaciones);
		tableCotizacion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableCotizacion.getTableHeader().setReorderingAllowed(false);
		
		String[] headers2= {"Codigo", "Fecha", "Cliente", "Vendedor", "Monto Total"};
		modelCotizaciones.setColumnIdentifiers(headers2);
		TableColumnModel columModel2 = tableCotizacion.getColumnModel();
		columModel2.getColumn(0).setPreferredWidth(90);
		columModel2.getColumn(1).setPreferredWidth(90);
		columModel2.getColumn(2).setPreferredWidth(200);
		columModel2.getColumn(3).setPreferredWidth(200);
		columModel2.getColumn(4).setPreferredWidth(110);
		scrollPaneCotizacion.setViewportView(tableCotizacion);
		
		btnVerCotizacion = new JButton("");
		btnVerCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(6, 2, cotizacionSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnVerCotizacion.setEnabled(false);
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
		tableDevoluciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableDevoluciones.getSelectedRow();
				devolucionSeleccionada = tableDevoluciones.getValueAt(seleccion,  0).toString();
				btnAbrirDevolucion.setEnabled(true);
				if(!Tienda.getInstance().buscarDevolucionVenta(devolucionSeleccionada).isRecibida()) {
					btnEliminarDevolucion.setEnabled(true);
					btnEditarDevolucion.setEnabled(true);
					btnRecibirDevolucion.setEnabled(true);
				} else {
					btnEliminarDevolucion.setEnabled(false);
					btnEditarDevolucion.setEnabled(false);
					btnRecibirDevolucion.setEnabled(false);
				}
				
			}
		});
		tableDevoluciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelDevoluciones = new DefaultTableModel();
		tableDevoluciones.setModel(modelDevoluciones);
		tableDevoluciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDevoluciones.getTableHeader().setReorderingAllowed(false);
		
		String[] headers4= {"Codigo", "Fecha", "Cliente", "Vendedor", "Estado", "Monto Total"};
		modelDevoluciones.setColumnIdentifiers(headers4);
		TableColumnModel columModel4 = tableDevoluciones.getColumnModel();
		columModel4.getColumn(0).setPreferredWidth(90);
		columModel4.getColumn(1).setPreferredWidth(90);
		columModel4.getColumn(2).setPreferredWidth(155);
		columModel4.getColumn(3).setPreferredWidth(155);
		columModel4.getColumn(4).setPreferredWidth(90);
		columModel4.getColumn(5).setPreferredWidth(108);
		scrollPane.setViewportView(tableDevoluciones);
		
		btnRecibirDevolucion = new JButton("");
		btnRecibirDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(7, 5, devolucionSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnRecibirDevolucion.setEnabled(false);
		btnRecibirDevolucion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/recibir.png")));
		btnRecibirDevolucion.setBounds(170, 391, 70, 70);
		panelDevoluciones.add(btnRecibirDevolucion);
		
		btnAbrirDevolucion = new JButton("");
		btnAbrirDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(7, 2, devolucionSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnAbrirDevolucion.setEnabled(false);
		btnAbrirDevolucion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/abrir.png")));
		btnAbrirDevolucion.setBounds(90, 391, 70, 70);
		panelDevoluciones.add(btnAbrirDevolucion);
		
		btnDevolucion = new JButton("");
		btnDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroVenta registroVenta = new RegistroVenta(null, 0, 1);
				registroVenta.setVisible(true);
				cargarTablas();
			}
		});
		btnDevolucion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/devolver.png")));
		btnDevolucion.setBounds(10, 391, 70, 70);
		panelDevoluciones.add(btnDevolucion);
		
		btnEditarDevolucion = new JButton("");
		btnEditarDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(7, 0, devolucionSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnEditarDevolucion.setEnabled(false);
		btnEditarDevolucion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/modificar.png")));
		btnEditarDevolucion.setBounds(250, 391, 70, 70);
		panelDevoluciones.add(btnEditarDevolucion);
		
		btnEliminarDevolucion = new JButton("");
		btnEliminarDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(7, 3, devolucionSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnEliminarDevolucion.setEnabled(false);
		btnEliminarDevolucion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/eliminar.png")));
		btnEliminarDevolucion.setBounds(330, 391, 70, 70);
		panelDevoluciones.add(btnEliminarDevolucion);
		
		btnSalirDevolucion = new JButton("");
		btnSalirDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirDevolucion.setIcon(new ImageIcon(Facturacion.class.getResource("/resources/salir.png")));
		btnSalirDevolucion.setBounds(634, 391, 70, 70);
		panelDevoluciones.add(btnSalirDevolucion);
		// TERMINA AQUI
		
		cargarTablas();
	}

	private void cargarTablas() {
		rowsFacturas = new Object[modelFacturas.getColumnCount()];
		modelFacturas.setRowCount(0);
		for(OrdenVenta x: Tienda.getInstance().getFacturas()) {
			if(x instanceof FacturaVenta) {
				rowsFacturas[0]= x.getCodigo();
				rowsFacturas[1]=new SimpleDateFormat("dd-MM-yyyy").format(x.getFecha());
				rowsFacturas[2]=x.getCliente().getNombre();
				rowsFacturas[3]=x.getEmpleado().getNombre();
				rowsFacturas[4]=x.getMontoTotal();
				modelFacturas.addRow(rowsFacturas);
			}
		}
		rowsCotizaciones = new Object[modelCotizaciones.getColumnCount()];
		modelCotizaciones.setRowCount(0);
		for(OrdenVenta x: Tienda.getInstance().getFacturas()) {
			if(x instanceof CotizacionVenta) {
				rowsCotizaciones[0]= x.getCodigo();
				rowsCotizaciones[1]=new SimpleDateFormat("dd-MM-yyyy").format(x.getFecha());
				rowsCotizaciones[2]=x.getCliente().getNombre();
				rowsCotizaciones[3]=x.getEmpleado().getNombre();
				rowsCotizaciones[4]=x.getMontoTotal();
				modelCotizaciones.addRow(rowsCotizaciones);
			}
		}
		
		rowsDevoluciones = new Object[modelDevoluciones.getColumnCount()];
		modelDevoluciones.setRowCount(0);
		for(OrdenVenta x: Tienda.getInstance().getFacturas()) {
			if(x instanceof DevolucionVenta) {
				rowsDevoluciones[0]= x.getCodigo();
				rowsDevoluciones[1]=new SimpleDateFormat("dd-MM-yyyy").format(x.getFecha());
				rowsDevoluciones[2]=x.getCliente().getNombre();
				rowsDevoluciones[3]=x.getEmpleado().getNombre();
				
				if(((DevolucionVenta) x).isRecibida()) {
					rowsDevoluciones[4]="APROBADA";
				} else {
					rowsDevoluciones[4]="PENDIENTE";
				}
				
				rowsDevoluciones[5]=x.getMontoTotal();
				modelDevoluciones.addRow(rowsDevoluciones);
			}
		}
	}
}
