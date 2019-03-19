import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Program {
	
	static HashMap<String, VertexMETA> graph;

	public static void main(String[] args) {
		
		
		PriorityQueue<VertexMETA> queue = new PriorityQueue<VertexMETA>(new dValueComparator());
		graph = new HashMap<String, VertexMETA>();
		String idV = null;
		String idU;
		VertexMETA startingVertex;
		int weight;
		VertexMETA v;
		VertexMETA u = null;
		VertexMETA currVertex = null;
		Scanner kb = new Scanner(System.in);
		String[] input = null;
		char responseA = 0;
		char responseB = 0;
		int counter1 = 1;
		int counter2 = 1;
		
		while(responseA != 'q') {
			System.out.println("Enter name of Vertex" + counter1);
			idV = kb.nextLine();
			if(graph.containsKey(idV)) 
				v = graph.get(idV);
			else {
				v = new VertexMETA(idV);
				graph.put(idV, v);
			}
				
			while(responseB != 'q') {
				System.out.println("Enter name of adjacent vertex" + counter2 + " followed by the weight seperated by a space");
				input = kb.nextLine().split(" ");
				idU = input[0];
				weight = Integer.parseInt(input[1]);
				if(graph.containsKey(idU)) 
					u = graph.get(idU);
				else {
					u = new VertexMETA(idU);
					graph.put(idU, u);
				}	
				graph.get(idV).addEdges(u, weight);
				System.out.println("Enter 'q' if you are finished adding adjacent verticies or any other key to add more");
				responseB = kb.nextLine().charAt(0);
				counter2++;
			}
			counter2 = 1;
			responseB = 0;
			counter1++;
			System.out.println("Enter 'q' if you are finished adding verticies or any other key to add more");
			responseA = kb.nextLine().charAt(0);
		}
		System.out.println("Enter name of starting vertex");
		startingVertex = graph.get(kb.nextLine());
		System.out.println("\n\nFinding shortest path.....\n\n");
		for(VertexMETA vm : graph.values())
			vm.setD(Integer.MAX_VALUE);
		startingVertex.setD(0);
		startingVertex.setColored(true);
		queue.add(startingVertex);
		
		while(!queue.isEmpty()) {
			currVertex = queue.remove();
			for(VertexMETA vm : currVertex.getEdgesMap().keySet()) {
				if(!vm.getColored()) {
					int d = vm.getD();
					vm.setColored(true);
	     			vm.setD(Math.min(d, currVertex.getD() + currVertex.getEdgesMap().get(vm)));
	     			vm.setPrev(currVertex);
	     			queue.add(vm);
				}
			}
		}
		for(VertexMETA vm : graph.values()) {
			String id = vm.getID();
			VertexMETA vertex = vm;
			VertexMETA finalVertex = vm;
			Stack<String> stack = new Stack<String>();
			while(id != startingVertex.getID()) {
				stack.add(id);
				vertex = vertex.getPrev();
				id = vertex.getID();
			}
			int size = stack.size();
			System.out.println("Total weight from " + startingVertex.getID() + " to " + finalVertex.getID() + " is: " + finalVertex.getD());
			System.out.print("PATH: " + startingVertex.getID());
			for(int i = 0; i < size; i++) 
				System.out.print(" - " + stack.pop());
			
			System.out.println();
		}
	}
}
