package br.com.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.GenericDao;
import br.com.model.UsuarioPessoa;

@ManagedBean(name = "usuarioPessoaManagedBean")
@ViewScoped
public class UsuarioPessoaManagedBean {

	private UsuarioPessoa usuarioPessoa = new UsuarioPessoa();

	private GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

	private List<UsuarioPessoa> list = new ArrayList<UsuarioPessoa>();

	public UsuarioPessoa getUsuarioPessoa() {
		return usuarioPessoa;
	}

	public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}

	public String salvar() {
		genericDao.salvar(usuarioPessoa);

		return "";
	}

	public String novo() {
		usuarioPessoa = new UsuarioPessoa();
		return "";
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioPessoa> getList() {
		list = genericDao.listar(UsuarioPessoa.class);
		return list;
	}
	
	public String remover() throws Exception {
		genericDao.deletarPorId(usuarioPessoa);
		usuarioPessoa = new UsuarioPessoa();
		return "";
	}
	

}
