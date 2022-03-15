package br.inf.AppProVenda.modal.domain;

import java.util.List;

public class Usuario {

	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private boolean admin;
		private Endereco endereco;	
		private List<Cliente> clientes;
		private List<Produto> produtos;
		private List<Venda> Vendas;
	
	public Usuario() {
	}
	
	@Override
	public String toString() {
		return String.format("Olá, %s (%s) %s", this.nome, this.email, this.admin ? "*" : "");
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Venda> getVendas() {
		return Vendas;
	}

	public void setVendas(List<Venda> vendas) {
		Vendas = vendas;
	}
	
}