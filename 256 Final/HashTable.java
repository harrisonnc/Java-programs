public class HashTable {

     private final static int defaultSize = 128;

      //creates a bucket array to hold the hashtable
      Node[] bucket;

      HashTable() {
            bucket = new Node[defaultSize];
            for (int i = 0; i < defaultSize; i++)
                  bucket[i] = null;
      }

      public int get(int key) {
            int hash = (key % defaultSize);
            if (bucket[hash] == null)
                  return -1;
            else {
                  Node entry = bucket[hash];
                  while (entry != null && entry.getKey() != key)
                        entry = entry.getNext();
                  if (entry == null)
                        return -1;
                  else
                        return entry.getRecord();
            }
      }

      public void put(int key, int record) {
            int hash = (key % defaultSize);
            if (bucket[hash] == null)
                  bucket[hash] = new Node(key, record);
            else {
                  Node entry = bucket[hash];
                  while (entry.getNext() != null && entry.getKey() != key)
                        entry = entry.getNext();
                  if (entry.getKey() == key)
                        entry.setRecord(record);
                  else
                        entry.setNext(new Node(key, record));
            }
      }


}