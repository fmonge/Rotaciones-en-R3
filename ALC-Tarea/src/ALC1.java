import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;

import classesalc.Fraccion;
import classesalc.MatrizFraccion;
import classesalc.resultados;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class ALC1 {
	private JFrame frmAlctarea;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_5;
	private JTextField txfnum11;
	private JTextField txfden11;
	private JTextField txfden12;
	private JTextField txfden13;
	private JTextField txfnum13;
	private JTextField txfnum14;
	private JTextField txfden14;
	private JTextField txfnum15;
	private JTextField txfden15;
	private JTextField txfnum21;
	private JTextField txfden21;
	private JTextField txfnum22;
	private JTextField txfden22;
	private JTextField txfnum23;
	private JTextField txfden23;
	private JTextField txfnum24;
	private JTextField txfden24;
	private JTextField txfnum25;
	private JTextField txfden25;
	private JTextField txfnum31;
	private JTextField txfden31;
	private JTextField txfnum32;
	private JTextField txfden32;
	private JTextField txfnum33;
	private JTextField txfden33;
	private JTextField txfnum34;
	private JTextField txfden34;
	private JTextField txfnum35;
	private JTextField txfden35;
	private JTextField txfnum41;
	private JTextField txfden41;
	private JTextField txfnum42;
	private JTextField txfden42;
	private JTextField txfnum43;
	private JTextField txfden43;
	private JTextField txfnum44;
	private JTextField txfden44;
	private JTextField txfnum45;
	private JTextField txfden45;
	private JTextField txfnum51;
	private JTextField txfden51;
	private JTextField txfnum52;
	private JTextField txfden52;
	private JTextField txfnum53;
	private JTextField txfden53;
	private JTextField txfnum54;
	private JTextField txfden54;
	private JTextField txfnum55;
	private JTextField txfden55;
	private JTextField textField_58;
	private JTextField textField_59;
	private JLabel lblErrorMessage;
	private JTextField txfnum12;	
	private JButton btnDatos;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;

	
	private JRadioButton rdbtnIntercambiarFilas;
	private JLabel lblSeleccioneLaOperacin;
	private JRadioButton rdbtnMultiplicarUnaFila;
	private JRadioButton rdbtnSumarUnaFila;
	private JSeparator separator;
	private JLabel label;
	private JLabel lblX;
	private JLabel label_1;
	private JButton btnEjecutar;
	private JButton btnDeshacer;
	private JSeparator separator_25;
	private JSeparator separator_26;
	private JButton btnNuevaMatriz;
	private JComboBox cmbColumnas;
	private JComboBox cmbFilas;
	
	private resultados misresultados = new resultados();
	
	//constantes y variables globales
	private int numFilas =2;
	private int numColumnas = 2;

//**************************************************************************
	private double[][] laMatriz;
	private MatrizFraccion miMatriz = new MatrizFraccion();
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ALC1 window = new ALC1();
					window.frmAlctarea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ALC1() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlctarea = new JFrame();
		frmAlctarea.setTitle("ALC-Tarea 1");
		frmAlctarea.setBounds(100, 100, 845, 498);
		frmAlctarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlctarea.getContentPane().setLayout(null);
		
		JLabel lblColumnas = new JLabel("Columnas");
		lblColumnas.setBounds(148, 42, 79, 14);
		frmAlctarea.getContentPane().add(lblColumnas);
		
		JLabel lblFilas = new JLabel("Filas");
		lblFilas.setBounds(30, 42, 28, 14);
		frmAlctarea.getContentPane().add(lblFilas);
		
		cmbFilas = new JComboBox();
		cmbFilas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				numFilas = cmbFilas.getSelectedIndex() + 2;
				lblErrorMessage.setText("escogió una matriz "+numFilas+"x"+numColumnas);

				//KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
							
			}
		});
		cmbFilas.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5"}));
		cmbFilas.setBounds(68, 39, 64, 20);
		frmAlctarea.getContentPane().add(cmbFilas);
		
		cmbColumnas = new JComboBox();
		cmbColumnas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			numColumnas = cmbColumnas.getSelectedIndex()+2;
			lblErrorMessage.setText("escogió una matriz "+numFilas+"x"+numColumnas);
			//Columnas
			btnNuevaMatriz.setEnabled(true);
			cmbColumnas.setEnabled(false);
			cmbFilas.setEnabled(false);
			habilitarColumnas(numFilas,numColumnas);
			laMatriz = new double[numFilas][numColumnas];
			btnDatos.setEnabled(true);
