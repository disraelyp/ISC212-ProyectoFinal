package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logic.Cliente;
import logic.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class RegistroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JSpinner spnCredito;
	private JButton btnNewButton_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroCliente dialog = new RegistroCliente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroCliente(Cliente aux) {
		
		if(aux == null) {
			setTitle("Registro de Clientes");
		} else {
			setTitle("Modificador de Clientes");
			cargarCliente(aux);
		}
		
		setBounds(100, 100, 456, 366);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 439, 327);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 429, 225);
			panel.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(22, 66, 108, 14);
			panel.add(lblNombre);
			
			JLabel lblCedula = new JLabel("C\u00E9dula:");
			lblCedula.setBounds(22, 26, 108, 14);
			panel.add(lblCedula);
			
			JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
			lblTelefono.setBounds(22, 106, 108, 14);
			panel.add(lblTelefono);
			
			JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
			lblDireccion.setBounds(22, 146, 108, 14);
			panel.add(lblDireccion);
			
			JLabel lblCreditoLimite = new JLabel("Cr\u00E9dito l\u00EDmite:");
			lblCreditoLimite.setBounds(22, 188, 108, 14);
			panel.add(lblCreditoLimite);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(140, 23, 124, 20);
			if(aux!=null){
				txtCedula.setEnabled(false);
			}
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(140, 63, 262, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(140, 103, 262, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(140, 143, 262, 20);
			txtDireccion.setText("");
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			spnCredito = new JSpinner();
			spnCredito.setBounds(140, 185, 124, 20);
			panel.add(spnCredito);
		}
		
		btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(339, 241, 70, 70);
		contentPanel.add(btnNewButton);
		
		
		
		if(aux == null) { // aqui cambian los botones
			btnNewButton_1 = new JButton("Registrar");
		} else {
			btnNewButton_1 = new JButton("Modificar");
		}
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(aux == null) { 
					if(Tienda.getInstance().verificarCliente(txtCedula.getText())) {
						Tienda.getInstance().generarCliente(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), (Float)spnCredito.getValue());
					} else {
						JOptionPane.showMessageDialog(null, "Esta cédula ya pertenece a un cliente", "Error", JOptionPane.ERROR_MESSAGE);;
					}
					clean();
				} else {
					Tienda.getInstance().modificarCliente(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), (Float)spnCredito.getValue());
					dispose();
				}
				
				
				
			}

			
		});
		btnNewButton_1.setBounds(246, 241, 70, 70);
		contentPanel.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 235, 429, 81);
		contentPanel.add(panel);
	}

	private void cargarCliente(Cliente aux) {
		txtCedula.setText(aux.getCedula());
		txtNombre.setText(aux.getNombre());
		txtTelefono.setText(aux.getTelefono());
		txtDireccion.setText(aux.getDireccion());
		spnCredito.setValue(aux.getCreditoLimite());		
	}
	
	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		spnCredito.setValue(0);
		
	}
}
