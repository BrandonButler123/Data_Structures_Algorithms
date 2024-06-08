public class Main {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertInLinkedList(1,0);
        singleLinkedList.insertInLinkedList(2,1);
        singleLinkedList.insertInLinkedList(3,2);
        singleLinkedList.insertInLinkedList(4,3);
        singleLinkedList.traverseLinkedListNew();
//        singleLinkedList.insertInLinkedList(5,1);
        singleLinkedList.searchNode(2);
        singleLinkedList.deleteInLinkedList(2);
        singleLinkedList.traverseLinkedListNew();
    }
}

//Assignment question number
//1. Uncomment line 11 "singleLinkedList.insertInLinkedList(5,1)" and investigate and fix.
    // why when inserting a value at a position that is already occupied, it throws a null pointer exception.

