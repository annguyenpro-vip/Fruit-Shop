package Controller;

import Model.Fruit;
import Model.FruitList;
import View.FruitListView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 84945
 */
public class FruitShopController {

    private List<Fruit> fruitArrayList;

    private FruitList fruitList = new FruitList();

    public FruitShopController() {
    }

    public FruitShopController(List<Fruit> fruitList) {
        this.fruitArrayList = fruitList;
    }
    Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String mChon[] = {"Create Fruit",
            "View Orders",
            "Shopping (for buyer)",
            "Exit"};
        FruitListView fruitListView = new FruitListView("\nFruit Management", mChon);
        fruitListView.run();
    }

    public void addFruit() throws ParseException, IOException {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Enter Price: ");
            try {
                price = sc.nextDouble();
                validPrice = true;
            } catch (Exception e) {
                System.err.println("Invalid input. Price must be double.");
                sc.nextLine();
            }
        }
        int quantity = 0;
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.print("Enter Quantity: ");
            try {
                quantity = sc.nextInt();
                validQuantity = true;
            } catch (Exception e) {
                System.err.println("Invalid input. Quantity must be an integer.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Enter Origin: ");
        String origin = sc.nextLine();

        Fruit fruit = new Fruit(id, name, price, quantity, origin);
        //fruitList.add(fruit);
        fruitList.addFruit(fruit);
        System.err.println("Add Item success!");
    }

    public void displayFruitList() {
        System.out.println("List of Fruit:");
        System.out.printf("%-20s%-20s%-20s%-20s\n", "++Item++", "++Fruit Name++", "++Origin++", "++Price++");
        ArrayList<Fruit> temp = fruitList.getFruitArrayList();
        for (Fruit fruit : temp) {
            if (temp == null) {
                System.out.println("No found fruit");
            } else if (temp != null) {
                System.out.printf("%-20s%-20s%-20s%-20s\n", fruit.getId(), fruit.getName(), fruit.getOrigin(),
                        fruit.getPrice() + "$");
            }
        }
    }

    public void createOrder() {
        boolean cont = true;
        String idBuy;
        int buyQuantity;
        do {
            ArrayList<Fruit> temp = fruitList.getFruitArrayList();
            for (Fruit fruit : temp) {
                System.out.print("Please input id: ");
                idBuy = sc.nextLine();
                if (idBuy.equalsIgnoreCase(fruit.getId())) {
                    System.out.println("You selected: " + fruit.getName());
                    System.out.print("Please input quantity: ");
                    buyQuantity = sc.nextInt();
                    if (buyQuantity > fruit.getQuantity()) {
                        System.out.println("Product does not enough.");
                    } else {
                        System.out.println("Do you want to order now (Y/N)?");
                        String choice = sc.nextLine();
                        sc.nextLine();
                        if (choice.equalsIgnoreCase("n")) {
                            cont = true;
                        } else if ((choice.equalsIgnoreCase("y"))) {
                            cont = false;

                        }
                    }
                } else {
                    System.out.println("Product not found!");
                }
            }
        } while (cont);
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amount");
//                            double amount = buyQuantity * fruit.getPrice();
//                            System.out.printf("%-20s%-20s%-20s%-20s\n", idBuy, buyQuantity, fruit.getPrice(), amount);
//                            double total = amount++;
        System.out.println("Input your name: ");
        String cusname = sc.nextLine();
    }

    public void viewCart() {

    }
}
