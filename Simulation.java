import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    ArrayList<Item> loadItems(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner items = new Scanner(file);
        ArrayList<Item> itemList = new ArrayList<>();
        while (items.hasNextLine()) {
            Item item = new Item();
            String line = items.nextLine();
            item.name = line.split("=")[0];
            item.weight = Integer.parseInt(line.split("=")[1]);
            itemList.add(item);
        }
        return itemList;
    }
    ArrayList<Item> beginPhase1() throws FileNotFoundException {
        String file="phase-1.txt";
        return loadItems(file);
    }
    ArrayList<Item> beginPhase2() throws FileNotFoundException {
        String file="phase-2.txt";
        return loadItems(file);
    }
    ArrayList<Rocket> loadU1(ArrayList<Item> itemList) {
        ArrayList<Rocket> u1List= new ArrayList<>();
        Rocket newU1 = new U1();
        for(Item item: itemList) {
            if(newU1.canCarry(item)) {
                newU1.carry(item);
            }
            else {
                u1List.add(newU1);
                newU1 = new U1();
            }
        }
        return u1List;
    }
    ArrayList<Rocket> loadU2(ArrayList<Item> itemList) {
        ArrayList<Rocket> u2List = new ArrayList<>();
        Rocket newU2 = new U2();
        for(Item item: itemList) {
            if(newU2.canCarry(item)) {
                newU2.carry(item);
            }
            else {
                u2List.add(newU2);
                newU2 = new U2();
            }
        }
        return u2List;
    }
    double runSimulation(ArrayList<Rocket> rocketList) {
        double totalCost = 0;
        for(Rocket rocket: rocketList) {
            totalCost+=rocket.cost;
            while(!rocket.launch() || !rocket.land()) {
                totalCost+=rocket.cost;
            }
        }
        return totalCost;
    }
}
