import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ps.criptaPerformance.CodificaPractica;

public class CryptaPerformanceTest {
	
	public static CodificaPractica cp = new CodificaPractica();
	double acumuladoVariaciones=0.0;// Variable para dejar guardada la variación acumulada
	
	// Estos son los valores que han dado la cla
	// Mejor caso: 38 ms.
	// Peor caso: 367 ms.
	// Tiempo promedio: 91.57899999999999 ms.
	// Desviación estandar: 20.752 ms.
	// Percentil 99: 174 ms.
	
	/**
	 * Llama al metodo que calcula los valores antes de iniciar los test
	 */
	@BeforeClass
	public static void init(){
		cp.calculaValores();
	}
	
	/**
	 * Comprueba que el mejor caso no se desvía más del 10% respecto del valor tomado como muestra
	 */
	@Test
	public void testMejorCasoCorrecto(){
		double mc = cp.retornaMejorCaso();
		assertEquals(38.0,mc,3.8);
		acumuladoVariaciones+=(Math.abs(38.0-mc)/38.0*100);
	}
	
	/**
	 * Comprueba que el peor caso no se desvía más del 10% respecto del valor tomado como muestra
	 */
	@Test
	public void testPeorCasoCorrecto(){
		double pc = cp.retornaPeorCaso();
		assertEquals(367.0,pc,36.7);
		acumuladoVariaciones+=(Math.abs(367.0-pc)/367.0*100);
	}
	
	/**
	 * Comprueba que el tiempo promedio no se desvía más del 10% respecto del valor tomado como muestra
	 */
	@Test
	public void testTiempoPromedioCorrecto(){
		double tp = cp.retornaTiempoPromedio();
		assertEquals(91.5789,tp,9.15789);
		acumuladoVariaciones+=(Math.abs(91.5789-tp)/91.5789*100);
	}
	
	/**
	 * Comprueba que la desviacion estandar no se desvía más del 10% respecto del valor tomado como muestra
	 */
	@Test
	public void testDesviacionEstandarCorrecto(){
		double de = cp.retornaDesviacionEstandar();
		assertEquals(20.752,de, 2.0752);
		acumuladoVariaciones+=(Math.abs(20.752-de)/20.752*100);
	}
	
	/**
	 * Comprueba que el percentil 99 no se desvía más del 10% respecto del valor tomado como muestra
	 */
	@Test
	public void testPercentil99Correcto(){
		double p99 = cp.retornaPercentil99();
		assertEquals(174.0,p99,17.4);
		acumuladoVariaciones+=(Math.abs(174.0-p99)/174.0*100);
	}
	
	/**
	 * Comprueba que el porcentaje de la desviación acumulada no es superior al 50%
	 */
	@Test
	public void testAcumuladoCorrecto(){
		assertEquals(0.0,acumuladoVariaciones,25.0);
	}
}
