package br.inf.AppProVenda.modal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.AppProVenda.clients.IUsuarioClient;
import br.inf.AppProVenda.modal.domain.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioClient usuarioClient;
	
	public void incluir(Usuario usuario) {		
		usuarioClient.incluir(usuario);
	}

	public List<Usuario> obterLista() {		
		return usuarioClient.obterLista();
	}

	public void excluir(Integer id) {		
		usuarioClient.excluir(id);		
	}

	public Long obterQtde() {
		return usuarioClient.obterQtde();
	}

	public Usuario validar(String email, String senha) {		
		return usuarioClient.validar(email, senha);
	}
	
	public Usuario obterPorId(Integer id) {
		return usuarioClient.obterPorId(id);
	}
}