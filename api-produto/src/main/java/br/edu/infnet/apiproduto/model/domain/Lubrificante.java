package br.edu.infnet.apiproduto.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.apiproduto.model.exceptions.MotorInvalidoException;

@Entity
@Table(name = "TLubrificante")
public class Lubrificante extends Produto {

	private String refinamento; 
	private String viscosidade;
	private String motor;
	
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
		ip.append(this.motor);

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
	
	
	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) throws MotorInvalidoException{
		
		if (motor != "DIESEL" && motor != "FLEX") {
			throw new MotorInvalidoException("Oleo de motor não trabalhado");
		}		
		
		this.motor = motor;
	}

	@Override
	public String Aplicacao() {

		return "O oleo do fabricante:"+super.getFabricante()+ " do modelo "+refinamento+ "!";
		
	}
}
