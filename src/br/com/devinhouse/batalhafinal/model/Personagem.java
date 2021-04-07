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

    public void aumentarPontosDeDefesa(int quantiaDeAumento){
        this.pontosDeSaude += quantiaDeAumento;
    }

    public int getPontosDeSaude() {
        return pontosDeSaude;
    }

    public void setPontosDeSaude(int pontosDeSaude) {
        this.pontosDeSaude = pontosDeSaude;
    }

    public int getPontosDeAtaque() {
        return pontosDeAtaque;
    }

    public int getPontosDeDefesa() {
        return pontosDeDefesa;
    }

}
