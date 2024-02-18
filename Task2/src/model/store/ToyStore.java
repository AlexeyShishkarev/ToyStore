package model.store;

import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Goods> listToys;

    public ToyStore(List<Goods> listToys){
        this.listToys = listToys;
    }

    public ToyStore(){
        this(new ArrayList<>());
    }

    public void addToy(Toys toy){
        listToys.add(toy);
    }

    public List<Goods> getListToys() {
        return listToys;
    }
}
