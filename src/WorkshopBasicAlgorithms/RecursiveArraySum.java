package WorkshopBasicAlgorithms;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class RecursiveArraySum {
    public static int sum(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        else {
            return nums[index] + sum(nums, index+1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        //System.out.print(Arrays.toString(nums));
        System.out.print(sum(nums, 0));
    }
}
