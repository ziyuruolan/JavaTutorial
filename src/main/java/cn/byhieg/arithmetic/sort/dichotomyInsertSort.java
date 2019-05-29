package cn.byhieg.arithmetic.sort;

/**
 * Created by weizhaoquan on 2019/05/29.
 * 二分查找型
 */
public class dichotomyInsertSort {
    static void insertSort(int[] arr){
        for (int i = 1;i<arr.length;i++ ) {
            int key = arr[i];
            int L= 0,R=i-1;
            while(L<=R){
                int mid= L+(R-L)/2;
                if (arr[mid]>key) {
                    R= mid-1;
                }else{
                    L=mid+1;
                }
            }
            for (int j = i-1;j>=L;j--) {
                arr[j+1] =arr[j];
                arr[L]=key;
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {6,3,5,7,3,7,8,9,1};
        insertSort(arr);
        System.out.printf( "1排序后的数组为 ：" );
        for (int num:arr) {
            System.out.printf(" "+num);
        }

    }
}
