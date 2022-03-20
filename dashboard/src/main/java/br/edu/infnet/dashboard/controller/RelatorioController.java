package br.edu.infnet.dashboard.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Log;
import br.edu.infnet.dashboard.model.domain.Produto;
import br.edu.infnet.dashboard.model.domain.Venda;
import br.edu.infnet.dashboard.model.service.LogService;
import br.edu.infnet.dashboard.model.service.VendaService;

@Controller
public class RelatorioController {
	
	@Autowired
	private VendaService vendaService;
	@Autowired
	private LogService logService;

	@GetMapping(value = "/generate")
	public String emissaoRelatorio(Model model) {
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet abaProdutos = workbook.createSheet("Produtos");
				
		String[] columns = {"Data", "Movimento da venda", "Tipo da venda", 
							"Nome do cliente", "E-mail do cliente", "CPF do clinte", "UF cliente",
							"fabricante do produto", "Valor do produto"};

		Row headerRow = abaProdutos.createRow(0);
		
		for(int i = 0; i < columns.length; i++) {
			headerRow.createCell(i).setCellValue(columns[i]);
		}
		
		List<Venda> vendas = vendaService.obterLista();
		
		int rowNum = 0;
		
		for(Venda venda : vendas) {
			
			for(Produto produto : venda.getProdutos()) {
				Row row = abaProdutos.createRow(++rowNum);
				
				row.createCell(0).setCellValue(
						venda.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
					);
				row.createCell(1).setCellValue(venda.getMovimento());
				row.createCell(2).setCellValue(venda.getTipo());
				row.createCell(3).setCellValue(venda.getCliente().getNome());
				row.createCell(4).setCellValue(venda.getCliente().getEmail());
				row.createCell(5).setCellValue(venda.getCliente().getCpf());
				row.createCell(6).setCellValue(
						venda.getCliente().getEndereco() != null ? 
								venda.getCliente().getEndereco().getUf() : ""
							);
				row.createCell(7).setCellValue(produto.getFabricante());
				row.createCell(8).setCellValue(produto.getValor());
			}
		}
		
		LocalDateTime hoje = LocalDateTime.now(); 
		
		String arquivo = "produtos"+hoje.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".xlsx";		

		String mensagem = null;
		try {
			workbook.write(new FileOutputStream(arquivo));

			workbook.close();

			mensagem = "A planilha gerada está disponível no diretório padrão!!!"; 
			
		} catch (IOException e) {
			mensagem = "Problemas na geração da planilha!!!";
			
			e.printStackTrace();
		}
		
		Log log = new Log();
		log.setData(hoje);
		log.setNome(mensagem);
		
		logService.incluir(log);
		
		return "redirect:/";
	}
}
