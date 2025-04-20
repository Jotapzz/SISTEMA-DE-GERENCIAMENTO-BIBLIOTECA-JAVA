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
                        //Pega o dados do livro e armazena na variavel
                        System.out.print("Nome: ");
                        String nome = input.next();
                        System.out.print("Email: ");
                        String email = input.next();
                        System.out.print("Matricula: ");
                        String matricula = input.next();

                        //Instancia usuario pela Classe Usuario e coloca os parâmetros que o usuário digitou
                        Usuario usuario = new Usuario(nome, email, matricula);
                        biblioteca.cadastrarUsuario(usuario);
                        System.out.println("Cadastrado com sucesso!");
                        break;

                    case 2:
                        //Pega o dados do livro e armazena na variavel
                        System.out.print("Titulo: ");
                        String titulo = input.next();
                        input.nextLine();
                        System.out.print("Autor: ");
                        String autor = input.nextLine();

                        //Instancia livro pela Classe Livro e coloca os parâmetros que o usuário digitou
                        Livro livro = new Livro(titulo, autor);
                        biblioteca.cadastrarLivro(livro); //chama a função e coloca o objeto livro como parâmetro
                        break;

                    case 3:
                        //cria uma variavel com o título e matricula do usuário
                        System.out.print("Título do  Livro: ");
                        String tituloLivro = input.next();
                        input.nextLine();
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
                            System.out.println("O Livro não encontrado.");

                        } else if (usuarioEmprestar == null) {
                            System.out.println("A matrícula não foi encontrada.");

                        }
                        break;
                }



            } catch (NullPointerException e) {
                System.out.println("Erro: Digite um Valor Correto!");
                return;
            }



        }
    }
}