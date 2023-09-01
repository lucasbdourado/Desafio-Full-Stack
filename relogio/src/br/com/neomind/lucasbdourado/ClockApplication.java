package br.com.neomind.lucasbdourado;

import java.util.Scanner;

public class ClockApplication {

    public static void main(String[] args) {
        Clock clock = new Clock();

        System.out.println("Calculadora - Angulo entre Ponteiros");
        System.out.println("------------------------------------");


        while (clock.getHour() == null || clock.getHour() > 12 ){
            System.out.println("Digite a hora desejada. Obs: 0-12");

            Scanner scanner = new Scanner(System.in);

            Integer hour = scanner.nextInt();

            clock.setHour(hour);
        }

        while (clock.getMin() == null || clock.getMin() > 60 ){
            System.out.println("Digite o minuto desejado. Obs: 0-60");

            Scanner scanner = new Scanner(System.in);

            Integer minute = scanner.nextInt();

            clock.setMin(minute);
        }

        Integer result = clock.retornaAnguloRelogio(clock.getHour(), clock.getMin());

        System.out.println("O angulo entre os dois ponteiros é: " + result);
    }
}