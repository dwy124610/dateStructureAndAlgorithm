package com.dwy.sparseArray;

import java.util.Arrays;

/**稀疏数组：稀疏数组 ---> 数组中有很多无效数据，压缩数组
 * @example:
 * 原数组:
 *               0 0 0 0 0 0 0 0 0 0 0
 *               0 0 1 0 0 0 0 0 0 0 0
 *               0 0 0 0 2 0 0 0 0 0 0
 *               0 0 0 0 0 0 0 0 0 0 0
 *               0 0 0 0 0 0 0 0 0 0 0
 *               0 0 0 0 0 0 0 0 0 0 0
 *               0 0 0 0 0 0 0 0 0 0 0
 *               0 0 0 0 0 0 0 0 0 0 0
 *               0 0 0 0 0 0 0 0 0 0 0
 *               0 0 0 0 0 0 0 0 0 0 0
 *               0 0 0 0 0 0 0 0 0 0 0
 * 稀疏数组:
 *               11 11 2
 *               1  2  1
 *               2  4  2
 * @Author: DongWenYu
 * @Date: 2021/5/30 19:40
 */
public class SparseArrayApplication {
    /**
     * <p>
     *     稀疏数组可以简单的看作为是压缩，在开发中也会使用到。比如将数据序列化到磁盘上，减少数据量，在IO过程中提高效率等等。
     *
     *     <p>
     *         为什么要进行压缩？
     *              - 由于稀疏矩阵中存在大量的“空”值，占据了大量的存储空间，而真正有用的数据却少之又少，
     *              - 且在计算时浪费资源，所以要进行压缩存储以节省存储空间和计算方便。
     *     </p>
     *
     * </p>
     * @param args
     */
    public static void main(String[] args) {
        //初始化数组
        int[][] array = getInitArray();
        //输出原始数组
        System.out.println("原始数组:");
        soutArray(array);
        //生成稀疏数组并输出
        int[][] sparseArray = getSparseArray(array);
        System.out.println("稀疏数组:");
        soutArray(sparseArray);
        //稀疏数组转为原始数组并输出
        int[][] arrayBySparseArray = getArrayBySparseArray(sparseArray);
        System.out.println("由稀疏数组转化来的数组:");
        soutArray(arrayBySparseArray);
        System.out.println("array ?= arrayBySparseArray: "+ Arrays.deepEquals(array, arrayBySparseArray));
    }

    /**
     * 将稀疏数组转化为原始数组
     * @param sparseArray 稀疏数组
     * @return int[][]
     * @create 2021/5/30 20:22
     */
    private static int[][] getArrayBySparseArray(int[][] sparseArray) {
        //通过稀疏数组的第一行初始化原始数组
        int row = sparseArray[0][0];
        int column = sparseArray[0][1];
        int[][] array = new int[row][column];
        //遍历稀疏数组，填充原始数组非0值
        for (int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }
    /**
     * 通过原始数组得到稀疏数组
     * @param array 原始数组
     * @return int[][]
     * @create 2021/5/30 20:20
     */
    private static int[][] getSparseArray(int[][] array) {
        //sum为非0数据的总个数
        int sum = getSum(array);
        //根据sum初始化稀疏数组大小
        int[][] sparseArray = new int[sum+1][3];
        //根据sum和array得到稀疏数组第一行
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;
        //遍历数组得到稀疏数组。
        //count表示放入了几个非0数
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0){
                    sparseArray[count+1][0] = i;
                    sparseArray[count+1][1] = j;
                    sparseArray[count+1][2] = array[i][j];
                    count++;
                }
            }
        }
        return sparseArray;
    }

    /**
     * 得到数组中有多少个非0值
     * @param array 原始数组
     * @return int
     * @create 2021/5/30 20:21
     */
    private static int getSum(int[][] array) {
        int sum = 0;
        for (int[] row : array) {
            for (int item : row) {
                if (item != 0){
                    sum ++;
                }
            }
        }
        return sum;
    }

    /**
     * 初始化数组
     * @return int[][] 
     * @create 2021/5/30 19:57
     */
    private static int[][] getInitArray() {
        int[][] array = new int[11][11];
        array[1][1] = 1;
        array[2][2] = 2;
        array[3][3] = 3;
        return array;
    }

    /**
     * 输出数组
     * @param array 
     * @return void 
     * @create 2021/5/30 20:21
     */
    private static void soutArray(int[][] array){
        for (int[] row : array) {
            for (int item : row) {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }
}
