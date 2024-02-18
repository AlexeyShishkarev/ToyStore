package presenter;

import model.Service;
import view.View;

public class Presenter {

    private Service service;
    private View view;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void showAllToys(){
        view.printAnswer(service.showAllToys());

    }

    public void addNewToy(String name, int significance, double price, int quantity){
        if (service.addNewToy(name, significance, price, quantity)){
            view.printAnswer("Игрушка успешно добавлена!");
        } else{
            view.printAnswer("Игрушка не добавлена! что то пошло не так...");
        }

    }


}
