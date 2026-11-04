package search.binartsearchtree;

public class Main {
    static void main(){
        BinartSearchTree<Integer, Integer> bst = new BinartSearchTree<>();
        bst.insert(30, 30);
        bst.insert(20, 20);
        bst.insert(25, 25);
        bst.insert(40, 40);
        bst.insert(10, 10);
        bst.insert(35, 35);

        bst.inorder();

        TreeNode<Integer, Integer> findNode = bst.search(25);
        if (findNode == null) {
            System.out.println("값을 찾을 수 없습니다.");
        } else {
            System.out.println(findNode.value);
        }

        bst.delete(25);

        bst.inorder();
    }
}
