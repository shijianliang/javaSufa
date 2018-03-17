package com.cn.alex.sort;

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
