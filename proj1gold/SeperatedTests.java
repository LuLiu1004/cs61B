import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeperatedTests {
    private static final int NUM_OF_RANDOMIZED_TESTS = 100;
    private static final int RANDOM_INTEGER = 100;



    @Test
    public void testAddFirst() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        int N = NUM_OF_RANDOMIZED_TESTS;
        String message = "";

        for (int i = 0; i < N; i++) {
            int randValue = StdRandom.uniform(RANDOM_INTEGER);
            sad1.addFirst(randValue);
            message = "addFirst(" + randValue + ")\n";
            ads1.addFirst(randValue);
            int expected = ads1.get(0);
            int actual = sad1.get(0);
            assertEquals("addFirst mismatches! Expected :" + expected + ",but got: " + actual, expected, actual);

        }
        // test if the final arrays match

        for (int i = 0; i < ads1.size(); i++) {
            int expected = ads1.get(i);
            int actual = sad1.get(i);
            assertEquals("Final arrays after implementing addFirst mismatch at index " + "i" + "! "
                    + "Expected :" + expected + ",but got: " + actual, expected, actual);
        }
    }

    @Test
    public void testAddLast() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        int N = NUM_OF_RANDOMIZED_TESTS;
        String messageLog = "";

        for (int i = 0; i < N; i++) {
            int randValue = StdRandom.uniform(RANDOM_INTEGER);
            sad1.addLast(randValue);
            ads1.addLast(randValue);
            messageLog += "addLast(" + randValue + ")\n";

            int expected = ads1.get(ads1.size() - 1);
            int actual = sad1.get(sad1.size() - 1);
            assertEquals("addLast mismatches! Expected :" + expected + ",but got: " + actual, expected, actual);

        }
        // test if the final arrays match

        for (int i = 0; i < ads1.size(); i++) {
            int expected = ads1.get(i);
            int actual = sad1.get(i);
            assertEquals("Final arrays after implementing addLast mismatch at index " + "i" + "! "
                    + "Expected :" + expected + ",but got: " + actual, expected, actual);
        }
    }

    @Test
    public void testRemoveLast() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        int N = NUM_OF_RANDOMIZED_TESTS;

        for (int i = 0; i < N; i++) {
            int randValue = StdRandom.uniform(RANDOM_INTEGER);
            sad1.addLast(randValue);
            ads1.addLast(randValue);

        }

        for (int i = 0; i < N; i++) {

            Integer actual = sad1.removeLast();
            Integer expected = ads1.removeLast();
            assertEquals("removeLast() mismatches. Expected :" + expected
                    + " ,but actual removed: " + actual, expected, actual);

        }
        // test if the final arrays are empty
        assertTrue(sad1.isEmpty());

    }

    @Test
    public void testRemoveFirst() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        int N = NUM_OF_RANDOMIZED_TESTS;

        for (int i = 0; i < N; i++) {
            int randValue = StdRandom.uniform(RANDOM_INTEGER);
            sad1.addLast(randValue);
            ads1.addLast(randValue);

        }

        for (int i = 0; i < N; i++) {

            Integer actual = sad1.removeFirst();
            Integer expected = ads1.removeFirst();
            assertEquals("removeFirst() mismatches. Expected :" + expected
                    + " ,but actual removed: " + actual, expected, actual);

        }
        // test if the final arrays are empty
        assertTrue(sad1.isEmpty());

    }
}
