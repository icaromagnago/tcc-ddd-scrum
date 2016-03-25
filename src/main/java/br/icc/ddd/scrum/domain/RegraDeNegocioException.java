package br.icc.ddd.scrum.domain;

import java.util.ArrayList;
import java.util.List;


public class RegraDeNegocioException extends Exception {
	private static final long serialVersionUID = 1L;

	private List<String> mensagens;

	public RegraDeNegocioException() {
		this.mensagens = new ArrayList<String>();
	}

	public RegraDeNegocioException(List<String> mensagens) {
		this.mensagens = mensagens;
	}

	public List<String> mensagens() {
		return this.mensagens;
	}
}
