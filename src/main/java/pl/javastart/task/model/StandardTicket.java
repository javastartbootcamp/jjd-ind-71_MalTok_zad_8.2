package pl.javastart.task.model;

public class StandardTicket extends Ticket {
    public StandardTicket(String event, Address eventAddress, String ticketType, double price, double discount) {
        super(event, eventAddress, ticketType, price, discount);
    }

    @Override
    public String ticketInfo() {
        return "Bilet standardowy: " + super.ticketInfo();
    }

    @Override
    public double getTotalPrice() {
        return super.getTotalPrice() + SHIPPING_COST;
    }
}
