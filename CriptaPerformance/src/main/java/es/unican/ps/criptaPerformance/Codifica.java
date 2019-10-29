/**
 * 
 */
package es.unican.ps.criptaPerformance;

/**
 * @author julio
 *
 */

import jcrypta.Jcripta;

public class Codifica {
	/**
	 * Main para calcular los valores que se van a tomar como base de la libreria cripta para los test
	 * @param args
	 */
	public static void main(String[] args) {
		CodificaPractica pc = new CodificaPractica();
		pc.calculaValores();
		System.out.println("Mejor caso: "+pc.retornaMejorCaso()+" milisegundos.");
		System.out.println("Peor caso: "+pc.retornaPeorCaso()+" milisegundos.");
		System.out.println("Tiempo promedio: "+pc.retornaTiempoPromedio()+" milisegundos.");
		System.out.println("Desviación estandar: "+pc.retornaDesviacionEstandar()+" milisegundos.");
		System.out.println("Percentil 99: "+pc.retornaPercentil99()+" milisegundos.");
	}
	  
}
