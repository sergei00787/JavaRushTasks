package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class DepositCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();

        String[] digits = ConsoleHelper.getValidTwoDigits(currencyCode);
        int denomination = Integer.parseInt(digits[0]);
        int count = Integer.parseInt(digits[1]);

        CurrencyManipulator manipulatorByCurrencyCode = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        manipulatorByCurrencyCode.addAmount(denomination, count);
    }
}
