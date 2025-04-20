package controller;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //Atributos
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;







    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }



    public void cadastrarLivro(Livro livro) {
        getLivros().add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        getUsuarios().add(usuario);
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String login) {
        for (Usuario usuario : usuarios) {
            if(usuario.getMatricula().equalsIgnoreCase(login)) {
                return usuario;
            }
        }
        return null;
    }








    public Livro listarLivrosDisponiveis() {

        for (Livro livro : getLivros()) {
            if (livro.isDisponivel()) {
                return livro;
            }
        }
        return null;
    }

    public void emprestarLivro(Livro titulo, Usuario matricula) {
        if (!titulo.isDisponivel()) {
            System.out.println("Livro indisponível. ");
            return;
        }

        titulo.setDisponivel(false);
        Emprestimo emprestimo = new Emprestimo(titulo, matricula);

        System.out.printf("O livro %s foi emprestado para o usuário %s com sucesso!\n", titulo.getTitulo(), matricula.getNome());
    }


    public void devolverLivro(Livro titulo) {
        if (!titulo.isDisponivel()) {
            System.out.println("Livro Devolvido com Sucesso!");
        }
        else {
            System.out.println("O Livro já foi Devolvido!");
        }
    }

    public void listarLivrosEmprestados() {
        for (Livro livro : getLivros()) {
            if (!livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
    }











    //Metodos Gets e Sets
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}