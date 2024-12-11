
public class SwappingNodes {

}
public static void swapNodes(LinkedList list, int data1, int data2) {
	
    System.out.println("Swapping " + data1 + " with " + data2);
  
    Node node1Prev = null;
    Node node2Prev = null;
    Node node1 = list.head;
    Node node2 = list.head;

    if (data1 == data2) {
      System.out.println("Elements are the same - no swap to be made");
      return;
    }
    		//in der Node-Class muss der Parameter im Constructor zu int statt String umgeschrieben werden, damit der Code läuft
    while (node1 != null) {
      if (node1.data == data1) { 
        break;
      }
      node1Prev = node1;
      node1 = node1.getNextNode();
    }
  
    while (node2 != null) {
      if (node2.data == data2) {
        break;
      }
      node2Prev = node2;
      node2 = node2.getNextNode();
    }
  
    if (node1 == null || node2 == null) {
      System.out.println("Swap not possible - one or more element is not in the list");
      return;
    }

    if (node1Prev == null) {
      list.head = node2;
    } else {
      node1Prev.setNextNode(node2);
    }

    if (node2Prev == null) { 
      list.head = node1;
    } else {
      node2Prev.setNextNode(node1);
    }
  
    Node temp = node1.getNextNode();
    node1.setNextNode(node2.getNextNode());
    node2.setNextNode(temp); 
  }