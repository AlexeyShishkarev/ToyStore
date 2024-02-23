package view.commands;

import view.ConsoleIO;

public class HoldADraw extends Commands{
    public HoldADraw(ConsoleIO consoleIO) {
        super("Провести розыгрышь", consoleIO);
    }

    @Override
    public void execute() {
        getConsoleIO().holdADraw();
    }
}
