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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class RegistroPaqueteComponentes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSerie;
	private JTable tableComponentes;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroPaqueteComponentes dialog = new RegistroPaqueteComponentes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroPaqueteComponentes() {
		setTitle("Registro de Paquetes de Componentes");
		setBounds(100, 100, 497, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panelBusqueda = new JPanel();
				panelBusqueda.setBorder(new TitledBorder(null, "Buscar componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelBusqueda.setBounds(0, 0, 471, 66);
				panel.add(panelBusqueda);
				panelBusqueda.setLayout(null);
				{
					JLabel lblCodigo = new JLabel("Serie:");
					lblCodigo.setBounds(58, 30, 64, 14);
					panelBusqueda.add(lblCodigo);
				}
				{
					txtSerie = new JTextField();
					txtSerie.setBounds(103, 27, 130, 20);
					panelBusqueda.add(txtSerie);
					txtSerie.setColumns(10);
				}
				
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(297, 26, 89, 23);
				panelBusqueda.add(btnBuscar);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 69, 471, 193);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			tableComponentes = new JTable();
			tableComponentes.setBorder(new TitledBorder(null, "Paquete de Componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setViewportView(tableComponentes);
			
			JPanel panelDatoPaquete = new JPanel();
			panelDatoPaquete.setBorder(new TitledBorder(null, "Datos del Paquete", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDatoPaquete.setBounds(0, 297, 471, 80);
			panel.add(panelDatoPaquete);
			panelDatoPaquete.setLayout(null);
			
			JLabel lblCodigo = new JLabel("C\u00F3digo:");
			lblCodigo.setBounds(10, 26, 95, 14);
			panelDatoPaquete.add(lblCodigo);
			
			JLabel lblPrecio = new JLabel("Descuento aplicado:");
			lblPrecio.setBounds(10, 51, 112, 14);
			panelDatoPaquete.add(lblPrecio);
			
			JLabel lblPrecioReal = new JLabel("Precio real:");
			lblPrecioReal.setBounds(227, 26, 77, 14);
			panelDatoPaquete.add(lblPrecioReal);
			
			JLabel lblPrecioDescuento = new JLabel("Precio con descuento:");
			lblPrecioDescuento.setBounds(227, 51, 120, 14);
			panelDatoPaquete.add(lblPrecioDescuento);
			
			textField = new JTextField();
			textField.setBounds(357, 23, 104, 20);
			panelDatoPaquete.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(357, 48, 102, 20);
			panelDatoPaquete.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(122, 48, 95, 20);
			panelDatoPaquete.add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(122, 20, 95, 20);
			panelDatoPaquete.add(textField_3);
			textField_3.setColumns(10);
			
			JPanel panelEliminar = new JPanel();
			panelEliminar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelEliminar.setBounds(0, 262, 471, 33);
			panel.add(panelEliminar);
			panelEliminar.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.setActionCommand("Cancel");
			panelEliminar.add(btnEliminar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCrear = new JButton("Crear");
				btnCrear.setActionCommand("OK");
				buttonPane.add(btnCrear);
				getRootPane().setDefaultButton(btnCrear);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
