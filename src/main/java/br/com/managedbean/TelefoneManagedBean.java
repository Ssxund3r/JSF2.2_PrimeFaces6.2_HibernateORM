package br.com.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.dao.DaoTelefones;
import br.com.dao.DaoUsuario;
import br.com.model.TelefoneUser;
import br.com.model.UsuarioPessoa;

@ManagedBean(name = "telefoneManagedBean")
@ViewScoped
public class TelefoneManagedBean {

	private UsuarioPessoa user = new UsuarioPessoa();
	private DaoUsuario<UsuarioPessoa> daoUser = new DaoUsuario<UsuarioPessoa>();
	private DaoTelefones<TelefoneUser> daoTelefone = new DaoTelefones<TelefoneUser>();
	private TelefoneUser telefoneUser = new TelefoneUser();

	@PostConstruct
	public void init() {
		String coduser = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("codigouser");

		user = daoUser.pesquisar(Long.parseLong(coduser), UsuarioPessoa.class);

	}

	public UsuarioPessoa getUser() {
		return user;
	}

	public void setUser(UsuarioPessoa user) {
		this.user = user;
	}

	public void setDaoTelefone(DaoTelefones<TelefoneUser> daoTelefone) {
		this.daoTelefone = daoTelefone;
	}

	public DaoTelefones<TelefoneUser> getDaoTelefone() {
		return daoTelefone;
	}

	public void setTelefoneUser(TelefoneUser telefoneUser) {
		this.telefoneUser = telefoneUser;
	}

	public TelefoneUser getTelefoneUser() {
		return telefoneUser;
	}

	public String salvar() {
		telefoneUser.setPessoa(user);
		daoTelefone.salvar(telefoneUser);
		telefoneUser = new TelefoneUser();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Salvo com Sucesso!"));
		
		return "";
	}

}
