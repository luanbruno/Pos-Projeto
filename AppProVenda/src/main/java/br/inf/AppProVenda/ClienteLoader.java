package br.inf.AppProVenda;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.inf.AppProVenda.modal.domain.Cliente;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.service.ClienteService;

@Component
@Order(2)
public class ClienteLoader implements ApplicationRunner {


	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Cliente cliente = new Cliente();
		cliente.setEmail("luan.branco@gmail.com");
		cliente.setNome("Luan B S branco");
		cliente.setCpf("12345678911");
		cliente.setUsuario(usuario);
		
		clienteService.incluir(cliente);
		
	}
}