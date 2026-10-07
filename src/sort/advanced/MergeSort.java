package sort.advanced;

import sort.common.MySorter;

import java.util.Comparator;

public class MergeSort<E extends Comparable<E>> implements MySorter<E> {

    @Override
    public void sort(E[] list) {
        // 정의되지 않은 comparator 호출 오류 수정 -> Comparable::compareTo로 메서드 위임
        sort(list, Comparable::compareTo);
    }

    @Override
    public void sort(E[] list, Comparator<E> comparator) {
        if (list == null || list.length <= 1) {
            return;
        }
        mergeSort(list, 0, list.length - 1, comparator);
    }

    private void mergeSort(E[] list, int p, int r, Comparator<E> comparator) {
        if (p < r) {
            int q = p + (r - p) / 2;
            mergeSort(list, p, q, comparator);
            mergeSort(list, q + 1, r, comparator);
            merge(list, p, q, r, comparator);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(E[] list, int p, int q, int r, Comparator<E> comparator) {
        int i = p;
        int j = q + 1;
        int t = 0;

        E[] tmp = (E[]) new Comparable[r - p + 1];

        while (i <= q && j <= r) {
            if (comparator.compare(list[i], list[j]) <= 0) {
                tmp[t++] = list[i++];
            } else {
                tmp[t++] = list[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = list[i++];
        }
        while (j <= r) {
            tmp[t++] = list[j++];
        }

        i = p;
        t = 0;
        while (i <= r) {
            list[i++] = tmp[t++];
        }
    }
}