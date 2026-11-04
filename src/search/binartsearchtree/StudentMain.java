package search.binartsearchtree;

import java.util.ArrayList;
import java.util.List;

public class StudentMain {
    static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        BinartSearchTree<String, Student> bst = new BinartSearchTree<>();

        bst.insert("홍길동", new Student("홍길동", 21, 20220101, 4.1));
        bst.insert("김길동", new Student("김길동", 22, 20220101, 4.1));
        bst.insert("이길동", new Student("이길동", 25, 20220101, 4.1));
        bst.insert("박길동", new Student("박길동", 19, 20220101, 4.1));

        bst.insert(studentList.get(0).name(), studentList.get(0));
        bst.insert(studentList.get(0).name(), studentList.get(1));
        bst.insert(studentList.get(0).name(), studentList.get(2));
        bst.insert(studentList.get(0).name(), studentList.get(3));

        bst.inorder();

        TreeNode<String, Student> findNode = bst.search("김길동");
        if (findNode == null) {
            System.out.println("값을 찾을 수 없습니다.");
        } else {
            System.out.println(findNode.value);
        }

        BinartSearchTree<Integer, Student> bstAge = new BinartSearchTree<>();
        bstAge.insert(studentList.get(0).age(), studentList.get(0));
        bstAge.insert(studentList.get(0).age(), studentList.get(1));
        bstAge.insert(studentList.get(0).age(), studentList.get(2));
        bstAge.insert(studentList.get(0).age(), studentList.get(3));

        bst.inorder();

        TreeNode<Integer, Student> findNodeAge = bstAge.search(19);
        if (findNodeAge == null) {
            System.out.println("값을 찾을 수 없습니다.");
        } else {
            System.out.println(findNodeAge.value);
        }

        bstAge.delete(19);
        bstAge.inorder();

    }
}
