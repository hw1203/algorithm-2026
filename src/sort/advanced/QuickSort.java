package sort.advanced;

import sort.common.MyList;
import sort.common.MySorter;

import static sort.common.MyList.*;

public class QuickSort<E extends Comparable<E>> implements MySorter<E> {
    @Override
    public void sort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private void quickSort(E[] list, int p, int r) {
        if ( p < r ) {
            // 개선 1 : 기준 원소를 임의로 선택하도록 함
            int k = (int) (Math.random() * (r - p + 1)) + p;
            swap(list, k, r);

            int q = partition(list, p, r);
            quickSort(list, p, q - 1);
            quickSort(list, q + 1, r);
        }
    }

    private int partition(E[] list, int p, int r) {

        E pivot = list[r];

        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if (list[j].compareTo(pivot) < 0) {
                swap(list, ++i, i);
            } else if (list[j].compareTo(pivot) == 0 && j % 2 == 1) { // 개선 2
                swap(list, ++i, j);
            }
        }
        swap(list, i + 1, r);
        return i + 1;
    }
}
