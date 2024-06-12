package DoubleLinkedList;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;


    //Create a Doubly Linked List
    public DoublyNode createDLL (int nodeValue){
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    public void insertDLL (int nodeValue, int location){
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if(head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = tail;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    public void traverseDLL() {
        if (head == null) {
            System.out.println("DLL does not exist");
            return;
        }
        DoublyNode tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.value + " <-> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }


    public void reverseTraverseDLL(){
        if(tail == null) {
            System.out.println("DLL does not exist");
            return;
        }
        DoublyNode tempNode = tail;
        while (tempNode != null) {
            System.out.print(tempNode.value + " <-> ");
            tempNode = tempNode.prev;
        }
        System.out.println("null");
    }

    public void searchNode (int nodeValue){
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.value == nodeValue){
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
    }

    public void deleteInDLL(int value) {
        if (head == null) {
            return;
        }

        if (head.value == value) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }

        DoublyNode current = head;
        while (current != null && current.value != value) {
            current = current.next;
        }

        if (current != null) {
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
            current.prev.next = current.next;
        }
    }

    public void deleteEntireDLL() {
        if (head == null) {
            System.out.println("DLL does not exist");
            return;
        }
        DoublyNode tempNode = head;
        while (tempNode != null) {
            DoublyNode nextNode = tempNode.next;
            tempNode.prev = null;
            tempNode.next = null;
            tempNode = nextNode;
        }
        head = tail = null;
    }
}
