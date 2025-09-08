package Abstracao;

public class Peixe {
    private String nome;
    private int pontos;

    public String getNome() {
        return nome;
    }

    public int getPontos()
    {
        return pontos;
    }


    public Peixe (String nome, int pontos)
    {
        this.nome = nome;
        this.pontos = pontos;
    }

}