//			btnIngresarDatos.setEnabled(false);
			miMatriz.setTamano(numFilas, numColumnas);
			//

			}
		});
		cmbColumnas.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5"}));
		cmbColumnas.setBounds(212, 39, 64, 20);
		frmAlctarea.getContentPane().add(cmbColumnas);
		
		btnNuevaMatriz = new JButton("Nueva Matriz");
		btnNuevaMatriz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			cmbColumnas.setSelectedIndex(0);
			cmbFilas.setSelectedIndex(0);
			cmbColumnas.setEnabled(true);
			cmbFilas.setEnabled(true);
		
			btnDatos.setEnabled(true);
			btnDeshacer.setEnabled(false);
			btnEjecutar.setEnabled(false);
			resetearMatrix();
			
			}
		});
		btnNuevaMatriz.setEnabled(false);
		btnNuevaMatriz.setBounds(304, 38, 125, 23);
		frmAlctarea.getContentPane().add(btnNuevaMatriz);
		
		separator = new JSeparator();
		separator.setBounds(27, 105, 33, 2);
		frmAlctarea.getContentPane().add(separator);
				
		rdbtnIntercambiarFilas = new JRadioButton("Intercambiar filas");
		rdbtnIntercambiarFilas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textField.setEnabled(true);
				textField_1.setEnabled(true);

				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("1");
				textField_2.setEnabled(false);
				textField_3.setEnabled(false);
				textField_4.setEnabled(false);
				textField_58.setEnabled(false);
				textField_59.setEnabled(false);
				textField_7.setEnabled(false);
				textField_58.setText("");
				textField_59.setText("1");
				textField_7.setText("");
				textField_5.setEnabled(false);
				textField_5.setText("");

				
				
				if (rdbtnIntercambiarFilas.isSelected()){
					rdbtnMultiplicarUnaFila.setSelected(false);
					rdbtnSumarUnaFila.setSelected(false);}
			
			}
		});
		rdbtnIntercambiarFilas.setEnabled(false);
		rdbtnIntercambiarFilas.setBounds(304, 105, 196, 23);
		frmAlctarea.getContentPane().add(rdbtnIntercambiarFilas);
		
		lblSeleccioneLaOperacin = new JLabel("Seleccione la operaci\u00F3n elemental:");
		lblSeleccioneLaOperacin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccioneLaOperacin.setEnabled(false);
		lblSeleccioneLaOperacin.setBounds(304, 89, 264, 14);
		frmAlctarea.getContentPane().add(lblSeleccioneLaOperacin);
		
		rdbtnMultiplicarUnaFila = new JRadioButton("Multiplicar una fila por un escalar");
		rdbtnMultiplicarUnaFila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setEnabled(false);
			textField.setText("");
			textField_1.setEnabled(false);
			textField_1.setText("");
			textField_58.setEnabled(false);
			textField_59.setEnabled(false);
			textField_7.setEnabled(false);
			textField_58.setText("");
			textField_59.setText("1");
			textField_7.setText("");
			textField_5.setEnabled(false);
			textField_5.setText("");
			
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("1");
			textField_2.setEnabled(true);
			textField_3.setEnabled(true);
			textField_4.setEnabled(true);
			
			if (rdbtnMultiplicarUnaFila.isSelected()){
				rdbtnIntercambiarFilas.setSelected(false);
				rdbtnSumarUnaFila.setSelected(false);
			}
			
			
			}
		});
		rdbtnMultiplicarUnaFila.setEnabled(false);
		rdbtnMultiplicarUnaFila.setBounds(304, 172, 223, 23);
		frmAlctarea.getContentPane().add(rdbtnMultiplicarUnaFila);
		
		rdbtnSumarUnaFila = new JRadioButton("Sumar una fila con un m\u00FAltiplo \r\nde otra fila");
		rdbtnSumarUnaFila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setEnabled(false);
			textField.setText("");
			textField_1.setEnabled(false);
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("1");
			textField_2.setEnabled(false);
			textField_3.setEnabled(false);
			textField_4.setEnabled(false);
			
			textField_58.setEnabled(true);
			textField_59.setEnabled(true);
			textField_7.setEnabled(true);
			textField_5.setEnabled(true);
			
			if(rdbtnSumarUnaFila.isSelected()){
				rdbtnIntercambiarFilas.setSelected(false);
				rdbtnMultiplicarUnaFila.setSelected(false);
			}
			
				
			}
		});
		rdbtnSumarUnaFila.setEnabled(false);
		rdbtnSumarUnaFila.setBounds(304, 259, 234, 33);
		frmAlctarea.getContentPane().add(rdbtnSumarUnaFila);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(314, 135, 38, 20);
		frmAlctarea.getContentPane().add(textField);
		textField.setColumns(10);
		
		label = new JLabel("-->");
		label.setEnabled(false);
		label.setBounds(362, 138, 46, 14);
		frmAlctarea.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(387, 135, 38, 20);
		frmAlctarea.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(314, 205, 38, 20);
		frmAlctarea.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(387, 205, 38, 20);
		frmAlctarea.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblX = new JLabel("X");
		lblX.setEnabled(false);
		lblX.setBounds(362, 208, 22, 14);
		frmAlctarea.getContentPane().add(lblX);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setText("1");
		textField_4.setBounds(314, 232, 38, 20);
		frmAlctarea.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		label_1 = new JLabel("+");
		label_1.setEnabled(false);
		label_1.setBounds(410, 310, 22, 14);
		frmAlctarea.getContentPane().add(label_1);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(362, 299, 38, 20);
		frmAlctarea.getContentPane().add(textField_7);
				
		btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.out.println("ejecutar operacion");
			btnDeshacer.setEnabled(true);
			
			if (rdbtnIntercambiarFilas.isSelected()){
			lblErrorMessage.setText("Intercambiar Columnas");
			intercambiarFilas();
			
			}else{
				if (rdbtnMultiplicarUnaFila.isSelected()){
					lblErrorMessage.setText("Multiplicar una fila por un escalar");
					multiplicarEscalar();
					
				}else{
					if(rdbtnSumarUnaFila.isSelected()){
						lblErrorMessage.setText("Sumar una fila con un múltiplo de otra");
						sumarFilas();
						}
				}
			}
			//lblErrorMessage.setText("Por favor seleccion una operacion");
			}//if Radiobuttons
			
			
			
			
			
		});
		btnEjecutar.setEnabled(false);
		btnEjecutar.setBounds(362, 369, 89, 23);
		frmAlctarea.getContentPane().add(btnEjecutar);
		
		btnDeshacer = new JButton("Deshacer");
		btnDeshacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//misresultados.setVisible(true);
				lblErrorMessage.setText("Deshacer");
			}
		});
		btnDeshacer.setEnabled(false);
		btnDeshacer.setBounds(556, 70, 125, 23);
		frmAlctarea.getContentPane().add(btnDeshacer);
		
		txfnum11 = new JTextField();
		txfnum11.setBounds(27, 82, 31, 20);
		frmAlctarea.getContentPane().add(txfnum11);
		txfnum11.setColumns(10);
		
		txfden11 = new JTextField();
		txfden11.setText("1");
		txfden11.setColumns(10);
		txfden11.setBounds(27, 110, 31, 20);
		frmAlctarea.getContentPane().add(txfden11);
		
		txfden12 = new JTextField();
		txfden12.setText("1");
		txfden12.setColumns(10);
		txfden12.setBounds(84, 110, 31, 20);
		frmAlctarea.getContentPane().add(txfden12);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(84, 105, 33, 2);
		frmAlctarea.getContentPane().add(separator_1);
		
		txfden13 = new JTextField();
		txfden13.setEnabled(false);
		txfden13.setText("1");
		txfden13.setColumns(10);
		txfden13.setBounds(139, 110, 31, 20);
		frmAlctarea.getContentPane().add(txfden13);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(139, 105, 33, 2);
		frmAlctarea.getContentPane().add(separator_2);
		
		txfnum13 = new JTextField();
		txfnum13.setEnabled(false);
		txfnum13.setColumns(10);
		txfnum13.setBounds(139, 82, 31, 20);
		frmAlctarea.getContentPane().add(txfnum13);
		
		txfnum14 = new JTextField();
		txfnum14.setEnabled(false);
		txfnum14.setColumns(10);
		txfnum14.setBounds(196, 82, 31, 20);
		frmAlctarea.getContentPane().add(txfnum14);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(196, 105, 33, 2);
		frmAlctarea.getContentPane().add(separator_3);
		
		txfden14 = new JTextField();
		txfden14.setEnabled(false);
		txfden14.setText("1");
		txfden14.setColumns(10);
		txfden14.setBounds(196, 110, 31, 20);
		frmAlctarea.getContentPane().add(txfden14);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(244, 104, 33, 2);
		frmAlctarea.getContentPane().add(separator_4);
		
		txfnum15 = new JTextField();
		txfnum15.setEnabled(false);
		txfnum15.setColumns(10);
		txfnum15.setBounds(244, 81, 31, 20);
		frmAlctarea.getContentPane().add(txfnum15);
		
		txfden15 = new JTextField();
		txfden15.setEnabled(false);
		txfden15.setText("1");
		txfden15.setColumns(10);
		txfden15.setBounds(244, 109, 31, 20);
		frmAlctarea.getContentPane().add(txfden15);
		
		txfnum21 = new JTextField();
		txfnum21.setColumns(10);
		txfnum21.setBounds(27, 145, 31, 20);
		frmAlctarea.getContentPane().add(txfnum21);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(27, 168, 33, 2);
		frmAlctarea.getContentPane().add(separator_5);
		
		txfden21 = new JTextField();
		txfden21.setText("1");
		txfden21.setColumns(10);
		txfden21.setBounds(27, 173, 31, 20);
		frmAlctarea.getContentPane().add(txfden21);
		
		txfnum22 = new JTextField();
		txfnum22.setColumns(10);
		txfnum22.setBounds(84, 145, 31, 20);
		frmAlctarea.getContentPane().add(txfnum22);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(84, 168, 33, 2);
		frmAlctarea.getContentPane().add(separator_6);
		
		txfden22 = new JTextField();
		txfden22.setText("1");
		txfden22.setColumns(10);
		txfden22.setBounds(84, 173, 31, 20);
		frmAlctarea.getContentPane().add(txfden22);
		
		txfnum23 = new JTextField();
		txfnum23.setEnabled(false);
		txfnum23.setColumns(10);
		txfnum23.setBounds(139, 145, 31, 20);
		frmAlctarea.getContentPane().add(txfnum23);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(139, 168, 33, 2);
		frmAlctarea.getContentPane().add(separator_7);
		
		txfden23 = new JTextField();
		txfden23.setEnabled(false);
		txfden23.setText("1");
		txfden23.setColumns(10);
		txfden23.setBounds(139, 173, 31, 20);
		frmAlctarea.getContentPane().add(txfden23);
		
		txfnum24 = new JTextField();
		txfnum24.setEnabled(false);
		txfnum24.setColumns(10);
		txfnum24.setBounds(196, 145, 31, 20);
		frmAlctarea.getContentPane().add(txfnum24);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(196, 168, 33, 2);
		frmAlctarea.getContentPane().add(separator_8);
		
		txfden24 = new JTextField();
		txfden24.setEnabled(false);
		txfden24.setText("1");
		txfden24.setColumns(10);
		txfden24.setBounds(196, 173, 31, 20);
		frmAlctarea.getContentPane().add(txfden24);
		
		txfnum25 = new JTextField();
		txfnum25.setEnabled(false);
		txfnum25.setColumns(10);
		txfnum25.setBounds(244, 144, 31, 20);
		frmAlctarea.getContentPane().add(txfnum25);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(244, 167, 33, 2);
		frmAlctarea.getContentPane().add(separator_9);
		
		txfden25 = new JTextField();
		txfden25.setEnabled(false);
		txfden25.setText("1");
		txfden25.setColumns(10);
		txfden25.setBounds(244, 172, 31, 20);
		frmAlctarea.getContentPane().add(txfden25);
		
		txfnum31 = new JTextField();
		txfnum31.setEnabled(false);
		txfnum31.setColumns(10);
		txfnum31.setBounds(26, 205, 31, 20);
		frmAlctarea.getContentPane().add(txfnum31);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(26, 228, 33, 2);
		frmAlctarea.getContentPane().add(separator_10);
		
		txfden31 = new JTextField();
		txfden31.setEnabled(false);
		txfden31.setText("1");
		txfden31.setColumns(10);
		txfden31.setBounds(26, 233, 31, 20);
		frmAlctarea.getContentPane().add(txfden31);
		
		txfnum32 = new JTextField();
		txfnum32.setEnabled(false);
		txfnum32.setColumns(10);
		txfnum32.setBounds(83, 205, 31, 20);
		frmAlctarea.getContentPane().add(txfnum32);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(83, 228, 33, 2);
		frmAlctarea.getContentPane().add(separator_11);
		
		txfden32 = new JTextField();
		txfden32.setEnabled(false);
		txfden32.setText("1");
		txfden32.setColumns(10);
		txfden32.setBounds(83, 233, 31, 20);
		frmAlctarea.getContentPane().add(txfden32);
		
		txfnum33 = new JTextField();
		txfnum33.setEnabled(false);
		txfnum33.setColumns(10);
		txfnum33.setBounds(138, 205, 31, 20);
		frmAlctarea.getContentPane().add(txfnum33);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(138, 228, 33, 2);
		frmAlctarea.getContentPane().add(separator_12);
		
		txfden33 = new JTextField();
		txfden33.setEnabled(false);
		txfden33.setText("1");
		txfden33.setColumns(10);
		txfden33.setBounds(138, 233, 31, 20);
		frmAlctarea.getContentPane().add(txfden33);
		
		txfnum34 = new JTextField();
		txfnum34.setEnabled(false);
		txfnum34.setColumns(10);
		txfnum34.setBounds(195, 205, 31, 20);
		frmAlctarea.getContentPane().add(txfnum34);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(195, 228, 33, 2);
		frmAlctarea.getContentPane().add(separator_13);
		
		txfden34 = new JTextField();
		txfden34.setEnabled(false);
		txfden34.setText("1");
		txfden34.setColumns(10);
		txfden34.setBounds(195, 233, 31, 20);
		frmAlctarea.getContentPane().add(txfden34);
		
		txfnum35 = new JTextField();
		txfnum35.setEnabled(false);
		txfnum35.setColumns(10);
		txfnum35.setBounds(243, 204, 31, 20);
		frmAlctarea.getContentPane().add(txfnum35);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(243, 227, 33, 2);
		frmAlctarea.getContentPane().add(separator_14);
		
		txfden35 = new JTextField();
		txfden35.setEnabled(false);
		txfden35.setText("1");
		txfden35.setColumns(10);
		txfden35.setBounds(243, 232, 31, 20);
		frmAlctarea.getContentPane().add(txfden35);
		
		txfnum41 = new JTextField();
		txfnum41.setEnabled(false);
		txfnum41.setColumns(10);
		txfnum41.setBounds(26, 265, 31, 20);
		frmAlctarea.getContentPane().add(txfnum41);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(26, 288, 33, 2);
		frmAlctarea.getContentPane().add(separator_15);
		
		txfden41 = new JTextField();
		txfden41.setEnabled(false);
		txfden41.setText("1");
		txfden41.setColumns(10);
		txfden41.setBounds(26, 293, 31, 20);
		frmAlctarea.getContentPane().add(txfden41);
		
		txfnum42 = new JTextField();
		txfnum42.setEnabled(false);
		txfnum42.setColumns(10);
		txfnum42.setBounds(83, 265, 31, 20);
		frmAlctarea.getContentPane().add(txfnum42);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setBounds(83, 288, 33, 2);
		frmAlctarea.getContentPane().add(separator_16);
		
		txfden42 = new JTextField();
		txfden42.setEnabled(false);
		txfden42.setText("1");
		txfden42.setColumns(10);
		txfden42.setBounds(83, 293, 31, 20);
		frmAlctarea.getContentPane().add(txfden42);
		
		txfnum43 = new JTextField();
		txfnum43.setEnabled(false);
		txfnum43.setColumns(10);
		txfnum43.setBounds(138, 265, 31, 20);
		frmAlctarea.getContentPane().add(txfnum43);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setBounds(138, 288, 33, 2);
		frmAlctarea.getContentPane().add(separator_17);
		
		txfden43 = new JTextField();
		txfden43.setEnabled(false);
		txfden43.setText("1");
		txfden43.setColumns(10);
		txfden43.setBounds(138, 293, 31, 20);
		frmAlctarea.getContentPane().add(txfden43);
		
		txfnum44 = new JTextField();
		txfnum44.setEnabled(false);
		txfnum44.setColumns(10);
		txfnum44.setBounds(195, 265, 31, 20);
		frmAlctarea.getContentPane().add(txfnum44);
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setBounds(195, 288, 33, 2);
		frmAlctarea.getContentPane().add(separator_18);
		
		txfden44 = new JTextField();
		txfden44.setEnabled(false);
		txfden44.setText("1");
		txfden44.setColumns(10);
		txfden44.setBounds(195, 293, 31, 20);
		frmAlctarea.getContentPane().add(txfden44);
		
		txfnum45 = new JTextField();
		txfnum45.setEnabled(false);
		txfnum45.setColumns(10);
		txfnum45.setBounds(243, 264, 31, 20);
		frmAlctarea.getContentPane().add(txfnum45);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setBounds(243, 287, 33, 2);
		frmAlctarea.getContentPane().add(separator_19);
		
		txfden45 = new JTextField();
		txfden45.setEnabled(false);
		txfden45.setText("1");
		txfden45.setColumns(10);
		txfden45.setBounds(243, 292, 31, 20);
		frmAlctarea.getContentPane().add(txfden45);
		
		txfnum51 = new JTextField();
		txfnum51.setEnabled(false);
		txfnum51.setColumns(10);
		txfnum51.setBounds(26, 328, 31, 20);
		frmAlctarea.getContentPane().add(txfnum51);
		
		JSeparator separator_20 = new JSeparator();
		separator_20.setBounds(26, 351, 33, 2);
		frmAlctarea.getContentPane().add(separator_20);
		
		txfden51 = new JTextField();
		txfden51.setEnabled(false);
		txfden51.setText("1");
		txfden51.setColumns(10);
		txfden51.setBounds(26, 356, 31, 20);
		frmAlctarea.getContentPane().add(txfden51);
		
		txfnum52 = new JTextField();
		txfnum52.setEnabled(false);
		txfnum52.setColumns(10);
		txfnum52.setBounds(83, 328, 31, 20);
		frmAlctarea.getContentPane().add(txfnum52);
		
		JSeparator separator_21 = new JSeparator();
		separator_21.setBounds(83, 351, 33, 2);
		frmAlctarea.getContentPane().add(separator_21);
		
		txfden52 = new JTextField();
		txfden52.setEnabled(false);
		txfden52.setText("1");
		txfden52.setColumns(10);
		txfden52.setBounds(83, 356, 31, 20);
		frmAlctarea.getContentPane().add(txfden52);
		
		txfnum53 = new JTextField();
		txfnum53.setEnabled(false);
		txfnum53.setColumns(10);
		txfnum53.setBounds(138, 328, 31, 20);
		frmAlctarea.getContentPane().add(txfnum53);
		
		JSeparator separator_22 = new JSeparator();
		separator_22.setBounds(138, 351, 33, 2);
		frmAlctarea.getContentPane().add(separator_22);
		
		txfden53 = new JTextField();
		txfden53.setEnabled(false);
		txfden53.setText("1");
		txfden53.setColumns(10);
		txfden53.setBounds(138, 356, 31, 20);
		frmAlctarea.getContentPane().add(txfden53);
		
		txfnum54 = new JTextField();
		txfnum54.setEnabled(false);
		txfnum54.setColumns(10);
		txfnum54.setBounds(195, 328, 31, 20);
		frmAlctarea.getContentPane().add(txfnum54);
		
		JSeparator separator_23 = new JSeparator();
		separator_23.setBounds(195, 351, 33, 2);
		frmAlctarea.getContentPane().add(separator_23);
		
		txfden54 = new JTextField();
		txfden54.setEnabled(false);
		txfden54.setText("1");
		txfden54.setColumns(10);
		txfden54.setBounds(195, 356, 31, 20);
		frmAlctarea.getContentPane().add(txfden54);
		
		txfnum55 = new JTextField();
		txfnum55.setEnabled(false);
		txfnum55.setColumns(10);
		txfnum55.setBounds(243, 327, 31, 20);
		frmAlctarea.getContentPane().add(txfnum55);
		
		JSeparator separator_24 = new JSeparator();
		separator_24.setBounds(243, 350, 33, 2);
		frmAlctarea.getContentPane().add(separator_24);
		
		txfden55 = new JTextField();
		txfden55.setEnabled(false);
		txfden55.setText("1");
		txfden55.setColumns(10);
		txfden55.setBounds(243, 355, 31, 20);
		frmAlctarea.getContentPane().add(txfden55);
		
		separator_25 = new JSeparator();
		separator_25.setBounds(314, 228, 33, 2);
		frmAlctarea.getContentPane().add(separator_25);
		
		textField_58 = new JTextField();
		textField_58.setEnabled(false);
		textField_58.setColumns(10);
		textField_58.setBounds(314, 299, 38, 20);
		frmAlctarea.getContentPane().add(textField_58);
		
		separator_26 = new JSeparator();
		separator_26.setBounds(314, 322, 33, 2);
		frmAlctarea.getContentPane().add(separator_26);
		
		textField_59 = new JTextField();
		textField_59.setEnabled(false);
		textField_59.setText("1");
		textField_59.setColumns(10);
		textField_59.setBounds(314, 326, 38, 20);
		frmAlctarea.getContentPane().add(textField_59);
		
		JSeparator separator_27 = new JSeparator();
		separator_27.setBounds(287, 408, 0, -338);
		frmAlctarea.getContentPane().add(separator_27);
		
		JSeparator separator_28 = new JSeparator();
		separator_28.setOrientation(SwingConstants.VERTICAL);
		separator_28.setBounds(298, 70, 6, 340);
		frmAlctarea.getContentPane().add(separator_28);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(0, 0, 611, 14);
		frmAlctarea.getContentPane().add(lblErrorMessage);
		
		txfnum12 = new JTextField();
		txfnum12.setText("1");
		txfnum12.setColumns(10);
		txfnum12.setBounds(84, 82, 31, 20);
		frmAlctarea.getContentPane().add(txfnum12);
		
		
		btnDatos = new JButton("Finalizar inserci\u00F3n");
		btnDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//colocar la matriz en un arreglo cuadrado
			
				//?
				
				btnNuevaMatriz.setEnabled(true);
				cmbColumnas.setEnabled(false);
				cmbFilas.setEnabled(false);
				laMatriz = new double[numFilas][numColumnas];
				miMatriz.setTamano(numFilas, numColumnas);
				
				//?
				
				
				cargarMatrix();
				lblErrorMessage.setText("Datos cargados, realice las operaciones");
				leerlaMatriz();
			//btnIngresarDatos.setEnabled(false);
			btnDatos.setEnabled(false);
			activarOperaciones();


			//************************************************************************************
			
			}
		});
		btnDatos.setBounds(103, 387, 173, 23);
		frmAlctarea.getContentPane().add(btnDatos);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(426, 299, 38, 20);
		frmAlctarea.getContentPane().add(textField_5);
		
		JSeparator separator_29 = new JSeparator();
		separator_29.setOrientation(SwingConstants.VERTICAL);
		separator_29.setBounds(544, 70, 6, 340);
		frmAlctarea.getContentPane().add(separator_29);
		
		JTextArea txtArea1 = new JTextArea();
		txtArea1.setBounds(10, 6, 1081, 20779);
		frmAlctarea.getContentPane().add(txtArea1);
		
		JScrollPane scrollPane = new JScrollPane(txtArea1);
		scrollPane.setBounds(555, 105, 264, 305);
		frmAlctarea.getContentPane().add(scrollPane);

		
		
		
	}
	
