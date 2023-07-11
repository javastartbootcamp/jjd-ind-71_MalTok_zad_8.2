package pl.javastart.task.logic;

import pl.javastart.task.model.*;

import java.util.Scanner;

public class TicketShop {
    private static final String ONLINE_TICKET = "online";
    private static final String STANDARD_TICKET = "standard";
    private static final String GIFT_TICKET = "gift";

    private static double countTicketFinalPrice(Ticket ticket) {
        String ticketType = ticket.getTicketType();
        return switch (ticketType) {
            case ONLINE_TICKET, STANDARD_TICKET, GIFT_TICKET -> ticket.getTotalPrice();
            default -> throw new IllegalStateException("Unexpected value: " + ticketType); //podpowiedź IntelliJ
        };
    }

    public static void showTicketFinalPrice(Ticket ticket) {
        System.out.println("Finalna cena biletu: " + countTicketFinalPrice(ticket));
    }

    public static Ticket createTicket(Scanner scanner) {
        System.out.println("Podaj nazwę wydarzenia:");
        String event = scanner.nextLine();
        System.out.println("Podaj adres wydarzenia:");
        Address address = createAddress(scanner);
        System.out.println("Wybierz rodzaj biletu:");
        String ticketType = chooseTicketType(scanner);
        double price = getPrice(scanner);
        double discount = getDiscount(scanner);

        return switch (ticketType) {
            case ONLINE_TICKET -> new OnlineTicket(event, address, ticketType, price, discount);
            case STANDARD_TICKET -> new StandardTicket(event, address, ticketType, price, discount);
            case GIFT_TICKET -> new GiftTicket(event, address, ticketType, price, discount);
            default -> throw new IllegalStateException("Unexpected value: " + ticketType); //podpowiedź IntelliJ
        };
    }

    private static double getDiscount(Scanner scanner) {
        double discount;
        do {
            System.out.println("Podaj zniżkę:");
            discount = scanner.nextDouble();
            scanner.nextLine();
            if (discount <= 0) {
                System.out.println("Zniżka musi być dodatnia");
            }
        } while (discount <= 0);
        return discount;
    }

    private static double getPrice(Scanner scanner) {
        double price;
        do {
            System.out.println("Podaj cenę podstawową:");
            price = scanner.nextDouble();
            scanner.nextLine();
            if (price <= 0) {
                System.out.println("Cena musi być dodatnia");
            }
        } while (price <= 0);
        return price;
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
