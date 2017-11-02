/**
 * 
 */
package classesalc;

import java.lang.IllegalArgumentException;
import java.lang.String;

/**
 * @author jchaves
 *
 */
public class Fraccion {

    private int numerador;
    private int denominador;
    //private double matrizF[][];
	/**
	 * 
	 */
	public Fraccion() {
		// TODO Auto-generated constructor stub
		 numerador = 0;
		 denominador = 1;
	}

	public Fraccion(int num, int den) {
		// TODO Auto-generated constructor stub
		this.numerador = num;
		if (den == 0) {
	        throw new IllegalArgumentException("denominador no puede ser cero");
	    }
	    this.denominador = den;
	}
	
/*	public Fraccion(int columnas, int filas){
	matrizF = new double[filas][columnas]; 
	
	}
*/	
    public String getFraccion() {
        return numerador + "/" + denominador;
    }

    public Fraccion getFraccionF() {
        return this;
    }

    public String getNumerador() {
        return ""+numerador;
    }
    public String getDenominador() {
        return ""+denominador;
    }

    public void setNumerador(int num) {
        numerador= num;
    }
    public void setDenominador(int den) {
        denominador= den;
    }
    
    public double getFraccionEnDecimal() {
        return ((double) numerador) / denominador;
    }

    public String getFraccionString() {
        return " "+numerador+"/"+denominador+" ";
    }

    //sumar fracciones
    public Fraccion sumar(Fraccion f) {
        Fraccion result = new Fraccion();
        result.numerador = this.numerador * f.denominador + this.denominador * f.numerador;
        result.denominador = this.denominador * f.denominador;
        result.simplificar();  //se simplifica antes de devolverla
        return result;
    }

    public Fraccion sumarFracciones(Fraccion f1, Fraccion f2) {
        Fraccion result = new Fraccion();
        result.numerador = f1.numerador * f2.denominador + f1.denominador * f2.numerador;
        result.denominador = f1.denominador * f2.denominador;
        return result;
    }
    
    
    //multiplicar fracciones
    public Fraccion multiplicar(Fraccion f) {
        Fraccion result = new Fraccion();
        result.numerador = this.numerador * f.numerador;
        result.denominador = this.denominador * f.denominador;
        result.simplificar(); 
        return result;
    }
    
    public Fraccion multiplicarFracciones(Fraccion f1, Fraccion f2) {
        Fraccion result = new Fraccion();
        result.numerador = f1.numerador * f2.numerador;
        result.denominador = f1.denominador * f2.denominador;      
        return result;
    }

    
    //máximo común divisor Euclides
    private int mcd() {
        int num = Math.abs(numerador);
        int den = Math.abs(denominador);
        if (den == 0) {
            return den;
        }
        int i;
        while (den != 0) {
            i = num % den;
            num = den;
            den = i;
        }
        return num;
    }

    //método para simplificar fracciones
    private void simplificar() {
        int i = mcd(); //mcd
        numerador = numerador / i;
        denominador = denominador / i;
    }
    
}
