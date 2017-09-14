package ru.job4j.referencesort;

import java.util.Comparator;
/**
 * Class comparator, sorts descending TreeSet.
 * @author Artem Prokopov
 * @since 15/09/2017
 * @version 1.0
 */
public class ComparatorSetStringDescending implements Comparator<String> {
    /**
     *  Compares two strings.
     * @param o1 the {@code String} to be compared.
     * @param o2 the {@code String} to be compared.
     * @return the value {@code 0} if the argument o1 string is equal to
     *          argument o2 string, a value less than {@code 0} if o1 string
     *          is lexicographically less than the string argument o2; and a
     *          value greater than {@code 0} if this string is
     *          lexicographically greater than the string argument.
     */
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        String[] st1 = o1.trim().split("\\\\");
        String[] st2 = o2.trim().split("\\\\");
        for (int i = 0; i < st1.length && i < st2.length && result == 0; i++) {
            result = st2[i].compareTo(st1[i]);
        }
        if (result == 0) {
            result = o1.length() - o2.length();
        }
        return result;
    }
}