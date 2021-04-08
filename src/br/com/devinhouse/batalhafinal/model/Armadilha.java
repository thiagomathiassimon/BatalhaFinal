package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.enums.Arma;
import br.com.devinhouse.batalhafinal.interfaces.Atacante;

import javax.swing.*;
import java.util.Random;

public class Armadilha implements Atacante {

    private int pontosDeAtaque;
    private Arma arma;

    public Armadilha(){
        this.pontosDeAtaque = 5;
        this.arma = Arma.ARMADILHA;
    }

    @Override
    public void atacar(Personagem personagemAtacado) {
        int valorDoDado = this.lancarDadoDeDezFaces();
        int ataqueTotal = this.pontosDeAtaque + this.arma.getPoderDeAtaque() + valorDoDado;
        int danoCausado;
        if (valorDoDado == 1) {
            danoCausado = 0;
            System.out.println("O ataque da armadilha pegou de raspão e você não sofreu dano.");
        } else {
            danoCausado = ataqueTotal - personagemAtacado.getPontosDeDefesa();
            if (danoCausado <= 0) {
                danoCausado = 0;
                System.out.println("O ataque da armadilha não foi suficiente para romper sua defesa e, por isso, você não sofreu nenhum dano.");
            } else {
                personagemAtacado.setPontosDeSaude(personagemAtacado.getPontosDeSaude() - danoCausado);
                System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida.%n", danoCausado, personagemAtacado.getPontosDeSaude());
            }
        }
    }

    private int lancarDadoDeDezFaces(){
        return new Random().nextInt(10) + 1;
    }
}
