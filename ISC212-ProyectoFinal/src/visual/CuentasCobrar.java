package visual;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuentasCobrar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnSalir;

	public CuentasCobrar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CuentasCobrar.class.getResource("/resources/logo.png")));
		setTitle("Cecomsa - Cuentas por Cobrar");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton button = new JButton("");
			button.setIcon(new ImageIcon(CuentasCobrar.class.getResource("/resources/abrir.png")));
			button.setBounds(10, 391, 70, 70);
			contentPanel.add(button);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 39, 774, 341);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnPagar = new JButton("PAGAR");
		btnPagar.setBounds(90, 391, 70, 70);
		contentPanel.add(btnPagar);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(CuentasCobrar.class.getResource("/resources/salir.png")));
		btnSalir.setBounds(714, 391, 70, 70);
		contentPanel.add(btnSalir);
		
		JButton btnVerCliente = new JButton("VER CLIENTE");
		btnVerCliente.setBounds(170, 391, 70, 70);
		contentPanel.add(btnVerCliente);
		
		JLabel lblNewLabel = new JLabel("Ordenar por:");
		lblNewLabel.setBounds(10, 14, 70, 14);
		contentPanel.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"FECHA DE FACTURACION", "FECHA LIMITE DE PAGO", "CLIENTE", "VENDEDOR"}));
		comboBox.setBounds(90, 11, 200, 20);
		contentPanel.add(comboBox);
	}
}
