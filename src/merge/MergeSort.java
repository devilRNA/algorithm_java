package merge;



import java.util.Arrays;
public class MergeSort {
    //divide
    //conquer
    //merge
    public static void main(String[] args) {
        int []arr = {4,1,7,6,9,8,5,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int []arr){
        int []temp =new int[arr.length];
        sort(arr,0,arr.length-1,temp);

    }

    private static void sort(int [] arr,int left ,int right,int [] temp){

        //divide case ; the base case is when left >= right?
        // questions : can we change the condition to arr.length < 2?
        // Answer: we cannot do that because we use array pointer to divide the arr.If so,you might get a StackFlow Error;
        if( left < right){
            int mid =(left+right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);

        }



    }
    private static void merge(int []arr ,int left ,int mid,int right ,int[] temp){
        System.out.println("Merging Array  in"+Arrays.toString(arr)+Arrays.toString(temp));
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i<=mid&&j<=right){ // giving value & move the array pointer
            if (arr[i]<=arr[j]){
                temp[t++]=arr[i++];
            }
            else {
                temp[t++]=arr[j++];
            }
        }

        while ( i <= mid){
            temp[t++] = arr[i++];
        }
        while ( j <= right){
            temp[t++] = arr[j++];
        }
        t=0;
        while ( left <= right){
            arr [left++] =temp [t++];
        }




    }




}
