package br.inf.AppProVenda.model.domain.tests;

import java.util.ArrayList;
import java.util.List;

import br.inf.AppProVenda.Exception.AditivoInvalidoException;
import br.inf.AppProVenda.Exception.AmperagemInvalidoException;
import br.inf.AppProVenda.Exception.MotorInvalidoException;
import br.inf.AppProVenda.modal.domain.Aditivo;
import br.inf.AppProVenda.modal.domain.Bateria;
import br.inf.AppProVenda.modal.domain.Lubrificante;
import br.inf.AppProVenda.modal.domain.Produto;

public class ProdutoTest {
	
	public static void main(String[] args) {
		
		List<Produto> produto = new ArrayList<Produto>();

		try {
			
		
			Bateria bateria = new Bateria("varejo", "moura", 1);
			bateria.setAmperagem(2);
			bateria.setTipo("carro");
			bateria.setPeso("2kg");
			System.out.println(bateria);
		} catch (AmperagemInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Aditivo aditivo = new Aditivo("atacado", "acdelco", 4);
			aditivo.setComposicao("organico");
			aditivo.setEmbalagem(500);
			aditivo.setModelo("prontouso");
			System.out.println(aditivo);
		} catch (AditivoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try{
			Lubrificante lubrificante = new Lubrificante("varejo", "petronas", 3);
			lubrificante.setTipo("motor");
			lubrificante.setRefinamento("15w40");
			lubrificante.setViscosidade("mineral");
		produto.add(lubrificante);
		} catch (MotorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(produto.toString());
	}

}
