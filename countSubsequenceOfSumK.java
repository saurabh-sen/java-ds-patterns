import java.util.*;

class CountSubsequenceOfSumK {

   private static void printArr(List<Integer> ans){
        for(int i =0;i<ans.size();++i){
            System.out.print(ans.get(i)+ " ");
        };
        System.out.println();
    }

    private static int countSubsequenceOfSumK(int[] arr, int target, List<Integer> ds, int sum, int i) {
        if(sum == target || i >= arr.length){
            if(sum == target){
                printArr(ds);
                return 1;
            }
            return 0;
        }
        ds.add(arr[i]);
        int take = countSubsequenceOfSumK(arr, target, ds, sum + arr[i], i+1);
        ds.remove(ds.size() - 1);
        int notTake = countSubsequenceOfSumK(arr, target, ds, sum, i+1);
        return take + notTake;
    }

    private static void solve(int[] arr, int target){
        List<Integer> ds = new ArrayList<>();
        int ans = countSubsequenceOfSumK(arr, target, ds, 0, 0);
        System.out.println("answer "+ans);
    }

    public static void main(String[] args){
        System.out.println("hello world");
        int[] arr = {3, 2, 1, 6};
        solve(arr, 6);
    }
};