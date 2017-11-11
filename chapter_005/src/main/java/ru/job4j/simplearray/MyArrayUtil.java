package ru.job4j.simplearray;

/**
 * Класс служебных методов для MyArray.
 */
public class MyArrayUtil implements ArrayUtil{
    /**
     * Поиск элемента в контейнере.
     * @param searchItem искомый элемент.
     * @return индекс найденного элемента, в противном случае если элемент не найден -1.
     */
    @Override
    public <T> int findItem(Array<T> array,T searchItem) {
        if (array.isEmpty()) {
            return -1;
        }
        for (int i = 0; i <= array.size(); i++) {
            if (searchItem.equals(array.get(i))) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Проверка индекса на принадлежность диапазону 0 <= i <= checkArray.
     * @param checkArray проверяемый массив.
     * @param checkIndex проверяемый индекс.
     * @return возвращает true если индекс checkIndex существует в массиве checkArray.
     */
    @Override
    public <T> boolean checkIndex(Array<T> checkArray, int checkIndex) {
        if (checkArray.isEmpty()) {
            return false;
        }
        if (checkIndex > checkArray.size() - 1 || checkIndex < 0) {
            return false;
        }
        return true;
    }

    @Override
    public <T> boolean checkIndexByMaxArraySize( int checkIndex) {
        if (checkIndex > this.getArrayMaxSize()) {
            return false;
        }
        return true;
    }

    @Override
    public int getArrayInitSize() {
        return ArrayUtil.ARRAY_INIT_SIZE;
    }

    @Override
    public int getArrayMaxSize() {
        return ArrayUtil.ARRAY_MAX_SIZE;
    }

    @Override
    public boolean checkFirstIndexMoreSecondIndex(int firstIndex, int secondIndex) {
        return false;
    }

    @Override
    public <T> boolean checkTrueTripleElement(Array<T> checkArray, int startIndex, int endIndex) {
        return this.checkIndex(checkArray, startIndex)
                && this.checkIndex(checkArray, endIndex)
                && this.checkFirstIndexMoreSecondIndex(endIndex, startIndex);
    }

    /**
     *
     * @param index
     * @param maxIndexArray
     * @return
     */
    @Override
    public String outOfBoundsMsg(int index, int maxIndexArray) {
        return "Index: " + index + ", Size: " + maxIndexArray;
    }
}

