package search.binartsearchtree;

public class BinartSearchTree<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;

    public TreeNode<K, V> search(K key){
        return search(root, key);
    }

    private TreeNode<K, V> search(TreeNode<K, V> t, K key) {
        if ( t == null ) {
            return null;
        }

        int result = key.compareTo(t.key);
        if (result == 0) {
            return t;
        } else if (result < 0) {
            return search(t.left, key);
        } else {
            return search(t.right, key);
        }
    }

    public void insert (K key, V value) {
        root = insert(root, key, value);
    }

    public TreeNode<K, V> insert(TreeNode<K, V> t, K key, V value) {
        if (t == null) {
            return new TreeNode<K, V>(key, value, null, null);
        }
        int result = key.compareTo(t.key);
        if (result < 0) {
            t.left = insert(t.left, key, value);
        } else if (result > 0){
            t.right = insert(t.right, key, value);
        } else {
            t.value = value;
        }
        return t;
    }

    public void delete(K key){
        root = findAndDelete(root, key);
    }

    private TreeNode<K, V> findAndDelete(TreeNode<K, V> t, K key) {
        if (t == null) {
            return null;
        }


        int result = key.compareTo(t.key);
        if (result == 0) {
            t = deleteNode(t);
        } else if (result < 0) {
            t.left = findAndDelete(t.left, key);
        } else {
            t.right = findAndDelete(t.right, key);
        }
        return t;
    }

    private TreeNode<K, V> deleteNode(TreeNode<K, V> r) {
        if (r.left == null && r.right == null) {
            return null; // case 1 (no child)
        } else if (r.left == null) {
            return r.right; // case 2 (only right child
        } else if (r.right == null) {
            return r.left; // case 2 (only left child)
        } else { // case 3 (two children)
            TreeNode<K, V> s = r.right;
            TreeNode<K, V> parent = null;
            while (s.left != null) {
                parent = s;
                s = s.left;
            }
            r.key = s.key;
            r.value = s.value;
            if (s == r.right) {
                r.right = s.right;
            } else {
                parent.left = s.right;
            }

            return r;
        }
    }


    // 중위 순회
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<K,V> t) {
        if (t == null) {
            return;
        }


        inorder(t.left);
        System.out.println(t.value);
        inorder(t.right);
    }
}
