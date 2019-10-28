package es.unican.ps.criptaPerformance;

import java.util.ArrayList;

import jcrypta.Jcripta;

public class CodificaPractica {
	// Variables para guardar y posteriormente retornar los valores pedidos en el enunciado de la practica
	private double mejorCaso;
	private double peorCaso;
	private double tiempoPromedio;
	private double desviacionEstandar;
	private double percentil99;
	//Variables necesarias para poder calcular los tiempos de cripta
	String clave;
	String sal;
	String resultado;
	long tiempo_inicial, duracion;
	// Establece por defecto el numero de iteraciones al crear un objeto de la clase
	private int numIteraciones;
	private ArrayList<Double> array = new ArrayList<Double>();// Array para calcular el percentil
	
	/**
	 * Constructor de la clase CodificaPractica
	 */
	public CodificaPractica() {
		this.mejorCaso=300.0;// Se le establece un valor alto para que se pueda mejorar
		this.peorCaso=0.0;// Se le establece un valor mínimo por defecto para que se pueda superar
		this.tiempoPromedio=0.0;// Se inician a 0 las variables para usarlas más adelante
		this.desviacionEstandar=0.0;
		this.percentil99=0.0;
		this.numIteraciones=1000;// Se va a ejecutar 100 por defecto para calcular los valores
	}
	
	/**
	 * Metodo que calcula todos los valores indicados en la practica(mejorCaso, peorCaso y media)
	 */
	public void calculaValores() {
		// Se van a ejecutar todas las iteraciones con los mismos valores
		Jcripta criptaLink = new Jcripta(); 
		clave = new String("Clave");
		sal   = new String("Sal");
		for(int i=0; i < numIteraciones ; i++) { 
			tiempo_inicial = System.currentTimeMillis();
			criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			array.add((double) duracion/100);
			tiempoPromedio+=duracion;//Se van acumulando todas las duraciones para dividirlas despues por el numero de iteraciones
			if(duracion < mejorCaso) {
				mejorCaso = duracion;// Si el tiempo de esta iteracion es menor al del mejor caso se establece como mejor caso
			}else if(duracion > peorCaso) {
				peorCaso = duracion;// Si el tiempo de esta iteracion es mayo al del peor caso se establece como peor caso
			}
		}
		tiempoPromedio=tiempoPromedio/numIteraciones;//Establece el tiempo promedio
	}
	
	
	public void calculaDesviacionEstandar() {
		// Se van a ejecutar todas las iteraciones con los mismos valores
		Jcripta criptaLink = new Jcripta(); 
		clave = new String("Clave");
		sal   = new String("Sal");
		double prom = retornaTiempoPromedio();// Obtiene el tiempo promedio
		for (int i = 0; i < numIteraciones; i++ ) {
			tiempo_inicial = System.currentTimeMillis();
			criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
		    desviacionEstandar += Math.pow ( duracion - prom, 2 );// Acumula la varianza
		}
		desviacionEstandar = Math.sqrt(desviacionEstandar/numIteraciones);// Calcula la desviacion a partir de la varianza acumulada 
	}
	
	/**
	 * Calcula el percentil 99, para ello se usa un array auxiliar para guardar todas las duraciones y se ordenan con un algoritmo de burbuja
	 */
	public void calculaPercentil99() {
		//Se usa un algoritmo tipo burbuja para ordenar los tiempos y así sacar el que se corresponde con el percentil(en este caso el 990)
		for(int i=0; i<=array.size()-2; i++) {
			for(int j=array.size()-1; j>i;j--) {
				if(array.get(j-1) > array.get(j)) {
					double temp = array.get(j-1);
					array.set(j-1, array.get(j));
					array.set(j, temp);
				}
			}
		}
		percentil99 = array.get(990);//El que marca el 99% en este caso es el 990(1000 iteraciones) 
	}
	
	/**
	 * Observadores para devolver todos los valores calculados
	 * @return valor calculado
	 */
	public double retornaMejorCaso() {
		return mejorCaso/100;
	}
	
	public double retornaPeorCaso() {
		return peorCaso/100;
	}
	
	public double retornaTiempoPromedio() {
		return tiempoPromedio/100;
	}
	
	public double retornaDesviacionEstandar() {
		return mejorCaso/100;
	}
	
	public double retornaPercentil99() {
		return percentil99;
	}
}
