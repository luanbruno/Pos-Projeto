package br.edu.infnet.apipedido.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.apipedido.model.exceptions.MotorInvalidoException;

@Entity
@Table(name = "TLubrificante")
public class Lubrificante extends Produto {

	private String refinamento; 
	private String viscosidade;
	private String tipo;
	
	public Lubrificante() {
	}
		
	public Lubrificante(String nome, String fabricante, Integer validade) {
		super(nome,fabricante,validade);
	}
	
	@Override
	public String toString() {
		StringBuilder ip = new StringBuilder();
		
		ip.append(super.toString());
		ip.append(this.refinamento);
		ip.append(";");
		ip.append(this.viscosidade);
		ip.append(";");
		ip.append(this.tipo);

		return ip.toString();
	}
		
	
	public String getViscosidade() {
		return viscosidade;
	}
	public void setViscosidade(String viscosidade) {
		this.viscosidade = viscosidade;
	}
	public String getRefinamento() {
		return refinamento;
	}
	public void setRefinamento(String refinamento) {
		this.refinamento = refinamento;
	}
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) throws MotorInvalidoException {
		
		if (tipo == "freio") {
			throw new MotorInvalidoException("Aplicação não trabalhada!");
		}
		
		
		this.tipo = tipo;
	}

	@Override
	public String Aplicacao() {

		return "O oleo do fabricante:"+super.getFabricante()+ " aplicao no "+tipo+ "!";
		
	}
}
