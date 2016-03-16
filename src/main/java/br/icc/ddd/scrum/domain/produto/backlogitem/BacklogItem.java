package br.icc.ddd.scrum.domain.produto.backlogitem;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.icc.ddd.scrum.domain.Entidade;
import br.icc.ddd.scrum.domain.produto.Produto;

@Entity
public class BacklogItem extends Entidade {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(max=100, message="O resumo deve possuir no máximo 100 caracteres")
	private String resumo;

	@Size(max=5000, message="A descricao deve possuir no máximo 5000 caracteres")
	private String descricao;

	@NotNull
	@ManyToOne(optional=false)
	private Produto produto;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoBacklogItem tipoBacklogItem;

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusBacklogItem statusBacklogItem;

	@Enumerated(EnumType.STRING)
	private StoryPoints storyPoints;

	public BacklogItem() {
		super();
		this.setStatusBacklogItem(StatusBacklogItem.PLANEJADO_BACKLOG);
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public TipoBacklogItem getTipoBacklogItem() {
		return tipoBacklogItem;
	}

	public void setTipoBacklogItem(TipoBacklogItem tipoBacklogItem) {
		this.tipoBacklogItem = tipoBacklogItem;
	}

	public StatusBacklogItem getStatusBacklogItem() {
		return statusBacklogItem;
	}

	public void setStatusBacklogItem(StatusBacklogItem statusBacklogItem) {
		this.statusBacklogItem = statusBacklogItem;
	}
}
