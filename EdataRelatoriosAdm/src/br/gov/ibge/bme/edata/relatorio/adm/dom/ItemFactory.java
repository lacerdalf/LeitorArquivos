package br.gov.ibge.bme.edata.relatorio.adm.dom;

import java.io.File;

public class ItemFactory {

	private static final ItemFactory INSTANCE;

	private ItemPool pool;

	private ItemFactory() {
		pool = ItemPool.getInstance();
	}

	static {
		INSTANCE = new ItemFactory();
	}

	public static ItemFactory getInstance() {
		return INSTANCE;
	}

	public Item build(File file) {
		Item item;
		if (file.isDirectory()) {
			item = new Diretorio(file);
		} else {
			item = new Arquivo(file);
		}
		pool.put(item);
		return item;
	}

	public Item buildAsRoot(File file) {
		Item item = build(file);
		item.setRoot(true);
		return item;
	}
}
