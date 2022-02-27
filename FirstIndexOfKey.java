package BinarySearch;

import java.util.Scanner;

/*
* We have given an array and a key element, we have to find the first index of the key element.
* This means that key element will be present multiple times, so we have to find the first index only.
*
* Example :
* Input : A = {1, 2, 4, 5, 5, 5, 6}, key = 5
* Output : 3 -> first index of key = 5 in the given array
*/
public class FirstIndexOfKey {
    public static int findFirstIndexOfKey(int[] array, int low, int high, int key){
        int indexOfKey = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == key){  // this means now we have to search only for left-hand side because first index will be at left side
                indexOfKey = mid;   // storing this index because it can be first index of the key
                high = mid - 1;
            }else if(array[mid] < key){ // if A[mid] < key then search in right-hand side
                low = mid + 1;
            }else{  // if A[mid] > key then search in left-hand side
                high = mid - 1;
            }
        }
        return indexOfKey;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();
        while (testCases-- > 0){
            System.out.println("Enter the number of elements:");
            int size = sc.nextInt();

            System.out.println("Enter elements:");
            int[] array = new int[size];
            for(int i=0 ; i<size ; i++){
                array[i] = sc.nextInt();
            }

            System.out.println("Enter key element to search:");
            int key = sc.nextInt();

            System.out.println("First index of key = " + key + " is : " + findFirstIndexOfKey(array, 0, array.length-1, key));
        }
    }
}
