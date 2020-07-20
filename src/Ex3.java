import java.util.Scanner;
//___________________________________________|
//           MAIN DO EX3 FUNDAMENTOS         |
//                LUIZA LENCINA              |
//___________________________________________|
public class Ex3 {
    public static void main(String[] args){

        // Popula a lista de produtos
        Produto p1 = new Produto("paa", "Café");
        Produto p2 = new Produto("pab", "Suco");
        Produto p3 = new Produto("waa", "Pão");
        Produto p4 = new Produto("wab", "Biscoito");
        Produto p5 = new Produto("wac", "Bolo");
        Produto p6 = new Produto("wad", "Cuca");
        Produto p7 = new Produto("wae", "Coca-cola");
        Produto p8 = new Produto("waf", "Fruki");
        Produto p9 = new Produto("wag", "Bolacha");
        Produto p10 = new Produto("wah", "Chocolate");
        Produto p11 = new Produto("wai", "Torta");
        Produto p12 = new Produto("waj", "Coxinha");
        Produto p13 = new Produto("aaa", "Panqueca");
        Produto p14 = new Produto("aab", "Pão de queijo");
        Produto p15 = new Produto("aac", "Tapioca");
        Produto p16 = new Produto("aad", "Ruffles");
        Produto p17 = new Produto("aae", "Doritos");
        Produto p18 = new Produto("aaf", "Queijo");
        Produto p19 = new Produto("aag", "Mortadela");
        Produto p20 = new Produto("aah", "Nuggets");
        Produto[] ps = {p1, p2, p3, p4, p5,
                        p6, p7, p8, p9, p10,
                        p11, p12, p13, p14, p15,
                        p16, p17, p18, p19, p20};
        ListaDeProdutos lp = new ListaDeProdutos(ps);

        Scanner in = new Scanner(System.in);
        CestoDeCompras cesto = new CestoDeCompras();
        System.out.println("______________________________________________________________________");
        System.out.println("|           Bem vindo ao supermercado BOM DIA NA FAZENDINHA!          |");
        System.out.println("\\--------|        O que podemos fazer por você hoje?         |--------/");
        System.out.println("          --------------------------------------------------");
        String menu = "";
        while(!menu.equals("-1")){
            System.out.println("---------------------------------------------------");
            System.out.println("|               BOM DIA NA FAZENDINHA!            |");
            System.out.println("|                --------------------             |");
            System.out.println("| 1. Listar produtos                              |");
            System.out.println("| 2. Adicionar item ao cesto                      |");
            System.out.println("| 3. Remover item do seu cesto                    |");
            System.out.println("| 4. Exibir cesto                                 |");
            System.out.println("| -1. Saída                                       |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|           OBRIGADA PELA PREFERÊNCIA!            |");
            System.out.println("|-------------------------------------------------|");
            System.out.print("Digite seu comando: ");
            menu = in.nextLine();
            menu = menu.strip();
            System.out.println();
            String amount = null;
            Produto curProd = null;

            switch(menu){
                case "1":
                    lp.listar();
                    break;
                case "2":
                    System.out.print("Por favor, Diga o código dos produtos: ");
                    curProd = lp.pesquisarProduto(in.nextLine().strip());
                    System.out.println();
                    while(curProd == null){
                        System.out.println("Opa, Código inválido!");
                        System.out.println("Vamos tentar novamente: ");
                        curProd = lp.pesquisarProduto(in.nextLine().strip());
                    }

                    System.out.print("Por favor, nos diga a quantidade: ");
                    amount = in.nextLine().strip();
                    try{
                        int qtd = Integer.parseInt(amount);
                        cesto.inserir(curProd, qtd);
                    }catch(NumberFormatException e){
                        System.out.println("Opa, Quantidade inválida!");
                    }catch(IllegalArgumentException e){
                        System.out.println("Opa, Uma quantidade negativa não pode! tente novamente: ");
                    }
                    break;
                case "3":
                    System.out.print("Por favor, digite o código do produto: ");
                    curProd = lp.pesquisarProduto(in.nextLine().strip());
                    System.out.println();
                    if(curProd == null){
                        System.out.println("Opa, código inválido!");
                        break;
                    }
                    System.out.print("Por favor, digite a quantidade: ");
                    amount = in.nextLine().strip();
                    try{
                        int qtd = Integer.parseInt(amount);
                        cesto.excluir(curProd, qtd);
                    }catch(NumberFormatException e){
                        System.out.println("Opa! Este valor não é válido.");
                    }catch(IllegalArgumentException e){
                        System.out.println("Opa! o valor tem que ser positivo! vamo de novo: ");
                    }
                    break;
                case "4":
                    cesto.listar();
                    break;
                case "-1":
                    System.out.println("Bye bye! Obrigada pela preferência, volte sempre!");
                    break;
                default:
                    System.out.println("Opa! Infelizmente não temos este comando. vamo denovo: ");
            }
        }
        in.close();
    }
}