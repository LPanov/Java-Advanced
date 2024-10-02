package WorkshopBasicAlgorithms.SumOfCoins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    public static int getIndex(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key < arr[mid]) {
                end = mid - 1;
            }
            else if (key > arr[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(reader.readLine());

        int result = getIndex(array, key);

        System.out.print(result);
    }
}