//habilita los campos segun el numero de filas y columnas deseados	
	void habilitarColumnas(int fila, int columna){

	if (fila != 0){
		if (fila==1){
			//se habilita 31,32
		  txfnum11.setEnabled(true);//columna 1
		  txfden11.setEnabled(true);
		  txfnum12.setEnabled(true); //fila 1
		  txfden12.setEnabled(true);
		  
			  //si la columna es 3 habilitamos //33
			  if (columna==3){
			  txfnum13.setEnabled(true);//columna 3
			  txfden13.setEnabled(true);
			  }
			  if(columna==4){
				  txfnum13.setEnabled(true);//columna 3
				  txfden13.setEnabled(true);
				  txfnum14.setEnabled(true);//columna 4
				  txfden14.setEnabled(true);
			  }
			  if(columna==5){
				  txfnum13.setEnabled(true);//columna 3
				  txfden13.setEnabled(true);
				  txfnum14.setEnabled(true);//columna 4
				  txfden14.setEnabled(true);
				  txfnum15.setEnabled(true);//columna 5
				  txfden15.setEnabled(true);
			}	//habilitarColumnas
		
		}//fila==1
		
		if (fila==2){
			//se habilita 31,32
		  txfnum21.setEnabled(true);//columna 1
		  txfden21.setEnabled(true);
		  txfnum22.setEnabled(true); //fila 1
		  txfden22.setEnabled(true);

		  if (columna==2){
		  txfnum22.setEnabled(true);
		  txfden22.setEnabled(true);
		  habilitarColumnas(fila-1, columna);
		  }
		  
			  //si la columna es 3 habilitamos //33
			  if (columna==3){
			  txfnum23.setEnabled(true);//columna 3
			  txfden23.setEnabled(true);
			  habilitarColumnas(fila-1, columna);
			  }
			  if(columna==4){
				  txfnum23.setEnabled(true);//columna 3
				  txfden23.setEnabled(true);
				  txfnum24.setEnabled(true);//columna 4
				  txfden24.setEnabled(true);
				  habilitarColumnas(fila-1, columna);
			  }
			  if(columna==5){
				  txfnum23.setEnabled(true);//columna 3
				  txfden23.setEnabled(true);
				  txfnum24.setEnabled(true);//columna 4
				  txfden24.setEnabled(true);
				  txfnum25.setEnabled(true);//columna 5
				  txfden25.setEnabled(true);
				  habilitarColumnas(fila-1, columna);
			}	//habilitarColumnas
		
		}//fila==2

//
		if (fila==3){
			//se habilita 31,32
		  txfnum31.setEnabled(true);//columna 1
		  txfden31.setEnabled(true);
		  txfnum32.setEnabled(true); //fila 1
		  txfden32.setEnabled(true);

		  if (columna==2){
		  txfnum32.setEnabled(true);
		  txfden32.setEnabled(true);
		  habilitarColumnas(fila-1, columna);
		  }

			  //si la columna es 3 habilitamos //33
			  if (columna==3){
			  txfnum33.setEnabled(true);//columna 3
			  txfden33.setEnabled(true);
			  habilitarColumnas(fila-1, columna);
			  }
			  if(columna==4){
				  txfnum33.setEnabled(true);//columna 3
				  txfden33.setEnabled(true);
				  txfnum34.setEnabled(true);//columna 4
				  txfden34.setEnabled(true);
				  habilitarColumnas(fila-1, columna);
			  }
			  if(columna==5){
				  txfnum33.setEnabled(true);//columna 3
				  txfden33.setEnabled(true);
				  txfnum34.setEnabled(true);//columna 4
				  txfden34.setEnabled(true);
				  txfnum35.setEnabled(true);//columna 5
				  txfden35.setEnabled(true);
				  habilitarColumnas(fila-1, columna);
			}	//habilitarColumnas
		
		}//fila==3
	}

		if (fila==4){
			
			//se habilita 31,32
		  txfnum41.setEnabled(true);//columna 1
		  txfden41.setEnabled(true);
		  txfnum42.setEnabled(true); //fila 1
		  txfden42.setEnabled(true);

		  if (columna==2){
		  txfnum42.setEnabled(true);
		  txfden42.setEnabled(true);
		  habilitarColumnas(fila-1, columna);
		  }
			  //si la columna es 3 habilitamos //33
			  if (columna==3){
			  txfnum43.setEnabled(true);//columna 3
			  txfden43.setEnabled(true);
			  habilitarColumnas(fila-1, columna);
			  }
			  if(columna==4){
				  txfnum43.setEnabled(true);//columna 3
				  txfden43.setEnabled(true);
				  txfnum44.setEnabled(true);//columna 4
				  txfden44.setEnabled(true);
				  habilitarColumnas(fila-1, columna);
			  }
			  if(columna==5){
				  txfnum43.setEnabled(true);//columna 3
				  txfden43.setEnabled(true);
				  txfnum44.setEnabled(true);//columna 4
				  txfden44.setEnabled(true);
				  txfnum45.setEnabled(true);//columna 5
				  txfden45.setEnabled(true);
				  habilitarColumnas(fila-1, columna);
			}	//habilitarColumnas
		
		}//fila==4
		
		
		if (fila==5){
			
			//se habilita 31,32
		  txfnum51.setEnabled(true);//columna 1
		  txfden51.setEnabled(true);
		  txfnum52.setEnabled(true); //fila 1
		  txfden52.setEnabled(true);
		  
		  if (columna==2){
		  txfnum52.setEnabled(true);
		  txfden52.setEnabled(true);
		  habilitarColumnas(fila-1, columna);
		  }

			  //si la columna es 3 habilitamos //33
			  if (columna==3){
			  txfnum53.setEnabled(true);//columna 3
			  txfden53.setEnabled(true);
			  habilitarColumnas(fila-1, columna);
			  }
			  if(columna==4){
				  txfnum53.setEnabled(true);//columna 3
				  txfden53.setEnabled(true);
				  txfnum54.setEnabled(true);//columna 4
				  txfden54.setEnabled(true);
				  habilitarColumnas(fila-1, columna);
			  }
			  if(columna==5){
				  txfnum53.setEnabled(true);//columna 3
				  txfden53.setEnabled(true);
				  txfnum54.setEnabled(true);//columna 4
				  txfden54.setEnabled(true);
				  txfnum55.setEnabled(true);//columna 5
				  txfden55.setEnabled(true);
				  habilitarColumnas(fila-1, columna);
			}	//habilitarColumnas
		
		}//fila==5
				


		
		
	}
	
