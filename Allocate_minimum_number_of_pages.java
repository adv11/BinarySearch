package BinarySearch;

import java.util.Scanner;

/*
Given number of pages in n different books and k students. The books are arranged in ascending order of number of pages.
Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number
of pages assigned to a student is minimum.
Example :
Input : pages[] = {12, 34, 67, 90}
        m = 2
Output : 113
Explanation:
There are 2 number of students. Books can be distributed
in following fashion :
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student
      2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student
      2 with 67 + 90 = 157 pages
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student
      1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113.
*/
public class Allocate_minimum_number_of_pages {
    public static int allocateBooks(int[] books, int n, int k){
        if(n < k){  // if number of books < number of students then return -1
            return -1;
        }
        // low <- Max element of the given array(books)
        // high <- Sum of all elements of the given array
        int low = Integer.MIN_VALUE, high = 0, res = -1;
        for(int i : books){ // storing max element in low
            if(i > low){
                low = i;
            }
        }
        for(int i : books){ // storing sum of all elements in high
            high += i;
        }
        // applying binary search
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isValid(books, n, k, mid)){  // if it is true then we found one answer, but we have to find optimal solution
                res = mid;  // that's why we are storing it in res variable
                high = mid - 1; // and appending mid-1 to high
            }else{
                low = mid + 1;  // if it is false then append mid+1 to low
            }
        }
        return res; // returning res
    }
    public static boolean isValid(int[] books, int n, int k, int mid){
        // students -> for counting students which we have allocated books
        // sum -> for checking if it is greater than mid then increase students
        int students = 1, sum = 0;
        for(int i : books){
            sum += i;
            if(sum > mid){
                students++;
                sum = i;
            }
            if(students > k){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            System.out.println("Enter the number of books:");
            int n = sc.nextInt();

            int[] books = new int[n];
            System.out.println("Enter the number of pages in each book");
            for (int i = 0; i < n; i++) {
                books[i] = sc.nextInt();
            }

            System.out.println("Enter the number of students among which we have to distribute books:");
            int students = sc.nextInt();

            System.out.println(allocateBooks(books, n, students));
        }
    }
}
