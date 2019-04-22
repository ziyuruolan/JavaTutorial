package cn.byhieg.arithmetic;

/**
 * Created by weizhaoquan on 2019/04/08.
 */
public class TwoDimensionalArray {
    public static int[][] rotate(int[][] matrix){
        int n= matrix.length;
        int[][] m = new int[n][n];
        for (int row = 0;row < n; row ++) {
            for (int col=0;col<n;col++) {
                m[row][col] = matrix[n-1-col][row];
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[][] arry = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        int[][] rotate = rotate( arry );
        printArray(rotate);
    }

    public static void printArray(int array[][]){
        for(int i=0;i<array.length; i++) {
            for(int j = 0; j< array[i].length; j++) {
                System.out.print(array[i][j]+"、");
            }
            System.out.println();
        }
    }
}
