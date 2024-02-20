package presenter;

import model.Service;
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


    public void findToy(String name) {
        if (service.findToy(name) == null){
            view.printAnswer("Товар с наименованием " + name + " не найден!!!");
        } else {
            view.printAnswer(service.findToy(name));
        }

    }

    public void save(String fileName) {
        service.save(toyStoreSaveLoad, fileName);
    }

    public void showAllSavedFiles(){
        if (service.showAllSavedFiles() == null){
            view.printAnswer("Нет сохраненных файлов!");
        } else {
            view.printAnswer(service.showAllSavedFiles());
        }

    }

    public void load(String path) {
        if(service.load(path)){
            view.printAnswer("Магазин успешно загружен!");
        } else {
            view.printAnswer("Магазин не загружен...");
        }
    }
}
