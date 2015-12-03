import java.util.HashMap;
import java.util.Scanner;
import io.orchestrate.client.Client;
import io.orchestrate.client.KvMetadata;
import io.orchestrate.client.OrchestrateClient;
/**
 * Created by ryantodd on 12/1/15.
 */




/**
 * Created by dev on 9/27/15.
 */
public class ShoppingList {


    public static void main(String[] args) {
        String apiKey = "c6dcc957-a634-8570-86b5c5a09e28";
        OrchestrateClient orchestrateClient = new OrchestrateClient(apiKey);
        Client client = orchestrateClient;


//creating my hashmap
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

//using a switch statement to determine next steps depending on user input
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


            case "delete":

                System.out.println("What item would you like to delete?");
                item = user_input.next();
                if (pantry.containsKey(item)){
                pantry.remove(item);
                System.out.println(item + " has been removed from your pantry.");
                }else{
                System.out.println("That item does not exist in your pantry.");
                }

            case "edit":
                System.out.println("What item would you like to edit?");
                item = user_input.next();

                if(!pantry.containsKey(item)){
                System.out.println("That item does not exist in your pantry.");
                }else{
                System.out.println("What is the amount that you would like to change to?");
                amount = user_input.nextInt();
                pantry.put(item,amount);
                    System.out.println("You have changed " + item + " to the amount of " + amount);
                }

            case "list":
                System.out.println("Here is a list of all of the items in your pantry!");
                for (String key : pantry.keySet()){
                    System.out.println(key + ": " + pantry.get(key));
                }




        }
    }
}





