class CSLList<T> {
  class Node {
    // Each Node object has these two fields
    private T element;
    private Node next;

    // Constructor: Creates a Node object with element = e and next = n
    Node(T e, Node n) {
      element = e;
      next = n;
    }

    // This function gets T e as input and sets e as the element of the Node
    public void setElement(T e) {
      element = e;
    }

    // This function returns the element variable of the Node
    public T getElement() {
      return element;
    }

    // This function gets Node n as input and sets the next variable of the current Node object as n.
    public void setNext(Node n) {
      next = n;
    }

    // This function returns the next Node
    public Node getNext() {
      return next;
    }
  }

  // Each object in CSLList has one field tail, which points to the tail Node of CSLList.
  private Node tail;

  /**
   * Constructor: initialises the tail field as null
   */
  public CSLList() {
    tail = null;
  }

  /**
   * @return The element in the first Node of this CSLL. If the list is empty, this method returns null.
   */
  public T getFirst() {
    if (tail == null)
      return null;
    return tail.getNext().getElement();
  }

  /**
   * @return The element in the last Node of this CSLL. If the list is empty, this method returns null.
   */
  public T getLast() {
    if (tail == null)
      return null;
    return tail.getElement();
  }

  /**
   * Adds element e in a new Node to the head of the list.
   *
   * @param e
   *     The element to add.
   */
  public void addFirst(T e) {
    if(tail == null) {
      tail = new Node(e,null);
      tail.next = tail;
      return;
    }
    Node temp = tail.next;
    Node newNode = new Node(e,temp);
    tail.next = newNode;
    
  }

  /**
   * Adds element e in a new Node to the tail of the list.
   *
   * @param e
   *     The element to add.
   */
  public void addLast(T e) {
    if(tail == null){
      tail = new Node(e,null);
      tail.next = tail;
      return;
    }
    Node temp = tail;
    tail = new Node(e,temp.next);
    temp.next = tail;
  }

  /**
   * Remove the first Node in the list and return its element.
   *
   * @return The element of the first Node. If the list is empty, this method returns null.
   */
  public T removeFirst() {
    if (tail == null) {
      return null;
    } else if (tail.next == tail) {
      Node temp = tail;
      tail = null;
      
      return temp.getElement();
    }
    Node temp = tail.next;
    Node nextNode = temp.next;
    tail.next = nextNode;
    return temp.getElement();
    
  }

  /**
   * Rotates the list such that the second element in the list will become the first element in the list.
   * Example: rotating the list [1, 2, 3] will become [2, 3, 1].
   */
  public void rotate() {
    if (tail == null ) {
      return;
    }
    tail = tail.next;
  } 

  /**
   * Merges this list and the other list by alternating elements from the two lists.
   * If one of the lists is longer than the other, the remaining elements are added to the end of the resulting list.
   *
   * @param other
   *     The other list to alternate elements with. Is treated as an empty list if it is null.
   * @return A new list with alternated elements of this list and the other list.
   */
  public CSLList<T> alternate(CSLList<T> other) {
    if (other == null){
      return this;
    }
    CSLList<T> a = new CSLList<T>();
    
    while(getFirst()!= null && other.getFirst()!= null) {
      a.addLast(removeFirst());
      a.addLast(other.removeFirst());
    }
    while(getFirst()!= null){
      a.addLast(removeFirst());
    }
    while(other.getFirst()!= null){
      a.addLast(other.removeFirst());
    }
    return a;
  }

  /**
   * Removes all elements at the odd positions in this list.
   * Note that the head of the list is element number 0, which is an even position.
   */
  public void dropOdd() {
    int index = 0;
    CSLList<T> a = new CSLList<T>();
    while(getFirst()!=null){
      if (index % 2 == 0) {
        a.addLast(removeFirst());
        index++;
        continue;
      }
      removeFirst();
      index++;
    }
    while(a.getFirst()!= null) {
      addLast(a.removeFirst());
    }
  }
}


