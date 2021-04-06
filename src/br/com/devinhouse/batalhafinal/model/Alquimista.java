package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.enums.Arma;

public class Alquimista extends Inimigo{
    private static final int PONTOS_DE_SAUDE_MAXIMOS = 100;
    private static final int PONTOS_DE_ATAQUE = 15;
    private static final int PONTOS_DE_DEFESA = 10;

    public Alquimista() {
        super(PONTOS_DE_SAUDE_MAXIMOS, PONTOS_DE_ATAQUE, PONTOS_DE_DEFESA, Arma.CAJADO);
    }

    @Override
    public void atacar(Personagem personagemAtacado) {

    }
}
