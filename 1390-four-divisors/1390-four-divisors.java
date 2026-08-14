class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;

        for (int num : nums) {
            int divisorCount = 0;
            int divisorSum = 0;

            // Find all divisors of num
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    int other = num / i;

                    divisorCount++;
                    divisorSum += i;

                    // Avoid counting sqrt(num) twice
                    if (i != other) {
                        divisorCount++;
                        divisorSum += other;
                    }
                }
            }

            // Add sum only if exactly 4 divisors
            if (divisorCount == 4) {
                total += divisorSum;
            }
        }

        return total;
    }
}