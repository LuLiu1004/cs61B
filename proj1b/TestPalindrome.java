import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome() {
        // normal cases
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("cat"));
        // corner cases
        assertTrue(palindrome.isPalindrome(String.valueOf('a')));
        assertFalse(palindrome.isPalindrome("aA"));
        assertTrue(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome(""));

    }
    @Test
    public void testIsPalindromeOffByOne() {
        // test isPalindrome with CharacterComparator offByOne
        CharacterComparator ob1 = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", ob1));
        assertTrue(palindrome.isPalindrome("", ob1));
        assertFalse(palindrome.isPalindrome("aba", ob1));
        assertFalse(palindrome.isPalindrome("aa", ob1));

    }
    @Test
    public void testIsPalindromeOffByFive() {
        // test isPalindrome with CharacterComparator offBy5

        CharacterComparator offBy5 = new OffByN(5);
        assertTrue(palindrome.isPalindrome("toto", offBy5));
        assertTrue(palindrome.isPalindrome("", offBy5));

    }
}
