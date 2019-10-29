import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
   Write a program that checks whether a sequence of HTML tags
   is properly nested. For each opening tag, such as <p>, there
   must be a closing tag </p>. A tag such as <p> may have other
   tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>

   The inner tags must be closed before the outer ones.
   Your program should process a file containing tags.
   For simplicity, assume that the tags are separated by
   spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
   public static void main(String[] args)
   {
      String filename = "TagSample1.html";

      try (Scanner in = new Scanner(new File(filename)))
      {
         // Your code goes here
         String t;
         Stack stuff = new Stack();
         while (in.hasNext()) {
             t = in.next();
             if (t.charAt(0) == '<') {
                if((t.charAt(1) == '/') && stuff.peek().equals(t.substring(2,t.length()-1))) {
                     stuff.pop();
                }
                else {
                    stuff.push(t.substring(1,t.length()-1));
                }
             }
             System.out.println(stuff);
         }
         
         if (stuff.size() == 0) {
             System.out.println("balanced");
         }
         else {
             System.out.println("not balanced");
         }




      }
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot open: " + filename);
      }

   }
}
