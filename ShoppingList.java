import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import io.orchestrate.client.KvMetadata;
import io.orchestrate.client.OrchestrateClient;

import javax.xml.crypto.KeySelectorException;
/**
 * Created by ryantodd on 12/1/15.
 */




/**
 * Created by dev on 9/27/15.
 */
public class ShoppingList {

    private static String apiKey = "c3672b0c-b96c-4145-8b75-bd6895b5458e";
    private static OrchestrateClient client = new OrchestrateClient(apiKey);
    private static HashMap<String, Integer> pantry = new HashMap<String, Integer>();

    public static Scanner user_input = new Scanner(System.in);


    public static void main(String[] args) {






//creating my hashmap


        pantry.put("apple", 1);

        System.out.println("Please choose what option you would like to do.");
        System.out.println("Type 'add' to add something to your pantry");
        System.out.println("Type 'delete' to delete something from your pantry");
        System.out.println("Type 'edit' to adjust the items in your pantry");
        System.out.println("Type 'list' to get a list of all items that are currently in your pantry");



        String choice;
        choice = user_input.next();

//using a switch statement to determine next steps depending on user input
        switch (choice) {

            case "add":
                addItem();
                break;

            case "delete":
                deleteItem();
                break;

            case "edit":
                editItem();
                break;

            case "list":
                listItem();
                break;


        }
    }
    public static void addItem(){

        System.out.println("What item would you like to add to your pantry?");
        String item = user_input.next();
        int amount = 0;
        if (!pantry.containsKey(item)) {
            System.out.println("What is the amount that you would like to add?");
            amount = user_input.nextInt();
        } else {
            System.out.println("That item is already in your pantry. Please edit this item instead.");
        }

        {
        try {

            PantryItem pantryItem = new PantryItem(item,amount);

            KvMetadata kvMetadata = client.postValue("pantry", pantryItem).get();

            System.out.println(kvMetadata.getKey());

        } catch (IOException e) {

            e.printStackTrace();

        }
        System.out.println("You have added " + amount +" "+  item + " to your pantry.");
    }
    }

    public static void deleteItem(){

        System.out.println("What item would you like to delete?");
        String item = user_input.next();
        if (pantry.containsKey(item)){
            pantry.remove(item);
            System.out.println(item + " has been removed from your pantry.");
        }else{
            System.out.println("That item does not exist in your pantry.");
        }
    }

    public static void editItem() {
        System.out.println("What item would you like to edit?");
        String item = user_input.next();

        if (!pantry.containsKey(item)) {
            System.out.println("That item does not exist in your pantry.");
        } else {
            System.out.println("What is the amount that you would like to change to?");
            int amount = user_input.nextInt();
            pantry.put(item, amount);
            System.out.println("You have changed " + item + " to the amount of " + amount);
        }
    }

    public static void listItem(){
        System.out.println("Here is a list of all of the items in your pantry!");
        for (String key : pantry.keySet()) {
            System.out.println(key + ": " + pantry.get(key));
        }

    }
}





