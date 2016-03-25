package br.icc.ddd.scrum.application.equipe;

import java.util.ArrayList;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.icc.ddd.scrum.domain.RegraDeNegocioException;
import br.icc.ddd.scrum.domain.equipe.AdicaoMembroEquipeService;
import br.icc.ddd.scrum.domain.equipe.Equipe;
import br.icc.ddd.scrum.domain.equipe.EquipeRepository;
import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;

@Stateless
public class EquipeServiceImpl implements EquipeService {

	private static final long serialVersionUID = 1L;

	@Inject
	private AdicaoMembroEquipeService adicaoMembroEquipeService;

	@Inject
	private EquipeRepository equipeRepository;

	@Inject
	private MembroRepository membroRepository;

	/**
	 * {@inheritDoc}
	 * @throws RegraDeNegocioException
	 */
	@Override
	public Long novaEquipe(Equipe equipe, Set<Membro> membros) throws RegraDeNegocioException {
		validarEntidade(equipe);
		adicaoMembroEquipeService.membrosEmOutraEquipe(membros, equipe.getId());

		Equipe equipeCriada = equipeRepository.incluir(equipe);
		membros.forEach(membro -> membro.vincularAEquipe(equipeCriada));
		membroRepository.incluir(new ArrayList<Membro>(membros));

		return equipeCriada.getId();
	}
}
