import java.util.*;

class FirstSubsequenceOfSumK {
   private static void printArr(List<Integer> ans){
        for(int i =0;i<ans.size();++i){
            System.out.print(ans.get(i)+ " ");
        };
        System.out.println();
    }
    private static boolean printAllSubsequencesOfSumK(int[] arr, int target, List<Integer> ds, int sum, int i) {
        if(sum == target || i >= arr.length){
            if(sum == target){
                printArr(ds);
                return true;
            }
            return false;
        }
        ds.add(arr[i]);
        if(printAllSubsequencesOfSumK(arr, target, ds, sum + arr[i], i+1))return true;
        ds.remove(ds.size() - 1);
        if(printAllSubsequencesOfSumK(arr, target, ds, sum, i+1))return true;
        return false;
    }
    private static void solve(int[] arr, int target){
        List<Integer> ds = new ArrayList<>();
        printAllSubsequencesOfSumK(arr, target, ds, 0, 0);
    }
    public static void main(String[] args){
        System.out.println("hello world");
        int[] arr = {3, 2, 1, 6};
        solve(arr, 6);
    }
};