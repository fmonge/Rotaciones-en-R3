package classesalc;
import java.lang.System;

public class MatrizFraccion {

	//private final Fraccion = new Fraccion();
    private int filas;
    private int columnas;
	Fraccion[][] matrizF;
    
	
	public MatrizFraccion() {
		// TODO Auto-generated constructor stub
		filas =2;
		columnas =2;
		matrizF = new Fraccion[filas][columnas];
	}
	
    public void setTamano(int i, int j) {
    	filas = i;
    	columnas = j;
    	matrizF = new Fraccion[i][j];
    }
    
    public void setColumnas(int j){
    	this.columnas=j;
    }

    public void setFilas(int i){
    	this.columnas=i;
    }
    
    public int getNumFilas(){
    	return filas;
    }
    
    public int getNumColumnas(){
    	return columnas;
    }    
     
    public void showMatrizConsola(){
    	
		for (int i=0; i<getNumFilas();i++){
			for (int j=0; j<getNumColumnas();j++){
				//String h = matrizF[i][j].getFraccionString();
				System.out.print("i"+i+",j"+j);
			 System.out.print(matrizF[i][j].getFraccionString()+"\t");
			}
			System.out.println();
		}

		
    }//show
    
    public Fraccion getCampo(int fila, int columna){
    	Fraccion campo = new Fraccion();
    	campo = matrizF[fila][columna]; 
    	return campo;
    }

    public void setCampo(int fila, int columna, Fraccion elemento){
    	//Fraccion campo = new Fraccion();
    	matrizF[fila][columna]= elemento; 
    }

    public Fraccion[] getFila(int filai){
    	Fraccion[] todalafila = new Fraccion[this.columnas];
    	System.out.print("fila"+(filai-1));
		for (int i=0; i<this.columnas;i++ ){
			todalafila[i]= matrizF[filai-1][i];
			System.out.print(" "+matrizF[filai-1][i].getFraccionString() );
		}
		System.out.println();
		
		return todalafila;
    }

    
   public void intercambioDeFilas(int fila1, int fila2){
	Fraccion[] buffer = new Fraccion[columnas];
	buffer = getFila(fila1);
    System.out.println("matriz original ");
	showMatrizConsola();

	for (int i=0; i<getNumFilas();i++){
		for (int j=0; j<getNumColumnas();j++){
			if (i==fila1-1){
				matrizF[fila1-1][j] = matrizF[fila2-1][j];
				matrizF[fila2-1][j] = buffer[j];
			}
		}
	//proxima fila
	}
	System.out.println("AplicandoIntercambio ");
 	showMatrizConsola();		

   }

   public void multiplicarEscalarPorFila(int filaF, Fraccion escalar){
	    System.out.println("matriz original ");
		showMatrizConsola();

		for (int i=0; i<getNumFilas();i++){
			for (int j=0; j<getNumColumnas();j++){
				if (i==filaF-1){
					matrizF[filaF-1][j] = matrizF[filaF-1][j].multiplicar(escalar);			
				}
			}
		//proxima fila
		}	
	System.out.println("AplicandoMultiplicacion ");
 	showMatrizConsola();		
		
//		System.out.println("fila-i "+matrizF[filai][i].toString());
	}

   
   public void sumaFilaEscalarPorFila(Fraccion escalar,int fila1,int fila2){
	    System.out.println("matriz original ");
		showMatrizConsola();

		for (int i=0; i<getNumFilas();i++){
			for (int j=0; j<getNumColumnas();j++){
				if (i==fila1-1){
					matrizF[fila2-1][j] = (matrizF[fila1-1][j].multiplicar(escalar)).sumar(matrizF[fila2-1][j]);
				}
			}
		//proxima fila
		}	
	System.out.println("AplicandoMultiplicacion x"+ escalar.getFraccionString());
	showMatrizConsola();		
	}   
   
}
