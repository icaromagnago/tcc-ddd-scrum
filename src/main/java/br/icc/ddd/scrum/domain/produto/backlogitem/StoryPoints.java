package br.icc.ddd.scrum.domain.produto.backlogitem;

public enum StoryPoints {
	ZERO {
		@Override
		public int valor() {
            return 0;
        }
    },

    UM {
        @Override
		public int valor() {
            return 1;
        }
    },

    DOIS {
        @Override
		public int valor() {
            return 2;
        }
    },

    TRES {
        @Override
		public int valor() {
            return 3;
        }
    },

    CINCO {
        @Override
		public int valor() {
            return 5;
        }
    },

    OITO {
        @Override
		public int valor() {
            return 8;
        }
    },

    TREZE {
        @Override
		public int valor() {
            return 13;
        }
    },

    VINTE {
        @Override
		public int valor() {
            return 20;
        }
    },

    QUARENTA {
        @Override
		public int valor() {
            return 40;
        }
    },

    CEM {
        @Override
		public int valor() {
            return 100;
        }
    };

    public abstract int valor();
}
