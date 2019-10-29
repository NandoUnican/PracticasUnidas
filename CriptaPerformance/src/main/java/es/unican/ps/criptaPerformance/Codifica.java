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
		System.out.println("Mejor caso: "+pc.retornaMejorCaso()+" segundos.");
		System.out.println("Peor caso: "+pc.retornaPeorCaso()+" segundos.");
		System.out.println("Tiempo promedio: "+pc.retornaTiempoPromedio()+" segundos.");
		System.out.println("Desviación estandar: "+pc.retornaDesviacionEstandar()+" segundos.");
		System.out.println("Percentil 99: "+pc.retornaPercentil99()+" segundos.");
	}
	  
}
