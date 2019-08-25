/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.Bucketing;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class MaximumUnsortedSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer> (2);
        int N = A.size();
        int start, stop, min, max;
        for (start = 1; start < N; start++) {
            if (A.get(start - 1) > A.get(start))
                break;
        }
        if (start == N) {
            res.add(-1);
            return res;
        }
        for (stop = N - 2; stop >= 0; stop--) {
            if (A.get(stop) > A.get(stop + 1))
                break;
        }
        start--;
        stop++;
        min = A.get(start);
        max = A.get(start);
        for (int i = start + 1; i <= stop; i++) {
            int elem = A.get(i);
            if (elem < min)
                min = elem;
            if (elem > max)
                max = elem;
        }
        while (true) {
            if (start > 0 && A.get(start - 1) > min) {
                start--;
                if (A.get(start) > max)
                    max = A.get(start);
            } else if (stop < N - 1 && A.get(stop + 1) < max) {
                stop++;
                if (A.get(stop) < min)
                    min = A.get(stop);
            } else {
                break;
            }
        }
        res.add(start);
        res.add(stop);
        return res;
    }
}
/*
ProblemUrls:
I-https://www.interviewbit.com/problems/maximum-unsorted-subarray/
NOTES:
*/
