package search;

import search.basic.IterBinarySearch;
import search.basic.RecurBinarySearch;
import search.basic.SequentialSearch;

public class SearchMain {
    static void main() {
        Integer[] list = new Integer[] { 10, 12, 13, 14, 17, 19, 25, 27, 30, 35, 40, 45, 47};

        //순차검색
//        SequentialSearch<Integer> search = new SequentialSearch<>();
//        int index = search.search(list, 17);
//        if (index >= 0) {
//            System.out.println("17은" + index + "위치에 있습니다.");
//        } else {
//            System.out.println("17은 리스트에 없습니다.");
//        }
//
//        index = search.search(list, 19);
//        if (index >= 0) {
//            System.out.println("19은" + index + "위치에 있습니다.");
//        } else {
//            System.out.println("19은 리스트에 없습니다.");
//        }

        //이진검색
        IterBinarySearch<Integer> searcher = new IterBinarySearch<>();
        int index1 = searcher.search(list, 17);
        if (index1 >= 0) {
            System.out.println("17은" + index1 + "위치에 있습니다.");
        } else {
            System.out.println("17은 리스트에 없습니다.");
        }

        index1 = searcher.search(list, 20);
        if (index1 >= 0) {
            System.out.println("20은" + index1 + "위치에 있습니다.");
        } else {
            System.out.println("20은 리스트에 없습니다.");
        }

        index1 = searcher.search(
                list,
                20,
                (a, b) -> Integer.compare(b, a) //lambda
        );


        //재귀 알고리즘
//        RecurBinarySearch<Integer> searcher1 = new RecurBinarySearch<>();
//        int index2 = searcher1.search(list, 17);
//        if (index2 >= 0) {
//            System.out.println("17은" + index2 + "위치에 있습니다.");
//        } else {
//            System.out.println("17은 리스트에 없습니다.");
//        }
//
//        index2 = searcher1.search(list, 19);
//        if (index2 >= 0) {
//            System.out.println("19은" + index2 + "위치에 있습니다.");
//        } else {
//            System.out.println("19은 리스트에 없습니다.");
//        }


    }
}
