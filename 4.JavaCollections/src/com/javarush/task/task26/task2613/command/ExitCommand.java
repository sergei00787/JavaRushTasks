package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;

class ExitCommand implements Command{
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Are you ready to exit? \"y\" or \"n\"");

    }
}
