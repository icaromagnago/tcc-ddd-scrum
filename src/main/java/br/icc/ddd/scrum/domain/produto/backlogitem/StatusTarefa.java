package br.icc.ddd.scrum.domain.produto.backlogitem;

public enum StatusTarefa {
	NAO_INICIADA("Não iniciada") {
		@Override
		public boolean isNaoIniciada() {
			return true;
		}
	},

	EM_ANDAMENTO("Em andamento") {
		@Override
		public boolean isEmAndamento() {
			return true;
		}
	},

	SUSPENSA("Suspensa") {
		@Override
		public boolean isSuspensa() {
			return true;
		}
	},

	RESOLVIDA("Resolvida") {
		@Override
		public boolean isResolvida() {
			return true;
		}
	};

	public boolean isNaoIniciada() {
		return false;
	}

	public boolean isEmAndamento() {
		return false;
	}

	public boolean isSuspensa() {
		return false;
	}

	public boolean isResolvida() {
		return false;
	}


	private String descricao;
	private StatusTarefa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
