package BinarySearch;
/*
* We have given an array which is sorted, but we have performed some rotation in the array.
* We have to find the key element provided by the user in the given array.
*
* Example:
* A = [11, 12, 15, 18, 2, 5 , 6, 8], key = 12
* Output : 1(index)
*
* Strategy:
* Simple find the index of the minimum element present in the array.
* Now we have to 2 sorted array : one is from index 0 to (minimum element's index - 1)
* and another one is from (minimum element's index to array.length-1)
* Now simply apply normal binary search in both parts and find the key element.
*/
import java.util.Scanner;

public class Find_element_in_rotated_sorted_array {
    // for finding index of the minimum element
    public static int findMinElementIndex(int[] array, int low, int high){
        while (low <= high){
            int mid = low + (high - low)/2;
            int preIndex = (mid - 1 + array.length) % array.length;
            int nextIndex = (mid + 1) % array.length;
            if(array[mid] <= array[preIndex] && array[mid] <= array[nextIndex])
                return mid;
            else if(array[mid] <= array[high]){
                high = mid - 1;
            }else if(array[mid] >= array[low]){
                low = mid + 1;
            }
        }
        return -1;
    }
    // for searching in the both sorted parts of the given array
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
    // for searching key
    public static int searchKey(int[] array, int key){
        // storing index of the minimum element in the array
        int minIndex = findMinElementIndex(array, 0, array.length-1);

        // there are 2 sorted parts in the array
        // one sorted part is from 0 to minIndex-1
        // other sorted part is from minIndex to array.length
        // now simply search key in both sorted parts using binary search
        int temp1 = binarySearch(array, 0, minIndex-1, key);
        int temp2 = binarySearch(array, minIndex, array.length-1, key);

        // if both return -1 then key value is not present in the array so simply return -1
        if(temp1 == -1 && temp2 == -1){
            return -1;
        }
        // else return +ve index
        return temp1 == -1 ? temp2-1 : temp1-1;
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

            System.out.println("Index of the key element is : " + searchKey(array, key));
        }
    }
}
