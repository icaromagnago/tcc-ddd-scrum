package br.icc.ddd.scrum.domain.produto.backlogitem;

import java.io.Serializable;

public class Estimativa implements Serializable {

	private static final long serialVersionUID = 1L;

	private int horasEstimadas;
	private int horasApontadas;

	public Estimativa() {
		super();
	}

	public Estimativa(int horasEstimadas) {
		this.setHorasEstimadas(horasEstimadas);
	}

	public Estimativa(int horasEstimadas, int horasApontadas) {
		this.setHorasEstimadas(horasEstimadas);
		this.setHorasApontadas(horasApontadas);
	}

	public Estimativa apontarHoras(int novoApontamento) {
		return new Estimativa(this.horasEstimadas, novoApontamento);
	}

	public int horasEstimadas() {
		return this.horasEstimadas;
	}

	public int horasApontadas() {
		return this.horasApontadas;
	}

	public int horasRestantes() {
		return this.horasEstimadas - this.horasApontadas;
	}

	private void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	private void setHorasApontadas(int horasApontadas) {
		this.horasApontadas = horasApontadas;
	}
}
