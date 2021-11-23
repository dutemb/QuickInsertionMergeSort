import java.util.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.lang.reflect.Type;


public class Sorts {
    public static void main(String[] args) {
        //The following function tested the functionality
        //of each sort individually, if you would like to see 
        //if my sorts work, you could uncomment this

        //testingHelpers();

        testingBestCasesOfSorts();
        testingWorstCasesOfSorts();
        testingRandomInputCases();
    }


    /* 
     *    purpose: this is a unit test function that tests each sort's
     *             performance based on the "best input" for various sorts
     *
     *             f.e one of the testcases is the best possible input for Insertion sort
     *             the test sorts an almost sorted array using Insertion,Merge and
     *             Quick sorts, then it outputs the runtime in nanoseconds
     */
    public static void testingBestCasesOfSorts() {
        //I googled values of minimum and maximum integers possible//
        int minimumIntegerPossible = -214748364;
        int maximumIntegerPossible = 214748364;

        //BEST CASE INSERTION ON AL: ALMOST SORTED
        List < Integer > insertionAL = generateList(40, minimumIntegerPossible, maximumIntegerPossible, 'a');
        //sort it
        mergeSortAL(insertionAL);
        //now add some random thing
        insertionAL.add(10);
        runOnceGivenList(insertionAL, "best case of an insertion sort on AL", "a", "print");
        System.out.println();


        //BEST CASE INSERTION ON LL
        List < Integer > insertionLL = generateList(40, minimumIntegerPossible, maximumIntegerPossible, 'l');
        //sort it
        mergeSortLL(insertionLL);
        //now add some random thing so we get an almost sorted list
        insertionLL.add(10);
        runOnceGivenList(insertionLL, "best case of an insertion sort LL", "ll", "print");
        System.out.println();

        //BEST CASE QUICKSORT on AL
        //input [4,2,3,1,5,7]
        List < Integer > quickA = new ArrayList < Integer > ();
        quickA.add(4);
        quickA.add(2);
        quickA.add(3);
        quickA.add(1);
        quickA.add(5);
        quickA.add(7);
        quickA.add(9);
        runOnceGivenList(quickA, "best case of quicksort on AL", "a", "print");
        System.out.println();

        //BEST CASE QUICKSORT on LL
        //input [4,2,3,1,5,7]
        List < Integer > quickL = new LinkedList < Integer > ();
        quickA.add(44);
        quickA.add(22);
        quickA.add(33);
        quickA.add(11);
        quickA.add(55);
        quickA.add(77);
        quickA.add(99);
        runOnceGivenList(quickL, "best case of quicksort on LL", "l", "print");
        System.out.println();




    }

    /* 
     *    purpose: this is a unit test function that tests each sort's
     *             performance based on the "worst input" for various sorts
     */
    public static void testingWorstCasesOfSorts() {
        //I googled values of minimum and maximum integers possible//
        int minimumIntegerPossible = -214748364;
        int maximumIntegerPossible = 214748364;


        //WORST CASE INSERTION ON AL: REVERSE SORTED
        List < Integer > insA = new ArrayList < Integer > ();
        insA.add(9);
        insA.add(8);
        insA.add(7);
        insA.add(6);
        insA.add(5);
        insA.add(4);
        insA.add(3);
        runOnceGivenList(insA, "worst case of insertion on AL", "a", "print");
        System.out.println();

        //WORST CASE INSERTION ON LL: REVERSE SORTED
        List < Integer > insL = new LinkedList < Integer > ();
        insL.add(9);
        insL.add(8);
        insL.add(7);
        insL.add(6);
        insL.add(5);
        insL.add(4);
        insL.add(3);
        runOnceGivenList(insL, "best case of insertion on LL", "l", "print");
        System.out.println();

        //WORST CASE QUICKSORT ON AL: ALREADY SORTED
        List < Integer > qAL = generateList(40, minimumIntegerPossible, maximumIntegerPossible, 'a');
        //sort it
        mergeSortAL(qAL);
        runOnceGivenList(qAL, "worst case of an quicksort on AL", "a", "print");
        System.out.println();

        //WORST CASE QUICKSORT ON LL: ALREADY SORTED
        List < Integer > qLL = generateList(40, minimumIntegerPossible, maximumIntegerPossible, 'l');
        //sort it
        mergeSortLL(qLL);
        runOnceGivenList(qLL, "worst case of an quicksort on AL", "a", "print");
        System.out.println();

    }


