import java.util.Comparator;

public class dValueComparator implements Comparator<VertexMETA> {

	@Override
	public int compare(VertexMETA v1, VertexMETA v2) {
		// TODO Auto-generated method stub
		return v1.getD() - v2.getD();
	}

}
