package br.com.devinhouse.batalhafinal.model;

import br.com.devinhouse.batalhafinal.enums.Arma;
import br.com.devinhouse.batalhafinal.enums.Motivacao;
import br.com.devinhouse.batalhafinal.exceptions.IllegalNameFormatException;
import br.com.devinhouse.batalhafinal.exceptions.IllegalSexFormatException;
import br.com.devinhouse.batalhafinal.exceptions.IllegalWeaponSelectionException;

public class Guerreiro extends Jogador {
    private static final int PONTOS_DE_ATAQUE = 15;
    private static final int PONTOS_DE_DEFESA = 15;

    public Guerreiro(String nome, String sexo, Motivacao motivacao, Arma arma)
            throws IllegalNameFormatException, IllegalSexFormatException, IllegalWeaponSelectionException {
        super(PONTOS_DE_ATAQUE, PONTOS_DE_DEFESA, nome, sexo, motivacao, arma);
    }

    @Override
    protected Arma validarArma(Arma arma) throws IllegalWeaponSelectionException {
        if (arma.equals(Arma.ESPADA) || arma.equals(Arma.MACHADO)){
            return arma;
        }
        throw new IllegalWeaponSelectionException("A arma escolhida não pode ser utilizada por persongans dessa class.");
    }
}
