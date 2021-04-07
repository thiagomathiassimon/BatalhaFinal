package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.enums.Arma;
import br.com.devinhouse.batalhafinal.enums.Motivacao;
import br.com.devinhouse.batalhafinal.exceptions.IllegalNameFormatException;
import br.com.devinhouse.batalhafinal.exceptions.IllegalSexFormatException;
import br.com.devinhouse.batalhafinal.exceptions.IllegalWeaponSelectionException;
import br.com.devinhouse.batalhafinal.interfaces.Atacante;

import java.util.Locale;
import java.util.Random;

public abstract class Jogador extends Personagem implements Atacante {

    private static final int PONTOS_DE_SAUDE_MAXIMOS = 200;

    private String nome;
    private String sexo;
    private Motivacao motivacao;
    private Arma arma;

    public Jogador(int pontosDeAtaque, int pontosDeDefesa, String nome, String sexo, Motivacao motivacao, Arma arma)
            throws IllegalNameFormatException, IllegalSexFormatException, IllegalWeaponSelectionException {
        super(PONTOS_DE_SAUDE_MAXIMOS, pontosDeAtaque, pontosDeDefesa);
        this.nome = this.validarNome(nome);
        this.sexo = this.validarSexo(sexo);
        this.motivacao = motivacao;
        this.arma = this.validarArma(arma);
    }

    private String validarNome(String nome) throws IllegalNameFormatException {
        if (nome.isBlank()){
            throw new IllegalNameFormatException("Formato de nome não suportado.\nFavor inserir um nome válido.");
        }
        return nome;
    }

    private String validarSexo(String sexo) throws IllegalSexFormatException {
        if(sexo.equals("M") || sexo.equals("F")){
            throw new IllegalSexFormatException("Formato de sexo não suportado.\nFavor inserir um sexo válido(M ou F).");
        }
        return sexo;
    }

    protected abstract Arma validarArma(Arma arma) throws IllegalWeaponSelectionException;

    public void restaurarPontosDeSaudeAoMaximo(){
        this.setPontosDeSaude(PONTOS_DE_SAUDE_MAXIMOS);
    }

    @Override
    public void atacar(Personagem personagemAtacado) {
        String mensagemDeAtaque = "Você atacou";
        if (this.arma.name().equalsIgnoreCase(Arma.ESPADA.name())){
            mensagemDeAtaque += " com sua" + Arma.ESPADA.name().toLowerCase();
        } else if (this.arma.name().equalsIgnoreCase(Arma.MACHADO.name())){
            mensagemDeAtaque += " com seu " + Arma.MACHADO.name().toLowerCase();
        } else if (this.arma.name().equalsIgnoreCase(Arma.MARTELO.name())){
            mensagemDeAtaque += " com seu " + Arma.MARTELO.name().toLowerCase();
        } else if (this.arma.name().equalsIgnoreCase(Arma.CLAVA.name())){
            mensagemDeAtaque += " com sua " + Arma.CLAVA.name().toLowerCase();
        } else if (this.arma.name().equalsIgnoreCase(Arma.ARCO.name())){
            mensagemDeAtaque += " com seu " + Arma.ARCO.name().toLowerCase() + ", a flecha atingiu";
        } else if (this.arma.name().equalsIgnoreCase(Arma.BESTA.name())){
            mensagemDeAtaque += " com sua " + Arma.BESTA.name().toLowerCase() + ", o virote atingiu";
        } else if (this.arma.name().equalsIgnoreCase(Arma.CAJADO.name())){
            mensagemDeAtaque += " com seu " + Arma.CAJADO.name().toLowerCase() + ", lançando uma bola de fogo";
        } else if (this.arma.name().equalsIgnoreCase(Arma.LIVRO_DE_MAGIAS.name())){
            mensagemDeAtaque += " absorvendo energia do livro com uma mão e liberando com a outra";
        }
        int valorDoDado = this.lancarDadoDeVinteFaces();
        int ataqueTotal = this.getPontosDeAtaque() + this.arma.getPoderDeAtaque() + valorDoDado;
        int danoCausado;
        if(valorDoDado == 1) {
            danoCausado = 0;
            System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
        } else if (valorDoDado == 20){
            danoCausado = ataqueTotal;
            mensagemDeAtaque += "e causou " + danoCausado + " de dano no inimigo!";
            personagemAtacado.setPontosDeSaude(personagemAtacado.getPontosDeSaude() - danoCausado);
            System.out.println("Você acertou um ataque crítico! " + mensagemDeAtaque);
        } else {
            danoCausado = ataqueTotal - personagemAtacado.getPontosDeDefesa();
            mensagemDeAtaque += "e causou " + danoCausado + " de dano no inimigo!";
            personagemAtacado.setPontosDeSaude(personagemAtacado.getPontosDeSaude() - danoCausado);
            System.out.println(mensagemDeAtaque);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalNameFormatException {
        this.nome = validarNome(nome);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) throws IllegalSexFormatException {
        this.sexo = validarSexo(sexo);
    }

    public Motivacao getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(Motivacao motivacao) {
        this.motivacao = motivacao;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
}
