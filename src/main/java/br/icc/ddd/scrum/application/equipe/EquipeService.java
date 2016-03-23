package br.icc.ddd.scrum.application.equipe;

import java.util.List;

import br.icc.ddd.scrum.application.ApplicationService;
import br.icc.ddd.scrum.domain.equipe.Equipe;
import br.icc.ddd.scrum.domain.equipe.Membro;

public interface EquipeService extends ApplicationService {
	Long novaEquipe(Equipe equipe, List<Membro> membros);
}
