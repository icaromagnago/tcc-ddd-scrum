package br.icc.ddd.scrum.domain.equipe;

import java.util.List;

import br.icc.ddd.scrum.domain.Repository;

public interface MembroRepository extends Repository<Membro> {

	List<Membro> todosOsMembrosDaEquipe(Long idEquipe);
	List<Membro> membrosPorNome(String nome);
}
