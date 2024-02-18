package view.commands;

import view.ConsoleIO;

public class ShowAllToys extends Commands{
    public ShowAllToys(ConsoleIO consoleIO) {
        super("показать список всех игрушек", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().ShowAllToys();
    }
}
