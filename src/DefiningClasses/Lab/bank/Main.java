package DefiningClasses.Lab.bank;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> accounts = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] token = command.split("\\s+");
            if (token[0].equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                accounts.putIfAbsent(bankAccount.getId(), bankAccount);
                System.out.println("Account ID"+bankAccount.getId()+" created");
            }
            else if (token[0].equals("Deposit")) {
                int id = Integer.parseInt(token[1]);
                double amount = Double.parseDouble(token[2]);
                if (accounts.containsKey(id)) {
                    System.out.println("Deposited "+String.format("%.0f", amount)+" to ID" + id);
                    accounts.get(id).deposit(amount);
                }
                else System.out.println("Account does not exist");
            }
            else if (token[0].equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(token[1]));
            }
            else if (token[0].equals("GetInterest")) {
                int id = Integer.parseInt(token[1]);
                int years = Integer.parseInt(token[2]);
                if (accounts.containsKey(id)) {
                    System.out.printf("%.2f%n", accounts.get(id).getInterest(years));
                }
                else System.out.println("Account does not exist");
            }

            command = scanner.nextLine();
        }
    }
}
