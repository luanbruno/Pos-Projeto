package br.inf.AppProVenda.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.inf.AppProVenda.modal.domain.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")

public interface IEnderecoClient {
	
	@GetMapping(value = "/{cep}/json")
	public Endereco buscarCep(@PathVariable String cep);
}