//Limpia la matriz y la deja lista para empezar desde 0
	void resetearMatrix(){

		  txfnum11.setEnabled(true);
		  txfnum11.setText("");
		  txfden11.setEnabled(true);
		  txfden11.setText("1");
		  txfnum21.setEnabled(true);
		  txfnum21.setText("");
		  txfden21.setEnabled(true);
		  txfden21.setText("1");
		  txfnum31.setEnabled(false);
		  txfnum31.setText("");
		  txfden31.setEnabled(false);
		  txfden31.setText("1");
		  txfnum41.setEnabled(false);
		  txfnum41.setText("");
		  txfden41.setEnabled(false);
		  txfden41.setText("1");
		  txfnum51.setEnabled(false);
		  txfnum51.setText("");
		  txfden51.setEnabled(false);
		  txfden51.setText("1");

		  txfnum12.setEnabled(true);
		  txfnum12.setText("");
		  txfden12.setEnabled(true);
		  txfden12.setText("1");
		  txfnum22.setEnabled(true);
		  txfnum22.setText("");
		  txfden22.setEnabled(true);
		  txfden22.setText("1");
		  txfnum32.setEnabled(false);
		  txfnum32.setText("");
		  txfden32.setEnabled(false);
		  txfden32.setText("1");
		  txfnum42.setEnabled(false);
		  txfnum42.setText("");
		  txfden42.setEnabled(false);
		  txfden42.setText("1");
		  txfnum52.setEnabled(false);
		  txfnum52.setText("");
		  txfden52.setEnabled(false);
		  txfden52.setText("1");

		  txfnum13.setEnabled(false);
		  txfnum13.setText("");
		  txfden13.setEnabled(false);
		  txfden13.setText("1");
		  txfnum23.setEnabled(false);
		  txfnum23.setText("");
		  txfden23.setEnabled(false);
		  txfden23.setText("1");
		  txfnum33.setEnabled(false);
		  txfnum33.setText("");
		  txfden33.setEnabled(false);
		  txfden33.setText("1");
		  txfnum43.setEnabled(false);
		  txfnum43.setText("");
		  txfden43.setEnabled(false);
		  txfden43.setText("1");
		  txfnum53.setEnabled(false);
		  txfnum53.setText("");
		  txfden53.setEnabled(false);
		  txfden53.setText("1");

		  txfnum14.setEnabled(false);
		  txfnum14.setText("");
		  txfden14.setEnabled(false);
		  txfden14.setText("1");
		  txfnum24.setEnabled(false);
		  txfnum24.setText("");
		  txfden24.setEnabled(false);
		  txfden24.setText("1");
		  txfnum34.setEnabled(false);
		  txfnum34.setText("");
		  txfden34.setEnabled(false);
		  txfden34.setText("1");
		  txfnum44.setEnabled(false);
		  txfnum44.setText("");
		  txfden44.setEnabled(false);
		  txfden44.setText("1");
		  txfnum54.setEnabled(false);
		  txfnum54.setText("");
		  txfden54.setEnabled(false);
		  txfden54.setText("1");

		  txfnum15.setEnabled(false);
		  txfnum15.setText("");
		  txfden15.setEnabled(false);
		  txfden15.setText("1");
		  txfnum25.setEnabled(false);
		  txfnum25.setText("");
		  txfden25.setEnabled(false);
		  txfden25.setText("1");
		  txfnum35.setEnabled(false);
		  txfnum35.setText("");
		  txfden35.setEnabled(false);
		  txfden35.setText("1");
		  txfnum45.setEnabled(false);
		  txfnum45.setText("");
		  txfden45.setEnabled(false);
		  txfden45.setText("1");
		  txfnum55.setEnabled(false);
		  txfnum55.setText("");
		  txfden55.setEnabled(false);
		  txfden55.setText("1");
		  //resetear la matriz
		  numFilas =2;
		  numColumnas = 2;
		  
		 
	}// resetear matriz

	void cargarMatrix(){
		System.out.println("ojo1 "+laMatriz[0].length+" "+laMatriz.length);
		for (int i=0; i<laMatriz.length;i++ ){
			for (int j=0; j<laMatriz[0].length;j++){
			  laMatriz[i][j]= valorCelda(i,j);
			  System.out.println("ojo "+laMatriz[i][j]);
			}
		}

	
		for (int i=0; i<miMatriz.getNumFilas();i++){
			for (int j=0; j<miMatriz.getNumColumnas();j++){
			  miMatriz.setCampo(i,j,elementoMatriz(i,j));
			  System.out.println("cargado "+ miMatriz.getCampo(i, j).getFraccionString() );
			}
		}

		
		
	}//cargarMatrix
	
	
	Fraccion elementoMatriz(int i, int j){
		int fila = i+1;
		int columna = j+1;
		
		Fraccion elemento= new Fraccion();
		int numerador;
		int denominador;

		//FILA1		
				//fila1 columna1		
				if(fila==1){
					try
					{
		 		      if(columna==1){
			 		  numerador = Integer.parseInt(txfnum11.getText());
					  denominador = Integer.parseInt(txfden11.getText());					  
		 		      elemento = new Fraccion(numerador, denominador);
					  } //columna1
				  	  
					  if(columna==2){
					  numerador = Integer.parseInt(txfnum12.getText());
					  denominador = Integer.parseInt(txfden12.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna2
				      
					  if(columna==3){
				  	  numerador = Integer.parseInt(txfnum13.getText());
					  denominador = Integer.parseInt(txfden13.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna3
							
					  if(columna==4){
					  numerador = Integer.parseInt(txfnum14.getText());
					  denominador = Integer.parseInt(txfden14.getText());
					  elemento = new Fraccion(numerador, denominador);
		  			  }//columna4					
					  
					  if(columna==5){
		  			  numerador = Integer.parseInt(txfnum15.getText());
					  denominador = Integer.parseInt(txfden15.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }
					}catch (Exception e)
					{
					lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
					JOptionPane.showMessageDialog(frmAlctarea, "Error en los datos");
					}
				}	//FILA 1
					
		//FILA2		
				if(fila==2){
					try
					{
		 		      if(columna==1){
					  numerador = Integer.parseInt(txfnum21.getText());
					  denominador = Integer.parseInt(txfden21.getText());
					  elemento = new Fraccion(numerador, denominador);
					  } //columna1
				  	  
					  if(columna==2){
					  numerador = Integer.parseInt(txfnum22.getText());
					  denominador = Integer.parseInt(txfden22.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna2
				      
					  if(columna==3){
				  	  numerador = Integer.parseInt(txfnum23.getText());
					  denominador = Integer.parseInt(txfden23.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna3
							
					  if(columna==4){
					  numerador = Integer.parseInt(txfnum24.getText());
					  denominador = Integer.parseInt(txfden24.getText());
					  elemento = new Fraccion(numerador, denominador);
		  			  }//columna4					
					  
					  if(columna==5){
		  			  numerador = Integer.parseInt(txfnum25.getText());
					  denominador = Integer.parseInt(txfden25.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }
					}catch (Exception e)
					{
					lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
					}
				}	//FILA 2

		//FILA3	
				if(fila==3){
					try
					{
		 		      if(columna==1){
					  numerador = Integer.parseInt(txfnum31.getText());
					  denominador = Integer.parseInt(txfden31.getText());
					  elemento = new Fraccion(numerador, denominador);
					  } //columna1
				  	  
					  if(columna==2){
					  numerador = Integer.parseInt(txfnum32.getText());
					  denominador = Integer.parseInt(txfden32.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna2
				      
					  if(columna==3){
				  	  numerador = Integer.parseInt(txfnum33.getText());
					  denominador = Integer.parseInt(txfden33.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna3
							
					  if(columna==4){
					  numerador = Integer.parseInt(txfnum34.getText());
					  denominador = Integer.parseInt(txfden34.getText());
					  elemento = new Fraccion(numerador, denominador);
		  			  }//columna4					
					  
					  if(columna==5){
		  			  numerador = Integer.parseInt(txfnum35.getText());
					  denominador = Integer.parseInt(txfden35.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }
					}catch (Exception e)
					{
					lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
					}
				}	//FILA 3

		//FILA4	
				if(fila==4){
					try
					{
		 		      if(columna==1){
					  numerador = Integer.parseInt(txfnum41.getText());
					  denominador = Integer.parseInt(txfden41.getText());
					  elemento = new Fraccion(numerador, denominador);
					  } //columna1
				  	  
					  if(columna==2){
					  numerador = Integer.parseInt(txfnum42.getText());
					  denominador = Integer.parseInt(txfden42.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna2
				      
					  if(columna==3){
				  	  numerador = Integer.parseInt(txfnum43.getText());
					  denominador = Integer.parseInt(txfden43.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna3
							
					  if(columna==4){
					  numerador = Integer.parseInt(txfnum44.getText());
					  denominador = Integer.parseInt(txfden44.getText());
					  elemento = new Fraccion(numerador, denominador);
		  			  }//columna4					
					  
					  if(columna==5){
		  			  numerador = Integer.parseInt(txfnum45.getText());
					  denominador = Integer.parseInt(txfden45.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }
					}catch (Exception e)
					{
					lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
					}
				}	//FILA 4

		//FILA5	
				if(fila==5){
					try
					{
		 		      if(columna==1){
					  numerador = Integer.parseInt(txfnum51.getText());
					  denominador = Integer.parseInt(txfden51.getText());
					  elemento = new Fraccion(numerador, denominador);
					  } //columna1
				  	  
					  if(columna==2){
					  numerador = Integer.parseInt(txfnum52.getText());
					  denominador = Integer.parseInt(txfden52.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna2
				      
					  if(columna==3){
				  	  numerador = Integer.parseInt(txfnum53.getText());
					  denominador = Integer.parseInt(txfden53.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }//columna3
							
					  if(columna==4){
					  numerador = Integer.parseInt(txfnum54.getText());
					  denominador = Integer.parseInt(txfden54.getText());
					  elemento = new Fraccion(numerador, denominador);
		  			  }//columna4					
					  
					  if(columna==5){
		  			  numerador = Integer.parseInt(txfnum55.getText());
					  denominador = Integer.parseInt(txfden55.getText());
					  elemento = new Fraccion(numerador, denominador);
					  }
					}catch (Exception e)
					{
					lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
					}
					}//FILA 5

				return elemento;
	
		
	}
	
	
	
	double valorCelda(int i, int j){
		int fila = i+1;
		int columna = j+1;
		
		int numerador;
		int denominador;
		
		double valor = 0;

//FILA1		
		//fila1 columna1		
		if(fila==1){
			try
			{
 		      if(columna==1){
			  numerador = Integer.parseInt(txfnum11.getText());
			  denominador = Integer.parseInt(txfden11.getText());
			  valor = (double) numerador / denominador;
			  } //columna1
		  	  
			  if(columna==2){
			  numerador = Integer.parseInt(txfnum12.getText());
			  denominador = Integer.parseInt(txfden12.getText());
			  valor = (double) numerador / denominador;
			  }//columna2
		      
			  if(columna==3){
		  	  numerador = Integer.parseInt(txfnum13.getText());
			  denominador = Integer.parseInt(txfden13.getText());
			  valor = (double) numerador / denominador;
			  }//columna3
					
			  if(columna==4){
			  numerador = Integer.parseInt(txfnum14.getText());
			  denominador = Integer.parseInt(txfden14.getText());
			  valor = (double) numerador / denominador;
  			  }//columna4					
			  
			  if(columna==5){
  			  numerador = Integer.parseInt(txfnum15.getText());
			  denominador = Integer.parseInt(txfden15.getText());
			  valor = (double) numerador / denominador;
			  }
			}catch (Exception e)
			{
			lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
			}
		}	//FILA 1
			
//FILA2		
		if(fila==2){
			try
			{
 		      if(columna==1){
			  numerador = Integer.parseInt(txfnum21.getText());
			  denominador = Integer.parseInt(txfden21.getText());
			  valor = (double) numerador / denominador;
			  } //columna1
		  	  
			  if(columna==2){
			  numerador = Integer.parseInt(txfnum22.getText());
			  denominador = Integer.parseInt(txfden22.getText());
			  valor = (double) numerador / denominador;
			  }//columna2
		      
			  if(columna==3){
		  	  numerador = Integer.parseInt(txfnum23.getText());
			  denominador = Integer.parseInt(txfden23.getText());
			  valor = (double) numerador / denominador;
			  }//columna3
					
			  if(columna==4){
			  numerador = Integer.parseInt(txfnum24.getText());
			  denominador = Integer.parseInt(txfden24.getText());
			  valor = (double) numerador / denominador;
  			  }//columna4					
			  
			  if(columna==5){
  			  numerador = Integer.parseInt(txfnum25.getText());
			  denominador = Integer.parseInt(txfden25.getText());
			  valor = (double) numerador / denominador;
			  }
			}catch (Exception e)
			{
			lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
			}
		}	//FILA 2

//FILA3	
		if(fila==3){
			try
			{
 		      if(columna==1){
			  numerador = Integer.parseInt(txfnum31.getText());
			  denominador = Integer.parseInt(txfden31.getText());
			  valor = (double) numerador / denominador;
			  } //columna1
		  	  
			  if(columna==2){
			  numerador = Integer.parseInt(txfnum32.getText());
			  denominador = Integer.parseInt(txfden32.getText());
			  valor = (double) numerador / denominador;
			  }//columna2
		      
			  if(columna==3){
		  	  numerador = Integer.parseInt(txfnum33.getText());
			  denominador = Integer.parseInt(txfden33.getText());
			  valor = (double) numerador / denominador;
			  }//columna3
					
			  if(columna==4){
			  numerador = Integer.parseInt(txfnum34.getText());
			  denominador = Integer.parseInt(txfden34.getText());
			  valor = (double) numerador / denominador;
  			  }//columna4					
			  
			  if(columna==5){
  			  numerador = Integer.parseInt(txfnum35.getText());
			  denominador = Integer.parseInt(txfden35.getText());
			  valor = (double) numerador / denominador;
			  }
			}catch (Exception e)
			{
			lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
			}
		}	//FILA 3

//FILA4	
		if(fila==4){
			try
			{
 		      if(columna==1){
			  numerador = Integer.parseInt(txfnum41.getText());
			  denominador = Integer.parseInt(txfden41.getText());
			  valor = (double) numerador / denominador;
			  } //columna1
		  	  
			  if(columna==2){
			  numerador = Integer.parseInt(txfnum42.getText());
			  denominador = Integer.parseInt(txfden42.getText());
			  valor = (double) numerador / denominador;
			  }//columna2
		      
			  if(columna==3){
		  	  numerador = Integer.parseInt(txfnum43.getText());
			  denominador = Integer.parseInt(txfden43.getText());
			  valor = (double) numerador / denominador;
			  }//columna3
					
			  if(columna==4){
			  numerador = Integer.parseInt(txfnum44.getText());
			  denominador = Integer.parseInt(txfden44.getText());
			  valor = (double) numerador / denominador;
  			  }//columna4					
			  
			  if(columna==5){
  			  numerador = Integer.parseInt(txfnum45.getText());
			  denominador = Integer.parseInt(txfden45.getText());
			  valor = (double) numerador / denominador;
			  }
			}catch (Exception e)
			{
			lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
			}
		}	//FILA 4

//FILA5	
		if(fila==5){
			try
			{
 		      if(columna==1){
			  numerador = Integer.parseInt(txfnum51.getText());
			  denominador = Integer.parseInt(txfden51.getText());
			  valor = (double) numerador / denominador;
			  } //columna1
		  	  
			  if(columna==2){
			  numerador = Integer.parseInt(txfnum52.getText());
			  denominador = Integer.parseInt(txfden52.getText());
			  valor = (double) numerador / denominador;
			  }//columna2
		      
			  if(columna==3){
		  	  numerador = Integer.parseInt(txfnum53.getText());
			  denominador = Integer.parseInt(txfden53.getText());
			  valor = (double) numerador / denominador;
			  }//columna3
					
			  if(columna==4){
			  numerador = Integer.parseInt(txfnum54.getText());
			  denominador = Integer.parseInt(txfden54.getText());
			  valor = (double) numerador / denominador;
  			  }//columna4					
			  
			  if(columna==5){
  			  numerador = Integer.parseInt(txfnum55.getText());
			  denominador = Integer.parseInt(txfden55.getText());
			  valor = (double) numerador / denominador;
			  }
			}catch (Exception e)
			{
			lblErrorMessage.setText("Error en los datos insertados vuelva a empezar");
			}
			}//FILA 5

		return valor;
	}//valorCelda
	
	
	
	void leerlaMatriz(){
		
		for (int i=0; i<laMatriz.length;i++ ){
			for (int j=0; j<laMatriz[0].length;j++){
			  laMatriz[i][j]= valorCelda(i,j);
			  System.out.println("matriz "+laMatriz[i][j]);
		
			}	
		}	
	}//leerlaMatriz
	
	
	void activarOperaciones (){
	
		lblSeleccioneLaOperacin.setEnabled(true);//
		rdbtnMultiplicarUnaFila.setEnabled(true);
		rdbtnIntercambiarFilas.setEnabled(true);
		rdbtnSumarUnaFila.setEnabled(true);
		separator_25.setEnabled(true);
		separator_26.setEnabled(true);
		label.setEnabled(true);
		lblX.setEnabled(true);
		label_1.setEnabled(true);
		btnEjecutar.setEnabled(true);
		
	}//activar operaciones
	
	
	//OPERACIONES ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	

void sumarFilas(){
try{	
	System.out.println("Sumar filas");
	int fila1 = Integer.parseInt(textField_7.getText());
	int fila2 = Integer.parseInt(textField_5.getText());
	int escalarNum = Integer.parseInt(textField_58.getText());
	int escalarDen = Integer.parseInt(textField_59.getText());
	Fraccion escalar = new Fraccion(escalarNum,escalarDen);
	miMatriz.sumaFilaEscalarPorFila(escalar,fila1,fila2);
	//Guargar
	misresultados.agregarOperacion("Operacion de Sumar una fila con un múltiplo de otra fila");
	misresultados.agregarOperacion(escalar.getFraccionString()+" x "+"F"+fila1 +"+"+"F"+fila2);
	desplegarMatriz();
	//guardar
}catch(Exception e){
	System.out.println(""+e.getMessage());
	lblErrorMessage.setText("Error en los campos, intente de nuevo");
	JOptionPane.showMessageDialog(frmAlctarea, "Error en los datos");
}
	
}

void multiplicarEscalar(){
try{	
	System.out.println("Multiplicar por escalar ");
	int fila1 = Integer.parseInt(textField_3.getText());
	int escalarNum = Integer.parseInt(textField_2.getText());
	int escalarDen = Integer.parseInt(textField_4.getText());
	Fraccion escalar = new Fraccion(escalarNum,escalarDen);
	miMatriz.multiplicarEscalarPorFila(fila1, escalar);
	//Guargar
	misresultados.agregarOperacion("Operacion de Multiplicacion de una fila por un escalar");
	misresultados.agregarOperacion(escalar.getFraccionString()+" x "+"F"+fila1);
	desplegarMatriz();
	//guardar

}catch(Exception e){
	System.out.println(""+e.getMessage());
	lblErrorMessage.setText("Error en los campos, intente de nuevo");
	JOptionPane.showMessageDialog(frmAlctarea, "Error en los datos");
}	
	
}//multiplicar


void intercambiarFilas(){
try{	
	System.out.println("intercambiar ");
	int fila1 = Integer.parseInt(textField.getText());
	int fila2 = Integer.parseInt(textField_1.getText());
	miMatriz.intercambioDeFilas(fila1, fila2);
	//Guargar
	misresultados.agregarOperacion("Operacion de Intercambio de Filas");
	misresultados.agregarOperacion("F"+fila1+"<-->"+"F"+fila2);
	desplegarMatriz();
	//Guardar 
}catch(Exception e){
	lblErrorMessage.setText("Error en los campos, intente de nuevo");
	System.out.println("Error: "+e.getMessage());
	JOptionPane.showMessageDialog(frmAlctarea, "Error en los datos");
}
	

}//intercambiar
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	void desplegarMatriz(){
		
		for (int i=0; i<miMatriz.getNumFilas();i++ ){
			//misresultados.areaResultados.append( "[");
			for (int j=0; j<miMatriz.getNumColumnas();j++){
				misresultados.areaResultados.append( miMatriz.getCampo(i,j).getFraccionString());
				misresultados.areaResultados.append("\t");
			}
			//misresultados.areaResultados.append( "]");
			misresultados.agregarlinea();
		}	
		misresultados.agregarlinea();

	}//desplegar
}
