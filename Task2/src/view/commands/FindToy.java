package view.commands;

import view.ConsoleIO;

public class FindToy extends Commands{
    public FindToy(ConsoleIO consoleIO) {
        super("Найти игрушку", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().findToy();
    }
}
