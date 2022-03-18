
package br.inf.AppProVenda.modal.domain;

import br.inf.AppProVenda.Exception.AditivoInvalidoException;

public class Aditivo extends Produto{

	private String composicao;
	private String modelo;
	private int embalagem;
	
	
	public Aditivo(String nome, String fabricante, Integer valor){
		super(nome,fabricante,valor);
	}
	
	@Override
	public String Aplicacao() {
		return "O aditivo do"+super.getFabricante()+" com embalagem de"+embalagem+"!";
	}
		
	@Override
	public String toString() {
		StringBuilder ip = new StringBuilder();
		ip.append(super.toString());
		ip.append(composicao);
		ip.append(";");
		ip.append(modelo);
		ip.append(";");
		ip.append(embalagem);
		
		return ip.toString();
	}

	public Aditivo() {
		// TODO Auto-generated constructor stub
	}
	
	public String getComposicao() {
		return composicao;
	}

	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo)  {
				
		this.modelo = modelo;
	}
	
	public int getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(int embalagem) throws AditivoInvalidoException{
		
		if (embalagem != 500 && embalagem != 1 && embalagem != 20) {
			throw new AditivoInvalidoException("tamanho de embalagm não trabalhado");
		}		
		
		this.embalagem = embalagem;
	}


	
}
