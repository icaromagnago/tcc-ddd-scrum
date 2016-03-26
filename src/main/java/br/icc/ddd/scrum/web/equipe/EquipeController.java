package br.icc.ddd.scrum.web.equipe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.omnifaces.cdi.ViewScoped;

import br.icc.ddd.scrum.application.equipe.EquipeService;
import br.icc.ddd.scrum.domain.RegraDeNegocioException;
import br.icc.ddd.scrum.domain.ValidacaoException;
import br.icc.ddd.scrum.domain.equipe.Equipe;
import br.icc.ddd.scrum.domain.equipe.EquipeRepository;
import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;
import br.icc.ddd.scrum.web.BaseController;

import com.google.common.collect.Sets;

@Named
@ViewScoped
public class EquipeController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Inject
	private MembroRepository membroRepository;

	@Inject
	private EquipeRepository equipeRepository;

	@Inject
	private EquipeService equipeService;

	private Equipe equipe;

	private Set<Membro> membrosEquipe;

	private Membro membro;

	@PostConstruct
	public void postConstruct() {
		String id = obterParametroRequisicao("id");
		if(StringUtils.isEmpty(id)) {
			equipe = new Equipe();
			membrosEquipe = new HashSet<Membro>();
		} else {
			equipe = equipeRepository.obter(Long.valueOf(id));
			membrosEquipe = Sets.newHashSet(membroRepository.todosOsMembrosDaEquipe(Long.valueOf(id)));
		}
	}

	public void criar() {
		try {
			this.equipeService.novaEquipe(this.equipe, this.membrosEquipe);
			addInfoMessageToFacesContext("A equipe foi criada com sucesso", null);
			redirect("/equipe/listar.xhtml", null);
		} catch(ValidacaoException e) {
			//Tratar o erro de validação
		} catch(RegraDeNegocioException e) {
			getLog().error(e.getMessage(), e);
			e.mensagens().forEach(mensagem -> addErrorMessageToFacesContext(mensagem, null));
		}
	}

	public void alterar() {
		try {
			this.equipeService.atualizarEquipe(this.equipe, this.membrosEquipe);
			addInfoMessageToFacesContext("A equipe foi atualizada com sucesso", null);
			redirect("/equipe/listar.xhtml", null);
		} catch(ValidacaoException e) {
			//Tratar o erro de validação
		} catch(RegraDeNegocioException e) {
			getLog().error(e.getMessage(), e);
			e.mensagens().forEach(mensagem -> addErrorMessageToFacesContext(mensagem, null));
		}
	}

	public List<Equipe> listarTodasAsEquipes() {
		return equipeRepository.listarTodos();
	}

	public List<Membro> listarTodosOsMembros() {
		return membroRepository.listarTodos();
	}

	public List<Membro> autoCompleteMembrosPorNome(String query) {
		return membroRepository.membrosPorNome(query);
	}

	public void adicionarMembro() {
		this.membrosEquipe.add(membro);
		membro = new Membro();
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Set<Membro> getMembrosEquipe() {
		return membrosEquipe;
	}

	public void setMembrosEquipe(Set<Membro> membrosEquipe) {
		this.membrosEquipe = membrosEquipe;
	}


}
