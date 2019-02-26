package receiptdetails;

// basket contains

public interface BasketInterface {

    // adds item into basket
    public void add(Item it);

    // adds up total amount from items in basket
    public double getTotalAmount();

    // adds up total tax amount from items in basket
    public double getTotalTax();

    // ease of printing receipt
    public String toString();
}
