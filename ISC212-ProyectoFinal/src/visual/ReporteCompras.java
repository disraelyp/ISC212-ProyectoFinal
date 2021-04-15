package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.CompraInventario;
import logic.OrdenInventario;
import logic.OrdenarCodigoOrdenInventario;
import logic.OrdenarFechaOrdenInventario;
import logic.OrdenarMontoOrdenInventario;
import logic.OrdenarProveedorOrdenInventario;
import logic.Tienda;

public class ReporteCompras extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelFacturas;
	private static Object[] rowsFacturas;
	private JButton btnSalir;
	private JComboBox<String> cmbOrden;
	private JTable tableFactura;
	private JTextField txtMonto;

	public ReporteCompras() {
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
			
			String[] headers1= {"Codigo", "Fecha", "Proveedor", "Estado", "Monto Total"};
			modelFacturas.setColumnIdentifiers(headers1);
			TableColumnModel columModel1 = tableFactura.getColumnModel();
			columModel1.getColumn(0).setPreferredWidth(90);
			columModel1.getColumn(1).setPreferredWidth(90);
			columModel1.getColumn(2).setPreferredWidth(300);
			columModel1.getColumn(3).setPreferredWidth(120);
			columModel1.getColumn(4).setPreferredWidth(110);
			scrollPane.setViewportView(tableFactura);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(394, 431, 250, 70);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Total Comprado:");
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
		float monto=0;
		for(OrdenInventario x: Tienda.getInstance().getOrdenes()) {
			if(x instanceof CompraInventario) {
				rowsFacturas[0]= ((CompraInventario) x).getCodigo();
				rowsFacturas[1]=x.getFechaTexto();
				rowsFacturas[2]=x.getProveedor().getNombre();
				if(((CompraInventario) x).isRecibida()) {
					rowsFacturas[3]="RECIBIDA";
				} else {
					rowsFacturas[3]="SIN RECIBIR";
				}
				rowsFacturas[4]="$ "+x.getCostoTotal();
				monto+=x.getCostoTotal();;
				modelFacturas.addRow(rowsFacturas);
			}

			txtMonto.setText("$ "+monto);
		}
	}
}
