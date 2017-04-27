package ru.job4j.accApplications;

/**
 * Основной класс системы заявок Tracker, работает с массивом заявок, осуществляет добавление удаление заявок,
 * и прочие функции.
 * @author Artem Prokopov
 * @since 27.04.2017
 * @version 1.0
 */
public class Tracker {
    /**
     * Массив заявок.
     */
    private Item[] items = Tracker.NULL_ITEM_ARRAY;

    /**
     * Константа ссылающаяся на массив 0 длины, означающий пустой массив.
     */
    private final static Item[] NULL_ITEM_ARRAY = new  Item[0];

    /**
     * Добавляет заявку в массив items.
     * @param item добавляемая заявка
     * @throws ArrayIndexOutOfBoundsException
     */
    public void add(Item item) throws ArrayIndexOutOfBoundsException {
        if (this.items != null && !item.equals(Item.EMPTY_ITEM)) {
           Item[] temp = new Item[this.items.length + 1];
           System.arraycopy(this.items, 0, temp, 0, this.items.length);
           temp[temp.length - 1] = item;
           this.items = temp;
           temp = null;
        } else if (!item.equals(Item.EMPTY_ITEM)){
            this.items = new Item[] {item};
        }
    }

    /**
     * Обновляет заявку в массиве items.
     * @param item обновляемая заявка
     * @throws ArrayIndexOutOfBoundsException
     */
    public void update(Item item) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < items.length; i++) {
            if (item.equalsId(this.items[i])) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Удаляет указанную заявку
     * @param item удаляемая заявка
     * @throws ArrayIndexOutOfBoundsException
     */
    public void delete(Item item) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < items.length; i++) {
            if (item.equals(this.items[i])) {
                Item[] temp = new Item[this.items.length - 1];
                System.arraycopy(this.items, 0, temp, 0, i);
                System.arraycopy(this.items, i + 1, temp, i + 1, this.items.length - (i + 1) - 1);
                this.items = temp;
                break;
            }
        }
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
     * @throws ArrayIndexOutOfBoundsException
     */
    public Item[] findByName(String key) throws ArrayIndexOutOfBoundsException {
        Item[] result = this.NULL_ITEM_ARRAY;
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
    public Item FindById(String id) {
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
