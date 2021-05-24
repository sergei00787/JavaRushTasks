package com.javarush.task.task37.task3714;

import org.junit.Assert;
import org.junit.Test;

public class TestRomanToInt {
    @Test
    public void TestRoman(){
        Assert.assertEquals(Solution.romanToInteger("MCMXXV"), 1925);
        Assert.assertEquals(Solution.romanToInteger("MDLXXV"), 1575);
        Assert.assertEquals(Solution.romanToInteger("MMDCCCXLIX"), 2849);
    }

}
