package model;

import model.store.Goods;
import model.store.ToyStore;
import model.store.Toys;

import java.util.List;

public class Service {

    private ToyStore toyStore;
    private int idToy;

    public Service(){
        toyStore = new ToyStore();
    }

    public boolean addNewToy(String name, int significance, double price, int quantity){
        Toys toy = new Toys(idToy++, name, significance, price, quantity);
        toyStore.addToy(toy);
        return true;
    }

    public String showAllToys(){
        List<Goods> goodsList = toyStore.getListToys();
        StringBuilder sb = new StringBuilder();
        if (toyStore.getListToys().size() == 0){
            return "Список пуст!";
        } else{
            sb.append("\nСписок всех игрушек: ").append("\n");
            for (Goods toys : goodsList){
                sb.append(toys).append("\n");
            }
        }
        return sb.toString();
    }


}
