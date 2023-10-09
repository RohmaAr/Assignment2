/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class q3_l215757 {
    public static void main(String[] ar)
    {
        List<int[]> list=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        System.out.println("How many intervals would you like to enter?");
        int in=scan.nextInt();
        for(int i=0;i<in;i++){
            int[] arr=new int[2];
            list.add(arr);
        }
        System.out.println("Enter upper and lower limits of intervals:");
        for(int i=0;i<list.size();i++)
        {
            System.out.println("Lower :");
            int u=scan.nextInt();
            System.out.println("Upper :");
            int l=scan.nextInt();
            list.get(i)[0]=u;
            list.get(i)[1]=l;
        }
        mergeIntervals(list);
        System.out.println("Printing merged list:");
        for(int i=0;i<list.size();i++)
        {
            System.out.println("{"+list.get(i)[0]+","+list.get(i)[1]+"]");
        }
        
    }
    public static void mergeIntervals(List<int[]> list)
    {
        for(int i=0;i<list.size();i++)
        {
            int j=i+1;
            if(j<list.size())
            {
                if(list.get(i)[1]==(list.get(j)[0]-1))
                {
                    list.get(i)[1]=list.get(j)[1];
                    list.remove(j);
                    i--;
                }
            }
        }
    }
}
