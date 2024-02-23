package view.commands;

import view.ConsoleIO;

public class ChangeSignificance extends Commands{


    public ChangeSignificance(ConsoleIO consoleIO) {
        super("Изменить значимость", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().changeSignificance();
    }
}
