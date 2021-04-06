package br.com.devinhouse.batalhafinal.enums;

public enum Arma {

    ESPADA("Jogador", 5), MACHADO("Jogador", 5), MARTELO("Jogador", 5),
    CLAVA("Jogador", 5), ARCO("Jogador", 5), BESTA("Jogador", 5),
    CAJADO("Jogador", 5), LIVRO_DE_MAGIAS("Jogador", 5), ARMADILHA("Armadilha", 2),
    MACHADO_DUPLO("Líder", 7);

    private String tipoDeArma;
    private int poderDeAtaque;

    private Arma(String tipoDeArma, int poderDeAtaque){
        this.tipoDeArma = tipoDeArma;
        this.poderDeAtaque = poderDeAtaque;
    }

    public String getTipoDeArma() {
        return tipoDeArma;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }
}
