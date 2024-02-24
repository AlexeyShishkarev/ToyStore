package model;

import model.store.*;
import model.store.prize.LoadPrize;
import model.store.prize.PrizeDraw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

    private ToyStore toyStore;
    private int idToy;
    private ToyStoreSaveLoad toyStoreSaveLoad;
    private PrizeDraw prizeDraw;
    private LoadPrize loadPrize;

    public Service(){
        toyStore = new ToyStore();
        toyStoreSaveLoad = new ToyStoreSaveLoad();
        prizeDraw = new PrizeDraw(toyStore.getListToys());
        loadPrize = new LoadPrize();
    }

    public boolean addNewToy(String name, int significance, double price, int quantity){
        Toys toy = new Toys(idToy++, name, significance, price, quantity);
        toyStore.addToy(toy);
        return true;
    }

    public String showAllToys(){
        List<Goods> goodsList = toyStore.getListToys();
        StringBuilder sb = new StringBuilder();
        if (toyStore.getListToys().isEmpty()){
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

    public boolean save(Writable writable, String fileName) {
        writable.save(toyStore, fileName);
        return true;
    }

    public String showAllSavedFiles(String expansion){
        return toyStoreSaveLoad.showAllSavedFiles(expansion);
    }

    public boolean load(String path) {
        toyStore = (ToyStore) toyStoreSaveLoad.load(path);
        idToy = idLoad();
//        prizeDraw =new PrizeDraw(toyStore.getListToys());

        return true;
    }

    /**
     * Возвращение максимального id
     */
    private Integer idLoad(){
        if (toyStore != null){
            List<Goods> goodsList = toyStore.getListToys();
            List<Integer> idList = new ArrayList<>();
            for (Goods goods : goodsList){
                idList.add(goods.getId());
            }
            return Collections.max(idList) + 1;
        }
        return null;
    }

    public boolean isCorrectId(int choice){
        List<Goods> goodsList = toyStore.getListToys();
        for (Goods goods : goodsList){
            if (goods.getId() == choice){
                return true;
            }
        }
        return false;
    }

    public Goods findToId(int id){
        for (Goods goods : toyStore.getListToys()){
            if (goods.getId() == id){
                return goods;
            }
        }
        return null;
    }


    public boolean changeName(int choice, String name) {
        Goods goods = findToId(choice);
        goods.setName(name);
        return true;
    }

    public boolean changeSignificance(int choice, int significance) {
        Goods goods = findToId(choice);
        goods.setSignificance(significance);
        return true;
    }



    public String holdADraw() {

        return prizeDraw.conductingTheDraw();

    }

    public String showAllPrize() {
       return prizeDraw.getPrizeList();
    }

    public boolean savePrize(Writable writable, String fileName) {
        writable.save(prizeDraw, fileName);
        return true;
    }

    public boolean loadPrize(String fileName) {
//        prizeDraw = new PrizeDraw(prizeDraw.retPrizeList());
        prizeDraw = (PrizeDraw) loadPrize.load(fileName);


        return true;
    }
}
