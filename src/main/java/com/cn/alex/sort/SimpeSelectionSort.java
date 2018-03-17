package com.cn.alex.sort;

/**
 * 简单选择排序
 * 每次找到 最小值（最大值），然后定位该元素
 * 例如3，2，1
 * 第一次找到最小1 放到第一个位置
 * 第二次在剩下的3,2中找到最小的2 放到第二个位置
 *
 * 二元选择排序
 * 每次找大最大值和最小值
 */
public class SimpeSelectionSort {
    public void sort(int[] a){

        for(int i=0 ;i<a.length;i++){
            int k=i;
            for(int j =i; j<a.length-1 ; j++){
                if(a[k] >a[j+1]){
                    k=j+1;
                }
            }
            int tem =a[i];
            a[i]=a[k];
            a[k]=tem;

        }
    }
    public  void printArr(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {
            int[] arr={3,1,5,7,2,4,9,6,6,8,99};
            SimpeSelectionSort simpeSelectionSort =new SimpeSelectionSort();
            simpeSelectionSort.sort(arr);
            simpeSelectionSort.printArr(arr);
    }
}
