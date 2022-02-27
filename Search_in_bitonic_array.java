package BinarySearch;
/*
* We have given an array(bitonic array) in which we have to search an element.
* Bitonic array is the array which increases up to a certain point and after that point it will decrease
*
* Example:
* A = [1, 3, 8, 12, 4, 2], key = 4
* Output : 4
*
*
* Key point :
* 1) Find the index(maxIndex) element of the max element in the array.
* 2) Then we have 2 sub-arrays one from 0 to maxIndex-1 (sorted in ascending order)
* 3) and another one is from maxIndex to a.length-1 (sorted in descending order)
* 4) Now apply binary search for first sub-array for ascending order.
* 5) and apply binary search for second sub-array for descending order.
* 6) if both return -1 then key is not present.
* 7) else print the index which is not -1.
*/
import java.util.Scanner;

public class Search_in_bitonic_array {
    // Binary search for ascending order sorted array
    public static int binarySearchAscendingOrder(int[] array, int key, int low, int high){
        while (low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == key){
                return mid;
            }else if(array[mid] > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    // Binary search for descending order sorted array
    public static int binarySearchDescendingOrder(int[] array, int key, int low, int high){
        while (low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == key){
                return mid;
            }else if(array[mid] > key){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    // finding the index of the peak element
    // so that we can divide the array in to 2 parts
    // left part : ascending order (0 to maxEleIndex-1)
    // right part : descending order (maxEleIndex to a.length-1)
    public static int findIndexOfMaxEle(int[] array){
        int low = 0, high = array.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(mid > 0 && mid < array.length-1){
                if(array[mid] > array[mid-1] && array[mid] > array[mid+1]){
                    return mid;
                }else if(array[mid] < array[mid-1]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else if(mid == 0){
                if(array[mid] > array[1]){
                    return mid;
                }else{
                    return 1;
                }
            }else{
                if(array[mid] < array[array.length-1]){
                    return array.length-1;
                }else{
                    return mid;
                }
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


            int maxEleIndex = findIndexOfMaxEle(array);
            int b1 = binarySearchAscendingOrder(array, key, 0, maxEleIndex-1);
            int b2 = binarySearchDescendingOrder(array, key, maxEleIndex, array.length-1);
            if(b1 == -1 && b2 == -1){
                System.out.println("Key not present in the array.");
            }else{
                int ans = b1 != -1 ? b1 : b2;
                System.out.println("Key is present at index : " + ans);
            }
        }
    }
}
