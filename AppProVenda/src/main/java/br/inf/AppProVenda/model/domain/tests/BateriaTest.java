package br.inf.AppProVenda.model.domain.tests;

import br.inf.AppProVenda.Exception.AmperagemInvalidoException;
import br.inf.AppProVenda.modal.domain.Bateria;

public class BateriaTest {

	public static void main(String[] args) {
		try {
			Bateria bateria = new Bateria("atacado", "moura", 1);
			bateria.setAmperagem(2);
			bateria.setTipo("carro");
			bateria.setPeso("2kg");
			System.out.println(bateria);
			System.out.println(bateria.Aplicacao());
		} catch (AmperagemInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Bateria bateria = new Bateria("atacado", "moura", 2);
			bateria.setAmperagem(4);
			bateria.setTipo("carro");
			bateria.setPeso("2kg");
			System.out.println(bateria);
			System.out.println(bateria.Aplicacao());
		} catch (AmperagemInvalidoException e) {
			System.out.println(e.getMessage());
		}
	
	}
}
