class Solution {
    int mh;

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        // do a binary search from l=1 and r = max time req i.e select a worker with max time and do all work with him 
        long l = 1;
        mh = mountainHeight;
        long max_time = workerTimes[0];

        for (int i = 0; i < workerTimes.length; i++) {
            max_time = Math.max(workerTimes[i], max_time);
        }

        long r = (max_time * (mountainHeight) * (mountainHeight + 1)) / 2;

        // do binary search 
        long result=0;
        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (check(mid,workerTimes)) {
                r = mid - 1;
                result=mid;
            } else {
                l = mid + 1;
            }
        }
        return result;

    }

    public boolean check(long mid, int[] workerTimes) {
        long h = 0;
        for (int i = 0; i < workerTimes.length; i++) {
            h += Math.sqrt((2 * mid / workerTimes[i]) + 0.25) - 0.5;
            if(h>=mh) return true;
        }
        return false;

    }

}