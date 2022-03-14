package br.edu.infnet.dashboard.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pedido {

	private Integer id;

	private LocalDateTime data;
	private String descricao;
	private boolean web;

	private Solicitante solicitante;

	private List<Produto> produtos;

	private Usuario usuario;

	public Pedido() {
		this.data = LocalDateTime.now();
		this.descricao = "Pedido padrão";
	}
	
	public Pedido(String descricao, Solicitante solicitante, List<Produto> produtos) {
		this();
		this.setDescricao(descricao);
		this.setSolicitante(solicitante);
		this.setProdutos(produtos);
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		String mensagem = String.format("%d;%s;%s;%s;%s;%d", 
					this.id,
					this.data.format(formato),
					this.descricao,
					this.web,
					this.solicitante,
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isWeb() {
		return web;
	}

	public void setWeb(boolean web) {
		this.web = web;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
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

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}