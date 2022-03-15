package br.inf.AppProVenda.model.domain.tests;


import java.util.ArrayList;
import java.util.List;

import br.inf.AppProVenda.Exception.AditivoInvalidoException;
import br.inf.AppProVenda.Exception.AmperagemInvalidoException;
import br.inf.AppProVenda.Exception.MotorInvalidoException;
import br.inf.AppProVenda.modal.domain.Aditivo;
import br.inf.AppProVenda.modal.domain.Bateria;
import br.inf.AppProVenda.modal.domain.Cliente;
import br.inf.AppProVenda.modal.domain.Lubrificante;
import br.inf.AppProVenda.modal.domain.Produto;
import br.inf.AppProVenda.modal.domain.Venda;

public class VendaTest {

	public static void main(String[] args) {
				
		List<Produto> produto = new ArrayList<Produto>();

			try {

				Bateria bateria = new Bateria("varejo", "moura", 1);
				bateria.setAmperagem(2);
				bateria.setTipo("carro");
				bateria.setPeso("2kg");
				System.out.println(bateria);
			produto.add(bateria);
			} catch (AmperagemInvalidoException e) {
				System.out.println(e.getMessage());
			}
			try {
				Aditivo aditivo = new Aditivo("atacado", "acdelco", 2);
				aditivo.setComposicao("organico");
				aditivo.setEmbalagem(500);
				aditivo.setModelo("prontouso");
				System.out.println(aditivo);
			produto.add(aditivo);
			} catch (AditivoInvalidoException e) {
				System.out.println(e.getMessage());
			}
			try{
				Lubrificante lubrificante = new Lubrificante("atacado", "petronas", 3);
				lubrificante.setTipo("motor");
				lubrificante.setRefinamento("15w40");
				lubrificante.setViscosidade("mineral");
			produto.add(lubrificante);
			} catch (MotorInvalidoException e) {
				System.out.println(e.getMessage());
			}

		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setCpf("159.574.158.77");
		cliente.setNome("Luan");
		cliente.setEmail("prouto@produto.com.br");

		Venda venda = new Venda();
		venda.setId(1);
		venda.setQtd(2);
		venda.setTipo("atacado");
		venda.setCliente(cliente);
		venda.setProdutos(produto);
		
		
		System.out.println(venda.toString());

		
		

	}
}
