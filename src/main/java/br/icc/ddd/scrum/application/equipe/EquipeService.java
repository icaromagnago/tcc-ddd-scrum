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
	 * @return id da nova equipe criada
	 * @throws RegraDeNegocioException
	 * <ul>
	 * <li>Se o scrum master já for scrum master ou membro de outra equipe</li>
	 * <li>Se algum membro já estiver em outra equipe</li>
	 * </ul>
	 */
	Long novaEquipe(Equipe equipe, Set<Membro> membros) throws RegraDeNegocioException;

	/**
	 * Atualiza uma equipe
	 * @param equipe equipe que será atualizada
	 * @param membros membros da equipe
	 * @throws RegraDeNegocioException
	 * <ul>
	 * <li>Se o scrum master já for scrum master ou membro de outra equipe</li>
	 * <li>Se algum membro já estiver em outra equipe</li>
	 * </ul>
	 */
	void atualizarEquipe(Equipe equipe, Set<Membro> membros) throws RegraDeNegocioException;
}
