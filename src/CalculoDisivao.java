import exceptions.divisor0exceptio;

import java.util.Scanner;

public class CalculoDisivao {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Digite o dividendo:");
        double dividendo = read.nextDouble();

        System.out.println("Digite o divisor:");
        double divisor = read.nextDouble();

        if (divisor == 0){
            throw new divisor0exceptio("Divisor não pode ser zero!!");
        }

        try{
            var resultado = dividendo / divisor;
            System.out.println("resultado = " + resultado);
        } catch (divisor0exceptio e){
            System.out.println(e.getMessage());
        }

    }
}
