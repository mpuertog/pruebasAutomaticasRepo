package co.edu.uniandes.miso4208.herramienta.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.uniandes.miso4208.herramienta.controlador.Orquestador;
import co.edu.uniandes.miso4208.herramienta.repositorio.Aplicacion;
import co.edu.uniandes.miso4208.herramienta.repositorio.Prueba;
import co.edu.uniandes.miso4208.herramienta.repositorio.TipoDispositivo;
import co.edu.uniandes.miso4208.herramienta.repositorio.TipoPrueba;

public class Principal {

	private JFrame frmHerramientaAutomatizacinPruebas;
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	/**
	 * @wbp.nonvisual location=681,149
	 */
	private final JTable table = new JTable();
	private final JPanel panel_6 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JPanel panel_8 = new JPanel();
	private final JPanel panel_9 = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmHerramientaAutomatizacinPruebas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
				"Par\u00E1metro", "Valor"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMaxWidth(75);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setMaxWidth(75);
		frmHerramientaAutomatizacinPruebas = new JFrame();
		frmHerramientaAutomatizacinPruebas.setTitle("Herramienta automatizaci\u00F3n pruebas");
		frmHerramientaAutomatizacinPruebas.setBounds(100, 100, 800, 476);
		frmHerramientaAutomatizacinPruebas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHerramientaAutomatizacinPruebas.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		frmHerramientaAutomatizacinPruebas.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "1. Dispositivo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_6, BorderLayout.NORTH);
		
		JRadioButton rdbtnWeb = new JRadioButton("Web");
		rdbtnWeb.setSelected(true);
		buttonGroup.add(rdbtnWeb);
		panel_6.add(rdbtnWeb);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Android");
		buttonGroup.add(rdbtnNewRadioButton);
		panel_6.add(rdbtnNewRadioButton);
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "2. Aplicacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_7);
		
		JComboBox<Aplicacion> comboBox_1 = new JComboBox<>();
		panel_7.add(comboBox_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "3. Tipo prueba", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frmHerramientaAutomatizacinPruebas.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton rdbtnHeadless = new JRadioButton("Headless");
		buttonGroup.add(rdbtnHeadless);
		rdbtnHeadless.setSelected(true);
		panel_1.add(rdbtnHeadless);
		
		JRadioButton rdbtnEndend = new JRadioButton("End-2-end");
		buttonGroup.add(rdbtnEndend);
		panel_1.add(rdbtnEndend);
		
		JRadioButton rdbtnBehavior = new JRadioButton("Behavior");
		buttonGroup.add(rdbtnBehavior);
		panel_1.add(rdbtnBehavior);
		
		JRadioButton rdbtnRamdom = new JRadioButton("Ramdom");
		buttonGroup.add(rdbtnRamdom);
		panel_1.add(rdbtnRamdom);
		
		JRadioButton rdbtnNofunctional = new JRadioButton("No-functional");
		buttonGroup.add(rdbtnNofunctional);
		panel_1.add(rdbtnNofunctional);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Escenario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmHerramientaAutomatizacinPruebas.getContentPane().add(panel_2, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setColumns(30);
		textArea.setRows(10);
		panel_2.add(textArea);
		frmHerramientaAutomatizacinPruebas.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "5. Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.add(panel_8, BorderLayout.NORTH);
		
		JButton btnLanzar = new JButton("Lanzar");
		panel_8.add(btnLanzar);
		
		JButton btnGenerarReporte = new JButton("Generar reporte");
		panel_8.add(btnGenerarReporte);
		panel_9.setBorder(new TitledBorder(null, "Consola", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		panel_9.add(textArea_1);
		textArea_1.setRows(5);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "4. Parametros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frmHerramientaAutomatizacinPruebas.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblPrueba = new JLabel("Prueba:");
		panel_5.add(lblPrueba);
		lblPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox comboBox = new JComboBox<>();
		panel_5.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_4.add(scrollPane, BorderLayout.CENTER);

		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Aplicacion> aplicaciones = Aplicacion.obtenerPorDispositivo(TipoDispositivo.ANDROID);
				comboBox_1.setModel(new DefaultComboBoxModel(aplicaciones.toArray()));
			}
		});

		rdbtnWeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Aplicacion> aplicaciones = Aplicacion.obtenerPorDispositivo(TipoDispositivo.WEB);
				comboBox_1.setModel(new DefaultComboBoxModel(aplicaciones.toArray()));
			}
		});
		
		rdbtnHeadless.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacion aplicacion = (Aplicacion) comboBox_1.getSelectedItem();
				List<Prueba> pruebas = Prueba.obtenerPorAplicacionYTipo(aplicacion, TipoPrueba.HEADLESS);
				comboBox.setModel(new DefaultComboBoxModel(pruebas.toArray()));
			}
		});
		
		rdbtnEndend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacion aplicacion = (Aplicacion) comboBox_1.getSelectedItem();
				List<Prueba> pruebas = Prueba.obtenerPorAplicacionYTipo(aplicacion, TipoPrueba.END_2_END);
				comboBox.setModel(new DefaultComboBoxModel(pruebas.toArray()));
			}
		});

		
		rdbtnNofunctional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacion aplicacion = (Aplicacion) comboBox_1.getSelectedItem();
				List<Prueba> pruebas = Prueba.obtenerPorAplicacionYTipo(aplicacion, TipoPrueba.NO_FUNCIONAL);
				comboBox.setModel(new DefaultComboBoxModel(pruebas.toArray()));
			}
		});
		
		rdbtnRamdom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacion aplicacion = (Aplicacion) comboBox_1.getSelectedItem();
				List<Prueba> pruebas = Prueba.obtenerPorAplicacionYTipo(aplicacion, TipoPrueba.RANDOM);
				comboBox.setModel(new DefaultComboBoxModel(pruebas.toArray()));
			}
		});
		
		rdbtnBehavior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacion aplicacion = (Aplicacion) comboBox_1.getSelectedItem();
				List<Prueba> pruebas = Prueba.obtenerPorAplicacionYTipo(aplicacion, TipoPrueba.BEHAVIOR);
				comboBox.setModel(new DefaultComboBoxModel(pruebas.toArray()));
			}
		});
		
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orquestador.ejecutarPrueba((Prueba) comboBox.getSelectedItem());
			}
		});
	}

}
