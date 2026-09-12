import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("PC_Mania");
        System.out.println("Escolha no mínimo duas promoções: ");
        System.out.println("Promoção 1, Promoção 2, Promoção 3");

        Cliente cliente = new Cliente();
        Computador computador1 = new Computador();
        Computador computador2 = new Computador();
        Computador computador3 = new Computador();

        computador1.setMarca("Apple");
        computador1.hb[0].setNome("Pentium Cor i5");
        computador1.hb[0].setCapacidade(2200);
        computador1.hb[1].setNome("Memoria RAM");
        computador1.hb[1].setCapacidade(8);
        computador1.hb[2].setNome("HD");
        computador1.hb[2].setCapacidade(500);
        computador1.sop.setNome("macOS Sequoia");
        computador1.sop.setTipo("64");

        computador2.setMarca("Samsung");


        int promocao = entrada.nextLine();

        switch (promocao){
            case 1:
                for(int i = 0;i<2;i++){
                    System.out.println(computador.hb[i].getNome());
                    System.out.println(computador.hb[i].getCapacidade());
                }


                break;

            case 2:

                break;

            case 3:

                break;

            case 0:
                break;
        }


    }
}
