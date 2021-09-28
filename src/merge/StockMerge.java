package merge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * this code is intended to implement an Example of  Algorithm Introduction .Chapter IV
 */

public class StockMerge {
    public static void main(String[] args) {
        int []arr = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
        int []delta=delta_arr(arr);
        System.out.println(Arrays.toString(delta));
        Map<String,Double> result=find_max_subarray(delta, 0,delta.length-1);
        System.out.println(result);
    }

    //need a function to get delta of Array (stock price delta)

    public static int[] delta_arr(int []arr){
        int j = 0;
        int []temp =new int[arr.length-1];
        for (int i =1;i<= arr.length-1;i++){
            temp[j++]=arr[i]-arr[i-1];
        }
        return temp;
    }

    public static Map<String,Double> find_max_crossing_subarray(int []arr,int low,int mid,int high){
        int leftsum = Integer.MIN_VALUE;
        int sum = 0;
        int max_left=0;
        int max_right=0;
        for (int i=mid;i >= low;i--){
            sum += arr[i];
            if (sum > leftsum){
                leftsum = sum;
                max_left=i;
            }
        }
        int rightsum = Integer.MIN_VALUE;
        sum = 0;
        for (int j =mid +1;j <= high;j++){
            sum+=arr[j];
            if (sum >rightsum){
                rightsum=sum;
                max_right=j;
            }
        }
        Map<String,Double> result =new HashMap<>();
        result.put("max_left", (double) max_left);
        result.put("max_right", (double) max_right);
        result.put("total", (double) (leftsum+rightsum));
        return result;
    }

    public static Map<String,Double> find_max_subarray(int []arr,int low,int high){
        Map<String,Double> result =new HashMap<>();
        if (high == low){
            result.put("max_left", (double) low);
            result.put("max_right", (double) high);
            result.put("total", (double) arr[low]);
            return result;
        }
        else {
            int mid = (low+high)/2;
            Map<String,Double> result_1 = find_max_subarray(arr,low,mid);
            Map<String,Double> result_2 = find_max_subarray(arr,mid+1,high);
            Map<String,Double> result_3 = find_max_crossing_subarray(arr,low,mid,high);

            if (result_1.get("total")>result_2.get("total") && result_1.get("total")>result_3.get("total")){
                return result_1;
            }
            else if (result_2.get("total")>result_1.get("total") && result_2.get("total")>result_3.get("total")){
                return result_2;
            }
            else {
                return result_3;
            }
        }


    }

}
