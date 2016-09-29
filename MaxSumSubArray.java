import java.util.*;
import java.lang.*;
import java.io.*;

public class MaxSumSubArray
{
    public static void main(String[] args)
    {
        subMatrixMaxSum(new int[][] {
                    {0, -2, -7, 0, -1},
					{9,  2, -6, 2,  0},
					{-4, 1, -4, 1,  0},
					{-1, 8, 0, -2 , 1},
					{-10, 1, 1, -5, 6},
					{-15, -1, 1, 5, -4}
				    });
        subMatrixMaxSum(new int[][] {
                    {0, -2, -7, 0, -1},
					{9,  2, -6, 2,  0},
					{-4, 1, -4, 1,  0},
					{-1, 8, 0, -2 , 1},
					{-10, 6, 1, -5, 6},
					{-15, -1, 1, 5, -4}
				    });
    }

    public static void subMatrixMaxSum(int[][] a)
    {
        int rows = a.length;
        int cols = a[0].length;
        long currentSum = 0;
        long maxSum = Integer.MIN_VALUE;

        for (int leftCol = 0; leftCol < cols; leftCol++)
        {
            int[] temp = new int[rows];	// used for Kandane's
            for(int rightCol = leftCol; rightCol < cols; rightCol++)
            {
                for (int i = 0; i < rows; i++)
                    temp[i] += a[i][rightCol];
                currentSum = kadane(temp);
                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
        }
        System.out.println("Max sum is " + maxSum);
    }

    public static long kadane(int[] tmp)
    {
        if (allNegative(tmp))
            return max(tmp);
        
        long maxSoFar = 0, maxEndingHere = 0;
        for (int i = 0; i < tmp.length; i++)
        {
            maxEndingHere += tmp[i];
            if (maxEndingHere < 0)
                maxEndingHere = 0;
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }

    public static boolean allNegative(int[] t)
    {
        boolean allNeg = true;
        for (int i = 0; i < t.length; i++)
            if (t[i] > 0)
                allNeg = false;
        return allNeg;
    }

    public static long max(int[] t)
    {
        int max = t[0];
        for (int i = 1; i < t.length; i++)
            if (t[i] > max)
                max = t[i];
        return max;
    }
}
