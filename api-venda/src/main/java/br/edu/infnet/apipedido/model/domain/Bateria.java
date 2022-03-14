package br.edu.infnet.apipedido.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.apipedido.model.exceptions.AmperagemInvalidoException;

@Entity
@Table(name = "TBateria")
public class Bateria extends Produto{

	private String peso;
	private int amperagem;
	private String tipo;
	
	public Bateria() {
		// TODO Auto-generated constructor stub
	}
	
	public Bateria(String nome, String fabricante, Integer validade) {
		super(nome,fabricante,validade);
	}
	
	@Override
	public String toString() {
		StringBuilder ip = new StringBuilder();
		ip.append(super.toString());
		ip.append(peso);
		ip.append(";");
		ip.append(amperagem);
		ip.append(";");
		ip.append(tipo);
		ip.append(";");
		
		return ip.toString();
	}
	
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getAmperagem() {
		return amperagem;
	}
	public void setAmperagem(int amperagem) throws AmperagemInvalidoException {
		
		if (amperagem <= 3) {
			throw new AmperagemInvalidoException("Aperagem não trabalhada!");
		}		
		this.amperagem = amperagem;
	}
	@Override
	public String Aplicacao() {
	
		return "A bateria de fabricante:"+super.getFabricante() +" é para "+ tipo;
	}	
	
}
