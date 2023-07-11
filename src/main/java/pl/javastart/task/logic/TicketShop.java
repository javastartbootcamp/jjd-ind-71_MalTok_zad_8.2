package pl.javastart.task.logic;

import pl.javastart.task.model.*;

import java.util.Scanner;

public class TicketShop {
    private static final double SHIPPING_COST = 5;
    private static final String ONLINE_TICKET = "online";
    private static final String STANDARD_TICKET = "standard";
    private static final String GIFT_TICKET = "gift";

    private static double countTicketFinalPrice(Ticket ticket) {
        String ticketType = ticket.getType();
        return switch (ticketType) {
            case ONLINE_TICKET -> ticket.getTotalPrice();
            case STANDARD_TICKET -> ticket.getTotalPrice() + SHIPPING_COST;
            case GIFT_TICKET -> ticket.getTotalPrice() + SHIPPING_COST + (ticket.getDiscount() * ticket.getTotalPrice());
            default -> throw new IllegalStateException("Unexpected value: " + ticketType); //podpowiedź IntelliJ
        };
    }

    public static void showTicketFullInfo(Ticket ticket) {
        String ticketType = ticket.getType();
        String text = switch (ticketType) {
            case ONLINE_TICKET -> "Bilet internetowy:";
            case STANDARD_TICKET -> "Bilet standardowy:";
            case GIFT_TICKET -> "Bilet prezentowy:";
            default -> throw new IllegalStateException("Unexpected value: " + ticketType); //podpowiedź IntelliJ
        };

        System.out.printf("%s %s, cena finalna wyniesie %.2f zł\n ", text, ticket.ticketInfo(), countTicketFinalPrice(ticket));
    }

    public static Ticket createTicket(Scanner scanner) {
        System.out.println("Podaj nazwę wydarzenia:");
        String event = scanner.nextLine();
        System.out.println("Podaj adres wydarzenia:");
        Address address = createAddress(scanner);
        System.out.println("Wybierz rodzaj biletu:");
        String type = chooseTicketType(scanner);
        double price = getPositiveDouble(scanner, "Podaj cenę podstawową:", "Cena musi być dodatnia");
        double userDiscount = getPositiveDouble(scanner, "Podaj zniżkę:", "Zniżka musi być dodatnia");
        double discount = userDiscount / 100;

        return new Ticket(event, address, type, price, discount);
    }

    private static double getPositiveDouble(Scanner scanner, String text, String message) {
        double calculation;
        do {
            System.out.println(text);
            calculation = scanner.nextDouble();
            scanner.nextLine();
            if (calculation <= 0) {
                System.out.println(message);
            }
        } while (calculation <= 0);
        return calculation;
    }

    private static String chooseTicketType(Scanner scanner) {
        String option;
        boolean found = false;
        do {
            System.out.println("Możliwe opcje:");
            System.out.println("Bilet internetowy, wpisz: " + ONLINE_TICKET);
            System.out.println("Bilet standardowy, wpisz: " + STANDARD_TICKET);
            System.out.println("Bilet prezentowy, wpisz: " + GIFT_TICKET);

            option = scanner.nextLine();
            if (option.equals(ONLINE_TICKET) || option.equals(STANDARD_TICKET) || option.equals(GIFT_TICKET)) {
                found = true;
            }
        } while (!found);
        return option;
    }

    private static Address createAddress(Scanner scanner) {
        System.out.println("Podaj ulicę:");
        String street = scanner.nextLine();
        System.out.println("Podaj numer domu:");
        String homeNo = scanner.nextLine();
        System.out.println("Podaj kod pocztowy:");
        String zipCode = scanner.nextLine();
        System.out.println("Podaj miasto/miejscowość:");
        String city = scanner.nextLine();

        return new Address(street, homeNo, zipCode, city);
    }
}
