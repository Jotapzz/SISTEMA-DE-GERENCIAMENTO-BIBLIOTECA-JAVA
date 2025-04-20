package model;

public class Livro {
    //Atributos
    private String titulo;
    private String autor;
    private boolean disponivel;


    public void emprestar(){
        //se o livro estiver disponivel
        if(isDisponivel()){
            System.out.println("Livro emprestado");
            setDisponivel(false);
        }
    }

    public void devolver(){
        //se o livro não estiver disponivel
        if (!isDisponivel()){
            System.out.println("Livro devolvido");
            setDisponivel(true);
        }
    }

    //Metodo Construtor
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    // Metodos Gets e Sets
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}