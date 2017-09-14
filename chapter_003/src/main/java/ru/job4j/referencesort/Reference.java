package ru.job4j.referencesort;

import java.util.Set;
import java.util.TreeSet;

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
    private final Set<String> storageReference = new TreeSet<>();

    /**
     * Constructor.
     * @param st array initialization reference units.
     */
    public Reference(String[] st) {
        initTreeSet(st);
    }

    /**
     * The method converts the array representation of the reference units.
     * @param initSt convertible array.
     */
    private void initTreeSet(String[] initSt) {
        for (String s: initSt) {
            String[] temp = s.trim().split("\\\\", -1);
            StringBuilder stb = new StringBuilder(temp[0]);
            storageReference.add(stb.toString());
            for (int i = 1; i < temp.length ; i++) {
                stb.append("\\").append(temp[i]);
                storageReference.add(stb.toString());
            }
        }
    }

    public String[] getReferenceArrayAscending() {
        TreeSet<String> temp = new TreeSet(new ComparatorReferenceString().reversed());
        temp.addAll(storageReference);
        return temp.toArray(new String[storageReference.size()]);
    }

    public String[] getReferenceArrayDescending() {
        return storageReference.toArray(new String[storageReference.size()]);
    }
}

