package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class RegistroVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public RegistroVenta() {
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
			panel.setBorder(new TitledBorder(null, "Informacion del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
			JButton btnNewButton = new JButton("Ver producto");
			btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.setBounds(614, 173, 70, 70);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnEliminarProducto = new JButton("Agregar Producto");
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
		
		JLabel lblNewLabel_2 = new JLabel("Metodo de pago:");
		lblNewLabel_2.setBounds(10, 26, 90, 14);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(110, 23, 155, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Deuda Actual:");
		lblNewLabel_3.setBounds(10, 57, 90, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(100, 54, 165, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblLimiteDeCredito = new JLabel("Limite de Credito");
		lblLimiteDeCredito.setBounds(10, 82, 90, 14);
		panel.add(lblLimiteDeCredito);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(100, 79, 165, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 132, 594, 270);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnVerProducto = new JButton("Eliminar Producto");
		btnVerProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVerProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnVerProducto.setBounds(614, 332, 70, 70);
		contentPanel.add(btnVerProducto);
		
		JButton btnCuentasPorCobrar = new JButton("Cuentas por Cobrar");
		btnCuentasPorCobrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCuentasPorCobrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCuentasPorCobrar.setBounds(614, 11, 70, 70);
		contentPanel.add(btnCuentasPorCobrar);
		
		JButton btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrearProducto.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearProducto.setBounds(614, 92, 70, 70);
		contentPanel.add(btnCrearProducto);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(220, 413, 463, 78);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setForeground(Color.RED);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_5.setText("$ 0.00     ");
		textField_5.setBounds(213, 36, 240, 31);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Monto a Pagar:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(213, 11, 240, 25);
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 413, 200, 78);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
	}
}
