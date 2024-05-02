package edu.hneu.mjt.kuznecsemen;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInterface {
    private final Service service;
    private final Bank bank;
    private final Scanner scanner;

    public ConsoleInterface(Service service, Bank bank) {
        this.service = service;
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Subscribe to a bank card");
            System.out.println("2. Get subscription by bank card number");
            System.out.println("3. Get all users");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    subscribeToBankCard();
                    break;
                case 2:
                    getSubscriptionByBankCardNumber();
                    break;
                case 3:
                    getAllUsers();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void subscribeToBankCard() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter your birthday (yyyy-mm-dd): ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine());

        User user = new User(name, surname, birthday);

        System.out.println("Choose card type:");
        System.out.println("1. Credit");
        System.out.println("2. Debit");
        System.out.print("Enter your choice: ");
        int cardTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        BankCardType cardType = cardTypeChoice == 1 ? BankCardType.CREDIT : BankCardType.DEBIT;

        BankCard bankCard = bank.createBankCard(user, cardType);
        service.subscribe(bankCard);
        System.out.println("Subscribed successfully! Your bank card is " + bankCard.number());
    }

    private void getSubscriptionByBankCardNumber() {
        System.out.print("Enter bank card number: ");
        String cardNumber = scanner.nextLine();
        Optional<Subscription> subscription = service.getSubscriptionByBankCardNumber(cardNumber);
        if (subscription.isPresent()) {
            System.out.println("Subscription found:");
            System.out.println(subscription.get());
        } else {
            System.out.println("No subscription found for the provided bank card number.");
        }
    }

    private void getAllUsers() {
        List<User> users = service.getAllUsers();
        if (!users.isEmpty()) {
            System.out.printf("All users:%s\n", users
                    .stream()
                    .map(u -> "%s %s".formatted(u.name(), u.surname())).collect(Collectors.joining(", ")));
        } else {
            System.out.println("No users found.");
        }
    }

    public static void main(String[] args) {
        ConsoleInterface consoleInterface = new ConsoleInterface(new ServiceImpl(), new BankImpl());
        consoleInterface.start();
    }
}
