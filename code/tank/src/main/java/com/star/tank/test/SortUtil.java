package com.star.tank.test;

import java.util.Comparator;

public class SortUtil<T> {
    public void sortUp(T[] arr,Comparator comparaotr){
        for( int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++) {
                if (comparaotr.compare(arr[i], arr[j]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
