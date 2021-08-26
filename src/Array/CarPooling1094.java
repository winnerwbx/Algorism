package Array;

import java.util.Arrays;

/**
 * //There is a car with capacity empty seats. The vehicle only drives east (i.e.,
 * //it cannot turn around and drive west).
 * //
 * // You are given the integer capacity and an array trips where trip[i] = [
 * //numPassengersi, fromi, toi] indicates that the iᵗʰ trip has numPassengersi passengers
 * //and the locations to pick them up and drop them off are fromi and toi
 * //respectively. The locations are given as the number of kilometers due east from the car's
 * //initial location.
 * //
 * // Return true if it is possible to pick up and drop off all passengers for all
 * //the given trips, or false otherwise.
 * //
 * //
 * // Example 1:
 * //
 * //
 * //Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * //Output: false
 * //
 * //
 * // Example 2:
 * //
 * //
 * //Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * //Output: true
 * //
 * //
 * // Example 3:
 * //
 * //
 * //Input: trips = [[2,1,5],[3,5,7]], capacity = 3
 * //Output: true
 * //
 * //
 * // Example 4:
 * //
 * //
 * //Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * //Output: true
 * //
 * //
 * //
 * // Constraints:
 * //
 * //
 * // 1 <= trips.length <= 1000
 * // trips[i].length == 3
 * // 1 <= numPassengersi <= 100
 * // 0 <= fromi < toi <= 1000
 * // 1 <= capacity <= 10⁵
 */
public class CarPooling1094 {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] journeyDiff = new int[1001];
            Arrays.fill(journeyDiff, 0);
            for (int[] trip : trips) {
                journeyDiff[trip[1]] += trip[0];
                journeyDiff[trip[2]] -= trip[0];
            }
            int[] journey = new int[1001];
            int length = journeyDiff.length;
            journey[0] = journeyDiff[0];
            if (journey[0] > capacity) {
                return false;
            }
            for (int i = 1; i < length; i++) {
                journey[i] = journey[i - 1] + journeyDiff[i];
                if (journey[i] > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
}
