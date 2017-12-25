package ru.job4j.simplecontainer;


import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/**
 * Класс контейнера HashMap, реализует интерфейс {@link Map<K, V>}.
 * @param <K> тип ключа.
 * @param <V> тип содержания контейнера.
 * @author Artem Prokopov
 * @since 20/03/2018
 * @version 1.0
 */

public class SimpleHashMap<K, V> implements Map<K, V> {
    /**
     * Емкость контенера при иницализации хранилища {@link SimpleHashMap#store}.
     */
    private static final int INIT_CAPACITY = 17;
    /**
     * Количество элементов в массиве хранилище {@link SimpleHashMap#store}.
     */
    private int storeCapacity;
    /**
     * Максимальное количество элементов в массиве хранилище элементов {@link SimpleHashMap#store}.
     */
    private static final int MAX_STORE_CAPACITY = Integer.MAX_VALUE - 1;
    /**
     * Фактор заполнения хранили элементами характерезует момент увеличения числа элементов в {@link SimpleHashMap#store}
     * и перераспределение элементов по новому хранилищу. Производится оценка по этому параметру
     * this.size / this.storeCapacity) < 1 - this.scaleFactor , в случае true увеличивается размер хранилища
     * и перераспределяются элементы.
     */
    private double scaleFactor = 0.75;
    /**
     * Количество элементов в хранилище.
     */
    private int size = 0;
    /**
     * Хранилище элементов контейнера.
     */
    //CHECKSTYLE:OFF
    Node<K, V>[] store;
    //CHECKSTYLE:ON
    /**
     * Конструктор по умолчанию.
     */
    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        this.store = (Node<K, V>[]) new Node[INIT_CAPACITY];
        this.storeCapacity = INIT_CAPACITY;
    }

    /**
     * Возвращает количество элементов в хранилище.
     * @return количество элементов в контейнере.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Метод проверки является ли хранилище пустым.
     * @return true если контейнер пустой, в противном случае false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Проверяет содержит ли передаваемый ключ в контейнере.
     * @param key искомый ключ.
     * @return true если заданный ключ присутствует в контейнере, в противном случае false.
     */
    @Override
    public boolean containsKey(Object key) {
        return key != null && findNodeByKey(key) != null;
    }

    /**
     * Проверяет наличие переданного объекта в контейнере.
     * @param value искомый объект.
     * @return true если объек присутствует в контейнере, в противном слулучае вернет false.
     */
    @Override
    public boolean containsValue(Object value) {
        return value != null && findNodeByValue(value) != null;
    }

    /**
     * Получает объект по заданному ключу.
     * @param key передаваемый ключ.
     * @return null если такого ключа не существует, либовернет объект из хранилища по ключу.
     */
    @Override
    public V get(Object key) {
        Node<K, V> tempNode = findNodeByKey(key);
        if (tempNode == null) {
            return null;
        }
        return tempNode.value;
    }

    /**
     * Поместит в хранилище объек V с ключом K.
     * @param key ключ соответствия объету типа V.
     * @param value объект помещаемый в контейнер.
     * @return объект помещенный в контейнер.
     */
    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key, "The key should not be null!");
        Objects.requireNonNull(value, "The value should not be null!");
        addNodeToStore(new Node<>(key, value));
        return value;
    }

    /**
     * Удаляет объект из хранилищи по ключу key.
     * @param key передаваеммый ключ.
     * @return если объект удален, возвращает удаленный объект, в противном случае null.
     */
    @Override
    public V remove(Object key) {
        return deleteKeyToStore(key);
    }

    /**
     * Помещает передаваемую Map, в данный контейнер.
     * @param m Map значения которой должны быть помещены в контейнер.
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Objects.requireNonNull(m, "The map should not be null!");
        for (Map.Entry<? extends K, ? extends V> e: m.entrySet()) {
           addNodeToStore(new Node<>(e.getKey(), e.getValue()));
        }
    }

    /**
     * Очищает контейнер.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        this.store = (Node<K, V>[]) new Node[INIT_CAPACITY];
        this.storeCapacity = INIT_CAPACITY;
        this.size = 0;
    }

    /**
     * Не реализованный функционал.
     * @return исключение.
     */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("keySet()");
    }

    /**
     * Не реализованный функционал.
     * @return исключение.
     */
    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("values()");
    }

    /**
     * Не реализованный функционал.
     * @return исключение.
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("entrySet()");
    }

    /**
     * Узел храняший "ключ - значение", представляет собой элемент односвязного списка для разрешений коллизий.
     * @param <K> тип ключа.
     * @param <V> тип объекта.
     */
    //CHECKSTYLE:OFF
    static class Node<K, V> {
        /**
         * Хранит вычесленный hashcode ключа.
         */
        final int hash;
        /**
         * Значение ключа.
         */
        final K key;
        /**
         * Значение хранящегося объекта.
         */
        V value;
        /**
         * Ссылка на следующий узел.
         */
        Node<K, V> next;

        /**
         * Коструктор узла.
         * @param initKey ключ.
         * @param initValue значение.
         */
        Node(K initKey, V initValue) {
            this.hash = initKey.hashCode();
            this.key = initKey;
            this.value = initValue;
        }
        //CHECKSTYLE:ON

        /**
         * Переопределяем метод equals.
         * @param o объект с которым идет сравнение.
         * @return true если объекты равны, false если не равны.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return hash == node.hash
                    && Objects.equals(key, node.key)
                    && Objects.equals(value, node.value)
                    && Objects.equals(next, node.next);
        }

        /**
         * Переопределяем метод hashCode.
         * @return хэш код ветки.
         */
        @Override
        public int hashCode() {
            return Objects.hash(hash, key, value);
        }
    }

    /**
     * Ищет узел по ключу.
     * @param k ключ по которому производится поиск.
     * @return найденый узел, в противном случае null.
     */
    private Node<K, V> findNodeByKey(Object k) {
        if (size == 0 && k == null) {
            return null;
        }
        int location = k.hashCode() % this.storeCapacity;
        if (this.store[location] == null) {
            return null;
        }
        if (this.store[location].key.equals(k)) {
            return this.store[location];
        }
        Node<K, V> tempNode = this.store[location];
        while (tempNode.next != null) {
            if (tempNode.next.key.equals(k)) {
                return tempNode.next;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    /**
     * Ищет узел по значению объекта.
     * @param v объект по которому производится поиск.
     * @return найденый узел, в противном случае если узел не найден, вернет false.
     */
    private Node<K, V> findNodeByValue(Object v) {
        if (size == 0 && v == null) {
            return null;
        }
        Node<K, V> tempNode = null;
        for (int i = 0; i < this.storeCapacity; i++) {
            if (this.store[i] == null) {
                continue;
            }
            tempNode = this.store[i];
            if (tempNode.value == v || tempNode.value.equals(v)) {
                return tempNode;
            }
            while (tempNode.next != null) {
                if (tempNode.next.value == v || tempNode.next.value.equals(v)) {
                    return tempNode.next;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }
    /**
     * Удаляет объект по ключу.
     * @param key ключ по которому производится удаление.
     * @return удаленный объект, в противном случае null.
     */
    private V deleteKeyToStore(Object key) {
        Node<K, V> tempNode = null;
        for (int i = 0; i < this.storeCapacity; i++) {
            if (this.store[i] == null) {
                continue;
            }
            tempNode = this.store[i];
            if (tempNode.key == key || tempNode.key.equals(key)) {
                this.store[i] = tempNode.next;
                this.size--;
                return tempNode.value;
            }
            while (tempNode.next != null) {
                if (tempNode.next.key == key || tempNode.next.key.equals(key)) {
                    V v = tempNode.next.value;
                    tempNode.next = tempNode.next.next;
                    this.size--;
                    return v;
                }
                tempNode = tempNode.next;
            }
        }

        if (this.storeCapacity > INIT_CAPACITY
                && ((double) this.size / this.storeCapacity) < 1 - this.scaleFactor) {
            reduceStore();
        }
        return null;
    }

    /**
     * Добавляет узел в хранилище.
     * @param n добавляем узел.
     */
    private void addNodeToStore(Node<K, V> n) {
        if (((double) this.size / this.storeCapacity) > this.scaleFactor) {
            increaseStore();
        }
        int location = n.hash % this.storeCapacity;
        addNodeLocation(n, location);
    }

    /**
     * Добавляет узел в заданную ячейку хранилища.
     * @param kvNode Добаляемый узел.
     * @param addLocation индекс массива в позицию которого добаляется узел.
     */
    private void addNodeLocation(Node<K, V> kvNode, int addLocation) {
        boolean t = false;
        if (this.store[addLocation] == null
                || (this.store[addLocation].hash == kvNode.hash
                && !this.store[addLocation].key.equals(kvNode.key))) {
            if (this.store[addLocation] != null) {
                kvNode.next = this.store[addLocation].next;
                this.store[addLocation].next = null;
            }
            this.store[addLocation] = kvNode;
            this.size++;
            return;
        } else if (this.store[addLocation].key.equals(kvNode.key)) {
            this.store[addLocation].value = kvNode.value;
            return;
        }
        Node<K, V> nextNode = this.store[addLocation];
        while (true) {
            if (nextNode.next == null) {
                nextNode.next = kvNode;
                this.size++;
                return;
            }
            if (this.store[addLocation].hash == kvNode.hash && !nextNode.next.key.equals(kvNode.key)) {
                kvNode.next = nextNode.next.next;
                nextNode.next = kvNode;
                this.size++;
                return;
            }
            if (nextNode.next.key.equals(kvNode.key)) {
                nextNode.next.value = kvNode.value;
                return;
            }
            nextNode = nextNode.next;
        }
    }

    /**
     * Увеличивает размер хранилища.
     */
    private void increaseStore() {
        if (MAX_STORE_CAPACITY - this.storeCapacity > INIT_CAPACITY) {
            this.storeCapacity += INIT_CAPACITY;
        } else if (this.storeCapacity != MAX_STORE_CAPACITY) {
            this.storeCapacity = MAX_STORE_CAPACITY;
        }
        distributionNode();
    }

    /**
     * Уменьшает размер хранилища.
     */
    private void reduceStore() {
        if (this.storeCapacity > INIT_CAPACITY) {
            this.storeCapacity -= INIT_CAPACITY;
            distributionNode();
        }
    }

    /**
     * Создает новое хранилище, и распределяет все элементы из сарого хнанилища в новом.
     * Новое созданное хранилище присваивается {@link SimpleHashMap#store}.
     */
    @SuppressWarnings("unchecked")
    private void distributionNode() {
        Node<K, V>[] tempStore = this.store;
        Node<K, V> tempNode = null;
        this.store = (Node<K, V>[]) new Node[this.storeCapacity];
        this.size = 0;
        for (Node<K, V> kvNode : tempStore) {
            tempNode = kvNode;
            while (tempNode != null) {
                addNodeToStore(tempNode);
                tempNode = tempNode.next;
            }
        }
    }

    /**
     * Переопределяем equals.
     * @param o объект с которым идет сравнение.
     * @return true если объекты равны, в противном случа false.
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        SimpleHashMap<K, V> that = (SimpleHashMap<K, V>) o;
        if (size != that.size) {
            return false;
        }
        Node<K, V>[] thatStore = that.store;
        for (int i = 0; i < this.store.length; i++) {
            if (this.store[i] != null && thatStore[i] != null) {
                if (!this.store[i].equals(thatStore[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Переопределяем hashCode.
     * @return хэшкод контейнера.
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(store);
        return result;
    }
}
