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

    @Override
    public void atacar(Personagem personagemAtacado) {
        int valorDoDado = this.lancarDadoDeVinteFaces();
        int ataqueTotal = this.getPontosDeAtaque() + this.arma.getPoderDeAtaque() + valorDoDado;
        int danoCausado;
        if(valorDoDado == 1) {
            danoCausado = 0;
            System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
        } else if (valorDoDado == 20){
            danoCausado = ataqueTotal;
            personagemAtacado.setPontosDeSaude(personagemAtacado.getPontosDeSaude() - danoCausado);
            System.out.println("O inimigo acertou um ataque crítico! Você sofreu " + danoCausado + " de dano e agora possui" + personagemAtacado.getPontosDeSaude() +
                    "pontos de vida.");
        } else {
            danoCausado = ataqueTotal - personagemAtacado.getPontosDeDefesa();
            personagemAtacado.setPontosDeSaude(personagemAtacado.getPontosDeSaude() - danoCausado);
            System.out.println("O inimigo atacou! Você sofreu " + danoCausado + " de dano e agora possui " + personagemAtacado.getPontosDeSaude() +
                    " pontos de vida.");
        }
    }
}
