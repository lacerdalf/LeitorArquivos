package br.gov.ibge.bme.edata.relatorio.adm.dom.service;

import br.gov.ibge.bme.edata.relatorio.adm.dom.Diretorio;
import br.gov.ibge.bme.edata.relatorio.adm.dom.Item;

public interface ArquivoService {

	Item carregarRaiz(String pathRaiz);
	
	void incluir(Diretorio dir);
	
	void remover(Item arquivo);

	void removerDiretorio(Diretorio dir);
}
