package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.enums.Arma;
import br.com.devinhouse.batalhafinal.interfaces.Atacante;

public class Armadilha implements Atacante {

    private int pontosDeAtaque;
    private Arma arma;

    public Armadilha(){
        this.pontosDeAtaque = 5;
        this.arma = Arma.ARMADILHA;
    }

    @Override
    public void atacar(Personagem persongameAtacado) {

    }
}
