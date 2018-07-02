package com.hangman.sinapse.hangman;
import java.util.Random;
/**
 * Created by Jerry Jr on 26/02/2018.
 */

public class Palavras {

    private String[] temas = new String[] {"animais","paises","frutas","esportes"};
    private String[] palavras = new String[] {"AVIÃO", "AERONAVE", "AUTOMÓVEL",
            "MOTOCICLETA", "BICICLETA", "IATE", "NAVIO", "TERRA", "MERCÚRIO",
            "PLUTÃO", "MARTE", "JUPTER", "NETUNO", "ELEFANTE", "ESCORPIÃO",
            "RINOCERONTE", "DINOSSAURO", "REFRIGERADOR", "ÁFRICA", "BRASIL",
            "TELEVISOR", "POLTRONA", "SECADORA", "ESCORREDOR", "LIQUIDIFICADOR",
            "EUROPA", "AMSTERDÃ", "ESTADOS UNIDOS", "GRÉCIA", "ARGENTINA",
            "VENEZUELA", "BOTAFOGO", "SÃO PAULO", "FLAMENGO", "PALMEIRAS",
            "FLUMINENSE", "AMOR", "INTELECTUAL", "SÁBIO", "CULTURA", "SABEDORIA",
            "TUCANO", "BEIJA-FLOR", "ZEBRA", "CRUZEIRO", "COMPUTADOR", "FACULDADE",
            "PIPOCA", "MACARRÃO", "FEIJOADA", "SABÃO EM PÓ", "LAVANDERIA",
            "COZINHA", "CHURRASCO", "PARANAENSE", "MINEIRO", "SANTISTA", "GAÚCHO",
            "CATARINENSE", "AFRICANO", "BRASILEIRO", "AMERICANO", "CARTEIRO",
            "LIXEIRO", "PROGRAMADOR", "LUMINÁRIA", "LUTADOR", "COZINHEIRO",
            "VENDEDOR", "FLORICULTURA", "JAPÃO", "ARÁBIA SAUDITA", "EQUADOR",
            "MÉXICO", "PORTUGUAL", "ALEMANHA", "PROFESSOR", "CHAVEIRO", "FAMÍLIA",
            "DOCUMENTÁRIO", "DOCUMENTOS", "FAMILIARES", "LANCHONETE"};

    public Palavras() {
    }

    public String sorteio() {
        String sortTema = temas[(int)(random()*temas.length)];
        String palavraSorteada = palavras[(int)(random()*palavras.length)];

        return palavraSorteada;
    }

    public static double random() {
        Random r = new Random();

        return r.nextDouble();
    }
}
