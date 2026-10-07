package sort.basic;

import sort.common.MySorter;

import java.util.Comparator;

import static sort.common.MyList.swap;

public class SelectionSort<E extends Comparable<E>> implements MySorter<E> {

    @Override
    public void sort(E[] list) {
        sort(list, Comparable::compareTo);
    }

    @Override
    public void sort(E[] list, Comparator<E> comparator) {
        for (int last = list.length - 1; last > 0; last--) {
            int largest = 0;
            for (int i = 1; i <= last; i++) {
                if (comparator.compare(list[i], list[largest]) > 0) {
                    largest = i;
                }
            }
            swap(list, largest, last);
        }
    }
}