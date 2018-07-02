package com.hangman.sinapse.hangman;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;

import java.util.Random;

/**
 * Created by Jerry Jr on 27/02/2018.
 */

public class SortWord {
    String[] temas, animais, paises, frutas, esportes, regiaoBrasil, regiaoN, regiaoS, regiaoSE, regiaoNE, regiaoCO,dicasAnimais,dicasPaises,dicasEsportes, dicasFrutas;
    private int tamanhoTema = 0;
    private String dica = "";
    public SortWord() {
        temas = new String[] {"animais","paises","frutas","esportes","cidades"};
        regiaoBrasil = new String[] {"norte", "sul", "centro-oeste", "nordeste", "sudeste"};
        //animais = new String[] {"cobra","cachorro","gato","elefante","leão","girafa","rinoceronte","hipopotamo","veado","vaca","pato","jacaré","crocodilo","lagarto","lagartixa","papagaio","cegonha","arara","zebra","hiena","macaco","rato","baleia","tubarão","alce","urso","cavalo","búfalo","antílope","águia","coruja","coiote","chimpanzé","canguru","esquilo","falcão","galinha","galo","golfinho","gorila","hamster","iguana","javali","lémure","leopardo","lobo","morcego","ovelha","pantera","peixe","raposa","sapo","tigre","tartaruga","jabuti"};

        //paises = new String[] {"brasil","argentina","uruguai","paraguai","bolívia","peru","equador","chile","venezuela","colômbia","suriname","guiana","trinidad e tobago","panamá","honduras","el salvador","nicarágua","bahamas","guatemala","haiti","cuba","jamaica","canadá","estados unidos","méxico","alemanha","inglaterra","país de gales","escócia","irlanda","holanda","polônia","portugal","espanha","itália","frança","turquia","servia","montenegro","iuguslávia","estônia","luxemburgo","ucrânia","rússia","grécia","hungria","áustria","bélgica","croácia","dinamarca","finlândia","suécia","suíça","noruega","romênia","japão","china","coreia do sul","coreia do norte","vietnã","nepal","afeganistão","paquistão","israel","egito","iraque","arábia saudita","kuwait","irã","azerbaijão","tunísia","marrocos","áfrica do sul","nigéria","angola","zâmbia","costa do marfim","argélia","camarões","gana","madagascar","tanzânia","uganda","somália","quênia"};

        //frutas = new String[] {"abacate","amora","ameixa","acerola","abacaxi","açaí","banana","carambola","cajá","caju","cereja","caqui","cupuaçu","figo","graviola","goiaba","ingá","jaca","jambo","jenipapo","kiwi","laranja","melancia","maracujá","melão","mamão","manga","maçã","mangaba","pera","pitanga","pinha","pitomba","pêssego","sapoti","tangerina","tamarindo","uva"};

        //esportes = new String[] {"futebol","vôlei","handebol","esgrima","basquete","atletismo","hipismo","golfe","ginática","ciclismo","judô","boxe","natação","pólo aquático","taekwondo","tênis","triatlo","vôlei de praia","canoagem"};

        //regiaoN = new String[] {"manaus","humaitá","parintins","manacapuru","coari","tefé","tabatinga","belém","santarém","marabá","castanhal","bragança","itaituba","altamira","vilhena","porto velho","ariquemes","guajará-mirim","ji-paraná","rolim de moura","cacoal","palmas","araguína","gurupi","porto nacional","macapá","santana","laranjal do jari","boa vista","bonfim"};
        //0-6 am, 7-13 pa, 14-20 ro, 21-24 to, 25-27 am, 28-29 rr

        //regiaoS = new String[] {"caxias do sul","porto alegre","canoas","pelotas","passo fundo","santa maria","uruguaiana","viamão","rio grande","novo hamburgo","gravataí","joinville","itajaí","blumenau","criciúma","são josé","balneário camburiú","florianópolis","são bento do sul","jaraguá do sul","tubarão","maringá","casvavel","ponta grossa","londrina","curitiba","umuarama","francisco beltrão","campo largo","pato branco"};
        //0-10 rs, 11-20 sc, 21-29 pr

        //regiaoSE = new String[] {"grarulhos","osasco","campinas","santos","ribeirão preto","são paulo","mauá","sorocaba","diadema","praia grande","guarujá","são gonçalo","são joão de meriti","nova iguaçu","volta redonda","rio de janeiro","duque de caxias","niterói","uberaba","belo horizonte","montes claros","juiz de fora","uberlândia","contagem","bom sucesso","betim","vitória","cariacia","vila velha","serra"};
        //0-10 sp, 11-17 rj, 19-25 mg, 26-29 es

        //regiaoNE = new String[] {"barreiras","juazeiro","ilhéus","feira de santana","salvador","juazeiro do norte","sobral","crato","fortaleza","quixadá","caruaru","olinda","abreu e lima","recife","petrolina","campina grande","bayeux","joão pessoa","natal","parnamirim","macaíba","mossoró","alcântara","imperatriz","barra da corda","são luis","codó","parnaíba","teresina","picos"};
        //0-4 ba, 5-9 ce, 10-13 pe, 14-17 pb, 18-21 rn, 22-26 ma, 27-29 pi

        //regiaoCO = new String[] {"luziânia","cristalina","anápolis","jataí","rio verde","goiânia","planaltina","dourados","corumbá","ponta porã","campo grande","três lagoas","rondonópolis","cuiabá","sinop","várzea grande","sorriso","cáceres","pontes e lacerda","tangará da serra","brasília"};
        //0-6 go,7-11 ms, 12-19 mt, 20 df

    }

