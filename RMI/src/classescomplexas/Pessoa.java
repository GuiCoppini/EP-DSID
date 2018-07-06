package classescomplexas;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private int idade;
    private double altura;
    private int nUSP;

    public Pessoa(String nome, int idade, double altura, int nUSP) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.nUSP = nUSP;
    }

    public String falaOi() {
        return "Oi, meu nome e "+nome+", de nUSP "+nUSP+" e tenho "+idade+" anos.";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
