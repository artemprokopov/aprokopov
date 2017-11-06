package ru.job4j.speedtestcollection;

import java.util.Random;
import java.util.Collection;
import java.util.Iterator;

/**
 * Класс тестирования коллекций ArrayList, LinkedList, TreeSet на скорость вставки
 * и удаления элементов.
 * элементов и на скорость удаления элементов.
 * @author Artem Prokopov
 * @since 03.09.2017
 * @version 1.0
 */
public class SpeedTestCollection {
    /**
     * Генерируем числа для произвольных строк.
     */
    private final Random random = new Random();

    /**
     * Тестируем добавление строк в коллекцию.
     * @param collection куда добавляем элементы.
     * @param amount количество элементов
     * @return время выполнения в миллисекундах.
     */
    public long add(Collection<String> collection, int amount) {
        long timeStart = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(Integer.toString(random.nextInt()));
        }
        return System.nanoTime() - timeStart;
    }

    /**
     *Тестируем удаление строк из коллекции.
     * @param collection откуда удаляем элементы.
     * @param amount количество элементов
     * @return время выполнения в миллисекундах.
     */
    public long delete(Collection<String> collection, int amount) {
        long timeStart = System.nanoTime();
        Iterator<String> iterator = collection.iterator();
        for (int i = 0; i < amount && iterator.hasNext(); i++) {
            iterator.next();
            iterator.remove();
        }
        return System.nanoTime() - timeStart;
    }
}
