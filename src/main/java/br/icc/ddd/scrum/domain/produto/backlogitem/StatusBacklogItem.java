package br.icc.ddd.scrum.domain.produto.backlogitem;

public enum StatusBacklogItem {

	PLANEJADO_BACKLOG("Em Backlog") {
		@Override
		public boolean estaPlanejadoBacklog() {
			return true;
		}
	},
	PLANEJADO_SPRINT("Em Sprint") {
		@Override
		public boolean estaPlanejadoSprint() {
			return true;
		}
	},
	FEITO("Feito") {
		@Override
		public boolean estaFeito() {
			return true;
		}
	},
	CANCELADO("Cancelado") {
		@Override
		public boolean estaCancelado() {
			return true;
		}
	};

	public boolean estaPlanejadoBacklog() {
		return false;
	}

	public boolean estaPlanejadoSprint() {
		return false;
	}

	public boolean estaFeito() {
		return true;
	}

	public boolean estaCancelado() {
		return true;
	}

	private String descricao;

	private StatusBacklogItem(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}


}
