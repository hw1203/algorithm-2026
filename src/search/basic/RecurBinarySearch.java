package search.basic;

import search.common.MySearcher;

import java.util.Comparator;

public class RecurBinarySearch<E extends Comparable<E>> implements MySearcher<E> {

    @Override
    public int search(E[] list, E target) {
        // 인자 5개 전달
        return binarySearch(list, 0, list.length - 1, target, Comparator.naturalOrder());
    }

    @Override
    public int search(E[] list, E target, Comparator<E> comparator) {
        // 인자 5개 전달
        return binarySearch(list, 0, list.length - 1, target, comparator);
    }

    // 매개변수를 정확히 5개로 선언
    private int binarySearch(E[] list, int low, int high, E target, Comparator<E> comparator) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        int result = comparator.compare(target, list[mid]);

        if (result == 0) {
            return mid;
        } else if (result < 0) {
            // 재귀 호출 시에도 인자 5개 전달
            return binarySearch(list, low, mid - 1, target, comparator);
        } else {
            // 재귀 호출 시에도 인자 5개 전달
            return binarySearch(list, mid + 1, high, target, comparator);
        }
    }
}