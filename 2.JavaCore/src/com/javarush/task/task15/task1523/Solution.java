package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {

    }

    public Solution(){}
    private Solution(String name){}
    protected Solution(String name, int count){}
    Solution(int count){}

}

