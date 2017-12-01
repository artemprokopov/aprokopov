package ru.job4j.store;

/**
 * Абстрактный класс для моделей.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */
public abstract class Base {
    /**
     * Поле хранение Id.
     */
    private String id;

    /**
     * Конструктор, инициализирует поле {@link Base#id} передаваемым рпараметром <strong>initId</strong>.
     * @param initId параметр инициализирующий поле <strong>id</strong>.
     */
    public Base(String initId) {
        this.id = initId;
    }

    /**
     * Геттер.
     * @return поле {@link Base#id}
     */
    public String getId() {
        return id;
    }

    /**
     * Сеттер.
     * @param id новое значение поля {@link Base#id}.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Переопределяем метод <strong>equals</strong>.
     * @param o объект с которым идет сравнение.
     * @return <strong>true</strong> если объекты равны.
     */
    @Override
    public  boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Base)) {
            return false;
        }

        Base base = (Base) o;

        return id.equals(base.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
