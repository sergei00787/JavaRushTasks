package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/

public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.YieldRunnable yieldRunnable = new Solution.YieldRunnable(1);
        Thread thread = new Thread(yieldRunnable);
        Solution.YieldRunnable yieldRunnable2 = new Solution.YieldRunnable(2);
        Thread thread2 = new Thread(yieldRunnable2);
        Solution.YieldRunnable yieldRunnable3 = new Solution.YieldRunnable(3);
        Thread thread3 = new Thread(yieldRunnable3);
        Solution.YieldRunnable yieldRunnable4 = new Solution.YieldRunnable(4);
        Thread thread4 = new Thread(yieldRunnable4);
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
