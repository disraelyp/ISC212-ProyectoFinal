package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;

public class RegistroComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSerie;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroComponente dialog = new RegistroComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroComponente() {
		setTitle("Registro de Componentes");
		setBounds(100, 100, 546, 360);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panelGeneral = new JPanel();
				panelGeneral.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelGeneral.setBounds(0, 0, 520, 107);
				panel.add(panelGeneral);
				panelGeneral.setLayout(null);
				
				JLabel lblSerie = new JLabel("Serie:");
				lblSerie.setBounds(10, 23, 46, 14);
				panelGeneral.add(lblSerie);
				
				txtSerie = new JTextField();
				txtSerie.setBounds(58, 20, 189, 20);
				panelGeneral.add(txtSerie);
				txtSerie.setColumns(10);
				
				JLabel lblModelo = new JLabel("Modelo:");
				lblModelo.setBounds(10, 48, 46, 14);
				panelGeneral.add(lblModelo);
				
				textField = new JTextField();
				textField.setBounds(58, 45, 189, 20);
				panelGeneral.add(textField);
				textField.setColumns(10);
				
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(10, 73, 46, 14);
				panelGeneral.add(lblMarca);
				
				textField_1 = new JTextField();
				textField_1.setBounds(58, 70, 189, 20);
				panelGeneral.add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(266, 26, 65, 14);
				panelGeneral.add(lblCantidad);
				
				JSpinner spnCantidad = new JSpinner();
				spnCantidad.setBounds(321, 23, 49, 20);
				panelGeneral.add(spnCantidad);
				
				JLabel lblMinima = new JLabel("Cant. M\u00EDnima:");
				lblMinima.setBounds(387, 26, 101, 14);
				panelGeneral.add(lblMinima);
				
				JSpinner spnMinima = new JSpinner();
				spnMinima.setBounds(461, 23, 49, 20);
				panelGeneral.add(spnMinima);
				
				JLabel lblCosto = new JLabel("Costo:");
				lblCosto.setBounds(266, 51, 46, 14);
				panelGeneral.add(lblCosto);
				
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(266, 76, 46, 14);
				panelGeneral.add(lblPrecio);
				
				JSpinner spnCosto = new JSpinner();
				spnCosto.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
				spnCosto.setBounds(321, 48, 189, 20);
				panelGeneral.add(spnCosto);
				
