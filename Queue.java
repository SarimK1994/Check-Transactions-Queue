import java.util.ArrayList;

public class Queue<QueueItem>
{
   private ArrayList<QueueItem> Q;

   public Queue()
   {
      Q = new ArrayList<QueueItem>();
   }
   // end constructor

   public void Enqueue(QueueItem QI)
   {
      Q.add(QI);
   }
   // end public method Enqueue

   public QueueItem Dequeue()
   {
      QueueItem QI;

      if (Q.size() == 0)
      {
         System.out.println("Queue Underflow!");
         System.exit(0);
      }
      // end if

      QI = Q.remove(0);

      return QI;
   }
   // end public method Dequeue

   public void MakeEmpty()
   {
      Q.clear();
   }
   // end public method MakeEmpty

   public boolean IsEmpty()
   {
      if (Q.isEmpty())
         return true;
      else
         return false;
      // end if
   }
   // end public method IsEmpty

   public int LengthQueue()
   {
      return Q.size();
   }
   // end public method LengthQueue

}
// end class Stack
