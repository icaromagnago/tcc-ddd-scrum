package br.icc.ddd.scrum.domain.produto.backlogitem;

import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.icc.ddd.scrum.domain.Entidade;
import br.icc.ddd.scrum.domain.produto.Produto;

import com.google.common.collect.Sets;

@Entity
public class BacklogItem extends Entidade {

	private static final long serialVersionUID = 4802814869870937580L;

	@NotNull(message="O resumo é obrigatório")
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

	@OneToMany(mappedBy="backlogItem", cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	Set<Tarefa> tarefas = Sets.newHashSet();

	public BacklogItem() {
		super();
	}

	public BacklogItem(String resumo, String descricao, Produto produto,
			TipoBacklogItem tipoBacklogItem,
			StatusBacklogItem statusBacklogItem, StoryPoints storyPoints) {
		super();
		this.resumo = resumo;
		this.descricao = descricao;
		this.produto = produto;
		this.tipoBacklogItem = tipoBacklogItem;
		this.statusBacklogItem = statusBacklogItem;
		this.storyPoints = storyPoints;
	}

	private BacklogItem(String resumo, String descricao,
			TipoBacklogItem tipo, StatusBacklogItem status) {
		this.resumo = resumo;
		this.descricao = descricao;
		this.tipoBacklogItem = tipo;
		this.statusBacklogItem = status;
	}

	public static BacklogItem novoItemDefeito(String resumo,
			String descricao) {
		return new BacklogItem(
				resumo, descricao,
				TipoBacklogItem.DEFEITO,
				StatusBacklogItem.PLANEJADO_BACKLOG);
	}

	public void novaTarefa(String resumo, String descricao, Estimativa estimativa) {
		Tarefa novaTarefa = new Tarefa(
				resumo, descricao,
				StatusTarefa.NAO_INICIADA,
				estimativa, this);

		this.tarefas.add(novaTarefa);
	}

	public void alterarStatusDaTarefa(Long idTarefa,
			StatusTarefa novoStatus) {
		tarefas.forEach(tarefa -> {
			if(tarefa.getId() == idTarefa) {
				tarefa.alterarStatus(novoStatus);
			}
		});

		boolean todasAsTarefasResolvidas = tarefas
				.stream()
				.allMatch(tarefa -> tarefa.getStatus().isResolvida());

		if(todasAsTarefasResolvidas) {
			setStatusBacklogItem(StatusBacklogItem.FEITO);
		}
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

	public Set<Tarefa> getTarefas() {
		return Collections.unmodifiableSet(tarefas);
	}
}
