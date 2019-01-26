/**************************************************************************
*                                                                         *
*     Program Filename:  Khan2.java                                       *
*     Author          :  Sarim Khan                                       *
*     Date Written    :  February 15, 2017                                *
*     Purpose         :  To analyze monthly check transactions            *
*     Input from      :  Program2.Dat                                     *
*     Output to       :  Output.dat                                       *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class Khan2
{
private static class CheckRecord
{
   private String CheckNumber;
   private String Category;
   private float  Amount;
   private String Month;
   private int    Date;
}

public static void main(String[] args) throws IOException
{
   CheckRecord X = new CheckRecord();
   Queue<CheckRecord> Household = new Queue<CheckRecord>();
   Queue<CheckRecord> Auto = new Queue<CheckRecord>();
   Queue<CheckRecord> Grocery = new Queue<CheckRecord>();
   Queue<CheckRecord> Other = new Queue<CheckRecord>();
   CheckRecord R = new CheckRecord();
   
   float a = 0; 
   float b = 0;
   float c = 0; 
   float d = 0; 
   
   DecimalFormat GroceryF = new DecimalFormat ("0.00"); 
   DecimalFormat OtherF = new DecimalFormat ("0.00"); 

   String   FileName;
   Scanner InputFile = new Scanner(System.in);
   Scanner  Input;

   System.out.print("Please enter the name of the input file: ");
   FileName = InputFile.nextLine();
   Input = new Scanner(new File(FileName));
   
   PrintWriter OutputFile = new PrintWriter("output.dat");
   
   while(Input.hasNext())
   {
      X = new CheckRecord();
      QueueLoad(X, Input);
      if (X.Category.charAt(0) == 'H')
      {
         Household.Enqueue(X);
      }
      if (X.Category.charAt(0) == 'A')
      {
         Auto.Enqueue(X);
      }
      if (X.Category.charAt(0) == 'G')
      {
         Grocery.Enqueue(X);
      }
      if (X.Category.charAt(0) == 'O')
      {
         Other.Enqueue(X);
      }
   
   }
   
   System.out.println("Household             Auto               Grocery            Other");
   System.out.println("=========             ====               =======            =====");
   
   while (!Household.IsEmpty() || !Auto.IsEmpty() || !Grocery.IsEmpty() || !Other.IsEmpty())
   {
      if (!Household.IsEmpty())
      {
         R = Household.Dequeue();
         System.out.print(R.CheckNumber + "   " + R.Amount);
         a += R.Amount;   
      }     
      else
         System.out.print("   ");
         
      if (!Auto.IsEmpty())
      {
         R = Auto.Dequeue();
         System.out.print("          " + R.CheckNumber + "   " + R.Amount);
         b += R.Amount;
      }
      else
         System.out.print("\t\t\t         ");
      if (!Grocery.IsEmpty())
      {
         R = Grocery.Dequeue();
         System.out.print("\t " + R.CheckNumber + "   " + R.Amount);
         c += R.Amount;
      }
      else
         System.out.print("\t\t     ");
      if (!Other.IsEmpty())
      {
         R = Other.Dequeue();
         System.out.println("       " + R.CheckNumber + "   " + R.Amount);
         d += R.Amount; 
      }
      else
         System.out.println();
         
    }
    
    System.out.println("Totals for January:"); 
    System.out.println(a + "\t\t      " + b + "\t\t " + GroceryF.format(c) + "\t\t    " + OtherF.format(d));

}


public static void QueueLoad(CheckRecord X, Scanner Input) throws IOException
{
   String A , B, D;
   float  F;
   int    E;
   
   A = Input.next();
   X.CheckNumber = A;
   B = Input.next();
   X.Category = B;
   F = Input.nextFloat();
   X.Amount = F;
   D = Input.next();
   X.Month = D;
   E = Input.nextInt();
   X.Date = E;
   
   
   return;
}

         
   
}
