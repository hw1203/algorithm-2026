package app.student;

import sort.basic.InsertionSort;
import sort.common.MyList;
import sort.common.MySorter;

public class StudentMain {
//     본인 포함, 이 클래스에 있는 학생 10명 리스트로 만들기
    static void main(){
        Student[] studentList = {
                new Student("1길동", 31, 1, 0.5),
                new Student("2길동", 32, 2, 1.0),
                new Student("3길동", 33, 3, 1.5),
                new Student("4길동", 34, 4, 2.0),
                new Student("5길동", 35, 5, 2.5),
                new Student("6길동", 36, 6, 3.0),
                new Student("7길동", 37, 7, 3.5),
                new Student("8길동", 38, 8, 4.0),
                new Student("9길동", 39, 9, 4.5),
                new Student("10길동", 30, 10, 0.0),

        };

        MySorter<Student> sorter = new InsertionSort<>();
        sorter.sort(studentList);
        MyList.println(studentList);
    }
}
