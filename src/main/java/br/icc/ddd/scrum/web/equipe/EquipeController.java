package br.icc.ddd.scrum.web.equipe;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.icc.ddd.scrum.domain.equipe.Equipe;
import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;
import br.icc.ddd.scrum.web.BaseController;

@Named
@ViewScoped
public class EquipeController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private MembroRepository membroRepository;

	private Equipe equipe;

	@PostConstruct
	public void postConstruct() {
		equipe = new Equipe();
	}

	public List<Membro> listarTodosOsMembros() {
		return membroRepository.listarTodos();
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
}
