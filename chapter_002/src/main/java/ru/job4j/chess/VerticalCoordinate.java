package ru.job4j.chess;
/**
 * Класс перечисление задает диапазон вертиуальных координат для шахматной доски.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0*/
public enum VerticalCoordinate {
    /**
     * Диапазон от 1 до 8 вертикальной координаты шахматной доски.
     */
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8);
    /**
     * Ассоциативный номер с полем перечисления, необходим для вычислений.
     */
    private final int count;

    /**
     *  Private конструктор, задает count.
     * @param i ассоциативный номер поля.
     */
   VerticalCoordinate(int i) {
        this.count = i;
   }

    /**
     * Проверет есть ли в перечислении ледующий элемент.
     * @param verticalGradient направление движения.
     * @return в случае если следующий элемет существует возвращает true, иначе false.
     */
   public boolean hasNext(Gradient verticalGradient) {
       try {
           getType(getCount() + verticalGradient.getCountGradient());
           return true;
       } catch (VerticalCoordinateIllegalParametersException vcipe) {
           return false;
       }
   }

    /**
     * Возвращает следующий элемент в перечислении.
     * @param verticalGradient направление, +1 либо -1, направлени поиска.
     * @return следующий элеент в перечислении.
     */
   public  VerticalCoordinate getNextType(Gradient verticalGradient) {
      return getType(getCount() + verticalGradient.getCountGradient());
   }

    /**
     * Метод возвращающий элемент перечисления по его ассоциативному номеру.
     * @param reqType ассоциативный номер.
     * @return вертикальную координату по ассоциативному номеру.
     * @throws VerticalCoordinateIllegalParametersException в случае не корректоного ассоциативного номера.
     */
    public  VerticalCoordinate getType(int reqType)
            throws VerticalCoordinateIllegalParametersException {
        for (VerticalCoordinate type: VerticalCoordinate.values()) {
            if (type.getCount() == reqType) {
                return  type;
            }
        }
        throw new VerticalCoordinateIllegalParametersException("Vertical coordinate is not found!!!");
    }

    /**
     * Возвращает ассоциативный номер.
     * @return ассоциативный номер.
     */
    public int getCount() {
        return count;
    }
}
