package br.edu.unifacear.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.bo.PaisBo;
import br.edu.unifacear.classes.Continente;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Pais;

public class Pais_Teste {

	public static void main(String []args) {
		
		Continente continente = new Continente();
		continente.setDescricao("América Latina");
		
		List <Pais> paises = new ArrayList();		
		
		Pais pais = new Pais();
		
		pais.setNome("Brasil");
		pais.setContinente(continente);

		paises.add(pais);

		continente.setPaises(paises);

		PaisBo paisBo = new PaisBo();
		try {
			paisBo.salvar(pais);
			System.out.println("Pais inserido - " + pais);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List <Pais> lista = paisBo.consultar("A");
			for (Pais pais2 : lista) {
				System.out.println(">>>" + pais2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
