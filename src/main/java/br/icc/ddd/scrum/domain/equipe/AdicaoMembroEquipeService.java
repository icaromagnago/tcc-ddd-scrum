package br.icc.ddd.scrum.domain.equipe;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.Dependent;

@Dependent
public class AdicaoMembroEquipeService {

	/**
	 * Valida se os membros podem ser adicionados a nova equipe
	 * @param membros membros que serão verificados
	 * @param idEquipe id da equipe na qual o membro está sendo adicionado
	 * @return membros que estão em outra equipe
	 */
	public List<Membro> membrosEmOutraEquipe(
			Set<Membro> membros,
			Long idEquipe) {
		List<Membro> membrosEmEquipe = Collections.emptyList();
		if (membros != null && !membros.isEmpty()) {
			membrosEmEquipe = membros
				.stream()
				.filter(membro -> membro.ehMembroDeAlgumaOutraEquipe(idEquipe))
				.collect(Collectors.toList());
		}

		return membrosEmEquipe;
	}
}
