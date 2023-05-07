package br.edu.unifacear.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.bo.TipoUsuarioBo;
import br.edu.unifacear.classes.TipoUsuario;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.classes.TipoUsuario;

public class TipoUsuario_Teste {

	public static void main (String []args) {
		
		Usuario u = new Usuario();
		u.setNome("Amanda");
		u.setEmail("amanda@gmail.com");
		u.setCpf("000.000.000-00");
		u.setLogin("Amanda");
		u.setSenha("Amanda0909");
		
		List <Usuario> usuarios = new ArrayList();
		usuarios.add(u);
		
		TipoUsuario tipoUsuario = new TipoUsuario ();
		
		tipoUsuario.setTipo("teste");
		u.setTipoUsuario(tipoUsuario);
		
		
		
		TipoUsuarioBo tipoUsuarioBo = new TipoUsuarioBo();
		try {
			tipoUsuarioBo.salvar(tipoUsuario);
			System.out.println("TipoUsuario inserido - " + tipoUsuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List <TipoUsuario> lista = tipoUsuarioBo.consultar("A");
			for (TipoUsuario tipoUsuario2 : lista) {
				System.out.println(">>>" + tipoUsuario2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
