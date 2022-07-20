package br.com.jsfprimefaceshibernate;

import org.junit.Test;

import br.com.dao.GenericDao;
import br.com.model.TelefoneUser;
import br.com.model.UsuarioPessoa;

public class TestHibernate {
	@Test
	public void testeHibernateUtil() {

		GenericDao<UsuarioPessoa> daoGeneric = new GenericDao<UsuarioPessoa>();// Instância o DAO genérico
		UsuarioPessoa pessoa = new UsuarioPessoa(); // Cria o objeto para ser salvo

		// Seta todas as propriedades do objeto
		pessoa.setIdade(999);
		pessoa.setLogin("teste");
		pessoa.setNome("Laricó");
		pessoa.setSenha("123");
		pessoa.setSobreNome("DoBanhado");

		daoGeneric.salvar(pessoa);// Chama o salvar para gravar no banco de dados.

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void gravaTelefone() {
		GenericDao genericDao = new GenericDao();

		UsuarioPessoa pessoa = (UsuarioPessoa) genericDao.pesquisar(17L, UsuarioPessoa.class);

		TelefoneUser telefoneUser = new TelefoneUser();

		telefoneUser.setTipo("Casa");
		telefoneUser.setNumero("999999999");
		telefoneUser.setPessoa(pessoa);

		genericDao.salvar(telefoneUser);

	}

}
