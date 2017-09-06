package ru.job4j.user;

import java.util.HashMap;
import java.util.List;

/**
 * Класс операций над классом пользователя.
 */
public class UserConvert {
    /**
     * Преобразует List<User>  в HashMap<Integer, User>, в качестве ключам  HashMap используется поле
     * id класаа {@link User}.
     * @param list преобразуемый List.
     * @return  HashMap<Integer, User>
     */
    public HashMap<Integer, User> process(final List<User> list) {
        HashMap<Integer, User> resultMap = new HashMap<>();
        for (User user: list) {
            resultMap.put(user.getId(), user);
        }
        return resultMap;
    }
}
