package br.inf.AppProVenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.inf.AppProVenda.modal.domain.Endereco;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String email = "admin@infnet.edu.br";
		String senha = "123";
		
		Usuario usuario = new Usuario();
		
//			Endereco endereco = new Endereco();
//			endereco.setBairro("bairro admin");
//			endereco.setCep("cep admin");
//			endereco.setComplemento("complemento admin");
//			endereco.setLocalidade("localidade admin");
//			endereco.setLogradouro("logradouro admin");
//			endereco.setUf("UF");
			
			usuario.setEmail(email);
			usuario.setNome("luan b s branco");
			usuario.setSenha(senha);
			usuario.setAdmin(true);
//			usuario.setEndereco(endereco);
			
			usuarioService.incluir(usuario);
		
		
	}
}