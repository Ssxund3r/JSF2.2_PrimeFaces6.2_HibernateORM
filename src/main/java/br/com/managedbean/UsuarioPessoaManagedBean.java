package br.com.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Salvo com Sucesso!"));
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
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Removido com sucesso!"));
		usuarioPessoa = new UsuarioPessoa();
		return "";
	}
	

}
