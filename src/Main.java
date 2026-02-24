//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] prices = {9, 1, 4, 7, 5, 2, 3, 8};
        // testSorting("Selection", prices);
        testSorting("insertion", prices);
    }

    public static void testSorting(String type, int[] original) {

        //allocates new memory
        int[] arr = original.clone();
        long start = System.nanoTime();

        switch (type) {
            case "Selection":
                selectionSort(arr);
                break;
            case "insertion":
                insertionSort(arr);
                break;
        }
        long end = System.nanoTime();
        printArray(arr);
        System.out.println(type + " Sort time: " + (end - start) + " ns");

    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
//{999, 199, 499, 1499, 50, 700, 1200, 300}
        for (int i = 0; i < arr.length - 1; i++) {

            //on first scan pass we consider first element as min and then compare with other elements
            //if next element is min then update value of minIndex and scan the complete array to find out minimum element
            //and then swap that min element with zero index element
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

    }

    public static void insertionSort(int[] arr) {
//{9, 1, 4, 7, 5, 2, 3, 8};
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }


    }
}