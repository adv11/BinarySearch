package BinarySearch;

import java.util.Scanner;

/*
* In this problem, we have given an array of distinct elements which is in sorted order, but we don't know the order of sorting
* whether it is ascending or descending in nature. We have given a key, we have to find the index
* of the element in the given. If element is not present then return -1.
*/
public class SortingOrderNotKnown {
    // for ascending order
    public static int binarySearch(int[] array, int low, int high, int key){
        while(low <= high){
            int mid = (low + high)/2;   // or we can use mid = (((high - low) / 2) + low)  for ignoring integer overflow

            // if the mid-index element == key then return index = mid + 1;
            if(array[mid] == key)
                return mid+1;
            else if(array[mid] < key)   // if array[mid] < key then low = mid + 1;
                low = mid + 1;
            else
                high = mid - 1; // if array[mid] > key then high = mid - 1;
        }
        return -1;  // if key element is not present in the array then return -1
    }
    // for descending order
    public static int binarySearchReverse(int[] array, int low, int high, int key){
        while(low <= high){
            int mid = low + (high - low)/2; // for getting rid of integer overflow
            if(array[mid] == key)
                return mid+1;
            else if(array[mid] > key){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            // size of the array
            System.out.println("Enter the number of elements in the array:");
            int size = sc.nextInt();

            // taking input
            System.out.println("Enter the elements in sorted order:");
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
            }

            // taking input for key element to search
            System.out.println("Enter the key element to search in the array:");
            int key = sc.nextInt();


            // This is a base case.
            // Because for array's length == 1 then it is both in ascending and descending order.
            // so simply check if the 0 indexed element is the key or not, if yes then return 1 else return -1
            if(array.length == 1 && array[0] == key)
                System.out.println("Index of key : 1");
            else if(array.length == 1 && array[0] != key)
                System.out.println("Index of key : -1");
            else{
                boolean checkOrder = true;
                if(array[0] > array[1])     // it means array is sorted in descending order
                    checkOrder = false;

                if(checkOrder)  // array is sorted in ascending order
                    System.out.println("Index of key is : " + binarySearch(array, 0, array.length-1 , key));
                else
                    System.out.println("Index of key is : " + binarySearchReverse(array, 0, array.length-1, key));
            }
        }
    }
}
