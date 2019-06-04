package cn.byhieg.arithmetic.sort;

/**
 * Created by weizhaoquan on 2019/06/04.
 */
public class ShellSort {
    static void shellSort(int[] arr){
        for (int g=  arr.length;g>0;g/=2) {
            for (int end = g;end<arr.length;end++) {
                int key = arr[end],i;
                for (i= end-g;i>=0 && key <arr[i];i-=g) {
                    arr[i+g]= arr[i];
                }
                arr[i+g]= key;
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {6,3,5,7,3,7,8,9,1};
        shellSort( arr );
        System.out.printf( "1排序后的数组为 ：" );
        for (int num :arr) {
            System.out.printf( num + " " );
        }
        System.out.println(  );
    }
}
