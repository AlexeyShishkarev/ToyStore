package view.commands;

import view.ConsoleIO;

public class ChangeName extends Commands{
    public ChangeName(ConsoleIO consoleIO) {
        super("Изменить имя игрушки", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().changeName();
    }
}
