package ru.job4j.sort;

/**
 * Класc описания User.
 * @author Artem Prokopov
 * @since 07.09.2017
 * @version 1.0
 */
public class User implements Comparable<User> {
    /**
     * Поле имя User.
     */
    private final String name;
    /**
     * Поле возраст User.
     */
    private final int age;

    /**
     * Конструктор.
     * @param initName инициализируем поле name.
     * @param initAge инициализируем поле age.
     */
    public User(final String initName, final int initAge) {
        name = initName;
        age = initAge;
    }

    /**
     * Переопределяем метод интерфейса Comparable, compareTo.
     * @param o сравниваемый объект.
     * @return 0 если поля age объектов равны, 1 если age > o.age, в противном случае -1.
     * Если o == null то возвращает 1.
     */
    @Override
    public int compareTo(final User o) {
        if (o == null) {
            throw new NullPointerException("The argument is null!");
        }
        int result = age != o.age ? age > o.age ? 1 : -1 : 0;
//        if (result == 0) {
//            result =  name.compareTo(o.getName());
//        }
        return  result;
    }

    /**
     * Переопределяем equals.
     * @param o объект с которым сравниваем.
     * @return true если объекты равны, в противном случае false.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return age == user.age && name.equals(user.name);
    }

    /**
     * Переопределяем hashCode.
     * @return новый hashcode.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    /**
     * Переопределяем метод toString.
     * @return
     */
    @Override
    public String toString() {
        return "User{"
                + "name='"
                + name
                + '\''
                + ", age="
                + age
                + '}';
    }

    /**
     * Геттер для age.
     * @return {@link User#age}
     */
    public int getAge() {
        return age;
    }

    /**
     * Геттер для name.
     * @return {@link User#name}
     */
    public String getName() {
        return name;
    }
}
