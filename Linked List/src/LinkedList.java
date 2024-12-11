public class LinkedList {

	public Node head;

	public LinkedList() {
		this.head = null;
	}

/* Header hinzufügen:
   1. neuen Knoten erstellen mit input data
   2. derzeitigen Head-Knoten in temporärer Variable speichern
   3. neuen Header deklarieren mit neu erstellten Knoten
   4. Falls bisher Header vorhanden --> nächster Knoten des neuen Header ist bisheriger Header; 
   falls kein Header --> neuer Knoten wird einfach als neuer Header deklariert (Kontrollinstanz sorgt für "maintaining", 
   also dass der neue Header auch auf den nächsten verweißt --> anderenfalls würde der currentHead ein "orphaned node" werden) */

  public void addToHead(String data) {
    Node newHead = new Node(data);
    Node currentHead = this.head;
    this.head = newHead;
    if (currentHead != null) {
      this.head.setNextNode(currentHead);
    }
  }

  /* Tail hinzufügen:
     1. neuen Knoten erstellen und als Header deklarieren
     2. Falls Header leer (Liste = empty) --> neuer Head ist neuer Knoten mit input data
     3. Falls Header vorhanden --> solange Liste durchgehen (mit Neudeklarierung des Knoten durch den Getter in jeder Iteration)
     ,bis letzter Knoten erreicht
     4. Beim letzten Knoten angekommen, wird der nächste Knoten mit einem Setter zu dem Knoten mit der input data erklärt */
  
  public void addToTail(String data) {
    Node tail = this.head;
    if (tail == null) {
      this.head = new Node(data);
    } else {
      while (tail.getNextNode() != null) {
        tail = tail.getNextNode();
      }
        tail.setNextNode(new Node(data));
    }
  }

  /* Header entfernen:
     1. neuen Knoten erstellen und als Header deklarieren
     2. Falls Header leer (Liste = empty) --> Header bleibt leer (nichts wird zurückgegeben)
     3. Falls nicht --> Header wird umdeklariert (mit Getter) zum nächsten Knoten 
     4. String-Inhalt des gelöschten Header wird returned */
  
public String removeHead() {
  Node removedHead = this.head;
  if(removedHead == null){
    return null;
  } 
  this.head = removedHead.getNextNode();
  return removedHead.data;
}

	/* Liste drucken: 
	   1. String erstellen ("output")
	   2. Knoten erstellen und als Header deklarieren (zum durchiterieren)
	   3. Solange Knoten Inhalt hat (= vorhanden ist) --> Knoteninhalt wird zum String hinzugefügt
	   4. String wird ausgedruckt (außerhalb der Schleife) */

public String printList() {
    String output = "<head> ";
    Node currentNode = this.head;
      while(currentNode != null) {
        output += currentNode.data + " ";
        currentNode = currentNode.getNextNode();
      }
      output += "<tail>";
      System.out.println(output);
    return output;
  }


  public static void main(String []args) {
    
  }  

}