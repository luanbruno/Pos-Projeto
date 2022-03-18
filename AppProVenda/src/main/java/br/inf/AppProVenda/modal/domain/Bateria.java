package br.inf.AppProVenda.modal.domain;

import br.inf.AppProVenda.Exception.AmperagemInvalidoException;

public class Bateria extends Produto{

	private String peso;
	private int amperagem;
	private String tipo;
	
	public Bateria() {
		// TODO Auto-generated constructor stub
	}
	
	public Bateria(String nome, String fabricante, Integer valor) {
		super(nome,fabricante,valor);
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
		
		if (amperagem <= 0) {
			throw new AmperagemInvalidoException("Aperagem não trabalhada!");
		}		
		this.amperagem = amperagem;
	}
	@Override
	public String Aplicacao() {
	
		return "A bateria do fabricante:"+super.getFabricante() +" é de "+ tipo+" volt " ;
	}	
	
}
