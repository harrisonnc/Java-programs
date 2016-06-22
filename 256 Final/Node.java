public class Node {
      int key;
      int record;
      Node nextNode;

      Node(int key, int value) {
            this.key = key;
            this.record = record;
            this.nextNode = null;
      }

      public int getRecord() {
            return record;
      }

      public void setRecord(int value) {
            this.record = value;
      }

      public int getKey() {
            return key;
      }

      public Node getNext() {
            return nextNode;
      }

      public void setNext(Node nextNode) {
            this.nextNode = nextNode;
      }
}