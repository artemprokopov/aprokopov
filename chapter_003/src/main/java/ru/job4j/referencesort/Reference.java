package ru.job4j.referencesort;

import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;

/**
 * Class of reference units.
 * @author Artem Prokopov
 * @since 14/09/2017
 * @version 1.0
 */
public class Reference {
    /**
     * Field saves reference units.
     */
    private final List<String[]> storageReference = new LinkedList<>();

    /**
     * Constructor.
     * @param st array initialization reference units.
     */
    public Reference(String[] st) {
        init(st);
    }

    /**
     * Init {@link Reference#storageReference}.
     * @param st array of string for initializes {@link Reference#storageReference};
     */
    private void init(String[] st) {
        Set<String> tempSet = new HashSet<>();
        for (String s : st) {
            String[] temp = s.trim().split("\\\\", -1);
            StringBuilder stringBuilder = new StringBuilder(temp[0]);
            tempSet.add(stringBuilder.toString());
            for (int i = 1; i < temp.length; i++) {
                stringBuilder.append("\\").append(temp[i]);
                tempSet.add(stringBuilder.toString());
            }
        }
        for (String string: tempSet) {
            storageReference.add(string.split("\\\\", -1));
        }
    }

    /**
     * The method returns structured ascending array of strings.
     * @return array of strings structured ascending.
     */
    public String[] getReferenceArrayAscending() {
        return getStrings(new ComparatorSetStringAscending());
    }

    /**
     * The method returns structured descending array of strings.
     * @return array of strings structured ascending.
     */
    public String[] getReferenceArrayDescending() {
        return getStrings(new ComparatorSetStringDescending());
    }

    /**
     * Creates array of strings from {@link Reference#storageReference} structured using a comparator.
     * @param setStringComparator comparator from ordering {@link Reference#storageReference};
     * @return array of strings structured using a comparator.
     */
    private String[] getStrings(Comparator<String[]> setStringComparator) {
        List<String> list = new LinkedList<>();
        storageReference.sort(setStringComparator);
        for (String[] sa: storageReference) {
            StringBuilder stringBuilder = new StringBuilder(sa[0]);
            for (int i = 1; i < sa.length; i++) {
                stringBuilder.append("\\").append(sa[i]);
            }
            list.add(stringBuilder.toString());
        }
        return list.toArray(new String[list.size()]);
    }
}

