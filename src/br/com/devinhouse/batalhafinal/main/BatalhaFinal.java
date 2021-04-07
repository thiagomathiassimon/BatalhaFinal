package br.com.devinhouse.batalhafinal.main;

import br.com.devinhouse.batalhafinal.enums.Arma;
import br.com.devinhouse.batalhafinal.enums.Motivacao;
import br.com.devinhouse.batalhafinal.exceptions.*;
import br.com.devinhouse.batalhafinal.model.*;

import java.util.Scanner;

public class BatalhaFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja bem vindo(a) à BATALHA FINAL!");
        Jogador jogador = null;
        try {
            jogador = new Guerreiro("Nome", "M", Motivacao.INICIAL, Arma.ESPADA);
        } catch (IllegalNameFormatException infe) {
            System.err.println("Atenção: " + infe.getMessage());
        } catch (IllegalSexFormatException isfe) {
            System.err.println("Cuidado: " + isfe.getMessage());
        } catch (IllegalWeaponSelectionException iwse) {
            System.err.println("Erro: " + iwse.getMessage());
        }
        boolean repetirFormulario = true;
        do {
            try {
                System.out.println("Informai vosso nome.");
                String nome = scanner.nextLine();
                System.out.println(nome + ", informai vosso sexo(M ou F).");
                String sexo = scanner.nextLine();
                System.out.println(nome + ", informai vossa classe(Guerreiro, Paladino, Arqueiro ou Mago).");
                String classe = scanner.nextLine();
                String opcoesDeArma = "";
                switch (classe.toUpperCase()) {
                    case "GUERREIRO" -> opcoesDeArma = Arma.ESPADA + "ou" + Arma.MACHADO;
                    case "PALADINO" -> opcoesDeArma = Arma.MARTELO + "ou" + Arma.CLAVA;
                    case "ARQUEIRO" -> opcoesDeArma = Arma.ARCO + "ou" + Arma.BESTA;
                    case "MAGO" -> opcoesDeArma = Arma.CAJADO + "ou" + Arma.LIVRO_DE_MAGIAS;
                    default -> throw new IllegalClassSelectionException("A classe selecionada é uma classe inválida.\nPor favor, selecione outra.");
                }
                System.out.println(nome + ", informai vossa arma(" + opcoesDeArma + ").");
                String armaEscolhida = scanner.nextLine();
                Arma arma = Arma.ESPADA;
                if (armaEscolhida.equalsIgnoreCase(Arma.ESPADA.name())){
                    arma = Arma.ESPADA;
                } else if(armaEscolhida.equalsIgnoreCase(Arma.MACHADO.name())){
                    arma = Arma.MACHADO;
                } else if(armaEscolhida.equalsIgnoreCase(Arma.MARTELO.name())){
                    arma = Arma.MARTELO;
                } else if(armaEscolhida.equalsIgnoreCase(Arma.CLAVA.name())){
                    arma = Arma.CLAVA;
                } else if(armaEscolhida.equalsIgnoreCase(Arma.ARCO.name())){
                    arma = Arma.ARCO;
                } else if(armaEscolhida.equalsIgnoreCase(Arma.BESTA.name())){
                    arma = Arma.BESTA;
                } else if(armaEscolhida.equalsIgnoreCase(Arma.CAJADO.name())){
                    arma = Arma.CAJADO;
                } else if(armaEscolhida.equalsIgnoreCase(Arma.LIVRO_DE_MAGIAS.name())){
                    arma = Arma.LIVRO_DE_MAGIAS;
                } else {
                    throw  new IllegalWeaponSelectionException("A arma selecionada não é uma arma válda.\nPor favor, selecione outra.");
                }

                switch (classe.toUpperCase()) {
                    case "GUERREIRO" ->  jogador = new Guerreiro(nome, sexo, Motivacao.INICIAL, arma);
                    case "PALADINO" -> jogador = new Paladino(nome, sexo, Motivacao.INICIAL, arma);
                    case "ARQUEIRO" -> jogador = new Arquiero(nome, sexo, Motivacao.INICIAL, arma);
                    case "MAGO" -> jogador = new Mago(nome, sexo, Motivacao.INICIAL, arma);
                }
                repetirFormulario = false;
            }catch (IllegalClassSelectionException icse){
                System.err.println("Cuidado: " + icse.getMessage());
            } catch (IllegalNameFormatException infe) {
                System.err.println(infe.getMessage());
            } catch (IllegalSexFormatException isfe) {
                System.err.println("Erro: " + isfe.getMessage());
            } catch (IllegalWeaponSelectionException iwse) {
                System.err.println("Atenção: " + iwse.getMessage());
            }
        } while (repetirFormulario);

        System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo,\n"
                + "e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.\n"
                + "Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");

        System.out.println("Memórias do caminho percorrido para chegar até aqui invadem sua mente.\n"
                + "Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno.\n"
                + "Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas.\n"
                + "Você está a um passo de encerrar para sempre esse mal.");

        System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");
        repetirFormulario = true;
        do {
            try {
                System.out.println(jogador.getNome() + ", por que está nessa missão de destruir os inimigos?\nVingança ou Glória?");

                String motivacaoEscolhida = scanner.nextLine();
                Motivacao motivacao = Motivacao.INICIAL;
                if (motivacaoEscolhida.equalsIgnoreCase(Motivacao.VINGANCA.name())) {
                    motivacao = Motivacao.VINGANCA;
                } else if (motivacaoEscolhida.equalsIgnoreCase(Motivacao.GLORIA.name())) {
                    motivacao = Motivacao.GLORIA;
                } else {
                    throw new IllegalMotivationSelectionException("A motivação selecionada não é uma motivação válda.\nPor favor, selecione outra.");
                }
                jogador.setMotivacao(motivacao);
                repetirFormulario = false;
            } catch (IllegalMotivationSelectionException imse) {
                System.err.println(imse.getMessage());
            }
        } while (repetirFormulario);

        if (jogador.getMotivacao() == Motivacao.VINGANCA) {
            System.out.println("Imagens daquela noite trágica invadem sua mente.\n"
                    + "Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes,\n"
                    + "mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram.\n"
                    + "Elas são o combustível que te fizeram chegar até aqui.\n"
                    + "E você sabe que não irá desistir até ter vingado a morte\n"
                    + "daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo.\n"
                    + "O maldito líder finalmente pagará por tanto mal causado na vida de tantos\n"
                    + "(e principalmente na sua).");
        } else {
            System.out.println("Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos,\n"
                    + "bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas,\n"
                    + "taberneiros se recusando a cobrar por suas bebedeiras e comilanças.\n"
                    + "Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas,\n"
                    + "depois de destruir o vilão que tanto assombrou a paz de todos.\n"
                    + "Porém, você sabe que ainda falta o último ato dessa história.\n"
                    + "Você se concentra na missão.\n"
                    + "A glória o aguarda, mas não antes da última batalha.");
        }
        System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas,\n"
                + "suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.\n"
                + "Você avança pelo portal.");

        System.out.println("A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas.\n"
                + "À sua frente, só é possível perceber que você se encontra em um corredor extenso.\n"
                + "Você só pode ir à frente, ou desistir.");

        System.out.println(jogador.getNome() + ", seguirá em frente ou desistirá?\nResponda 'Sim' para seguir em frente e 'Não' para desistir.");
        String escolhaDeContinuidade = scanner.nextLine();
        if (escolhaDeContinuidade.equalsIgnoreCase("Não")) {
            System.out.println("O medo invade o seu coração e você sente que ainda não está à altura do desafio.\n"
                    + "Você se volta para a noite lá fora, e corre em direção à segurança.");
            System.exit(0);
        }
        System.out.println("Você caminha, atento a todos os seus sentidos, por vários metros,\n"
                + "até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha,\n"
                + "vindo de dentro de uma porta aberta.");

        System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
                + "e pondera sobre como passar pela porta.");
        System.out.println(jogador.getNome() + ", como deseja passar pela porta?\nEscolha entre 'Andando cuidadosamente', 'Correndo' ou 'Saltando'.");
        String modoDeEtradaNaSala = scanner.nextLine();
        if (modoDeEtradaNaSala.equalsIgnoreCase("SALTANDO")) {
            System.out.println("Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
        } else if (modoDeEtradaNaSala.equalsIgnoreCase("CORRENDO")) {
            System.out.println("Você respira fundo e desata a correr em direção à sala.\n"
                    + "Quando passa pela porta, sente que pisou em uma pedra solta,\n"
                    + "mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.\n"
                    + "Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você,\n"
                    + "e quando se vira, vê várias flechas no chão.\n"
                    + "Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,\n"
                    + "mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
        } else {
            System.out.println("Você toma cuidado e vai caminhando vagarosamente em direção à luz.\n"
                    + "Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.\n"
                    + "Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor.\n"
                    + "Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");

            Armadilha armadilha = new Armadilha();
            armadilha.atacar(jogador);
        }

        System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
                + "Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas.\n"
                + "A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler,\n"
                + "mas reconhece como sendo a língua antiga utilizada pelo inimigo.\n"
                + "Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas,\n"
                + "e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais,\n"
                + "antes de conseguir enfrentar o líder.");

        System.out.println("Você se dirige para a porta à direita.");

        System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                + "Ao entrar, você se depara com uma sala espaçosa,\n"
                + "com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas.\n"
                + "Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados\n"
                + "utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n"
                + "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás.\n"
                + "Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo.\n"
                + "Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate.\n"
                + "Ele avança em sua direção.");

        Armeiro armeiro = new Armeiro();
        combate(armeiro, jogador);

        System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados.\n"
                + "Olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");

        System.out.println(jogador.getNome() + ", deseja pagar as armaduras novas?\nResponda 'Sim' para pegar e 'Não' para deixá-las.");
        String pegarArmadura = scanner.nextLine();
        if (pegarArmadura.equalsIgnoreCase("Sim")) {
            System.out.println("Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas,\n"
                    + "que estavam danificadas, pelas peças de armaduras existentes na sala.\n"
                    + "De armadura nova, você se sente mais protegido para os desafios à sua frente.");
            jogador.aumentarPontosDeDefesa(5);
        } else {
            System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
        }
        System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo.\n"
                + "Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

        System.out.println("Você retorna à sala anterior e se dirige à porta da esquerda.\n"
                + "Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                + "Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,\n"
                + "existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas,\n"
                + "e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes,\n"
                + "criando poções utilizadas pelos soldados para aterrorizar a região.");
        System.out.println("No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo.\n"
                + "Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.");

        Alquimista alquimista = new Alquimista();
        combate(alquimista, jogador);

        System.out.println("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo.\n"
                + "Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado,\n"
                + "pega a garrafa e pondera se deve beber um gole.");
        System.out.println(jogador.getNome() + ", deseja beber a poção?\nResponda 'Sim' para beber e 'Não' para não berber.");
        String beberAPocao = scanner.nextLine();
        if (beberAPocao.equalsIgnoreCase("Sim")) {
            System.out.println("Você se sente revigorado para seguir adiante!");
            jogador.restaurarPontosDeSaudeAoMaximo();
        } else {
            System.out.println("Você fica receoso de beber algo produzido pelo inimigo.");
        }
        System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa,\n"
                + "e sabe que aquela chave abre a outra fechadura da porta do líder inimigo.\n"
                + "Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.");

        System.out.println("De volta à sala das portas, você se dirige à porta final.\n"
                + "Coloca as chaves nas fechaduras, e a porta se abre.\n"
                + "Seu coração acelera, memórias de toda a sua vida passam pela sua mente,\n"
                + "e você percebe que está muito próximo do seu objetivo final.\n"
                + "Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.");

        System.out.println("Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.");

        System.out.println("Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.");

        Lider lider = new Lider();

        System.out.println(jogador.getNome() + ", deseja atacar ou esperar?\nResponda 'Atacar' para atacar o líder ou 'Esperar' para que ele ataque-vos.");
        String escolhaDePrioridadeDeAtaque = scanner.nextLine();
        if (escolhaDePrioridadeDeAtaque.equalsIgnoreCase("Atacar")){
            combate(jogador, lider);
        } else {
            combate(lider, jogador);
        }

        System.out.println("Você conseguiu!");

        if (jogador.getMotivacao() == Motivacao.VINGANCA){
            System.out.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. " +
                    "Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
        } else if (jogador.getMotivacao() == Motivacao.GLORIA){
            System.out.println("O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
        }

        System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta,\n"
                + "e todos vocês saem em direção à noite, retornando à cidade.\n"
                + "Seu dever está cumprido.");

        scanner.close();
    }

    private static void combate(Personagem personagemAtacante, Personagem segundoAAtacar) {

        boolean continuarCombate = true;
        while (continuarCombate){
            if (personagemAtacante.getPontosDeSaude() != 0) {
                personagemAtacante.atacar(segundoAAtacar);
            } else {
                continuarCombate = false;
                return;
            }
            if (segundoAAtacar.getPontosDeSaude() != 0){
                segundoAAtacar.atacar(personagemAtacante);
            } else {
                return;
            }
            String mensagemDeMorte = "";
            if ((personagemAtacante instanceof Inimigo || segundoAAtacar instanceof Inimigo ) && personagemAtacante.getPontosDeSaude() == 0){
                mensagemDeMorte = "O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.";
            } else if ((personagemAtacante instanceof Jogador || segundoAAtacar instanceof Jogador) && personagemAtacante.getPontosDeSaude() == 0) {
                Jogador jogador;
                if (personagemAtacante instanceof Jogador) {
                    jogador = (Jogador) personagemAtacante;
                } else {
                    jogador = (Jogador) segundoAAtacar;
                }
                mensagemDeMorte = "Você não estava preparado para a força do inimigo.";
                if (jogador.getMotivacao() == Motivacao.VINGANCA) {
                    mensagemDeMorte += "Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.";
                } else if (jogador.getMotivacao() == Motivacao.GLORIA) {
                    if (jogador.getSexo().equalsIgnoreCase("M")) {
                        mensagemDeMorte += "A glória que buscavas não será sua, e a cidade aguarda por seu próximo herói.";
                    } else if (jogador.getSexo().equalsIgnoreCase("F")) {
                        mensagemDeMorte += "A glória que buscavas não será sua, e a cidade aguarda por sua próxima heroína.";
                    }
                }
            }
        }
    }
}
