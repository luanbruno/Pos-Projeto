package br.edu.infnet.apiusuario.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TVenda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDateTime data;
	private String movimento;	
	private String tipo;
	
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idCliente")
	@JsonIgnore
	private Cliente cliente;

	@ManyToMany(cascade = CascadeType.DETACH)
	@JsonIgnore
	private List<Produto> produtos;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	@JsonIgnore
	private Usuario usuario;

	public Venda() {
		this.data = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		String mensagem = String.format("%d;%s;%s;%s;%s;%d",
				this.id,
				this.data.format(data), 
				this.movimento, 
				this.tipo, 
				this.cliente, 
				this.produtos.size()
			);	
		
		return mensagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	

}