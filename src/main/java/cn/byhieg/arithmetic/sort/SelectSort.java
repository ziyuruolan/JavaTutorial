package cn.byhieg.arithmetic.sort;

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
}
