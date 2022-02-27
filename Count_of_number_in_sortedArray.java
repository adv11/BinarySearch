package BinarySearch;
/*
* We are given a problem where we have to find the number of occurrences of the given key value.
* We have that the array is sorted.
* Example :
* A = [2, 4, 10, 10, 10, 18, 20], key = 10
* Output : 3

* Key Point : Find the first and last index of the key and simply print (Last index - first index + 1)
* because the array is sorted.
*/
import java.util.Scanner;

public class Count_of_number_in_sortedArray {
    // finding first index
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
    // finding last index
    public static int findLastIndexOfKey(int[] array, int low, int high, int key){
        int indexOfKey = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == key){  // if the mid-index element is the key element then store it because it can be the last index of the key element
                indexOfKey = mid;   // and now search for last index of key element on the right side of the mid-index.
                low = mid + 1;
            }else if(array[mid] < key){ // if A[mid] < key then search right side of the mid-index
                low = mid + 1;
            }else{  // if A[mid] > key then search left side of the mid-index
                high = mid - 1;
            }
        }
        return indexOfKey;
    }
    public static int countFreq(int[] a, int low, int high, int key){
        return (findLastIndexOfKey(a, 0, a.length-1, key) - findFirstIndexOfKey(a, 0, a.length-1, key) + 1);
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

            System.out.println("Enter key element to search it's count in the array:");
            int key = sc.nextInt();

            System.out.println("Frequency of the key = " + key + " is : " + countFreq(array, 0, array.length-1, key));
        }
    }
}