				JSpinner spnPrecio = new JSpinner();
				spnPrecio.setBounds(321, 73, 189, 20);
				panelGeneral.add(spnPrecio);
			}
			
			JPanel panelTipo = new JPanel();
			panelTipo.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTipo.setBounds(0, 111, 520, 58);
			panel.add(panelTipo);
			panelTipo.setLayout(null);
			
			JRadioButton rdbtnTarjetaMadre = new JRadioButton("Tarjeta Madre");
			rdbtnTarjetaMadre.setSelected(true);
			rdbtnTarjetaMadre.setBounds(6, 20, 109, 23);
			panelTipo.add(rdbtnTarjetaMadre);
			
			JRadioButton rdbtnDiscoDuro = new JRadioButton("Disco Duro");
			rdbtnDiscoDuro.setBounds(287, 20, 109, 23);
			panelTipo.add(rdbtnDiscoDuro);
			
			JRadioButton rdbtnMicro = new JRadioButton("Microprocesador");
			rdbtnMicro.setBounds(137, 20, 126, 23);
			panelTipo.add(rdbtnMicro);
			
			JRadioButton rdbtnMemoriaRAM = new JRadioButton("Memoria RAM");
			rdbtnMemoriaRAM.setBounds(416, 20, 98, 23);
			panelTipo.add(rdbtnMemoriaRAM);
			
			JPanel panelTarjetaMadre = new JPanel();
			panelTarjetaMadre.setBorder(new TitledBorder(null, "Tarjeta Madre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTarjetaMadre.setBounds(0, 173, 520, 106);
			panel.add(panelTarjetaMadre);
			panelTarjetaMadre.setLayout(null);
			
			JLabel lblTipoMicro = new JLabel("Tipo de conexi\u00F3n del microprocesador:");
			lblTipoMicro.setBounds(50, 27, 226, 14);
			panelTarjetaMadre.add(lblTipoMicro);
			
			JLabel lblTipoDiscoDuro = new JLabel("Tipo de conexi\u00F3n del disco duro:");
			lblTipoDiscoDuro.setBounds(50, 52, 226, 14);
			panelTarjetaMadre.add(lblTipoDiscoDuro);
			
			JLabel lblTipoDeMemoria = new JLabel("Tipo de memoria RAM:");
			lblTipoDeMemoria.setBounds(50, 77, 226, 14);
			panelTarjetaMadre.add(lblTipoDeMemoria);
			
			JComboBox cbxTipoMicro = new JComboBox();
			cbxTipoMicro.setModel(new DefaultComboBoxModel(new String[] {"PGA", "BGA", "LGA"}));
			cbxTipoMicro.setBounds(304, 21, 121, 20);
			panelTarjetaMadre.add(cbxTipoMicro);
			
			JComboBox cbxTipoDiscoDuro = new JComboBox();
			cbxTipoDiscoDuro.setModel(new DefaultComboBoxModel(new String[] {"IDE", "SATA", "SATA-2", "SATA-3"}));
			cbxTipoDiscoDuro.setBounds(304, 46, 121, 20);
			panelTarjetaMadre.add(cbxTipoDiscoDuro);
			
			JComboBox cbxMemoriaRam = new JComboBox();
			cbxMemoriaRam.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR-2", "DDR-3", "DDR-4"}));
			cbxMemoriaRam.setBounds(304, 71, 121, 20);
			panelTarjetaMadre.add(cbxMemoriaRam);
			
			JPanel panelMicro = new JPanel();
			panelMicro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelMicro.setBounds(0, 173, 520, 106);
			panel.add(panelMicro);
			panelMicro.setLayout(null);
			
			JLabel lblConexion = new JLabel("Tipo de conexi\u00F3n del microprocesador:");
			lblConexion.setBounds(50, 27, 226, 14);
			panelMicro.add(lblConexion);
			
			JComboBox cbxConexion = new JComboBox();
			cbxConexion.setModel(new DefaultComboBoxModel(new String[] {"PGA", "BGA", "LGA"}));
			cbxConexion.setBounds(304, 21, 121, 20);
			panelMicro.add(cbxConexion);
			
			JLabel lblVelocidad = new JLabel("Velocidad:");
			lblVelocidad.setBounds(50, 52, 226, 14);
			panelMicro.add(lblVelocidad);
			
			JSpinner spnVelocidad = new JSpinner();
			spnVelocidad.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnVelocidad.setBounds(304, 46, 90, 20);
			panelMicro.add(spnVelocidad);
			
			JLabel lblNucleos = new JLabel("Cantidad de n\u00FAcleos:");
			lblNucleos.setBounds(50, 77, 226, 14);
			panelMicro.add(lblNucleos);
			
			JSpinner spnNucleos = new JSpinner();
			spnNucleos.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(1)));
			spnNucleos.setBounds(304, 71, 121, 20);
			panelMicro.add(spnNucleos);
			
			JLabel lblGHz = new JLabel("GHz");
			lblGHz.setBounds(396, 52, 26, 14);
			panelMicro.add(lblGHz);
			
			JPanel panelMemoriaRAM = new JPanel();
			panelMemoriaRAM.setBorder(new TitledBorder(null, "Memoria RAM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelMemoriaRAM.setLayout(null);
			panelMemoriaRAM.setBounds(0, 173, 522, 106);
			panel.add(panelMemoriaRAM);
			
			JLabel label = new JLabel("Capacidad de almacenamiento:");
			label.setBounds(50, 27, 226, 14);
			panelMemoriaRAM.add(label);
			
			JSpinner spnCapacidadRAM = new JSpinner();
			spnCapacidadRAM.setModel(new SpinnerListModel(new String[] {"4", "8", "16", "32", "64", "128"}));
			spnCapacidadRAM.setBounds(304, 21, 90, 20);
			panelMemoriaRAM.add(spnCapacidadRAM);
			
			JLabel label_1 = new JLabel("Gb");
			label_1.setBounds(400, 27, 23, 14);
			panelMemoriaRAM.add(label_1);
			
			JLabel lbl = new JLabel("Cantidad de revoluciones por minuto:");
			lbl.setBounds(50, 77, 226, 14);
			panelMemoriaRAM.add(lbl);
			
			JSpinner spinner_1 = new JSpinner();
			spinner_1.setBounds(0, 0, 121, 20);
			panelMemoriaRAM.add(spinner_1);
			
			JLabel lblMemoriaRAM = new JLabel("Tipo de memoria RAM:");
			lblMemoriaRAM.setBounds(50, 52, 226, 14);
			panelMemoriaRAM.add(lblMemoriaRAM);
			
			JComboBox cbxMemoriaRAM = new JComboBox();
			cbxMemoriaRAM.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR-2", "DDR-3", "DDR-4"}));
			cbxMemoriaRAM.setBounds(304, 46, 121, 20);
			panelMemoriaRAM.add(cbxMemoriaRAM);
			
			JPanel panelDiscoDuro = new JPanel();
			panelDiscoDuro.setBorder(new TitledBorder(null, "Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDiscoDuro.setBounds(0, 173, 520, 106);
			panel.add(panelDiscoDuro);
			panelDiscoDuro.setLayout(null);
			
			JLabel lblCapacidad = new JLabel("Capacidad de almacenamiento:");
			lblCapacidad.setBounds(50, 27, 226, 14);
			panelDiscoDuro.add(lblCapacidad);
			
			JSpinner spnCapacidad = new JSpinner();
			spnCapacidad.setModel(new SpinnerListModel(new String[] {"250", "500", "1000", "2000", "3000", "4000", "6000", "10000"}));
			spnCapacidad.setBounds(304, 21, 90, 20);
			panelDiscoDuro.add(spnCapacidad);
			
			JLabel lblGb = new JLabel("Gb");
			lblGb.setBounds(400, 27, 23, 14);
			panelDiscoDuro.add(lblGb);
			
			JLabel lblRPM = new JLabel("Cantidad de revoluciones por minuto:");
			lblRPM.setBounds(50, 77, 226, 14);
			panelDiscoDuro.add(lblRPM);
			
			JSpinner spnRPM = new JSpinner();
			spnRPM.setModel(new SpinnerListModel(new String[] {"5,400", "7,200", "10,000", "15,000"}));
			spnRPM.setBounds(304, 46, 121, 20);
			panelDiscoDuro.add(spnRPM);
			
			JLabel lblTipoDeConexion = new JLabel("Tipo de conexi\u00F3n:");
			lblTipoDeConexion.setBounds(50, 52, 226, 14);
			panelDiscoDuro.add(lblTipoDeConexion);
			
			JComboBox cbxConexionDD = new JComboBox();
			cbxConexionDD.setModel(new DefaultComboBoxModel(new String[] {"IDE", "SATA", "SATA-1", "SATA-2", "SATA-3"}));
			cbxConexionDD.setBounds(304, 46, 121, 20);
			panelDiscoDuro.add(cbxConexionDD);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
