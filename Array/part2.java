package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class part2 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i=0;i<nums.length;i++){//{0,1,0,3,12}
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        while(j<nums.length){
            nums[j] = 0;
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }

    void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){ //time - O(n) space - o(1) 
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }

    void RightShift(int[] arr){
        int last = arr.length;
        for(int i=arr.length-1;i>0;i--){
            arr[i] = arr[i-1];
        }

        arr[0] = last;
        System.out.println(Arrays.toString(arr));
    }

    void rightShiftbyK(int[] arr,int k){// time = O(n) space - O(k)  --> better approach reverse array 
        //reverse approach --> time - O(n) space - O(1)

        //int[] kElements = new int[k];
        //int j =0;
        int n = arr.length;
        k = k%n;
        /*for(int i=n-k;i<n;i++){
            kElements[j++] = arr[i]; 
        }
        for(int i=n-1;i>=k;i--){
            arr[i]=arr[i-k];
        }
        for(int i=0;i<k;i++){
            arr[i] = kElements[i];
        }
        System.out.println(Arrays.toString(arr));
        */

        //reverse whole array
        reverse(arr,0,n-1);

        //reverse the first k elements
        reverse(arr, 0, k-1);

        //reverse the remaining elements
        reverse(arr, k, n-1);

        System.out.println(Arrays.toString(arr));
    }

    void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    void unionElemets(int[] one,int[] two){
        HashSet<Integer> set = new HashSet<>();//? using HashSet - add unique elements

        for(int n:one){
            set.add(n);
        }

        for(int n:two){
            set.add(n);
        }

        System.out.println(set);
    }


    void findMode(int[] arr){//time - O(n) space - O(n)
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n:arr){
            map.put(n,map.getOrDefault(n, 0)+1);

        }

        
        int maxfreq = -1;
        int maxkey = -1;
        for(int key : map.keySet()){
            int currentKey = key;
            int currentfreq = map.get(key);
            if(currentfreq > maxfreq){
                maxfreq = currentfreq;
                maxkey = currentKey;
            }
        }
        System.out.println(maxkey +"appears" +maxfreq);
    }

    void highestAndlowestfreq(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        System.out.println(map);

        //highest and lowest freq
        int highestfreq = Integer.MIN_VALUE;
        int highestfreqElement = -1; 

        int lowestfreq = Integer.MAX_VALUE;
        int lowestfreqElement = -1;

        for(int key:map.keySet()){//{1,2,3,4}
            System.out.println(key);
            int currentkey = key;
            int currentfreq = map.get(key);
            if(highestfreq < currentfreq){
                highestfreq = currentfreq;
                highestfreqElement = currentkey;
            }

            if(lowestfreq > currentfreq){
                lowestfreq = currentfreq;
                lowestfreqElement = currentkey;
            }
        }
        System.out.println("Highest frequency element: " + highestfreqElement + " : " + highestfreq);
        System.out.println("Lowest frequency element: " + lowestfreqElement + " : " + lowestfreq);
    }

    public void main(){
        
        //*Q1 */
        int[] nums = {0,1,0,3,12};//
        moveZeroes(nums);

        //*Q2 - Reverse an array*/
        int[] arr = {1,2,3,4,5};
        reverseArray(arr);

        //*Q3 - shift array element by 1 position */
        int[] array = {1,2,3,4,5,6}; //? [6,1,2,3,4,5] 
        RightShift(array);


        //*Q4 - shift array element by k position */
        int[] arr2 = {1,2,3,4,5,6};
        int k=2;
        rightShiftbyK(arr2, 3);

        //*Q5 - Union of two array(all elements without dublication) */

        int[] one = {1,2,3,4,5};
        int[] two = {4,5,6,7,8};
        unionElemets(one, two);

        //*Q6 - find mode of an array */

        int[] arr4 = {1, 2, 2, 3, 3,3,3};//mode --> highest frequency of an element in an array
        findMode(arr4);

        //*Q7 - find element with highest and lowest frequency */

        int[] arr7 = {2,1,3,1,3,1,4,1,4,1,4,1};
        highestAndlowestfreq(arr7);
    }
}
