package br.icc.ddd.scrum.application.equipe;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;

@Stateless
public class MembroServiceImpl implements MembroService {

	private static final long serialVersionUID = 1L;

	@Inject
	private MembroRepository membroRepository;

	@Override
	public Long novoMembro(Membro membro) {
		validarEntidade(membro);
		Membro novoMembro = membroRepository.incluir(membro);

		return novoMembro.getId();
	}
}
