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
    private Item[] items = Item.NULL_ITEM_ARRAY;

    /**
     * Добавляет заявку в массив items.
     * @param item добавляемая заявка
     * @throws ArrayIndexOutOfBoundsException
     * @return в случае успеха операции возвращает true, иначе false.
     */
    public boolean add(Item item) throws ArrayIndexOutOfBoundsException {
        boolean result = false;
        if (this.items != null && !item.equals(Item.EMPTY_ITEM)) {
           Item[] temp = new Item[this.items.length + 1];
           System.arraycopy(this.items, 0, temp, 0, this.items.length);
           temp[temp.length - 1] = item;
           this.items = temp;
           result = true;
        } else if (!item.equals(Item.EMPTY_ITEM)){
            this.items = new Item[] {item};
            result = true;
        }
        return result;
    }

    /**
     * Обновляет заявку в массиве items.
     * @param item обновляемая заявка
     * @throws ArrayIndexOutOfBoundsException
     * @return в случае успеха операции возвращает true, иначе false.
     */
    public boolean update(Item item) throws ArrayIndexOutOfBoundsException {
       boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if (item.equalsId(this.items[i])) {
                items[i] = item;
               result = true;
            }
        }
        return result;
    }

    /**
     * Удаляет указанную заявку
     * @param item удаляемая заявка
     * @throws ArrayIndexOutOfBoundsException
     * @return в случае успеха операции возвращает true, иначе false.
     */
    public boolean delete(Item item) throws ArrayIndexOutOfBoundsException {
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
     * @throws ArrayIndexOutOfBoundsException
     */
    public Item[] findByName(String key) throws ArrayIndexOutOfBoundsException {
        Item[] result = Item.NULL_ITEM_ARRAY;
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
