package sort.advanced;

import sort.common.MySorter;

import java.util.Comparator;

import static sort.common.MyList.*;

public class QuickSort<E extends Comparable<E>> implements MySorter<E> {

    @Override
    public void sort(E[] list) {
        // 미초기화 변수 에러 해결 -> Comparable::compareTo로 메서드 위임
        sort(list, Comparable::compareTo);
    }

    @Override
    public void sort(E[] list, Comparator<E> comparator) {
        quickSort(list, 0, list.length - 1, comparator);
    }

    private void quickSort(E[] list, int p, int r, Comparator<E> comparator) {
        if (p < r) {
            // 개선 1 : 기준 원소를 임의로 선택하도록 함
            int k = (int) (Math.random() * (r - p + 1)) + p;
            swap(list, k, r);

            // partition 메서드로 comparator 전달
            int q = partition(list, p, r, comparator);
            quickSort(list, p, q - 1, comparator);
            quickSort(list, q + 1, r, comparator);
        }
    }

    private int partition(E[] list, int p, int r, Comparator<E> comparator) {
        E pivot = list[r];
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            // 미완성 구문 처리 및 Comparator 비교 사용
            int result = comparator.compare(list[j], pivot);

            if (result < 0) {
                // swap 인덱스 오타 수정 (++i, i -> ++i, j)
                swap(list, ++i, j);
            } else if (result == 0 && j % 2 == 1) { // 개선 2
                swap(list, ++i, j);
            }
        }
        swap(list, i + 1, r);
        return i + 1;
    }
}