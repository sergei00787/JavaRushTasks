package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){

        Date startTimestamp = new Date();
        for (String str: strings) {
            ids.add(shortener.getId(str));
        }
        Date endTimestamp = new Date();
        long time = endTimestamp.getTime() - startTimestamp.getTime();
        return time;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date startTimestamp = new Date();
        for (Long num: ids) {
            strings.add(shortener.getString(num));
        }
        Date endTimestamp = new Date();
        long time = endTimestamp.getTime() - startTimestamp.getTime();
        return time;
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        Set<Long> resultSetLong = new HashSet<>();

        for (int i = 0; i < 10000; ++i) {
            origStrings.add(Helper.generateRandomString());
        }

        long timeGetIdsShotner1 = getTimeToGetIds(shortener1,origStrings,resultSetLong);
        long timeGetIdsShotner2 = getTimeToGetIds(shortener2,origStrings,resultSetLong);
        Assert.assertTrue(timeGetIdsShotner1 > timeGetIdsShotner2);

        long timeGetStringsShotner1 = getTimeToGetStrings(shortener1,resultSetLong,origStrings);
        long timeGetStringsShotner2 = getTimeToGetStrings(shortener2,resultSetLong,origStrings);
        Assert.assertEquals(timeGetStringsShotner1, timeGetStringsShotner2, 30);
                
    }

}
