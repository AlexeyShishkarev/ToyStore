package view.commands;

import view.ConsoleIO;

public class ShowAllToys extends Commands{
    public ShowAllToys(ConsoleIO consoleIO) {
        super("Показать список всех игрушек", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().ShowAllToys();
    }
}
