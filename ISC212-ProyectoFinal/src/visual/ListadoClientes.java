package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model;
	private JTextField textField;
	private JTable table;

	public ListadoClientes(boolean seleccionar) {
		setResizable(false);
		setModal(true);
		setTitle("Listado de Clientes.");
		setBounds(100, 100, 360, 472);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Salir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(181, 400, 153, 23);
			contentPanel.add(btnNewButton);
		}
		
		textField = new JTextField();
		textField.setBounds(10, 11, 210, 23);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setBounds(230, 11, 104, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Mostrar todos");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(10, 45, 324, 23);
		contentPanel.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 79, 324, 310);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		
		String[] headers2= {"Cedula", "Nombre"};
		model.setColumnIdentifiers(headers2);
		TableColumnModel columModel = table.getColumnModel();
		columModel.getColumn(0).setPreferredWidth(99);
		columModel.getColumn(1).setPreferredWidth(220);
		scrollPane.setViewportView(table);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setEnabled(false);
		btnSeleccionar.setBounds(10, 400, 153, 23);
		contentPanel.add(btnSeleccionar);
	}
}
