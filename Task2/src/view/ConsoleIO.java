package view;

import com.sun.source.tree.WhileLoopTree;
import presenter.Presenter;

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

    public boolean isNumeric(String num){
        int number;
        try {
            number = Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public String consoleInput(String message){
        printAnswer(message);
        return scanner.nextLine();
    }

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

    public void addNewToy(){
        String name = consoleInput("Введите название игрушки: ");
        double price = inputNumberDouble("Введите цену игрушки: ");
        int significance = inputNumberInt("Введите значимость для розыгрыша (от 1 до 3): ");
        int quantity = inputNumberInt("Введите количество игрушек: ");

        presenter.addNewToy(name, significance, price, quantity);

    }


}
