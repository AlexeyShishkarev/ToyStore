package view.commands;

import view.ConsoleIO;

public class SavePrize extends Commands{
    public SavePrize(ConsoleIO consoleIO) {
        super("Сохранить результат розыгрыша", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().savePrize();
    }
}
