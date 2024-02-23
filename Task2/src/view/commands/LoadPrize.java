package view.commands;

import view.ConsoleIO;

public class LoadPrize extends Commands{
    public LoadPrize(ConsoleIO consoleIO) {
        super("Загрузить результаты розыгрыша", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().loadPrize();
    }
}
