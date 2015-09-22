package containers;

import java.util.Iterator;

/**
 *
 * @author justin
 * @param <T> The type being put in the list
 */
public interface List<T> extends Iterable<T> {
    
    // add an item to the list
    public void add(T t);
    
    // empty the list
    public void clear();
    
    // search the list
    public boolean contains(T t);
    
    // check for equality
    public boolean equals(List<T> rhs);
    
    // is the list empty?
    public boolean isEmpty();
    
    // get an iterator
    public Iterator<T> iterator();
   
    // how big is the list?
    public int size();
    
    public T[] toArray();
}
