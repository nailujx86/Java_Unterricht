package woche_2;

import java.util.Arrays;

/**
 * BubbleSort
 */
public class BubbleSort {

    static int[] sort(int[] param) {
        int sortCount;
        var param2 = param;
		do {
            sortCount = 0;
            for (int i = 0; i < param2.length - 1; i++) {
                if(param2[i] > param2[i+1]) {
                    var tmp = param2[i];
                    param2[i] = param2[i+1];
                    param2[i+1] = tmp;
                    sortCount++;
                }
            }
        } while (sortCount != 0);
        return param2;
    }

    public static void main(String[] args) {
        int arrrrray[] = {1,9,12,4848,342934,93,219};
        arrrrray = sort(arrrrray);
        System.out.println(Arrays.toString(arrrrray));
    }
}