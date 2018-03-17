package com.cn.alex.sort;

/**
 *   堆排序
 *   最小堆 ： 所有叶子节点 都小于自己的子节点
 *   分为两步： 1.建堆  2.对顶元素与堆最后一个元素交换位置
 */
public class HeapSort {

    public void create(int [] data,int last){
        for(int i=last;i>0;i--){
            int parent =(i-1)/2;
            if(data[parent]>data[i]){
                swap(data,parent,i);
            }
        }
    }

    public  void swap(int[] data,int i,int j){
        if(i == j){
            return;
        }
        data[i]=data[i]+data[j];
        data[j]=data[i]-data[j];
        data[i]=data[i]-data[j];
    }

    public void printArr(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }


    }

    public static void main(String[] args) {
        int [] a ={3,1,5,7,2,4,9,6,10,8};
        HeapSort heapSort =new HeapSort();
        for(int i=0; i<a.length;i++){
            heapSort.create(a,a.length-1-i);
            heapSort.swap(a,0,a.length-1-i);
            System.out.println(i+"*****************");
            heapSort.printArr(a);
            System.out.println();
        }
        System.out.println("zuihou");
        heapSort.printArr(a);

    }
}
