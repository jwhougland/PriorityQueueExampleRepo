import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Main class for the priority queue console app.
 */
public class Main {
    /**
     * Entry method for the priority queue console app.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {

        // Create a priority queue that will hold assignments
        // that can be polled in the following order:
        // 1. Nearest due date first
        // 2. In the case where multiple assignment have the same due date then by priority
        // 3. In the case of a tie with the previous comparisons then the
        //      natural order determined by the Comparator function
        Queue<Assignment> queue = new PriorityQueue<>(
                Comparator.comparing(Assignment::getDueDate)
                        .thenComparing(Assignment::getPriority));

        // Insert assignments into the priority queue
        queue.offer(new Assignment("Buy milk and eggs",
                getDateXNumberOfDaysFromNow(2),
                Assignment.Priority.MEDIUM));

        queue.offer(new Assignment("Find new show on Netflix",
                getDateXNumberOfDaysFromNow(6),
                Assignment.Priority.LOW));

        queue.offer(new Assignment("Continue Udemy course",
                getDateXNumberOfDaysFromNow(5),
                Assignment.Priority.MEDIUM));

        queue.offer(new Assignment("Finish work assignment #1",
                getDateXNumberOfDaysFromNow(4),
                Assignment.Priority.HIGH));

        queue.offer(new Assignment("Finish work assignment #2",
                getDateXNumberOfDaysFromNow(2),
                Assignment.Priority.HIGH));

        queue.offer(new Assignment("Check out new restaurant",
                getDateXNumberOfDaysFromNow(13),
                Assignment.Priority.LOW));

        // Poll and print all items from the priority queue
        System.out.println("Printing assignments in priority order:");
        while (!queue.isEmpty()) {
            Assignment assignment = queue.poll();
            System.out.println(assignment);
        }

        // Noting that the above while loop prints the following:
        // Printing assignments in priority order:
        // Assignment{description='Finish work assignment #2', dueDate=Thu Nov 23 11:43:04 CST 2023, priority=HIGH}
        // Assignment{description='Buy milk and eggs', dueDate=Thu Nov 23 11:43:04 CST 2023, priority=MEDIUM}
        // Assignment{description='Finish work assignment #1', dueDate=Sat Nov 25 11:43:04 CST 2023, priority=HIGH}
        // Assignment{description='Continue Udemy course', dueDate=Sun Nov 26 11:43:04 CST 2023, priority=MEDIUM}
        // Assignment{description='Find new show on Netflix', dueDate=Mon Nov 27 11:43:04 CST 2023, priority=LOW}
        // Assignment{description='Check out new restaurant', dueDate=Mon Dec 04 11:43:04 CST 2023, priority=LOW}
    }

    /**
     * Returns a date object that is set for X number of days from now
     *
     * @param daysFromNow X number of days from now
     */
    public static Date getDateXNumberOfDaysFromNow(long daysFromNow) {

        // Get the current time in milliseconds
        long currentTimeMillis = System.currentTimeMillis();

        // Compute the future time in milliseconds as follows: daysFromNow * 24 * 3600 * 1000
        // This comes from:
        //     [daysFromNow] * 24 hours * 3600 seconds * 1000 milliseconds    -----> days from now in milliseconds
        //                     ________   ____________   _________________
        //                     1 day      1 hour         1 second
        long futureTimeMillis = currentTimeMillis + (daysFromNow * 24 * 3600 * 1000);

        // Create a Date object representing the future time
        return new Date(futureTimeMillis);
    }
}