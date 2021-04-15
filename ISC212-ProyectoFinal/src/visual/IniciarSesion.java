package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logic.Tienda;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class IniciarSesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnIngresar;
	private JPanel panel;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream tienda;
				FileOutputStream tienda2;
				ObjectInputStream read;
				ObjectOutputStream write;
				try {
					tienda=new FileInputStream("data.dat");
					read=new ObjectInputStream(tienda);
					Tienda temp = (Tienda)read.readObject();
					Tienda.setTienda(temp);
					tienda.close();
					read.close();
				} catch (FileNotFoundException e) {
					try {
						tienda2 = new FileOutputStream("data.dat");
						write = new ObjectOutputStream(tienda2);
						Tienda.getInstance().generarAdministrador("0000", "Administrador", "0000", "0000", 0, 0, "admin", "1234");
						Tienda.getInstance().generarVendedor("0000", "Vendedor", "0000", "0000", 0, 0, "vendedor", "1234");						
						write.writeObject(Tienda.getInstance());
						tienda2.close();
						write.close();
					} catch (FileNotFoundException e1){
					} catch (IOException e1) {
					}
				} catch (IOException e) {
				} catch (ClassNotFoundException e) {
				} 
				
				try {
					IniciarSesion iniciarSesion = new IniciarSesion();
					iniciarSesion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IniciarSesion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/resources/logo.png")));
		setTitle("CECOMSA - Ingreso al Sistema");
		
		
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 351, 230);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUsuario.setBounds(10, 11, 315, 20);
			panel.add(lblUsuario);
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(10, 42, 300, 20);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblContrasea.setBounds(10, 73, 315, 20);
			panel.add(lblContrasea);
			
			txtContraseña = new JPasswordField();
			txtContraseña.setBounds(10, 104, 300, 20);
			panel.add(txtContraseña);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnIngresar = new JButton("Ingresar");
				btnIngresar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Tienda.getInstance().iniciarSesion(txtUsuario.getText(), String.valueOf(txtContraseña.getPassword()))) {
							dispose();
							Principal principal = new Principal();
							principal.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null,"Error: Usuario o Contraseña invalidos","Error",JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
				buttonPane.add(btnIngresar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnCancelar);
			}
		}
	}
}