    /* 
     *    purpose: this is a unit test function that tests each sort's
     *             performance based randomized input, and a specified range(each is different)
     *             each testcase is ran 100 times and then the results are averaged
     */
    public static void testingRandomInputCases() {


        //I googled values of minimum and maximum integers possible//
        int minimumIntegerPossible = -214748364;
        int maximumIntegerPossible = 214748364;

        System.out.println("Test sorting random list of size 10 with Integer.MIN to Integer.MAX");
        runOnceRandomInput(10, minimumIntegerPossible, maximumIntegerPossible, "print");
        System.out.println();
        averageRun(100, 10, minimumIntegerPossible, maximumIntegerPossible);
        System.out.println();

        System.out.println("Test sorting random list of size 100 with Integer.MIN to Integer.MAX");
        runOnceRandomInput(100, minimumIntegerPossible, maximumIntegerPossible, "print");
        System.out.println();
        averageRun(100, 100, minimumIntegerPossible, maximumIntegerPossible);
        System.out.println();

        System.out.println("Test sorting random list of size 1000 with Integer.MIN to Integer.MAX");
        runOnceRandomInput(1000, minimumIntegerPossible, maximumIntegerPossible, "print");
        System.out.println();
        averageRun(100, 1000, minimumIntegerPossible, maximumIntegerPossible);
        System.out.println();

        //THIS TAKES FOREVER SO I COMMENTED IT OUT
        /*
        System.out.println("Test sorting random list of size 10000 with Integer.MIN to Integer.MAX");
        runOnceRandomInput(10000, minimumIntegerPossible, maximumIntegerPossible, "print");
        averageRun(100, 10000, minimumIntegerPossible, maximumIntegerPossible);
        System.out.println();
        */


        //TESTING SMALLER RANGE EACH ELEMENT CAN HAVE [-10,10]

        System.out.println("Test sorting random list of size 10 with -10 to 10");
        runOnceRandomInput(10, -10, 10, "print");
        System.out.println();
        averageRun(100, 10, -10, 10);
        System.out.println();

        System.out.println("Test sorting random list of size 100 with -10 to 10");
        runOnceRandomInput(100, -10, 10, "print");
        System.out.println();
        averageRun(100, 100, -10, 10);
        System.out.println();

        System.out.println("Test sorting random list of size 1000 with -10 to 10");
        runOnceRandomInput(1000, -10, 10, "print");
        System.out.println();
        averageRun(100, 1000, -10, 10);
        System.out.println();


        //THIS TAKES FOREVER because i run ALL sorts on a HUGE list 100 times,
        /*
        System.out.println("Test sorting random list of size 10000 with Integer.MIN to Integer.MAX");
        runOnceRandomInput(10000, -10, 10, "print");
        averageRun(100, 10000, -10, 10);
        System.out.println();*/


    }



    /* Section 2 of code: the actual sorts

/* 
 *    purpose: sort an ArrayList in ascending order using O(n) space
 * parameters: type of list: ArrayList
 *    Returns: n/a but sorted list
 *    Why: this is literally the project
 */
    private static void mergeSortAL(List < Integer > given) {
        if (given.size() < 2) {
            return;
        }
        int mid = given.size() / 2;

        List < Integer > left = new ArrayList < Integer > (given.subList(0, mid));
        List < Integer > right = new ArrayList < Integer > (given.subList(mid, given.size()));

        mergeSortAL(left);
        mergeSortAL(right);
        merge(left, right, given);
    }

    /* 
     *    purpose: sort a LL in ascending order using O(n) space
     * parameters: type of list: Linked LIst
     *    Returns: n/a but sorted list
     *    Why: this is literally the project
     */
    private static void mergeSortLL(List < Integer > given) {
        if (given.size() < 2) {
            return;
        }
        int mid = given.size() / 2;

        List < Integer > left = new LinkedList < Integer > (given.subList(0, mid));
        List < Integer > right = new LinkedList < Integer > (given.subList(mid, given.size()));

        mergeSortLL(left);
        mergeSortLL(right);
        merge(left, right, given);
    }

