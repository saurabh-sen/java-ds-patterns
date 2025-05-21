import java.util.*;

class CombinationSum1 {

    private static void print(List<Integer> ds) {
        for (int item : ds) {
            System.err.print(item+" ");
        }
        System.err.println();
    }

    private static void combinationSum1(int i, List<Integer> ds, int[] arr, int target) {
        // BASE CASE
        if (i >= arr.length) {
            if (target == 0) {
                print(ds);
            }
            return;
        }
        if(target < 0) {
            return;
        }

        // RECURSIVE CALLS
        // TRICK::: PICK ITEM AND DON'T INCREASE INDEX
        ds.add(arr[i]);
        combinationSum1(i, ds, arr, target - arr[i]);

        // NOT PICK ITEM AND INCREASE THE INDEX
        ds.remove(ds.size() - 1);
        combinationSum1(i + 1, ds, arr, target);
    }

    private static void solve(int[] arr, int target) {
        List<Integer> ds = new ArrayList<>();
        combinationSum1(0, ds, arr, target);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7 };
        int target = 7;
        solve(arr, target);
    }
}