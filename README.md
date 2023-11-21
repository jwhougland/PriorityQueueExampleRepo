# PriorityQueueExampleRepo
Demonstrates the use of a priority queue to keep user-defined Assignment objects stored in a priority order.

The console app will insert various Assignment objects in a priority queue, and when the elements are polled
from the queue they will be extracted in priority order per the following rules:
1. Nearest due date first
2. In the case where multiple assignment have the same due date then by priority
3. In the case of a tie with the previous comparisons then the
   natural order determined by the Comparator function
