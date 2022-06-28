// Combination Sum (https://leetcode.com/problems/combination-sum/)

// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return result;

        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path) {
        // base
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (i == candidates.length || target < 0) {
            return;
        }

        // logic

        // not choose
        helper(candidates, target, i + 1, new ArrayList<>(path));

        // action
        path.add(candidates[i]);

        // choose
        helper(candidates, target - candidates[i], i, new ArrayList<>(path));

        // Back-tracking
        path.remove(path.size() - 1);
    }
}