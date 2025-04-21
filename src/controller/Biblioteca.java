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


    //Metodo Construtor
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }


    //Metodos de Cadastrar os livros e o cadastro do Usuario
    public void cadastrarLivro(Livro livro) {
        getLivros().add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        getUsuarios().add(usuario);
    }


    //Metodo de Buscar o titulo do Livro Disponível
    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    //Metodo de Buscar matrícula do usuário disponível
    public Usuario buscarUsuario(String login) {
        for (Usuario usuario : usuarios) {
            if(usuario.getMatricula().equalsIgnoreCase(login)) {
                return usuario;
            }
        }
        return null;
    }


    //Metodo que Lista todos os Livros Disponível
    public void listarLivrosDisponiveis() {

        for (Livro livro : getLivros()) {
            if (livro.isDisponivel()) {
                System.out.printf("Livro: %s  Autor: %s\n",livro.getTitulo(),livro.getAutor());
            }

        }

    }

    //Metodo que empresta o Livro
    public void emprestarLivro(Livro titulo, Usuario matricula) {
        titulo.emprestar(); //Pega o Metodo da Classe Livro


        Emprestimo emprestimo = new Emprestimo(titulo, matricula);

        System.out.printf("O livro %s foi emprestado para o usuário %s com sucesso!\n", titulo.getTitulo(), matricula.getNome());
    }


    public void devolverLivro(Livro titulo, Usuario matricula) {
        titulo.devolver(); //Usa o metodo da Classe Livro

        System.out.printf("O livro %s foi devolvido pelo usuário %s\n", titulo.getTitulo(), matricula.getNome());
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