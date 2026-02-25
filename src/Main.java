public class Main {
    public static void main(String[] args) {
        int[] prices = {9, 1, 4, 7, 5, 2, 3, 8};
        testSorting("Selection", prices);
        testSorting("insertion", prices);
        testSorting("bubble", prices);
        testSorting("quick", prices);
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
            case "bubble":
                bubbleSort(arr);
                break;
            case "quick":
                quickSort(arr);
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
        //first scan from arr index 1 and keep arr index 1 as temp variable. Now compare this temp variable with index 0 element if index 0 element is
        //greater than index 1 then shift the element right
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

    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 0;
            //took arr.length-1-i in order to avoid unnecessary comparisons for elements that are already sorted.
            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;

                }

            }
            // took flag in order to avoid unnecessary swapping in case of array is sorted.
            if (flag == 0)
                break;

        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {

        // this condition is whether elements are there or not for comparison coz sorting can only be done if there are more than two elements
        if (start < end) {

            int pivotIndex = partition(arr, start, end);

            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }
    //check if pivot element is greater than array element starting at zero then element is replaced with first element from scan
    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {

            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        //returning pivot element index no
        return i + 1;
    }
}