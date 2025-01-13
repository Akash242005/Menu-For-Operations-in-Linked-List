import java.util.*;
class Node{
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}

public class  Main1 {
    Node head = null;
    Node tail = null;
    public Node insertEnd(int data)
        {
            Node node = new Node(data);
            if(head==null)
            {
                head=node;
                tail=node;
                tail.next = head;
            }
            else
            {
                tail.next = node;
                node.next = head;
                tail = node;
            }
            return head;
        }
    public void display(Node head)
        {
            if(head==null)
            {
                System.out.println("There are no elements in the Linked List");
            }
            else
            {
                Node temp = head;
                System.out.print(temp.data+" -> ");
                temp = temp.next;
                while(temp!=head)
                {
                    System.out.print(temp.data+" -> ");
                    temp = temp.next;
                }
                System.out.println("null");
            }
        }
    public Node insertBegin(int data)
    {
        Node temp = new Node(data);
        if(head==null)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            Node temp1 = head;
            temp.next = temp1;
            tail.next = temp;
            head = temp;
        }
        return head;
    }
    public Node insertSpecificPos(int data,int pos)
    {
        Node temp = new Node(data);
        int count = 2;
        if(pos==1 && head==null)
        {
            head = temp;
            tail = temp;
        }
        else if(pos==1)
        {
            temp.next = head;
            tail.next = temp;
            head = temp;
        }
        else
        {
            Node temp1 = head.next;
            while(temp1!=head)
            {
                count++;
                if(count==pos)
                {
                    temp.next = temp1.next;
                    temp1.next=temp;
                    break;
                }
                temp1 = temp1.next;
            }
            if(temp1==head && count==pos)
            {
                head = temp;
                tail= temp;
                tail.next = head;
            }
            else if(count<pos)
            {
                System.out.println("Enter the position within the range");
            }
        }
        return head;
    }
    public Node deleteFirst()
    {
        if(head==null)
        {
            System.out.println("No elements to delete");
        }
        else
        {
            tail.next = head.next;
            head = head.next;
        }
        return head;
    }
    public Node deleteLast()
    {
        if(head==null)
        {
            System.out.println("No elements to delete");
        }
        else if(head==tail)
        {
            head = null;
            tail = null;
        }
        else if(head.next.next==head)
        {
            tail = head;
            head.next = null;
        }
        else
        {
            Node temp = head;
            while(temp.next.next!=head)
            {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
        return head;
    }
    public Node deleteByPos(int pos)
    {
        if(head==null)
        {
            System.out.println("There are no elements to delete");
        }
        return head;
    }
        public static void main(String[] args) {
            Main1 circle = new Main1();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Number Elements to Insert : ");
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
            {
                System.out.print("Enter the element to insert : ");
                int num = sc.nextInt();
                circle.insertEnd(num);
            }
            circle.display(circle.head);
            circle.insertBegin(6789);
            circle.display(circle.head);
            circle.insertEnd(789);
            circle.display(circle.head);
            circle.insertSpecificPos(1111, 3);
            circle.display(circle.head);
            circle.deleteFirst();
            circle.display(circle.head);
            circle.deleteLast();
            circle.display(circle.head);
    }
}
