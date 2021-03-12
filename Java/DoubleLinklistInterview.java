/*You’re given a Doubly Linked List. Write a function to merge two adjacent nodes in the linked list. Make sure you validate the input and check for error conditions.


input: (A <-> B <-> C <-> D <-> E , C , D)

output: A <-> B <-> F <-> E


class Node {
    Node prev
    Node next
    String value
}

input: (A <-> B <-> C <-> D <-> E  <->C , A , B)
*/
//B <-> A 
// A,B -> "AB"

Node mergeNodes(Node head, Node A, Node B){
    if(head == null || head.next == null){
        return;
    }
    Node dummy = new Node("dummy");
    dummy.next = head;
    Node point = head;
    
    while(point != null){
        if(point.val == A.val){
            if(point.next != null && point.next.val == B.val){
                merge(point, A.val + B.val, dummy);   
            }
        }else if(point.val == B.val){
            if(point.next != null && point.next.val == A.val){
                merge(point, A.val + B.val, dummy);
            }
        }
        point = point.next;
    }
    
    return dummy.next;
}
void merge(Node point, String newVal, Node dummy){
    Node newNode = new Node(newVal);
    Node rear = point.next.next;
    if(point.prev != null){
        Node tmp = point.prev;
        tmp.next = newNode;
        newNode.prev = tmp;
    }
    else{
        dummy.next = newNode;
        newNode.prev = dummy;
    }
    
    newNode.next = rear;
    rear.prev = newNode;
}