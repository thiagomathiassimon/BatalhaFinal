package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.enums.Arma;

public class Lider extends Inimigo {
    private static final int PONTOS_DE_SAUDE_MAXIMOS = 200;
    private static final int PONTOS_DE_ATAQUE = 15;
    private static final int PONTOS_DE_DEFESA = 15;

    public Lider() {
        super(PONTOS_DE_SAUDE_MAXIMOS, PONTOS_DE_ATAQUE, PONTOS_DE_DEFESA, Arma.MACHADO_DUPLO);
    }

}
