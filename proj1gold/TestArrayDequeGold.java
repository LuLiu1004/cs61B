import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {

    private static final int RANDOM_INTEGER = 10;

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();


        StringBuilder messageLog = new StringBuilder();
        for (int i = 0; i < RANDOM_INTEGER; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();


            if (numberBetweenZeroAndOne < 0.5) {
                student.addLast(i);
                messageLog.append(String.format("addLast(%d)\n", i));
                Integer actual = student.get(student.size() - 1);
                assertEquals(messageLog.toString(), (Object) i, actual);
            } else {
                student.addFirst(i);
                messageLog.append(String.format("addFirst(%d)\n", i));
                Integer actual = student.get(0);
                assertEquals(messageLog.toString(), (Object) i, actual);

            }


        }
        for (int i = 0; i < RANDOM_INTEGER; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();


            if (numberBetweenZeroAndOne < 0.5) {
                Integer expected = student.get(student.size() - 1);
                Integer actual = student.removeLast();
                messageLog.append("removeLast()\n");
                assertEquals(messageLog.toString(), expected, actual);
            } else {
                Integer expected = student.get(0);
                Integer actual = student.removeFirst();
                messageLog.append("removeFirst()\n");
                assertEquals(messageLog.toString(), expected, actual);

            }
        }



    }
}
