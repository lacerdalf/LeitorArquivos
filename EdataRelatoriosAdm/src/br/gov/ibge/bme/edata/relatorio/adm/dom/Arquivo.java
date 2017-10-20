package br.gov.ibge.bme.edata.relatorio.adm.dom;

import java.io.File;

/**
 * 
 * @author luis.lacerda
 *
 */
public class Arquivo extends Item {

	private static final long serialVersionUID = -1380201614286668302L;


	/**
	 * 
	 * @param file
	 */
	public Arquivo(File file) {
		super(file);
	}


	@Override
	public boolean isDiretorio() {
		return false;
	}

}
