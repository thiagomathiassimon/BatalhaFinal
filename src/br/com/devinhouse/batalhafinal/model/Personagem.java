package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.interfaces.Atacante;

import java.util.Random;

public abstract class Personagem implements Atacante {

    private int pontosDeSaude;
    private int pontosDeAtaque;
    private int pontosDeDefesa;

    public Personagem(int pontosDeSaude, int pontosDeAtaque, int pontosDeDefesa){
        this.pontosDeSaude = pontosDeSaude;
        this.pontosDeAtaque = pontosDeAtaque;
        this.pontosDeDefesa = pontosDeDefesa;
    }

    public void aumentarPontosDeDefesa(int quantiaDeAumento){
        this.pontosDeSaude += quantiaDeAumento;
    }

    public int lancarDadoDeVinteFaces(){
        return new Random().nextInt(20) + 1;
    }

    @Override
    public abstract void atacar(Personagem persongameAtacado);

    public int getPontosDeSaude() {
        return pontosDeSaude;
    }

    protected void setPontosDeSaude(int pontosDeSaude) {
        this.pontosDeSaude = pontosDeSaude;
    }

    public int getPontosDeAtaque() {
        return pontosDeAtaque;
    }

    public int getPontosDeDefesa() {
        return pontosDeDefesa;
    }

}
