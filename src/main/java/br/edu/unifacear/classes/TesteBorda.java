package br.edu.unifacear.classes;

import br.edu.unifacear.dao.GenericDao;

public class TesteBorda {

	public static void main(String[] args) {

//		Borda borda  = new Borda();
//		borda.setDescricao("TESTE4");
//		try {
//			new GenericDao<Borda>().salvarOuAtualizar(borda);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	

//		Composicao composicao = new Composicao();
//		composicao.setDescricao("teste");
//		try {
//			new GenericDao<Composicao>().salvarOuAtualizar(composicao);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Distribuicao distibuicao = new Distribuicao();
//		distibuicao.setDescricao("Teste");
//		try {
//			new GenericDao<Distribuicao>().salvarOuAtualizar(distibuicao);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Forma forma = new Forma();
//		forma.setDescricao("Teste");
//		try {
//			new GenericDao<Forma>().salvarOuAtualizar(forma);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Continente continente = new Continente();
//		continente.setDescricao("TesteTeste");
//		try {
//			new GenericDao<Continente>().salvarOuAtualizar(continente);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		continente = new GenericDao<Continente>().findById(Continente.class, 1);
		
//		Pais pais = new Pais();
//		pais.setNome("Teste");
//		pais.setContinente(continente);
//		try {
//			new GenericDao<Pais>().salvarOuAtualizar(pais);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		borda = new GenericDao<Borda>().findById(Borda.class, 1);
//		composicao = new GenericDao<Composicao>().findById(Composicao.class, 1);
//		distibuicao = new GenericDao<Distribuicao>().findById(Distribuicao.class, 1);
//		forma = new GenericDao<Forma>().findById(Forma.class, 1);
//		pais = new GenericDao<Pais>().findById(Pais.class, 1);
//		
	
		Moeda moeda = new Moeda();
//		moeda.setDescricao("teste");
//		moeda.setBorda(borda);
//		moeda.setComposicao(composicao);
//		moeda.setDistribuicao(distibuicao);
//		moeda.setForma(forma);
//		moeda.setPais(pais);
//		try {
//			new GenericDao<EntityBase>().salvarOuAtualizar(moeda);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		TipoUsuario TpUsuario = new TipoUsuario();
//		TpUsuario.setTipo("Colecionador");
//		try {
//			new GenericDao<TipoUsuario>().salvarOuAtualizar(TpUsuario);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		TpUsuario = new GenericDao<TipoUsuario>().findById(TipoUsuario.class, 1);
//		
	
//		Usuario usuario = new Usuario();
//		usuario.setNome("Amanda");
//		usuario.setTipoUsuario(TpUsuario);
//		try {
//			new GenericDao<Usuario>().salvarOuAtualizar(usuario);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		EstadoConservacao estado = new EstadoConservacao();
//		estado.setDescricao("Conservado");
//		try {
//			new GenericDao<EstadoConservacao>().salvarOuAtualizar(estado);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		Usuario usuario0 = new Usuario();
		
//		estado = new GenericDao<EstadoConservacao>().findById(EstadoConservacao.class, 2);
//		usuario = new GenericDao<Usuario>().findById(Usuario.class, 2);
//		usuario0 = new GenericDao<Usuario>().findById(Usuario.class, 1);
//		moeda = new GenericDao<Moeda>().findById(Moeda.class, 1);
		
//		Colecao colecao = new Colecao();
//		colecao.setAno(999);
//		colecao.setEstadoConservacao(estado);
//		colecao.setColecionador(usuario);
//		colecao.setMoeda(moeda);
//		try {
//			new GenericDao<Colecao>().salvarOuAtualizar(colecao);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		colecao = new GenericDao<Colecao>().findById(Colecao.class, 1);
		
//		ItensAVenda itensvenda = new ItensAVenda();
//		venda.setQuantidade(9);
//		venda.setColecao(colecao);
//		venda.setColecionador(usuario);
//		try {
//			new GenericDao<ItensAVenda>().salvarOuAtualizar(venda);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		Venda venda = new Venda();
//		venda.setData(9090);
//		venda.setUsuarioVendedor(usuario);
//		venda.setUsuraioComprador(usuario0);
//		try {
//			new GenericDao<Venda>().salvarOuAtualizar(venda);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		venda = new GenericDao<Venda>().findById(Venda.class, 1);
//		
//		ItensAVenda itensVenda = new ItensAVenda();
//		itensVenda.setQuantidade(9);
//		itensVenda.setVenda(venda);
//		try {
//			new GenericDao<ItensAVenda>().salvarOuAtualizar(itensVenda);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		moeda = new GenericDao<Moeda>().findById(Moeda.class, 1);

		
		Colecao colecao = new Colecao();
		colecao.setAno(888);
		colecao.setMoeda(moeda);
		try {
			new GenericDao<Colecao>().salvarOuAtualizar(colecao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
