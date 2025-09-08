import Abstracao.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Jogador j1 = new Jogador("Jonas", 1000);

        Peixe p1 = new Peixe("Tilápia", 10);
        Peixe p2 = new Peixe ("Sardinha", 5);
        Peixe p3 = new Peixe ("Atum", 100);
        Peixe p4 = new Peixe ("Salmão", 200);
        ArrayList<Peixe> peixes = new ArrayList<>();
        peixes.add(p1);
        peixes.add(p2);
        peixes.add(p3);
        peixes.add(p4);


        Pescador a1 = new Pescador("Joao", 0);
        Pescador a2 = new Pescador ("Jeremias", 0);
        Pescador a3 = new Pescador("Buiu", 0);

        a1.setPeixes(peixes);
        a2.setPeixes(peixes);
        a3.setPeixes(peixes);
        int x = 1;

        ArrayList<Pescador> pescadores = new ArrayList<>();
        pescadores.add(a1);
        pescadores.add(a2);
        pescadores.add(a3);

        String pescador = "";
        int valor = 0;
        while(x == 1)
        {
            System.out.println("Escolha quanto quer apostar e um pescador para você apostar, jogador " + j1.getNome() + "      CREDITOS: " + j1.getCreditos());
            for (int i = 0; i < pescadores.size(); i++)
            {
                System.out.println("PESCADOR " + pescadores.get(i).getNome());
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Entre com sua aposta");
            valor = sc.nextInt();
            System.out.println("Entre com o nome do pescador");
            pescador = sc.next();
            j1.apostar(valor, pescador);

            Thread t1 = new Thread(a1);
            t1.start();
            Thread t2 = new Thread(a2);
            t2.start();
            Thread t3 = new Thread(a3);
            t3.start();

            try {
                t1.join(); // Wait for thread1 to finish
                t2.join(); // Wait for thread2 to finish
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("PONTUAÇÃO FINAL: ");

            Collections.sort(pescadores);
            for (int i = 0; i < pescadores.size(); i++)
                System.out.println(pescadores.get(i).getNome() + " " + pescadores.get(i).getPontuacao());

            if (pescadores.get(0).getNome().compareTo(pescador)==0)
            {
                System.out.println("Você ganhou a aposta! ");
                j1.setCreditos(j1.getCreditos()+valor*2);
            }
            else
            {
                System.out.println("Que pena! Você perdeu a aposta!");
            }


            System.out.println("Quer continuar? Nº de créditos: " + j1.getCreditos() + "\n(1) SIM (2) NAO");
            x = sc.nextInt();
        }


        System.out.println("Seu crédito final é: " + j1.getCreditos());


    }
}
