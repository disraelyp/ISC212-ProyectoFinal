package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Componente;
import logic.PaqueteComponentes;
import logic.Producto;
import logic.Tienda;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;

public class RegistroPaqueteComponentes extends JDialog {

	private static ArrayList<Componente> componentes;
	private static PaqueteComponentes paqueteComponentes=null;
	private static String componenteSeleccionado;
	private static int funcion;
	
	private static DefaultTableModel modelProductos;
	private static Object[] rowsProductos;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtCosto;
	private JButton btnAccion;
	private JTable table;
	private JButton btnEliminar;
	private JSpinner spnDescuento;
	private JSpinner spnCantidad;

	public RegistroPaqueteComponentes(PaqueteComponentes aux, int aux2) {
		
		funcion = aux2;
		componentes=new ArrayList<Componente>();
		paqueteComponentes=aux;
		if(paqueteComponentes == null) {
			setTitle("CECOMSA - Registro de paquete de componentes.");
		} else {
			if(funcion==0) {
				setTitle("CECOMSA - Modificador de paquete componentes (Codigo:"+paqueteComponentes.getCodigo()+").");
			}  else {
				if(funcion==1) {
					setTitle("CECOMSA - Ver paquete componente (Codigo:"+paqueteComponentes.getCodigo()+").");
				} else {
					setTitle("CECOMSA - Eliminar paquete componentes (Codigo:"+paqueteComponentes.getCodigo()+").");
				}
			}
		}
		
		setBounds(100, 100, 460, 500);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/logo.png")));
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panelComponentes = new JPanel();
			panelComponentes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelComponentes.setBounds(10, 11, 414, 300);
			panel.add(panelComponentes);
			panelComponentes.setLayout(null);
			
			JLabel lblTabla = new JLabel("Componentes del paquete:");
			lblTabla.setBounds(10, 11, 394, 14);
			panelComponentes.add(lblTabla);
			
			JPanel panelTabla = new JPanel();
			panelTabla.setBounds(10, 36, 344, 253);
			panelComponentes.add(panelTabla);
			panelTabla.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panelTabla.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int seleccion = -1;
					seleccion = table.getSelectedRow();
					componenteSeleccionado = table.getValueAt(seleccion,  0).toString();
					btnEliminar.setEnabled(true);
				}
			});
			
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			modelProductos = new DefaultTableModel();
			table.setModel(modelProductos);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getTableHeader().setReorderingAllowed(false);
			
			String[] headers= {"Codigo", "Descripcion", "Cantidad"};
			modelProductos.setColumnIdentifiers(headers);
			TableColumnModel columModel = table.getColumnModel();
			columModel.getColumn(0).setPreferredWidth(90);
			columModel.getColumn(1).setPreferredWidth(160);
			columModel.getColumn(2).setPreferredWidth(90);
			
			scrollPane.setViewportView(table);
			
			JButton btnAgregar = new JButton("");
			btnAgregar.setIcon(new ImageIcon(RegistroPaqueteComponentes.class.getResource("/resources/mas.png")));
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoProductos listadoProductos = new ListadoProductos(true, true);
					Producto producto = listadoProductos.showDialog();
					
					if(producto!=null) {
						componentes.add((Componente) producto);
						cargarComponentes();
					}
				}				
			});
			btnAgregar.setBounds(364, 36, 40, 40);
			panelComponentes.add(btnAgregar);
			
			btnEliminar = new JButton("");
			btnEliminar.setIcon(new ImageIcon(RegistroPaqueteComponentes.class.getResource("/resources/x.png")));
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					componentes.remove(Tienda.getInstance().buscarComponente(componenteSeleccionado));
				}
			});
			btnEliminar.setEnabled(false);
			btnEliminar.setBounds(364, 87, 40, 40);
			panelComponentes.add(btnEliminar);
			
			JPanel panelInformacion = new JPanel();
			panelInformacion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInformacion.setBounds(10, 328, 414, 80);
			panel.add(panelInformacion);
			panelInformacion.setLayout(null);
			
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(90, 11, 110, 20);
			panelInformacion.add(txtPrecio);
			txtPrecio.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Precio total:");
			lblNewLabel_1.setBounds(10, 14, 102, 14);
			panelInformacion.add(lblNewLabel_1);
			
			txtCosto = new JTextField();
			txtCosto.setEditable(false);
			txtCosto.setColumns(10);
			txtCosto.setBounds(90, 42, 110, 20);
			panelInformacion.add(txtCosto);
			
			spnDescuento = new JSpinner();
			spnDescuento.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					cargarComponentes();
				}
			});
			spnDescuento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(0.5)));
			spnDescuento.setBounds(284, 11, 110, 20);
			panelInformacion.add(spnDescuento);
			
			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(0, 0, 0, 1));
			spnCantidad.setBounds(284, 42, 110, 20);
			panelInformacion.add(spnCantidad);
			
			JLabel lblCosto = new JLabel("Costo total:");
			lblCosto.setBounds(10, 45, 102, 14);
			panelInformacion.add(lblCosto);
			
			JLabel lblCantidad = new JLabel("Cantidad D.:");
			lblCantidad.setBounds(210, 45, 102, 14);
			panelInformacion.add(lblCantidad);
			
			JLabel lblDescuento = new JLabel("Descuento:");
			lblDescuento.setBounds(210, 14, 102, 14);
			panelInformacion.add(lblDescuento);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				if(paqueteComponentes == null) {
					btnAccion = new JButton("Registrar");
				} else {
					if(funcion==0) {
						btnAccion = new JButton("Modificar");
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
						if(aux == null) { 
							if(componentes.isEmpty() || componentes.size()<=1) {
								JOptionPane.showMessageDialog(null, "Se necesita almenos dos productos para crear un paquete.", "Error", JOptionPane.WARNING_MESSAGE);
							} else {
								Tienda.getInstance().generarPaqueteComponentes(componentes, (float) spnDescuento.getValue(), (int) spnCantidad.getValue());
								clean();
							}
						} else {
							if(funcion==0) {
								Tienda.getInstance().modificarPaqueteComponentes(paqueteComponentes.getCodigo(), componentes, (float) spnDescuento.getValue(), (int) spnCantidad.getValue());
								dispose();
							}  else {
								if(funcion==2) {
									Tienda.getInstance().eliminarPaqueteComponentes(paqueteComponentes.getCodigo());
									dispose();
								}
							}
						}
					}
				});
				buttonPane.add(btnAccion);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnSalir);
			}
		}
		if(paqueteComponentes != null) {
			if(funcion!=0) {
				bloquearCampos();
			}
			cargarCompra();
		}
	}

	private void bloquearCampos() {
		txtCosto.setEnabled(false);
		txtPrecio.setEnabled(false);
		spnCantidad.setValue(1);
		spnDescuento.setValue(0);
		spnDescuento.setEnabled(false);
		spnCantidad.setEnabled(false);
		btnAccion.setEnabled(false);
		btnEliminar.setEnabled(false);
		
		
		cargarComponentes();
	}
	
	private void clean() {
		componentes=new ArrayList<Componente>();
		spnCantidad.setValue(1);
		spnDescuento.setValue(0);
		cargarComponentes();
	}
	
	private void cargarCompra() {
		componentes=paqueteComponentes.getProductos();
		spnCantidad.setValue(paqueteComponentes.getCantidad());
		spnDescuento.setValue(paqueteComponentes.getDescuento());
		cargarComponentes();
	}
	
	private int cantidad() {
		int cantidad=0;
		String codigo=null;
		if(paqueteComponentes == null && funcion==0) {
			spnCantidad.setEnabled(true);
		}		
		for(Componente x: componentes) {
			if(x.getCantidad()>cantidad) {
				cantidad=x.getCantidad();
				codigo=x.getCodigo();
			}
		}
		if(cantidad!=0) {
			for(Producto x: Tienda.getInstance().getProductos()) {
				if(codigo.equals(x.getCodigo())) {
					cantidad=(int)(x.getCantidad()/5);
					break;
				}
			}
		}
		return cantidad;
	}
	
	private void cargarComponentes() {
		rowsProductos = new Object[modelProductos.getColumnCount()];
		float montoTotal=(float) 0.00;
		float costoTotal=(float) 0.00;
		modelProductos.setRowCount(0);
		if(componentes.size()!=0) {
			btnAccion.setEnabled(true);
			for(Componente x: componentes) {
				rowsProductos[0]= x.getCodigo();
				rowsProductos[1]= ((Componente) x).getMarca()+"-"+((Componente) x).getModelo();
				rowsProductos[2]=x.getCantidad();
				montoTotal+=x.getCantidad()*x.getPrecio();
				costoTotal+=x.getCantidad()*x.getCosto();
				modelProductos.addRow(rowsProductos);
			}
			txtPrecio.setText("$ "+((montoTotal)-(montoTotal*(((float) spnDescuento.getValue())/100))));
			txtCosto.setText("$ "+costoTotal);
			spnCantidad.setModel(new SpinnerNumberModel(1, 1, cantidad(), 1));
		}		
	}
}
