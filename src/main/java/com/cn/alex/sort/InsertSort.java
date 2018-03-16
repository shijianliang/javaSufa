package com.cn.alex.sort;

/**
 * 直接插入排序
 */
public class InsertSort {
    public void inserSort(int [] a){
        for(int i=1;i<a.length;i++){
            int j;
            int x =a[i];
            for(j=i;j>0&&x<a[j-1];j--){
                a[j]=a[j-1];
            }
            a[j]=x;
        }

    }
    public void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 19};
//        for (int i = 0; i < arr.length; i++) {
//            int j=i;
//            while (j >= 0 && arr[j] > arr[j + 1]) {
//                int tem = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = tem;
//                j--;
//            }
//            if( i>=arr.length-2){
//                break;
//            }
//        }
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
        InsertSort insertSort =new InsertSort();
        insertSort.printArr(arr);
        insertSort.inserSort(arr);
        insertSort.printArr(arr);
    }
}
