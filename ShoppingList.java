import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ryantodd on 12/1/15.
 */




/**
 * Created by dev on 9/27/15.
 */
public class ShoppingList {


    public static void main(String[] args) {

        HashMap<String, Integer> pantry = new HashMap<String, Integer>();
        pantry.put("apple", 1);


        System.out.println("Please choose what option you would like to do.");
        System.out.println("Type 'add' to add something to your pantry");
        System.out.println("Type 'delete' to delete something from your pantry");
        System.out.println("Type 'edit' to adjust the items in your pantry");
        System.out.println("Type 'list' to get a list of all items that are currently in your pantry");

        Scanner user_input = new Scanner(System.in);

        String choice;
        choice = user_input.next();

        switch (choice) {

            case "add":
                System.out.println("What item would you like to add to your pantry?");
                String item = user_input.next();
                int amount = 0;
                if (!pantry.containsKey(item)) {
                    System.out.println("What is the amount that you would like to add?");
                    amount = user_input.nextInt();
                } else {
                    System.out.println("That item is already in your pantry. Please edit this item instead.");
                }


                pantry.put(item, amount);
                System.out.println("You have added " + amount +" "+  item + " to your pantry.");


            /*case "delete":

                System.out.println("What item would you like to delete?");
                item = user_input.next();

            case "edit":
                System.out.println("What item would you like to edit?");
                item = user_input.next();

            case "list":
                System.out.println("Here is a list of all of the items in your pantry!");
                for (i = 0; i < pantry.size(); i++) {

                    System.out.println(pantry.keySet());
               */
        }
    }
}





