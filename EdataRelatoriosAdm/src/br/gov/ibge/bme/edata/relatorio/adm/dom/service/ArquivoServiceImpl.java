package br.gov.ibge.bme.edata.relatorio.adm.dom.service;

import java.io.File;

import br.gov.ibge.bme.edata.relatorio.adm.dom.Diretorio;
import br.gov.ibge.bme.edata.relatorio.adm.dom.Item;
import br.gov.ibge.bme.edata.relatorio.adm.dom.ItemFactory;

public class ArquivoServiceImpl implements ArquivoService {

	@Override
	public Item carregarRaiz(String pathRaiz) {
		File file = new File(pathRaiz);
		return ItemFactory.getInstance().buildAsRoot(file);
	}

	@Override
	public void incluir(Diretorio dir) {
		File file = getAsFile(dir);
		file.mkdir();
	}

	@Override
	public void remover(Item arquivo) {
		File file = getAsFile(arquivo);
		file.delete();
	}

	@Override
	public void removerDiretorio(Diretorio arquivo) {
		File file = getAsFile(arquivo);
		deleteTree(file);
		file.delete();
	}

	public static void deleteTree(File inFile) {
		if (inFile.isFile()) {
			inFile.delete();
		} else {
			File files[] = inFile.listFiles();
			for (File file : files) {
				deleteTree(file);
			}
		}
	}

	private File getAsFile(Item arquivo) {
		return new File(arquivo.getPath());
	}

}
