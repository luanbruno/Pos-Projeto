package br.inf.AppProVenda.model.domain.tests;

import br.inf.AppProVenda.Exception.AditivoInvalidoException;
import br.inf.AppProVenda.modal.domain.Aditivo;

public class AditivoTest {

	public static void main(String[] args) {
		try {
		Aditivo aditivo = new Aditivo("varejo", "acdelco", 3);
		aditivo.setComposicao("organico");
		aditivo.setEmbalagem(500);
		aditivo.setModelo("prontouso");
		System.out.println(aditivo);
		System.out.println(aditivo.Aplicacao());
		} catch (AditivoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Aditivo aditivo = new Aditivo("atacado", "acdelco", 3);
			aditivo.setComposicao("inorganico");
			aditivo.setEmbalagem(15);
			aditivo.setModelo("concentrado");
			System.out.println(aditivo);
			System.out.println(aditivo.Aplicacao());
			} catch (AditivoInvalidoException e) {
				System.out.println(e.getMessage());
			}
	}
}
