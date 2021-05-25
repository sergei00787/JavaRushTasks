package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {

    public static void main(String[] args) {
        FactoryException.getException(ApplicationExceptionMessage.UNHANDLED_EXCEPTION);
    }

    public static Class getFactoryClass() {
        return FactoryException.class;
    }
}