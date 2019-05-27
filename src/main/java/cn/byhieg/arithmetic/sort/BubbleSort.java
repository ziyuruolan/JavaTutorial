package cn.byhieg.arithmetic.sort;

/**
 * Created by weizhaoquan on 2019/04/17.
 */
public class BubbleSort {

    static void swap (int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void bubbleSort1(int[] arr){
        for (int end = arr.length-1;end>0;end--) {
            boolean isSort = true;
            for (int i = 0 ;i<end;i++) {
                if (arr[i]>arr[i+1]) {
                    swap( arr,i,i+1 );
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    public static int[] bubbleSort(int[] array){
        if (array.length == 0) {
            return array;
        }
        for (int i = 0;i<array.length-1;i++) {
            for (int j=0;j<array.length -1-i;j++ ) {
                if (array[j+1]<array[j]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,5,7,3,7,8,9,1};
        int[] ints = bubbleSort( arr );
        System.out.printf( "1排序后的数组为：" );
        for (int num :ints) {
            System.out.printf( num+" " );
        }
        System.out.println(  );
        int[] arr1 = {6,3,5,7,3,7,8,9,1};
        bubbleSort1( arr1 );
        System.out.printf( "2排序后的数组为：" );
        for (int num :arr1) {
            System.out.printf( num+" " );
        }
    }
}
