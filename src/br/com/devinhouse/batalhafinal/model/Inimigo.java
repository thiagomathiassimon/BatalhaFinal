package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.enums.Arma;
import br.com.devinhouse.batalhafinal.interfaces.Atacante;

public abstract class Inimigo extends Personagem implements Atacante {

    private Arma arma;

    public Inimigo(int pontosDeSaude, int pontosDeAtaque, int pontosDeDefesa, Arma arma) {
        super(pontosDeSaude, pontosDeAtaque, pontosDeDefesa);
        this.arma = arma;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
}
