package br.icc.ddd.scrum.web.produto;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.omnifaces.cdi.ViewScoped;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message="O nome do produto é obrigatório")
	@Size(max=50, message="O nome do produto deve possuir no máximo 50 caracteres")
	private String nomeProduto;

	@Size(max=5, message="A descrição do produto deve possuir no máximo 5 caracteres")
	private String descricaoProduto;

	public void save() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário salvo com sucesso", null));
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}



}
