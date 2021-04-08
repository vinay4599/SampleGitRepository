package maven16.maven16;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HaspMapTable {

	public static void main(String args[]) 
    { 
        //----------hashtable ------------------------- 
     
        Hashtable<Integer,String> ht=new Hashtable<Integer,String>(); 
        ht.put(101," Santhosh"); 
        ht.put(101,"Sreedar"); 
        ht.put(102,"Devaki"); 
        ht.put(103,"Ganesh"); 
        System.out.println("Hashtable list:"); 
        for (Map.Entry m:ht.entrySet()) { 
            System.out.println(m.getKey()+" "+m.getValue()); 
        } 
  
        //----------------hashmap-------------------------------- 
        HashMap<Integer,String> hm=new HashMap<Integer,String>(); 
        hm.put(100,"Santhosh"); 
        hm.put(104,"Vinay");   
        hm.put(101,"Sreedhar"); 
        hm.put(102,"Harini"); 
        System.out.println("HashMap list:"); 
        for (Map.Entry m:hm.entrySet()) { 
            System.out.println(m.getKey()+" "+m.getValue()); 
        } 

}
}