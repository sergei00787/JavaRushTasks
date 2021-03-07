package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(byteArrayOutputStream.toByteArray());
		byte[] digest = md.digest();
		
		StringBuffer hexString = new StringBuffer();
		for (int i = 0;i<digest.length;i++) {
			hexString.append(String.format("%02x", digest[i] & 0xff));
		}

		return hexString.toString().equals(md5);
    }
}
