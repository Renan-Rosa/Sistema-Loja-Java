package model;


public class Cliente {
    private static int count = 1;

    private int id;
    private String nome;
    private int CPFCli;

    public Cliente(String nome, int CPFCli){
        this.id = count;
        this.nome = nome;
        this.CPFCli = CPFCli;
        Cliente.count += 1;
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
    public int getCPFCli() {
        return CPFCli;
    }

    public void setCPFCli(int CPFCli) {
        this.CPFCli = CPFCli;
    }

    public String toString() {
        return "Id: " + this.getId() +
                "\nNome(Razão social): " + this.getNome() +
                "\nCPF: " + this.getCPFCli();
    }
}
