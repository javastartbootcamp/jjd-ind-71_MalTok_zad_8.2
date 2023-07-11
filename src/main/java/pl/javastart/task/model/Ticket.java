package pl.javastart.task.model;

import pl.javastart.task.model.Address;

public class Ticket {
    public static int nextTicketNo = 1;
    public static final double SHIPPING_COST = 5;

    private String event;
    private Address eventAddress;
    private String ticketType;
    private double price;
    private double discount;
    private final int ticketNo;

    public Ticket(String event, Address eventAddress, String ticketType, double price, double discount) {
        this.event = event;
        this.eventAddress = eventAddress;
        this.ticketType = ticketType;
        this.price = price;
        this.discount = discount;
        ticketNo = nextTicketNo++;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Address getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(Address eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public String ticketInfo() {
        return event + ", miejsce imprezy:  " + eventAddress.info() + ", cena podstawowa: " + price + "zł, zniżka: "
                + discount + "%, cena finalna wyniesie " +  getTotalPrice() + "zł";
    }

    public double countDiscount() {
        return discount / 100;
    }

    public double getDiscountPrice() {
        return countDiscount() * price;
    }

    public double getTotalPrice() {
        return price - getDiscountPrice();
    }
}
