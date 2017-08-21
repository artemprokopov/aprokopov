package ru.job4j.chess;
/**
 * Класс перечисление задает диапазон горизонтаьных координат для шахматной доски.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */

public enum HorizontalCoordinate {
    /**
     * Диапазон от a до h горизонтальной координаты шахматной доски.
     */
    a(1), b(2), c(3), d(4), e(5), f(6), g(7), h(8);
    /**
     * Ассоциативный номер с полем перечисления, необходим для вычислений.
     */
    private final int count;
    /**
     *  Private конструктор, задает count.
     * @param i ассоциативный номер поля.
     */
   HorizontalCoordinate(int i) {
        this.count = i;
    }
    /**
     * Проверет есть ли в перечислении седующий элемент.
     * @param horizontalGradient направление движения.
     * @return в случае если следующий элемет существует возвращает true, иначе false.
     */
    public boolean hasNext(Gradient horizontalGradient) {
        try {
            getType(getCount() + horizontalGradient.getCountGradient());
            return true;
        } catch (HorizontalCoordinateIllegalParametrsException hcipe) {
            return false;
        }
    }
    /**
     * Возвращает следующий элемент в перечислении.
     * @param horizontalGradient направление, +1 либо -1, направлени поиска.
     * @return следующий элеент в перечислении.
     * @throws HorizontalCoordinateIllegalParametrsException в случае не корректной координаты.
     */
    public  HorizontalCoordinate getNextType(Gradient horizontalGradient)
            throws HorizontalCoordinateIllegalParametrsException {
        return getType(getCount() + horizontalGradient.getCountGradient());
    }

    /**
     * Метод возвращающий элемент перечисления по его ассоциативному номеру.
     * @param reqType ассоциативный номер.
     * @return новую горизонтальную координатую
     * @throws HorizontalCoordinateIllegalParametrsException в случае не корректоного ассоциативного номера.
     */
    public  HorizontalCoordinate getType(int reqType)
            throws HorizontalCoordinateIllegalParametrsException {
        for (HorizontalCoordinate type: HorizontalCoordinate.values()) {
            if (type.getCount() == reqType) {
                return  type;
            }
        }
        throw new HorizontalCoordinateIllegalParametrsException("Horizontal coordinate is not found!!!");
    }
    /**
     * Возвращает ассоциативный номер.
     * @return ассоциативный номер.
     */
    public  int getCount() {
        return count;
    }
}
