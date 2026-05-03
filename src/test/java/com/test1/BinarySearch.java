package com.test1;

import org.testng.annotations.Test;

public class BinarySearch {

    @Test
    public void binarySearchVsLinearSearch() {
        try {
            int[] array = {1, 4, 5, 6, 7, 8, 9};
            int tar = 10;
            int low = 0;
            int high = array.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (tar == array[mid]) {
                    System.out.println(array[mid]);
                    break;
                } else if (array[mid] < tar) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
            if (low > high) {
                throw new Exception("Target not found in the array.");
            }

        } catch (Exception e) {
            throw new IndexOutOfBoundsException(String.valueOf(e));
        }

    }
}
