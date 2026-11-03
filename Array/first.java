package Array;

import java.util.Scanner;

public class first {
    void getAverage(int[] arr){
        double Sum = 0;
        int n = arr.length;
        for(int a : arr){
            Sum = Sum + a;
        }
        double avg = Sum/n;
        System.out.println("Average of all element in an Array: " + avg);
    }


    int[] multiplyBy10(int[] arr){
        int size = arr.length;
        int[] newArray = new int[size];

        for(int i=0;i<size;i++){
            int Element = arr[i];
            int newElement = Element * 10;
            newArray[i] = newElement;
        }
        //return new Array
        return newArray;
    }

    int findElement(int[] arr,int target){
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    int findMax(int[] arr){
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            /*if(max < arr[i]){
                max = arr[i];
            }*/
           //using math.max() - return the greatest of 2 number
           max = Math.max(max, arr[i]);
        }
        return max;
    } 

    int[] getPosandNegSum(int[] arr){
        int postiveSum = 0;
        int negativeSum = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= 0){
                postiveSum = postiveSum + arr[i];
            }
            else{
                negativeSum = negativeSum + arr[i];
            }
        }
        int[] Sum = {postiveSum,negativeSum}; 
        return Sum;
    }

    int[] countZeroandOne(int[] arr){
        int countZeroes = 0;
        int countOne = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                countZeroes++;
            }
            else{
                countOne++;
            }
        }
        int[] count = {countZeroes,countOne};
        return count;
    }

    int firstUnsorted(int[] arr){
        int element;
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= arr[i+1]){
                element = arr[i+1];
                return element;
            }
        }
        return -1;
    }

    int[] swapAlternate(int[] arr){
        int[] swap;
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
            i++;
        }
        return arr;
    }

    int[] intersectionElement(int[] one,int[] two){
        int[] common = new int[Math.min(one.length, two.length)];
        int k =0;
        for(int i=0;i<one.length;i++){
            for(int j=0;j<two.length;j++){
                if(one[i] == two[j]){
                    common[k] = one[i];
                    k++;
                    break;
                }
            }
        }
        return common;
    }



    void main(String[] args) {
        //*Q1 - Average of array element */
        int []arr = {2,4,7,1,3};
        //getAverage(arr);

        //*Q2 - Multipy each element of an array by 10 */
        int[] arr2 = {1,2,3,4};
        int[] ans = multiplyBy10(arr2);
        for(int a : ans){
            //sSystem.out.println(a);
        }

        //*Q3 - Find the element in an array (Linear Search)*/
        int[] arr3 = {2,4,1,8,9,10};
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter the target element: ");
        //int target = sc.nextInt();
        //System.out.println("Find at index: " + findElement(arr3,target));

        //*Q4 - Max element in an array */
        int[] arr4 = {3,18,1,12,30,24};
        int Max = findMax(arr4);
        System.out.println("Max value in an array: " + Max);


        //*Q5 - return sum of positive and negative number */

        int[] arr5 = {-3,12,-19,28,9,-4};
        int[] Ans = getPosandNegSum(arr5);
        //System.out.println("Sum of Positive Number: " + Ans[0]);
        //System.out.println("Sum of Negative Number: " + Ans[1]); 

        //*Q6 - Count the number of Zeroes and ones */

        int[] arr6 = {0,1,0,1,1,0,1,0,0,1};
        int[] Count = countZeroandOne(arr6);
        int Zeroes = Count[0];
        int One = Count[1];
        //System.out.println("Number of Zeroes: " + Zeroes);
        //System.out.println("Number of One: " + One);

        //*Q7 - Find first unsorted element in array */

        int[] arr7 = {3,4,7,2,8,10};
        int firstUnsortedElem = firstUnsorted(arr7);
        System.out.println("First Unsorted Element: " + firstUnsortedElem);

        //*Q8 - Swap alternate element in an array */
         
        int[] arr8 = {1,2,3,4,5,6};
        int[] Swap = swapAlternate(arr8);
        for(int a : Swap){
            //System.out.println(a);
        } 

        //*Q9 - Intersection element present in two array */

        int[] one = {2,3,4,5};
        int[] two = {3,4,6,7};
        int[] common = intersectionElement(one, two);
        for(int e : common){
            System.out.println(e);
        }
    }
}
