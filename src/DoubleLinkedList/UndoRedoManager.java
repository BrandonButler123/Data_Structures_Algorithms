package DoubleLinkedList;

// Undo/Redo functionality: In applications that support undo/redo functionality, a doubly linked list can be used to
// maintain a sequence of states. Ech state change is stored as a node in the list, allowing easy navigation between previous and
// next states, enabling undoing and redoing of actions.
// 1<>2<>3<>4<>5

public class UndoRedoManager<T> {
    private class Node{
        private T state;
        private Node prev;
        private Node next;
        private Node (T state){
            this.state = state;
        }
    }

    private Node currentState;
    public T undo(){
        if (currentState == null) {
            System.out.println("No state to undo");
            return null;
        }
        // Get the previous state
        Node previousState = currentState.prev;
        if (previousState == null) {
            System.out.println("Reached the initial state");
            return null;
        } else {
            // update the current state to the previous state
            currentState = previousState;
        }
        return currentState.state;
    }

    public T redo(){
        if (currentState == null) {
            System.out.println("No state to redo");
            return null;
        }
        Node nextState = currentState.next;
        if (nextState == null) {
            System.out.println("Reached the final state");
        } else {
            currentState = nextState;;
        }
        return currentState.state;
    }

    public void performAction (T newState) {
        // create a new node for the new task
        Node newNode = new Node(newState);

        // set the links for the new node
        newNode.prev = currentState;
        newNode.next = null;

        //update the next link for the current state
        if (currentState != null) {
            currentState.next = newNode;
        }
        // update the current to the new state
        currentState = newNode;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();
        undoRedoManager.performAction("state 1");
        undoRedoManager.performAction("state 2");
        undoRedoManager.performAction("state 3");
        undoRedoManager.performAction("state 4");
        undoRedoManager.performAction("state 5");

        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);

    }
}
