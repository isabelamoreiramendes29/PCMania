package br.inatel.poo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("PC_Mania");


        Cliente cliente = new Cliente("Isabela", "12312312356");

        Computador computador1 = new Computador("Apple", 2268,
                "macOS Sequoia", 64,
                "Pentium Core i5", 2200,
                "Memoria RAM", 8,
                "HD", 500);

        Computador computador2 = new Computador("Samsung", 2269,
                "Windows 8", 64,
                "Pentium Core i7", 3370,
                "Memoria RAM", 16,
                "HD", 1000);

        Computador computador3 = new Computador("Dell", 2270,
                "Windows 10", 64,
                "Pentium Core i7", 4500,
                "Memoria RAM", 32,
                "HD", 2000);

        MemoriaUSB pendrive1 = new MemoriaUSB("Pen-drive", 16);
        MemoriaUSB pendrive2 = new MemoriaUSB("Pen-drive", 32);
        MemoriaUSB hdExterno = new MemoriaUSB("HD Externo", 1000);

        System.out.println("=== Promoção 1 ===");
        computador1.mostraPCConfigs();
        System.out.println("=== Promoção 2 ===");
        computador2.mostraPCConfigs();
        System.out.println("=== Promoção 3 ===");
        computador3.mostraPCConfigs();

        Computador[] comprados = new Computador[10];
        int qtdComprados = 0;
        int promocao = -1;
        int adicionar = 0;

        while(promocao !=0){

            System.out.println("Escolha no mínimo duas promoções: ");
            System.out.println("Promoção 1, Promoção 2, Promoção 3");

            promocao = entrada.nextInt();
            if(promocao == 0 && qtdComprados < 2){
                System.out.println("Voce precisa comprar no minimo 2 computadores!");
                promocao = -1;
            }


            switch (promocao){
            case 1:
                comprados[qtdComprados] = computador1;
                qtdComprados++;

                System.out.println("Deseja levar o Pen-drive? 1 - Sim   2 - Nao");
                adicionar = entrada.nextInt();

                if(adicionar == 1){
                    computador1.addMemoriaUSB(pendrive1);
                }
                System.out.println("Promoção 1 adicionada!");
                break;

            case 2:
                comprados[qtdComprados] = computador2;
                qtdComprados++;

                System.out.println("Deseja levar o Pen-drive? 1 - Sim   2 - Nao");
                adicionar = entrada.nextInt();

                if(adicionar == 1){
                    computador2.addMemoriaUSB(pendrive2);
                }
                System.out.println("Promoção 2 adicionada!");
                break;

            case 3:
                comprados[qtdComprados] = computador3;
                qtdComprados++;
                System.out.println("Deseja levar o Pen-drive? 1 - Sim   2 - Nao");
                adicionar = entrada.nextInt();

                if(adicionar == 1){
                    computador3.addMemoriaUSB(hdExterno);
                }
                System.out.println("Promoção 3 adicionada!");
                break;

        }
        }

        for(int i = 0; i < qtdComprados; i++){
            comprados[i].mostraPCConfigs();
        }

        cliente.comprar(comprados);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        System.out.println("Total: R$" + cliente.calculaTotalCompra());

        ProcessarPedido.enviarPedido(cliente.getComputadores());
    }
}
