import java.util.Random;

public class Produto {

    // gerar codigo do produto do produto
        String codigo() {
        Random gerar = new Random();
        // nao gerar numeros negativos
        int gerador = gerar.nextInt();
        do{
            gerador = gerar.nextInt();
        }while(gerador < 0);

        String codigo = Integer.toString(gerador);
        return codigo;
    }

    //descricao do produto
   String[] descricao(String codigo){
        String[] descri = { };



    }


}

