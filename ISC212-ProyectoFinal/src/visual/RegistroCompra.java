package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class RegistroCompra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTable table;
	
	public RegistroCompra() {
		setResizable(false);
		setTitle("Modulo de Facturacion");
		setModal(true);
		setBounds(100, 100, 710, 534);	
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion del Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 309, 110);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblCodigo = new JLabel("Cedula:");
				lblCodigo.setBounds(10, 23, 80, 14);
				panel.add(lblCodigo);
			}
			
			textField = new JTextField();
			textField.setBounds(66, 20, 129, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			JButton btnNewButton_1 = new JButton("Buscar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoClientes listadoClientes = new ListadoClientes(true);
					listadoClientes.setVisible(true);
				}
			});
			btnNewButton_1.setBounds(205, 19, 89, 23);
			panel.add(btnNewButton_1);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 51, 46, 14);
			panel.add(lblNewLabel);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBounds(66, 48, 228, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Telefono:");
			lblNewLabel_1.setBounds(10, 82, 67, 14);
			panel.add(lblNewLabel_1);
			
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setBounds(66, 79, 228, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("");
			btnNewButton.setEnabled(false);
			btnNewButton.setIcon(new ImageIcon(RegistroVenta.class.getResource("/resources/abrir.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegistroComponente registroComponente = new RegistroComponente();
					registroComponente.setVisible(true);
				}
			});
			btnNewButton.setVerticalAlignment(SwingConstants.TOP);
			btnNewButton.setBounds(614, 173, 70, 70);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnEliminarProducto = new JButton("Agregar Producto");
			btnEliminarProducto.setEnabled(false);
			btnEliminarProducto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoProductos listadoProductos = new ListadoProductos(true);
					listadoProductos.setVisible(true);
				}
			});
			btnEliminarProducto.setVerticalAlignment(SwingConstants.BOTTOM);
			btnEliminarProducto.setHorizontalAlignment(SwingConstants.LEFT);
			btnEliminarProducto.setBounds(614, 251, 70, 70);
			contentPanel.add(btnEliminarProducto);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Adicional", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(329, 11, 275, 110);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 132, 594, 270);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		
		String[] headers= {"Codigo", "Descripcion", "Cantidad", "Costo Unit.", "Monto Total"};
		model.setColumnIdentifiers(headers);
		TableColumnModel columModel = table.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(100);
		columModel.getColumn(1).setPreferredWidth(200);
		columModel.getColumn(2).setPreferredWidth(90);
		columModel.getColumn(3).setPreferredWidth(100);
		columModel.getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JButton btnVerProducto = new JButton("Eliminar Producto");
		btnVerProducto.setEnabled(false);
		btnVerProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVerProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnVerProducto.setBounds(614, 332, 70, 70);
		contentPanel.add(btnVerProducto);
		
		JButton btnCuentasPorCobrar = new JButton("Cuentas por Pagar");
		btnCuentasPorCobrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCuentasPorCobrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCuentasPorCobrar.setBounds(614, 11, 70, 70);
		contentPanel.add(btnCuentasPorCobrar);
		
		JButton btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroComponente registroComponente = new RegistroComponente();
				registroComponente.setVisible(true);
			}
		});
		btnCrearProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearProducto.setBounds(614, 92, 70, 70);
		contentPanel.add(btnCrearProducto);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(362, 413, 322, 78);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setForeground(Color.RED);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_5.setText("$ 0.00     ");
		textField_5.setBounds(10, 36, 302, 31);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Monto a Pagar:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(10, 11, 240, 25);
		panel_2.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(RegistroVenta.class.getResource("/resources/facturar.png")));
		btnNewButton_2.setBounds(10, 413, 78, 78);
		contentPanel.add(btnNewButton_2);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(RegistroVenta.class.getResource("/resources/salir.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(98, 413, 78, 78);
		contentPanel.add(btnSalir);
	}

}
