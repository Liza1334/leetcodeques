import java.util.*;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    public static void backtrack(int[] nums,
                                 List<Integer> current,
                                 List<List<Integer>> result) {

        // Base case
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Don't use an element twice
            if (current.contains(nums[i])) {
                continue;
            }

            current.add(nums[i]);        // choose

            backtrack(nums, current, result); // explore

            current.remove(current.size() - 1); // undo
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(permute(nums));
    }
}