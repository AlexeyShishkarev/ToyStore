package model;

import model.store.*;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private ToyStore toyStore;
    private int idToy;
    private ToyStoreSaveLoad toyStoreSaveLoad;

    public Service(){
        toyStore = new ToyStore();
        toyStoreSaveLoad = new ToyStoreSaveLoad();
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


    public String findToy(String name) {
        List<Goods> toysList = toyStore.getListToys();
        StringBuilder stringBuilder = new StringBuilder();
        for (Goods goods : toysList){
            if (goods.getName().toLowerCase().contains(name.toLowerCase())){
                if(stringBuilder.isEmpty()){
                    stringBuilder.append("Список товаров с наименованием ").append(name).append(":\n\n");
                }
                stringBuilder.append(goods).append("\n");
            }

        }
        if (stringBuilder.isEmpty()) {
            return  null;
        }
        return stringBuilder.toString();
    }

    public void save(Writable writable, String fileName) {
        writable.save(toyStore, fileName);
    }

    public String showAllSavedFiles(){
        return toyStoreSaveLoad.showAllSavedFiles();
    }

    public boolean load(String path) {
        toyStore = (ToyStore) toyStoreSaveLoad.load(path);
        return true;
    }
}
