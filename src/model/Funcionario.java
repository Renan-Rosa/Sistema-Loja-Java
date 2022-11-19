package model;


public class Funcionario {
    private static int count = 1;

    private int id;
    private String nome;
    private int CPFFunc;

    public Funcionario(String nome, int CPFFunc){
        this.id = count;
        this.nome = nome;
        this.CPFFunc = CPFFunc;
        Funcionario.count += 1;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCPFFunc() { return CPFFunc;}

    public void setCPFFunc(int CPFFunc) {
        this.CPFFunc = CPFFunc;
    }

    public String toString() {
        return "Id: " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCPFFunc();
    }

}
