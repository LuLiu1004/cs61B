public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst; // always point to the slot before the first actual item
    private int nextLast;
    private static final int INITIAL_CAPACITY = 8;
    private static final double  DEFAULT_FACTOR = 0.25;


    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;

    }
    /*
    Move the current index one step forward in the array.
     */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }
    /*
    Move the current index one step backward in the array.
     */
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        // get the first index by move the nextFirst one step forward
        int firstIdx = plusOne(nextFirst);
        // copy the old circular array to the new linear array
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(firstIdx + i) % items.length];
        }
        // reset the array
        items = newItems;
        // reset the pointer
        // all the valid items now are at the front of the new array, from 0 to size -1
        nextFirst = newCapacity - 1; // before index 0, at the end of the array
        nextLast = size;



    }




    /**
     * Adds an item of type T to the front of the deque.
     * @param item the value of the newly added node
     */
    public void addFirst(T item) {
        // check if the array is full
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;


    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item the value of the newly added node
     */
    public void addLast(T item) {
        // check if the array is full
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;


    }

    /**
     * Verify if the deque is empty.
     * @return true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     * @return the number of items in the deque.
     */
    public int size() {
        return this.size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {

        int firstIdx = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[(firstIdx + i) % items.length] + " ");
        }
        System.out.println();

    }
    private void shrinkArrayByHalf() {
        if (items.length >= INITIAL_CAPACITY * 2 && size / (double) items.length < DEFAULT_FACTOR) {
            //shrink the array
            resize(items.length / 2);
        }
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return the removed item or null if no such item exists.
     */
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        int firstIdx = plusOne(nextFirst);
        T removedItem = items[firstIdx];
        // null the removed item
        items[firstIdx] = null;
        nextFirst = firstIdx;
        size--;
        shrinkArrayByHalf();
        return removedItem;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return the removed item or null if no such item exists.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int lastIdx = minusOne(nextLast);
        T removedItem = items[lastIdx];
        // free the removed item from the array
        items[lastIdx] = null;
        nextLast = lastIdx;
        size--;
        // check if the array
        shrinkArrayByHalf();
        return removedItem;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * NOTE:Must not alter the deque!
     * @param index
     * @return
     */

    public T get(int index) {

        if (isEmpty() || index >= size) {
            return null;
        }
        int firstIdx = plusOne(nextFirst);
        int returnedIdx = (firstIdx + index) % items.length;
        return items[returnedIdx];
    }
    private T getRecursive(int index) {
        if (isEmpty() || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, plusOne(nextFirst));
    }

    private T getRecursiveHelper(int targetIdx, int currIdx) {
        if (targetIdx == 0) {
            return items[currIdx];
        }
        return getRecursiveHelper(targetIdx - 1, plusOne(currIdx));

    }
}
