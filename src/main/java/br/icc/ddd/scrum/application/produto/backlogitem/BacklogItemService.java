package br.icc.ddd.scrum.application.produto.backlogitem;

import br.icc.ddd.scrum.application.ApplicationService;
import br.icc.ddd.scrum.domain.produto.backlogitem.Estimativa;

public interface BacklogItemService extends ApplicationService {
	void novaTarefa(Long idBacklogItem, String resumo, String descricao, Estimativa estimativa);
}
