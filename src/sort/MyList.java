package sort;

public class MyList {
    public static <E> void print(E[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static <E> void swap(E[] list, int i, int j) {
        E tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
}
