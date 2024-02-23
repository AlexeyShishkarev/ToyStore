package model.store;

import java.io.Serializable;

public abstract class Goods implements Serializable, ToyItem{
    private int id;
    private String name;
    private int significance;

    public Goods(int id, String name, int significance) {
        this.id = id;
        this.name = name;
        this.significance = significance;
    }

    @Override
    public String toString() {
        return "id: " + id + "\nНаименование: " + name + "\n";
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public int getSignificance() {
        return significance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSignificance(int significance) {
        this.significance = significance;
    }
}
