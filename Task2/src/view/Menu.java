package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Commands> commandsList;

    public Menu(ConsoleIO consoleIO){
        commandsList = new ArrayList<>();
        commandsList.add(new ShowAllToys(consoleIO));
        commandsList.add(new AddNewToy(consoleIO));
        commandsList.add(new FindToy(consoleIO));
        commandsList.add(new Save(consoleIO));
        commandsList.add(new Load(consoleIO));
        commandsList.add(new Finish(consoleIO));
    }

    public int menuSize(){
        return commandsList.size();
    }

    public String printMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("========МЕНЮ========").append("\n");
        for (int i = 0; i < menuSize() ; i++) {
            sb.append(i + 1).append(". ").append(commandsList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }


    public void execute(int choice){
        Commands commands = commandsList.get(choice - 1);
        commands.execute();
    }




}
