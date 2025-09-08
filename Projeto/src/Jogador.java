public class Jogador {
    private String nome;
    private int creditos;

    public int getCreditos()
    {
        return creditos;
    }

    public String getNome()
    {
        return nome;
    }

    public void setCreditos (int creditos)
    {
        this.creditos = creditos;
    }

    public Jogador(String nome, int creditos)
    {
        this.nome = nome;
        this.creditos = creditos;
    }



    public void apostar(int valor, String numero_pescador)
    {
        if (creditos - valor < 0)
        {
            System.out.println("Você não tem saldo suficiente!");
        }
        else
        {
            System.out.println("Você está apostando " + valor + " no pescador " + numero_pescador);

            creditos = creditos - valor;
        }

    }
}
