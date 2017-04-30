package ru.job4j.accapplications;

import java.util.Arrays;
import java.util.Date;

/**
 * Класс описывающий структуру заявки.
 * @author Artem Prokopov
 * @since 27.04.2017
 * @version 1.0
 */
public class Item {

    /**
     * Константа пустой заявки с id равному строке empty.
     */
    public static final Item EMPTY_ITEM = new Item("empty");

    /**
     * Поле id содержит уникальную идентификационную строку заявки.
     */
    private final String id;

    /**
     *  Поле name содержит имя создавшего заявку.
     */
    private String name = "";

    /**
     * Поле desc содержит описание заявки.
     */
    private String desc = "";

    /**
     * Поле created содержит врея создание заявки в мс.
     */
    private  long created = 0;

    /**
     * Поле comments содержит массив строк комментариев  заявке.
     */
    private String[] comments = new String[0];

    /**
     * Private конструктод для создания пустой заявки.
     * @param str строка иницализации поля id
     */
    private Item(String str) {
        this.id = str;
    }

    /**
     * Конструктор создающий базовую заявку.
     */
    Item() {
        this.created = new Date().getTime();
        this.id = Long.toString((this.created) / (long) (Math.random() * 100))
                    + "-" + (long) (Math.random() * 1000000);
    }

    /**
     * Геттер возвращает значение поля id.
     * @return возвращает значение поля id
     */
    public String getId() {
        return id;
    }

    /**
     * Геттер возвращает значение поля name.
     * @return возвращает значение поля name
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер устанавливает значени поля name.
     * @param name имя составителя заявки.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер возвращает значение поля desc.
     * @return возвращает значение поля desc.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Сеттер учтанавливает значение поля desc.
     * @param desc передаваямое значени.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Геттер возвращает значение поля create.
     * @return возвращает значение поля create.
     */
    public long getCreated() {
        return created;
    }

    /**
     * Сеттер устанавливает время созднания или обновления заявки.
     * @param created устанавливаемое время
     */
    void setCreated(long created) {
        this.created = created;
    }

    /**
     * Сеттер устанавливает время создания или модификации заявки.
     * */
    protected void setCreated() {
        this.created = new Date().getTime();
    }

    /**
     * Геттер возвращает значение поля comments(массив комментариев).
     * @return возвращает значение поля comments.
     */
    public String[] getComments() {
        return comments;
    }

    /**
     * Добавляет комментарий.
     * @param comments массив комментариев.
     */
    protected void setComments(String[] comments) {
        this.comments = comments;
    }

    /**
     * Добавляет комментарий к заявке.
     * @param comment содержание комментария
     */
    public void addComments(String comment) {
        if (this.comments.length == 0) {
            this.comments = new String[]{comment};
        } else {
            String[] temp = new String[this.comments.length + 1];
            System.arraycopy(this.comments, 0, temp, 0, this.comments.length);
            temp[temp.length - 1] = comment;
            this.comments = temp;
        }
    }

    /**
     * Удаляет комментарий из заявки.
     * @param delComment удаляемый комментарий.
     * @return возвращает true если операция зовершена успешно, иначе возвращает false.
     */
    public boolean deletComment(String delComment) {
        if (this.comments.length != 0) {
            for (int i = 0; i < this.comments.length; i++) {
                if (delComment.equals(this.comments[i])) {
                    String[] temp = new String[this.comments.length - 1];
                    System.arraycopy(this.comments, 0, temp, 0, i);
                    System.arraycopy(this.comments, i + 1, temp, i, this.comments.length - i - 1);
                    this.comments = temp;
                    return true;
                }
            }
        }
        return  false;
    }

    /**
     * Обновляет указанный комментарий.
     * @param upComment обновляемый комментарий.
     * @param newComment новый комментарий.
     * @return вовращает true если операция завершена успешно, иначе возвращает false/
     */
    public boolean updateComment(String upComment, String newComment) {
        if (this.comments.length != 0) {
            for (int i = 0; i < this.comments.length; i++) {
                if (upComment.equals(this.comments[i])) {
                    this.comments[i] = newComment;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Метод сравнения объектов Item по полю id.
     * @param item объект с которым сравниваем.
     * @return true если поля равны.
     */
    public boolean equalsId(Item item) {
        return this.id.equals(item.id);
    }

    /**
     * Метод сравнения объектов Item по содержанию полей кроме уникального поля id,
     * и даты создания.
     * @param item объект с которым сравниваем.
     * @return true если поля равны.
     */
    public boolean equalsItem(Item item) {
        if (!this.name.equals(item.name)) {
            return false;
        }
        if (!this.desc.equals(item.desc)) {
            return false;
        }
        return Arrays.deepEquals(this.comments, item.comments);
    }

    /**
     * Метод получения копии объекта Item с сохранением уникального поля id,
     * и даты создания created.
     * @return копию объекта Item с сохранением idб и даты создания created.
     */
    public Item getCopyItemSafeIdAndCreated() {
        Item item = new Item(this.id);
        item.setName(this.name);
        item.setDesc(this.desc);
        item.setCreated(this.created);
        item.setComments(this.comments);
        return  item;
    }

    /**
     * Метод получения копии объекта Item с созданием уникального поля id,
     * и новой даты создания created.
     * @return копию объекта Item с сохранением id.
     */
    public Item getCopyItemWithNewIdAndCreated() {
        Item item = new Item();
        item.setName(this.name);
        item.setDesc(this.desc);
        item.setComments(this.comments);
        return  item;
    }

    /**
     * Перегружаем метод equals класса Object.
     * @param o объект с которым сравниваем.
     * @return true если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (this.created != item.created) {
            return false;
        }
        if (!this.id.equals(item.id)) {
            return false;
        }
        if (!this.name.equals(item.name)) {
            return false;
        }
        if (!this.desc.equals(item.desc)) {
            return false;
        }
        return Arrays.deepEquals(this.comments, item.comments);
    }

    /**
     * Перегружаем метод hashCode.
     * @return возвращает hashCode.
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + desc.hashCode();
        result = 31 * result + (int) (created ^ (created >>> 32));
        result = 31 * result + Arrays.hashCode(comments);
        return result;
    }
}
