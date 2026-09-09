    package sort;
    import sort.basic.BubbleSort;
    import sort.basic.InsertionSort;
    import sort.basic.SelectionSort;

    public class SortMain{
        static void main() {

            Integer[] intList = { 8, 31, 48, 73, 3, 65, 20, 29, 11, 15};
//            MySort<Integer> sorter = new SelectionSort<>();
//            MySorter<Integer> sorter = new BubbleSort<>();
            MySorter<Integer> sorter = new InsertionSort<>();
            sorter.sort(intList);
            MyList.print(intList);

            Double[] doubleList = { 8.0, 31.0, 48.0, 73.0, 3.0, 65.0, 20.0, 29.0, 11.0, 15.0};
            MySorter<Double> doubleSorter = new BubbleSort<>();
            doubleSorter.sort(doubleList);
            MyList.print(doubleList);

            String[] stringsList = { "8", "31", "48", "73", "3", "65", "20", "29", "11", "15"};
            MySorter<String> stringSorter = new BubbleSort<>();
            stringSorter.sort(stringsList);
            MyList.print(stringsList);



        }
}