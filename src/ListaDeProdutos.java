import java.util.Arrays;

//___________________________________________|
//              LISTA DE PRODUTO             |
//                LUIZA LENCINA              |
//___________________________________________|

public class ListaDeProdutos {
    private Produto[] produtos;
    private int fill;

    // Construtor padrao
    public ListaDeProdutos(){
        this.produtos = new Produto[50];
        this.fill = 0;
    }

    // Construtor com array
    public ListaDeProdutos(Produto[] produtos){
        //Arrays are passed by reference, so we want to clone it to avoid
        //unwanted side-effects. Sadly, .clone() creates an Object-type object
        //so we need to cast it back to Produto[]
        this.produtos = (Produto[]) produtos.clone();
        this.fill = produtos.length;
    }

    // Construtor que permite setar o tamanho inicial da lista
    public ListaDeProdutos(int size){
        this.produtos = new Produto[size];
        this.fill = 0;
    }

     //cadastra um produto novo na lista
     //@return Este metodo retorna uma ListaDeProdutos para que ele seja fluente e permita
     // encadear chamadas do tipo "l.cadastrarProduto(a).cadastrarProduto(b)" etc...


    public ListaDeProdutos cadastrarProduto(Produto produto){

        // Se o produto ja esta cadastrado, nao faz nada
        if(this.pesquisarProduto(produto.getCodigo())!=null) return this;

        if(this.fill == produtos.length){
            this.produtos = Arrays.copyOf(produtos, produtos.length * 2);
        }
        produtos[fill] = produto;
        fill++;
        return this;
    }

    //Pesquisa e lista o produto pelo codigo
    public Produto pesquisarProduto(String codigo){
        for(int i = 0; i < this.fill; i++){
            if(produtos[i].getCodigo().equals(codigo)){
                return produtos[i];
            }
        }
        return null;
    }

    //Acha o indice do produto na lista
    // se ele acha -1 caso contrario i
    public int getIndex(Produto produto){
        for(int i = 0; i < this.fill; i++){
            if(produtos[i].equals(produto)){
                return i;
            }
        }
        return -1;
    }

   //GET que retorna produto que se encontra em determinado indice da lista
    public Produto getProduto(int i)throws IndexOutOfBoundsException{
        //caso valor do prod não seja permitido "ilegal"
        if(i<0||i>=this.fill) throw new IndexOutOfBoundsException();
        return produtos[i];
    }

    //lista todos os produtos
    public void listar(){
        System.out.println(this.toString());
    }
    
    // excluir produto
    public boolean excluir(Produto produto){
        int j = fill;
        for(int i = 0; i < fill; i++){
            if(produtos[i].equals(produto)){
                j = i;
            }
        }
        if(j!=fill){
            this.fill--;
            for(;j<fill;j++){
                produtos[j] = produtos[j++];
            }
            return true;
        }
        return false;
    }

    // toString da lista
    public String toString(){
        //string builder pra forçar
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.fill; i++){
            sb.append(i+1).append(". Produto Codigo: ").append(produtos[i].getCodigo()).append("\nDescricao: ").append(produtos[i].getDescricao()).append("\n\n");
        }
        return sb.toString();
    }

    //return do array
    // o quanto ele suporta
    public int getFill() {
        return fill;
    }
}