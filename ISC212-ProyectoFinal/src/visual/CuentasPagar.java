package visual;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuentasPagar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;

	public CuentasPagar() {
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
		
		JButton btnPagar = new JButton("pagar");
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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		
		String[] headers= {"Fecha", "Proveedor", "Administrador", "Fecha Limite de Pago", "Monto Total"};
		model.setColumnIdentifiers(headers);
		TableColumnModel columModel = table.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(90);
		columModel.getColumn(1).setPreferredWidth(230);
		columModel.getColumn(2).setPreferredWidth(180);
		columModel.getColumn(3).setPreferredWidth(130);
		columModel.getColumn(4).setPreferredWidth(130);
		scrollPane.setViewportView(table);
	}
}
