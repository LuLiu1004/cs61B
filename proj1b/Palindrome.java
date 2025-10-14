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
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;

    }

    /**
     * Verify if the given word is a palindrome.
     * @param word the given word
     * @return true if the given word is a palindrome, and false otherwise.
     */
    public boolean isPalindrome(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }

        Deque<Character> wordDeque = wordToDeque(word);
        int numOfIterations = wordDeque.size() / 2;
        for (int i = 0; i < numOfIterations; i++) {
            Character firstChar = wordDeque.removeFirst();
            Character lastChar = wordDeque.removeLast();
            if (!firstChar.equals(lastChar)) {
                return false;
            }
        }
        return  true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() <= 1) {
            return true;
        }


        Deque<Character> wordDeque = wordToDeque(word);

        while (wordDeque.size() > 1) {
            char firstChar = wordDeque.removeFirst();
            char lastChar = wordDeque.removeLast();
            if (!cc.equalChars(firstChar, lastChar)) {
                return false;
            }
        }
        return  true;
    }



}
