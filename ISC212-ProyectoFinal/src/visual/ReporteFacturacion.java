package visual;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.FacturaVenta;
import logic.OrdenFechaOrdenVenta;
import logic.OrdenVenta;
import logic.OrdenarClienteOrdenVenta;
import logic.OrdenarCodigoOrdenVenta;
import logic.OrdenarMontoOrdenVenta;
import logic.Tienda;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class ReporteFacturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelFacturas;
	private static Object[] rowsFacturas;
	private JButton btnSalir;
	private JComboBox<String> cmbOrden;
	private JTable tableFactura;
	private JTextField txtMonto;

	public ReporteFacturacion() {
		setResizable(false);
		setTitle("Modulo de Facturacion");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/logo.png")));
		setModal(true);
		setBounds(100, 100, 755, 550);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			btnSalir = new JButton("");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setIcon(new ImageIcon(ReporteFacturacion.class.getResource("/resources/salir.png")));
			btnSalir.setBounds(654, 431, 70, 70);
			panel.add(btnSalir);
			
			JLabel lblNewLabel = new JLabel("Ordenar por:");
			lblNewLabel.setBounds(10, 14, 115, 14);
			panel.add(lblNewLabel);
			
			cmbOrden = new JComboBox<String>();
			cmbOrden.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(cmbOrden.getSelectedIndex()) {
					case 0:
						Tienda.getInstance().getFacturas().sort(new OrdenarCodigoOrdenVenta());
						break;
					case 1:
						Tienda.getInstance().getFacturas().sort(new OrdenarClienteOrdenVenta());
						break;
					case 2:
						Tienda.getInstance().getFacturas().sort(new OrdenarMontoOrdenVenta());
						break;
					case 3:
						Tienda.getInstance().getFacturas().sort(new OrdenFechaOrdenVenta());
						break;
					}
					cargarTablas();
				}
			});
			cmbOrden.setModel(new DefaultComboBoxModel<String>(new String[] {"CODIGO", "CLIENTE", "MONTO", "FECHA"}));
			cmbOrden.setBounds(84, 11, 130, 20);
			panel.add(cmbOrden);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 39, 714, 381);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			tableFactura = new JTable();
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
			columModel1.getColumn(4).setPreferredWidth(130);
			scrollPane.setViewportView(tableFactura);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(394, 431, 250, 70);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Total Vendido:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setBounds(10, 11, 230, 14);
			panel_2.add(lblNewLabel_1);
			
			txtMonto = new JTextField();
			txtMonto.setForeground(Color.RED);
			txtMonto.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtMonto.setBounds(10, 36, 230, 23);
			panel_2.add(txtMonto);
			txtMonto.setColumns(10);
		}
		cargarTablas();
	}
	private void cargarTablas() {
		rowsFacturas = new Object[modelFacturas.getColumnCount()];
		modelFacturas.setRowCount(0);
		float monto = 0;
		for(OrdenVenta x: Tienda.getInstance().getFacturas()) {
			if(x instanceof FacturaVenta) {
				rowsFacturas[0]= x.getCodigo();
				rowsFacturas[1]=new SimpleDateFormat("dd-MM-yyyy").format(x.getFecha());
				rowsFacturas[2]=x.getCliente().getNombre();
				rowsFacturas[3]=x.getEmpleado().getNombre();
				rowsFacturas[4]="$ "+x.getMontoTotal();
				monto+=x.getMontoTotal();
				modelFacturas.addRow(rowsFacturas);
			}
		}
		txtMonto.setText("$ "+monto);
	}
}
