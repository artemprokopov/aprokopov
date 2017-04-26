package ru.job4j.accApplications;

/**
 * Created by Prokopov on 26.04.2017.
 */
public class Tracker {
    private Item[] items = Tracker.NULL_ITEM_ARRAY;
    private final static Item[] NULL_ITEM_ARRAY = new  Item[0];

    public void add(Item item) throws ArrayIndexOutOfBoundsException {
        if (this.items != null && item.equals(Item.EMPTY_ITEM)) {
           Item[] temp = new Item[this.items.length + 1];
           System.arraycopy(this.items, 0, temp, 0, this.items.length);
           temp[temp.length - 1] = item;
           this.items = temp;
           temp = null;
        } else if (!item.equals(Item.EMPTY_ITEM)){
            this.items = new Item[] {item};
        }
    }

    public void update(Item item) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < items.length; i++) {
            if (item.equalsId(this.items[i])) {
                items[i] = item;
                break;
            }
        }
    }

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

    public Item[] findAll() {
        return this.items;
    }

    public Item[] findByName(String key) {
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
