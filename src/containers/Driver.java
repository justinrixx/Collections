package containers;

import java.util.Iterator;

/**
 *
 * @author justin
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // instantiate an ArrayList
        LinkedList<Integer> list = new LinkedList();
        
        
        // add some stuff to the list
        list.add(1);
        list.add(2);
        list.add(3);
        
        System.out.println("Size: " + list.size());
        
        Iterator it = list.iterator();
        
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        
        for (Integer i : list) {
            System.out.println(i);
        }
        
        list.clear();
        
        
        System.out.println("Clear.\nSize: " + list.size());
        
        list.add(3);
        list.add(2);
        list.add(1);
        
        System.out.println("Size: " + list.size());
        
        for (Integer i : list) {
            System.out.println(i);
        }
    }
    
}
