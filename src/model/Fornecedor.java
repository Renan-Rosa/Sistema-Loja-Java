package model;

public class Fornecedor {
    private static int count = 1;

    private int id;
    private String nome;
    private int CNPJ;

    public Fornecedor(String nome, int CNPJ){
        this.id = count;
        this.nome = nome;
        this.CNPJ = CNPJ;
        Fornecedor.count += 1;
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
    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int CNPJ) { this.CNPJ = CNPJ;}

    public String toString() {
        return "Id: " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nCNPJ: " + this.getCNPJ();
    }

}
