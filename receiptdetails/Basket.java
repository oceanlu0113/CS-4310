package receiptdetails;

// class that contains items
import java.util.ArrayList;

public class Basket implements BasketInterface {

    private ArrayList<Item> list;
    private double totalAmount;
    private double totalTax;
    
    Basket() {
        this.list = new ArrayList<>();
        totalAmount = 0;
        totalTax = 0;
    }

    // setters
    @Override
    public void add(Item it) {
        list.add(it);
    }

    // getters
    private void getTotals() {
        // Note: make sure values aren't duplicated everytime this function is called
        totalAmount = 0;
        totalTax = 0;
        for (int i = 0; i < list.size(); i++) {
            totalAmount += list.get(i).getPrice();
            totalTax += list.get(i).getSalesTax();

        }
    }

    @Override
    public double getTotalAmount() {
        getTotals();
        return totalAmount;
    }

    @Override
    public double getTotalTax() {
        getTotals();
        return totalTax;
    }

    // ease in printing out receipt with printf function
    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < list.size(); i++) {
            r += list.get(i);
        }
        r += String.format("Sales Tax : %.2f", getTotalTax());
        r += String.format("\nTotal: %.2f", getTotalAmount() + getTotalTax());
        return r;
    }
}
