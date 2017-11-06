package ru.job4j.speedtestcollection;


import org.junit.Ignore;
import org.junit.FixMethodOrder;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;

/**
 * Класс  для оценки скорости добавления элементов в коллекции ArrayList, LinkedList, TreeSet.
 * @author Artem Prokopov
 * @since 05.09.2017
 * @version 1.0
 */
@Ignore
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpeedTestCollectionTest {
    /**
     * Объект класса содержащий тестируемые методы.
     */
    private final SpeedTestCollection speedTestCollection = new SpeedTestCollection();
    /**
     * ArrayList для теста добавления элементов.
     */
    private final List<String> arrayListAdd = new ArrayList<>();
    /**
     * LinkedList для теста добавления элементов.
     */
    private final List<String> linkedListAdd = new LinkedList<>();
    /**
     * TreeSet для теста добавления элементов.
     */
    private final Set<String> treeSetAdd = new TreeSet<>();
    /**
     * ArrayList для теста удаления элементов.
     */
    private final List<String> arrayListDel = new ArrayList<>();
    /**
     * LinkedList для теста удаления элементов.
     */
    private final List<String> linkedListDel = new LinkedList<>();
    /**
     * TreeSet для теста удаления элементов.
     */
    private final Set<String> treeSetDel = new TreeSet<>();
    /**
     * Feli для зсписи результатов.
     */
    private static File file;
    /**
     * Буфер для записи в файл.
     */
    private static BufferedWriter bufferedWriter;
    /**
     * Map для хранения результатов.
     */
    private static Map<String, LinkedHashMap<String, Long>> resultTest = new LinkedHashMap<>();

    /**
     * Создаем файл для записи результатов. Файо создается в лерриктории log в корне проекта, если такой дерриктории
     * не существует, то она создается.
     */
    @BeforeClass
    public static void initClass() {
        resultTest.put("ArrayListAdd", new LinkedHashMap<>());
        resultTest.put("LinkedListAdd", new LinkedHashMap<>());
        resultTest.put("TreeSetAdd", new LinkedHashMap<>());
        resultTest.put("ArrayListDel", new LinkedHashMap<>());
        resultTest.put("LinkedListDel", new LinkedHashMap<>());
        resultTest.put("TreeSetDel", new LinkedHashMap<>());
        try {
            file = new File("./log/");
            file.mkdir();
            file = new File(String.format("./log/SpeedTestCollection %s %s",
                    LocalDate.now(),
                    LocalTime.now().format(DateTimeFormatter.ofPattern("HH_mm_ss"))));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
        } catch (IOException ioe) {
            System.out.println("Не удалось создать файл лога из-за ошибки ввода-вывода.");
            System.out.println(ioe);
        }
    }

    /**
     * Записываем результаты из Map в файл.
     */
    @AfterClass
    public  static void closeClass() {
        try {
            bufferedWriter.write(
                    String.format("%18s %12d %12d %12d %12d",
                            "Кол-ов элементов: ", 1000, 10_000, 100_000, 1_000_000)
            );
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write(
                    String.format("%18s",
                            "Время выполнения нс:")
            );
            bufferedWriter.newLine();
            for (Map.Entry<String, LinkedHashMap<String, Long>> e
                    :resultTest.entrySet()) {
                bufferedWriter.write(
                        String.format("%18s %12d %12d %12d %12d",
                                e.getKey(),
                                resultTest.get(e.getKey()).get("1000"),
                                resultTest.get(e.getKey()).get("10000"),
                                resultTest.get(e.getKey()).get("100000"),
                                resultTest.get(e.getKey()).get("1000000"))
                );
                bufferedWriter.newLine();
            }
        } catch (IOException ioe) {
            System.out.println("Не удалось записать в файл лога из-за ошибки ввода-вывода.");
        }


        try {
            bufferedWriter.close();
        } catch (IOException ioe) {
            System.out.println("Не удалось закрыть файл лога из-за ошибки ввода-вывода.");
        }
    }

    /**
     * Заполняем коллекции элементами для тестов на удаление элементов.
     */
    @Before
    public void init() {
        speedTestCollection.add(arrayListDel, 1_100_000);
        speedTestCollection.add(linkedListDel, 1_100_000);
        speedTestCollection.add(treeSetDel, 1_100_000);
    }

    /**
     * Тест на время добавления 1 000 элементов в ArrayList.
     */
    @Test
    public void addArrayList1000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(arrayListAdd, 1_000);
        }
        resultTest.get("ArrayListAdd").put("1000", time / 3);
    }
    /**
     * Тест на время добавления 10 000 элементов в ArrayList.
     */
    @Test
    public void addArrayList10000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(arrayListAdd, 10_000);
        }
        resultTest.get("ArrayListAdd").put("10000", time / 3);
    }
    /**
     * Тест на время добавления 100 000 элементов в ArrayList.
     */
    @Test
    public void addArrayList100000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(arrayListAdd, 100_000);
        }
        resultTest.get("ArrayListAdd").put("100000", time / 3);
    }
    /**
     * Тест на время добавления 1 000 000 элементов в ArrayList.
     */
    @Test
    public void addArrayList1000000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(arrayListAdd, 1_000_000);
        }
        resultTest.get("ArrayListAdd").put("1000000", time / 3);
    }
    /**
     * Тест на время добавления 1 000 элементов в LinkedList.
     */
    @Test
    public void addLinkedList1000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(linkedListAdd, 1_000);
        }
        resultTest.get("LinkedListAdd").put("1000", time / 3);
    }
    /**
     * Тест на время добавления 10 000 элементов в LinkedList.
     */
    @Test
    public void addLinkedList10000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(linkedListAdd, 10_000);
        }
        resultTest.get("LinkedListAdd").put("10000", time / 3);
    }
    /**
     * Тест на время добавления 100 000 элементов в LinkedList.
     */
    @Test
    public void addLinkedList100000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(linkedListAdd, 100_000);
        }
        resultTest.get("LinkedListAdd").put("100000", time / 3);
    }
    /**
     * Тест на время добавления 1 000 000 элементов в LinkedList.
     */
    @Test
    public void addLinkedList1000000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(linkedListAdd, 1_000_000);
        }
        resultTest.get("LinkedListAdd").put("1000000", time / 3);
    }
    /**
     * Тест на время добавления 1 000 элементов в TreeSet.
     */
    @Test
    public void addTreeSet1000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(treeSetAdd, 1_000);
        }
        resultTest.get("TreeSetAdd").put("1000", time / 3);
    }
    /**
     * Тест на время добавления 10 000 элементов в TreeSet.
     */
    @Test
    public void addTreeSet10000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(treeSetAdd, 10_000);
        }
        resultTest.get("TreeSetAdd").put("10000", time / 3);
    }
    /**
     * Тест на время добавления 100 000 элементов в TreeSet.
     */
    @Test
    public void addTreeSet100000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(treeSetAdd, 100_000);
        }
        resultTest.get("TreeSetAdd").put("100000", time / 3);
    }
    /**
     * Тест на время добавления 1 000 000 элементов в TreeSet.
     */
    @Test
    public void addTreeSet1000000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.add(treeSetAdd, 1_000_000);
        }
        resultTest.get("TreeSetAdd").put("1000000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 1 000 элементов в ArrayList.
     */
    @Test
    public void delArrayList1000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(arrayListDel, 1_000);
        }
        resultTest.get("ArrayListDel").put("1000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 10 000 элементов в ArrayList.
     */
    @Test
    public void delArrayList10000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(arrayListDel, 10_000);
        }
        resultTest.get("ArrayListDel").put("10000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 100 000 элементов в ArrayList.
     */
    @Test
    public void delArrayList100000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(arrayListDel, 100_000);
        }
        resultTest.get("ArrayListDel").put("100000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 1 000 000 элементов в ArrayList.
     */
    @Test
    public void delArrayList1000000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(arrayListDel, 1_000_000);
        }
        resultTest.get("ArrayListDel").put("1000000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 1 000 элементов в LinkedList.
     */
    @Test
    public void delLinkedList1000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(linkedListDel, 1_000);
        }
        resultTest.get("LinkedListDel").put("1000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 10 000 элементов в LinkedList.
     */
    @Test
    public void delLinkedList10000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(linkedListDel, 10_000);
        }
        resultTest.get("LinkedListDel").put("10000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 100 000 элементов в LinkedList.
     */
    @Test
    public void delLinkedList100000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(linkedListDel, 100_000);
        }
        resultTest.get("LinkedListDel").put("100000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 1 000 000 элементов в LinkedList.
     */
    @Test
    public void delLinkedList1000000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(linkedListDel, 1_000_000);
        }
        resultTest.get("LinkedListDel").put("1000000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 1 000 элементов в TreeSet.
     */
    @Test
    public void delTreeSet1000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(treeSetDel, 1_000);
        }
        resultTest.get("TreeSetDel").put("1000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 10 000 элементов в TreeSet.
     */
    @Test
    public void delTreeSet10000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(treeSetDel, 10_000);
        }
        resultTest.get("TreeSetDel").put("10000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 100 000 элементов в TreeSet.
     */
    @Test
    public void delTreeSet100000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(treeSetDel, 100_000);
        }
        resultTest.get("TreeSetDel").put("100000", time / 3);
    }
    /**
     * Тест на время удаления из головы коллекции 1 000 000 элементов в TreeSet.
     */
    @Test
    public void delTreeSet1000000Elements() {
        long time = 0;
        for (int i = 0; i < 3; i++) {
            time = time + speedTestCollection.delete(treeSetDel, 1_000_000);
        }
        resultTest.get("TreeSetDel").put("1000000", time / 3);
    }

}