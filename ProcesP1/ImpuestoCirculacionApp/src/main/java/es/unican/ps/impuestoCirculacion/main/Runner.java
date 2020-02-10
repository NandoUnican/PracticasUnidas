package es.unican.ps.impuestoCirculacion.main;

import es.unican.ps.impuestoCirculacion.businessLayer.GestionImpuestoCirculacion;
import es.unican.ps.impuestoCirculacion.daoLayer.ImpuestosDAO;
import es.unican.ps.impuestoCirculacion.presentationLayer.VistaFuncionario;

import es.unican.ps.impuestoCirculacion.daoLayer.IContribuyentesDAO;
import es.unican.ps.impuestoCirculacion.daoLayer.IVehiculosDAO;

public class Runner {

	public static void main(String[] args) {
		ImpuestosDAO datos = new ImpuestosDAO();
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion((IContribuyentesDAO)datos, (IVehiculosDAO)datos);
		VistaFuncionario vista = new VistaFuncionario(negocio, negocio);
		vista.setVisible(true);
	}

}
