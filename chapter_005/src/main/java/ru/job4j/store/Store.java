package ru.job4j.store;

/**
 * Интерфейс хранилища моделей.
 * @param <T> Тип элементов хранилища, допускаются типы расширяющие тип {@link Base}.
 * @author Aretm Prokopov
 * @since 21/11/2017
 * @version 1.0
 */
public interface Store<T extends Base> {
    /**
     * Добавление элемента в хранилище.
     * @param model добавляемая модель.
     * @return добавленную модель.
     */
    T add(T model);

    /**
     * Обновляет модель в хранилище.
     * @param model обновляемая модель.
     * @return обновленную мадель.
     */
    T update(T model);

    /**
     * Удаляем модель по <strong>id</strong>.
     * @param id <strong>идентификатор</strong> удаляемой заявки.
     * @return <strong>true</strong> если удаление прошло успешно, в противном случае возвращает
     * <strong>false</strong>.
     */
    boolean delete(String id);
}
