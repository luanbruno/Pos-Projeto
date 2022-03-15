package br.inf.AppProVenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setEmail("luan.branco@infnet.edu.br");
		usuario.setNome("luan b s branco");
		usuario.setSenha("12345");
		usuario.setAdmin(true);
		
		usuarioService.incluir(usuario);
		
	}
}