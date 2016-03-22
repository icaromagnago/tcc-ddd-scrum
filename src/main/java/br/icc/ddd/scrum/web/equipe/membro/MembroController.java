package br.icc.ddd.scrum.web.equipe.membro;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.icc.ddd.scrum.application.equipe.MembroService;
import br.icc.ddd.scrum.domain.ValidacaoException;
import br.icc.ddd.scrum.domain.equipe.Equipe;
import br.icc.ddd.scrum.domain.equipe.EquipeRepository;
import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;
import br.icc.ddd.scrum.web.BaseController;

@Named
@ViewScoped
public class MembroController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private MembroService membroService;

	@Inject
	private MembroRepository membroRepository;

	@Inject
	private EquipeRepository equipeRepository;

	private Membro membro;

	@PostConstruct
	public void postConstruct() {
		membro = new Membro();
	}

	public void criar() {
		try {
			this.membroService.novoMembro(membro);
			addInfoMessageToFacesContext("O novo membro foi criado com sucesso", null);
			redirect("/membro/listar.xhtml", null);
		} catch(ValidacaoException e) {
			//Tratar o erro de validação
		}
	}

	public List<Membro> listarTodosOsMembros() {
		return membroRepository.listarTodos();
	}

	public List<Equipe> listarTodasAsEquipes() {
		return equipeRepository.listarTodos();
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

}
