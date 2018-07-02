package com.hangman.sinapse.hangman;

/**
 * Created by Jerry Jr on 02/03/2018.
 */
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import java.lang.String;
import android.view.View.OnClickListener;


public final class Util extends GameActivity{
    static String[] temas, animais, paises, frutas, esportes, regiaoBrasil, norte, sul, sudeste, nordeste, centro;

    public static void carregaPalavrasTema(){
        temas = new String[] {"animais","paises","frutas","esportes"};
        animais = new String[] {"cobra","cachorro","gato","elefante","leão","girafa","rinoceronte","hipopotamo","veado","vaca","pato","jacaré","crocodilo","lagarto","lagartixa","papagaio","cegonha","arara","zebra","hiena","macaco","rato","baleia","tubarão","alce","urso","cavalo","búfalo","antílope","águia","coruja","coiote","chimpanzé","canguru","esquilo","falcão","galinha","galo","golfinho","gorila","hamster","iguana","javali","lémure","leopardo","lobo","morcego","ovelha","pantera","peixe","raposa","sapo","tigre","tartaruga","jabuti"};

        paises = new String[] {"brasil","argentina","uruguai","paraguai","bolívia","peru","equador","chile","venezuela","colômbia","suriname","guiana","trinidad e tobago","panamá","honduras","el salvador","nicarágua","bahamas","guatemala","haiti","cuba","jamaica","canadá","estados unidos","méxico","alemanha","inglaterra","país de gales","escócia","irlanda","holanda","polônia","portugal","espanha","itália","frança","turquia","servia","montenegro","iuguslávia","estônia","luxemburgo","ucrânia","rússia","grécia","hungria","áustria","bélgica","croácia","dinamarca","finlândia","suécia","suíça","noruega","romênia","japão","china","coreia do sul","coreia do norte","vietnã","nepal","afeganistão","paquistão","israel","egito","iraque","arábia saudita","kuwait","irã","azerbaijão","tunísia","marrocos","áfrica do sul","nigéria","angola","zâmbia","costa do marfim","argélia","camarões","gana","madagascar","tanzânia","uganda","somália","quênia"};

        frutas = new String[] {"abacate","amora","ameixa","acerola","abacaxi","açaí","banana","carambola","cajá","caju","cereja","caqui","cupuaçu","figo","graviola","goiaba","ingá","jaca","jambo","jenipapo","kiwi","laranja","melancia","maracujá","melão","mamão","manga","maçã","mangaba","pera","pitanga","pinha","pitomba","pêssego","sapoti","tangerina","tamarindo","uva"};

        esportes = new String[] {"futebol","vôlei","handebol","esgrima","basquete","atletismo","hipismo","golfe","ginática","ciclismo","judô","boxe","natação","pólo aquático","taekwondo","tênis","triatlo","vôlei de praia","canoagem"};

        regiaoBrasil = new String[] {"norte", "sul", "centro-oeste", "nordeste", "sudeste"};

        norte = new String[] {"manaus","humaitá","parintins","manacapuru","coari","tefé","tabatinga","belém","santarém","marabá","castanhal","bragança","itaituba","altamira","vilhena","porto velho","ariquemes","guajará-mirim","ji-paraná","rolim de moura","cacoal","palmas","araguína","gurupi","porto nacional","macapá","santana","laranjal do jari","boa vista","bonfim"}; //0-6 amazonas, 7-13 para, 14-20 rondonia, 21-24 tocantins, 25-27 amapa, 28-29 roraima

        sul = new String[] {""};

        sudeste = new String[] {""};

        nordeste = new String[] {""};

        centro = new String[] {""};
    }

}