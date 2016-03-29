package br.icc.ddd.scrum.domain.produto.backlogitem;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.icc.ddd.scrum.domain.Entidade;

@Entity
public class Tarefa extends Entidade {

	private static final long serialVersionUID = 1L;

	@NotNull(message="O resumo é obrigatório")
	@Size(max=100, message="O resumo deve possuir no máximo 100 caracteres")
	private String resumo;

	@Size(max=5000, message="A descrição deve possuir no máximo 5000 caracteres")
	private String descricao;

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusTarefa status;

	@ManyToOne(optional=false)
	private BacklogItem backlogItem;

	private Long tempoEstimado;

	private Long tempoRestante;

	public Tarefa() {
		super();
	}

	public Tarefa(String resumo, String descricao, StatusTarefa status, BacklogItem backlogItem) {
		super();
		this.resumo = resumo;
		this.descricao = descricao;
		this.status = status;
		this.backlogItem = backlogItem;
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
	public StatusTarefa getStatus() {
		return status;
	}
	public void setStatus(StatusTarefa status) {
		this.status = status;
	}

	public BacklogItem getBacklogItem() {
		return backlogItem;
	}

	public void setBacklogItem(BacklogItem backlogItem) {
		this.backlogItem = backlogItem;
	}
}