    private void newAnimal(){
        animais = new String[] {"cobra","cachorro","gato","elefante","leão","girafa","rinoceronte","hipopotamo","vaca","pato","jacaré","crocodilo","lagartixa","papagaio","cegonha","arara","zebra","hiena","macaco","rato","baleia","tubarão","alce","urso","cavalo","búfalo","águia","coruja","coiote","chimpanzé","canguru","esquilo","falcão","galinha","galo","golfinho","gorila","hamster","javali","lémure","leopardo","lobo","morcego","ovelha","pantera negra","peixe","raposa","sapo","tigre","tartaruga","jabuti","sucuri"};
        tamanhoTema = animais.length;
        dicasAnimais = new String[] {"inimiga das amiga","abana os rabos quando feliz","solta bastante pelo","de onde vem o marfim?","rei da selva","a maior da áfrica","chifre pontiagudo","pesa ate 4 toneladas","de onde vem o leite?","quac quac","ref. Marca Lacoste","lágrimas falsas. ref. ditado popular","réptil pequeno que escala paredes","ave que fala","quem traz os bebês?","simbolo amazônico no ar","a listradinha da selva","moro nas terras sombrias. ref. Rei Leão","pulo de galho em galho","inimigo do Tom","filme: Free Willy","peixe de mordida assassina","mamífero de chifre que habita norte do planeta","hiberno no inverno","esrela no hipismo","meu queijo é muito famoso e caro","usada como símbolo nacional nos EUA","durmo de dia, caço a noite","inimigo do Papaléguas","me chamo César em um filme famoso de primatas","tenho bolsa para meus filhotes","amo nozes","Jogador famoso do futsal brasileiro","tenho asas, mas não voo","tenho crista e esporões","o mais inteligente das águas","maior e mais forte primata","ref. hantaro","também conhecido como porco do mato","ref. eu me remexo muito","muito parecido com a onça","comeu a vovózinha. ref. Chapeuzinho","famoso conde drácula","minha lã é tao quentinha","herói da marvel","ref. procurando Nemo","ref. simbolo navegador Firef.x","não gosto de lavar o pé","maior felino do planeta","tenho amigas que são ninjas","ref. mais importante prêmio literário do Brasil","Conhecida também como anaconda"};
    }

