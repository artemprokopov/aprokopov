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
     *
     */
    private static final Item[] NULL_ITEM_ARRAY = {};

    /**
     * Массив заявок.
     */
    private AccArray<Item> items = new AccArray<>();

    /**
     * Добавляет заявку в массив items.
     * @param item добавляемая заявка
     * @return в случае успеха операции возвращает true, иначе false.
     */
    public boolean add(Item item) {
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).equals(item)) {
                return false;
            }
        }
        items.add(item);
        return true;
    }

    /**
     * Обновляет заявку в массиве items.
     * @param item обновляемая заявка
     * @param newItem новая заявка
     * @return в случае успеха операции возвращает true, иначе false.
     */
    public boolean update(Item item, Item newItem) {
        for (int i = 0; i < items.size(); i++) {
            if (item.equals(items.get(i))) {
                items.set(i, newItem);
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
        items.delete(item);
        result = true;
        return result;
    }

    /**
     * Возвращает все существующие заявки.
     * @return items массив заявок.
     */
    public Item[] findAll() {
        return items.toArray(new Item[items.size()]);
    }

    /**
     * Ищет заявку по совпадению поля @name в заявках массива items.
     * @param key ключевое слово для поиска
     * @return возвращает массив Item[] содержащий найденные заявкиб если заявок не найдено возвращает NULL_ITEM_ARRAY.
     */
    public Item[] findByName(String key) {
        Item[] result = Tracker.NULL_ITEM_ARRAY;
        for (int i = 0; i < items.size(); i++) {
            Item count = items.get(i);
            if (count.getName().equals(key)) {
                Item[] temp = new Item[result.length + 1];
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = count;
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
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                result = items.get(i);
                break;
            }
        }
        return result;
    }
}
