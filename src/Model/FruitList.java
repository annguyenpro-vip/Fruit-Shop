/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author OS
 */
public class FruitList {
    private ArrayList<Fruit> fruitArrayList = new ArrayList<>();

    public FruitList() {
    }

    public ArrayList<Fruit> getFruitArrayList() {
        return fruitArrayList;
    }

    public void setFruitArrayList(ArrayList<Fruit> fruitArrayList) {
        this.fruitArrayList = fruitArrayList;
    }
    
    public void addFruit(Fruit fruit) {
        fruitArrayList.add(fruit);
    }
}
