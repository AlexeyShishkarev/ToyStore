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
     * @param num
     * @return
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
            printAnswer("Вы ввели не число!!!");
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
        int significance = inputNumberInt("Введите значимость для розыгрыша (от 1 - самый расспространненый до " +
                "3 - самый редкий): ");
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
        String fileName = consoleInput("Введите имя файла: ") + ".txt";
        presenter.save(fileName);
    }

    private String isCorrectPath(){
        String currentPath = new File("").getAbsolutePath();
        File folder = new File(currentPath);
        File[] files = folder.listFiles();
        while (true){
            String path = consoleInput("Введите название сохраненного файла: ");
            for (File file : files){
                if (file.getName().equals(path)){
                    return path;
                }
            }
            printAnswer("Название файла введено неверно!");
            presenter.showAllSavedFiles();
        }
    }


    public void load() {
        presenter.showAllSavedFiles();
        String fileName = isCorrectPath();
        presenter.load(fileName);
        }
    }
