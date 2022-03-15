package br.inf.AppProVenda.model.domain.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.inf.AppProVenda.Exception.AditivoInvalidoException;
import br.inf.AppProVenda.Exception.AmperagemInvalidoException;
import br.inf.AppProVenda.Exception.MotorInvalidoException;
import br.inf.AppProVenda.modal.domain.Aditivo;
import br.inf.AppProVenda.modal.domain.Bateria;
import br.inf.AppProVenda.modal.domain.Cliente;
import br.inf.AppProVenda.modal.domain.Lubrificante;
import br.inf.AppProVenda.modal.domain.Produto;
import br.inf.AppProVenda.modal.domain.Venda;

public class ArquivoTeste {
	public static void main(String[] args) {

		try {
			String dir = "C:/Users/luank/Desktop/POS-infnet/Nova pasta/AppProVenda/";
			String arq = "arquivo.txt";

			try {
				FileReader fileR = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileR);

				FileWriter fileW = new FileWriter(dir + "out_" + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);

				Venda venda = new Venda();
				List<Produto> produtos = new ArrayList<Produto>();

				
				String linha = leitura.readLine();

				String[] campos = null;

				while (linha != null) {
					campos = linha.split(";");

					switch (campos[0]) {
					case "A":
						try {
							Aditivo aditivo = new Aditivo("atacado", "acdelco", 1);
							aditivo.setComposicao(campos[1]);
							aditivo.setEmbalagem(Integer.valueOf(campos[2]));
							aditivo.setModelo(campos[3]);
							produtos.add(aditivo);
						} catch (AditivoInvalidoException e) {
							System.out.println(e.getMessage());

						}
						break;
						
					case "B":						
						try {
							Bateria bateria = new Bateria("atacado", "moura", 2);
							bateria.setAmperagem(Integer.valueOf(campos[1]));
							bateria.setTipo(campos[2]);
							bateria.setPeso(campos[3]);
							produtos.add(bateria);
						} catch (AmperagemInvalidoException e) {
							System.out.println(e.getMessage());
						}
						
						break;

					case "L":
						try {
							Lubrificante lubrificante = new Lubrificante("varejo", "petronas", 2);
							lubrificante.setTipo(campos[1]);
							lubrificante.setRefinamento(campos[2]);
							lubrificante.setViscosidade(campos[3]);
							produtos.add(lubrificante);
						} catch (MotorInvalidoException e) {
							System.out.println(e.getMessage());
						}

						break;

					case "C":
						Cliente cliente = new Cliente();
						cliente.setId(1);
						cliente.setNome(campos[3]);
						cliente.setCpf(campos[4]);
						cliente.setEmail(campos[5]);

						venda.setId(1);
						venda.setTipo(campos[1]);
						venda.setQtd(Integer.valueOf(campos[2]));
						venda.setCliente(cliente);
						break;

					default:
						System.out.println("Tipo do produto inválido!");
						break;
					}

					linha = leitura.readLine();

				}

				venda.setProdutos(produtos);		


				for (Produto produto : venda.getProdutos()) {
					escrita.write(venda.getTipo());
					escrita.write(";");
					escrita.write(venda.getCliente().getNome());
					escrita.write(";");
					escrita.write(produto.Aplicacao());
					escrita.write("\r\n"); 
				}

				fileR.close();
				leitura.close();
				escrita.close();
				fileW.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Processamento realizado!");
		}

	}
}
