package br.com.devinhouse.batalhafinal.model;

public abstract class Personagem {

    private int pontosDeSaude;
    private int pontosDeAtaque;
    private int pontosDeDefesa;

    public Personagem(int pontosDeSaude, int pontosDeAtaque, int pontosDeDefesa){
        this.pontosDeSaude = pontosDeSaude;
        this.pontosDeAtaque = pontosDeAtaque;
        this.pontosDeDefesa = pontosDeDefesa;
    }

}
