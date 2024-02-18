package view.commands;

import view.ConsoleIO;

public class AddNewToy extends Commands{
    public AddNewToy(ConsoleIO consoleIO) {
        super("Добавить новую игрушку", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().addNewToy();
    }
}
