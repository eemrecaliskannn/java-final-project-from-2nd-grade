// Object-Oriented Programming with Java Project 
// Emre Çalýþkan 1803021054
package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	 OVERGAME.overgame();
    }
}

abstract class Urun {
    int id;
    String name;
    double price;

    public Urun() {}

    public Urun(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Game extends Urun {
    String genre;
    String developer;
	String publisher;
	

    Game(int id, String name, double price, String genre,String developer ,String publisher) {
        super(id, name, price);
        this.genre = genre;
        this.developer = developer ;
        this.publisher = publisher;
   
    }
    
}

class Console extends Urun {

    private int size;
    private String brand;
    private int storage;
    private String ram;

    public Console(int id, String name, double price, double size, String brand, String ram, int storage) {
        super();

        this.id = id;
        this.name = name;
        this.price = price;

        this.setSize(size);
        this.setBrand(brand);
        this.setStorage(storage);
        this.setRam(ram);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(double size2) {
        this.size = (int) size2;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}

class Pc extends Urun {

    private String setBrand;
    String brand;

    public Pc(int id, String name, double price, String brand) {
        super();


        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;

    }

    public String getBrand() {
        return brand;        
    }

    public void setBrand(String brand) {
        this.brand = brand;

    }

}

class OVERGAME {

    public static void overgame() {

        SEPET sepet = new SEPETImpl();      

        ArrayList < Game > games = new ArrayList < Game > (Arrays.asList(
            new Game(1, "The Last of Us part 2", 60,"Action-Advanture" ,"Naughty Dog", "Sony Interactive Entertainment"),
            new Game(2,"Red Dead Redemption 2", 60,"Action-Advanture" ,"Rockstar Games", "Rockstar Games"),
            new Game(3, "Ori and The Will of The Wisps", 40,"Platform-Metroidvania", "Moon Studios", "Xbox Games")
        ));

        ArrayList < Pc > pcs = new ArrayList < Pc > (Arrays.asList(
            new Pc(4, "Asus hx", 1000, "Asus"),
            new Pc(5, "Hp x55", 800, "Hp"),
            new Pc(6, "Casper10xii", 500, "Casper")
        ));

        ArrayList < Console > consoles = new ArrayList < Console > (Arrays.asList(
            new Console(7, "PlayStaion 5", 500, 0.5, "Sony", "16GB", 825),
            new Console(8, "Xbox Series X", 500, 0.38, "Microsoft", "16GB", 1000),
            new Console(9, "Nintendo Switch", 220, 0.15, "Nintendo", "4GB", 100)  
        ));

        ArrayList < Urun > prods = new ArrayList < Urun > ();
        prods.addAll(games);
        prods.addAll(pcs);
        prods.addAll(consoles);

        Scanner scanner = new Scanner(System.in);

        int option = -1;

        System.out.println("	 Welcome to Gameover");
        System.out.println("Select the type of product which you want to Buy ");
        System.out.println("Press 1 to see GamE Category");
        System.out.println("Press 2 to see Pc CategoRy");
        System.out.println("Press 3 to see Console Category");
        System.out.println("Press 4 to add product in the basKet");
        System.out.println("Press 5 to take ordEr");
        

        boolean found = false;

        while (option != 0) {

            option = scanner.nextInt();

            switch (option) {
            case 1:
                System.out.println("Select the game that you want to buy");
                for (Game game: games) {
                    System.out.println(game.id + " - " + game.name + " - " + game.developer + " - " + game.price+"TL" + " - " + game.publisher + " - " + game.genre );
                }

                int choice = scanner.nextInt();
                found = false;
                for (Game game: games) {
                    if (game.id == choice) {
                        sepet.add(game);
                        System.out.println("if you want to add press 4  " + game.name + "/" + game.developer + "/"+ game.publisher + ""); 
                        		
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Game not found");
                }
                break;
            case 2:
                System.out.println("Select the Pc you want to buy");
                for (Pc pc: pcs) {
                	System.out.println(pc.id + " - " + pc.name + " - " + pc.brand + " - " + pc.price+"TL");		
                }

                choice = scanner.nextInt();
                found = false;
                for (Pc pc: pcs) {
                    if (pc.id == choice) {
                        sepet.add(pc);
                        System.out.println(pc.name + " added to basket!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Pc not found");
                }
                break;
            case 3:
                System.out.println("Select the console that you want to buy");
                System.out.println("    Model      Price     Brand   Ram   Storage");
                for (Console console: consoles) {
                    System.out.println(console.id + " - " + console.name + " - " + console.price + " - " + console.getBrand() + " - " + console.getRam() + " - " + console.getStorage());
                }

                choice = scanner.nextInt();
                found = false;
                for (Console console: consoles) {
                    if (console.id == choice) {
                        sepet.add(console);
                        System.out.println(console.name +" "+ console.getRam()+"/"+console.getStorage()+" added to basket!");
                        
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Console not found");
                }
                break;
          

            case 4:
                System.out.println("Your item is added"+ " and your "+ "Total price: " + sepet.getPrice());
                break;

            case 5:
                sepet.pay();
                System.out.println("Order is taken thank you for your purchasing...");
                break;

            default:
                System.out.println("Please enter a proper product...");
            }
        }
    }
}

interface SEPET {
    void add(Urun urun);
    double getPrice();
    void pay();
}

class SEPETImpl implements SEPET {

    List < Urun > products = new ArrayList < > ();

    
    public void add(Urun urun) {
        products.add(urun);
    }
    
    public double getPrice() {
        double price = 0;

        for (Urun product: products) {
            price += product.price;
        }
        return price;
    }
    
    public void pay() {
        products.clear();
    }
}