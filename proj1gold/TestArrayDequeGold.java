import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    private static final int NUM_OF_RANDOMIZED_TESTS = 100;
    private static final int RANDOM_INTEGER = 100;

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        StringBuilder messageLog = new StringBuilder();

        for (int i = 0; i < NUM_OF_RANDOMIZED_TESTS; i++) {
            int operation = StdRandom.uniform(4);

            if (operation == 0) {
                int randVal = StdRandom.uniform(RANDOM_INTEGER);
                student.addFirst(randVal);
                solution.addFirst(randVal);
                messageLog.append(String.format("addFirst(%d)\n", randVal));
            } else if (operation == 1) {
                int randVal = StdRandom.uniform(RANDOM_INTEGER);
                student.addLast(randVal);
                solution.addLast(randVal);
                messageLog.append(String.format("addLast(%d)\n", randVal));
            } else if (operation == 2 && !student.isEmpty() && !solution.isEmpty()) {
                Integer expected = solution.removeFirst();
                Integer actual = student.removeFirst();
                messageLog.append("removeFirst()\n");
                assertEquals(messageLog.toString(), expected, actual);
            } else if (operation == 3 && !student.isEmpty() && !solution.isEmpty()) {
                Integer expected = solution.removeLast();
                Integer actual = student.removeLast();
                messageLog.append("removeLast()\n");
                assertEquals(messageLog.toString(), expected, actual);
            }
        }

    }
}
