package BinarySearch;
/*
* We have given an array of characters in sorted order and a key element. We have to find the next
* alphabetic greater character than key element. If next greater element is not present then return
* null.
*
* Example:
* A = [a, b, c, d, e], key = e
* Output : null
*
* A = [a, b, c, d, e], key = c
* Output : d
*/
import java.util.Scanner;

public class Next_alphabetic_order {
    public static Object nextAlphabeticElement(char[] array, char key){
        int low = 0, high = array.length-1;
        char ans = '#';
        while (low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == key){
                low = mid + 1;
            }else if(array[mid] < key){
                low = mid + 1;
            }else{
                ans = array[mid];
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter test cases:");
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            System.out.println("Enter the size of the array:");
            int size = sc.nextInt();
            System.out.println("Enter the elements of the array:");
            char[] array = new char[size];
            for (int i = 0; i < size; i++) {
                array[i] = sc.next().charAt(0);
            }
            System.out.println("Enter key element:");
            char key = sc.next().charAt(0);

            System.out.println("Next greater element than given key is : " + nextAlphabeticElement(array, key));
        }
    }
}
