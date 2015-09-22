package containers;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author justin
 * @param <T> The type being put in the list
 */
public class ArrayList<T> implements List<T> {
    
    /**
     * Initialize the member variables
     */
    public ArrayList() {
        mSize = 0;
        mCapacity = 0;
        mArray = null;
    }
    
    /**
     * Initialize the list to hold a certain size
     * @param capacity The size to initialize to
     */
    public ArrayList(int capacity) {
        mSize = 0;
        mCapacity = capacity;
        mArray = new Object[capacity];
    }
    
    /* The public stuff */

    @Override
    public void add(T t) {
        
        // grow if necessary
        if (mSize == mCapacity) {
            grow();
        }
        
        // add it into the list
        mArray[mSize] = t;
        mSize++;
    }
    
    
    public void add(int location, T t) {
        
        if (location < 0 || location >= mCapacity) {
            throw new ArrayIndexOutOfBoundsException("Capacity: " + mCapacity + "; Index: " + location);
        }
        
        // grow if necessary
        if (mSize == mCapacity) {
            grow();
        }
        
        // shift the list
        for (int i = mSize - 1; i >= location; i++) {
            mArray[i] = mArray[i - 1];
        }
        
        // put it in its spot
        mArray[location] = t;
        mSize++;
    }
    
    public T get(int index) {
        
        if (index < 0 || index >= mCapacity) {
            throw new ArrayIndexOutOfBoundsException("Capacity: " + mCapacity + "; Index: " + index);
        }
        
        return (T)(mArray[index]);
    }

    /**
     * Clear the contents of the list
     */
    @Override
    public void clear() {
        mSize = 0;
    }

    /**
     * Does the list contain this item?
     * @param t The item to look for
     * @return True if it exists in the list, false otherwise
     */
    @Override
    public boolean contains(T t) {
        for (int i = 0; i < mSize; i++) {
            if (((T)(mArray[i])).equals(t)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public boolean equals(List<T> rhs) {
        
        int i = 0;
        for (T t : rhs) {
            if (!((T)(mArray[i])).equals(t)) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (mSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public T[] toArray() {
        
        // create a copy of the internal data
        Object[] copy = new Object[mSize];
        
        System.arraycopy(mArray, 0, copy, 0, mSize);
        
        // cast and return it
        return (T[])(copy);
    }
    
    
    /* The private stuff */
    
    private void grow() {
        
        int newCapacity;
        
        if (mSize == 0) {
            newCapacity = 1;
        } else {
            newCapacity = mSize + ((mSize + 1) / 2);
        }
        
        // reallocate
        Object[] newArray = new Object[newCapacity];
        
        if (mArray != null) {
            // copy the old stuff over
            System.arraycopy(mArray, 0, newArray, 0, mArray.length);
        }
        
        // set the member variables
        mArray = newArray;
        mCapacity = newCapacity;
    }
    
    int mSize;
    int mCapacity;
    Object[] mArray;
    
    private class ArrayListIterator implements Iterator<T> {
        
        private int cursor;

        public ArrayListIterator() {
            cursor = 0;
        }
        
        @Override
        public boolean hasNext() {
            return cursor < ArrayList.this.mSize;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T)(ArrayList.this.mArray[cursor++]);
            }
            throw new NoSuchElementException();
        }
        
    }
}
