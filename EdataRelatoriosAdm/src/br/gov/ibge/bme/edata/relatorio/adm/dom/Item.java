package br.gov.ibge.bme.edata.relatorio.adm.dom;

import java.io.File;
import java.io.Serializable;

/**
 * 
 * @author luis.lacerda
 *
 */
public abstract class Item implements Serializable {

	private static final long serialVersionUID = -5658719374011783783L;
	
	private static long idCount = 0;

	/**
	 * 
	 * @param file
	 */
	public Item(File file) {
		id = gerarId();
		nome = file.getName();
		path = file.getAbsolutePath();
		root = false;
	}

	private static synchronized long gerarId() {
		return ++idCount;
	}

	private final Long id;
	private String nome;
	private String path;
	private Diretorio pai;
	private boolean root;

	public abstract boolean isDiretorio();

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Diretorio getPai() {
		return pai;
	}

	public void setPai(Diretorio pai) {
		this.pai = pai;
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public boolean hasPai() {
		return pai != null;
	}

	public String toString() {
		return (isDiretorio() ? "dir:" : "f:") + (hasPai() ? getPai().toString() + '/' : "") + getNome();
	}
}
