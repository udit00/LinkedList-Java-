class SinglyNode<T>{
    T data;
    SinglyNode<T> next;
}
class SinglyLinkedList<T>{
    SinglyNode<T> head, tail;

    /* Default Constructor */
    SinglyLinkedList(){
        head = null;
        tail = null;
    }

    /* Copy Constructor */
    SinglyLinkedList(SinglyLinkedList<T> object){
        this.head = object.head;
        this.tail = object.tail;
    }

    /* O(1) since it adds the element at the End */
    public void add(T data){
        var newNode = new SinglyNode<T>();
        newNode.data = data;

        /* There are some elements in the list already */
        if(head != null) {
            tail.next = newNode;
        }

        /* List is empty, so add the element at the head */
        else{
            head = newNode;
        }
        tail = newNode;
    }

    /* O(N) || Big O of N */
    public void removeWithIndex(Integer index){

        /* This function takes an integer (1 based Indexing) and traverse the list until
           we arrive @ the node that is right behind the node to delete. We just have to
           make sure that the traverse node just does go past the node to delete or even
           at it, so that we can delete it. [ That is the only way to delete the link
           when it's a singly Linked List, since we don't have a prev link to go back ] */

        if(index < 1){
            System.out.println("Invalid index ( '"+index+"' ).\n[Note: Index to delete must be in 1 based indexing.]");
        }
        else {
            SinglyNode<T> traversal = head;
            if (index == 1) {
                System.out.println("Removed ( '" + traversal.data + "' )");
                head = traversal.next;
            } else {
                for (int i = 2; i < index && traversal.next != null; i++) {
                    traversal = traversal.next;
                }

                /* Element entered is not the last */
                if(traversal.next!=null) {
                    System.out.println("Removed ( '" + traversal.next.data + "' )");
                    if (traversal.next.next == null) {
                        traversal.next = null;
                        tail = traversal;
                    } else {
                        traversal.next = traversal.next.next;
                    }
                }

                /*  If the traversal is @ the last element that means the index entered is > size
                   of the list. */
                else{
                    System.out.println("Invalid index ( '"+index+"' )." +
                            "\n[Value entered was greater than the size of the actual list.]");
                }
            }
        }
    }

    /* O(N) || Big O of N */
    public void removeWithElement(T elementToDelete){
        SinglyNode<T> traversal = head;

        /* if the element to delete is the head */
        if(traversal.data == elementToDelete){
            head = traversal.next;
            traversal.next = null;
        }else {
            while (traversal.next != null && traversal.next.data != elementToDelete) {
                traversal = traversal.next;
            }
            if (traversal.next == null && traversal.data != elementToDelete) {
                System.out.println("Element not found ( " + elementToDelete + " )");
            } else if (traversal.next != null && traversal.next.next != null) {
                traversal.next = traversal.next.next;
            } else if (traversal.next.next == null) {
                traversal.next = null;
                tail = traversal;
            } else {
                System.out.println("Element not found ( " + elementToDelete + " )");
            }
        }
    }

    /* O(N) || Big O of N */
    public void printList(){
        SinglyNode<T> traverse = head;
        while (traverse != null) {
            System.out.print(traverse.data+ " ");
            traverse = traverse.next;
        }
        System.out.println("-> Null");
    }
    public void reverseListIterative(){
        SinglyNode<T> prev = null;
        SinglyNode<T> current = head;
        SinglyNode<T> temp = null;

        tail = current;

        while(current!=null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        head = prev;
    }
    public SinglyNode<T> reverseListRecursive(SinglyNode<T> head){
        if(head == null || head.next == null)
            return head;
        SinglyNode<T> newHead = reverseListRecursive(head.next);  // this return the newHead
        tail = head;
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
