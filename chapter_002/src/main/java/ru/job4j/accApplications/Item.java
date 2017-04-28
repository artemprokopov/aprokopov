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
     * Константа ссылающаяся на массив 0 длины, означающий пустой массив.
     */
    public final static Item[] NULL_ITEM_ARRAY = new  Item[0];

    /**
     * Константа пустой заявки с id равному строке empty.
     */
    public static final Item EMPTY_ITEM = new Item("empty");
    /**
     * Поле id содержит уникальную идентификационную строку заявки.
     */
    private final String id;

    /**
     *  Поле name содержит имя создавшего заявку
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
     * Добавляет комментарий
     * @param comments
     */
    protected void setComments(String[] comments) {
        this.comments = comments;
    }

    /**
     * Добавляет комментарий к заявке.
     * @param comment содержание комментария
     * @return возвращает true, если комментарий добавлен успешно, иначе false.
     */
    public boolean addComments(String comment) {
        boolean result = false;
        if (this.comments.length == 0) {
            this.comments = new String[]{comment};
            result = true;
        } else {
            String[] temp = new String[this.comments.length + 1];
            System.arraycopy(this.comments, 0, temp, 0, this.comments.length);
            temp[temp.length - 1] = comment;
            this.comments = temp;
            result = true;
        }
        return result;
    }

    /**
     * Удаляет комментарий из заявки.
     * @param delComment удаляемый комментарий.
     * @return возвращает true если операция зовершена успешно, иначе возвращает false.
     */
    public boolean deletComments(String delComment) {
        boolean result = false;
        if (this.comments.length != 0) {
            for (int i = 0; i < this.comments.length; i++) {
                if (delComment.equals(this.comments[i])) {
                    String[] temp = new String[this.comments.length - 1];
                    System.arraycopy(this.comments, 0, temp, 0, i);
                    System.arraycopy(this.comments, i + 1, temp, i, this.comments.length - i - 1);
                    this.comments = temp;
                    result = true;
                    break;
                }
            }
        }
        return  result;
    }

    /**
     * Обновляет указанный комментарий.
     * @param upComment обновляемый комментарий.
     * @param newComment новый комментарий.
     * @return вовращает true если операция завершена успешно, иначе возвращает false/
     */
    public boolean updateComment(String upComment, String newComment) {
        boolean result = false;
        if (this.comments.length != 0) {
            for (int i = 0; i < this.comments.length; i++) {
                if (upComment.equals(this.comments[i])) {
                    this.comments[i] = newComment;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод сравнения объектов Item по полю id.
     * @param item объект с которым сравниваем.
     * @return true если поля равны.
     */
    public boolean equalsId (Item item) {
        return this.id.equals(item.id);
    }

    /**
     * Перегружаем метод equals класса Object.
     * @param obj объект с которым сравниваем.
     * @return true если объекты равны, иначе false.
     */
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
