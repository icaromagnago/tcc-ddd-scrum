package br.icc.ddd.scrum.application.produto.backlogitem;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.icc.ddd.scrum.domain.produto.backlogitem.BacklogItem;
import br.icc.ddd.scrum.domain.produto.backlogitem.BacklogItemRepository;
import br.icc.ddd.scrum.domain.produto.backlogitem.Estimativa;

@Stateless
public class BacklogItemServiceImpl implements BacklogItemService {

	private static final long serialVersionUID = 1L;

	@Inject
	BacklogItemRepository backlogItemRepository;

	@Override
	public void novaTarefa(Long idBacklogItem,
			String resumo, String descricao,
			Estimativa estimativa) {

		BacklogItem backlogItem = backlogItemRepository.obter(idBacklogItem);
		backlogItem.novaTarefa(resumo, descricao, estimativa);

		backlogItemRepository.atualizar(backlogItem);
	}
}
