package DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertDLL(1,0);
        doublyLinkedList.insertDLL(2,1);
        doublyLinkedList.insertDLL(3,2);
        doublyLinkedList.insertDLL(4,3);
        doublyLinkedList.insertDLL(5,4);
        doublyLinkedList.insertDLL(6,5);
        doublyLinkedList.insertDLL(7,6);
        doublyLinkedList.insertDLL(8,7);


        doublyLinkedList.traverseDLL();
        doublyLinkedList.reverseTraverseDLL();
        doublyLinkedList.searchNode(1);
        doublyLinkedList.deleteInDLL(2);
        doublyLinkedList.reverseTraverseDLL();
        doublyLinkedList.deleteEntireDLL();
        doublyLinkedList.traverseDLL();

    }
}
