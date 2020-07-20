//___________________________________________|
//                 PRODUTO EX1               |
//                LUIZA LENCINA              |
//___________________________________________|


public class Produto {
    private String codigo;
    private String descricao;
    private int qtd;

    //padrão quant 1
    public Produto(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtd = 1;
    }

    public Produto(String codigo, String descricao, int qtd){
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtd = qtd;
    }

    // Getters & Setters (Metódos Básicos)

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    // Setters especializados (incrementa e descrementa) :)

    public void add(int qtd){
        this.qtd+=qtd;
    }
    public void remove(int qtd) throws IllegalStateException{
        if(this.qtd-qtd<0) throw new IllegalStateException();
        this.qtd -= qtd;
    }

    public boolean equals(Produto p){
        return this.codigo.equals(p.codigo);
    }

    public int hashCode(){
        return this.codigo.hashCode();
    }

}