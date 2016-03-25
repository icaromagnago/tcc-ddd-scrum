package br.icc.ddd.scrum.application.equipe;

import java.util.Set;

import br.icc.ddd.scrum.application.ApplicationService;
import br.icc.ddd.scrum.domain.RegraDeNegocioException;
import br.icc.ddd.scrum.domain.equipe.Equipe;
import br.icc.ddd.scrum.domain.equipe.Membro;

public interface EquipeService extends ApplicationService {

	/**
	 * Cria uma nova equipe
	 * @param equipe equipe que será criada
	 * @param membros membros da equipe
	 * @throws RegraDeNegocioException
	 * <ul>
	 * <li>Se algum membro já estiver em outra equipe</li>
	 * </ul>
	 */
	Long novaEquipe(Equipe equipe, Set<Membro> membros) throws RegraDeNegocioException;
}
