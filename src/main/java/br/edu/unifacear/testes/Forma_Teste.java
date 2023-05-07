package br.edu.unifacear.testes;

import java.util.List;

import br.edu.unifacear.bo.FormaBo;
import br.edu.unifacear.classes.Forma;
import br.edu.unifacear.classes.Forma;

public class Forma_Teste {
	
	public static void main(String []args) {
		
		Forma forma = new Forma();
		
		forma.setDescricao("Circular");
		
		FormaBo formaBo = new FormaBo();
		try {
			formaBo.salvar(forma);
			System.out.println("Forma inserido - " + forma);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List <Forma> lista = formaBo.consultar("A");
			for (Forma forma2 : lista) {
				System.out.println(">>>" + forma2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
