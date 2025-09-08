package Abstracao;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Pescador implements Runnable, Comparable<Pescador> {
    private String nome;
    private int pontuacao;
    private int aposta;
    private ArrayList<Peixe> peixes = new ArrayList<>();

    public void setPeixes(ArrayList peixes)
    {
        this.peixes = peixes;
    }

    public String getNome()
    {
        return nome;
    }

    public int getPontuacao()
    {
        return pontuacao;
    }

    public Pescador(String nome, int pontuacao){
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public void pescar(Peixe peixe)
    {
        System.out.println(nome + " pescou um peixe! " + peixe.getNome() + " com pontuacao de " + peixe.getPontos());
        pontuacao += peixe.getPontos();

    }

    @Override
    public void run() {
        long timeInicial = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        long timeFinal = 0;


        while (timeFinal - timeInicial < 10) {
            Random rand = new Random();
            int x = rand.nextInt(0, (peixes.size() - 1));
            pescar(peixes.get(x));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            timeFinal = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }
    }

    @Override
    public int compareTo(Pescador o) {
        if (this.pontuacao > o.pontuacao)
            return -1;
        else if (this.pontuacao < o.pontuacao)
            return 1;
        else
            return 0;
    }

}
