package br.icc.ddd.scrum.application.equipe;

import java.util.List;

import javax.ejb.Stateless;

import br.icc.ddd.scrum.domain.equipe.Equipe;
import br.icc.ddd.scrum.domain.equipe.Membro;

@Stateless
public class EquipeServiceImpl implements EquipeService {

	private static final long serialVersionUID = 1L;

	@Override
	public Long novaEquipe(Equipe equipe, List<Membro> membros) {
		validarEntidade(equipe);
		return null;

	}

}
