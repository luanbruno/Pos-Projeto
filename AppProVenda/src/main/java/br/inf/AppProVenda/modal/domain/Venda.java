package br.inf.AppProVenda.modal.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Venda {
	
	private Integer id;
	private LocalDateTime data;
	private int qtd;
	private String tipo;
	private Cliente cliente;
	private List<Produto> produtos;
	private Usuario usuario;
	
	@Override
	public String toString() {
		
		DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		String mensagem = String.format("%d;%s;%d;%s;%s;%d",
				this.id,
				this.data.format(data), 
				this.qtd, 
				this.tipo, 
				this.cliente, 
				this.produtos.size()
			);	
		
		return mensagem;
	}	
	
	public Venda(){
		data = LocalDateTime.now(); 
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


	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
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