    /* 
     *    purpose: merges the sublists in the correct order
     * parameters: type of list: temp right,left and the given ,ist
     *    Returns: n/a but sorted list
     *    Why: helper for mergeSort
     */

    private static void merge(List < Integer > left, List < Integer > right, List < Integer > given) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex))
                given.set(listIndex++, left.get(leftIndex++));
            else
                given.set(listIndex++, right.get(rightIndex++));
        }
        while (leftIndex < left.size()) {
            given.set(listIndex++, left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            given.set(listIndex++, right.get(rightIndex++));
        }
    }

    /* 
     *    purpose: sorts list in the correct order using an insertion sort
     * parameters: LL or AL
     *    Returns: n/a but sorted list
     */
    private static void insertionSort(List < Integer > list) {
        int j = 0;
        for (int i = 1; i < list.size(); i++) {
            int cur = list.get(i);
            j = i - 1;
            while (j >= 0 && cur < list.get(j)) {
                int temp = list.get(j);
                list.set(j, list.get(j + 1));
                list.set(j + 1, temp);
                j--;
            }
        }
    }


    /* 
     *    purpose: sorts list in the correct order using an insertion sort
     * parameters: type of list: temp right,left which should store input 
     *                right of pivot and left of pivot and the given list
     *    Returns: n/a but sorted list
     */
    private static void quickSort(List < Integer > list, int left, int right) {
        int q = 0;
        if (right > left) {
            q = partition(list, left, right);
            quickSort(list, left, q - 1);
            quickSort(list, q + 1, right);
        }
    }

    private static int partition(List < Integer > given, int left, int right) {
        int pivot = given.get(left);
        int i = left;
        int j = right + 1;
        for (int k = 0; k < given.size(); k++) {
            while (given.get(++i) < pivot) { //take care of left side
                if (i >= right)
                    break;
            }
            while (given.get(--j) > pivot) { //take care of right side      
                if (j <= left)
                    break;

            }
            if (i >= j) break; // break the for-loop
            else Collections.swap(given, i, j);

        }
        if (j == left)
            return j;
        // swap (list[left],list[j]);
        Collections.swap(given, left, j);

        return j;
    }




    /* 
     *    purpose: this function to test sorts and prints the sorted output
     *                  it also tests my helper functions
     */

    public static void testingHelpers() {
        List < Integer > newList = new ArrayList < Integer > ();
        List < Integer > get = generateList(10, -214748364, 214748364, 'a');
        List < Integer > getI = get;
        List < Integer > getQ = get;

        printList(get);
        System.out.println();
        printList(getI);
        System.out.println();
        printList(getQ);

        System.out.println("print sorted");
        mergeSortAL(get);
        insertionSort(getI);
        quickSort(getQ, 0, getQ.size() - 1);
        printList(get);
        System.out.println();
        printList(getI);
        System.out.println();
        printList(getQ);


        System.out.println("Test random array in the range from min to max");
        runOnceRandomInput(10, -214748364, 214748364, "print");


    }

    private static int generateMax(int min) {
        Random rand = new Random();
        int max = rand.nextInt();
        while (max < min) {
            max = rand.nextInt();
        }
        return max;
    }

    /* 
     *    purpose: this function runs every sort on the specified list
     * parameters: size of the array, rangeBegin--minimum number the random number can be
     *             rangeEnd -- maximum value the random number can be
     *    Returns: nothing, but output the average runtime of sorting the given list
     *    Why: because I wanted to have a way to generate test cases easily, I also
     *         would like to test random inputs on the array of random sizes with specified
     *         and unspecified ranges
     */
    private static void runOnceGivenList(List < Integer > given, String description, String type, String print) {

        List < Integer > qA = new LinkedList < > (given); //for accuracy let's sort the same unsorted input
        List < Integer > iA = new LinkedList < > (given);
        long mergeALSum = timeGivenSort("mL", given);
        long quickALSum = timeGivenSort("q", qA);
        long insertionALSum = timeGivenSort("i", iA);

        if (type == "a") {
            qA = new ArrayList < > (given); //for accuracy let's sort the same unsorted input
            iA = new ArrayList < > (given);
            mergeALSum = timeGivenSort("mA", given);
            quickALSum = timeGivenSort("q", qA);
            insertionALSum = timeGivenSort("i", iA);
        }
        if (print == "print") {
            System.out.println("Sorting " + description);
            System.out.println("Merge: " + mergeALSum + " nanoseconds");
            System.out.println("Insertion: " + insertionALSum + " nanoseconds");
            System.out.println("Quick: " + quickALSum + " nanoseconds");
        }

    }
    /* 
     *    purpose: given the numRuns, run all sorts on numRuns times on a random list
     *             of size sizeList where each elem is in the rane [rangeBegin,rangeEnd]
     *             print the results
    * parameters: size of the array, rangeBegin--minimum number the random number can be *
        rangeEnd--maximum value the random number can be *
        Returns: nothing, but output the average runtime of sorting numRuns lists *
        Why: because I wanted to have a way to generate test cases easily, I also *
        would like to test random inputs on the array of random sizes with specified *
        and unspecified ranges */
    private static void averageRun(int numRuns, int sizeList, int rangeBegin, int rangeEnd) {
        System.out.println("This is average sorting runtime of " + numRuns + " lists of size " + sizeList);
        System.out.println("In the range [" + rangeBegin + "," + rangeEnd + "]");

        long mergeLLSum = 0;
        long mergeALSum = 0;
        long insertionLLSum = 0;
        long insertionALSum = 0;
        long quickLLSum = 0;
        long quickALSum = 0;

        for (int i = 0; i < numRuns; i++) {
            List < Integer > mA = generateList(sizeList, rangeBegin, rangeEnd, 'a');
            List < Integer > qA = new ArrayList < > (mA); //for accuracy let's sort the same unsorted input
            List < Integer > iA = new ArrayList < > (mA);
            mergeALSum += timeGivenSort("mA", mA);
            quickALSum += timeGivenSort("q", qA);
            insertionALSum += timeGivenSort("i", iA);

            List < Integer > mL = generateList(sizeList, rangeBegin, rangeEnd, 'l');
            List < Integer > qL = new LinkedList < > (mL);
            List < Integer > iL = new LinkedList < > (mL);
            mergeLLSum += timeGivenSort("mL", mL);
            quickLLSum += timeGivenSort("q", qL);
            insertionLLSum += timeGivenSort("i", iL);
        }

        //find averages
        mergeALSum = mergeALSum / numRuns;
        quickALSum = quickALSum / numRuns;
        insertionALSum = insertionALSum / numRuns;
        mergeLLSum = mergeLLSum / numRuns;
        quickLLSum = quickLLSum / numRuns;
        insertionLLSum = insertionLLSum / numRuns;


        //sorry this is horrible modularity, but It was just so much easier to copy/paste
        System.out.println("For LinkedLists: ");
        System.out.println("Merge: " + mergeLLSum + " nanoseconds ");
        System.out.println("Insertion: " + insertionLLSum + " nanoseconds ");
        System.out.println("Quick: " + quickLLSum + " nanoseconds ");
        System.out.println("For ArrayLists: ");
        System.out.println("Merge: " + mergeALSum + " nanoseconds");
        System.out.println("Insertion: " + insertionALSum + " nanoseconds");
        System.out.println("Quick: " + quickALSum + " nanoseconds");

    }


    /* 
     *    purpose: this function creates a specified  list(both an ArrayList and LL)
     *             and runs all sorts on it while also figuring out the time.
     * parameters: size of the array, rangeBegin--minimum number the random number can be
     *             rangeEnd -- maximum value the random number can be
     *    Returns: nothing, but output the average runtime of sorting numRuns lists
     *    Why: because I wanted to have a way to generate test cases easily, I also
     *         would like to test random inputs on the array of random sizes with specified
     *         and unspecified ranges
     */
    private static void runOnceRandomInput(int sizeList, int rangeBegin, int rangeEnd, String print) {
        List < Integer > mA = generateList(sizeList, rangeBegin, rangeEnd, 'a');
        List < Integer > qA = new ArrayList < > (mA); //for accuracy let's sort the same unsorted input
        List < Integer > iA = new ArrayList < > (mA);
        long mergeALSum = timeGivenSort("mA", mA);
        long quickALSum = timeGivenSort("q", qA);
        long insertionALSum = timeGivenSort("i", iA);

        List < Integer > mL = generateList(sizeList, rangeBegin, rangeEnd, 'l');
        List < Integer > qL = new LinkedList < > (mL);
        List < Integer > iL = new LinkedList < > (mL);
        long mergeLLSum = timeGivenSort("mL", mL);
        long quickLLSum = timeGivenSort("q", qL);
        long insertionLLSum = timeGivenSort("i", iL);

        if (print == "print") {
            System.out.println("Sorting the list of size " + sizeList);
            System.out.println("Where each element is in the range [" + rangeBegin + "," + rangeEnd + "]");
            System.out.println("For LinkedLists: ");
            System.out.println("Merge: " + mergeLLSum + " nanoseconds ");
            System.out.println("Insertion: " + insertionLLSum + " nanoseconds ");
            System.out.println("Quick: " + quickLLSum + " nanoseconds ");
            System.out.println("For ArrayLists: ");
            System.out.println("Merge: " + mergeALSum + " nanoseconds");
            System.out.println("Insertion: " + insertionALSum + " nanoseconds");
            System.out.println("Quick: " + quickALSum + " nanoseconds");

        }
    }

    /* 
     *    purpose: prints list(this was helpful for debugging sorts)
     * parameters: an list
     *    Returns: none
     *    Why: because I need to print my list to make sure the code is working
     */
    private static void printList(List < Integer > given) {
        System.out.println();
        System.out.print("[");
        for (int i = 0; i < given.size(); i++) {
            System.out.print(given.get(i));
            System.out.print(" ");
        }
        System.out.println("]");
    }


    /* 
     *    purpose: generates a List filled with random numbers in the specified range
     *             [rangeBegin,rangeEnd]
     * parameters: size of the array, rangeBegin--minimum number the random number can be
     *             rangeEnd -- maximum value the random number can be
     *    Returns: List
     *    Why: because I wanted to have a way to generate test cases easily, I also
     *         would like to test random inputs on the array of random sizes with specified
     *         and unspecified ranges
     */
    private static List < Integer > generateList(int size, int rangeBegin, int rangeEnd, char listType) {

        List < Integer > returned = createprefferedList(listType);
        Random thankYouTas = new Random();
        for (int i = 0; i < size; i++) {

            returned.add(thankYouTas.nextInt((rangeEnd - rangeBegin) + 1) + rangeBegin);
        }
        return returned;
    }


    /* 
     *    purpose: generates either an ArrayList or a Linked List based on preference
     * parameters: type of list: AL or LL
     *    Returns: List
     *    Why: because I wanted to have some generic way to generate a list
     */
    private static List < Integer > createprefferedList(char listType) {
        List < Integer > returned = new LinkedList < Integer > ();
        if (listType == 'a') {
            returned = new ArrayList < Integer > ();
        }
        return returned;
    }


    /* 
     *    purpose: given the sort type that include the list type(merge/insertion/quick),
     *             records the time it takes for a sort to run. The time only includes sorting
     *              time without the creation of the list for higher precision.
     * parameters: size of the array, rangeBegin--minimum number the random number can be
     *             rangeEnd -- maximum value the random number can be
     *    Returns: time it took to run a specified sort on the list
     *    Why: because I wanted to have a way to generate test cases easily, I also
     *         would like to test random inputs on the array of random sizes with specified
     *         and unspecified ranges
     */
    private static long timeGivenSort(String sortType, List < Integer > notSorted) {
        if (sortType == "mL") {

            long start2 = System.nanoTime();
            mergeSortLL(notSorted);
            long end2 = System.nanoTime();
            return end2 - start2;

        } else if (sortType == "mA") {

            long start2 = System.nanoTime();
            mergeSortAL(notSorted);
            long end2 = System.nanoTime();
            return end2 - start2;

        } else if (sortType == "q") {

            long start2 = System.nanoTime();
            quickSort(notSorted, 0, notSorted.size() - 1);
            long end2 = System.nanoTime();
            return end2 - start2;

        } else if (sortType == "i") {

            long start2 = System.nanoTime();
            insertionSort(notSorted);
            long end2 = System.nanoTime();
            return end2 - start2;

        } else {
            System.out.println("not a valid sort");
        }
        return -1;

    }



}