package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[4];
        for (int i = 0; i < 4 ; i++) {
            byte curNetAddress = (byte) (ip[i] & mask[i]);
            netAddress[i] = curNetAddress;
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {
        for (byte bt: bytes) {
            System.out.print(convertByteToString(bt) + " ");
        }
        System.out.println();
    }

    public static String convertByteToString(byte bb){
        String s1 = String.format("%8s", Integer.toBinaryString(bb & 0xFF)).replace(' ', '0');
        return s1;
    }
}
