package ru.job4j.checkcyclicallist;

import java.util.Objects;

/**
 * Класс проверки цикличности списка.
 * @author Artem Prokopov
 * @since 27/12/2017
 * @version 1.0
 */
public class CycleList {
    /**
     * Метод поиска цикличности в односвязном списке, с помощью цикла.
     * @param first указательн на голову списка.
     * @return true если односвязный список имеет зацикливания, в противном случае возвращает false.
     */
    public boolean hasCycleFindLoop(final Node<?> first) {
        boolean result = false;
        Node<?> turtle = null;
        Node<?> rabbit = null;
        if (first != null) {
            turtle = first;
            rabbit = turtle.next;
        }
        while (!result && rabbit != null) {
            if (rabbit.next != null
                    && rabbit.next.next != null) {
                if (turtle == rabbit
                        || turtle == rabbit.next
                        || turtle == rabbit.next.next) {
                    result = true;
                }
                rabbit = rabbit.next.next.next;
                turtle = turtle.next;
            } else {
                rabbit = null;
            }
        }
        return result;
    }
    /**
     * Метод поиска цикличности в односвязном списке.
     * @param first указательн на голову списка.
     * @return true если односвязный список имеет зацикливания, в противном случае возвращает false.
     */
    public boolean hasCycle(final Node<?> first) {
        if (Objects.isNull(first)) {
            return false;
        }
        return hasCycleList(first, first.next);
    }

    /**
     * Рекурсивный метод поиска зацикливания в односвязном списке.
     * @param turtle точка начала поиска, медленный маркер "черепаха".
     * @param rabbit точка старта поиска, быстрого маркера "кролик", должен быть на несколько шагов впереди(один или более).
     * @return true если односвязный список имеет зацикливания(встречаются равные ссылки), в противном случае возвращает false.
     */
    private boolean hasCycleList(final Node<?> turtle, final Node<?> rabbit) {
        if (Objects.isNull(rabbit)
                || Objects.isNull(rabbit.next)
                || Objects.isNull(rabbit.next.next)) {
            return false;
        }
        if (turtle == rabbit
                || turtle == rabbit.next
                || turtle == rabbit.next.next) {
            return true;
        }
        return hasCycleList(turtle.next, rabbit.next.next);
    }
}
