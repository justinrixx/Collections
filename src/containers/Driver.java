/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        ArrayList<Integer> list = new ArrayList();
        
        
        // add some stuff to the list
        list.add(1);
        list.add(2);
        list.add(3);
        
        Iterator it = list.iterator();
        
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        
        for (Integer i : list) {
            System.out.println(i);
        }
        
        list.clear();
        
        list.add(3);
        list.add(2);
        list.add(1);
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
}
