package pl.javastart.task.app;

import pl.javastart.task.logic.TicketShop;
import pl.javastart.task.model.Ticket;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        Address address = new Address("Mieczysława Karłowicza", "28", "71-899", "Szczecin");
//        OnlineTicket onlineTicket = new OnlineTicket("Koncert zespołu Metallica", address, "online", 100, 5);
//        StandardTicket standardTicket = new StandardTicket("Koncert zespołu Metallica", address, "standard", 100, 5);
//        GiftTicket giftTicket = new GiftTicket("Koncert zespołu Metallica", address, "gift", 100, 5);
//        System.out.println(onlineTicket.ticketInfo());
//        System.out.println(standardTicket.ticketInfo());
//        System.out.println(giftTicket.ticketInfo());

        Ticket ticket1 = TicketShop.createTicket(scanner);
        TicketShop.showTicketFullInfo(ticket1);

        Ticket ticket2 = TicketShop.createTicket(scanner);
        TicketShop.showTicketFullInfo(ticket2);

    }
}