    private void newPais(){
        paises = new String[] {"brasil","argentina","uruguai","paraguai","bolívia","peru","equador","chile","venezuela","colômbia","suriname","guiana francesa","panamá","honduras","el salvador","nicarágua","bahamas","guatemala","haiti","cuba","jamaica","canadá","estados unidos","méxico","alemanha","inglaterra","país de gales","escócia","irlanda","holanda","polônia","portugal","espanha","itália","frança","turquia","estônia","luxemburgo","ucrânia","rússia","grécia","hungria","áustria","bélgica","croácia","dinamarca","finlândia","suécia","suíça","noruega","romênia","japão","china","coreia do sul","coreia do norte","vietnã","nepal","afeganistão","paquistão","israel","egito","iraque","arábia saudita","kuwait","irã","azerbaijão","tunísia","marrocos","áfrica do sul","nigéria","angola","zâmbia","costa do marfim","argélia","camarões","gana","madagascar","tanzânia","uganda","somália","quênia"};
        tamanhoTema = paises.length;
        dicasPaises = new String[] {"páis do futebol","nossos hermanos","vizinho dos hermanos","Assunção é sua capital","onde fica maior deserto de sal","onde está a nascento do Rio Amazonas","ref. linha imaginária que marca 0°","capital Santiago","capital Caracas","ref. Pablo Escobar","vizinho ao leste da Guiana","vizinho francês do Suriname","possui um famoso canal marítimo","honduras","el salvador","nicarágua","bahamas","guatemala","haiti","ditador Fidel Castro","terra do Bob Marley","possui as Cataratas do Niágara","conhecido como Tio Sam","fronteira de maior polêmica com os EUA","lembrança dos 7x1","residência da Rainha Elizabeth","pertence ao Reino Unido","situado na ilha da Grã-Bretanha","conhecida como A Ilha Esmeralda","seleção conhecida como Laranja Mecânica","","sofreu muito com holocausto","quem nos descobriu?","sua capital é Madrid","onde está a Basílica de São Pedro. ref. Cristianismo","qual a cor do cavalo branco de Napoleão","está localizado o Monte Ararate","idioma é Estoniano","nome de um técnico do Flamengo","sou segundo maior país Europeu. Capital Kiev.","maior páis do Mundo","onde surgiu os Jogos Olímpicos","banda famosa de Hip Hop no Brasil","nacionalidade de um arquiduque morto de um Império. ref. Primeira Guerra Mundial","belgica","Mirko Crocop ref. UFC","dinamarca","finlandia","suecia","noruega","romenia","Império que participava da Triplice Entente","Ali Express","coreia do sul","É o mais fechado do mundo","Vencedor da guerra na década de 60","nepal","Onde está uma das maiores organizações terroristas do mundo","paquistao","israel","Terra dos faraós","iraque","Terra dos shakes","Nome de um refrigerante de guaraná","ira","azerbaijao","tunisia","marrocos","ref. Nelson Mandela","nigeria","angola","zambia","Terra do jogador Didie Drogba","argelia","camaroes","gana","Nome de um filme infantil. ref. Rei Julios","tanzania","uganda","somalia","Terra africana dos famosos corredores"};
    }

    private void newFruta(){
        frutas = new String[] {"abacate","amora"};
        tamanhoTema = frutas.length;
        dicasFrutas = new String[] {"abacate","amora","ameixa","acerola","abacaxi","açaí","banana","carambola","cajá","caju","cereja","caqui","cupuaçu","figo","graviola","goiaba","ingá","jaca","jambo","jenipapo","kiwi","laranja","melancia","maracujá","melão","mamão","manga","maçã","mangaba","pera","pitanga","pinha","pitomba","pêssego","sapoti","tangerina","tamarindo","uva"};
    }

    private void newEsporte(){
        esportes = new String[] {"futebol","vôlei","handebol","esgrima","basquete","atletismo","hipismo","golfe","ciclismo","judô","jiu-jitsu","futsal","pugilismo","natação","pólo aquático","taekwondo","tênis","triatlo","vôlei de praia","canoagem"};
        tamanhoTema = esportes.length;
        dicasEsportes = new String[] {"esporte mais popular no mundo","jogo termina quando um time completa três sets vencidos","jogo de quadra que se faz gols com usando a mão","arte de lutar com armas brancas (espada, florete, sabre etc)","jogo de quadra que os pontos, são feitos fazendo acertando o cesto","é um conjunto de esportes constituído por varias modalidades: corrida, salto, lançamento e marcha","é o maior esporte feito com cavalos no mundo inteiro","esporte jogado em campos gramados arremessando uma bola para uma série de buracos","esporte de corrida de duas rodas, porém não é motocicleta","esporte onde quem faz um Ippon, já vence","seu estio foi difundido mundialmente pela família Gracie","esporte no qual jogador Falcão joga e faz show","luta em que se usa apenas as mãos, envolvidas em luvas. ref. Mike Tyson","esporte praticado na água, possui variadas modalidades. ref. Michael Phelps","pode ser dito que é o handebol jogado na água","esporte de luta coreana que se utiliza muito as pernas e os pé como ataque","possui um famoso esporista com codinome Guga","evento atlético composto por três modalidades: natação, ciclismo e corrida","esporte praticado por duas equipes, cada uma composta de dois jogadores","também praticado na água, porém não precisa nadar"};
    }

