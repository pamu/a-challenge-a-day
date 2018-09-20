package com.achallengeaday.solution;

import com.achallengeaday.tree.TreeNode;

import java.util.HashSet;

public class Solution {


    public static void main(String... args) {
        TreeNode tree = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(8, null, null)));
        int sum = 10;

        int result = countPairs(tree, 10);

        System.out.println("number of pairs are: " + result);
    }

    /**
     * Strategy would be
     * <p>
     * Start a root.
     * <p>
     * When ever you see a node. Take the value of the node and then
     * Subtract the value from the sum. Now keep the result in a
     * Set. Now when you go to any node. Check if the value of that node is
     * already present in the set and then remove that value from the set.
     */

    public static int countPairs(TreeNode node, int sum) {
        helper(node, sum);
        return pairsCount;
    }

    private final static HashSet<Integer> secondValueSet = new HashSet<>();
    private static int pairsCount = 0;

    private static void helper(TreeNode node, int sum) {
        if (node == null) return;

        // Action 1
        if (secondValueSet.contains(node.value)) {
            pairsCount += 1;
            secondValueSet.remove(node.value); // count each pair once
            System.out.println("pair (" + (sum - node.value) + ", " + node.value + ")");
        }

        // Action 2
        int secondValue = sum - node.value; // (node.value + (sum - (node.value)) = sum
        secondValueSet.add(secondValue);

        helper(node.left, sum);
        helper(node.right, sum);
    }


    // Target is 10

    // Travel from top to bottom
    // Visit 5 then 3 ....
    // When we visit a node
    //
    // 1. Result = Sum - node value
    // 2. Check is the Result is already present in the set
    // 3. Its already available
    //    1. Remove
    //    2. Inc + 1 the count
    // 4. Its not present
    //    1. Add the Result the set
    // O (n)

    // (5, 5) = 10

    // 10 - 3 = Second value or Pair

    // Set() // empty

    //
}
