package presenter;

import model.Service;
import model.store.Goods;
import model.store.ToyStoreSaveLoad;
import view.View;

public class Presenter {

    private Service service;
    private View view;
    private ToyStoreSaveLoad toyStoreSaveLoad;

    public Presenter(View view){
        this.view = view;
        service = new Service();
        toyStoreSaveLoad = new ToyStoreSaveLoad();
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

    public boolean containsToy(String name){
        if (service.findToy(name) == null){
            view.printAnswer("Товар с наименованием " + name + " не найден!!!");
            return false;
        } else {
            return true;
        }
    }

    public void findToy(String name) {
        if (service.findToy(name) == null){
            view.printAnswer("Товар с наименованием " + name + " не найден!!!");
        } else {
            view.printAnswer(service.findToy(name));
        }

    }

    public void save(String fileName) {
        if (service.save(toyStoreSaveLoad, fileName)){
            view.printAnswer("Файл успешно сохранен!");
        }
    }

    public boolean showAllSavedFiles(String expansion){
        if (service.showAllSavedFiles(expansion) == null){
            view.printAnswer("Нет сохраненных файлов!");
            return false;

        } else {
            view.printAnswer(service.showAllSavedFiles(expansion));
            return true;
        }

    }

    public void load(String path) {
        if(service.load(path)){
            view.printAnswer("Магазин успешно загружен!");
        } else {
            view.printAnswer("Магазин не загружен...");
        }
    }


    public boolean isCorrectId(int choice) {
        if (!service.isCorrectId(choice)){
            view.printAnswer("Выбран неверный id!!!");
            return false;
        }
        return true;
    }

    public void changeName(int choice, String name){
        if(service.changeName(choice, name)){
            view.printAnswer("Имя успешно изменено!");
        }
    }

    public void changeSignificance(int choice, int significance) {

        if(service.changeSignificance(choice, significance)){
            view.printAnswer("Значение успешно изменено!");
        }

    }


    public void holdADraw() {
        String prize = service.holdADraw();
        if (prize == null){
            view.printAnswer("Кончились игрушки для розыгрыша(((");
        } else {
            view.printAnswer("Вы выиграли: " + prize);
        }
    }

    public void showAllPrize() {
        view.printAnswer(service.showAllPrize());
        }

    public void savePrize(String fileName) {
        if (service.savePrize(toyStoreSaveLoad, fileName)){
            view.printAnswer("Результат розыгрыша успешно сохранен!");
        }
    }

    public void loadPrize(String fileName) {
            if(service.loadPrize(fileName)){
                view.printAnswer("Магазин успешно загружен!");
            } else {
                view.printAnswer("Магазин не загружен...");
            }
        }
    }

