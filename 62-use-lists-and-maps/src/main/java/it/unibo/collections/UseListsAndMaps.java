package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    /**
     *
     */
    private static final int RANGE_RAND = 100000;
    /**
     *
     */
    private static final double ELEM_ADDED = 100.000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> integerArrayList = new ArrayList <>();
        for(int i=1000; i<2000; i++){
            integerArrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> integerLinkedList = new LinkedList<>(integerArrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp1; 
        int temp2;
        int index = integerArrayList.size();
        temp1 = integerArrayList.get(0);
        temp2 = integerArrayList.get(index-1);
        integerArrayList.set(index-1, temp1);
        integerArrayList.set(0, temp2);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for( final int i: integerArrayList ){
            System.out.println(i);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        
        //calcolo del tempo con ArrayList
        long time1= System.nanoTime();
        for(int i=0; i<ELEM_ADDED; i++){
            int value = (int)(Math.random()*RANGE_RAND);
            integerArrayList.add(i,value);
        }
        time1 = System.nanoTime() - time1;
        

        //calcolo del tempo con LinkedList
        long time2= System.nanoTime();
        for(int i=0; i<ELEM_ADDED; i++){
            int value = (int)(Math.random()*RANGE_RAND);
            integerLinkedList.addFirst(value);
        }
        time2 = System.nanoTime() - time2;

        System.out.println("time needed using ArrayList:" + time1);
        System.out.println("time needed using LinkedList:" + time2);
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */

        //calcolo del tempo con ArrayList
        long time3= System.nanoTime();
        for(int i=0; i<1000; i++){
            integerArrayList.get((integerArrayList.size())/2);
        }
        time3 = System.nanoTime() - time3;
        //calcolo del tempo con LinkedList
        long time4= System.nanoTime();
        for(int i=0; i<1000; i++){
            integerLinkedList.get((integerLinkedList.size())/2);
        }
        time4 = System.nanoTime() - time4;
        System.out.println("time needed using ArrayList:" + time3);
        System.out.println("time needed using LinkedList:" + time4);

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1110635000L);
        map.put("Americas",972005000L);
        map.put("Antarctica",0L);
        map.put("Asia",4298723000L);
        map.put("Europe", 742452000L);
        map.put("Oceania", 38304000L);

        /*
         * 8) Compute the population of the world
         */
        long sum=0;
        for(final long i: map.values()){
            sum+=i;
        }
        System.out.println(sum);
    }
}
