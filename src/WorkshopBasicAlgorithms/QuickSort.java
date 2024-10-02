package WorkshopBasicAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
    private static void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(int a[], int n)
    {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        sort(array);
        printArray(array, array.length);
    }
}
