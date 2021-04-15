package visual;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.FacturaVenta;
import logic.OrdenVenta;
import logic.Tienda;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class CuentasCobrar extends JDialog {

	private static String compraSeleccionada=null;
	private final JPanel contentPanel = new JPanel();
	private static Object[] rowsProductos;
	private JTable table;
	private static DefaultTableModel model;
	private JButton btnPagar;

	public CuentasCobrar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CuentasCobrar.class.getResource("/resources/logo.png")));
		setTitle("Cecomsa - Cuentas por Pagar");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 805, 505);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Ordenar por:");
		lblBuscar.setBounds(10, 11, 91, 14);
		panel.add(lblBuscar);
		
		JComboBox<String> cbxOrdenar = new JComboBox<String>();
		cbxOrdenar.setModel(new DefaultComboBoxModel<String>(new String[] {"FECHA DE COMPRA", "FECHA LIMITE DE PAGO", "PROVEEDOR", "ADMINISTRADOR", "MONTO TOTAL"}));
		cbxOrdenar.setBounds(90, 8, 160, 20);
		panel.add(cbxOrdenar);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon(CuentasPagar.class.getResource("/resources/abrir.png")));
		btnAbrir.setBounds(10, 381, 70, 70);
		panel.add(btnAbrir);
		
		btnPagar = new JButton("");
		btnPagar.setIcon(new ImageIcon(CuentasCobrar.class.getResource("/resources/cobrar.png")));
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda busqueda = new Busqueda(5, 6, compraSeleccionada);
				busqueda.setVisible(true);
				cargarTabla();
			}
		});
		btnPagar.setEnabled(false);
		btnPagar.setBounds(90, 381, 70, 70);
		panel.add(btnPagar);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(CuentasPagar.class.getResource("/resources/salir.png")));
		btnSalir.setBounds(704, 381, 70, 70);
		panel.add(btnSalir);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 36, 764, 334);
		panel.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = -1;
				seleccion = table.getSelectedRow();
				compraSeleccionada = table.getValueAt(seleccion,  0).toString();
				
				System.out.printf(compraSeleccionada);
				
				if(compraSeleccionada!=null) {
					if(!Tienda.getInstance().buscarFacturaVenta(compraSeleccionada).isPagada()) {
						btnPagar.setEnabled(true);
					}
				} 
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		
		String[] headers= {"Codigo", "Cliente", "Vendedor", "Fecha Limite", "Estado", "Monto Total"};
		model.setColumnIdentifiers(headers);
		TableColumnModel columModel = table.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(90);
		columModel.getColumn(1).setPreferredWidth(190);
		columModel.getColumn(2).setPreferredWidth(175);
		columModel.getColumn(3).setPreferredWidth(130);
		columModel.getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		cargarTabla();
	}
	
	private void cargarTabla() {
		rowsProductos = new Object[model.getColumnCount()];
		model.setRowCount(0);
		
		for(OrdenVenta x: Tienda.getInstance().getFacturas()) {
			if(x instanceof FacturaVenta) {
				rowsProductos[0]=x.getCodigo();
				rowsProductos[1]=x.getCliente().getNombre();
				rowsProductos[2]=x.getEmpleado().getNombre();
				rowsProductos[3]=new SimpleDateFormat("dd-MM-yyyy").format(sumarFecha(x.getFecha(), x.getPlazoPago()));
				
				if(((FacturaVenta) x).isPagada()) {
					rowsProductos[4]="PAGADA";
				} else {
					rowsProductos[4]="PENDIENTE.";
				}
				if(x.getPlazoPago()==1) {
					Tienda.getInstance().buscarFacturaVenta(x.getCodigo()).setPagada(true);
					rowsProductos[4]="PAGADA";
				}
				rowsProductos[5]=x.getMontoTotal();
				model.addRow(rowsProductos);
			}
		}
	}

	private Date sumarFecha(Date fecha, int plazoPago) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, plazoPago*15);
		return calendar.getTime();
	}
}
