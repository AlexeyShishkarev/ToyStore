package view.commands;

import view.ConsoleIO;

public class Save extends Commands{
    public Save(ConsoleIO consoleIO) {
        super("Сохранить магазин", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().save();
    }
}
