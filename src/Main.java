import controller.Biblioteca;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();




        while (true) {
            System.out.println("==== Gerenciamento de Livros ====");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - cadastrar Livro");
            System.out.println("3 - Pegar um Livro");
            System.out.println("4 - Devolver o Livro");
            System.out.println("5 - Listar Livros");
            System.out.println("6 - Sair");
            try {
                System.out.print("Escolha uma opcao: ");
                int opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = input.next();
                        System.out.print("Email: ");
                        String email = input.next();
                        System.out.print("Matricula: ");
                        String matricula = input.next();


                        Usuario usuario = new Usuario(nome, email, matricula);
                        biblioteca.cadastrarUsuario(usuario);
                        System.out.println("Cadastrado com sucesso!");
                        break;

                    case 2:
                        //Pega o dados do livro e armazena na variavel
                        input.nextLine();
                        System.out.print("Titulo: ");
                        String titulo = input.nextLine();

                        System.out.print("Autor: ");
                        String autor = input.nextLine();

                        //Instancia livro pela Classe Livro e coloca os parâmetros que o usuário digitou
                        Livro livro = new Livro(titulo, autor);
                        biblioteca.cadastrarLivro(livro); //cha
                        break;

                    case 3:
                        //cria uma variavel com o título e matricula do usuário
                        input.nextLine();
                        System.out.print("Título do  Livro: ");
                        String tituloLivro = input.nextLine();

                        System.out.print("Matrícula do usuário: ");
                        String matriculaLivro = input.nextLine();

                        //Cria uma variavel e atribui a função que retorna o Título caso exista
                        Livro livroEmprestar = biblioteca.buscarLivro(tituloLivro);

                        //Cria uma variavel e atribui a função que retorna a matricula caso exista
                        Usuario usuarioEmprestar = biblioteca.buscarUsuario(matriculaLivro);

                        //verificação se o livro e usuario existe
                        if (livroEmprestar != null && usuarioEmprestar != null) {
                            biblioteca.emprestarLivro(livroEmprestar, usuarioEmprestar);
                        } else if (livroEmprestar == null) {
                            System.out.println("O Livro não foi encontrado.");

                        } else if (usuarioEmprestar == null) {
                            System.out.println("A matrícula não foi encontrada.");

                        }
                        break;

                    case 4:
                        //Pega os dados do livro e da matrícula do usuário que quer devolver
                        input.nextLine();
                        System.out.print("Título do  Livro: ");
                        String tituloDevolver = input.nextLine();

                        System.out.print("Matrícula do usuário: ");
                        String matriculaDevolver = input.nextLine();

                        //Verifica se o Livro e a matrícula existem
                        Livro devolvertitulo = biblioteca.buscarLivro(tituloDevolver);
                        Usuario matriculadoDevolver = biblioteca.buscarUsuario(matriculaDevolver);

                        //Verifica se existe e se o usuário não está disponivel
                        if (devolvertitulo != null && matriculaDevolver != null) {
                            biblioteca.devolverLivro(devolvertitulo, matriculadoDevolver);
                        } else if (devolvertitulo == null) {
                            System.out.println("O livro não foi encontrado.");
                        } else {
                            System.out.println("A matrícula do usuário não foi encontrado.");

                        }
                        break;


                    case 5:
                        System.out.println("==== LISTA DE LIVROS DISPONIVEL ====");
                        biblioteca.listarLivrosDisponiveis();
                        break;


                    case 6:
                        return;

                    default:
                        System.out.println("Escolha uma opção Correta!");
                        break;

                }

            } catch (Exception e) {

                System.out.println("Erro: Digite um Valor Correto!");
                break;
            }

        }
    }
}