import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class MyCalendar {


//    Queue<Integer> endQeueue = new PriorityQueue();
    List<List<Integer>> schedule;

    public MyCalendar() {
        schedule = new ArrayList();
    }

    public boolean book(int start, int end) {
        boolean isNotDistinct = true;
        for (int i = 0; i < schedule.size(); i++) {
            int reserveStart = schedule.get(i).get(0);
            int reserveEnd = schedule.get(i).get(1);
            int minEnd = Math.min(reserveEnd, end);

            if (minEnd > reserveStart && minEnd > start) {
                isNotDistinct = false;
            }
        }
        if (isNotDistinct) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(start);
            list.add(end);
            schedule.add(list);
        }

        return isNotDistinct;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */