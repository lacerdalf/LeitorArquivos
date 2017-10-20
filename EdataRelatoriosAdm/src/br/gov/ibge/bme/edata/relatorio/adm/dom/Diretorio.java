package br.gov.ibge.bme.edata.relatorio.adm.dom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author luis.lacerda
 *
 */
public class Diretorio extends Item {

	private static final long serialVersionUID = 4560179406134583006L;

	/**
	 * @param file
	 */
	public Diretorio(File file) {
		super(file);
		lerFilhos(file);
	}

	private List<Item> filhos;

	public List<Item> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<Item> filhos) {
		this.filhos = filhos;
	}
	
	private void lerFilhos(File file) {
		File[] children = file.listFiles();
		filhos = new ArrayList<Item>();

		if (children != null) {
			for (File child : children) {
				if(child != null) {
					Item itemChild = ItemFactory.getInstance().build(child);
					itemChild.setPai(this);
					filhos.add(itemChild);
				}
			}
		}
	}

	@Override
	public boolean isDiretorio() {
		return true;
	}

}
