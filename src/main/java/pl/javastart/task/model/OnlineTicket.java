package pl.javastart.task.model;

public class OnlineTicket extends Ticket {

    public OnlineTicket(String event, Address eventAddress, String ticketType, double price, double discount) {
        super(event, eventAddress, ticketType, price, discount);
    }

    @Override
    public String ticketInfo() {
        return "Bilet internetowy: " + super.ticketInfo();
    }

    @Override
    public double getTotalPrice() {
        return super.getTotalPrice();
    }

}
