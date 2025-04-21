package model;

public class Usuario {
    //Atributos
    private String nome;
    private String email;
    private String matricula;

    //Metodo Construtor
    public Usuario(String nome, String email, String matricula) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
    }

    //Metodos Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}