package br.edu.infnet.apipedido.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo( 		
		use = JsonTypeInfo.Id.NAME, 		
		include = JsonTypeInfo.As.PROPERTY, 		
		property = "tipo")
@JsonSubTypes({ 	
	@JsonSubTypes.Type(value = Aditivo.class, name = "Aditivo"), 	
	@JsonSubTypes.Type(value = Lubrificante.class, name = "Lubrificante"), 
	@JsonSubTypes.Type(value = Bateria.class, name = "Bateria") 
})
public abstract class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String fabricante;
	private int validade;

	@ManyToMany(mappedBy = "produtos")
	@JsonIgnore
	private List<Venda> vendas;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	@JsonIgnore
	private Usuario usuario;
	
	public Produto() {
		
	}
	
	public Produto(String nome, String fabricante, Integer validade) {
		this.nome = nome;
		this.fabricante = fabricante;
		this.validade = validade;
	}
	
	
	public abstract String Aplicacao();
	
	@Override
	public String toString() {
		
		StringBuilder ip = new StringBuilder();
		
		ip.append(id);
		ip.append(';');
		ip.append(nome);
		ip.append(';');
		ip.append(fabricante);
		ip.append(';');
		ip.append(validade);
		ip.append(";");
		ip.append(this.Aplicacao());
		
		return ip.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getValidade() {
		return validade;
	}

	public void setValidade(int validade) {
		this.validade = validade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	

}