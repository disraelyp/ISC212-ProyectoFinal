package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class RegistroProovedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRNC;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtRepresentante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroProovedor dialog = new RegistroProovedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroProovedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroProovedor.class.getResource("/resources/provee.png")));
		setTitle("Registro de Proveedores");
		setResizable(false);
		setBounds(100, 100, 509, 518);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 484, 367);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registro de Proveedores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblRNC = new JLabel("RNC:");
			lblRNC.setBounds(27, 49, 124, 14);
			panel.add(lblRNC);
			
			JLabel lblNewLabel = new JLabel("Nombre de la empresa:");
			lblNewLabel.setBounds(27, 112, 172, 14);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n:");
			lblNewLabel_1.setBounds(27, 175, 124, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_2.setBounds(27, 238, 124, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Representante:");
			lblNewLabel_3.setBounds(27, 301, 124, 14);
			panel.add(lblNewLabel_3);
			
			txtRNC = new JTextField();
			txtRNC.setBounds(178, 44, 138, 20);
			panel.add(txtRNC);
			txtRNC.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(178, 108, 275, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(178, 172, 275, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(178, 236, 138, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			txtRepresentante = new JTextField();
			txtRepresentante.setBounds(178, 300, 275, 20);
			panel.add(txtRepresentante);
			txtRepresentante.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 375, 484, 92);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(396, 11, 70, 70);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(316, 11, 70, 70);
		panel.add(btnNewButton_1);
	}
}
