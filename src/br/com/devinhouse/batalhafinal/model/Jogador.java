package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.enums.Arma;
import br.com.devinhouse.batalhafinal.enums.Motivacao;
import br.com.devinhouse.batalhafinal.exceptions.IllegalNameFormatException;
import br.com.devinhouse.batalhafinal.exceptions.IllegalSexFormatException;
import br.com.devinhouse.batalhafinal.exceptions.IllegalWeaponSelectionException;
import br.com.devinhouse.batalhafinal.interfaces.Atacante;

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