    private void newRegiaoNorte(){
        regiaoN = new String[] {"manaus","humaitá","parintins","manacapuru","coari","tefé","tabatinga","belém","santarém","marabá","castanhal","bragança","itaituba","altamira","vilhena","porto velho","ariquemes","guajará-mirim","ji-paraná","rolim de moura","cacoal","palmas","araguína","gurupi","porto nacional","macapá","santana","laranjal do jari","boa vista","bonfim"};
        tamanhoTema = regiaoN.length;
        //0-6 am, 7-13 pa, 14-20 ro, 21-24 to, 25-27 am, 28-29 rr
    }

    private void newRegiaoSul(){
        regiaoS = new String[] {"caxias do sul","porto alegre","canoas","pelotas","passo fundo","santa maria","uruguaiana","viamão","rio grande","novo hamburgo","gravataí","joinville","itajaí","blumenau","criciúma","são josé","balneário camburiú","florianópolis","são bento do sul","jaraguá do sul","tubarão","maringá","casvavel","ponta grossa","londrina","curitiba","umuarama","francisco beltrão","campo largo","pato branco"};
        tamanhoTema = regiaoS.length;
        //0-10 rs, 11-20 sc, 21-29 pr
    }

    private void newRegiaoSudeste(){
        regiaoSE = new String[] {"grarulhos","osasco","campinas","santos","ribeirão preto","são paulo","mauá","sorocaba","diadema","praia grande","guarujá","são gonçalo","são joão de meriti","nova iguaçu","volta redonda","rio de janeiro","duque de caxias","niterói","uberaba","belo horizonte","montes claros","juiz de fora","uberlândia","contagem","bom sucesso","betim","vitória","cariacia","vila velha","serra"};
        tamanhoTema = regiaoSE.length;
        //0-10 sp, 11-17 rj, 19-25 mg, 26-29 es
    }

    private void newRegiaoNordeste(){
        regiaoNE = new String[] {"barreiras","juazeiro","ilhéus","feira de santana","salvador","juazeiro do norte","sobral","crato","fortaleza","quixadá","caruaru","olinda","abreu e lima","recife","petrolina","campina grande","bayeux","joão pessoa","natal","parnamirim","macaíba","mossoró","alcântara","imperatriz","barra da corda","são luis","codó","parnaíba","teresina","picos"};
        tamanhoTema = regiaoNE.length;
        //0-4 ba, 5-9 ce, 10-13 pe, 14-17 pb, 18-21 rn, 22-26 ma, 27-29 pi
    }

    private void newRegiaoCentro(){
        regiaoCO = new String[] {"luziânia","cristalina","anápolis","jataí","rio verde","goiânia","planaltina","dourados","corumbá","ponta porã","campo grande","três lagoas","rondonópolis","cuiabá","sinop","várzea grande","sorriso","cáceres","pontes e lacerda","tangará da serra","brasília"};
        tamanhoTema = regiaoCO.length;
        //0-6 go,7-11 ms, 12-19 mt, 20 df
    }

    public String getDica(){
        return dica;
    }

