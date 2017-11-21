package ru.job4j.store;
/**
 * Класс хранилище моделей Role.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */
public class RoleStore extends AbstractStore<Role> {
    /**
     * Удаляем модель по <strong>id</strong>.
     * @param id <strong>идентификатор</strong> удаляемой заявки.
     * @return
     */
    @Override
    public boolean delete(String id) {
        Base deleteModel = new Role(id);
        return super.delete(deleteModel);
    }
}
