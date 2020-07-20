//___________________________________________|
//              CESTO DE COMPRAS             |
//                LUIZA LENCINA              |
//___________________________________________|
public class CestoDeCompras{
    private ListaDeProdutos cesto;

    // padrão faz um cesto do tamanho 50
    public CestoDeCompras(){
        this.cesto = new ListaDeProdutos();
    }

    // permite especificar o tamanho do cesto (size)
    public CestoDeCompras(int size){
        this.cesto = new ListaDeProdutos(size);
    }

    //pesquisa o produto pelo codigo
    public Produto pesquisar(String codigo){
        return this.cesto.pesquisarProduto(codigo);
    }


   // Adiciona os produtos no cesto de compras
    // se o produto ja existe ele simplesmente acrscenta mais :)
    public CestoDeCompras inserir(Produto p, int qtd) throws IllegalArgumentException{
        if(qtd<0) throw new IllegalArgumentException("Quantidade deve ser nao-negativa");
        if(qtd==0) return this;
        Produto helper = this.pesquisar(p.getCodigo());
        if(helper!=null){
            helper.add(qtd);
            return this;
        }
        p.setQtd(qtd);
        cesto.cadastrarProduto(p);
        return this;
    }

    // Exclui algo do cesto
    // caso ele não há no cesto, simplesmente ignora (boolean)
    public boolean excluir(Produto p, int qtd) throws IllegalArgumentException{
        if(qtd<0) throw new IllegalArgumentException("Quantidade deve ser nao-negativa");
        Produto helper = this.pesquisar(p.getCodigo());
        if(helper!=null){
            if(helper.getQtd()-qtd>0)
                helper.remove(qtd);
            else cesto.excluir(p);
            return true;
        }
        return false;
    }

    //lista de produtos no cesto de compras
    public void listar(){
        System.out.println(this.toString());
    }

    //imprimi a lista // string do cesto // return do que tem nele :)
    public String toString(){
        String[] base = cesto.toString().split("\n");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cesto.getFill(); i++){
            sb.append(base[i*3]);
            sb.append("\nQuantidade: ").append(cesto.getProduto(i).getQtd()).append("\n").append(base[i*3+1]).append("\n\n");
        }
        return sb.toString();
    }
}