package view.commands;

import view.ConsoleIO;

public abstract class Commands implements ICommand {

    private String description;
    private ConsoleIO consoleIO;

    public Commands(String description, ConsoleIO consoleIO){
        this.description = description;
        this.consoleIO = consoleIO;
    }

    public ConsoleIO getConsoleIO() {
        return consoleIO;
    }

    public String getDescription() {
        return description;
    }


}
