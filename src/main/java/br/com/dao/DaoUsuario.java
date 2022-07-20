package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.model.UsuarioPessoa;

public class DaoUsuario<E> extends GenericDao<UsuarioPessoa> {

	public void removerUsuario(UsuarioPessoa pessoa) throws Exception {
		getEntityManager().getTransaction().begin();
		String sqlDeltaFone = "delete from telefoneuser where pessoa_id  = " + pessoa.getId(); 
		getEntityManager().createNativeQuery(sqlDeltaFone).executeUpdate();
		getEntityManager().getTransaction().commit();
		
		super.deletarPorId(pessoa);

	}

	@SuppressWarnings("unchecked")
	public List<UsuarioPessoa> pesquisar(String campoPesquisa) {

		Query query = super.getEntityManager()
				.createQuery("from UsuarioPessoa where nome like '%" + campoPesquisa + "%' ");

		return query.getResultList();
	}
}
