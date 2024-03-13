package co.bank;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("001");

        while(true){
            System.out.println("Oque deseja fazer? - Criar conta (C) , Sair (E)");
            String op = scanner.nextLine();

            if(op.equals("C") || op.equals("Criar Conta")){

                System.out.println("Digite o nome: ");
                String name  = scanner.nextLine();
                Accout accout = santander.generateAccout(name);
                santander.InsertAccout(accout);
                operateAccout(accout);
            }
            else if (op.equals("E")) {
                break;
            }
            else{
                System.out.println("Comando invalido, tente novamete");
            }

            List<Accout> accoutList = santander.getAccouts();

            for(Accout cc: accoutList){
                System.out.println(cc);
            }

            santander.ImprimirTotal();


        }
    }
    static void operateAccout(Accout accout){

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("Oque deseja fazer? D = Deposito , S = Saque , E = Sair da conta");
            String op = scanner.nextLine();

            if (op.equals("D") || op.equals("Deposito") || op.equals("DEPOSITO")){
                System.out.println("Qual o valor deseja depositar?");
                double value = scanner.nextDouble();
                accout.Deposito(value);

            }
            else if (op.equals("S") || op.equals("Saque")|| op.equals("SAQUE") ) {

                System.out.println("Qual valor deseja Sacar");

                double value = scanner.nextDouble();

                if(!accout.Sacar(value)) {
                    System.out.println("Não foi possivel sacar o valor de: " + value);
                }
            }
            else if (op.equals("E")) {
                break;
            }
            else{
                System.out.println("Comando invalido, tente novamete");
            }

            scanner = new Scanner(System.in);
        }
    }


}
