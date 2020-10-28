import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.utils.*;

import sun.java2d.DestSurfaceProvider;
import sun.security.krb5.internal.crypto.Des;

public class Graph {

    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
    
    public static class Node {
        private int id;
        LinkedList<Node> adjacents = new LinkedList<Node>();
        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return this.nodeLookup.get(id);
    }

    public void addEdge(int source_id, int destination_id) {
        Node source = this.getNode(source_id);
        Node destination = this.getNode(destination_id);
        source.adjacents.add(destination);
    } 

    public boolean hasPathDFS(int source_id, int destination_id) {
        Node source = getNode(source_id);
        Node destination = getNode(destination_id);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(source, destination, visited);
    }
    
    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;
        }
        visited.add(source.id);

        if (souce == id) {
            return true;
        }

        for (Node child : source.adjacents) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPathBFS(int source_id, int destination_id) {
        Node source = this.getNode(source_id);
        Node destination = this.getNode(destination_id);
        return hasPathBFS(source, destination);
    }

    private boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node == destination) {
                return true;
            }
            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);
            for (Node child : node.adjacents) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}