package br.gov.ibge.bme.edata.relatorio.adm.app.control;

import javax.servlet.ServletContext;

import br.gov.ibge.bme.edata.relatorio.adm.dom.Item;
import br.gov.ibge.bme.edata.relatorio.adm.dom.ItemPool;
import br.gov.ibge.bme.edata.relatorio.adm.dom.service.ArquivoService;
import br.gov.ibge.bme.edata.relatorio.adm.dom.service.ArquivoServiceImpl;
import br.gov.ibge.bme.edata.relatorio.adm.inf.config.ConfiguracaoEdata;

public class RelatorioAdmControlador {

	public final static String ATT_NAME = "RelatorioAdmControlador";

	private ArquivoService arquivoService;
	private Item diretorioAtual;

	public RelatorioAdmControlador() {
		arquivoService = new ArquivoServiceImpl();
	}

	public void carregarRaiz(ServletContext contexto) {
		String path = contexto.getRealPath("").replace(ConfiguracaoEdata.DIR_THIS_APP, ConfiguracaoEdata.DIR_RELATORIOS);
		diretorioAtual = arquivoService.carregarRaiz(path);
	}

	public void carregarItem(Long itemName) {
		diretorioAtual = ItemPool.getInstance().get(itemName);
	}

	public ArquivoService getArquivoService() {
		return arquivoService;
	}

	public void setArquivoService(ArquivoService arquivoService) {
		this.arquivoService = arquivoService;
	}

	public Item getDiretorioAtual() {
		return diretorioAtual;
	}

	public void setDiretorioAtual(Item diretorioAtual) {
		this.diretorioAtual = diretorioAtual;
	}

}
