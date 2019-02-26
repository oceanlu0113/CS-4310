package receiptdetails;

// class that contains nature of item
public class Item implements ItemInterface {

    private int amount;
    private String name;
    private double price;
    private boolean imported;
    private boolean exemptedGoods; // goods that are books, foods, medical prodcuts (exempted from basic sales tax)  
    private static final double NONEXEMPTTAX = 0.10;
    private static final double IMPORTEDTAX = 0.05;

    // default constructor
    Item() {
        amount = 0;
        name = "";
        price = 0;
        imported = false;
        exemptedGoods = false;
    }

    // setters
    Item(String s) {
        //assumes all entry of data are of the following nature: #amount# #imported# #name# at #price#
        // #amount# is from 0-9; #name# is after #amount# until "at "; #price# is after "at "
        amount = Integer.parseInt(s.substring(0, 1));
        name = s.substring(2, s.indexOf("at ")).trim();
        price = amount * (Double.parseDouble(s.substring(s.indexOf("at ") + 3)));

        // identify import duty
        if (s.contains("imported")) {
            imported = true;
        } else {
            imported = false;
        }

        // books, food, and medical products that are exempt
        if (s.contains("book") || s.contains("pill") || s.contains("chocolate")) {
            exemptedGoods = true;
        } else {
            exemptedGoods = false;
        }
    }

    // getters
    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getSalesTax() {
        double salesTax;
        double importTax;

        /**
         * Import duty is an additional sales tax applicable on all imported
         * goods at a rate of 5%, with no exemptions
         */
        if (imported) {
            importTax = round(IMPORTEDTAX * price);
        } else {
            importTax = 0;
        }

        /**
         * Basic sales tax is applicable at a rate of 10% on all goods, except
         * books, food, and medical products that are exempt.
         */
        if (exemptedGoods) {
            salesTax = 0;
        } else {
            salesTax = round(NONEXEMPTTAX * price);
        }
        return salesTax + importTax;
    }

    // round off function
    private double round(double amount) {
        return (double) Math.ceil(amount / 0.05d) * 0.05d;
    }

    // ease of printing receipt
    @Override
    public String toString() {
        return String.format(getAmount() + " " + getName() + ": %.2f\n", getPrice());
    }
}
