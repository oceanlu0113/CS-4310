package receiptdetails;

// item is in charge of getting its own respective price as well as certain characteristics

public interface ItemInterface {
    
    // get amount of duplicates of an item
    public int getAmount();

    // get the name/title of the item
    public String getName();

    // get the price and cost of item
    public double getPrice();

    // get the sales tax of the item (respective to imported (0.05) and exempted goods (0.10))
    public double getSalesTax();
    
    // ease of printing receipt
    public String toString();
}
