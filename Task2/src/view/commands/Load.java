package view.commands;

import view.ConsoleIO;

public class Load extends Commands{
    public Load(ConsoleIO consoleIO) {
        super("Загрузить", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().load();
    }
}
