package model.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToyStore implements Serializable {
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
