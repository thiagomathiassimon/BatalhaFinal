package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.enums.Arma;

public class Armeiro extends Inimigo{
    private static final int PONTOS_DE_SAUDE_MAXIMOS = 100;
    private static final int PONTOS_DE_ATAQUE = 10;
    private static final int PONTOS_DE_DEFESA = 15;

    public Armeiro() {
        super(PONTOS_DE_SAUDE_MAXIMOS, PONTOS_DE_ATAQUE, PONTOS_DE_DEFESA, Arma.ESPADA);
    }

}
