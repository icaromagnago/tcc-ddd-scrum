package br.icc.ddd.scrum.application.equipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.icc.ddd.scrum.domain.RegraDeNegocioException;
import br.icc.ddd.scrum.domain.equipe.AdicaoMembroEquipeService;
import br.icc.ddd.scrum.domain.equipe.Equipe;
import br.icc.ddd.scrum.domain.equipe.EquipeRepository;
import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;

import com.google.common.collect.Lists;

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
	 *
	 * @throws RegraDeNegocioException
	 */
	@Override
	public Long novaEquipe(Equipe equipe, Set<Membro> membros)
			throws RegraDeNegocioException {
		validarEntidade(equipe);

		List<String> regrasVioladas = validarRegrasDeNegocio(equipe, membros);
		if(!regrasVioladas.isEmpty()) {
			throw new RegraDeNegocioException(regrasVioladas);
		}

		Equipe equipeCriada = equipeRepository.incluir(equipe);
		membros.forEach(membro -> membro.vincularAEquipe(equipeCriada));
		membroRepository.incluir(Lists.newArrayList(membros));


		return equipeCriada.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void atualizarEquipe(Equipe equipe, Set<Membro> membros)
			throws RegraDeNegocioException {
		validarEntidade(equipe);

		List<String> regrasVioladas = validarRegrasDeNegocio(equipe, membros);
		if(!regrasVioladas.isEmpty()) {
			throw new RegraDeNegocioException(regrasVioladas);
		}

		equipeRepository.atualizar(equipe);
		membros.forEach(membro -> membro.vincularAEquipe(equipe));
		membroRepository.atualizar(Lists.newArrayList(membros));
	}

	private List<String> validarRegrasDeNegocio(Equipe equipe, Set<Membro> membros) {
		List<String> regrasVioladas = new ArrayList<String>();

		Membro scrumMaster = equipe.getScrumMaster();
		if (scrumMaster != null
				&& scrumMaster.ehMembroDeAlgumaOutraEquipe(equipe.getId())) {

			regrasVioladas.add(String.format(
					"%s já é membro ou scrum master em outro produto",
					scrumMaster.getNome()));
		}

		List<Membro> membrosEmOutraEquipe = adicaoMembroEquipeService
				.membrosEmOutraEquipe(membros, equipe.getId());

		if (!membrosEmOutraEquipe.isEmpty()) {
			membrosEmOutraEquipe.forEach(membro -> regrasVioladas.add(String.format(
					"%s já é membro de outra equipe", membro.getNome())));
		}

		return regrasVioladas;
	}
}
