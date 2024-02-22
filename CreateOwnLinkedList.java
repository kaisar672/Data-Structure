import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class CreateOwnLinkedList{
    static int size;
    static boolean flagListCreated;
    Node createList(){
        System.out.print("Enter the Number of nodes You want To create : ");
        Scanner scan=new Scanner(System.in);
        size=scan.nextInt();
        Node head=null;
        Node prevNode=null;
        for (int i=0;i<size;i++){
            System.out.print("Enter The data : ");
            Node currNode=new Node(scan.nextInt());
            //prevNode=currNode;
            if(i==0) {
                head = currNode;
                prevNode = head;
            }
            else {
                prevNode.next = currNode;
                currNode.next = null;
                prevNode = currNode;
            }
        }
        System.out.println(size+" nodes have been created.");
        System.out.println("********************************");
        return head;
    }
    Node insertNodeAnywhere(Node head){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter The Location from 1 to "+(size+1)+" including("+(size+1)+") : ");
        int location=scan.nextInt();
        System.out.print("Enter The Data :  ");
        Node currNode=new Node(scan.nextInt());
        int i=1;
        if(location==1){
            currNode.next=head;
            head=currNode;
            System.out.println("Inserted");
        }
        else if(location==size+1){
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=currNode;
        }
        else if(location>1 && location<=size){
            Node temp=head;
            while(i<location-1) {
                temp = temp.next;
                i++;
            }
            currNode.next=temp.next;
            temp.next=currNode;
        }
        else
            System.out.println("You have not Entered valid Location");
        System.out.println("Node is Inserted At Location : "+location);
        System.out.println("******************************");
        size++;
        return head;
    }
    void display(Node temp){
        System.out.println("The Output is :");
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
        System.out.println("***********************");
    }
    void displayTotalNodes(){
        System.out.println("Total Nodes Are : "+size);
    }
    boolean searchElement(Node head,int key){
        Node temp=head;
        while(temp!=null){
            if(temp.data==key)
                return true;
            temp=temp.next;
        }
        return false;
    }
    boolean checkListCreated(){
        if(size==0) {
            System.out.println("You have not created the list Yet");
            System.out.println("Create the List First");
            System.out.println("***********************************");
            return false;
        }
        return true;
    }
    Node deleteNodeAnyWhere(Node head,int nodeNumber){
        Node temp=head;
        Node prev=temp;
        int i=0;
        for(i=0;i<nodeNumber-1;i++){
            prev=temp;
            temp=temp.next;
        }
        if(nodeNumber!=1)
            prev.next=temp.next;
        else if(nodeNumber==1) {
            head = temp.next;
            prev.next=null;
        }
        size--;
        System.out.println("Node Number "+nodeNumber+" is deleted");
        System.out.println("*****************************************");
        return head;
    }
    int sumData(Node head){
        Node temp=head;
        int sum=0;
        while(temp!=null){
            sum=sum+temp.data;
            temp=temp.next;
        }
        return sum;
    }
    public static void main(String[] args){
        CreateOwnLinkedList obj=new CreateOwnLinkedList();
        Scanner scan=new Scanner(System.in);
        int flag=0;
        Node head=null;
        while(true){
            if(flag==1)
                break;
            obj.displayTotalNodes();
            System.out.println("Your Available Choices Are :");
            System.out.println("    1.Create LinkedList.\n    2.Display List.\n    3.Insert Node AnyWhere.\n    4.Search The Element\n    5.Delete The Node\n    6.Add The data Elements\n    7.Exit.");
            System.out.println("***************************");
            System.out.print("Enter the choice : ");
            int choice=scan.nextInt();
            switch(choice){
                case 1: if(size==0) {
                            head = obj.createList();
                            flagListCreated=true;
                        }
                        else if (size>0){
                            System.out.println("You have Already Created The List.");
                            System.out.println("Do Other Operations : ");
                            System.out.println("**********************************");

                        }
                        break;
                case 2:  boolean value=obj.checkListCreated();
                        if(value)
                            obj.display(head);
                        break;
                case 3: value=obj.checkListCreated();
                        if(value)
                            head=obj.insertNodeAnywhere(head);
                        break;
                case 4: value=obj.checkListCreated();
                        if(value) {
                            int keyElement = scan.nextInt();
                            boolean result= obj.searchElement(head,keyElement);
                            if(result)
                                System.out.println("Element is Found");
                            else
                                System.out.println("Element is Not Found");
                        }
                        break;
                case 5: if(!flagListCreated) {
                            System.out.println("All Nodes have been deleted.\nTo use Delete option. First Create The List Again.");
                            break;
                        }
                        value=obj.checkListCreated();
                        if(value) {
                            System.out.print("Enter The Node Number from 1 to "+size+". Which You want to Delete : ");
                            int nodeNumber=scan.nextInt();
                            head = obj.deleteNodeAnyWhere(head,nodeNumber);
                            if(flagListCreated && size==0)
                                flagListCreated=false;
                        }
                        break;
                case 6: value=obj.checkListCreated();
                        if(value) {
                            int sum = obj.sumData(head);
                            System.out.println("The Sum of Elements are  : " + sum);
                        }
                        break;
                case 7: flag=1;
                        break;
                default: System.out.println("You have Entered wrong Choice");
            }
        }
    }
}