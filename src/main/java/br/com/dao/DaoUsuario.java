package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.model.UsuarioPessoa;

public class DaoUsuario<E> extends GenericDao<UsuarioPessoa> {
	public void removerUsario(UsuarioPessoa pessoa) throws Exception {
		getEntityManager().getTransaction().begin();

		getEntityManager().remove(pessoa);

		getEntityManager().getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<UsuarioPessoa> pesquisar(String campoPesquisa) {

		Query query = super.getEntityManager()
				.createQuery("from UsuarioPessoa where nome like '%" + campoPesquisa + "%' ");

		return query.getResultList();
	}
}
