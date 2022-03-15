package br.inf.AppProVenda.model.domain.tests;

import br.inf.AppProVenda.modal.domain.Cliente;

public class ClienteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setCpf("123.159.357-58");
		cliente.setNome("bento");
		cliente.setEmail("bento@venda.com");
		System.out.println(cliente.toString());
	}

}
