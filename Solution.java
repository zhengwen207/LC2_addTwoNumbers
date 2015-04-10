
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next = null;
    }
}


public class Solution {

    // main function
    public static void main(String[] args){

       long A1=342;

       long A2=465;

       ListNode l1=Long2List(A1);
       ListNode l2=Long2List(A2);

       ListNode l=addTwoNumbers(l1,l2);

       printList(l1);

       printList(l2);

       printList(l);

       long C=List2Long(l);
       System.out.println("The sum of "+A1+" and "+A2+" is "+C);

    }

    // this function prints out the list
    public static void printList(ListNode l){

        ListNode p=l;

        String s="(";

        while (p!=null){

            if (p==l) s+=p.val;
            else s+=" -> "+p.val;

            p=p.next;
        }

      s+=")";

      System.out.println(s);

    }

    // this function adds two lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
         long a1=List2Long(l1);
         long a2=List2Long(l2);

         long b=a1+a2;

         return Long2List(b);
    }

    // This static function converts a list to long
    public static long List2Long(ListNode l){
        
        // sum
        long s=0;

        // digit
        int i=0;

        // pointer to the current node
        ListNode p=l;

        while (p!=null){
           s+=p.val*Math.pow(10,i);

           // update p and i
           p=p.next;
           ++i;
        }

        return s;
    }

    // this static function converts long to a list
    public static ListNode Long2List(long s){
        
        if (s==0) {
           ListNode head=new ListNode(0);
           return head;
        }
        // if s>0
        else {
           ListNode head=null;   
           ListNode pre=null;

           while (s>0)
           {
               int digit=(int)(s%10);
               
               ListNode curr=new ListNode(digit);

               // put it in the linked list
               if (pre==null) head=curr;
               else pre.next=curr;
              
               // update s
               s=(s-digit)/10;

               // update pre
               pre=curr;
           }
           return head;
        }

    }
}
