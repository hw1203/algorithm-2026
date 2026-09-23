package search.basic;

import search.common.MySearcher;

import java.util.Comparator;

import static java.util.Arrays.binarySearch;

public class RecurBinarySearch <E extends Comparable<E>> implements MySearcher<E> {

    @Override
    public int search(E[] list, E target) {
        return binarySearch(list, 0, list.length -1, target);
    }

    @Override
    public int search(E[] list, E key, Comparator<E> comparator) {
        return 0;
    }

    private int binarySearch(E[] list, int low, int high, E target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (target.equals(list[mid])) {
            return mid;
        } else if (target.compareTo(list[mid]) < 0) {
            return binarySearch(list, low, mid -1, target);
        } else {
            return binarySearch(list, mid + 1, high, target);
        }
    }
}
