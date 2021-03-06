package ru.job4j.accapplications;

/**
 * Класс для теста консольного ввода, подменяет класс {@link ConsoleInput}.
 * Принимает параметры ввода пользователя в конструкторе
 * @see StubInput#StubInput(int, int, String...)
 * @author Artem Prokopov
 * @since 05.07.2017
 * @version 1.0
 */
public class StubInput implements Input {
    /**
     *Массив содержащий симулируеммые команды пользователя
     * инициализируется в конструкторе {@link StubInput#StubInput(int, int, String...)}.
     */
    private final String[] userInputSimulate;
    /**
     *Счетчик команд для метода ask().
     * @see StubInput#ask(String)
     */
    private int countArray = 0;
    /**
     * Поле сохраняющее первую команду по выбору пункта меню
     * инициализируется в конструкторе.
     * @see StubInput#StubInput(int, int, String...)
     */
    private final int selectMenu1;

    /**
     *Поле сохраняющее вторую команду по выбору пункта меню
     * инициализируется в конструкторе.
     * @see StubInput#StubInput(int, int, String...)
     * В данной версии игнорируется, по умолчанию принимает
     * значение выбора пункта меню 6, выход из программы.
     */
    private final int selectMenu2;

    /**
     * Конструктор, инициализирует значения полей класса.
     * @param menuId1 первый выбираемый пункт менюб принимаемые значени от 0 .. 6, в противном случае
     *                 никаких действий не выполняется.
     * @param menuId2 второй выбираемый пункт меню, в данной версии игнорируется.
     * @param strings массив строк для использования при выполнении действий пользователя по
     *                вводу необходимой инфрмации. Количество параметров различно.
     *                1.При выборе пункта меню "0. Add new Item" {@link StubInput#selectMenu1} равно 0,
     *                необхоимо передать 3 параметра для заполнения заявки {@link Item#name}, {@link Item#desc},
     *                {@link Item#comments} .
     *                2. При выборе пункта меню "1. Show all items" {@link StubInput#selectMenu1} равно 1,
     *                возможно произвольное количество параметров,так как все параметны игнорируются.
     *                3. При выборе пункт меню "2. Edit item" {@link StubInput#selectMenu1} равно 2,
     *                необходимо передать 4 параметра {@link Item#id} индификатор редактируемой заявки
     *                и три редактируемых параметр {@link Item#name}, {@link Item#desc}, {@link Item#comments} .
     *                4. При выборе "3. Delete item" {@link StubInput#selectMenu1} равно 3, необходимо
     *                передать 1 параметр {@link Item#id} индификатор удаляемой заявки.
     *                5. При выборе "4. Find item by Id"  {@link StubInput#selectMenu1} равно 4, необходимо
     *                передать 1 параметр {@link Item#id} индификатор заявки для которой выполняется поиск.
     *                6. При выборе "5. Find items by name"  {@link StubInput#selectMenu1} равно 5, необходимо
     *                передать 1 параметр {@link Item#name} имя поля заявки для которого выполняется поиск.
     */
    public StubInput(int menuId1, int menuId2, String... strings) {
        userInputSimulate = strings;
        selectMenu1 = menuId1;
        selectMenu2 = 6;
    }

    /**
     * Имплементируемый метод интерфейса {@link Input#ask(String)}
     * для симулирования запросов пользователя.
     * @param question параметр запроса.
     * @return result строку ответ на пользовательский запрос, в данном варианте автономно.
     */
    @Override
    public String ask(String question) {
        String result = "";
        switch (question) {
            case "Select: ":
                result = Integer.toString(selectMenu1);
                ++countArray;
                break;
            case "Enter you name: ":
                result = userInputSimulate[0];
                break;
            case "Enter desc: ":
                result = userInputSimulate[1];
                break;
            case "Enter comments: ":
                result = userInputSimulate[2];
                ++countArray;
                break;
            case "Enter application id to edit: ":
                result = userInputSimulate[0];
                break;
            case "Enter new name: ":
                result = userInputSimulate[1];
                break;
            case "Enter new desc: ":
                result = userInputSimulate[2];
                break;
            case "Enter new comments: ":
                result = userInputSimulate[3];
                ++countArray;
                break;
            case "Enter application id to delete: ":
                result = userInputSimulate[0];
                ++countArray;
                break;
            case "Enter application id to find: ":
                result = userInputSimulate[0];
                ++countArray;
                break;
            case "Enter name to find Item: ":
                result = userInputSimulate[0];
                ++countArray;
                break;
            default:
                ++countArray;
                result = "";
        }
        return result;
    }

    /**
     * Имплементируемый метод интерфейса {@link Input#ask(String, int, int)}.
     * @param question параметр запроса.
     * @param rangMin нижняя граница возвращаемого целочисленного параметра
     * @param rangeMax верхняя граница диапазона возвращаемого целочисленного параметра
     * @return номер выбранного пункта меню, либо {@link StubInput#selectMenu1} или
     * {@link StubInput#selectMenu2}.
     */
    public int ask(String question, int rangMin, int rangeMax)  {
        countArray++;
        return countArray < 2 ? selectMenu1 : selectMenu2;
    }
}
