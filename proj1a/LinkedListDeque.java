public class LinkedListDeque <T>{
    private class StuffNode{
        public T item;
        public StuffNode prev;
        public StuffNode next;

        public StuffNode(T item, StuffNode prevNode, StuffNode nextNode){
            this.item = item;
            prev = prevNode;
            next = nextNode;

        }
    }

    private StuffNode sentinel;

    private int size;
    //Constructor : Creates an empty linked list deque.
    public LinkedListDeque(){
        sentinel = new StuffNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item the value of the newly added node
     */
    public void addFirst(T item){

        StuffNode newNode = new StuffNode(item,sentinel,sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;

    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item the value of the newly added node
     */
    public void addLast(T item){
        StuffNode newNode = new StuffNode(item,sentinel.prev,sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    /**
     * Verify if the deque is empty.
     * @return true if deque is empty, false otherwise.
     */
    public boolean isEmpty(){

        return size==0;
    }

    /**
     * Returns the number of items in the deque.
     * @return the number of items in the deque.
     */
    public int size(){
        return this.size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque(){

        StuffNode ptr = sentinel.next;
        while(ptr!=sentinel){
            System.out.println(ptr.item+" ");
            ptr = ptr.next;
        }
        System.out.println();

    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return the removed item or null if no such item exists.
     */
    public T removeFirst(){

        if(isEmpty()) return null;

        StuffNode first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.item;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return the removed item or null if no such item exists.
     */
    public T removeLast(){
        if(isEmpty()) return null;
        StuffNode last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return last.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * NOTE:Must not alter the deque!
     * @param index
     * @return
     */

    public T get(int index){

        if (isEmpty()|| index >= size) return null;
        StuffNode ptr = sentinel.next;
        //traverse through th list to the given index
        for(int i=0; i<index;i++){
            ptr = ptr.next;
        }
        return ptr.item;
    }
    public T getRecursive(int index){
        if (isEmpty()|| index >= size) return null;
        return getRecursiveHelper(sentinel.next,index);
    }

    private T getRecursiveHelper(StuffNode node, int index){
        if(index ==0) return node.item;
        return getRecursiveHelper(node.next,index-1);

    }


}
