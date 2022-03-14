package br.edu.infnet.dashboard.model.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.edu.infnet.dashboard.model.exceptions.PesoInvalidoException;
import br.edu.infnet.dashboard.model.exceptions.ValorInvalidoException;

@JsonTypeInfo( 		
		use = JsonTypeInfo.Id.NAME, 		
		include = JsonTypeInfo.As.PROPERTY, 		
		property = "tipo")
@JsonSubTypes({ 	
	@JsonSubTypes.Type(value = Bebida.class, name = "Bebida"), 	
	@JsonSubTypes.Type(value = Comida.class, name = "Comida") 
})
public abstract class Produto {

	private Integer id;
	private String descricao;
	private float valor;
	private float peso;

	private List<Pedido> pedidos;

	private Usuario usuario;
	
	public Produto() {
		
	}
	
	public Produto(String descricao, float valor, float peso) throws ValorInvalidoException, PesoInvalidoException {
		
		if(valor < 0) {
			throw new ValorInvalidoException("Impossível cadastrar o produto: valor negativo!");
		}
		
		if(valor == 0) {
			throw new ValorInvalidoException("Impossível cadastrar o produto: valor zerado!");
		}

		if(peso < 0) {
			throw new PesoInvalidoException("Impossível cadastrar o produto: peso negativo!");
		}
		
		if(peso == 0) {
			throw new PesoInvalidoException("Impossível cadastrar o produto: peso zerado!");
		}

		this.descricao = descricao;
		this.valor = valor;
		this.peso = peso;
	}
	
	public abstract float calcularValorVenda();
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		sb.append(id);
		sb.append(";");
		sb.append(descricao);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(peso);
		sb.append(";");
		sb.append(this.calcularValorVenda());
		
		return sb.toString();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}