package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//  represents a weighted undirected graph

public class Graph {
	Vertex[] adjLists; // array of all vertices in the graph

	public Graph(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));

		// read number of vertices
		adjLists = new Vertex[sc.nextInt()];

		// read vertex names & create vertices
		for (int v = 0; v < adjLists.length; v++) {
			adjLists[v] = new Vertex(sc.next(), null);
		}

		// read edges
		while (sc.hasNext()) {
			// read vertex names and translate to vertex numbers
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			int weight = sc.nextInt();

			// add v2 to front of v1's adjacency list and
			// add v1 to front of v2's adjacency list
			adjLists[v1].adjList = new AdjacencyNode(v2, adjLists[v1].adjList, weight);
			adjLists[v2].adjList = new AdjacencyNode(v1, adjLists[v2].adjList, weight);
		}
		sc.close();
	}

	int indexForName(String name) {
		for (int v = 0; v < adjLists.length; v++) {
			if (adjLists[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}

	// returns the number of vertices in the graph
	public int numberOfVertices() {
		return adjLists.length;
	}

	// print a summary of the graph
	public void summarize() {
		for (int j = 0; j < numberOfVertices(); j++) {
			Vertex vj = adjLists[j];
			System.out.print(vj.name + ": ");
			for (AdjacencyNode e = vj.adjList; e != null; e = e.next) {
				System.out.print(adjLists[e.vertexNum].name + " " + e.weight + ",  ");
			}
			System.out.println();
		}
	}

	public int shortestPath(String nameFrom, String nameTo) {
		

		SPRecord[] record = new SPRecord[adjLists.length];

		int startIndex = indexForName(nameFrom);
		int endIndex = indexForName(nameTo);
		
		if(startIndex == endIndex){
			
			return 0;
		}

		record[startIndex] = new SPRecord(true, 0, 0);

		// first linked list item for vertex
		AdjacencyNode temp = adjLists[startIndex].adjList;

		int minDistance = temp.weight;
		int minIndex = temp.vertexNum;

		int fringe = 0;

		while (temp != null) {

			int index = temp.vertexNum;

			record[index] = new SPRecord(false, temp.weight, temp.weight);

			fringe++;

			temp = temp.next;

		}
		int prevIndex = 0;

		while (fringe != 0) {

			int[] distances = new int[fringe];
			int[] index = new int[fringe];
			int arrayCount = fringe;

			// Scans the fringe for distances and throws them in an array

			for (int i = 0; i < record.length; i++) {

				if (record[i] == null) {

					continue;
				}

				if (record[i].inTree == false) {

					distances[arrayCount - 1] = record[i].distance;
					index[arrayCount - 1] = i;
					arrayCount--;
				}

			}

			// gets minDistance

			if (distances.length == 1) {
				minDistance = distances[0];
				minIndex = index[0];

			} else {

				for (int r = 1; r < distances.length; r++) {

					if (distances[r] <= distances[r - 1]) {

						minDistance = distances[r];

						minIndex = index[r];

					} else {
						minDistance = distances[r - 1];

						minIndex = index[r - 1];

					}

				}

			}

			// updates the tree, remove element from fringe

			prevIndex = minIndex;
			record[minIndex].inTree = true;
			fringe--;

			// update the fringe

			AdjacencyNode nextNode = adjLists[minIndex].adjList;

			while (nextNode != null) {

				int nodeIndex = nextNode.vertexNum;

				if (record[nodeIndex] != null) {

					if (record[nodeIndex].inTree == false) {
						int newDistance = nextNode.weight + minDistance;

						if (record[nodeIndex].distance > newDistance) {
							
							//update distance
							record[nodeIndex].distance = newDistance;
							
							//update link
							record[nodeIndex].link = nextNode.weight;
						}

					}
					nextNode = nextNode.next;
					continue;

				} else {
					
					//insert into the fringe
					record[nodeIndex] = new SPRecord(false, nextNode.weight, nextNode.weight + minDistance);

					fringe++;

				}

			}

		}
		
		for(int i=0; i<record.length; i++){
			
			System.out.println(record[i]);
			
		}

		return record[endIndex].distance - record[startIndex].distance;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Graph g = new Graph("graph.txt");
		g.summarize();
		System.out.println(g.shortestPath("Alex", "Taylor"));
	}
}