package model.application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;
import model.services.PixService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data: ");
        System.out.print("Contract number: ");
        int contractNumber = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        String contractDate = sc.next();
        System.out.println("Contract value: ");
        double totalValue = sc.nextDouble();
        System.out.println("Enter the installment quantity: ");
        int installmentQuantity = sc.nextInt();

        Contract contract = new Contract(contractNumber, LocalDate.parse(contractDate, fmt), totalValue);
        ContractService service = new ContractService(new PaypalService());

        service.processContract(contract, installmentQuantity);

        System.out.println("Installments: ");
        for (Installment installment : contract.getInstallmentList()){
            System.out.println(installment);
        }
        sc.close();
    }
}
