package br.icc.ddd.scrum.domain.produto.backlogitem;

public enum TipoBacklogItem {
	HISTORIA("História") {
        @Override
		public boolean isHistoria() {
            return true;
        }
    },

    MELHORIA("Melhoria") {
        @Override
		public boolean isMelhoria() {
            return true;
        }
    },

    DEFEITO("Defeito") {
        @Override
		public boolean isDefeito() {
            return true;
        }
    };

    public boolean isHistoria() {
    	return false;
    }

    public boolean isMelhoria() {
    	return false;
    }

    public boolean isDefeito() {
        return false;
    }
    private String descricao;

    private TipoBacklogItem(String descricao) {
    	this.descricao = descricao;
    }

    public String getDescricao() {
    	return this.descricao;
    }

}
