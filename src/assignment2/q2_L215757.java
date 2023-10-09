/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class q2_L215757 {
    public static void main(String[] a)
    {
        FirstNonRepeatingStream f=new FirstNonRepeatingStream();
       
        Scanner scan=new Scanner(System.in);
         String c=scan.nextLine();
       
        while(!c.isEmpty())
        {
            f.add(c.charAt(0));
            c=scan.nextLine();
        }
        System.out.println("first nonrepeating char is : "+f.getFirstNonRepeating());
    }
}
class FirstNonRepeatingStream{
    LinkedHashSet<Character> list;
    HashSet<Character> repeated;
    public FirstNonRepeatingStream()
    {
        repeated=new HashSet<>();
        list=new LinkedHashSet<>();
    }
    public void add(char a)
    {
        if(list.contains(a))
        {
            list.remove(a);
            repeated.add(a);
        }
        else
        {   
            if(!repeated.contains(a))
            list.add(a);
        }
        //System.out.println(list);
        //System.out.println(repeated);
    }
    public char getFirstNonRepeating()
    {
        if(list.isEmpty())
            return '-';
        else{
            Iterator<Character> it = list.iterator();
            return it.next();
        }
    }
}
