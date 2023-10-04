/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment2;

/**
 *
 * @author Dell
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GenericStack<Integer> stackI=new GenericStack<>();
        
            stackI.displayStack();
        for(int i=0;i<5;i++)
        {
            stackI.push(i);
        }
        
            stackI.displayStack();
        try{
            
            System.out.println("POPPING FROM STACK");
            for(int i=0;i<6;i++)
            {
                System.out.println(" "+stackI.pop());
            }
        }
        catch(ExceptionHandling e)
        {
            System.out.println(e.getMessage());
         
        }
        //STACK FLOAT
        GenericStack<Float> stackF=new GenericStack<>();
         stackF.displayStack();
        for(int i=0;i<5;i++)
        {
            stackF.push((float)(i+34.43));
        }
        
            stackF.displayStack();
        try{
            
            System.out.println("POPPING FROM STACK");
            for(int i=0;i<6;i++)
            {
                System.out.println(" "+stackF.pop());
            }
        }
        catch(ExceptionHandling e)
        {
            System.out.println(e.getMessage());
         
        }
        
    // STACK STRING
        GenericStack<String> stackS=new GenericStack<>();
         stackS.displayStack();
        for(int i=0;i<5;i++)
        {
            stackS.push((String)("random characters"+i));
        }
        
            stackS.displayStack();
        try{
            System.out.println("POPPING FROM STACK");
            for(int i=0;i<6;i++)
            {
                System.out.println(" "+stackS.pop());
            }
        }
        catch(ExceptionHandling e)
        {
            System.out.println(e.getMessage());
        }
        
    }   
}
class ExceptionHandling extends Exception{
    public ExceptionHandling(String m)
    {
        super(m);
        System.out.println("Exception thrown:\t");
    }
}
class GenericStack<T>{

    Node<T> bottom=null;
    Node<T> top=null;
    int size=0;
    public void push(T d)
    {
        if(bottom==null)
        {
            bottom=new Node<>(d);
            top=bottom;
        }
        else
        {
            Node<T> node=new Node<>(d);
            top.next=node;
            top=node;
        }
        size++;
    }
    public int getSize()
    {
        return size;
    }
    public void displayStack()
    {
        System.out.println("PRINTING STACK");
        try{
            if(!isEmpty())
               recur(bottom);
           else
               throw new ExceptionHandling("Cannot display an empty stack"); 
        }
        catch(ExceptionHandling e)
        {
            System.out.println(e.getMessage());       
                        e.printStackTrace();

        }
    }
    public boolean isEmpty()
    {
        if(bottom==null)
            return true;
        else
            return false;
    }
    public T pop() throws ExceptionHandling
    {
        if(isEmpty())
        {
            throw new ExceptionHandling("Popping from empty stack");
        }
        if(size==1)
        {
            size--;
            Node<T> node=bottom;
            bottom=null;
            return node.data;
        }
        else{
            Node<T> node=getNewTop(bottom);
            node.next=null;
            Node<T> node2=top;
            top=node;
            size--;
            return node2.data;
        }
    }
    private Node<T> getNewTop(Node<T> node)
    {
        if(node.hasNext() && node.next==top)
        {
         return node;  
        }
       else
           return getNewTop(node.next);
    }
    private void recur(Node<T> node){
       if(node.hasNext())
       {
           recur(node.next);
           node.display();
       }
       else
           node.display();
    }
    class Node<T>{
        T data;
        Node next;
        public Node(T d)
        {
            data=d;
            next=null;    
        }
        public boolean hasNext()
        {
            if(next==null)
                return false;
            else
                return true;
        }
        public void display()
        {
            System.out.println(data+" ");
        }
    }
}