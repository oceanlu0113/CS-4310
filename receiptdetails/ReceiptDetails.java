package receiptdetails;

import java.util.Scanner;

public class ReceiptDetails {

    public static void main(String[] args) {
        // assumes all entry of data are of the following nature: #amount# #imported# #name# at #price#
        Scanner in = new Scanner(System.in);
        Basket input1 = new Basket();
        Basket input2 = new Basket();
        Basket input3 = new Basket();

        // receiving data for Input 1
        System.out.println("Input 1:");
        for (int i = 0; i < 3; i++) {
            Item item = new Item(in.nextLine());
            input1.add(item);
        }

        // receiving data for Input 2
        System.out.println("\nInput 2:");
        for (int i = 0; i < 2; i++) {
            Item item = new Item(in.nextLine());
            input2.add(item);
        }

        // receiving data for Input 3
        System.out.println("\nInput 3:");
        for (int i = 0; i < 4; i++) {
            Item item = new Item(in.nextLine());
            input3.add(item);
        }

        // printing the reciept 
        System.out.println("\nOutput 1: \n" + input1);
        System.out.println("\nOutput 2: \n" + input2);
        System.out.println("\nOutput 3: \n" + input3);
    }
}
