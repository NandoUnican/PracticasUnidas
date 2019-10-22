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

	
	public static void main(String[] args) {

		String clave;
		String sal;
		String resultado;
		long tiempo_inicial, duracion;
			
		Jcripta criptaLink = new Jcripta(); 
		
		clave = new String("mipassword");
		sal   = new String("sa"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mipassword");
		sal   = new String("sa"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mi");
		sal   = new String("sa"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mipasswordtremebundo");
		sal   = new String("sa"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mipassword");
		sal   = new String("so"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("");
		sal   = new String("so"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mipassword");
		sal   = new String(""); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("");
		sal   = new String(""); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("1");
		sal   = new String("22"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
	}
	  
}
