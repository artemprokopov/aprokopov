package ru.job4j.accapplications;

/**
 * Основной класс системы заявок Tracker, работает с массивом заявок, осуществляет добавление удаление заявок,
 * и прочие функции.
 * @author Artem Prokopov
 * @since 27.04.2017
 * @version 1.0
 */
public class Tracker {
    /**
     * Константа ссылающаяся на массив 0 длины, означающий пустой массив.
     */
    public static final Item[] NULL_ITEM_ARRAY = {};

    /**
     * Массив заявок.
     */
    private Item[] items = NULL_ITEM_ARRAY;

    /**
     * Добавляет заявку в массив items.
     * @param item добавляемая заявка
     * @return в случае успеха операции возвращает true, иначе false.
     */
    public boolean add(Item item) {
        for (Item i : this.items) {
            if (i.equals(item)) {
                return false;
            }
        }
        Item[] temp = new Item[this.items.length + 1];
        System.arraycopy(this.items, 0, temp, 0, this.items.length);
        temp[temp.length - 1] = item;
        this.items = temp;
        return true;
    }

    /**
     * Обновляет заявку в массиве items.
     * @param item обновляемая заявка
     * @param newItem новая заявка
     * @return в случае успеха операции возвращает true, иначе false.
     */
    public boolean update(Item item, Item newItem) {
        for (int i = 0; i < items.length; i++) {
            if (item.equals(this.items[i])) {
                items[i] = newItem;
                return true;
            }
        }
        return false;
    }

    /**
     * Удаляет указанную заявку.
     * @param item удаляемая заявка
     * @return в случае успеха операции возвращает true, иначе false.
     */
    public boolean delete(Item item) {
        boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if (item.equals(this.items[i])) {
                Item[] temp = new Item[this.items.length - 1];
                System.arraycopy(this.items, 0, temp, 0, i);
                System.arraycopy(this.items, i + 1, temp, i, this.items.length - i  - 1);
                this.items = temp;
               result = true;
            }
        }
        return result;
    }

    /**
     * Возвращает все существующие заявки.
     * @return items массив заявок.
     */
    public Item[] findAll() {
        return this.items;
    }

    /**
     * Ищет заявку по совпадению поля @name в заявках массива items.
     * @param key ключевое слово для поиска
     * @return возвращает массив Item[] содержащий найденные заявкиб если заявок не найдено возвращает NULL_ITEM_ARRAY.
     */
    public Item[] findByName(String key) {
        Item[] result = NULL_ITEM_ARRAY;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getName().equals(key)) {
                Item[] temp = new Item[result.length + 1];
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = items[i];
                result = temp;
            }
        }
        return result;
    }

    /**
     * Производит поиск заявки в массиве заявок items по полю id.
     * @param id значение поля id
     * @return найденую заявку, в противном случае возвращает EMPTY_ITEM.
     */
    public Item findById(String id) {
        Item result = Item.EMPTY_ITEM;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }
}
