
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class Main {
   Node head = null;
   Node tail = null;

   public Main1() {
   }

   public Node insertEnd(int var1) {
      Node var2 = new Node(var1);
      if (this.head == null) {
         this.head = var2;
         this.tail = var2;
         this.tail.next = this.head;
      } else {
         this.tail.next = var2;
         var2.next = this.head;
         this.tail = var2;
      }

      return this.head;
   }

   public void display(Node var1) {
      if (var1 == null) {
         System.out.println("There are no elements in the Linked List");
      } else {
         System.out.print(var1.data + " -> ");

         for(Node var2 = var1.next; var2 != var1; var2 = var2.next) {
            System.out.print(var2.data + " -> ");
         }

         System.out.println("null");
      }

   }

   public Node insertBegin(int var1) {
      Node var2 = new Node(var1);
      if (this.head == null) {
         this.head = var2;
         this.tail = var2;
      } else {
         Node var3 = this.head;
         var2.next = var3;
         this.tail.next = var2;
         this.head = var2;
      }

      return this.head;
   }

   public Node insertSpecificPos(int var1, int var2) {
      Node var3 = new Node(var1);
      int var4 = 2;
      if (var2 == 1 && this.head == null) {
         this.head = var3;
         this.tail = var3;
      } else if (var2 == 1) {
         var3.next = this.head;
         this.tail.next = var3;
         this.head = var3;
      } else {
         Node var5;
         for(var5 = this.head.next; var5 != this.head; var5 = var5.next) {
            ++var4;
            if (var4 == var2) {
               var3.next = var5.next;
               var5.next = var3;
               break;
            }
         }

         if (var5 == this.head && var4 == var2) {
            this.head = var3;
            this.tail = var3;
            this.tail.next = this.head;
         } else if (var4 < var2) {
            System.out.println("Enter the position within the range");
         }
      }

      return this.head;
   }

   public Node deleteFirst() {
      if (this.head == null) {
         System.out.println("No elements to delete");
      } else {
         this.tail.next = this.head.next;
         this.head = this.head.next;
      }

      return this.head;
   }

   public Node deleteLast() {
      if (this.head == null) {
         System.out.println("No elements to delete");
      } else if (this.head == this.tail) {
         this.head = null;
         this.tail = null;
      } else if (this.head.next.next == this.head) {
         this.tail = this.head;
         this.head.next = null;
      } else {
         Node var1;
         for(var1 = this.head; var1.next.next != this.head; var1 = var1.next) {
         }

         var1.next = this.head;
         this.tail = var1;
      }

      return this.head;
   }

   public static void main(String[] var0) {
      Main1 var1 = new Main1();
      Scanner var2 = new Scanner(System.in);
      System.out.print("Enter the Number Elements to Insert : ");
      int var3 = var2.nextInt();

      for(int var4 = 0; var4 < var3; ++var4) {
         System.out.print("Enter the element to insert : ");
         int var5 = var2.nextInt();
         var1.insertEnd(var5);
      }

      var1.display(var1.head);
      var1.insertBegin(6789);
      var1.display(var1.head);
      var1.insertEnd(789);
      var1.display(var1.head);
      var1.insertSpecificPos(1111, 3);
      var1.display(var1.head);
      var1.deleteFirst();
      var1.display(var1.head);
      var1.deleteLast();
      var1.display(var1.head);
   }
}
