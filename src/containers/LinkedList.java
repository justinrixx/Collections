package containers;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author justin
 */
public class LinkedList<T> implements List<T>{
    
    public LinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void add(T t) {
        Node newNode = new Node(t);
        
        if (head == null && tail == null) {
            
            head = newNode;
            tail = newNode;
        } else {
            if (tail != null) {
                tail.next = newNode;
                newNode.prev = tail;
                
                tail = newNode;
            }
        }
        
        size++;
    }
    
    public void addToFront(T t) {
        Node newNode = new Node(t);
        
        if (head == null && tail == null) {
            
            head = newNode;
            tail = newNode;
        } else {
            if (head != null) {
                head.prev = newNode;
                newNode.next = head;
                
                head = newNode;
            }
        }
        
        size++;
    }

    @Override
    public void clear() {
        
        // just release the list to the garbage collector
        head = null;
        tail = null;
        
        size = 0;
    }

    @Override
    public boolean contains(T t) {
        
        Node n = head;
        
        while (n != null) {
            if (n.data.equals(t)) {
                return true;
            }
            
            n = n.next;
        }
        
        return false;
    }

    @Override
    public boolean equals(List<T> rhs) {
        
        Node n = head;
        for (T t : rhs) {
            
            if (n == null) {
                return false;
            } else if (!t.equals(n.data)) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean isEmpty() {
        
        if (size == 0) {
            return true;
        }
        
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] toArray() {
        Object[] array = new Object[size];
        
        int i = 0;
        Node n = head;
        while(n != null) {
            array[i] = n.data;
            i++;
        }
        
        return (T[])(array);
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    /**
     * A node in the list
     */
    private class Node {
        
        // constructor for convenience
        public Node(T t) {
            data = t;
            next = null;
            prev = null;
        }
        
        public Node next;
        public Node prev;
        
        public T data;
    }
    
    private class LinkedListIterator implements Iterator<T> {
        
         private Node cursor;

        public LinkedListIterator() {
            cursor = LinkedList.this.head;
        }
        
        @Override
        public boolean hasNext() {
            return (cursor != null);
        }

        @Override
        public T next() {
            if (hasNext()) {
                
                T data = cursor.data;
                cursor = cursor.next;
                
                return data;
            }
            throw new NoSuchElementException();
        }
        
    }
}
