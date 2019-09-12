/* This can be categorized as a interval/meeting attendance problem or a problem which calculates 
 * the number of people alive at any given instant of time. The logic is the same
 * 
 * Problem Definition - Given a list of start and end dates/times. Find the time instant which has
 * the maximum number of people present
 * 
 * Input - [[10, 40], [20, 50], [90, 120], [50, 90], [50, 120]]
 * Output - 2 at 50 and 2 at 90
 * 
 * */
import java.util.*;

class Interval{		
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}	
}

public class maxPeople {			
	public static void main(String[] args) {
		List<Interval> times = new ArrayList<>();
		times.add(new Interval(10, 40));
		times.add(new Interval(20, 50));
		times.add(new Interval(90, 120));
		times.add(new Interval(50, 90));
		times.add(new Interval(50, 120));
		int count = findMaxPeople(times);
		System.out.println("Max number of people present at anytime during the party is : " + count);
	}
	
	public static int findMaxPeople(List<Interval> times) {
		List<Integer> startTimes = new ArrayList<>();
		List<Integer> endTimes = new ArrayList<>();

		for(Interval time : times) {
			startTimes.add(time.start);
			endTimes.add(time.end);
		}
		
		Collections.sort(startTimes);
		Collections.sort(endTimes);
		
		int i = 0;
		int j = 0;
		int count = 0;
		int maxCount = 0;
		
		while(i < startTimes.size() && j < endTimes.size()) {			
			if(startTimes.get(i) <= endTimes.get(j)) {
				count++;
				i++;
			} else {
				count--;
				j++;
			}
			maxCount = Math.max(count, maxCount);			
		}
		
		return maxCount;		
	}
}
