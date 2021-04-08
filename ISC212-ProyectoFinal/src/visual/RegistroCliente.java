package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Cliente;
import logic.Tienda;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class RegistroCliente extends JDialog {
	
	private static Cliente cliente=null;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JSpinner spnCredito;
	private JButton btnAccion;
	private JButton btnCancelar;

	public RegistroCliente(Cliente aux, int funcion) {
		
		cliente=aux;
		if(cliente == null) {
			setTitle("Registro de Clientes");
		} else {
			if(funcion==0) {
				setTitle("Modificador de Clientes (Cedula:"+cliente.getCedula()+")");
			}  else {
				if(funcion==1) {
					setTitle("Ver cliente (Cedula:"+cliente.getCedula()+")");
				} else {
					setTitle("Eliminar cliente (Cedula:"+cliente.getCedula()+")");
				}
			}
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroCliente.class.getResource("/resources/logo.png")));
		setBounds(100, 100, 375, 270);
		setLocationRelativeTo(null);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblCedula = new JLabel("Cedula:");
				lblCedula.setBounds(10, 11, 46, 14);
				panel.add(lblCedula);
			}
			
			txtCedula = new JTextField();
			txtCedula.setBounds(86, 8, 150, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(86, 39, 250, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 42, 46, 14);
			panel.add(lblNombre);
			
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setBounds(10, 73, 86, 14);
			panel.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(86, 70, 250, 20);
			panel.add(txtTelefono);
			
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(86, 98, 250, 20);
			panel.add(txtDireccion);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(10, 101, 86, 14);
			panel.add(lblDireccion);
			
			spnCredito = new JSpinner();
			spnCredito.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnCredito.setBounds(125, 140, 211, 20);
			panel.add(spnCredito);
			
			JLabel lblNewLabel = new JLabel("Limite de Credito:");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(10, 143, 117, 14);
			panel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				if(cliente == null) {
					btnAccion = new JButton("Registrar");
				} else {
					if(funcion==0) {
						btnAccion = new JButton("Modificar");
						txtCedula.setEnabled(false);
					}  else {
						if(funcion==2) {
							btnAccion = new JButton("Eliminar");
						} else {
							btnAccion = new JButton("Abrir");
							btnAccion.setVisible(false);
						}
					}
				}
				
				btnAccion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(cliente == null) { 
							if(!Tienda.getInstance().verificarCliente(txtCedula.getText())) {
								Tienda.getInstance().generarCliente(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), (Float)spnCredito.getValue());
								clean();
							} else {
								JOptionPane.showMessageDialog(null, "Esta cédula ya pertenece a un cliente", "Error", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							if(funcion==0) {
								Tienda.getInstance().modificarCliente(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), (Float)spnCredito.getValue());								
								dispose();
							}  else {
								if(funcion==2) {
									Tienda.getInstance().eliminarCliente(cliente.getCedula());
									dispose();
								}
							}
						}
					}
				});
				buttonPane.add(btnAccion);
				getRootPane().setDefaultButton(btnAccion);
			}
			{
				btnCancelar = new JButton("Salir");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		if(cliente != null) {
			if(funcion!=0) {
				bloquearCampos();
			}
			cargarCliente();
		}
	}
	
	private void bloquearCampos() {
		txtCedula.setEnabled(false);
		txtNombre.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtDireccion.setEnabled(false);
		spnCredito.setEnabled(false);	
	}
	private void cargarCliente() {
		txtCedula.setText(cliente.getCedula());
		txtNombre.setText(cliente.getNombre());
		txtTelefono.setText(cliente.getTelefono());
		txtDireccion.setText(cliente.getDireccion());
		spnCredito.setValue(cliente.getCreditoLimite());		
	}
	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		spnCredito.setValue(0);
	}
}
