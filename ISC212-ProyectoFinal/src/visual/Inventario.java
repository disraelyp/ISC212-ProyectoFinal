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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Inventario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model1;
	private static DefaultTableModel model2;
	private JTable tableOrden;
	private JTable tableCotizacion;
	private JButton btnCrearOrden;
	private JButton btnModificarOrden;
	private JButton btnDuplicarOrden;
	private JButton btnEliminarOrden;
	private JComboBox<String> cmbOrden;
	private JComboBox<String> cmbOrdenCotizacion;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Inventario dialog = new Inventario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Inventario() {
		setTitle("Modulo de Inventario");
		setModal(true);
		setBounds(100, 100, 750, 550);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 734, 512);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 724, 500);
		contentPanel.add(tabbedPane);
		
		JPanel panelOrdenes = new JPanel();
		tabbedPane.addTab("Ordenes de Compras", null, panelOrdenes, null);
		panelOrdenes.setLayout(null);
		
		btnCrearOrden = new JButton("CREAR");
		btnCrearOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearOrden.setBounds(90, 391, 70, 70);
		panelOrdenes.add(btnCrearOrden);
		
		btnModificarOrden = new JButton("MODIFICAR");
		btnModificarOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificarOrden.setBounds(170, 391, 70, 70);
		panelOrdenes.add(btnModificarOrden);
		
		btnDuplicarOrden = new JButton("DUPLICAR");
		btnDuplicarOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDuplicarOrden.setBounds(250, 391, 70, 70);
		panelOrdenes.add(btnDuplicarOrden);
		
		JButton btnSalirOrden = new JButton("SALIR");
		btnSalirOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSalirOrden.setBounds(639, 391, 70, 70);
		panelOrdenes.add(btnSalirOrden);
		
		btnEliminarOrden = new JButton("ELIMINAR");
		btnEliminarOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarOrden.setBounds(330, 391, 70, 70);
		panelOrdenes.add(btnEliminarOrden);
		
		JButton btnDevolucionOrden = new JButton("DEVOLUCION");
		btnDevolucionOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDevolucionOrden.setBounds(410, 391, 70, 70);
		panelOrdenes.add(btnDevolucionOrden);
		
		JLabel lblOrdenar = new JLabel("Ordenar por:");
		lblOrdenar.setBounds(10, 11, 78, 14);
		panelOrdenes.add(lblOrdenar);
		
		cmbOrden = new JComboBox<String>();
		cmbOrden.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos", "Proveedor", "Productos", "Monto", "Fecha"}));
		cmbOrden.setBounds(90, 8, 150, 20);
		panelOrdenes.add(cmbOrden);
		
		JPanel panelTablaOrden = new JPanel();
		panelTablaOrden.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTablaOrden.setBounds(10, 36, 699, 349);
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
		columModel1.getColumn(2).setPreferredWidth(300);
		columModel1.getColumn(3).setPreferredWidth(100);
		columModel1.getColumn(4).setPreferredWidth(114);
		scrollPaneOrden.setViewportView(tableOrden);
		
		JButton btnVerOrden = new JButton("VER");
		btnVerOrden.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVerOrden.setBounds(10, 391, 70, 70);
		panelOrdenes.add(btnVerOrden);
		
		JPanel panelCotizaciones = new JPanel();
		tabbedPane.addTab("Cotizaciones", null, panelCotizaciones, null);
		panelCotizaciones.setLayout(null);
		
		JButton button = new JButton("CREAR");
		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.setBounds(10, 391, 70, 70);
		panelCotizaciones.add(button);
		
		JButton button_1 = new JButton("MODIFICAR");
		button_1.setVerticalAlignment(SwingConstants.BOTTOM);
		button_1.setBounds(90, 391, 70, 70);
		panelCotizaciones.add(button_1);
		
		JButton button_2 = new JButton("DUPLICAR");
		button_2.setVerticalAlignment(SwingConstants.BOTTOM);
		button_2.setBounds(170, 391, 70, 70);
		panelCotizaciones.add(button_2);
		
		JButton button_3 = new JButton("SALIR");
		button_3.setVerticalAlignment(SwingConstants.BOTTOM);
		button_3.setBounds(639, 391, 70, 70);
		panelCotizaciones.add(button_3);
		
		JButton button_4 = new JButton("ELIMINAR");
		button_4.setVerticalAlignment(SwingConstants.BOTTOM);
		button_4.setBounds(250, 391, 70, 70);
		panelCotizaciones.add(button_4);
		
		JButton button_5 = new JButton("DEVOLUCION");
		button_5.setVerticalAlignment(SwingConstants.BOTTOM);
		button_5.setBounds(330, 391, 70, 70);
		panelCotizaciones.add(button_5);
		
		JLabel lblOrdenarCotizacion = new JLabel("Ordenar por:");
		lblOrdenarCotizacion.setBounds(10, 11, 78, 14);
		panelCotizaciones.add(lblOrdenarCotizacion);
		
		cmbOrdenCotizacion = new JComboBox<String>();
		cmbOrdenCotizacion.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos", "Proveedor", "Productos", "Monto", "Fecha"}));
		cmbOrdenCotizacion.setBounds(90, 8, 150, 20);
		panelCotizaciones.add(cmbOrdenCotizacion);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 36, 699, 349);
		panelCotizaciones.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
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
		columModel2.getColumn(2).setPreferredWidth(300);
		columModel2.getColumn(3).setPreferredWidth(100);
		columModel2.getColumn(4).setPreferredWidth(114);
		scrollPane.setViewportView(tableCotizacion);
		
		// EMPEZO AQUI
		
		
		
		// TERMINO AQUI
		
		JPanel panelProductos = new JPanel();
		tabbedPane.addTab("Listado de Productos", null, panelProductos, null);
		
		JPanel panelDevoluciones = new JPanel();
		tabbedPane.addTab("Devoluciones", null, panelDevoluciones, null);
	}
}
