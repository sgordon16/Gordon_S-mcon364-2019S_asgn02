import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VertexMETA {
	
	private int d;
	private boolean colored = false;
	private VertexMETA prev;
	private String id;

	private Map<VertexMETA, Integer> edges = new HashMap<VertexMETA, Integer>();
	
	public VertexMETA(String id, Map<VertexMETA, Integer> edges) {
		this.id = id;
		this.edges = edges;
	}
	
	public VertexMETA(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public void addEdges(VertexMETA v, int w) {
		edges.put(v, w);
	}
	
	public Map<VertexMETA, Integer> getEdgesMap() {
		return edges;
	}
	
	public Set<VertexMETA> getEdgesSet() {
		return edges.keySet();
	}
	
	public void setD(int d) {
		this.d = d;
	}
	
	public int getD() {
		return d;
	}
	
	public void setPrev(VertexMETA v) {
		this.prev = v;
	}
	
	public VertexMETA getPrev() {
		return prev;
	}

	public void setColored(boolean b) {
		colored = b;
	}
	
	public boolean getColored() {
		return colored;
	}
	public boolean equals(VertexMETA v) {
		return this.id == v.getID();
	}
}
