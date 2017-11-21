package ru.job4j.store;

import ru.job4j.simplearray.SimpleArray;

import java.util.Objects;

/**
 * Абстрактное ранилище моделей.
 * @param <T> Тип элементов хранилища, допускаются типы расширяющие тип {@link Base}.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
     * Контейнер хранилища моделей.
     */
    private final SimpleArray<Base> simpleArray = new SimpleArray<>();

    /**
     * Переопределяем методы интерфейса {@link Store#add(Base)}.
     * @param model добавляемая модель.
     * @return добавленная модель.
     */
    @Override
    public T add(T model) {
        simpleArray.add(model);
        return model;
    }

    /**
     * Переопределяем методы интерфейса {@link Store#update(Base)}.
     * Метод {@link Base#equals(Object)} сравнивает по <strong>id</strong>,
     * метод {@link SimpleArray#findItem(Object)} производить линейный поиск, сравнивая
     * объекты с помощью переобределенного метода equals.
     * @param model обновляемая модель.
     * @return обновленная модель.
     */
    @Override
    public T update(T model) {
        int updateIndex = simpleArray.findItem(model);
        simpleArray.update(updateIndex, model);
        return model;
    }
    /**
     * Переопределяем методы интерфейса {@link Store#delete(String)}.
     * @param deleteModel  удаляемая модель заявки.
     * @return <strong>true</strong> если удаление прошло успешно, в противном случае возвращает
     * <strong>false</strong>.
     */
    protected boolean delete(Base deleteModel) {
        Base result = simpleArray.delete(deleteModel);
        return Objects.nonNull(result);
    }
}
