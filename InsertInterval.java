public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        boolean merged = false;
        ArrayList<Interval> results = new ArrayList<Interval>();
        for (Interval interval : intervals) {
            if (interval.start <= newInterval.end && interval.end >= newInterval.start) {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
                continue;
            }
            if (!merged && interval.start > newInterval.end) {
                results.add(newInterval);
                merged = true;
            }
            results.add(interval);
        }
        if (!merged)
            results.add(newInterval);

        return results;
    }
}
