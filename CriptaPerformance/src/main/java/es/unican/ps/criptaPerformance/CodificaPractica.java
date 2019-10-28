package es.unican.ps.criptaPerformance;

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
	
	/**
	 * Constructor de la clase CodificaPractica
	 */
	public CodificaPractica() {
		this.mejorCaso=300.0;// Se le establece un valor alto para que se pueda mejorar
		this.peorCaso=0.0;// Se le establece un valor m�nimo por defecto para que se pueda superar
		this.tiempoPromedio=0.0;// Se inician a 0 las variables para usarlas m�s adelante
		this.desviacionEstandar=0.0;
		this.percentil99=0.0;
		this.numIteraciones=1000;// Se va a ejecutar 1000 por defecto para calcular los valores
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
	 * Observadores para devolver todos los valores calculados
	 * @return valor calculado
	 */
	public double retornaMejorCaso() {
		return mejorCaso/100;
	}
	
	public double retornaPeroCaso() {
		return peorCaso/100;
	}
	
	public double retornaTiempoPromedio() {
		return tiempoPromedio/100;
	}
	
	public double retornaDesviacionEstandar() {
		return mejorCaso/100;
	}
	
	public double retornaPercentil99() {
		return percentil99/100;
	}
}
