package ru.job4j.store;

/**
 * Класс хранилище моделей User.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */
public class UserStore extends AbstractStore<User> {
    /**
     * Удаляем модель по <strong>id</strong>.
     * @param id <strong>идентификатор</strong> удаляемой заявки.
     * @return
     */
    @Override
    public boolean delete(String id) {
        Base deleteModel = new User(id);
        return super.delete(deleteModel);
    }
}
