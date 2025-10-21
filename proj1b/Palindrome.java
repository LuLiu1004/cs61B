public class Palindrome {
    /**
     * Given a String, wordToDeque should return a Deque
     * where the characters appear in the same order as in the String.
     * @param word the given String
     * @return a Deque where the characters appear in the same order as in the String.
     */
    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            System.out.println("The input word cannot be null.");
            return null;
        }
        LinkedListDeque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;

    }

    /**
     * Helper method to verify if the given word deque is a palindrome.
     * @param wordDeque the deque holds all the characters of a word
     * @return true if the given deque is a palindrome, false otherwise.
     */

    private boolean isPalindromeHelper(Deque wordDeque) {
        if (wordDeque == null || wordDeque.isEmpty() || wordDeque.size() <= 1) {
            return true;
        }
        if (wordDeque.removeFirst().equals(wordDeque.removeLast())) {
            return isPalindromeHelper(wordDeque);
        } else {
            return false;
        }
    }


    /**
     * Verify if the given word is a palindrome.
     * @param word the given word
     * @return true if the given word is a palindrome, and false otherwise.
     */
    public boolean isPalindrome(String word) {
        Deque wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque);
    }

    private boolean isPalindromeHelper(Deque wordDeque, CharacterComparator cc) {
        if (wordDeque == null || wordDeque.isEmpty() || wordDeque.size() <= 1) {
            return true;
        }
        Character first = (Character) wordDeque.removeFirst();
        Character last = (Character) wordDeque.removeLast();
        if (cc.equalChars(first, last)) {
            return isPalindromeHelper(wordDeque, cc);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque, cc);
    }



}
