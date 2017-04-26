package ru.job4j.accApplications;

/**
 * Created by Prokopov on 26.04.2017.
 */
public class Tracker {
    private Item[] items;

    public void add(Item item) throws ArrayIndexOutOfBoundsException {
        if (this.items != null) {
           Item[] temp = new Item[this.items.length + 1];
           System.arraycopy(this.items, 0, temp, 0, this.items.length);
           temp[temp.length - 1] = item;
           this.items = temp;
           temp = null;
        } else {
            this.items = new Item[] {item};
        }
    }

    public void update(Item item) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < items.length; i++) {
            if (item.getId().equals(items[i].getId())) {
                items[i] = item;
                break;
            }
        }
    }

    public void delete(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (item.getId().equals(items[i].getId())) {
                items[i] = item;
            }
        }
    }

    public Item[] findAll() {
        return null;
    }

    public Item[] findByName(String key) {
        return null;
    }

    public void FindById(String id) {
    }

}
