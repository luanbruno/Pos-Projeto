package br.inf.AppProVenda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.inf.AppProVenda.modal.domain.Aditivo;
import br.inf.AppProVenda.modal.domain.Bateria;
import br.inf.AppProVenda.modal.domain.Cliente;
import br.inf.AppProVenda.modal.domain.Lubrificante;
import br.inf.AppProVenda.modal.domain.Produto;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.domain.Venda;
import br.inf.AppProVenda.modal.service.VendaService;

@Component
@Order(4)
public class VendaLoader implements ApplicationRunner {

	@Autowired
	private VendaService vendaService;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		
		Aditivo aditivo = new Aditivo("aditivo raddiador", "acdelco", 2);
		aditivo.setId(1);
		
		Bateria bateria = new Bateria("bateria de moto", "moura", 1);
		bateria.setId(1);
		
		Lubrificante lubrificante = new Lubrificante("oleo de motor", "petronas", 3);
		lubrificante.setId(1);
		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(aditivo);
		produtos.add(bateria);
		produtos.add(lubrificante);
		
		Venda venda = new Venda();
		venda.setMovimento("retirada");;
		venda.setTipo("atacado");
		venda.setCliente(cliente);
		venda.setProdutos(produtos);
		venda.setUsuario(usuario);
				
		vendaService.incluir(venda);
	
	}
}