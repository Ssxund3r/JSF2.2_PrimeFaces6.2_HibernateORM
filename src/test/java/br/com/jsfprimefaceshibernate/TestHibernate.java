package br.com.jsfprimefaceshibernate;

import org.junit.Test;

import br.com.dao.GenericDao;
import br.com.model.UsuarioPessoa;

public class TestHibernate {
	@Test
	public void testeHibernateUtil() {
		
		GenericDao<UsuarioPessoa> daoGeneric =
				new GenericDao<UsuarioPessoa>();// Instância o DAO genérico
		UsuarioPessoa pessoa = new UsuarioPessoa(); // Cria o objeto para ser salvo

		// Seta todas as propriedades do objeto
		pessoa.setIdade(45);
		pessoa.setLogin("teste");
		pessoa.setNome("Paulo");
		pessoa.setSenha("123");
		pessoa.setSobreNome("Egidio");

		daoGeneric.salvar(pessoa);// Chama o salvar para gravar no banco de dados.

	}
}
