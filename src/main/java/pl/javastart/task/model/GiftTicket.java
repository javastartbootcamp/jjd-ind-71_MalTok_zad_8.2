package pl.javastart.task.model;

public class GiftTicket extends Ticket {

    public GiftTicket(String event, Address eventAddress, String ticketType, double price, double discount) {
        super(event, eventAddress, ticketType, price, discount);
    }

    @Override
    public String ticketInfo() {
        return "Bilet prezentowy: " + super.ticketInfo();
    }

    @Override
    public double getTotalPrice() {
        return super.getTotalPrice() + SHIPPING_COST + getAdditionalGiftCost();
    }

    private double getAdditionalGiftCost() {
        return super.getTotalPrice() * countDiscount();
    }
}
