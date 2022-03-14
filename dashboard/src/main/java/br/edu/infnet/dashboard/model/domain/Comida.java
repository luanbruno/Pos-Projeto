package br.edu.infnet.dashboard.model.domain;

import br.edu.infnet.dashboard.model.exceptions.PesoInvalidoException;
import br.edu.infnet.dashboard.model.exceptions.QuantidadeServidoNegativaException;
import br.edu.infnet.dashboard.model.exceptions.ValorInvalidoException;

public class Comida extends Produto {
	
	private int qtdeServido;
	private boolean regional;
	private String ingredientes;
	
	public Comida() {
		// TODO Auto-generated constructor stub
	}

	public Comida(String descricao, float valor, float peso) throws ValorInvalidoException, PesoInvalidoException {
		super(descricao, valor, peso);
	}

	@Override
	public float calcularValorVenda() {
		
		float valor = this.getValor() 
		        + (this.getPeso() * 0.05f)
				+ (this.regional ? this.getValor()/10 : 0)	
				+ (this.getQtdeServido() * 0.10f);
		
		return valor;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append(";");
		sb.append(qtdeServido);
		sb.append(";");
		sb.append(regional);
		sb.append(";");
		sb.append(ingredientes);
		sb.append(";");

		return sb.toString();
	}

	public int getQtdeServido() {
		return qtdeServido;
	}

	public void setQtdeServido(int qtdeServido) throws QuantidadeServidoNegativaException {
		
		if(qtdeServido < 0) {
			throw new QuantidadeServidoNegativaException("A quantidade de servido está negativa!");
		}
		
		this.qtdeServido = qtdeServido;
	}

	public boolean isRegional() {
		return regional;
	}

	public void setRegional(boolean regional) {
		this.regional = regional;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
}
