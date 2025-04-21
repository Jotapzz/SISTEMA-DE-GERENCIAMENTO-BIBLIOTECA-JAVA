package model;


public class Emprestimo {
    //Atributos
    private Livro livro;
    private Usuario usuario;
    private String dataEmprestimo;
    private String dataDevolucao;

    //Metodo Construtor
    public Emprestimo(Livro livro, Usuario usuario) {
        //Atributos
        this.livro = livro;
        this.usuario = usuario;
    }

    //Metodos Gets e Sets
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}