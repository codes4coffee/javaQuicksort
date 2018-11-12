import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 10;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = random.nextInt(20);
            System.out.println(arr[i]);
        }
        quickSortDriver(arr);
        System.out.println("=============================================================================");
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }

    public static void quickSortDriver(int[] arr) {
        quickSort(arr,arr.length - 1, 0);
    }

    private static void quickSort(int[] unsorted, int right, int left) {
        int i = left;
        int j = right;
        swapElements(unsorted, left, right);
        int pivot = unsorted[right];
        j--; //Move the right pointer so the pivot is ignored
        while(j >= i) {
            while(i+1 < unsorted.length && unsorted[++i] < pivot);
            while(j-1 > -1 && unsorted[--j] > pivot);
            if( i <= j)
                swapElements(unsorted, i, j);
        }
        swapElements(unsorted, i, right);
        if(left != 0){
            if(left != i - 1 && i - 1 > -1){
                quickSort(unsorted, i -1, left);
            }
        }

        if(right != unsorted.length - 1){
            if(right != i + 1 && i + 1 < unsorted.length){
                quickSort(unsorted, right, i + 1);
            }
        }
    }

    private static void swapElements(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
