package cn.byhieg.arithmetic.sort;

import java.util.Arrays;

public class SelectSort {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void selectSort(int[] arr){
        for (int i = 0;i<arr.length;i++) {
            int minIndex =  i;
            for (int j=i+1;j<arr.length;j++) {
                minIndex = arr[j]<arr[minIndex] ? j : minIndex;
                swap(arr,i,minIndex);
            }
        }
    }

    static int[] selectSort1(int[] sourceArr){
        int[] arr = Arrays.copyOf(sourceArr,sourceArr.length);
        for (int i = 0;i<arr.length-1;i++) {
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min]) {
                    min = j;
                }
            }
            if (i!=min) {
                int temp = arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,5,7,3,7,8,9,1};
        selectSort( arr );
        System.out.printf( "1排序后的数组为 ：" );
        for (int num :arr) {
            System.out.printf( num + " " );
        }
        System.out.println(  );
        int[] arr1 = {6,3,5,7,3,7,8,9,1};
        int[] arr11 = selectSort1(arr1);
        System.out.printf( "2排序后的数组为 ：" );
        for (int num :arr11) {
            System.out.printf( num+" " );
        }
    }
}
