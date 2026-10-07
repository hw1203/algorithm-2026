package sort.basic;

import sort.common.MySorter;

import java.util.Comparator;

public class InsertionSort<E extends Comparable<E>> implements MySorter<E> {

    @Override
    public void sort(E[] list) {
        sort(list, Comparable::compareTo);
    }

    @Override
    public void sort(E[] list, Comparator<E> comparator) {
        for (int i = 1; i < list.length; i++) {
            E newItem = list[i];
            int j = i - 1;

            // Comparable 대신 전달받은 Comparator 사용
            for (; j >= 0 && comparator.compare(newItem, list[j]) < 0; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = newItem;
        }
    }
}