    public String sorteio() {
        String palavraSorteada = "";
        int pos = 0;
        if(!GameActivity.nivel.equals("normal")) {
            GameActivity.tema = temas[(int)(random()*temas.length)];
        }
        switch (GameActivity.tema){
            case "animais":
                newAnimal();
                pos = (int)(random()*animais.length);
                palavraSorteada = animais[pos];
                dica = dicasAnimais[pos];
                break;
            case "paises":
                newPais();
                pos = (int)(random()*paises.length);
                palavraSorteada = paises[pos];
                dica = dicasPaises[pos];
                break;
            case "frutas":
                newFruta();
                pos = (int)(random()*frutas.length);
                palavraSorteada = frutas[pos];
                dica = dicasFrutas[pos];
                break;
            case "esportes":
                newEsporte();
                pos = (int)(random()*esportes.length);
                palavraSorteada = esportes[pos];
                dica = dicasEsportes[pos];
                break;
            case "cidades":
                String regiao = regiaoBrasil[(int) (random()*regiaoBrasil.length)];
                switch (regiao){
                    case "norte":
                        newRegiaoNorte();
                        pos = (int) (random()*regiaoN.length);
                        palavraSorteada = regiaoN[pos];
                        //0-6 am, 7-13 pa, 14-20 ro, 21-24 to, 25-27 am, 28-29 rr
                        if(pos <= 6)
                            dica = "amazonas";
                        else if(pos <= 13)
                            dica = "pará";
                        else if(pos <= 20)
                            dica = "rondônia";
                        else if(pos <= 24)
                            dica = "tocantins";
                        else if(pos <= 27)
                            dica = "amapá";
                        else dica = "roraima";
                        break;
                    case "sul":
                        newRegiaoSul();
                        pos = (int) (random()*regiaoS.length);
                        palavraSorteada = regiaoS[pos];
                        //0-10 rs, 11-20 sc, 21-29 pr
                        if(pos <= 10)
                            dica = "rio grande do sul";
                        else if(pos < 20)
                            dica = "santa catarina";
                        else
                            dica = "paraná";
                        break;
                    case "sudeste":
                        newRegiaoSudeste();
                        pos = (int) (random()*regiaoSE.length);
                        palavraSorteada = regiaoSE[pos];
                        //0-10 sp, 11-18 rj, 19-26 mg, 27-30 es
                        if(pos <= 10)
                            dica = "são paulo";
                        else if(pos <= 17)
                            dica = "rio de janeiro";
                        else if(pos < 26)
                            dica = "minas gerais";
                        else
                            dica = "espírito santo";
                        break;
                    case "nordeste":
                        newRegiaoNordeste();
                        pos = (int) (random()*regiaoNE.length);
                        palavraSorteada = regiaoNE[pos];
                        //0-4 ba, 5-9 ce, 10-13 pe, 14-16 pb, 17-20 rn, 21-25 ma, 26-28 pi
                        if(pos <= 4)
                            dica = "bahia";
                        else if(pos <= 9)
                            dica = "ceará";
                        else if(pos <= 13)
                            dica = "pernambuco";
                        else if(pos <= 16)
                            dica = "paraíba";
                        else if(pos <= 21)
                            dica = "rio grande do norte";
                        else if(pos <= 26)
                            dica = "maranhão";
                        else dica = "piauí";
                        break;
                    case "centro-oeste":
                        newRegiaoCentro();
                        pos = (int) (random()*regiaoCO.length);
                        palavraSorteada = regiaoCO[pos];
                        //0-6 go,7-11 ms, 12-19 mt, 20 df
                        if(pos <= 6)
                            dica = "goiás";
                        else if(pos <= 11)
                            dica = "mato grosso do sul";
                        else if(pos <= 19)
                            dica = "mato grosso";
                        else
                            dica = "distrito federal";
                        break;
                }
                break;
        }

        return palavraSorteada;
    }

    public int getTamanho(){
        return tamanhoTema;
    }

    public int dica(String[] str){
        int pos = 0;
        pos = (int) (random()*str.length);
        int i=0;
        while(str[pos] == "*"){
            pos = (int) (random()*str.length);
        }
        return pos;
    }

    public static double random() {
        Random r = new Random();
        return r.nextDouble();
    }

    public String sorteiaTema(){
        String tema = temas[(int)(random()*temas.length)];
        while(GameActivity.tema.equals(tema)){
            tema = temas[(int)(random()*temas.length)];
        }
        return tema;
    }
}
