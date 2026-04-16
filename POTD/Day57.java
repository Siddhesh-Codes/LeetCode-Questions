// 2515. Shortest Distance to Target String in a Circular Array

// Mistake Log:
// 1. Trying to simulate the movement: Attempting to move left (i - 1 + n) % n or right (i + 1) % n step-by-step is technically correct but harder to implement and prone to infinite loops or off-by-one errors.
// 2. Missing the circular math relationship: In a circle, the left path and the right path between two points always add up to the total length of the circle.

// Core Concept: The Circular Distance Rule
// Whenever you see "Shortest Distance" + "Circular Array", don't simulate the steps. Use math instead.
//
// The Rule:
// In an array of length N, if you know the direct (straight-line) distance (D) between two indices, the wrap-around distance going the opposite way is always exactly N - D.
//
// Formula:
// 1. Find Direct Distance: D = |targetIndex - startIndex|
// 2. Find Wrap-Around Distance: N - D
// 3. Take the Minimum: Shortest path = min(D, N - D)
//
// Application:
// Instead of moving left and right from the startIndex to find the target, just loop through the array from 0 to N-1. Every time you find the target word, calculate the direct distance, use the rule to find the wrap-around distance, and keep track of the absolute minimum distance found.


package POTD;

public class Day57 {
    public int closestTarget(String[] words, String target, int startIndex) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) {
                int straightDis = Math.abs(i - startIndex);
                int distance = words.length - straightDis;

                res = Math.min(Math.min(distance, straightDis), res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
