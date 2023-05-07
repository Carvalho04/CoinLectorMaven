package br.edu.unifacear.testes;

import java.util.List;

import br.edu.unifacear.bo.VendaBo;
import br.edu.unifacear.classes.Venda;
import br.edu.unifacear.classes.Venda;

public class Venda_Teste {

	
	public static void main (String []args) {
		
	Venda venda = new Venda();
			
			VendaBo vendaBo = new VendaBo();
			try {
				vendaBo.salvar(venda);
				System.out.println("Venda inserido - " + venda);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				List <Venda> lista = vendaBo.consultar("A");
				for (Venda venda2 : lista) {
					System.out.println(">>>" + venda2);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
