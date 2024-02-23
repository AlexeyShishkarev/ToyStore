package view.commands;

import view.ConsoleIO;

public class ShowAllPrize extends Commands{
    public ShowAllPrize(ConsoleIO consoleIO) {
        super("Показать список призов", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().showAllPrize();
    }
}
