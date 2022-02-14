import org.junit.jupiter.api.Test;
import task1.FindPairs;
import task1.PairNumber;

import java.util.List;

/**
 * Task 1. Find a solution for a unique pairs problem and demonstrate your coding style. Please use the Java
 * Collections framework for this task.
 * Write classes to find all unique pairs of numbers in a sequence that add up to 7. Example:
 * Sample Input: (-1, 2, 1, 4, 5, 1, 3, 6, 2, 8)
 * Sample output: (5, 2), (1, 6), (8, -1) and (3, 4)
 * Your code must include the following:
 * • A class to encapsulate a pair of numbers.
 * o Feel free to add features to this class that would be useful for this exercise.
 * • A utility class that finds the pairs. This must:
 * o take a list of numbers (input).
 * o Return a list of pairs of numbers (output).
 * • Comments in your code that state any assumptions you are making.
 *
 */
public class Task1Test {

    @Test
    public void pairNumberTest(){
        int[] array = new int[]{-1, 2, 1, 4, 5, 1, 3, 6, 2, 8};
        int targetSum = 7;

        List<PairNumber> results = FindPairs.findUniquePairs(array, targetSum);
        System.out.println(results.toString());

        //test 2
        array = new int[]{2,2};
        targetSum = 4;
        results = FindPairs.findUniquePairs(array, targetSum);
        System.out.println(results.toString());
    }

}
