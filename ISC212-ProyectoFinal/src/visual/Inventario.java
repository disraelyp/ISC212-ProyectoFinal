package visual;

import java.awt.BorderLayout;
import java.awt.Toolkit;

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

import logic.Componente;
import logic.CompraInventario;
import logic.CotizacionInventario;
import logic.DevolucionInventario;
import logic.DiscoDuro;
import logic.MemoriaRAM;
import logic.Microprocesador;
import logic.OrdenInventario;
import logic.OrdenarCantidadProducto;
import logic.OrdenarCodigoOrdenInventario;
import logic.OrdenarCodigoProducto;
import logic.OrdenarFechaOrdenInventario;
import logic.OrdenarMontoOrdenInventario;
import logic.OrdenarPrecioProducto;
import logic.OrdenarProveedorOrdenInventario;
import logic.PaqueteComponentes;
import logic.Producto;
import logic.TarjetaMadre;
import logic.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inventario extends JDialog {

	private static String ordenInventarioSeleccionada=null;
	private static String cotizacionInventarioSeleccionada=null;
	private static String devolucionInventarioSeleccionada=null;
	private static String productoSeleccionado=null;
	
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelOrddenes;
	private static Object[] rowsOrdenes;
	private static DefaultTableModel modelCotizaciones;
	private static Object[] rowsCotizaciones;
	private static DefaultTableModel modelDevoluciones;
	private static Object[] rowsDevoluciones;
	private static DefaultTableModel modelProductos;
	private static Object[] rowsProductos;
	private JTable tableOrden;
	private JTable tableCotizacion;
	private JButton btnCrearOrden;
	private JButton btnModificarOrden;
	private JComboBox<String> cmbOrden;
	private JComboBox<String> cmbOrdenCotizacion;
	private JButton btnSalirCotizacion;
	private JButton btnSalirOrden;
	private JTable tableDevoluciones;
	private JTable tableProductos;
	private JButton btnAbrirProducto;
	private JButton btnCrearProducto;
	private JButton btnCrearPaquete;
	private JButton btnModificarProducto;
	private JButton btnEliminarProducto;
	private JButton btnSalir;
	private JButton btnVerOrden;
	private JButton btnDevolucionOrden;
	private JButton btnEliminarOrden;
	private JButton btnRecibirOrden;
	private JButton btnEliminarCotizacion;
	private JButton btnConvertirCotizacion;
	private JButton btnModificarCotizacion;
	private JButton btnVerCotizacion;
	private JButton btnCrearCotizacion;
	private JButton btnEliminarDevolucion;
	private JButton btnModificarDevolucion;
	private JButton btnProcesarDevolucion;
	private JButton btnAbrirDevolucion;
	private JButton btnGenerarDevolucion;
	private JButton btnSalirDevolucion;
	private JComboBox<String> cbxOrdenDevoluciones;

	public Inventario() {
		
		setTitle("CECOMSA - Modulo de Inventario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/logo.png")));
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 784, 512);
		setResizable(false);
		setModal(true);
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
				RegistroCompra registroCompra = new RegistroCompra(null, 0, 0);
				registroCompra.setVisible(true);
				cargarTablas();
			}
		});
		btnCrearOrden.setBounds(10, 391, 70, 70);
		panelOrdenes.add(btnCrearOrden);
		
		btnModificarOrden = new JButton("");
		btnModificarOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(0, 0 ,ordenInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnModificarOrden.setEnabled(false);
		btnModificarOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/modificar.png")));
		btnModificarOrden.setBounds(250, 391, 70, 70);
		panelOrdenes.add(btnModificarOrden);
		
		btnSalirOrden = new JButton("");
		btnSalirOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/salir.png")));
		btnSalirOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirOrden.setBounds(689, 391, 70, 70);
		panelOrdenes.add(btnSalirOrden);
		
		btnDevolucionOrden = new JButton("");
		btnDevolucionOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(0, 4,ordenInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnDevolucionOrden.setEnabled(false);
		btnDevolucionOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/devolver.png")));
		btnDevolucionOrden.setBounds(330, 391, 70, 70);
		panelOrdenes.add(btnDevolucionOrden);
		
		JLabel lblOrdenar = new JLabel("Ordenar por:");
		lblOrdenar.setBounds(10, 11, 78, 14);
		panelOrdenes.add(lblOrdenar);
		
		cmbOrden = new JComboBox<String>();
		cmbOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cmbOrden.getSelectedIndex()) {
				case 0:
					Tienda.getInstance().getOrdenes().sort(new OrdenarCodigoOrdenInventario());
					break;
				case 1:
					Tienda.getInstance().getOrdenes().sort(new OrdenarProveedorOrdenInventario());
					break;
				case 2:
					Tienda.getInstance().getOrdenes().sort(new OrdenarMontoOrdenInventario());
					break;
				case 3:
					Tienda.getInstance().getOrdenes().sort(new OrdenarFechaOrdenInventario());
					break;
				}
				cargarTablas();
			}
		});
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
		tableOrden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableOrden.getSelectedRow();
				ordenInventarioSeleccionada = tableOrden.getValueAt(seleccion,  0).toString();
				btnVerOrden.setEnabled(true);
				if(Tienda.getInstance().buscarCompraInventario(ordenInventarioSeleccionada).isRecibida()) {
					btnDevolucionOrden.setEnabled(true);
					btnModificarOrden.setEnabled(false);
					btnEliminarOrden.setEnabled(false);
					btnRecibirOrden.setEnabled(false);
				} else {
					btnModificarOrden.setEnabled(true);
					btnEliminarOrden.setEnabled(true);
					btnDevolucionOrden.setEnabled(false);
					btnRecibirOrden.setEnabled(true);
				}
			}
		});
		tableOrden.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelOrddenes = new DefaultTableModel();
		tableOrden.setModel(modelOrddenes);
		tableOrden.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableOrden.getTableHeader().setReorderingAllowed(false);
		
		String[] headers1= {"Codigo", "Fecha", "Proveedor", "Estado", "Monto Total"};
		modelOrddenes.setColumnIdentifiers(headers1);
		TableColumnModel columModel1 = tableOrden.getColumnModel();
		columModel1.getColumn(0).setPreferredWidth(90);
		columModel1.getColumn(1).setPreferredWidth(90);
		columModel1.getColumn(2).setPreferredWidth(330);
		columModel1.getColumn(3).setPreferredWidth(120);
		columModel1.getColumn(4).setPreferredWidth(114);
		scrollPaneOrden.setViewportView(tableOrden);
		
		btnVerOrden = new JButton("");
		btnVerOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(0, 2,ordenInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnVerOrden.setEnabled(false);
		btnVerOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/abrir.png")));
		btnVerOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVerOrden.setBounds(90, 391, 70, 70);
		panelOrdenes.add(btnVerOrden);
		
		btnEliminarOrden = new JButton("");
		btnEliminarOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(0, 3,ordenInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnEliminarOrden.setEnabled(false);
		btnEliminarOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/eliminar.png")));
		btnEliminarOrden.setBounds(410, 391, 70, 70);
		panelOrdenes.add(btnEliminarOrden);
		
		btnRecibirOrden = new JButton("");
		btnRecibirOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(0, 5, ordenInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnRecibirOrden.setEnabled(false);
		btnRecibirOrden.setIcon(new ImageIcon(Inventario.class.getResource("/resources/recibir.png")));
		btnRecibirOrden.setBounds(170, 391, 70, 70);
		panelOrdenes.add(btnRecibirOrden);
		
		JPanel panelCotizaciones = new JPanel();
		tabbedPane.addTab("Cotizaciones", null, panelCotizaciones, null);
		panelCotizaciones.setLayout(null);
		
		btnCrearCotizacion = new JButton("");
		btnCrearCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroCompra registroCompra = new RegistroCompra(null, 0, 2);
				registroCompra.setVisible(true);
				cargarTablas();
			}
		});
		btnCrearCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/cotizar.png")));
		btnCrearCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearCotizacion.setBounds(10, 391, 70, 70);
		panelCotizaciones.add(btnCrearCotizacion);
		
		btnModificarCotizacion = new JButton("");
		btnModificarCotizacion.setEnabled(false);
		btnModificarCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(1, 0, cotizacionInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnModificarCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/modificar.png")));
		btnModificarCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificarCotizacion.setBounds(170, 391, 70, 70);
		panelCotizaciones.add(btnModificarCotizacion);
		
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
		
		btnEliminarCotizacion = new JButton("");
		btnEliminarCotizacion.setEnabled(false);
		btnEliminarCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(1, 3, cotizacionInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnEliminarCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/eliminar.png")));
		btnEliminarCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarCotizacion.setBounds(330, 391, 70, 70);
		panelCotizaciones.add(btnEliminarCotizacion);
		
		btnConvertirCotizacion = new JButton("");
		btnConvertirCotizacion.setEnabled(false);
		btnConvertirCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(1, 4, cotizacionInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnConvertirCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/comprar.png")));
		btnConvertirCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConvertirCotizacion.setBounds(250, 391, 70, 70);
		panelCotizaciones.add(btnConvertirCotizacion);
		
		JLabel lblOrdenarCotizacion = new JLabel("Ordenar por:");
		lblOrdenarCotizacion.setBounds(10, 11, 78, 14);
		panelCotizaciones.add(lblOrdenarCotizacion);
		
		cmbOrdenCotizacion = new JComboBox<String>();
		cmbOrdenCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cmbOrdenCotizacion.getSelectedIndex()) {
				case 0:
					Tienda.getInstance().getOrdenes().sort(new OrdenarCodigoOrdenInventario());
					break;
				case 1:
					Tienda.getInstance().getOrdenes().sort(new OrdenarProveedorOrdenInventario());
					break;
				case 2:
					Tienda.getInstance().getOrdenes().sort(new OrdenarMontoOrdenInventario());
					break;
				case 3:
					Tienda.getInstance().getOrdenes().sort(new OrdenarFechaOrdenInventario());
					break;
				}
				cargarTablas();
			}
		});
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
		tableCotizacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableCotizacion.getSelectedRow();
				cotizacionInventarioSeleccionada = tableCotizacion.getValueAt(seleccion,  0).toString();
				if(cotizacionInventarioSeleccionada!=null) {
					btnVerCotizacion.setEnabled(true);
					btnModificarCotizacion.setEnabled(true);
					btnConvertirCotizacion.setEnabled(true);
					btnEliminarCotizacion.setEnabled(true);
				} else {
					btnVerCotizacion.setEnabled(false);
					btnModificarCotizacion.setEnabled(false);
					btnConvertirCotizacion.setEnabled(false);
					btnEliminarCotizacion.setEnabled(false);
				}
			}
		});
		tableCotizacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelCotizaciones = new DefaultTableModel();
		tableCotizacion.setModel(modelCotizaciones);
		tableCotizacion.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableCotizacion.getTableHeader().setReorderingAllowed(false);
		
		String[] headers2= {"Codigo", "Fecha", "Proveedor", "Monto Total"};
		modelCotizaciones.setColumnIdentifiers(headers2);
		TableColumnModel columModel2 = tableCotizacion.getColumnModel();
		columModel2.getColumn(0).setPreferredWidth(90);
		columModel2.getColumn(1).setPreferredWidth(90);
		columModel2.getColumn(2).setPreferredWidth(450);
		columModel2.getColumn(3).setPreferredWidth(114);
		scrollPaneCotizacion.setViewportView(tableCotizacion);
		
		btnVerCotizacion = new JButton("");
		btnVerCotizacion.setEnabled(false);
		btnVerCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(1, 2, cotizacionInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnVerCotizacion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/abrir.png")));
		btnVerCotizacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVerCotizacion.setBounds(90, 391, 70, 70);
		panelCotizaciones.add(btnVerCotizacion);
		
		JPanel panelDevoluciones = new JPanel();
		tabbedPane.addTab("Devoluciones", null, panelDevoluciones, null);
		panelDevoluciones.setLayout(null);
		
		JLabel label = new JLabel("Ordenar por:");
		label.setBounds(10, 11, 78, 14);
		panelDevoluciones.add(label);
		
		cbxOrdenDevoluciones = new JComboBox<String>();
		cbxOrdenDevoluciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cbxOrdenDevoluciones.getSelectedIndex()) {
				case 0:
					Tienda.getInstance().getOrdenes().sort(new OrdenarCodigoOrdenInventario());
					break;
				case 1:
					Tienda.getInstance().getOrdenes().sort(new OrdenarProveedorOrdenInventario());
					break;
				case 2:
					Tienda.getInstance().getOrdenes().sort(new OrdenarMontoOrdenInventario());
					break;
				case 3:
					Tienda.getInstance().getOrdenes().sort(new OrdenarFechaOrdenInventario());
					break;
				}
				cargarTablas();
			}
		});
		cbxOrdenDevoluciones.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "PROVEEDOR", "MONTO", "FECHA"}));
		cbxOrdenDevoluciones.setBounds(90, 8, 150, 20);
		panelDevoluciones.add(cbxOrdenDevoluciones);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 749, 344);
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
				devolucionInventarioSeleccionada = tableDevoluciones.getValueAt(seleccion,  0).toString();
				
				if(devolucionInventarioSeleccionada!=null) {
					btnAbrirDevolucion.setEnabled(true);
					if(!Tienda.getInstance().buscarDevolucionInventario(devolucionInventarioSeleccionada).isRetirada()) {
						btnEliminarDevolucion.setEnabled(true);
						btnModificarDevolucion.setEnabled(true);
						btnProcesarDevolucion.setEnabled(true);
					}
				} else {
					btnAbrirDevolucion.setEnabled(false);
					btnEliminarDevolucion.setEnabled(false);
					btnModificarDevolucion.setEnabled(false);
					btnProcesarDevolucion.setEnabled(false);
				}
			}
		});
		tableDevoluciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelDevoluciones = new DefaultTableModel();
		tableDevoluciones.setModel(modelDevoluciones);
		tableDevoluciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDevoluciones.getTableHeader().setReorderingAllowed(false);
		
		String[] headers3= {"Codigo", "Fecha", "Proveedor", "Estado", "Monto Total"};
		modelDevoluciones.setColumnIdentifiers(headers3);
		TableColumnModel columModel3 = tableDevoluciones.getColumnModel();
		columModel3.getColumn(0).setPreferredWidth(90);
		columModel3.getColumn(1).setPreferredWidth(90);
		columModel3.getColumn(2).setPreferredWidth(330);
		columModel3.getColumn(3).setPreferredWidth(120);
		columModel3.getColumn(4).setPreferredWidth(114);
		scrollPane.setViewportView(tableDevoluciones);
		
		btnProcesarDevolucion = new JButton("");
		btnProcesarDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(2, 5,devolucionInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnProcesarDevolucion.setEnabled(false);
		btnProcesarDevolucion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/retirar.png")));
		btnProcesarDevolucion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnProcesarDevolucion.setBounds(170, 391, 70, 70);
		panelDevoluciones.add(btnProcesarDevolucion);
		
		btnAbrirDevolucion = new JButton("");
		btnAbrirDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(2, 2, devolucionInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnAbrirDevolucion.setEnabled(false);
		btnAbrirDevolucion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/abrir.png")));
		btnAbrirDevolucion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAbrirDevolucion.setBounds(90, 391, 70, 70);
		panelDevoluciones.add(btnAbrirDevolucion);
		
		btnGenerarDevolucion = new JButton("");
		btnGenerarDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroCompra registroCompra = new RegistroCompra(null, 1, 0);
				registroCompra.setVisible(true);
			}
		});
		btnGenerarDevolucion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/devolver.png")));
		btnGenerarDevolucion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnGenerarDevolucion.setBounds(10, 391, 70, 70);
		panelDevoluciones.add(btnGenerarDevolucion);
		
		btnModificarDevolucion = new JButton("");
		btnModificarDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(2, 0,devolucionInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnModificarDevolucion.setEnabled(false);
		btnModificarDevolucion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/modificar.png")));
		btnModificarDevolucion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificarDevolucion.setBounds(250, 391, 70, 70);
		panelDevoluciones.add(btnModificarDevolucion);
		
		btnEliminarDevolucion = new JButton("");
		btnEliminarDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(2, 3,devolucionInventarioSeleccionada);
				busqueda.setVisible(true);
				cargarTablas();
			}
		});
		btnEliminarDevolucion.setEnabled(false);
		btnEliminarDevolucion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/eliminar.png")));
		btnEliminarDevolucion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarDevolucion.setBounds(330, 391, 70, 70);
		panelDevoluciones.add(btnEliminarDevolucion);
		
		btnSalirDevolucion = new JButton("");
		btnSalirDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirDevolucion.setIcon(new ImageIcon(Inventario.class.getResource("/resources/salir.png")));
		btnSalirDevolucion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSalirDevolucion.setBounds(689, 391, 70, 70);
		panelDevoluciones.add(btnSalirDevolucion);
		
		JPanel panelProductos = new JPanel();
		tabbedPane.addTab("Listado de Productos", null, panelProductos, null);
		panelProductos.setLayout(null);
		
		JLabel label_1 = new JLabel("Ordenar por:");
		label_1.setBounds(10, 11, 78, 14);
		panelProductos.add(label_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(comboBox_1.getSelectedIndex()) {
				case 0:
					Tienda.getInstance().getProductos().sort(new OrdenarCodigoProducto());
					break;
				case 1:
					Tienda.getInstance().getProductos().sort(new OrdenarCantidadProducto());
					break;
				case 2:
					Tienda.getInstance().getProductos().sort(new OrdenarPrecioProducto());
					break;
				}
				cargarTablas();
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "CANTIDAD", "PRECIO"}));
		comboBox_1.setBounds(90, 8, 150, 20);
		panelProductos.add(comboBox_1);
		
		btnAbrirProducto = new JButton("");
		btnAbrirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productoSeleccionado!=null) {
					if(Tienda.getInstance().buscarProducto(productoSeleccionado) instanceof Componente) {
						Busqueda busqueda = new Busqueda(3, 2, productoSeleccionado);
						busqueda.setVisible(true);
					} else {
						Busqueda busqueda = new Busqueda(4, 2, productoSeleccionado);
						busqueda.setVisible(true);
					}
				}
				cargarTablas();
			}
		});
		btnAbrirProducto.setEnabled(false);
		btnAbrirProducto.setIcon(new ImageIcon(Inventario.class.getResource("/resources/abrir.png")));
		btnAbrirProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAbrirProducto.setBounds(170, 391, 70, 70);
		panelProductos.add(btnAbrirProducto);
		
		btnCrearProducto = new JButton("");
		btnCrearProducto.setIcon(new ImageIcon(Inventario.class.getResource("/resources/producto.png")));
		btnCrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroComponente registroComponente = new RegistroComponente(null, 0);
				registroComponente.setVisible(true); //bien
				cargarTablas();
			}
		});
		btnCrearProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearProducto.setBounds(10, 391, 70, 70);
		panelProductos.add(btnCrearProducto);
		
		btnModificarProducto = new JButton("");
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productoSeleccionado!=null) {
					if(Tienda.getInstance().buscarProducto(productoSeleccionado) instanceof Componente) {
						Busqueda busqueda = new Busqueda(3, 0, productoSeleccionado);
						busqueda.setVisible(true);
					} else {
						Busqueda busqueda = new Busqueda(4, 0, productoSeleccionado);
						busqueda.setVisible(true);
					}
				}
				cargarTablas();
			}
		});
		btnModificarProducto.setEnabled(false);
		btnModificarProducto.setIcon(new ImageIcon(Inventario.class.getResource("/resources/modificar.png")));
		btnModificarProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificarProducto.setBounds(250, 391, 70, 70);
		panelProductos.add(btnModificarProducto);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(Inventario.class.getResource("/resources/salir.png")));
		btnSalir.setBounds(689, 391, 70, 70);
		panelProductos.add(btnSalir);
		
		JPanel panelTablaProductos = new JPanel();
		panelTablaProductos.setBounds(10, 36, 749, 344);
		panelProductos.add(panelTablaProductos);
		panelTablaProductos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneProductos = new JScrollPane();
		panelTablaProductos.add(scrollPaneProductos, BorderLayout.CENTER);
		
		tableProductos = new JTable();
		tableProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = tableProductos.getSelectedRow();
				productoSeleccionado = tableProductos.getValueAt(seleccion,  0).toString();
				btnAbrirProducto.setEnabled(true);
				btnEliminarProducto.setEnabled(true);
				btnModificarProducto.setEnabled(true);
			}
		});
		tableProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelProductos = new DefaultTableModel();
		tableProductos.setModel(modelProductos);
		tableProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableProductos.getTableHeader().setReorderingAllowed(false);
		String[] headers4= {"Codigo", "Descripcion", "Tipo", "Cantidad", "Precio total", "Costo total"};
		modelProductos.setColumnIdentifiers(headers4);
		TableColumnModel columModel4 = tableProductos.getColumnModel();
		columModel4.getColumn(0).setPreferredWidth(90);
		columModel4.getColumn(1).setPreferredWidth(250);
		columModel4.getColumn(2).setPreferredWidth(120);
		columModel4.getColumn(3).setPreferredWidth(90);
		columModel4.getColumn(4).setPreferredWidth(90);
		columModel4.getColumn(5).setPreferredWidth(100);
		scrollPaneProductos.setViewportView(tableProductos);		
		
		btnEliminarProducto = new JButton("");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productoSeleccionado!=null) {
					if(Tienda.getInstance().buscarProducto(productoSeleccionado) instanceof Componente) {
						Busqueda busqueda = new Busqueda(3, 3, productoSeleccionado);
						busqueda.setVisible(true);
					} else {
						Busqueda busqueda = new Busqueda(4, 3, productoSeleccionado);
						busqueda.setVisible(true);
					}
				}
				cargarTablas();
			}
		});
		btnEliminarProducto.setEnabled(false);
		btnEliminarProducto.setIcon(new ImageIcon(Inventario.class.getResource("/resources/eliminar.png")));
		btnEliminarProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarProducto.setBounds(330, 391, 70, 70);
		panelProductos.add(btnEliminarProducto);
		
		btnCrearPaquete = new JButton("");
		btnCrearPaquete.setIcon(new ImageIcon(Inventario.class.getResource("/resources/paquete.png")));
		btnCrearPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroPaqueteComponentes registroPaqueteComponentes = new RegistroPaqueteComponentes(null, 0);
				registroPaqueteComponentes.setVisible(true);
			}
		});
		btnCrearPaquete.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearPaquete.setBounds(90, 391, 70, 70);
		panelProductos.add(btnCrearPaquete);
		
		cargarTablas();
	}
	
	private void cargarTablas() {
		rowsOrdenes = new Object[modelOrddenes.getColumnCount()];
		modelOrddenes.setRowCount(0);
		for(OrdenInventario x: Tienda.getInstance().getOrdenes()) {
				if(x instanceof CompraInventario) {
					rowsOrdenes[0]= ((CompraInventario) x).getCodigo();
					rowsOrdenes[1]=x.getFechaTexto();
					rowsOrdenes[2]=x.getProveedor().getNombre();
					if(((CompraInventario) x).isRecibida()) {
						rowsOrdenes[3]="RECIBIDA";
					} else {
						rowsOrdenes[3]="SIN RECIBIR";
					}
					rowsOrdenes[4]=x.getCostoTotal();
					modelOrddenes.addRow(rowsOrdenes);
				}
			}
		
		
			rowsCotizaciones = new Object[modelCotizaciones.getColumnCount()];
			modelCotizaciones.setRowCount(0);
			for(OrdenInventario x: Tienda.getInstance().getOrdenes()) {
				if(x instanceof CotizacionInventario) {
					rowsCotizaciones[0]=((CotizacionInventario) x).getCodigo();
					rowsCotizaciones[1]=x.getFechaTexto();
					rowsCotizaciones[2]=x.getProveedor().getNombre();
					rowsCotizaciones[3]=x.getCostoTotal();
					modelCotizaciones.addRow(rowsCotizaciones);
				}
			}
			rowsDevoluciones = new Object[modelDevoluciones.getColumnCount()];
			modelDevoluciones.setRowCount(0);
			for(OrdenInventario x: Tienda.getInstance().getOrdenes()) {
				if(x instanceof DevolucionInventario) {
					rowsDevoluciones[0]= ((DevolucionInventario) x).getCodigo();
					rowsDevoluciones[1]=x.getFechaTexto();
					rowsDevoluciones[2]=x.getProveedor().getNombre();
					if(((DevolucionInventario) x).isRetirada()) {
						rowsDevoluciones[3]="RETIRADA";
					} else {
						rowsDevoluciones[3]="SIN RETIRAR";
					}
					rowsDevoluciones[4]=x.getCostoTotal();
					modelDevoluciones.addRow(rowsDevoluciones);
				}
			}
			rowsProductos = new Object[modelProductos.getColumnCount()];
			modelProductos.setRowCount(0);
			for(Producto x: Tienda.getInstance().getProductos()) {
				rowsProductos[0]= x.getCodigo();
				if(x instanceof Componente) {
					rowsProductos[1]= ((Componente) x).getMarca()+"-"+((Componente) x).getModelo();
				} else {
					rowsProductos[1]="Paquete #(Codigo: "+((PaqueteComponentes) x).getCodigo()+")";
				}		
				if(x instanceof TarjetaMadre) {
					rowsProductos[2]="Tarjeta Madre";
				} else {
					if(x instanceof Microprocesador) {
						rowsProductos[2]="Microprocesador";
					} else {
						if(x instanceof DiscoDuro) {
							rowsProductos[2]="Disco duro";
						} else {
							if(x instanceof MemoriaRAM) {
								rowsProductos[2]="Memoria RAM";
							} else {
								if(x instanceof PaqueteComponentes) {
									rowsProductos[2]="Paquete de compoenentes.";
								}
							}
						}
					}
				}
				rowsProductos[3]=x.getCantidad();
				rowsProductos[4]=x.getPrecio();
				rowsProductos[5]=x.getCosto();
				modelProductos.addRow(rowsProductos);
			}
		}
}
