package br.icc.ddd.scrum.application.equipe;

import br.icc.ddd.scrum.application.ApplicationService;
import br.icc.ddd.scrum.domain.equipe.Membro;

public interface MembroService extends ApplicationService {

	Long novoMembro(Membro membro);

	void atualizarMembro(Membro membro);
}
