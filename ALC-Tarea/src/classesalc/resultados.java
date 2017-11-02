package classesalc;

import classesalc.MatrizFraccion;
import classesalc.Fraccion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class resultados extends JFrame {

	private JPanel contentPane;
	public JTextArea areaResultados;
	public JButton btnRegresar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resultados frame = new resultados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public resultados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(148, 262, 112, 23);
		contentPane.add(btnRegresar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 399, 239);
		contentPane.add(scrollPane);
		
		areaResultados = new JTextArea();
		scrollPane.setViewportView(areaResultados);
		areaResultados.setEditable(false);
		
	}
	

	public void agregarOperacion(String op){
		areaResultados.append(op+"\n");
	}

	public void agregarlinea(){
		areaResultados.append("\n");
	}
	public void agregarMatrizResultado(MatrizFraccion m){

/*		
		for (int i=0; i< m.getNumFilas();i++){
			//for (int j=0; j<m.getNumColumnas();j++){
				//String h = matrizF[i][j].getFraccionString();
				areaResultados.append("[");
				Fraccion[] fila = m.getFila(i);
				
				
						
				areaResultados.append( m.getFila(i) +"\t");
			 //System.out.print(matrizF[i][j].getFraccionString()+"\t");
			//}
			System.out.println("]");
		}
*/
		
	}
}
