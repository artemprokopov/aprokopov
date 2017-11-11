package ru.job4j.simplearray;

public interface ArrayUtil {
    /**
     * Смещение максимального размера массива относительно {@link Integer#MAX_VALUE}.
     */
    int ARRAY_INDEX_MAX_VALUE_OFFSET = 5;
    /**
     * Максимальный размер массива принимается  как
     * {@link Integer#MAX_VALUE} - {@link ArrayUtil#ARRAY_INDEX_MAX_VALUE_OFFSET}.
     */
    int ARRAY_MAX_SIZE = Integer.MAX_VALUE - ARRAY_INDEX_MAX_VALUE_OFFSET;
    /**
     * Размер которым инициализируется массив по умолчанию.
     */
    int ARRAY_INIT_SIZE = 10;
    /**
     * Поиск элемента в массиве реализующий интерфейс {@link Array}.
     * @param array массив в котором производим поиск.
     * @param searchItem искомый элемент.
     * @return индекс найденного элемента, в противном случае если элемент не найден -1.
     */
    <T> int findItem(Array<T> array,T searchItem);
    /**
     * Проверка индекса на принадлежность диапазону 0 <= i <= array.
     * @param checkIndex проверяемый индекс.
     */
    <T> boolean checkIndex(Array<T> checkArray,int checkIndex);

    /**
     *
     * @param checkIndex
     * @param <T>
     * @return
     */
    <T> boolean checkIndexByMaxArraySize(int checkIndex);
    /**
     * Возвращает начальный размер массива по умолчанию.
     * @return начальный размер массива по умолчанию.
     */
    int getArrayInitSize();

    /**
     *
     * @return
     */
    int getArrayMaxSize();

    boolean checkFirstIndexMoreSecondIndex(int firstIndex, int secondIndex);

    <T> boolean checkTrueTripleElement(Array<T> checkArray ,int startIndex, int endIndex);

    /**
     * Формирует строку сообщения при выходе за границы массива.
     * @param index индекс вызывающий исключение.
     * @param maxIndexArray максимальный индекс массива.
     * @return сформированную строку для сообзения.
     */
    String outOfBoundsMsg(int index, int maxIndexArray);

}

