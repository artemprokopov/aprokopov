package ru.job4j.simplearray;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void toArray()  {
        SimpleArray<Integer> simpleArray = new SimpleArray<>();
        simpleArray.add(1);
        simpleArray.add(2);
        System.out.println(simpleArray.get(3));
    }

}