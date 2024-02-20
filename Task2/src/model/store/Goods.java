package model.store;

import java.io.Serializable;

public class Goods implements Serializable {
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
}
