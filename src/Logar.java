import exceptions.SenhaInvalidaException;

import java.util.Scanner;

public class Logar {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        try {
            System.out.println("Login: ");
            String login = read.nextLine();
            System.out.println("Senha: ");
            String senha = read.nextLine();
            if (senha.length()<8){
                throw new SenhaInvalidaException("A senha deve ter pelo menos 8 caracteres!!!");
            }
            System.out.println("Logado.");
        } catch (SenhaInvalidaException e){
            System.out.println(e.getMessage());
        }




    }
}
