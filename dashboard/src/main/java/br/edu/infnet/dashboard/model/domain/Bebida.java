package br.edu.infnet.dashboard.model.domain;

import br.edu.infnet.dashboard.model.exceptions.PesoInvalidoException;
import br.edu.infnet.dashboard.model.exceptions.ValorInvalidoException;

public class Bebida extends Produto {
	
	private String marca;
	private boolean importada;
	private boolean gelada;
	
	public Bebida() {
		// TODO Auto-generated constructor stub
	}

	public Bebida(String descricao, float valor, float peso) throws ValorInvalidoException, PesoInvalidoException {
		super(descricao, valor, peso);
	}

	@Override
	public float calcularValorVenda() {
		
		float valor = this.getValor() 
				        + (this.getPeso() * 0.05f)
						+ (this.importada ? this.getValor()/10 : 0)	
						+ (this.gelada ? this.getValor()/20 : 0);

		return valor;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append(";");
		sb.append(marca);
		sb.append(";");
		sb.append(importada);
		sb.append(";");
		sb.append(gelada);
		sb.append(";");

		return sb.toString();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isImportada() {
		return importada;
	}

	public void setImportada(boolean importada) {
		this.importada = importada;
	}

	public boolean isGelada() {
		return gelada;
	}

	public void setGelada(boolean gelada) {
		this.gelada = gelada;
	}
}