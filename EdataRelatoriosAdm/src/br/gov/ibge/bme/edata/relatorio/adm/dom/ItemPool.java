package br.gov.ibge.bme.edata.relatorio.adm.dom;

import java.util.HashMap;
import java.util.Map;

public class ItemPool {

	private static final ItemPool INSTANCE;

	static {
		INSTANCE = new ItemPool();
	}

	public static ItemPool getInstance() {
		return INSTANCE;
	}

	private ItemPool() {
		map = new HashMap<Long, Item>();
	}

	private final Map<Long, Item> map;
	
	public Item get(Long id) {
		return map.get(id);
	}

	public void put(Item item) {
		map.put(item.getId(), item);
	}

}
