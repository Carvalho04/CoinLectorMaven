package br.edu.unifacear.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.bo.MoedaBo;
import br.edu.unifacear.classes.Borda;
import br.edu.unifacear.classes.Composicao;
import br.edu.unifacear.classes.Distribuicao;
import br.edu.unifacear.classes.Forma;
import br.edu.unifacear.classes.Moeda;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.classes.Moeda;

public class Moeda_Teste {

	public static void main (String []args) {
		
		Forma forma = new Forma();
		forma.setDescricao("Oval");
		
		Distribuicao distribuicao = new Distribuicao();
		distribuicao.setDescricao("Casa da Moeda");
		
		Composicao composicao = new Composicao();
		composicao.setDescricao("Ouro");
		
		Borda borda = new Borda();
		borda.setDescricao("Serrilhada");
		
		Pais pais = new Pais();
		pais.setNome("França");
		
		List<Moeda> moedas = new ArrayList();
		
		
		Moeda moeda = new Moeda();
		
		moeda.setNome("1 real");
		moeda.setDescricao("Moeda brasileira de Um real atual");
		moeda.setCunhagem("3.870.550.000");
		moeda.setPeso(0.7);
		moeda.setEspessura(1.95);
		moeda.setValor_face(1);
		moeda.setAno(1995);
		moeda.setForma(forma);
		moeda.setDistribuicao(distribuicao);
		moeda.setComposicao(composicao);
		moeda.setBorda(borda);
		moeda.setPais(pais);

		moedas.add(moeda);
		pais.setMoedas(moedas);
		borda.setMoedas(moedas);
		composicao.setMoedas(moedas);
		distribuicao.setMoedas(moedas);
		forma.setMoedas(moedas);
		
	MoedaBo moedaBo = new MoedaBo();
	try {
		moedaBo.salvar(moeda);
		System.out.println("Moeda inserido - " + moeda);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	try {
		List <Moeda> lista = moedaBo.consultar("A");
		for (Moeda moeda2 : lista) {
			System.out.println(">>>" + moeda2);
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
}