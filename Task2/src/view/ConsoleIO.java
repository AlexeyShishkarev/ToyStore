package view;

import com.sun.source.tree.WhileLoopTree;
import presenter.Presenter;

import java.io.File;
import java.util.Scanner;

public class ConsoleIO implements View{
    private boolean work;
    private Presenter presenter;
    private Menu menu;
    private Scanner scanner;

    public ConsoleIO(){
        presenter = new Presenter(this);
        menu = new Menu(this);
        scanner = new Scanner(System.in);
        work = true;
    }



    @Override
    public void start() {
        printAnswer("Добро пожаловать!");
            while(work){
            printAnswer(menu.printMenu());
            int choice = inputChoice();
            menu.execute(choice);

        }
    }

    @Override
    public void printAnswer(String message) {
        System.out.println(message);
    }


    /**
     * Считываем с консоли ввод и если он удовлетворяет нашим условиям - передаем число
     * @return
     */
    public int inputChoice(){
        int choice;
        while (true){
            String str = consoleInput("Выберите действие: ");
            if (isNumeric(str)){
                choice = Integer.parseInt(str);
                if (choice > 0 && choice <= menu.menuSize()){
                    return choice;
                } else {
                    printAnswer("Команда должна быть от 1 до " + menu.menuSize() + "!!!");
                }
            }
        }
    }

    /**
     * Проверка является ли введенное значение числом
     */
    public boolean isNumeric(String num){
        int number;
        try {
            number = Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e){
            printAnswer("Вы ввели не число!");
            return false;
        }
    }

    /**
     * Считывание с консоли ввода с выводом информации пользователю
     * @param message
     * @return
     */
    public String consoleInput(String message){
        printAnswer(message);
        return scanner.nextLine();
    }

    /**
     * Проверка является ли введенное число double
     * @param message
     * @return
     */
    public double inputNumberDouble(String message){

        double number;
        while (true){
            String str = consoleInput(message);
            if (isNumeric(str)){
                number = Double.parseDouble(str);
                return number;
            }
            printAnswer("Вы ввели не число!!!");
                    }
    }

    public int inputNumberInt(String message){
        int number;
        while (true){
            String str = consoleInput(message);
            if (isNumeric(str)){
                number = Integer.parseInt(str);
                return number;
            }
        }

    }

    public void ShowAllToys(){
        presenter.showAllToys();
    }


    /**
     * Считываем с консоли все данные необходимы для добавления новой игрушки и пробрасываем их в presenter
     */
    public void addNewToy(){
        String name = consoleInput("Введите название игрушки: ");
        double price = inputNumberDouble("Введите цену игрушки: ");
        int significance = inputNumberInt("Введите значимость для розыгрыша (от 1 - самый редкий до " +
                "3 - самый частый): ");
        int quantity = inputNumberInt("Введите количество игрушек: ");

        presenter.addNewToy(name, significance, price, quantity);

    }


    public void finish() {
        printAnswer("До новый встреч!!!");
        work = false;
    }

    public void findToy() {
        String name = consoleInput("Введите название игрушки для поиска: ");
        presenter.findToy(name);
    }

    public void save(){
        String fileName = consoleInput("Введите имя файла: ") + ".mg";
        presenter.save(fileName);
    }

    private String isCorrectPath(){
        String currentPath = new File("").getAbsolutePath();
        File folder = new File(currentPath);
        File[] files = folder.listFiles();
        while (true){
            String path = consoleInput("Введите название сохраненного файла: ");
            assert files != null;
            for (File file : files){
                if (file.getName().equals(path)){
                    return path;
                }
            }
            printAnswer("Название файла введено неверно!");
//            presenter.showAllSavedFiles();
        }
    }


    public void load() {
        if(presenter.showAllSavedFiles("mg")){
            String fileName = isCorrectPath();
            presenter.load(fileName);
        }
    }

    public void changeName(){
        presenter.findToy(isCorrectName());
        int choice = isCorrectId();
        String name = consoleInput("Введите новое имя: ");
        presenter.changeName(choice, name);

    }


    /**
     * Проверка корректности введенного веса для розыгрыша
     */
    private int isCorrectSignificance(){
        while (true){
            int significance = inputNumberInt("Введите новое значение: ");
            if (significance > 0 && significance < 4){
                return significance;
            } else {
                printAnswer("Значение должно быть от 1 - самый расспространненый до \" +\n" +
                        "\"3 - самый редкий) ");
            }
        }
    }

    public void changeSignificance(){
        presenter.findToy(isCorrectName());
        int choice = isCorrectId();
        int significance = isCorrectSignificance();
        presenter.changeSignificance(choice, significance);
    }

    /**
     * Проверка, что введнный id есть в списке игрушек
     */
    private int isCorrectId(){

        while (true){
            int choice = inputNumberInt("Введите id для изменения: ");
            if (presenter.isCorrectId(choice)){
                return choice;
            }
        }

    }

    public void savePrize(){
        presenter.savePrize(consoleInput("Введите имя файла для сохранения результатов розыгрыша: ") + ".pr");
    }



    /**
     * Проверка, что товар с таким именем и правда существует.
     */
    private String isCorrectName(){
        while (true){
            String name = consoleInput("Введите название для поиска: ");
            if (presenter.containsToy(name)){
                return name;
            }
        }
    }

    public void holdADraw(){
        presenter.holdADraw();
    }

    public void showAllPrize(){
        presenter.showAllPrize();
    }

    public void loadPrize() {
        if(presenter.showAllSavedFiles("pr")){
            String fileName = isCorrectPath();
            presenter.loadPrize(fileName);
        }
    }

}
