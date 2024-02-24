import java.util.Scanner;
class Node{
    Node prev;
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }

}
public class StackImplementationUsingLinkedList {
    static int maxCapacityStack,size;
    Node head,top,tail,prevNode;
    void push(){
        if(!isFullStack()) {
            System.out.print("Enter The data : ");
            Scanner scan = new Scanner(System.in);
            int data = scan.nextInt();
            Node node = new Node(data);
            if(size==0) {
                head = node;
                node.prev = null;
            }
            else {
                prevNode.next=node;
                node.prev = prevNode;
            }
            node.next=null;
            prevNode=node;
            top = node;
            tail = node;
            size++;
            System.out.println(data + " is pushed to stack");
        }
    }
    void display(){
        Node temp=head;
        if(!isEmpty()) {
            System.out.println("The Output is given :");
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    void pop(){
        if(!isEmpty()) {
            int data =top.data;
            top = tail.prev;
            tail = tail.prev;
            System.out.println(data + " is popped from stack");
            size--;
        }
    }
    static boolean isFullStack(){
        if(size==maxCapacityStack){
            System.out.println("Stack is Full");
            return true;
        }
        return false;
    }
    static boolean isEmpty(){
        if(size==0) {
            System.out.println("Stack is Empty");
            return true;
        }
        return false;
    }
    int peek(){
        return top.data;
    }

    public static void main(String[] args) {
        StackImplementationUsingLinkedList obj=new StackImplementationUsingLinkedList();
        System.out.print("Enter The Maximum Capacity of Stack : ");
        Scanner scan=new Scanner(System.in);
        maxCapacityStack=scan.nextInt();
        int flag=0;
        while(true) {
            if (flag == 1)
                break;
            System.out.println("You have Following Choices.");
            System.out.println("1.    Push\n2.    Display \n3.    Pop\n4.    Peek\n5.    Exit");
            System.out.print("Enter The Choice :  ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    obj.push();
                    break;
                case 2: obj.display();
                        break;
                case 3:
                    obj.pop();
                    break;
                case 4:
                    int data=obj.peek();
                    System.out.println("The Peek value is : "+data);
                    break;
                case 5:
                    flag = 1;
                    break;
                default:
                    System.out.println("You have Entered Wrong choice");
            }
        }
    }
}