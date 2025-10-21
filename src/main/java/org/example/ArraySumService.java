package org.example;

public class ArraySumService {
    public int sumArray(int[] arr){
        if(arr.length == 0){
            throw new IllegalArgumentException("Array is empty");
        }
        int tong = 0;
        for (int i = 0; i<arr.length; i++){
            if(arr[i] < 0 || arr[i] > 1000){
                throw new IllegalArgumentException("Phan tu nam trong khoang tu 0 den 1000");
            }
            tong += arr[i];
        }
        return tong;
    }
}
