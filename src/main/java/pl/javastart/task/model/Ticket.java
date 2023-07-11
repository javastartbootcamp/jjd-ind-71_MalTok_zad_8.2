package pl.javastart.task.model;

public class Ticket {
    public static int nextNumber = 1;

    private String event;
    private Address eventAddress;
    private String type;
    private double price;
    private double discount;
    private final int number;

    public Ticket(String event, Address eventAddress, String type, double price, double discount) {
        this.event = event;
        this.eventAddress = eventAddress;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.number = nextNumber++;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getNumber() {
        return number;
    }

    public String ticketInfo() {
        return event + ", miejsce imprezy:  " + eventAddress.info() + ", cena podstawowa: " + price + "zł, zniżka: "
                + (discount * 100) + "%";
    }

    private double getDiscountPrice() {
        return discount * price;
    }

    public double getTotalPrice() {
        return price - getDiscountPrice();
    }
}
