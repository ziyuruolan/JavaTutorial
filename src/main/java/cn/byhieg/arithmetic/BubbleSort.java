package cn.byhieg.arithmetic;

/**
 * Created by weizhaoquan on 2019/04/17.
 */
public class BubbleSort {
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
        System.out.printf( "排序后的数组为：" );
        for (int num :ints) {
            System.out.printf( num+" " );
        }
    }
}
