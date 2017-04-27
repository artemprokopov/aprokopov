package ru.job4j.accApplications;

import java.util.Date;

/**
 * Класс описывающий структуру заявки.
 * @author Artem Prokopov
 * @since 27.04.2017
 * @version 1.0
 */
public class Item {
    /**
     * Поле id содержит уникальную идентификационную строку заявки.
     */
    private final String id;

    /**
     *  Поле name содержит имя создавшего заявку
     */
    private String name;

    /**
     * Поле desc содержит описание заявки.
     */
    private String desc;

    /**
     * Поле created содержит врея создание заявки.
     */
    private long created;

    /**
     * Поле comments содержит массив строк комментариев  заявке.
     */
    private String[] comments;

    /**
     * Константа пустой заявки с id равному строке empty.
     */
    public static final Item EMPTY_ITEM = new Item("empty");;

    /**
     * Private конструктод для создания пустой заявки.
     * @param str
     */
    private Item(String str) {
        this.id = str;
    }

    /**
     * Конструктор создающий базовую заявку.
     */
    public Item() {
        this.created = new Date().getTime();
        this.id = Long.toString((this.created)/(long) (Math.random() * 100))
                    + "-" + this.hashCode();
    }

    /**
     * Геттер возвращает значение поля id.
     * @return возвращает значение поля id
     */
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
