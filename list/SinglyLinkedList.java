//Create a SinglyLinkedList class like the above
public class SinglyLinkedList {
    public Node head;
    public Node tail;
    //Create a constructor method that sets the head to null of your SinglyLinkedList objects
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

public void add(int value){
    Node newNode = new Node(value);
    if (this.head == null) {
        this.head = newNode;
    }
    else {
        Node runner = this.head;
        while(runner.next != null){
            runner = runner.next;
        }
        runner.next = newNode;
    }
}
//Create a remove() method that will remove a node from the end of your list
public void remove() {
    if (this.head == null) {
        this.head = null;
    }
    if (head.next == null) {
        this.head = null;
    }
    Node second_last = this.head;
    while (second_last.next.next != null)
        second_last = second_last.next;

    second_last.next = null;

    
}
public void PrintValues() {
    Node second_last = this.head;
    if (this.head == null){
        System.out.println(second_last.value);

    }
    while(second_last != null) {
        System.out.println(second_last.value);
        second_last = second_last.next;

    }
    System.out.println(second_last.value);
}
}