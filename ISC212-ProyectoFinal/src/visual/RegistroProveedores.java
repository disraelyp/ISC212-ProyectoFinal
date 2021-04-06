package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logic.Proveedor;
import logic.Tienda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroProveedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRNC;
	private JTextField txtNombreE;
	private JTextField txtTelefonoE;
	private JTextField txtDireccionE;
	private JTextField txtNombreR;
	private JTextField txtTelefonoR;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroProveedores dialog = new RegistroProveedores(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroProveedores(Proveedor aux) {
		
		if(aux == null) {
			setTitle("Registro de Proveedores");
		} else {
			setTitle("Modificador de Proveedores");
			cargarProveedor(aux);
		}
		
		setBounds(100, 100, 450, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos de la Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(5, 5, 424, 201);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("RNC:");
				label.setBounds(22, 29, 68, 14);
				panel.add(label);
			}
			{
				txtRNC = new JTextField();			
				txtRNC.setColumns(10);
				txtRNC.setBounds(140, 24, 132, 20);
				if(aux!=null){
					txtRNC.setEnabled(false);
				}	
				panel.add(txtRNC);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(22, 72, 108, 14);
				panel.add(label);
			}
			{
				txtNombreE = new JTextField();
				txtNombreE.setColumns(10);
				txtNombreE.setBounds(140, 68, 262, 20);
				panel.add(txtNombreE);
			}
			{
				JLabel label = new JLabel("Tel\u00E9fono:");
				label.setBounds(22, 115, 108, 14);
				panel.add(label);
			}
			{
				txtTelefonoE = new JTextField();
				txtTelefonoE.setColumns(10);
				txtTelefonoE.setBounds(140, 112, 262, 20);
				panel.add(txtTelefonoE);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(22, 158, 108, 14);
				panel.add(label);
			}
			{
				txtDireccionE = new JTextField();
				txtDireccionE.setText("");
				txtDireccionE.setColumns(10);
				txtDireccionE.setBounds(140, 156, 262, 20);
				panel.add(txtDireccionE);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del Representante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(5, 209, 424, 124);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(22, 38, 108, 14);
				panel.add(label);
			}
			{
				txtNombreR = new JTextField();
				txtNombreR.setColumns(10);
				txtNombreR.setBounds(140, 35, 262, 20);
				panel.add(txtNombreR);
			}
			{
				JLabel label = new JLabel("Tel\u00E9fono:");
				label.setBounds(22, 78, 108, 14);
				panel.add(label);
			}
			{
				txtTelefonoR = new JTextField();
				txtTelefonoR.setColumns(10);
				txtTelefonoR.setBounds(140, 75, 262, 20);
				panel.add(txtTelefonoR);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(5, 344, 424, 89);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				btnNewButton = new JButton("New button");
				btnNewButton.setBounds(344, 11, 70, 70);
				panel.add(btnNewButton);
			}
			{
				if(aux == null) { // aqui cambian los botones
					btnNewButton_1 = new JButton("Registrar");
				} else {
					btnNewButton_1 = new JButton("Modificar");
				}
				
				
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(aux == null) { 
							if(Tienda.getInstance().verificarRnc(txtRNC.getText())) {
								Tienda.getInstance().generarProveedor(txtRNC.getText(), txtNombreE.getText(), txtTelefonoE.getText(), txtDireccionE.getText(), txtNombreR.getText(), txtTelefonoR.getText());
							} else {
								JOptionPane.showMessageDialog(null, "Este RNC ya pertenece a un proveedor registrado");;
							}
							clean();
						} else {
							Tienda.getInstance().modificarProveedor(txtRNC.getText(), txtNombreE.getText(), txtTelefonoE.getText(), txtDireccionE.getText(), txtNombreR.getText(), txtTelefonoR.getText() );
							dispose();
						}
					}
				});
				btnNewButton_1.setBounds(264, 11, 70, 70);
				panel.add(btnNewButton_1);
			}
		}
	}

	private void cargarProveedor(Proveedor aux) {
		txtRNC.setText(aux.getRnc());
		txtNombreE.setText(aux.getNombre());
		txtTelefonoE.setText(aux.getTelefono());
		txtDireccionE.setText(aux.getDireccion());
		txtNombreR.setText(aux.getNombreRepre());
		txtTelefonoR.setText(aux.getTelefonoRepre());
		
	}
	
	private void clean() {
		txtRNC.setText("");
		txtNombreE.setText("");
		txtTelefonoE.setText("");
		txtDireccionE.setText("");
		txtNombreR.setText("");
		txtTelefonoR.setText("");
	}

}
