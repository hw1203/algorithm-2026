package algoritmdesign;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 성능 측정(Performance Measurement)
public class PerformanceTest {
    public static void main(String[] args){
//        List<String> list = new ArrayList<>(); // 배열 리스트
        List<String> list = new LinkedList<>(); // 연결 리스트

        long startTime; long endTime;

        startTime = System.nanoTime();
        for ( int i = 0; i < 10000; i++){
            list.add (0, String.valueOf(i));
        }

        // 배열 리스트 일때 걸리는 시간
        // 1, 2, 3, ... n
        // n^2에 비례 <- ?

        // 연결 리스트 일때 걸리는 시간
        // 1, 1, 1, ... 1
        // n에 비례

        endTime = System.nanoTime();

        System.out.printf("%-17s %8d ns \n"," 알고리즘 수행 시간: ", (endTime - startTime));
    }
}
