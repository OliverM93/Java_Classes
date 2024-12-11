public class Node {

  public String data;
  private Node next;

  public Node(String data) {
    this.data = data;
    this.next = null;
  }
  	// Setter/Muator Method, um nächsten Knoten zu deklarieren
  public void setNextNode(Node node) {
    this.next = node;
  }
  	// Getter/Accessor, um nächsten Knoten zu ermitteln
  public Node getNextNode() {
    return this.next;
  }

}