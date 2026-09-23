package search.basic;

import search.common.MySearcher;

import java.util.Comparator;

public class SequentialSearch<E extends Comparable<E>> implements MySearcher<E> {
    @Override
    public int search(E[] list, E target) {
//        for (int i = 0; i < list.length; i++) {
//            if (list[i].equals(target)) {
//                return i;
//            }
        int i = 0;
        while (i < list.length) {
            if (list[i].equals(target)) {
                return i;
            }
            i++;
        }
        return -1;

    }

    @Override
    public int search(E[] list, E key, Comparator<E> comparator) {
        return 0;
    }
}
