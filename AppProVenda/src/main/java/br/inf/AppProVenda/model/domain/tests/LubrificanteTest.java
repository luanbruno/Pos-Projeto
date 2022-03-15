package br.inf.AppProVenda.model.domain.tests;

import br.inf.AppProVenda.Exception.MotorInvalidoException;
import br.inf.AppProVenda.modal.domain.Lubrificante;

public class LubrificanteTest {


	public static void main(String[] args) {
		try {
		Lubrificante lubrificante = new Lubrificante("atacado", "petronas", 5);
		lubrificante.setTipo("motor");
		lubrificante.setRefinamento("15w40");
		lubrificante.setViscosidade("mineral");
		System.out.println(lubrificante.toString());
		System.out.println(lubrificante.Aplicacao());
		} catch (MotorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			Lubrificante lubrificante = new Lubrificante("varejo", "petronas", 6);
			lubrificante.setTipo("freio");
			lubrificante.setRefinamento("15w40");
			lubrificante.setViscosidade("mineral");
			System.out.println(lubrificante.toString());
			System.out.println(lubrificante.Aplicacao());
			} catch (MotorInvalidoException e) {
				System.out.println(e.getMessage());
			}
	}
		
}
