package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;

public class RegistroEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtCodigo;
	private JTextField txtUsuario;
	private JTextField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroEmpleado dialog = new RegistroEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroEmpleado() {
		setTitle("Registro de Empledos");
		setBounds(100, 100, 456, 552);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(5, 5, 430, 400);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(21, 191, 108, 14);
				panel.add(label);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setText("");
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(139, 185, 262, 20);
				panel.add(txtDireccion);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(139, 144, 262, 20);
				panel.add(txtTelefono);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(139, 103, 262, 20);
				panel.add(txtNombre);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setColumns(10);
				txtCedula.setBounds(139, 62, 262, 20);
				panel.add(txtCedula);
			}
			{
				JLabel label = new JLabel("C\u00E9dula:");
				label.setBounds(21, 68, 108, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(21, 109, 108, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Tel\u00E9fono:");
				label.setBounds(21, 150, 108, 14);
				panel.add(label);
			}
			{
				JLabel lblCodigo = new JLabel("C\u00F3digo:");
				lblCodigo.setBounds(21, 27, 108, 14);
				panel.add(lblCodigo);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEnabled(false);
				txtCodigo.setColumns(10);
				txtCodigo.setBounds(139, 21, 91, 20);
				panel.add(txtCodigo);
			}
			{
				JLabel lblSueldoBase = new JLabel("Sueldo base:");
				lblSueldoBase.setBounds(21, 232, 108, 14);
				panel.add(lblSueldoBase);
			}
			{
				JSpinner spnSueldoBase = new JSpinner();
				spnSueldoBase.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spnSueldoBase.setBounds(139, 226, 91, 20);
				panel.add(spnSueldoBase);
			}
			{
				JLabel lblUsuario = new JLabel("Usuario:");
				lblUsuario.setBounds(21, 314, 108, 14);
				panel.add(lblUsuario);
			}
			{
				txtUsuario = new JTextField();
				txtUsuario.setBounds(139, 308, 262, 20);
				panel.add(txtUsuario);
				txtUsuario.setColumns(10);
			}
			{
				txtContraseña = new JTextField();
				txtContraseña.setText("");
				txtContraseña.setBounds(139, 349, 262, 20);
				panel.add(txtContraseña);
				txtContraseña.setColumns(10);
			}
			{
				JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
				lblContraseña.setBounds(21, 355, 108, 14);
				panel.add(lblContraseña);
			}
			{
				JLabel lblComision = new JLabel("Comisi\u00F3n:");
				lblComision.setBounds(21, 273, 108, 14);
				panel.add(lblComision);
			}
			{
				JSpinner spnComision = new JSpinner();
				spnComision.setModel(new SpinnerNumberModel(1, 1, 10, 1));
				spnComision.setBounds(139, 270, 91, 20);
				panel.add(spnComision);
			}
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Administrador");
			rdbtnNewRadioButton.setBounds(263, 228, 125, 23);
			panel.add(rdbtnNewRadioButton);
			
			JPanel panelAdmin = new JPanel();
			panelAdmin.setBounds(240, 258, 161, 39);
			panel.add(panelAdmin);
			panelAdmin.setLayout(null);
			
			JLabel lblSueldoExtra = new JLabel("Sueldo extra:");
			lblSueldoExtra.setBounds(10, 14, 75, 14);
			panelAdmin.add(lblSueldoExtra);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(93, 11, 68, 20);
			panelAdmin.add(spinner);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(5, 405, 430, 97);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(350, 11, 70, 70);
				panel.add(btnCancelar);
			}
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setBounds(270, 11, 70, 70);
				panel.add(btnRegistrar);
			}
		}
	}
}
