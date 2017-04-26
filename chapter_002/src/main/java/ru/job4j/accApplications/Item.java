package ru.job4j.accApplications;

import java.util.Date;

/**
 * Created by Prokopov on 26.04.2017.
 */
public class Item {
    private final String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public static final Item EMPTY_ITEM;
    static {
        EMPTY_ITEM = new Item("empty");
    }

    private Item(String str) {
        this.id = str;
    }

    Item() {
        this.id = Long.toString((new Date().getTime())/(long) (Math.random() * 100))
                    + "-" + this.hashCode();
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public boolean equalsId (Item item) {
        return this.id.equals(item.id);
    }

    @Override
    public boolean equals (Object obj) {
        boolean result = false;
        if (obj == null || obj.getClass() != this.getClass()) {
            result = false;
        } else {
            Item item = (Item) obj;
            if (this.id.equals(item.id)
                    && this.name.equals(item.name)
                    && this.desc.equals(item.desc)
                    && this.created == item.created
                    && this.comments.length == item.comments.length) {
                for (int i = 0; i < this.comments.length; i++) {
                    if (this.comments[i].equals(item.comments[i])) {
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        return  result;
    }
}
