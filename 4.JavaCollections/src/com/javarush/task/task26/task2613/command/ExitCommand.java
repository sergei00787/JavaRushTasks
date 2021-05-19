package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class ExitCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Are you ready to exit? \"Y\" or \"N\"");
        String result = ConsoleHelper.readString();
        if (result.toUpperCase().equals("Y") && result != null) {
            ConsoleHelper.writeMessage("Good buy");
//            System.exit(0);
        } else {

        }
    }
}
