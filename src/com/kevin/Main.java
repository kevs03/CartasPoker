package com.kevin;

import java.util.Scanner;

public class Main {

    private static Boolean isRunning;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.initPalos();
        deck.init();
        isRunning = true;

        do {
            try {
                var option = showMenu();
                if(option < 0 || option > 4){
                    throw new Exception("Opción no valida, ingresa una opcion valida");
                }
                switch (option){
                    case 1:
                        deck.shuffle();
                        break;
                    case 2:
                        deck.head();
                        break;
                    case 3:
                        deck.pick();
                        break;
                    case 4:
                        deck.hand();
                        break;
                    default:
                        isRunning = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("");
            }
        } while (isRunning);

    }
    public static int showMenu(){

        System.out.println("Bienvenido a Poker!");
        System.out.println("Seleccione una opcion:");
        System.out.println("1 Mezclar deck");
        System.out.println("2 Sacar una carta");
        System.out.println("3 Carta al azar");
        System.out.println("4 Generar una mano de 5 cartas");
        System.out.println("0 Salir");

        Scanner scanner = new Scanner(System.in);
        var option = scanner.nextInt();
        return option;
    }
}
