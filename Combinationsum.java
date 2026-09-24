import java.util.*;

public class Combinationsum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public static void backtrack(int[] candidates, int target, int start,
                                 List<Integer> current,
                                 List<List<Integer>> result) {

        // Target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            current.add(candidates[i]);  // choose

            // i, NOT i + 1
            // because we can reuse the same number
            backtrack(candidates,
                      target - candidates[i],
                      i,
                      current,
                      result);

            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }
}