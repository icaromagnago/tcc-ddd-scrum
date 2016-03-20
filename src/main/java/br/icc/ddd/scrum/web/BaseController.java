package br.icc.ddd.scrum.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(BaseController.class);

	private void addMessageToFacesContext(String clientId, Severity severidade, String resumo, String detalhe) {
		FacesMessage facesMessage = new FacesMessage(severidade, resumo, detalhe);
		FacesContext.getCurrentInstance().addMessage(clientId, facesMessage);
	}

	/**
	 * Adiciona mensagem de erro ao contexto do Faces
	 *
	 * @param resumo Resumo da mensagem
	 * @param detalhe A mensagem com mais detalhes
	 */
	protected void addErrorMessageToFacesContext(String resumo, String detalhe) {
		addErrorMessageToFacesContext(null, resumo, detalhe);
	}

	/**
	 * Adiciona mensagem de erro ao contexto do Faces
	 *
	 * @param clientId Id do componente de destino da mensagem
	 * @param resumo Resumo da mensagem
	 * @param detalhe A mensagem com mais detalhes
	 */
	protected void addErrorMessageToFacesContext(String clientId, String resumo, String detalhe) {
		addMessageToFacesContext(clientId, FacesMessage.SEVERITY_ERROR, resumo, detalhe);
	}

	/**
	 * Adiciona mensagem de informação ao contexto do Faces
	 *
	 * @param resumo Resumo da mensagem
	 * @param detalhe A mensagem com mais detalhes
	 */
	protected void addInfoMessageToFacesContext(String resumo, String detalhe) {
		addInfoMessageToFacesContext(null, resumo, detalhe);
	}

	/**
	 * Adiciona mensagem de erro ao contexto do Faces
	 *
	 * @param clientId Id do componente de destino da mensagem
	 * @param resumo Resumo da mensagem
	 * @param detalhe A mensagem com mais detalhes
	 */
	protected void addInfoMessageToFacesContext(String clientId, String resumo, String detalhe) {
		addMessageToFacesContext(clientId, FacesMessage.SEVERITY_INFO, resumo, detalhe);
	}

	/**
	 * Adiciona mensagem de aviso ao contexto do Faces
	 *
	 * @param resumo Resumo da mensagem
	 * @param detalhe A mensagem com mais detalhes
	 */
	protected void addWarnMessageToFacesContext(String resumo, String detalhe) {
		addWarnMessageToFacesContext(null, resumo, detalhe);
	}

	/**
	 * Adiciona mensagem de erro ao contexto do Faces
	 *
	 * @param clientId Id do componente de destino da mensagem
	 * @param resumo Resumo da mensagem
	 * @param detalhe A mensagem com mais detalhes
	 */
	protected void addWarnMessageToFacesContext(String clientId, String resumo, String detalhe) {
		addMessageToFacesContext(clientId, FacesMessage.SEVERITY_WARN, resumo, detalhe);
	}

	/**
	 * Faz o redirecionamento para outra página
	 * @param outcome url da página destino do redirecionamento
	 * @param params parâmetros que serão adicionados a url
	 * @throws IllegalArgumentException caso página não encontrada ou outcome null ou empty
	 */
	protected void redirect(String outcome, Map<String, List<String>> params) {
		try {
			if (outcome == null || outcome.isEmpty()) {
				throw new IllegalArgumentException("'outcome' não pode ser null nem vazio.");
			}
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			String path = externalContext.getRequestContextPath();

			String encodeRedirectURL = externalContext.encodeRedirectURL(path, params);
			externalContext.redirect(encodeRedirectURL);

		} catch (IOException e) {
			String mensagem = "Página não encotrada";
			logger.error(mensagem);
			throw new IllegalArgumentException(mensagem);
		}
	}

	/**
	 * Get Logger.
	 * @return logger
	 */
	protected Logger getLog() {
		return logger;
	}


}
