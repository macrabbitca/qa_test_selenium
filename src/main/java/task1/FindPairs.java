package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the pairs  in a given array class.
 *
 * @author Jim Wang
 * @createTime 2022-02-09
 */
public class FindPairs {

    /**
     * Find the non  duplicate pairs and the pair's sum equal target sum.
     *
     * @param array     input array
     * @param targetSum target sum
     * @return non duplicate pairs List
     */
    public static List<PairNumber> findUniquePairs(int[] array, int targetSum) {
        List<PairNumber> resultList = new ArrayList<>();
        // if the array is null or the array's element quantity less than 2 , will return empty list
        if (array == null || array.length < 2) {
            return resultList;
        }
        //sort array first
        Arrays.sort(array);

        int leftIndex = 0;
        int rightIndex = array.length - 1;


        while (leftIndex < rightIndex) {
            int currentSum = array[rightIndex] + array[leftIndex];
            // found the pair that sum mach the target sum
            if (currentSum == targetSum) {
                PairNumber currentPair = new PairNumber();
                currentPair.setNumber1(array[leftIndex]);
                currentPair.setNumber2(array[rightIndex]);
                resultList.add(currentPair);

                //shift the left index and right index
                leftIndex++;
                rightIndex--;

                // skip same element to avoid duplicate pairs
                while (leftIndex < rightIndex && array[leftIndex] == array[leftIndex - 1]) {
                    leftIndex++;
                }
                // skip same element to avoid duplicate pairs
                while (leftIndex < rightIndex && array[rightIndex] == array[rightIndex + 1]) {
                    rightIndex--;
                }
            } else if (currentSum > targetSum) {
                // we need a pair with a bigger sum
                rightIndex--;
            } else {
                // we need a pair with a smaller sum
                leftIndex++;
            }
        }
        return resultList;
    }
}
