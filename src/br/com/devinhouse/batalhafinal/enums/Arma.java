package br.com.devinhouse.batalhafinal.enums;

public enum Arma {

    ESPADA(5), MACHADO(5), MARTELO(5), CLAVA(5), ARCO(5), BESTA(5),
    CAJADO(5), LIVRO_DE_MAGIAS(5), ARMADILHA(2), MACHADO_DUPLO(7);

    private int poderDeAtaque;

    private Arma(int poderDeAtaque){
        this.poderDeAtaque = poderDeAtaque;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }
}
