package cn.byhieg.arithmetic.sort;

import java.util.Arrays;

/**
 * Created by weizhaoquan on 2019/05/29.
 */
public class InsertSort {
    static int[] insertSort(int[] sourceArr){
        int[] arr = Arrays.copyOf(sourceArr,sourceArr.length);
        for (int i = 1;i<arr.length;i++) {
            int  temp = arr[i];
            int j = i;
            while (j>0 && temp<arr[j-1]) {
                arr[j]=arr[j-1];
                j--;
            }
            if (j!=i) {
                arr[j] = temp;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,5,7,3,7,8,9,1};
        int[] arrs = insertSort( arr );
        System.out.printf( "1排序后的数组为 ：" );
        for (int num :arrs) {
            System.out.printf( num + " " );
        }

    }
}
