

public class LinkedGraph{
    private int vertCount, EdgeCount;



    private class Node{
        int v; Node next;
        Node(int x, Node t){
            v = x;
            next = t;
        }
    }
    private class LinkedList implements List{
        private int vertex;
        private Node node;

        LinkedList(int v){
            this.vertex = v;
            node = null;
        }

        @Override
        public int beg() {
            // TODO Auto-generated method stub
            node = adj[vertex];

            return node == null ? -1 : node.v;
        }

        @Override
        public int nxt() {
            //
            if (node != null) node = node.next;
            return node == null ? -1 : node.v;
        }

        @Override
        public boolean end() {
            // TODO Auto-generated method stub
            return node == null;
        }
    }

    private Node[] adj;

    LinkedGraph(int V){
        vertCount = V;

    }

    public int getVertCount() {
        return vertCount;
    }

    public int getEdgeCount() {
        return EdgeCount;
    }



    public List getList(int vertices){
        return new LinkedList(vertices);
    }




    }