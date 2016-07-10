package datastructures.graph;

import datastructures.imports.Bag;
import datastructures.imports.StdIn;
import datastructures.linkedlist.LinkedList;

/**
 * Created by mm on 3/3/16.
 */
public class Graph {
    int vertex ;
    Bag<Integer>[] adjList;
    public Graph(int noOfvertex){
        vertex = noOfvertex;
        adjList = (Bag<Integer>[]) new Bag[vertex];
        for (int i = 0; i < vertex; i++) {
            adjList[i] = new Bag<Integer>();
        }
    }
    public Graph(StdIn in){

    }
    public void addEdge(int v, int w){
        if ((v < vertex) && (w < vertex)){
            adjList[v].add(w);
            adjList[w].add(v);
        }
    }
    public boolean isEdge(int v , int w){
        if ((v < vertex) && (w < vertex)) {
            for (int edge : adjList[v]) {
                if (edge == w) return true;
            }
        }
        return false;
    }
    public int V(){
        return vertex;
    }
    public int E(){
        return 0;
    }
    public Iterable<Integer> adj(int v){
        return null;
    }
}
